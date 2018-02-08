package com.newstar.hbms.utils.file;

import com.aspose.pdf.DocSaveOptions;
import com.aspose.pdf.SaveOptions;
import com.aspose.words.IImageSavingCallback;
import com.aspose.words.ImageSavingArgs;

import java.io.*;

/**
 * Created by fellowlong on 2017/6/7.
 */
public abstract class FileUtils {

    static {
        try {
            com.aspose.pdf.License pdfLicense = new com.aspose.pdf.License();
            pdfLicense.setLicense(FileUtils.class.getClassLoader().getResourceAsStream("pdf-converter.xml"));
            com.aspose.cells.License excelLicense = new com.aspose.cells.License();
            excelLicense.setLicense(FileUtils.class.getClassLoader().getResourceAsStream("excel-converter.xml"));
        } catch (Exception e) {
            throw new RuntimeException("无效的授权文件", e);
        }
    }

    public static void convert(InputStream sourceInputStream, final String targetFile, FileType sourceFileType, FileType targetFileType) {
        Object pdfSaveOptions = -1;
        Object wordSaveOptions = -1;
        Object excelSaveOptions = -1;
        Object imageSavingCallback = null;
        if (targetFileType.equals(FileType.doc) || targetFileType.equals(FileType.docx)) {
            com.aspose.pdf.DocSaveOptions docSaveOptionsByPdf = new com.aspose.pdf.DocSaveOptions();
            docSaveOptionsByPdf.setFormat(com.aspose.pdf.SaveFormat.DocX);
            pdfSaveOptions = docSaveOptionsByPdf;
            //不支持  DOC、DOCX、XLS、XLSX转PPT、PPTX
        } else if (targetFileType.equals(FileType.ppt) || targetFileType.equals(FileType.pptx)) {
            com.aspose.pdf.PptxSaveOptions pptxSaveOptions = new com.aspose.pdf.PptxSaveOptions();
            pdfSaveOptions = pptxSaveOptions;
            //不支持  DOC、DOCX、XLS、XLSX转PPT、PPTX
        } else if (targetFileType.equals(FileType.xls) || targetFileType.equals(FileType.xlsx)) {
            com.aspose.pdf.ExcelSaveOptions excelSaveOptionsByPdf = new com.aspose.pdf.ExcelSaveOptions();
            pdfSaveOptions = excelSaveOptionsByPdf;
            //不支持  DOC、DOCX、XLS、XLSX转XLS、XLSX
        } else if (targetFileType.equals(FileType.txt) || targetFileType.equals(FileType.text)) {
            com.aspose.pdf.LaTeXSaveOptions textSaveOptionsByPdf = new com.aspose.pdf.LaTeXSaveOptions();
            pdfSaveOptions = textSaveOptionsByPdf;

            com.aspose.words.TxtSaveOptions txtSaveOptionsByDoc = new com.aspose.words.TxtSaveOptions();
            txtSaveOptionsByDoc.setSaveFormat(com.aspose.words.SaveFormat.TEXT);
            wordSaveOptions = txtSaveOptionsByDoc;

            com.aspose.cells.TxtSaveOptions txtSaveOptionsByExcel =new com.aspose.cells.TxtSaveOptions();
            txtSaveOptionsByExcel.setEncoding(com.aspose.cells.Encoding.getUTF8());
            excelSaveOptions = txtSaveOptionsByExcel;

        } else if (targetFileType.equals(FileType.html)) {

            com.aspose.pdf.HtmlSaveOptions htmlSaveOptionsByPdf = new com.aspose.pdf.HtmlSaveOptions(com.aspose.pdf.SaveFormat.Html);
            pdfSaveOptions = htmlSaveOptionsByPdf;

            com.aspose.words.HtmlSaveOptions htmlSaveOptionsByDoc = new com.aspose.words.HtmlSaveOptions(com.aspose.words.SaveFormat.HTML);
            htmlSaveOptionsByDoc.setImageSavingCallback(new IImageSavingCallback() {

                int index = 1;

                @Override
                public void imageSaving(ImageSavingArgs imageSavingArgs) throws Exception {
                    String targetShortFileName = targetFile.substring((targetFile.lastIndexOf("/") > -1 ? targetFile.lastIndexOf("/") : targetFile.lastIndexOf("\\")) + 1, targetFile.lastIndexOf("."));
                    String imageShortName = targetShortFileName + "-"  + index++ +"." + imageSavingArgs.getImageFileName().substring(imageSavingArgs.getImageFileName().lastIndexOf(".") + 1);
                    String imageFullPathName = targetFile.substring(0, targetFile.lastIndexOf("/") + 1) + imageShortName;
                    imageSavingArgs.setImageFileName(imageShortName);
                    imageSavingArgs.setImageStream(new FileOutputStream(imageFullPathName));
                    imageSavingArgs.setKeepImageStreamOpen(false);
                }
            });
            htmlSaveOptionsByDoc.setSaveFormat(com.aspose.words.SaveFormat.HTML);
            wordSaveOptions = htmlSaveOptionsByDoc;

            com.aspose.cells.HtmlSaveOptions htmlSaveOptionsByExcel =new com.aspose.cells.HtmlSaveOptions(com.aspose.cells.SaveFormat.HTML);
            excelSaveOptions = htmlSaveOptionsByExcel;

        } else if (targetFileType.equals(FileType.pdf)) {
            com.aspose.words.PdfSaveOptions pdfSaveOptionsByDoc = new com.aspose.words.PdfSaveOptions();
            pdfSaveOptionsByDoc.setSaveFormat(com.aspose.words.SaveFormat.PDF);
            wordSaveOptions = pdfSaveOptionsByDoc;

            com.aspose.cells.XlsSaveOptions pdfSaveOptionsByExcel =new com.aspose.cells.XlsSaveOptions(com.aspose.cells.SaveFormat.PDF);
            excelSaveOptions = pdfSaveOptionsByExcel;
            //不支持PDF转PDF
        } else {
            throw new RuntimeException("不能识别的类型:" + targetFileType);
        }
        try {
            if (sourceFileType.equals(FileType.pdf)) {
                com.aspose.pdf.Document doc = new com.aspose.pdf.Document(sourceInputStream);
                doc.save(targetFile, (SaveOptions) pdfSaveOptions);
                doc.freeMemory();
                doc.close();
            } else if (sourceFileType.equals(FileType.doc) || sourceFileType.equals(FileType.docx)) {
                com.aspose.words.Document doc = new com.aspose.words.Document(sourceInputStream);
                doc.save(targetFile, (com.aspose.words.SaveOptions) wordSaveOptions);
            } else if (sourceFileType.equals(FileType.xls) || sourceFileType.equals(FileType.xlsx)) {
                com.aspose.cells.Workbook doc = new com.aspose.cells.Workbook(sourceInputStream);
                doc.save(targetFile, (com.aspose.cells.SaveOptions) excelSaveOptions);
            } else {
                throw new RuntimeException("不支持的源文件格式:" + sourceFileType);
            }
        } catch (Exception e) {
            throw new RuntimeException("转换文件失败:", e);
        }
    }

    public static String getText(InputStream sourceInputStream, FileType sourceFileType) {
        String text = null;
        try {
            if (sourceFileType.equals(FileType.pdf)) {
                com.aspose.pdf.Document doc = new com.aspose.pdf.Document(sourceInputStream);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                doc.save(outputStream, com.aspose.pdf.SaveFormat.TeX);
                doc.freeMemory();
                doc.close();
                text = outputStream.toString();
            } else if (sourceFileType.equals(FileType.doc) || sourceFileType.equals(FileType.docx)) {
                com.aspose.words.Document doc = new com.aspose.words.Document(sourceInputStream);
                text = doc.toString(com.aspose.words.SaveFormat.TEXT);
            } else if (sourceFileType.equals(FileType.xls) || sourceFileType.equals(FileType.xlsx)) {
                com.aspose.cells.Workbook doc = new com.aspose.cells.Workbook(sourceInputStream);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                doc.save(outputStream, com.aspose.cells.SaveFormat.CSV);
                text = outputStream.toString();
            } else {
                throw new RuntimeException("不支持的源文件格式:" + sourceFileType);
            }
        } catch (Exception e) {
            throw new RuntimeException("转换文件失败:", e);
        }
        return text;
    }

    public static byte[] readToBytes(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            return bytes;
        } catch (IOException e) {
            throw new RuntimeException("读取数据量出错");
        }
    }



}

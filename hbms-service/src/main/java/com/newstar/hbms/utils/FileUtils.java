package com.newstar.hbms.utils;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.newstar.hbms.common.Constants;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardDecryptionMaterial;
import org.apache.pdfbox.util.PDFText2HTML;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.*;
import java.util.Date;
import java.util.Random;

/**
 * Created by fellowlong on 2014-09-26.
 */
public abstract class FileUtils {

  public enum FileType {
    doc, docx, xls, xlsx, ppt, pptx, pdf, html, txt
  }

  private static final String separator = "{#%&}";

  public static String encodeFileName(String originalFileName, Date currentDate) {
    String date = DateUtils.dateFormat(currentDate, Constants.DATE_PATTERN_FOR_FILE);
    String fileNameNoExtend = originalFileName.substring(0, originalFileName.lastIndexOf("."));
    String fileExtendName = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
    long random = new Random(System.currentTimeMillis()).nextInt();
    return date + separator + fileNameNoExtend + separator + random + "." + fileExtendName;
  }

  public static String decodeFileName(String encodedFileName) {
    String fileNameNoExtend = encodedFileName.substring(
        encodedFileName.indexOf(separator) + separator.length(),
        encodedFileName.indexOf(separator, encodedFileName.indexOf(separator) + 1));
    String fileExtendName = encodedFileName.substring(encodedFileName.lastIndexOf(".") + 1);
    return fileNameNoExtend + "." + fileExtendName;
  }

  public static String getText(String filePath) {
    String fileName = new File(filePath).getName();
    String extendFileName = fileName.substring(fileName.lastIndexOf(".") + 1);
    FileType fileType = null;
    try {
      fileType = FileType.valueOf(extendFileName.toLowerCase());
    } catch (Exception e) {
      throw new RuntimeException("不支持的文件类型", e);
    }
    String targetFilePath = null;
    try {
      File tempFile = File.createTempFile("hbms", "hbms");
      targetFilePath = tempFile.getAbsolutePath();
      tempFile.delete();
    } catch (IOException e) {
      throw new RuntimeException("转换文件时创建临时文件失败", e);
    }
    targetFilePath += ".pdf";
    String result = null;
    try {
      boolean saveAsResult = false;
      InputStream textInputStream = null;
      if (FileType.doc.equals(fileType) || FileType.docx.equals(fileType)) {
        saveAsResult = wordSaveAs(filePath, targetFilePath, FileType.pdf);
      } else if (FileType.xls.equals(fileType) || FileType.xlsx.equals(fileType)) {
        saveAsResult = excelSaveAs(filePath, targetFilePath, FileType.pdf);
      } else if (FileType.ppt.equals(fileType) || FileType.pptx.equals(fileType)) {
        saveAsResult = pptSaveAs(filePath, targetFilePath, FileType.pdf);
      } else {
        throw new RuntimeException("不支持的文件类型");
      }
      if (saveAsResult) {
        try {
          byte[] textBytes = pdfConvert(new FileInputStream(targetFilePath), FileType.txt, null);
          textInputStream = new ByteArrayInputStream(textBytes);
        } catch (FileNotFoundException e) {
          throw new RuntimeException("读取转换后的文件失败", e);
        }
      }
      try {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int length = 0;
        byte[] buffer = new byte[1024];
        while ((length = textInputStream.read(buffer, 0, buffer.length)) > 0) {
          outputStream.write(buffer, 0, length);
        }
        textInputStream.close();
        outputStream.flush();
        outputStream.close();
        if (outputStream.size() > 0) {
          result = outputStream.toString();
        }
      } catch (IOException e) {
        throw new RuntimeException("读取转换后的文件失败", e);
      }
    } finally {
      if (targetFilePath != null) {
        File pdfFile = new File(targetFilePath);
        if (pdfFile.exists()) {
          //pdfFile.delete();
        }
      }
    }
    return result;
  }

  public static boolean wordSaveAs(String sourceFilePath, String targetFilePath, FileType targetFileType) {
    ComThread.InitSTA();
    boolean result = false;
    ActiveXComponent component = new ActiveXComponent("Word.Application");
    try {
      component.setProperty("Visible", new Variant(false));
      Dispatch documents = component.getProperty("Documents").toDispatch();
      Dispatch document = Dispatch.invoke(
          documents, "Open", 1, new Object[]{sourceFilePath, new Variant(false), new Variant(true)}, new int[1])
          .toDispatch();
      int targetFileFormat = -1;
      if (targetFileType.equals(FileType.txt)) {
        targetFileFormat = 7;
      } else if (targetFileType.equals(FileType.html)) {
        targetFileFormat = 8;
      } else if (targetFileType.equals(FileType.pdf)) {
        targetFileFormat = 17;
      } else {
        throw new RuntimeException("暂不支持Word转换成格式：" + targetFileType);
      }
      Dispatch.invoke(document, "SaveAs", 1, new Object[]{targetFilePath, new Variant(targetFileFormat)}, new int[1]);
      Dispatch.call(document, "Close", new Variant(false));
      result = true;
    } catch (Exception e) {
      throw new RuntimeException(
          "Word转换成格式：" + targetFileType + "出错, source=" + sourceFilePath + ", target=" + targetFilePath, e);
    } finally {
      component.invoke("Quit", new Variant[0]);
      ComThread.Release();
      ComThread.quitMainSTA();
    }
    return result;
  }

  public static boolean excelSaveAs(String sourceFilePath, String targetFilePath, FileType targetFileType) {
    ComThread.InitSTA();
    boolean result = false;
    ActiveXComponent component = new ActiveXComponent("Excel.Application");
    try {
      component.setProperty("Visible", new Variant(false));
      Dispatch workbooks = component.getProperty("Workbooks").toDispatch();
      Dispatch workbook = Dispatch.invoke(
          workbooks, "Open", 1, new Object[]{sourceFilePath, new Variant(false), new Variant(true)}, new int[1])
          .toDispatch();
      if (targetFileType.equals(FileType.txt) || targetFileType.equals(FileType.html)) {
        int targetFileFormat = targetFileType.equals(FileType.txt) ? 42 : 44;
        Dispatch.invoke(workbook, "SaveAs", 1, new Object[]{targetFilePath, new Variant(targetFileFormat)}, new int[1]);
      } else if (targetFileType.equals(FileType.pdf)) {
        Dispatch.invoke(workbook, "ExportAsFixedFormat", 1, new Object[]{new Variant(0), targetFilePath}, new int[1]);
      } else {
        throw new RuntimeException("暂不支持Word转换成格式：" + targetFileType);
      }
      Dispatch.call(workbook, "Close", new Variant(false));
      result = true;
    } catch (Exception e) {
      throw new RuntimeException(
          "Excel转换成格式：" + targetFileType + "出错, source=" + sourceFilePath + ", target=" + targetFilePath, e);
    } finally {
      component.invoke("Quit", new Variant[0]);
      ComThread.Release();
      ComThread.quitMainSTA();
    }
    return result;
  }

  public static boolean pptSaveAs(String sourceFilePath, String targetFilePath, FileType targetFileType) {
    ComThread.InitSTA();
    boolean result = false;
    int targetFileFormat = -1;
    if (targetFileType.equals(FileType.html)) {
      targetFileFormat = 12;
    } else if (targetFileType.equals(FileType.pdf)) {
      targetFileFormat = 32;
    } else {
      throw new RuntimeException("暂不支持Word转换成格式：" + targetFileType);
    }
    ActiveXComponent component = new ActiveXComponent("PowerPoint.Application");
    try {
      Dispatch presentations = component.getProperty("Presentations").toDispatch();
      Dispatch presentation = Dispatch.call(
          presentations, "Open", sourceFilePath, new Variant(-1), new Variant(-1), new Variant(0))
          .toDispatch();
      Dispatch.call(presentation, "SaveAs", targetFilePath, new Variant(targetFileFormat));
      Dispatch.call(presentation, "Close");

      result = true;
    } catch (Exception e) {
      throw new RuntimeException(
          "PPT转换成格式：" + targetFileType + "出错, source=" + sourceFilePath + ", target=" + targetFilePath, e);
    } finally {
      component.invoke("Quit", new Variant[0]);
      ComThread.Release();
      ComThread.quitMainSTA();
    }
    return result;
  }

  public static byte[] pdfConvert(InputStream inputStream, FileType targetFileType, String password) {
    PDDocument document = null;
    try {
      document = PDDocument.load(inputStream, true);
    } catch (IOException e) {
      throw new RuntimeException("加载PDF文件失败", e);
    }
    if (document.isEncrypted()) {
      try {
        document.openProtection(new StandardDecryptionMaterial(password));
      } catch (Exception e) {
        throw new RuntimeException("打开有密码的PDF文件失败", e);
      }
    }
    AccessPermission ap = document.getCurrentAccessPermission();
    if (!ap.canExtractContent()) {
      throw new RuntimeException("无权打开此PDF");
    }
    byte[] result = null;
    if (targetFileType.equals(FileType.txt)) {
      try {
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setForceParsing(true);
        String text = stripper.getText(document);
        if (text != null) {
          result = text.getBytes();
        }
      } catch (Exception e) {
        throw new RuntimeException("获取PDF文本出错", e);
      }
    } else if (targetFileType.equals(FileType.html)) {
      try {
        PDFText2HTML pdfText2HTML = new PDFText2HTML("utf-8");
        pdfText2HTML.setForceParsing(true);
        String html = pdfText2HTML.getText(document);
        if (html != null) {
          result = html.getBytes();
        }
      } catch (Exception e) {
        throw new RuntimeException("PDF转HTML出错", e);
      }
    } else {
      throw new RuntimeException("暂不支持pdf转换成txt和html外的其他格式：" + targetFileType);
    }
    return result;
  }

  public static void main(String[] args) {

  }

}

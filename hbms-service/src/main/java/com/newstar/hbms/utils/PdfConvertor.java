package com.newstar.hbms.utils;

import org.apache.pdfbox.ExtractText;
import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.BadSecurityHandlerException;
import org.apache.pdfbox.pdmodel.encryption.StandardDecryptionMaterial;
import org.apache.pdfbox.util.PDFText2HTML;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by fellowlong on 2016/2/10.
 */
public class PdfConvertor {

  public static void main(String[] args) throws IOException, CryptographyException, BadSecurityHandlerException {
    PDDocument document = PDDocument.load(new FileInputStream("c:/test/王海啸（高级iOS软件工程师）.pdf"), true);
    if (document.isEncrypted()) {
      StandardDecryptionMaterial sdm = new StandardDecryptionMaterial("");
      document.openProtection(sdm);
    }

    AccessPermission ap = document.getCurrentAccessPermission();
    if (!ap.canExtractContent()) {
      throw new IOException("You do not have permission to extract text");
    }
    PDFTextStripper stripper = new PDFTextStripper();
    stripper.setForceParsing(true);
    System.out.println(stripper.getText(document));
//    stripper.setStartPage(2);
//    stripper.setEndPage(3);
    FileWriter fileWriter = new FileWriter("C:/test/王海啸（高级iOS软件工程师）.txt", false);
    stripper.writeText(document, fileWriter);
    fileWriter.flush();
    fileWriter.close();

    PDFText2HTML pdfText2HTML = new PDFText2HTML("utf-8");
    pdfText2HTML.setForceParsing(true);
    System.out.println(pdfText2HTML.getText(document));
    FileWriter fileWriterHtml = new FileWriter("C:/test/王海啸（高级iOS软件工程师）.html", false);
    pdfText2HTML.writeText(document, fileWriterHtml);
    fileWriterHtml.flush();
    fileWriterHtml.close();
  }

}

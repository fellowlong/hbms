package com.newstar.hbms.utils;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlException;

import java.io.*;

/**
 * Created by fellowlong on 2014/10/3.
 */
public abstract class WordParser {

  public static enum Version {
    DOC_97TO2003,
    DOCX_2007ABOVE;
  }

  public static String getText(InputStream inputStream) {
    String text = null;
    Document doc = null;
    try {
      doc = new Document(inputStream);
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      doc.save(os, SaveFormat.TEXT);
      text = os.toString();
    } catch (Exception e) {
      throw new RuntimeException("解析文件异常", e);
    }
    return text;
  }

  public static Version getVersion(String fileName) {
    Version version = null;
    if (fileName == null) {
      version = null;
    } else if (fileName.toLowerCase().endsWith(".doc")){
      version = Version.DOC_97TO2003;
    } else if (fileName.toLowerCase().endsWith(".docx")){
      version = Version.DOCX_2007ABOVE;
    }
    return version;
  }
}

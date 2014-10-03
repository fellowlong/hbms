package com.companyname.hbms.utils;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by fellowlong on 2014/10/3.
 */
public abstract class WordParser {

  public static final String VERSION_97TO2003 = "doc";

  public static final String VERSION_2007ABOVE = "docx";

  public static String getText(InputStream inputStream, String version) {
    String text = null;
    try {
      if (version.equals(VERSION_97TO2003)) {
        WordExtractor extractor = new WordExtractor(inputStream);
        text = extractor.getText();
      } else if (version.equals(VERSION_2007ABOVE)) {
        POIXMLTextExtractor extractor = new XWPFWordExtractor(new XWPFDocument(inputStream));
        text = extractor.getText();
      } else {
        throw new Exception("不能识别的Word版本" + version);
      }
    } catch (Throwable t) {
      throw new RuntimeException("从word中解析文件出错", t);
    }
    return text;
  }
}

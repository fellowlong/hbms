package utils;

import com.companyname.hbms.utils.WordParser;
import junit.framework.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by fellowlong on 2014/10/3.
 */
public class WordParserTest extends TestCase {

  public void testParse() throws FileNotFoundException {
    String text = WordParser.getText(new FileInputStream(new File("c:\\cd\\陈佳简历20110628.期望从北京回重庆.doc")), WordParser.Version.DOC_97TO2003);
    System.out.println(text);
    System.out.println("\n\n\n\n\n\n");
    text = WordParser.getText(new FileInputStream(new File("c:\\cd\\邱笛.docx")), WordParser.Version.DOCX_2007ABOVE);
    System.out.println(text);
  }

}

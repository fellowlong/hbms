package aspose;

import com.aspose.words.*;
import junit.framework.TestCase;

import javax.print.attribute.AttributeSet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

/**
 * Created by wangjinsi on 17-2-10.
 */
public class WordTest extends TestCase {

  public void testParseWord() {
    try {
      ByteArrayOutputStream os = new ByteArrayOutputStream(5000);
      Document doc = new Document("/home/wangjinsi/桌面/田野.rtf");
//      doc.save(os, SaveFormat.TEXT);
      doc.save("/home/wangjinsi/桌面/田野.html", SaveFormat.HTML);
      System.out.println(os.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

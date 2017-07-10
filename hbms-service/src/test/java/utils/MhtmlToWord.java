package utils;

import junit.framework.TestCase;
import com.jacob.com.*;
import com.jacob.activeX.*;

import java.io.File;

/**
 * Created by wangjinsi on 2017/7/11.
 */
public class MhtmlToWord extends TestCase {

    public void testConvert() {
        String wordDir = "G:\\简历\\1002676487@qq.com委托2017-03-01后入库\\word\\";
        File[] files = new File("G:\\简历\\1002676487@qq.com委托2017-03-01后入库\\").listFiles();
        for (File f : files) {
            if (f.getName().endsWith(".mhtml")) {
                String sourceFile = f.getAbsolutePath();
                String targetFile = wordDir + f.getName().replace("mhtml", "docx");
                ActiveXComponent component = new ActiveXComponent("Word.Application");
                try {
                    component.setProperty("Visible", new Variant(false));
                    Dispatch documents = component.getProperty("Documents").toDispatch();
                    Dispatch document = Dispatch.invoke(
                            documents, "Open", 1, new Object[]{sourceFile, new Variant(false), new Variant(true)}, new int[1])
                            .toDispatch();
                    Dispatch.invoke(document, "SaveAs", 1, new Object[]{targetFile, new Variant(16)}, new int[1]);
                    Dispatch.call(document, "Close", new Variant(false));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    component.invoke("Quit", new Variant[0]);
                    ComThread.Release();
                    ComThread.quitMainSTA();
                }
            }
        }

    }

}

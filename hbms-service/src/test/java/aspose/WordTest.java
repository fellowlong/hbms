package aspose;

import com.aspose.pdf.*;
import com.aspose.words.*;
import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import com.newstar.hbms.utils.file.FileType;
import com.newstar.hbms.utils.file.FileUtils;
import junit.framework.TestCase;

import javax.print.attribute.AttributeSet;
import java.io.*;
import java.util.Iterator;

/**
 * Created by wangjinsi on 17-2-10.
 */
public class WordTest extends TestCase {
    public void testParseWord() throws Exception {
        File resumeDir = new File("E:\\OfficeFiles\\newstar\\测试简历\\");
        File[] resumes = resumeDir.listFiles();
        for (File resume : resumes) {
            if (resume.isDirectory()) continue;
            try {
                FileUtils.convert(
                        new FileInputStream(resume),
                        "E:\\OfficeFiles\\newstar\\测试简历\\html\\" + resume.getName() + ".html",
                        FileType.getFileType(resume.getName()),
                        FileType.html);
            } catch (Exception e) {
                System.out.println(resume.getName());
                e.printStackTrace();
            }
        }
    }

}

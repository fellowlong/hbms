package com.newstar.hbms.util;

import com.newstar.hbms.utils.FileUtils;
import junit.framework.TestCase;

/**
 * Created by wangjinsi on 2016/2/12.
 */
public class FileUtilsTest extends TestCase {

  public void testWordGetText() {
    System.out.println(FileUtils.getText("c:/test/吴奇的简历.doc"));
  }
  public void testExcelGetText() {
    System.out.println(FileUtils.getText("c:/test/jimdb集群收集模板-运营研发部-王进思.xlsx"));
  }
  public void testPPtGetText() {
    System.out.println(FileUtils.getText("c:/test/晋升T4级别述职报告【王进思】V2.pptx"));
  }
}

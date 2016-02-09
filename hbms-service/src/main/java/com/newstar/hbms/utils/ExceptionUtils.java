package com.newstar.hbms.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: fellowlong
 * Date: 8/28/12
 * Time: 11:32 AM
 */
public abstract class ExceptionUtils {

    public static String getExceptionStack(Throwable t)  {
        if (t == null) {
          return null;
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter(os);
        try {
          t.printStackTrace(printWriter);
          printWriter.close();
          os.close();
        } catch (IOException e) {
          throw new RuntimeException("获取异常堆栈信息失败", e);
        }
        return os.toString();
    }

}

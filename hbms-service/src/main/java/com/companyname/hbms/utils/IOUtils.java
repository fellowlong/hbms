package com.companyname.hbms.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by fellowlong on 2014-09-26.
 */
public abstract class IOUtils {

  public static void copy(InputStream in, OutputStream out) throws IOException {
    byte[] pool = new byte[1024];
    int length = 0;
    while ((length = in.read(pool, 0, pool.length)) > 0) {
      out.write(pool, 0, length);
    }
  }

}

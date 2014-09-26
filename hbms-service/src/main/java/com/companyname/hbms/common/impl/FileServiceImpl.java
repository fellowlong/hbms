package com.companyname.hbms.common.impl;

import com.companyname.hbms.common.FileService;
import com.companyname.hbms.utils.IOUtils;

import java.io.*;

/**
 * Created by fellowlong on 2014-09-26.
 */
public class FileServiceImpl implements FileService {

  private String prefix;

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  @Override
  public void save(InputStream inputStream, String uri) throws IOException {
    File file = new File(prefix + uri);
    OutputStream out = new FileOutputStream(file);
    IOUtils.copy(inputStream, out);
    out.flush();
    out.close();
  }

  @Override
  public InputStream get(String uri) throws IOException {
    return new FileInputStream(prefix + uri);
  }

}

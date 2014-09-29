package com.companyname.hbms.common.service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by fellowlong on 2014-09-26.
 */
public interface FileService {

  public void save(InputStream inputStream, String uri) throws IOException;

  public InputStream get(String uri) throws IOException;

}

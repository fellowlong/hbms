package com.newstar.hbms.utils;

import com.newstar.hbms.common.Constants;

import java.util.Date;
import java.util.Random;

/**
 * Created by fellowlong on 2014-09-26.
 */
public abstract class FileUtils {

  private static final String separator = "{#%&}";

  public static String  encodeFileName(String originalFileName, Date currentDate) {
    String date = DateUtils.dateFormat(currentDate, Constants.DATE_PATTERN_FOR_FILE) ;
    String fileNameNoExtend = originalFileName.substring(0, originalFileName.lastIndexOf("."));
    String fileExtendName = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
    long random = new Random(System.currentTimeMillis()).nextInt();
    return date + separator + fileNameNoExtend + separator + random + "." + fileExtendName;
  }

  public static String  decodeFileName(String encodedFileName) {
    String fileNameNoExtend = encodedFileName.substring(
      encodedFileName.indexOf(separator) + separator.length(),
      encodedFileName.indexOf(separator, encodedFileName.indexOf(separator) + 1));
    String fileExtendName = encodedFileName.substring(encodedFileName.lastIndexOf(".") + 1);
    return fileNameNoExtend + "." + fileExtendName;
  }

}

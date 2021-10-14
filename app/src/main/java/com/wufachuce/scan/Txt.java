package com.wufachuce.scan;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Txt {
  private static boolean DEBUG;
  
  private static Context context;
  
  private static File currentLogFile;
  
  private static String currntTime;
  
  private static String deviceId;
  
  private static boolean isSave;
  
  public static File logDir;
  
  private static String md5Code;
  
  private static boolean productionMode;
  
  public static String secretKey;
  
  private static StringBuffer stringBuffer;

  public static void createFile(Context paramContext) {
    context = paramContext;
    logDir = CacheManager.getCacheFile(paramContext, "logs");
    if (!logDir.exists())
      logDir.mkdir();
    if (currentLogFile == null || !currentLogFile.exists() || !currentLogFile.isFile()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getDateStr2());
      stringBuilder.append(".txt");
      currentLogFile = new File(logDir, stringBuilder.toString());
      boolean exists = currentLogFile.exists();
      try {
        currentLogFile.createNewFile();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
    } 
  }
  
  public static String getDateStr2() {
    return (new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA)).format(new Date(System.currentTimeMillis()));
  }
  
  public static void save2File(String paramString) {
    writeText2File(currentLogFile.getAbsolutePath(), paramString);
  }
  
  public static void writeText2File(String paramString1, String paramString2) {
    try {
      FileWriter fileWriter = new FileWriter(paramString1, true);
      fileWriter.write(paramString2);
      fileWriter.write("\r\n");
      fileWriter.flush();
      fileWriter.close();
      Toast.makeText(context,"提交成功",Toast.LENGTH_LONG).show();
    } catch (IOException e) {
      Log.e("scan",e.fillInStackTrace().toString());

    } 
  }
}

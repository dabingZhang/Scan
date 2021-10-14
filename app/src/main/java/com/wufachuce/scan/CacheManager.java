package com.wufachuce.scan;

import android.content.Context;
import android.os.Environment;

import java.io.File;


public class CacheManager {
  public static File rootDir = new File(Environment.getExternalStorageDirectory(), "abc");

  /**
   * 获取缓存目录 SDCard/sncfc/xx
   *
   * @param context
   * @param fileName 文件名
   * @return
   */
  public static File getCacheFile(Context context, String fileName) {

    File appCacheDir = null;
    /*if ("mounted".equals(Environment.getExternalStorageState()) ) {
      appCacheDir = new File(rootDir, fileName);
    }*/

    if (appCacheDir == null || !appCacheDir.exists() && !appCacheDir.mkdirs()) {
      appCacheDir = context.getObbDir();
    }

    return appCacheDir;
  }




}

package com.schoolerc.fiftheditioncompanion.util;

import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Chaz Schooler on 3/11/2017.
 */

public class FileUtil {
    private static final String TAG = "FileUtil";

    public static void unzip(InputStream src, File dst, OnErrorListener errorListener) {
        try {
            ZipInputStream zip = new ZipInputStream(src);
            ZipEntry entry = zip.getNextEntry();

            byte[] buffer = new byte[1024];
            int len;
            while (entry != null) {
                Log.v(TAG, "Expanding file: " + entry.getName());
                File outfile = new File(dst.getAbsolutePath() + File.separator + entry.getName());
                if (!outfile.getParentFile().exists()) {
                    outfile.getParentFile().mkdirs();
                }
                if (entry.isDirectory()) {
                    if (!outfile.exists()) {
                        outfile.mkdir();
                    }
                } else {
                    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outfile));
                    while ((len = zip.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, len);
                    }
                    outputStream.close();
                }
                zip.closeEntry();
                entry = zip.getNextEntry();
            }

            zip.closeEntry();
            zip.close();
        } catch (IOException ex) {
            errorListener.onError(ex, "Failed to read zip file");
        }
    }
}

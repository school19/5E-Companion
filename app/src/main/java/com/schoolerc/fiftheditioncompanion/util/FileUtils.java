package com.schoolerc.fiftheditioncompanion.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Chaz Schooler on 3/5/2017.
 */

public class FileUtils {
    private static final String Tag = "FileUtils";
    public static FileExtension getExtension(File f)
    {
        if(!f.exists())
        {
            throw new IllegalArgumentException("File: " + f.getPath() + " does not exist!");
        }

        if(f.isDirectory())
        {
            throw new IllegalArgumentException("File: " + f.getPath() + " is a directory!");
        }

        String path = f.getPath();
        int finalDotPos = path.lastIndexOf('.');

        if(finalDotPos == -1)
        {
            return FileExtension.None;
        }

        String extension = path.substring(finalDotPos+1);

        if(extension.equalsIgnoreCase("xml"))
        {
            return FileExtension.Xml;
        }
        else if(extension.equalsIgnoreCase("zip"))
        {
            return FileExtension.Zip;
        }
        else
        {
            return FileExtension.None;
        }
    }

    public static void unzip(File src, File dst) {
        if (getExtension(src) != FileExtension.Zip) {
            throw new IllegalArgumentException("Source file " + src.getPath() + " is not a .zip file!");
        }

        if (dst.exists() && !dst.isDirectory())
        {
            throw new IllegalArgumentException("Destination: " + dst.getPath() + " exists and is not a directory!");
        }

        if(!dst.exists())
        {
            dst.mkdirs();
        }
        byte[] buffer = new byte[1024];
        ZipInputStream zipInputStream;
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(src)));
            ZipEntry entry = zipInputStream.getNextEntry();

            while(entry != null)
            {
                String fileName = entry.getName();
                File unzippedFile = new File(dst.getPath() + File.pathSeparator + fileName);

                new File(unzippedFile.getParent()).mkdirs();

                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(unzippedFile));

                int len;
                while((len = zipInputStream.read(buffer)) > 0)
                {
                    outputStream.write(buffer, 0, len);
                }

                outputStream.close();
                entry = zipInputStream.getNextEntry();
            }
            zipInputStream.closeEntry();
            zipInputStream.close();
        }
        catch(FileNotFoundException ex)
        {
            throw new IllegalArgumentException("Source file " + src.getPath() + " does not exist!");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}

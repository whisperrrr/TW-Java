package com.thoughtworks.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class FileUtil {

    /**
     * 完成复制文件夹方法:
     * 1. 把给定文件夹from下的所有文件(包括子文件夹)复制到to文件夹下
     * 2. 保证to文件夹为空文件夹，如果to文件夹不存在则自动创建
     * <p>
     * 例如把a文件夹(a文件夹下有1.txt和一个空文件夹c)复制到b文件夹，复制完成以后b文件夹下也有一个1.txt和空文件夹c
     */
    public static void copyDirectory(File from, File to) throws IOException {
        if (!to.exists()) {
            to.mkdirs();
        } else {
            delete(to);
        }
        File[] listFiles = from.listFiles();
        String separator = File.separator;

        for (File file : Objects.requireNonNull(listFiles)) {
            File fileTo = new File(to + separator + file.getName());
            if (file.isFile()) {
                copyFile(file, fileTo);
            } else {
                copyDirectory(file, fileTo);
            }
        }
    }

    //清空文件夹。保证to文件夹在复制之前为空
    private static void delete(File to) {
        if (to.isFile()) {
            to.delete();
        } else {
            for (File file : to.listFiles()) {
                delete(file);
            }
        }
    }

    //复制文件
    public static void copyFile(File fromFile, File toFile) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fromFile));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(toFile))) {
            byte[] buffer = new byte[1024];
            int n;
            while ((n = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, n);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




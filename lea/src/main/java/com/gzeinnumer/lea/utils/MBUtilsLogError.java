package com.gzeinnumer.lea.utils;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("ALL")
public class MBUtilsLogError {

    public static void logSystemFunctionGlobal(String function, String msg) {
        Log.d("MyBaseUtilsLogError_Deb", function + "_" + msg);
    }

    public static void initFileLogError(String appName, String logLocation) {
        if (appName == null) {
            logSystemFunctionGlobal("initFileLogError", "AppName tidak boleh null");
            return;
        }
        if (logLocation == null) {
            logSystemFunctionGlobal("initFileLogError", "LogLocation tidak boleh null");
            return;
        }
        if (appName.length() == 0) {
            logSystemFunctionGlobal("initFileLogError", "AppName tidak boleh kosong");
            return;
        }
        if (logLocation.length() == 0) {
            logSystemFunctionGlobal("initFileLogError", "LogLocation tidak boleh kosong");
            return;
        }
        if (!appName.substring(0, 1).equals("/")) {
            appName = "/" + appName;
        }
        if (!logLocation.substring(0, 1).equals("/")) {
            logLocation = "/" + logLocation;
        }

        if (isExternalStorageWritable()) {

            File appDirectory = new File(Environment.getExternalStorageDirectory() + appName);
            File logDirectory = new File(appDirectory + logLocation);
            String fileName = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
            File logFile = new File(logDirectory, "logcat_" + fileName + ".txt");

            // create app folder
            if (!appDirectory.exists()) {
                appDirectory.mkdir();
            }

            // create log folder
            if (!logDirectory.exists()) {
                logDirectory.mkdir();
            }

            // clear the previous logcat and then write the new one to the file
            try {
                Process process = Runtime.getRuntime().exec("logcat -c");
                process = Runtime.getRuntime().exec("logcat -f " + logFile);
            } catch (IOException e) {
                e.printStackTrace();
                logSystemFunctionGlobal("initFileLogError", "Gagal menulis text ke file : " + e.getMessage());
            }

        } else if (isExternalStorageReadable()) {
            // only readable
        } else {
            // not accessible
        }
    }

    /* Checks if external storage is available for read and write */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}

package com.lxl.lu.util.http;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by asus on 2016/9/29.
 */
public class UploadUtil {

    public boolean upload(String filepath,String urls) throws Exception {

        final String ENCORDING = "UTF-8";
        String boundary = "---------------------------7db1c523809b2";// +java.util.UUID.randomUUID().toString();//
        File file = new File(filepath);

        String fileName = new String("gege".getBytes(), "ISO-8859-1");
        URL url = new URL(
                urls);
        StringBuilder sb = new StringBuilder();


        sb.append("--" + boundary + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"file\"; filename=\""
                + "lyw.txt" + "\"" + "\r\n");
        sb.append("Content-Type: application/octet-stream" + "\r\n");
        sb.append("\r\n");

        byte[] before = sb.toString().getBytes(ENCORDING);
        byte[] after = ("\r\n--" + boundary + "--\r\n").getBytes(ENCORDING);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(10000);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type",
                "multipart/form-data; boundary=" + boundary);
        conn.setRequestProperty("Content-Length", before.length + file.length()
                + after.length + "");

        conn.setDoOutput(true);
        conn.setDoInput(true);

        OutputStream out = conn.getOutputStream();
        FileInputStream fis = new FileInputStream(file);
        out.write(before);

        byte[] buf = new byte[1024 * 5];
        int len;
        while ((len = fis.read(buf)) != -1)
            out.write(buf, 0, len);

        out.write(after);

        InputStream in = conn.getInputStream();
        InputStreamReader isReader = new InputStreamReader(in);
        BufferedReader bufReader = new BufferedReader(isReader);
        String line = null;
        String data = "getResult=";
        while ((line = bufReader.readLine()) != null)
            data += line;
        Log.i("System.out", "result=" + data);
        boolean sucess = conn.getResponseCode() == 200;
        in.close();
        fis.close();
        out.close();
        conn.disconnect();

        return sucess;
    }
}


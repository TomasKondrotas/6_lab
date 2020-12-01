package com.example.a6_lab;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class DataLoader extends AsyncTask<String, Void, String> {

    protected String doInBackground(String... params) {
        try {
            return getRateFromECB(params[0]);
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            return sw.toString();
        }
    }


    public static String getRateFromECB(String currencyCode) throws IOException {
        String rate = "Data were not retrieved";
        InputStream stream = downloadUrl(Constants.ECB_URL);
        try {
            rate = Parser.getRateFromECB(stream, currencyCode);
        }
        finally {
            if (stream != null) {
                stream.close();
            }
        }
        return rate;
    }

    private static InputStream downloadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }

}

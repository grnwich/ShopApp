package com.app.shop.shopapp.utils;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/3/15.
 */
public class NetConnection {


    public final String CHARSET="utf-8";
    public NetConnection(final String url, final HttpMethod method,
                         final SuccessCallback successCallback,
                         final FailCallback failCallback, final String... kvs) {

        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... arg0) {

                StringBuffer paramsStr = new StringBuffer();

                for (int i = 0; i < kvs.length; i += 2) {
                    paramsStr.append(kvs[i]).append("=").append(kvs[i + 1])
                            .append("&");
                }
                String string = paramsStr.toString().substring(0,
                        (paramsStr.length() - 1));
                System.out.println(string);

                try {
                    HttpURLConnection uc = null;

                    switch (method) {
                        case POST:

                            try {
                                uc = (HttpURLConnection) new URL(url).openConnection();
                                uc.setDoOutput(true);
                                uc.setDoInput(true);
                                uc.setRequestProperty("Accept-Charset","UTF-8");
                                uc.setRequestProperty("contentType","UTF-8");
                                OutputStream out = uc.getOutputStream();
                                out.write(string.getBytes());
                                out.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            break;
                        default:

                            uc = (HttpURLConnection) new URL(url + "?" + paramsStr.toString())
                                    .openConnection();

                            break;
                    }

                    System.out.println("Request url:" + uc.getURL());
                    System.out.println("Request data:" + paramsStr);

                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(uc.getInputStream(),
                                    CHARSET));

                    String line = null;
                    StringBuffer result = new StringBuffer();
                    while ((line = br.readLine()) != null) {
                        result.append(line);
                    }

                    System.out.println("Result:" + result);
                   // return uc.getURL().toString();
                    return result.toString();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String result) {

                if (result != null) {
                    if (successCallback != null) {
                        successCallback.onSuccess(result);
                    }
                } else {
                    if (failCallback != null) {
                        failCallback.onFail();
                    }
                }

                super.onPostExecute(result);
            }
        }.execute();

    }

    public static interface SuccessCallback {
        void onSuccess(String result);
    }

    public static interface FailCallback {
        void onFail();
    }

}

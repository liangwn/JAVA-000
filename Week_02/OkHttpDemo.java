package com.jerry.learn.week2;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by liang on 2020/10/25.
 */
public class OkHttpDemo {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:8801")
                .build();
        Response response = client.newCall(request).execute();
        String body = response.body().string();
        System.out.println("OkHttpDemo body: "+body);
    }
}

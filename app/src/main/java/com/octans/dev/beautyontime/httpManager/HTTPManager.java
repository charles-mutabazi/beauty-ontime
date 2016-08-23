package com.octans.dev.beautyontime.httpManager;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mutabazi on 8/23/16.
 */
public class HTTPManager {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    public static String getSaloonsData(String url) throws IOException {


        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response responses = null;

            try {
                responses = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String jsonData = responses.body().string();
            return jsonData;
        }catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


 ///next function
}

package com.wkq.net.interceptor;


import android.text.TextUtils;

import com.google.gson.Gson;
import com.wkq.net.model.MoveMTimeSearchInfo;

import org.json.JSONObject;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 作者:吴奎庆
 * <p>
 * 时间:2019-12-22
 * <p>
 * 用途:
 */


public class MTimeSearchInterceptor extends MoveDbResponseBodyInterceptor {
    @Override
    Response intercept(Response response, String url, String body) throws IOException {
        String content = null;
        JSONObject jsonObject = null;
        MoveMTimeSearchInfo moveMTimeSearchInfo = null;
        int start = body.indexOf("{");
        int end = body.lastIndexOf("}");
        if (end > 100) {
            content = body.substring(start, end + 1);
        }

        try {
            Gson gson = new Gson();
            if (!TextUtils.isEmpty(content))
                moveMTimeSearchInfo = gson.fromJson(content, MoveMTimeSearchInfo.class);
        } catch (Exception e) {

        }


        if (response.isSuccessful() && moveMTimeSearchInfo != null) {
            try {
                jsonObject=new JSONObject(content);
                JSONObject jsonData = new JSONObject();
                jsonData.put("errorMessage", "成功");
                jsonData.put("errorCode", "200");
                jsonData.put("data", jsonObject);
                MediaType contentType = response.body().contentType();
                ResponseBody responseBody = ResponseBody.create(contentType, jsonData.toString());
                return response.newBuilder().body(responseBody).build();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            try {
                jsonObject = new JSONObject(body);
                JSONObject jsonData = new JSONObject();
                jsonData.put("errorMessage", response.code() + "");
                jsonData.put("errorCode", response.body().string());


                MediaType contentType = response.body().contentType();
                ResponseBody responseBody = ResponseBody.create(contentType, jsonData.toString());
                return response.newBuilder().body(responseBody).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return response;
    }
}

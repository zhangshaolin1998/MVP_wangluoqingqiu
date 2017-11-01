package com.bawei.lianxi.modle;

import android.app.Activity;

import com.bawei.lianxi.Bean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 于俊建 on 2017/10/30.
 */

public class MainActivityModel extends Activity {
    String u = "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0";

    public void getData(boolean up, final MainActivityModelListener listener){

    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .addHeader("User-Agent","OkHttp Example")
            .url(u)
            .build();
     client.newCall(request).enqueue(new Callback() {
         @Override
         public void onFailure(Call call, IOException e) {
             listener.callBackFailure(1);
         }

         @Override
         public void onResponse(Call call, Response response) throws IOException {
             String string = response.body().string();
             Gson gson=new Gson();
             Bean bean = gson.fromJson(string, Bean.class);
             listener.callBackSuccess(bean);

         }
     });


}

}

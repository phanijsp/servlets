package com.example.servlets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.loopj.android.http.HttpGet;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.utils.URIBuilder;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

public class servletinserthelper extends AsyncTask<String, Integer, String> {
    EditText    et9;
    Context     cv9;
    String sd;
    FloatingActionButton ntv;

    LottieAnimationView lav9;
    public servletinserthelper(FloatingActionButton submit,LottieAnimationView  lav,String ss, EditText et, Context cv){
        et9=et;
        sd=ss;
        cv9=cv;
        lav9=lav;
        ntv=submit;
    }
    @SuppressLint("RestrictedApi")
    public void update(String s){
        lav9.setVisibility(View.INVISIBLE);
        ntv.setVisibility(View.VISIBLE);
        et9.setVisibility(View.VISIBLE);
        et9.setText("");
        Toast.makeText(cv9,"Submitted SuccessFully!",Toast.LENGTH_SHORT).show();
    }

    protected String doInBackground(String... Args) {
        String output = null;
        String s="haha";
        try {
            URIBuilder builder = new URIBuilder("http://192.168.31.158:8080/xcx/helloinsert");   //.net servlet url here
            builder.setParameter("Complaint",sd);//    this is parameter                DefaultHttpClient httpClient = new DefaultHttpClient();
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(builder.build());
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return output;
    }

    @Override        protected void onPostExecute(String s)
    {
        try            {
            update(s);

        } catch (NullPointerException e)
        {

        }
    }
}

package com.example.servlets;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.loopj.android.http.HttpGet;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.utils.URIBuilder;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

public class servlethelper extends AsyncTask<String, Integer, String> {
TextView    tv9;
ListView    lv9;
Context     cv9;
    public servlethelper(TextView   tv, ListView    lv, Context cv){
        tv9=tv;
        lv9=lv;
        cv9=cv;
    }

    public void update(String s){
        tv9.setText(s);
        String s2[]=s.split(",!,!,!,");
        String[] reversed = new String[s2.length];
        for(int i = 0; i<s2.length; i++) {
            reversed[i] = s2[s2.length -i-1];
        }
        s2 = reversed;



        ArrayAdapter<String> rldaptam_arrayAdapter   =   new ArrayAdapter<String>(cv9,R.layout.vselementcat,s2);
        ArrayAdapter<String> rldaptam_arrayAdapter2   =   new ArrayAdapter<String>(cv9, R.layout.vselementcat,
                R.id.tv5, s2);
        lv9.setAdapter(rldaptam_arrayAdapter2);



    }

    protected String doInBackground(String... Args) {
        String output = null;
        String s="haha";
        try {
            URIBuilder builder = new URIBuilder("http://192.168.31.158:8080/xcx/hello");   //.net servlet url here
            builder.setParameter("Name","John Smith");//    this is parameter                DefaultHttpClient httpClient = new DefaultHttpClient();
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(builder.build());
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            output = EntityUtils.toString(httpEntity);

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

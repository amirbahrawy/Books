package com.example.android.books;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by Amir on 19/08/2019.
 */

public class Utils {
    private static URL createUrl(String api){
       URL url=null;
        try {
            url=new URL(api);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
    private static String makeHttpRequest(URL url){
        String response="";
        if (url==null)
            return response;
        else{
            HttpURLConnection httpURLConnection=null;
             InputStream inputStream=null;
            try {
                httpURLConnection=(HttpURLConnection) url.openConnection();
                inputStream=url.openStream();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode()==200){
                   inputStream=httpURLConnection.getInputStream();
                   response=getFromStream(inputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if (httpURLConnection!=null)
                    httpURLConnection.disconnect();
                if (inputStream!=null)
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
      return response;
    }

    private static String getFromStream(InputStream inputStream) {
        StringBuilder stringBuilder =new StringBuilder();
        if (inputStream!=null){
           InputStreamReader inputStreamReader=new InputStreamReader(inputStream,Charset.forName("utf-8"));
           BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            try {
                String line=bufferedReader.readLine();
                while (line!=null){
                   stringBuilder.append(line);
                   line=bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
             return stringBuilder.toString();
    }
    private static List<BookModel> executeDataFromJson(String json){
       String title="",author="",imageUrl="";
       List<BookModel> books=new ArrayList<>();
        try {
            JSONObject root=new JSONObject(json);
            JSONArray items=root.getJSONArray("items");
            for (int i=0;i<=items.length();i++){
                JSONObject each_item=items.getJSONObject(i);
                JSONObject volumeInfo=each_item.getJSONObject("volumeInfo");
                if (volumeInfo.has("title")){
                   title=volumeInfo.getString("title");
                }
                else
                    title="no thing";
                if (volumeInfo.has("imageLinks")){
                    imageUrl=volumeInfo.getJSONObject("imageLinks").getString("thumbnail");
                }
                else imageUrl="";
                if (volumeInfo.has("authors")){
                   author=volumeInfo.getJSONArray("authors").getString(0);
                }
                else author="Not Found";
            }
           books.add(new BookModel(title,author,imageUrl));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return books;
    }
public static List<BookModel> utils(String api){
     String json=makeHttpRequest(createUrl(api));
     return executeDataFromJson(json);
}
}

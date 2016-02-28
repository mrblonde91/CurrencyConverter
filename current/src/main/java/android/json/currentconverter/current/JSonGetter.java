package android.json.currentconverter.current;

import android.util.Log;
import com.google.gson.JsonElement;
import com.loopj.android.http.HttpGet;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Michael on 27/02/2016.
 */
public class JSonGetter {
    public String GetJson(String url) {
        StringBuilder builder = new StringBuilder();
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet getter = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(getter);
            StatusLine status = response.getStatusLine();
            int statusCode = status.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream stream = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } else {
                Log.e("Convert_JSonError", "Failed to retrieve JSon");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}

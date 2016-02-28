package android.json.currentconverter.current;

import android.os.AsyncTask;
import android.provider.Telephony;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.google.gson.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;


public class Converter extends ActionBarActivity {

    TextView name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new CurrencyRetriever().execute();
        setContentView(R.layout.activity_converter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class CurrencyRetriever extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            TextView name = (TextView) findViewById(R.id.textView);
        }

        @Override
        protected String doInBackground(String... params) {
            JSonGetter getter = new JSonGetter();
            Gson converter = new Gson();
            String results = getter.GetJson("http://api.fixer.io/latest");
            return results;
        }


        @Override
        protected void onPostExecute(String jsonObject) {
            Gson converter = new GsonBuilder().create();
            JsonElement element = new JsonParser().parse(jsonObject);
            try {
                Currencies rates = converter.fromJson(element, Currencies.class);
                Log.i("Result", rates.toString());
            } catch (Exception e) {
                Log.e("Converter_ParsingError", e.toString());
            }

        }


    }

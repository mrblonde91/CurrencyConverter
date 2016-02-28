package android.json.currentconverter.current;

import android.util.Log;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * Created by Michael on 27/02/2016.
 */
public class Currencies {
    @SerializedName("base")
    private String base;
    @SerializedName("date")
    private String date;
    @SerializedName("rates")
    private Rates rates;
    private List<String> currencyNames;
    public String getBase() {
        return base;
    }
    public void setCurrencyNames(Iterator<String> keys)
    {
        currencyNames=new ArrayList<String>();
       while (keys.hasNext())
       {
          currencyNames.add(keys.next());
       }
    }
    public List<String> getCurrencyNames()
    {
        return currencyNames;
    }


}

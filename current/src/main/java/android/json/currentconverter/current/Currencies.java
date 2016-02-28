package android.json.currentconverter.current;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

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

    public String getBase() {
        return base;
    }

}

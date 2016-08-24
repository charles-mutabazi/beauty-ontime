package jsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import models.SaloonItems;

/**
 * Created by mutabazi on 8/23/16.
 */
public class JsonParser {
    public static List<SaloonItems> ParseSaloonsJsonData(String saloonData) throws JSONException {
        List<SaloonItems> saloonList = new ArrayList<>();

        JSONObject Jobject = new JSONObject(saloonData);
        JSONArray Jarray = Jobject.getJSONArray("places");

        for (int i=0; i < Jarray.length(); i++){
            JSONObject object     = Jarray.getJSONObject(i);
            SaloonItems items = new SaloonItems();

            items.setSaloonId(object.getString("_id"));
            items.setSaloonName(object.getString("name"));
            items.setSaloonAddress(object.getString("address"));
            items.setSaloonDescription(object.getString("description"));
            items.setSaloonImage(object.getString("image_url_large"));
            saloonList.add(items);
        }


        return saloonList;
    }
}

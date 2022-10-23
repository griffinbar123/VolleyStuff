package com.example.volleystuff2.placeholder;

import android.app.Activity;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.volleystuff2.ProfModel;
import com.example.volleystuff2.R;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlaceholderContent {


    public static final List<ProfModel> ITEMS = new ArrayList<>();

    public static final Map<String, ProfModel> ITEM_MAP = new HashMap<>();

    public boolean recreated = false;

    public List<ProfModel> jsonParse(Activity activity) {
        String url = activity.getString(R.string.url);

        RequestQueue queue = Volley.newRequestQueue(activity);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject object = response.getJSONObject("record");
                            JSONArray jsonArray = object.getJSONArray("gameCompanies");

                            clearItems();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject gameCompany = jsonArray.getJSONObject(i);
                                String json = String.valueOf(gameCompany);
                                Gson gson = new Gson();
                                ProfModel model = gson.fromJson(json, ProfModel.class);

                                addItems(model);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!recreated) {
                            activity.recreate();
                            recreated = true;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        });
        queue.add(request);
        return ITEMS;
    }

    public void addItems(ProfModel model){
        ITEMS.add(model);
        ITEM_MAP.put(model.getName(), model);
    }

    public void clearItems() {
        ITEMS.clear();
        ITEM_MAP.clear();
    }
}
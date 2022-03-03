package com.xampy.xrade.models.xrequests;


import android.os.AsyncTask;

import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class RsiStochGetRequest extends JsonObjectRequest {
    public RsiStochGetRequest(int method, String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    public RsiStochGetRequest(String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(url, jsonRequest, listener, errorListener);
    }
}

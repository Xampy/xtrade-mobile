package com.xampy.xrade.models.xrequests;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.xampy.xrade.models.SignalTimeframes;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RsiStochRequest {

    private final static String SERVER_URL = "http://192.168.137.1:5000/data";
    private final VolleyRequestQueue mVolleyRequestQueueSingleton;

    public interface RsiStochRequestListener {
        void onSuccess(JSONObject response);
        void onFailure();
    }


    public RsiStochRequest(Context ctx){
        mVolleyRequestQueueSingleton = new VolleyRequestQueue(ctx);
    }


    //Will add later listener for handling result and errors
    //will add volleyRequest
    public void getRsiStock(String signal_name, int rsi_period, SignalTimeframes time_frame,
                            final RsiStochRequestListener listener){

        //Construct params here
        Log.d("RSI request", "Function called");
        JSONObject params = null;
        try {
            params = new JSONObject();
            params.put("rsi_period", rsi_period);
            params.put("time_frame", time_frame.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        StringRequest rs_request = new StringRequest (
                Request.Method.GET,
                SERVER_URL +
                        "?symbol=" +  signal_name,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Rsi Response", response);
                        if (listener != null){
                            JSONObject r = null;
                            try {
                                r = new JSONObject(response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            listener.onSuccess(r);
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        Log.d("Body Type", rs_request.getBodyContentType());


        //add request to request queue
        mVolleyRequestQueueSingleton.getRequestQueue().add(rs_request);
    }
}

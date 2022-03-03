package com.xampy.xrade.models.xrequests;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyRequestQueue {

    private static VolleyRequestQueue volleyRequestQueue;
    private RequestQueue requestQueue;
    private static Context context;

    public VolleyRequestQueue(Context ctx) {
        context = ctx;
    }


    public RequestQueue getRequestQueue() {
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return requestQueue;
    }
}

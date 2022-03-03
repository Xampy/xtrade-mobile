package com.xampy.xrade.models;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.xampy.xrade.models.timer.SetIntervalTimer;
import com.xampy.xrade.models.xrequests.RsiStochRequest;
import com.xampy.xrade.models.xrequests.VolleyRequestQueueSingleton;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * TA signal model
 *
 * Get signal data, compute data and update view
 */
public class XradeSignalModel {

    private final int mRsiPeriod;
    private final SignalTimeframes mSignalTimeFrame;



    private final SetIntervalTimer mIntervalCCallback;


    private double mRsiValue;
    private RsiStochRequest mRsiStochRequest;
    private String mSignalName;


    public interface XradeSignalModelListener {
        void onRsiUpdated(String new_value);
    }
    private XradeSignalModelListener mListener;




    /**
     * ONSTRUCTOR
     * @param rsiPeriod period for rsi computing
     * @param timeframe time frame to be used
     */
    public XradeSignalModel(Context context, int rsiPeriod, SignalTimeframes timeframe){

        mRsiPeriod = rsiPeriod;
        mSignalTimeFrame = timeframe;
        mRsiStochRequest = new RsiStochRequest(context);


        //Start interval aller
        mIntervalCCallback =
                new SetIntervalTimer(
                    25000,  //1min = 60 * 1000
                    new SetIntervalTimer.OnSetIntervalTimerListener(){

                        @Override
                        public void onTimeElapsed() {
                            //Update rsi value
                            mRsiStochRequest.getRsiStock(
                                    mSignalName,
                                    7,
                                    SignalTimeframes.H1,
                                    new RsiStochRequest.RsiStochRequestListener() {
                                        @Override
                                        public void onSuccess(JSONObject response) {
                                            try {
                                                handleResponse(response);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }

                                        @Override
                                        public void onFailure() {
                                            Log.d("RDI ERROR", "Error occur white getting data");
                                        }
                                    }

                            );
                        }
                    }
        );

        //mIntervalCCallback.run();
    }

    public void setListener(XradeSignalModelListener listener){
        mListener = listener;
    }
    
    public void setSignalName(String name){
        this.mSignalName = name;
    }


    private void handleResponse(JSONObject response) throws JSONException {
        //The response is not yet an array
        mRsiValue = response.getDouble("rsi");
        if(mListener != null)
            mListener.onRsiUpdated(String.valueOf(mRsiValue));

    }


}

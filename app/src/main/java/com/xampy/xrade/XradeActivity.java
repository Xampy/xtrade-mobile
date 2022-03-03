package com.xampy.xrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.xampy.xrade.custom_view.XradeSignalView;
import com.xampy.xrade.models.SignalTimeframes;
import com.xampy.xrade.models.XradeSignal;
import com.xampy.xrade.models.XradeSignalModel;
import com.xampy.xrade.models.xrequests.RsiStochRequest;
import com.xampy.xrade.models.xrequests.VolleyRequestQueueSingleton;

import org.json.JSONException;
import org.json.JSONObject;

public class XradeActivity extends AppCompatActivity {


    private VolleyRequestQueueSingleton mVolleyRequestQueueSingleton;
    private XradeSignalView mVolatility100IndexView;
    private XradeSignalView mVolatility10IndexView;
    private XradeSignalView mBoom1000IndexView;
    private XradeSignalView mCash1000IndexView;
    private XradeSignalView mVolatility50IndexView;
    private XradeSignalView mVolatility25IndexView;
    private XradeSignalView mVolatility75IndexView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xrade);

        getSupportActionBar().hide();


        //[START initialize required variables]
        mVolleyRequestQueueSingleton = VolleyRequestQueueSingleton.getInstance(getApplicationContext());
        //[END initialize required variables]




        //Views


        //[START Volatility 100 Index ]
        mVolatility100IndexView = (XradeSignalView) findViewById(R.id.xrade_volatility_100_index);
        XradeSignalModel volatility_100_index_model =
                new XradeSignalModel(getApplicationContext(), 7, SignalTimeframes.H1);
        volatility_100_index_model.setSignalName("Volatility 100 Index");

        XradeSignal volatility_100_index = new XradeSignal(volatility_100_index_model, mVolatility100IndexView);
        //[END Volatility 100 Index ]

        //[START Volatility 10 Index ]
        mVolatility10IndexView = (XradeSignalView) findViewById(R.id.xrade_volatility_10_index);
        XradeSignalModel volatility_10_index_model =
                new XradeSignalModel(getApplicationContext(), 7, SignalTimeframes.H1);
        volatility_10_index_model.setSignalName("Volatility 10 Index");

        XradeSignal volatility_10_index = new XradeSignal(volatility_10_index_model, mVolatility10IndexView);
        //[END Volatility 10 Index ]

        //[START Volatility 25 Index ]
        mVolatility25IndexView = (XradeSignalView) findViewById(R.id.xrade_volatility_25_index);
        XradeSignalModel volatility_25_index_model =
                new XradeSignalModel(getApplicationContext(), 7, SignalTimeframes.H1);
        volatility_25_index_model.setSignalName("Volatility 25 Index");

        XradeSignal volatility_25_index = new XradeSignal(volatility_25_index_model, mVolatility25IndexView);
        //[END Volatility 25 Index ]


        //[START Volatility 50 Index ]
        mVolatility50IndexView = (XradeSignalView) findViewById(R.id.xrade_volatility_50_index);
        XradeSignalModel volatility_50_index_model =
                new XradeSignalModel(getApplicationContext(), 7, SignalTimeframes.H1);
        volatility_50_index_model.setSignalName("Volatility 50 Index");

        XradeSignal volatility_50_index = new XradeSignal(volatility_50_index_model, mVolatility50IndexView);
        //[END Volatility 25 Index ]



        //[START Volatility 25 Index ]
        mVolatility75IndexView = (XradeSignalView) findViewById(R.id.xrade_volatility_75_index);
        XradeSignalModel volatility_75_index_model =
                new XradeSignalModel(getApplicationContext(), 7, SignalTimeframes.H1);
        volatility_75_index_model.setSignalName("Volatility 75 Index");

        XradeSignal volatility_75_index = new XradeSignal(volatility_75_index_model, mVolatility75IndexView);
        //[END Volatility 25 Index ]



        //[START Boom 1000 Index ]
        mBoom1000IndexView = (XradeSignalView) findViewById(R.id.xrade_boom_1000_index);
        XradeSignalModel boom_1000_index_model =
                new XradeSignalModel(getApplicationContext(), 7, SignalTimeframes.H1);
        boom_1000_index_model.setSignalName("Boom 1000 Index");

        XradeSignal boom_1000_index = new XradeSignal(boom_1000_index_model, mBoom1000IndexView);
        //[END Volatility 100 Index ]

        //[START Cash 1000 Index ]
        mCash1000IndexView = (XradeSignalView) findViewById(R.id.xrade_crash_1000_index);
        XradeSignalModel cash_1000_index_model =
                new XradeSignalModel(getApplicationContext(), 7, SignalTimeframes.H1);
        cash_1000_index_model.setSignalName("Crash 1000 Index");

        XradeSignal cash_1000_index = new XradeSignal(boom_1000_index_model, mCash1000IndexView);
        //[END Volatility 100 Index ]
    }


    @Override
    protected void onPause() {
        //Stop interval runner
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        //destroy the interval
        super.onDestroy();
    }
}

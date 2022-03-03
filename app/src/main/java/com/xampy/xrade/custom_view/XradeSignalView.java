package com.xampy.xrade.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.xampy.xrade.R;
import com.xampy.xrade.models.XradeSignalModel;

public class XradeSignalView extends LinearLayout {


    private String mSignalName;
    private TypedArray mXradeAttributesTypedArray;
    private CharSequence[] mXradeSignalValues;


    private TextView mSignalNameTextView;
    private TextView mSignaActionTextView;
    private TextView mRsiValueTextView;
    private TextView mStochValueTextValue;
    private TextView mStochRangeCrossTextView;
    private ImageView mRsiCross80UpImageView;
    private ImageView mRsiCross80DownImageView;
    private ImageView mRsiCross20UpImageView;
    private ImageView mRsiCross20DownImageView;
    private ImageView mStochCross80UpImageView;
    private ImageView mStochCross80DownImageView;
    private ImageView mStochCross20UpImageView;
    private ImageView mStochCross20DownImageView;





    private XradeSignalModel mSignaModel;




    public XradeSignalView(Context context) {
        super(context);
        this.initializeViews(context);
    }

    public XradeSignalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mXradeAttributesTypedArray = context
                .obtainStyledAttributes(attrs, R.styleable.XradeSignalView);

        mSignalName = mXradeAttributesTypedArray.getString(R.styleable.XradeSignalView_signal_name);

        mXradeAttributesTypedArray.recycle();



        this.initializeViews(context);
    }

    public XradeSignalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initializeViews(context);

        mXradeAttributesTypedArray = context
                .obtainStyledAttributes(attrs, R.styleable.XradeSignalView);
        mSignalName = mXradeAttributesTypedArray.getString(R.styleable.XradeSignalView_signal_name);

        mXradeAttributesTypedArray.recycle();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public XradeSignalView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);


        mXradeAttributesTypedArray = context
                .obtainStyledAttributes(attrs, R.styleable.XradeSignalView);
        mSignalName = mXradeAttributesTypedArray.getString(R.styleable.XradeSignalView_signal_name);

        mXradeAttributesTypedArray.recycle();

        this.initializeViews(context);
    }


    /**
     * Inflate the views in the layout
     * @param context
     */
    private void initializeViews(Context context){
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.xrate_signal_view, this);
    }



    //Set the view model
    public void setViewModel(XradeSignalModel model){
        mSignaModel = model;
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();



        mSignalNameTextView = (TextView) this.findViewById(R.id.xrade_signal_view_signal_name_text_view);
        mSignaActionTextView = (TextView) this.findViewById(R.id.xrade_signal_view_action_text_view);
        mRsiValueTextView = (TextView) this.findViewById(R.id.xrade_signal_view_rsi_value_text_view);
        mStochValueTextValue = (TextView) this.findViewById(R.id.xrade_signal_view_stoch_value_text_view);
        mStochRangeCrossTextView = (TextView) this.findViewById(R.id.xrade_signal_view_stoch_range_cross_text_view);


        mRsiCross80UpImageView = (ImageView) this.findViewById(R.id.xrade_signal_view_rsi_cross_80_up_image_view);
        mRsiCross80DownImageView = (ImageView) this.findViewById(R.id.xrade_signal_view_rsi_cross_80_down_image_view);

        mRsiCross20UpImageView = (ImageView) this.findViewById(R.id.xrade_signal_view_rsi_cross_20_up_image_view);
        mRsiCross20DownImageView = (ImageView) this.findViewById(R.id.xrade_signal_view_rsi_cross_20_down_image_view);


        mStochCross80UpImageView = (ImageView) this.findViewById(R.id.xrade_signal_view_stoch_cross_80_up_image_view);
        mStochCross80DownImageView = (ImageView) this.findViewById(R.id.xrade_signal_view_stoch_cross_80_down_image_view);

        mStochCross20UpImageView = (ImageView) this.findViewById(R.id.xrade_signal_view_stoch_cross_20_up_image_view);
        mStochCross20DownImageView = (ImageView) this.findViewById(R.id.xrade_signal_view_stoch_cross_20_down_image_view);




        mSignalNameTextView.setText(mSignalName);
    }







    //Functions
    public void setRsiValue(String value){
        mRsiValueTextView.setText(value);
    }

    public void setStochValue(double K, double D){

    }

    public void toggleRsiRangeCross(){

    }
}

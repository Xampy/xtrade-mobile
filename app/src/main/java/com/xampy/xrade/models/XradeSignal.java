package com.xampy.xrade.models;

import com.xampy.xrade.custom_view.XradeSignalView;

public class XradeSignal {


    public XradeSignal(XradeSignalModel model, final XradeSignalView view){






       XradeSignalModel.XradeSignalModelListener mListener =
                new XradeSignalModel.XradeSignalModelListener() {
                    @Override
                    public void onRsiUpdated(String new_value) {
                        //Get the view to update his RSI
                        view.setRsiValue(new_value);
                    }
                };




        model.setListener(mListener);
    }



}

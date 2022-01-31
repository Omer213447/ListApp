package com.ax.listapp.models;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ControlModel {
    public static boolean isTextViewEmpty(TextView textView){
        if(textView.getText().equals(" ")){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isEditTextEmpty(EditText editText){
        if(editText.getText().equals(" ")){
            return true;
        }else {
            return false;
        }
    }
}

package com.nollec.clearedittextdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * Created by suweiliang on 15-8-19.
 */
public class InputEditText extends EditText {

    private Drawable deleteImage = getResources().getDrawable(android.R.drawable.ic_menu_delete);
    private Drawable leftImage1 = getResources().getDrawable(android.R.drawable.ic_menu_call);
    private Drawable leftImage2 = getResources().getDrawable(android.R.drawable.ic_menu_compass);


    public InputEditText(Context context) {
        super(context);
        init();
    }

    public InputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        setDelete();
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setDelete();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (deleteImage != null && event.getAction() == MotionEvent.ACTION_UP) {
            float x = event.getX();
            if (getWidth() - x <= getCompoundPaddingRight()) {
                if (!TextUtils.isEmpty(getText().toString())) {
                    setText("");
                }
            }
        }
        return super.onTouchEvent(event);
    }

    private void setDelete() {
        if (1 > length()) {
            setCompoundDrawablesRelativeWithIntrinsicBounds(leftImage1, null, null, null);
        } else {
            setCompoundDrawablesRelativeWithIntrinsicBounds(leftImage2, null, deleteImage, null);
        }
    }


}

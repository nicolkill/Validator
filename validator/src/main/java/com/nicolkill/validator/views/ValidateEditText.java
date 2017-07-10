package com.nicolkill.validator.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.nicolkill.validator.R;
import com.nicolkill.validator.TextValidator;
import com.nicolkill.validator.Validator;

/**
 * Created by nicolkill on 7/10/17.
 */

public class ValidateEditText extends AppCompatEditText {

    private String mErrorMessage = null;
    private Validator mValidator = new TextValidator();

    public ValidateEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null) {
            configureAttrs(context, attrs);
        }
    }

    public ValidateEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            configureAttrs(context, attrs);
        }
    }

    private void configureAttrs(Context context, AttributeSet attrs) {
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ValidateEditText);
        int type = attributes.getInt(R.styleable.ValidateEditText_type_validator, 0);
        mErrorMessage = attributes.getString(R.styleable.ValidateEditText_text_error);
        attributes.recycle();
        if (mErrorMessage == null) {
            mErrorMessage = "";
        }
        initValidator(type);
    }

    private void initValidator(int type) {
        mValidator = ValidateTextInputLayout.ValidateMethods.initValidator(type);
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        mErrorMessage = errorMessage;
    }

    public Validator getValidator() {
        return mValidator;
    }

    public void setValidator(Validator validator) {
        mValidator = validator;
    }

    public boolean isValid() {
        return ValidateTextInputLayout.ValidateMethods.isValid(new ValidateTextInputLayout.EditTextMethods() {
            @Override
            public void setError(String text) {
                ValidateEditText.this.setError(text);
            }

            @Override
            public String getText() {
                return ValidateEditText.this.getText().toString();
            }

            @Override
            public Context getContext() {
                return ValidateEditText.this.getContext();
            }

            @Override
            public Validator getValidator() {
                return ValidateEditText.this.getValidator();
            }

            @Override
            public String getErrorMessage() {
                return ValidateEditText.this.getErrorMessage();
            }
        });
    }

}

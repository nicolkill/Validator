package com.nicolkill.validator.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;

import com.nicolkill.validator.DateTimeValidator;
import com.nicolkill.validator.DateValidator;
import com.nicolkill.validator.EMailValidator;
import com.nicolkill.validator.NameValidator;
import com.nicolkill.validator.NumberValidator;
import com.nicolkill.validator.PhoneValidator;
import com.nicolkill.validator.R;
import com.nicolkill.validator.TextValidator;
import com.nicolkill.validator.TimeValidator;
import com.nicolkill.validator.URLValidator;
import com.nicolkill.validator.Validator;

/**
 * Created by nicolkill on 6/2/17.
 */

public class ValidateTextInputLayout extends TextInputLayout {

    private String mErrorMessage = null;
    private Validator mValidator = new TextValidator();

    public ValidateTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null) {
            configureAttrs(context, attrs);
        }
    }

    public ValidateTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            configureAttrs(context, attrs);
        }
    }

    private void configureAttrs(Context context, AttributeSet attrs) {
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ValidateTextInputLayout);
        int type = attributes.getInt(R.styleable.ValidateTextInputLayout_type_validator, 0);
        mErrorMessage = attributes.getString(R.styleable.ValidateTextInputLayout_text_error);
        attributes.recycle();
        if (mErrorMessage == null) {
            mErrorMessage = "";
        }
        initValidator(type);
    }

    private void initValidator(int type) {
        mValidator = ValidateMethods.initValidator(type);
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

    public String getText() {
        return getEditText().getText().toString();
    }

    public void setText(String text) {
        getEditText().setText(text);
    }

    public boolean isValid() {
        return ValidateMethods.isValid(new EditTextMethods() {
            @Override
            public void setError(String text) {
                ValidateTextInputLayout.this.setError(text);
            }

            @Override
            public String getText() {
                return ValidateTextInputLayout.this.getText();
            }

            @Override
            public Context getContext() {
                return ValidateTextInputLayout.this.getContext();
            }

            @Override
            public Validator getValidator() {
                return ValidateTextInputLayout.this.getValidator();
            }

            @Override
            public String getErrorMessage() {
                return ValidateTextInputLayout.this.getErrorMessage();
            }
        });
    }

    protected interface EditTextMethods {
        void setError(String text);
        String getText();
        Context getContext();
        Validator getValidator();
        String getErrorMessage();
    }

    protected static class ValidateMethods {

        public static Validator initValidator(int type) {
            switch (type) {
                case 0:
                    return new TextValidator();
                case 1:
                    return new NumberValidator();
                case 2:
                    return new DateValidator();
                case 3:
                    return new TimeValidator();
                case 4:
                    return new DateTimeValidator();
                case 5:
                    return new EMailValidator();
                case 6:
                    return new URLValidator();
                case 7:
                    return new PhoneValidator();
                case 8:
                    return new NameValidator();
            }
            return new TextValidator();
        }

        public static boolean isValid(EditTextMethods editText) {
            editText.setError(null);
            String text = editText.getText();
            boolean isValid = !text.isEmpty();
            if (!isValid) {
                editText.setError(editText.getContext().getString(R.string.field_not_empty));
            } else {
                isValid = editText.getValidator().isValid(text);
                if (!isValid) {
                    editText.setError(editText.getErrorMessage());
                }
            }
            return isValid;
        }

    }

}

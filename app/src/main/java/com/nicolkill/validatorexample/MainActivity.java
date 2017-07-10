package com.nicolkill.validatorexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.nicolkill.validator.PhoneValidator;
import com.nicolkill.validator.TextValidator;
import com.nicolkill.validator.Validator;
import com.nicolkill.validator.views.ValidateEditText;
import com.nicolkill.validator.views.ValidateTextInputLayout;

public class MainActivity extends AppCompatActivity {

    private ValidateTextInputLayout mValidateTextInputLayout;
    private ValidateEditText mValidateEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mValidateTextInputLayout = (ValidateTextInputLayout) findViewById(R.id.edit1);
        mValidateEditText = (ValidateEditText) findViewById(R.id.edit2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mValidateTextInputLayout.isValid();
                mValidateEditText.isValid();
            }
        });
    }

}

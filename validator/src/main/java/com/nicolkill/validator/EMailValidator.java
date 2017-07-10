package com.nicolkill.validator;

import android.util.Patterns;

/**
 * Created by Nicol Acosta on 25/05/2017.
 */

public class EMailValidator extends Validator {

    @Override
    public boolean isValid(String text) {
        return Patterns.EMAIL_ADDRESS.matcher(text).matches();
    }

}

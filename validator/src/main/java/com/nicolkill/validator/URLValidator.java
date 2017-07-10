package com.nicolkill.validator;

import android.util.Patterns;

/**
 * Created by Nicol Acosta on 25/05/2017.
 */

public class URLValidator extends Validator {

    @Override
    public boolean isValid(String text) {
        return Patterns.WEB_URL.matcher(text).matches();
    }

}

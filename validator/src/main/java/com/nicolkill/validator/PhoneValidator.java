package com.nicolkill.validator;

import android.util.Patterns;

/**
 * Created by Nicol Acosta on 25/05/2017.
 */

public class PhoneValidator extends Validator {

    public static final int PHONE_CHARACTERS_NUMBER = 10;

    @Override
    public boolean isValid(String text) {
        return Patterns.PHONE.matcher(text).matches() && text.length() == PHONE_CHARACTERS_NUMBER;
    }

}

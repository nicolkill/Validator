package com.nicolkill.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Nicol Acosta on 25/05/2017.
 */

public class DateTimeValidator extends Validator {

    public final static String DATETIME_FORMAT = "dd-MM-yyyy HH:mm:ss";

    @Override
    public boolean isValid(String text) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(DATETIME_FORMAT);
            df.setLenient(false);
            df.parse(text);
            return true;
        } catch (ParseException e) {
        }
        return false;
    }

}

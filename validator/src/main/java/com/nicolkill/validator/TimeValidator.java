package com.nicolkill.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Nicol Acosta on 25/05/2017.
 */

public class TimeValidator extends Validator {

    public final static String TIME_FORMAT = "HH:mm:ss";

    @Override
    public boolean isValid(String text) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(TIME_FORMAT);
            df.setLenient(false);
            df.parse(text);
            return true;
        } catch (ParseException e) {
        }
        return false;
    }

}

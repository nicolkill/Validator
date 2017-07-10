package com.nicolkill.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Nicol Acosta on 25/05/2017.
 */

public class DateValidator extends Validator {

    public final static String DATE_FORMAT = "dd-MM-yyyy";

    @Override
    public boolean isValid(String text) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(text);
            return true;
        } catch (ParseException e) {
        }
        return false;
    }

}

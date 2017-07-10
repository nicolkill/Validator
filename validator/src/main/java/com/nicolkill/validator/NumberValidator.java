package com.nicolkill.validator;

/**
 * Created by Nicol Acosta on 25/05/2017.
 */

public class NumberValidator extends Validator {

    @Override
    public boolean isValid(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

}

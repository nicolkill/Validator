package com.nicolkill.validator;

/**
 * Created by Nicol Acosta on 25/05/2017.
 */

public abstract class Validator {

    public abstract boolean isValid(String text);

    public String notValidMessage() {
        return "The text is not valid";
    }

}

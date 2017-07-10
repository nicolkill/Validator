package com.nicolkill.validator;

import java.util.regex.Pattern;

/**
 * Created by Nicol Acosta on 25/05/2017.
 */

public class NameValidator extends Validator {

    private static final String NAME_FORMAT = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+";

    @Override
    public boolean isValid(String text) {
        return Pattern.compile(NAME_FORMAT).matcher(text).matches();
    }

}

package com.example.gymaths.equations;

import android.os.Build;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.R)
public class Parser {

    // Retourne NumberFormatException si le nombre
    // n'est pas parsable.
    public static Exp parse(String input) {
        input = input.replace(" ", "");
        if (input.contains("/") && input.split("/").length == 2) // TODO Optimisable !
        {
            String[] temp = input.split("/");
            return new Divide(
                    new Number(Float.parseFloat(temp[0])),
                    new Number(Float.parseFloat(temp[1])));
        } else {
            return new Number(Float.parseFloat(input));
        }

    }
}

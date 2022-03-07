package com.example.gymaths.equations;

/**
 * Classe permettant de convertir l'entrée texte de l'utlisateur en {@code Exp}.
 *
 * @author Vincent Commin & Louis Leenart
 */
public class Parser {

    // Retourne NumberFormatException si le nombre
    // n'est pas parsable.

    /**
     * Parse l'input utilisateur en une {@code Exp}.
     *
     * Note: Ce parseur est très basique et nécessite une refonte complète pour généraliser son
     * fonctionnement.
     *
     * @param input Entrée texte de l'utilisateur
     * @return Exp correspondant à l'entrée utilisateur
     * @throws NumberFormatException Si le nombre n'est pas de la forme Number ou Number / Number.
     */
    public static Exp parse(String input) throws NumberFormatException {
        input = input.replace(" ", "");
        if (input.contains("/") && input.split("/").length == 2) // TODO Optimisable
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

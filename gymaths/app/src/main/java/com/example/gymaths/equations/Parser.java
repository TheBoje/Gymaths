package com.example.gymaths.equations;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class Parser {
    // TODO Ajouter les opérateurs ici
    private static Map<Character, Exp> operators = null;/*Map.of(
        '+', new Plus(null, null),
        '-', new Minus(null, null),
        '*', new Times(null, null),
        '/', new Divide(null, null)
    );*/


    // Source : https://www.klittlepage.com/2013/12/22/twelve-days-2013-shunting-yard-algorithm/
    public static String infixToRPN(String input)
    {
        Stack<Character> operatorStack = new Stack<>();
        // Structure de donnée qui preprésente le string comme 
        // une liste que l'on peut manipuler
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        
        main:
        for (char c : chars){
            char popped;
            // TODO retirer les ' ' du l'input
            switch (c) {
                case '(':
                    operatorStack.push('(');
                    break;
                case ')':
                    while(!operatorStack.empty())
                    {
                        popped = operatorStack.pop();
                        if (popped == '(')
                        {
                            continue main;
                        }
                        else 
                        {
                            sb.append(" ").append(popped);
                        }
                    }
                    throw new UnsupportedOperationException("Unbalanced parentheses");
                default:
                    if(operators.containsKey(c)){
                        Exp o1 = operators.get(c).copy();
                        Exp o2;
                        while (!operatorStack.empty() && null != (o2 = operators.get(operatorStack.peek()))){
                            if((!((Operator)o1).isRightAssociative() 
                            && ((Operator)o1).comparePrecedence(o2) == 0 
                            || ((Operator) o1).comparePrecedence(o2) < 0))
                            {
                                operatorStack.pop();
                                sb.append(" ").append(((Operator)o2).getSymbol());
                            }
                            else 
                            {
                                break;
                            }
                        }
                        operatorStack.push(c);
                    } else {
                        if (sb.length() > 0){
                            sb.append(" ");
                        }
                        sb.append(c);
                    }
                    break;
            }
        }
        while(!operatorStack.isEmpty()){
            sb.append(" ").append(operatorStack.pop());
        }
        return sb.toString();
    }


    public static Exp infixToExp(String input) {
        Stack<Character> operatorStack = new Stack<>();
        Stack<Exp> operandStack = new Stack<>();
        char[] chars = input.toCharArray();

        main:
        for (char c : chars) {
            char popped;
            switch (c) {
                case ' ':
                    break;
                case '(':
                    operatorStack.push('(');
                    break;
                case ')':
                    while (!operatorStack.isEmpty()) {
                        popped = operatorStack.pop();
                        if (popped == '(') {
                            continue main;
                        } else {
                            //addNote() ??
                        }
                    }
            }
        }
        return null; // FIXME not finished
    }
}

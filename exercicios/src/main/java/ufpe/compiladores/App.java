package ufpe.compiladores;

import java.util.Scanner;
import java.util.Stack;

/**
 * Infix expressions to postfix expressions
 */
public final class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder output = new StringBuilder();
        Stack<Character> operations = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(!Character.isWhitespace(c)) {
                if(!((c == '+') || (c == '-') || (c == '*') || (c == '/'))) {
                    output.append(c);
                } else {
                    operations.push(c);
                }
            }
        }
        while(!operations.empty()) {
            output.append(operations.pop());
        }

        System.out.println(output);        

        in.close();
    }
}

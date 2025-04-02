package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * prefix 계산식을 postfix 계산식으로 변경시키기. (23.4.2 수정)
 */

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer prefix = new StringTokenizer(sc.nextLine());
        Deque<String> oper = new ArrayDeque<>();
        StringBuilder postfix = new StringBuilder();

        while (prefix.hasMoreTokens()) {
            String token = prefix.nextToken();
            switch (token) {
                case ")" -> {
                    while (!oper.isEmpty() && !oper.peek().equals("(")) {
                        postfix.append(oper.pop());
                    }
                    oper.remove();
                }
                case "+", "-" -> {
                    while(isPrior(oper.peek())) postfix.append(oper.pop());
                    oper.push(token);
                }
                case "(", "*", "/" -> oper.push(token);

                default -> postfix.append(token);
            }
        }

        for (String s : oper) {
            postfix.append(s);
        }

        System.out.println(postfix);
    }

    static boolean isPrior(String token) {
        if (token == null) return false;
        return token.equals("*") || token.equals("/");
    }
}

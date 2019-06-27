import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class AlgExpression {
    // take expression like 3 + 6 / 2 - 7 * 3
    // and evaluate it
    public static Double evaluate(String expression) {
        Stack<String> stack = new Stack<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("*", 3);
        map.put("/", 3);
        map.put("+", 2);
        map.put("-", 2);
        map.put("(", 1);
        ArrayList<String> list = new ArrayList<>();
        String[] ss = expression.split(" ");
        for(String s : ss){
            if(s.contains("1") || s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") || s.contains("6") || s.contains("7") || s.contains("8") || s.contains("9") || s.contains("0")){
                list.add(s);
            } else if(s.equals("(")){
                stack.push(s);
            } else if(s.equals(")")){
                String topToken = stack.pop();
                while (!topToken.equals("(")){
                    list.add(topToken);
                    topToken = stack.pop();
                }
            } else {
                while (!stack.empty() && map.get(stack.peek()) >= map.get(s)){
                    list.add(stack.pop());
                }
                stack.push(s);
            }
        }
        while(!stack.empty())
            list.add(stack.pop());

        for(String s : list){
            if(s.contains("1") || s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") || s.contains("6") || s.contains("7") || s.contains("8") || s.contains("9") || s.contains("0")){
                stack.push(s);
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                double result = doMath(s, Double.valueOf(operand1), Double.valueOf(operand2));
                stack.push(String.valueOf(result));
            }
        }
        return Double.valueOf(stack.pop());
    }

    public static double doMath(String op, double op1, double op2){
        if(op.equals("*"))
            return op1*op2;
        else if(op.equals("/"))
            return op1/op2;
        else if(op.equals("+"))
            return op1+op2;
        return op1-op2;
    }
}

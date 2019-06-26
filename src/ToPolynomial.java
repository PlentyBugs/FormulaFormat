public class ToPolynomial {
    public static String expand(String expr) {
        String firstPart = expr.split("\\^")[0].substring(1, expr.split("\\^")[0].length()-1);
        int power = Integer.parseInt(expr.split("\\^")[1]);

        if(power == 0)
            return "1";

        StringBuilder builder = new StringBuilder();
        char ch = '0';
        int firstKoeff = 0;
        int secondKoeff = 0;
        String signs = "";

        for(char c : firstPart.toCharArray()){
            if(c != '+' && c != '-'){
                if(!"qwertyuiopasdfghjklzxcvbnm".contains(String.valueOf(c))){
                    builder.append(c);
                } else if("qwertyuiopasdfghjklzxcvbnm".contains(String.valueOf(c)) && firstKoeff == 0){
                    firstKoeff = (builder.toString().equals("")) ? 1: Integer.parseInt(builder.toString().trim());
                    builder = new StringBuilder();
                    ch = c;
                }
            } else {
                signs += c;
            }
        }

        secondKoeff = (builder.toString().equals("")) ? 1: (builder.toString().trim().equals("0")) ? 0 : Integer.parseInt(builder.toString().trim());
        if(signs.length() == 2) {
            firstKoeff *= -1;
            if (signs.equals("--"))
                secondKoeff *= -1;
        } else if(signs.equals("-"))
            secondKoeff *= -1;
        builder = new StringBuilder();

        System.out.println();
        for(int i = 0; i <= power; i++){
            long k = fact(power)/(fact(i)*fact(power-i));
            long g = ((long) Math.pow(firstKoeff, power-i))*k*((long) Math.pow(secondKoeff, i));
            String s = "";
            String letPart = (power-i==1) ? String.valueOf(ch) : (power-i != 0) ? ch + "^" + (power - i) : "";
            String intPart = (g == 1 && !letPart.equals("")) ? "" : (g == -1 && !letPart.equals("")) ? "-" : String.valueOf(g);
            s = (intPart.equals("0")) ? "" : intPart + letPart;
            if(!builder.toString().equals(""))
                if(g > 0)
                    s = "+" + s;
            builder.append(s);
        }

        return builder.toString();
    }

    public static long fact(long x){
        return (x==0) ? 1 : fact(x-1)*x;
    }
}
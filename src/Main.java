public class Main {
    public static void main(String[] args){
        System.out.println("---Test---");
        System.out.println(ToPolynomial.expand("(-10  x+   6)^5")); // -100000x^5+300000x^4-360000x^3+216000x^2-64800x+7776
        System.out.println(ToPolynomial.expand("(5y+12)^3")); // 125x^3+900x^2+2160x+1728
        System.out.println(ToPolynomial.expand("(12z-4)^4")); // 20736z^4-27648z^3+13824z^2-3072z+256
        System.out.println(AlgExpression.evaluate("3 + 6 / 2 - 7 * 3"));
        System.out.println(AlgExpression.evaluate("( 3 + 6 ) / 3 - 7 * 3"));
        System.out.println(AlgExpression.evaluate("3 + 6 / 2 - 1 * 3"));
    }
}

public class SquareTriangle {

    public static void main(String[] args){

        CalculateSquare(3, 4, 5);

    }

    public static double CalculateSquare(int a, int b, int c){

        boolean isTriangle = true;
        double p = ((double)(a+b+c))/2;
        double s;

        if (p <= a || p <= b || p <= c || a*b*c==0) {
            isTriangle = false;
            //throw new MyException("Не треугольник");
        }
        return isTriangle ? Math.sqrt(p*(p - a)*(p - b)*(p - c)) : -1;
    }
}

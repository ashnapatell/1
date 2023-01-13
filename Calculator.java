public class Calculator {
public static double addition(double x, double y){
    return x+y;
}
public static double subtraction(double x, double y){
    return x-y;
}
public static double division(double x, double y){
    return x/y;
}
public static double multiplication(double x, double y){
    return x*y;
}
public static void main (String[] args){
    System.out.println("What is the first value?");
    double x;
    double y;
    x = Double.parseDouble(args[0]);
    System.out.println("What is the second value?");
    y = Double.parseDouble(args[1]);
    System.out.println("What operation would you like to do (add,subtract,multiply,divide)?");
    int i = 0;
    for (i = 0; i < args.length; i++){
        String operation = args[i];
        if (operation == "add"){
            addition(x,y);
        } else {
            if (operation == "subtract"){
                subtraction(x,y);
            } else {
                if (operation == "multiply"){
                    multiplication(x,y);
                } else {
                    division(x,y);
                }
            }
        }
    }
    
}
}
public class SimpleIntrest {
    public static double calculate(double principle, double rate, int year){
        return principle*rate*year/100;
    }

    public static void main(String[] args) {
        System.out.println(calculate(1225,5.5,6));
    }
}

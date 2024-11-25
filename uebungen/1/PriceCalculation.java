public class PriceCalculation {
 
    public double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount;
 
        if (extras >= 5) {
            addon_discount = 15;
        } else if (extras >= 3) {
            addon_discount = 10;
        } else {
            addon_discount = 0;
        }

        if (discount > addon_discount) {
            addon_discount = discount;
        }
 
        return baseprice * (1 - discount / 100.0) + specialprice + extraprice * (1 - addon_discount / 100.0);
    }
 
    public boolean test_calculate_price() {
        double result = calculatePrice(200.0, 30.0, 50.0, 3, 5.0);  // Beispielwerte
        double expected = 265;  // Beispielhafte erwartete Berechnung
        System.out.println("result="+result);
        return Math.abs(result - expected) < 0.01;  // Toleranz für Gleitkommazahlen
    }
 
   /* public static void main(String[] args) {
        PriceCalculation calc = new PriceCalculation();
        boolean testResult = calc.test_calculate_price();
        System.out.println("Test erfolgreich: " + testResult);
    }
    */
}
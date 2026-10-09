public class Main {
    public static void main(String[] args) {
        System.out.println("=== Regression Test Runner ===");
        int total = 0;
        int passed = 0;

        total++; passed += test("Single item total", 20.00, calculateTotal(2, 10.00, 0));
        total++; passed += test("10 percent discount", 90.00, calculateTotal(10, 10.00, 10));
        total++; passed += test("Zero quantity", 0.00, calculateTotal(0, 99.00, 0));
        total++; passed += test("25 percent discount", 75.00, calculateTotal(4, 25.00, 25));

        System.out.printf("Result: %d/%d tests passed%n", passed, total);
        if (passed != total) System.exit(1);
    }

    static double calculateTotal(int quantity, double unitPrice, double discountPercent) {
        double subtotal = quantity * unitPrice;
        return subtotal * (1 - discountPercent / 100.0);
    }

    static int test(String name, double expected, double actual) {
        boolean ok = Math.abs(expected - actual) < 0.001;
        System.out.printf("%-25s expected=%6.2f actual=%6.2f -> %s%n",
                name, expected, actual, ok ? "PASS" : "FAIL");
        return ok ? 1 : 0;
    }
}

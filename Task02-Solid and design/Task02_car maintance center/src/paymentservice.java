public interface paymentservice {
    void pay (double amount);
}

class CashPayment implements paymentservice {
    public void pay(double amount) {
        System.out.println("Paid cash: " + amount);
    }
}

class VisaPayment implements paymentservice {
    public void pay(double amount) {
        System.out.println("Paid by VISA: " + amount);
    }
}
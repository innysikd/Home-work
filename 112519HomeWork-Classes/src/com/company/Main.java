package com.company;

public class Main {

    public static void main(String[] args) {

        LoanConsumer consumer1 = new LoanConsumer("James", 50, 25000);
        LoanConsumer consumer2 = new LoanConsumer("Tomas", 75, 20000);
        LoanConsumer consumer3 = new LoanConsumer("George", 55, 19999);

        LoanIssuer issuer1 = new LoanIssuer("Vasja", true, true);
        LoanIssuer issuer2 = new LoanIssuer("Masha", false, true);
        LoanIssuer issuer3 = new LoanIssuer("Petja", false, false);

        System.out.println(toIssue(consumer3, issuer2));


    }

    public static boolean toIssue (LoanConsumer consumer, LoanIssuer issuer) {
        boolean toIssue = false;
        if (consumer.getSalary() >= 20000) {
            if (issuer.isLazy)
                toIssue = true;
            if (issuer.isLazy == false && issuer.isKind) {
                if (consumer.getAge() <= 70)
                    toIssue = true;
            }
            if (issuer.isKind == false && issuer.isKind == false) {
                if (consumer.getAge() <= 50)
                    toIssue = true;
            }

        }
        return toIssue;
    }
}

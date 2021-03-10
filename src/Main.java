import java.util.Scanner;

public class Main {
    private static int minIncome = 4000; // definition du chiffre d'affaire minimum
    private static int maxIncome = 12000; // et max

    private static int officeRentCharge = 1400; // les charges externes
    private static int telephonyCharge = 50;
    private static int internetAccessCharge = 30;

    private static int assistantSalary = 1550; // salaire de l'assistant
    private static int financeManagerSalary = 1550; // salaire du manager

    private static double mainTaxPercent = 0.24; // les charges internes
    private static double managerPercent = 0.25;

    private static double minInvestmentsAmount = 10000; // chiffre d'affaire a partir du quel on peut reinvestir

    public static void main(String[] args) {
        while (true) {
            System.out.println("Entrer le chiffre d\'affaire mensuel " +
                "(de 2000 à 9000 euros): ");
            int income = (new Scanner(System.in)).nextInt();

            if (!checkIncomeRange(income)) {
                continue;
            }

            double managerSalary = income * managerPercent;
            double pureIncome = income - managerSalary -
                calculateFixedCharges();
            double taxAmount = mainTaxPercent * pureIncome;
            double pureIncomeAfterTax = pureIncome - taxAmount;

            boolean canMakeInvestments = pureIncomeAfterTax >=
                minInvestmentsAmount;

            System.out.println("Le salaire du manager: " + managerSalary);
            System.out.println("Le total des impots: " +
                (taxAmount > 0 ? taxAmount : 0));
            System.out.println("Entreprise peut investir: " +
                (canMakeInvestments ? "oui" : "non"));
            if (pureIncome < 0) {
                System.out.println("Chiffre d\'affaire négatif! Il faut augmenter le chiffre!");
            }
        }
    }

    private static boolean checkIncomeRange(int income) {
        if (income < minIncome) {
            System.out.println("Chiffre d\'affaire est sous la barre");
            return false;
        }
        if (income > maxIncome) {
            System.out.println("Chiffre d\'affaire est elèvé");
            return false;
        }
        return true;
    }

    private static int calculateFixedCharges() {
        return officeRentCharge +
            telephonyCharge +
            internetAccessCharge +
            assistantSalary +
            financeManagerSalary;
    }
}

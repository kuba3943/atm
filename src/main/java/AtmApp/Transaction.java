package AtmApp;

import java.time.LocalDate;

public class Transaction {

    private double amount;
    private LocalDate timestamp;
    private String memo;
    private Account inAccount;

    public Transaction(double amount, Account inAccount) {
        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = LocalDate.now();
        this.memo = "";
    }

    public Transaction(double amount, String memo, Account inAccount) {
        this(amount, inAccount);
        this.memo = memo;
    }
}

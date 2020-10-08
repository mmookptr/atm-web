package th.ac.ku.atm.model;

public class Transaction {
    private  int bankaccountId;
    private double amount;
    private String transactiontype;

    public Transaction(int bankaccountId, double amount, String transactiontype) {
        this.bankaccountId = bankaccountId;
        this.amount = amount;
        this.transactiontype = transactiontype;
    }

    public int getBankaccountId() {
        return bankaccountId;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactiontype() {
        return transactiontype;
    }
}

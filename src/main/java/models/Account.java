package models;

public class Account {
    private final String accountName;
    private final String accountBalance;
    private final String accountCurrency;
    private final String accountNumber;
    private final String accountOpenDate;
    private final String accountDescription;
    private final String accountOwner;

    public Account(String accountName, String accountBalance, String accountCurrency, String accountNumber, String accountOpenDate, String accountDescription, String accountOwner) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.accountCurrency = accountCurrency;
        this.accountNumber = accountNumber;
        this.accountOpenDate = accountOpenDate;
        this.accountDescription = accountDescription;
        this.accountOwner = accountOwner;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                ", accountCurrency='" + accountCurrency + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountOpenDate='" + accountOpenDate + '\'' +
                ", accountDescription='" + accountDescription + '\'' +
                ", accountOwner='" + accountOwner + '\'' +
                '}';
    }
}
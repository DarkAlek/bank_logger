package models;

public class Account {
    public final String accountName;
    public final String accountBalance;
    public final String accountCurrency;
    public final String accountNumber;
    public final String accountOpenDate;
    public final String accountDescription;
    public final String accountOwner;

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
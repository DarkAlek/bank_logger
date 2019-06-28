package models;

public class Account {
    private String accountName;
    private String accountBalance;
    private String accountCurrency;
    private String accountNumber;
    private String accountOpenDate;
    private String accountDescription;
    private String accountOwner;

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
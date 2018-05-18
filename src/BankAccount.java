import java.text.NumberFormat;

public class BankAccount {
    // Bank account number id
    private int accountNo;
    // Name of the owner of the bank account
    private String name;
    // The balance of the bank account
    private double balance;

    // Gets the account number
    public int getAccountNo() {
        return accountNo;
    }
    // Gets the name of the bank account
    public String getName() {
        return name;
    }
    // Gets the total balance of the account
    public double getBalance() {
        return balance;
    }

    // Bank Account constructor
    public BankAccount() {
    }
    // Bank Account constructor with parameters
    public BankAccount(int accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        if(balance > 0.0)
            this.balance = balance;
    }
    // A method to withdraw or deposit an amount to the total balance
    public void withdrawOrDeposit(double amount, boolean isWithdraw){
        if(amount > 0.0) {
            if (isWithdraw) {
                balance -= amount;
            } else {
                balance += amount;
            }
        }
    }
    // Returns the account info in a neatly typed string
    public String getAccountInfo(){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return "Account No : " + accountNo +
                "\nName : " + name +
                "\nBalance : " + currencyFormat.format(balance);
    }
}

import javax.swing.*;

public class BankAccountTest {
    public static void main(String[] args) {
        // Banking Menu Options
        Object[] menuOptions = {"Setup Account","Update Account", "Exit App"};
        // Setting up the Message Box
        JFrame frame = new JFrame();
        // Setting up Bank Account initializer
        BankAccount myAccount = new BankAccount();
        // The option integer
        int o;
        // The do-while loop that'll loop until the user presses the exit app button
        do {
            // Sets the value of O from the user's input
            o = JOptionPane.showOptionDialog(frame,
                    "Select your Option",
                    "Bank Account Menu",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, menuOptions, menuOptions[2]);
            // For system command prompts
            System.out.printf("%s Selected",menuOptions[o]);
            // If user selects Setup Account
            if(o == 0){
                myAccount = setupAccount();
                JOptionPane.showMessageDialog(frame,myAccount.getAccountInfo());
            }
            // If user selects update account
            else if(o == 1){
                if(myAccount.getAccountNo() <= 0 || myAccount.getName().isEmpty())
                    JOptionPane.showMessageDialog(frame,"Account has not been setup.");
                else{
                    updateAccount(myAccount, frame);
                    JOptionPane.showMessageDialog(frame,myAccount.getAccountInfo());
                }

            }
        }  while(o != 2);
    } // End of Main

    // A method to setup the Bank account
    public static BankAccount setupAccount(){
        // The setup variables for the account
        int accountNo=0;
        String name="";
        double balance=0;
        // A string array of messages
        String[] messages = {"Enter your Account Number",
        "Enter your Name", "Enter your Balance"};

        // Continually prompts the user to enter information
        for (int x = 0; x < messages.length; x++){
            // Set value of s to the user input
            String s = (String)JOptionPane.showInputDialog(messages[x]);
            // If nothing is typed then repeat the question
            if(s.isEmpty()) x--;
            else{
                if(x == 0) {
                    // Account Number
                    // Try-Catch Exceptions for Account Number
                    try {
                        accountNo = Integer.parseInt(s);
                    } catch (NumberFormatException nfe){
                     x--; // If it isn't a numeric format, repeat the question
                    }
                } else if(x == 1) {
                    // Name
                    name = s; // Name is already a string; no need for exceptions
                } else if (x == 2) {
                    // Balance
                    try{
                        balance = Double.parseDouble(s);
                    } catch (NumberFormatException nfe){
                        x--;
                    }
                }
            }
        }
        // For system command prompts
        System.out.println("Setup Complete");
        // Returns with new information added to the bank account
        return new BankAccount(accountNo,name,balance);
    } // End of setupAccount
    // A method to update the Bank account
    public static void updateAccount(BankAccount aAccount, JFrame aFrame){
        // Banking Update Options
        Object[] updateOptions = {"Withdraw","Deposit","Return"};
        int o = JOptionPane.showOptionDialog(aFrame,
                "Select your Option",
                "Update Bank Account",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,updateOptions,updateOptions[2]);
        // For system command prompts
        System.out.printf("%s Selected",updateOptions[o]);
        if(o != 2){
            String input;
            double amount = 0;
            do{
                input = JOptionPane.showInputDialog("Enter in Amount");

                try{
                    amount = Double.parseDouble(input);
                } catch(NumberFormatException nfe){
                    input = "";
                }

                // Withdraw
                if(o == 0){
                    if(amount > aAccount.getBalance()){
                        JOptionPane.showMessageDialog(
                                aFrame,
                                "Amount is greater than the Total Balance." +
                                        "\nWithdraw cannot be processed.");
                        input="";
                    }
                    else{
                        aAccount.withdrawOrDeposit(amount,true);
                    }
                }
                // Deposit
                else if(o == 1) {
                    aAccount.withdrawOrDeposit(amount,false);
                }
            }while(input.isEmpty());
            System.out.println("Update Complete");
        }
        else{
            System.out.println("Exit Update");
        }
    } // End of updateAccount
}

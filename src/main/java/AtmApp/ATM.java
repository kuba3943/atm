package AtmApp;

import lombok.extern.java.Log;

import java.util.Scanner;

@Log
public class ATM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank theBank = new Bank("kBank");

        User aUser = theBank.addUser("Jakub", "Domagała", "1234");

        Account newAccount = new Account("Checking", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;

        while (true){
            curUser = ATM.mainMenuPrompt(theBank, sc);

            ATM.printUserMenu(curUser, sc);
        }
    }

    private static User mainMenuPrompt(Bank theBank, Scanner sc) {
        String userID;
        String pin;
        User authUser;

        do{
            System.out.printf("\n\n Welcome to %s \n\n", theBank.getName());
            System.out.printf("Enter user ID: ");
            userID = sc.nextLine();
            System.out.printf("Enter pin: ");
            pin = sc.nextLine();

            authUser = theBank.userLogin(userID, pin);
            if (authUser == null){
                System.out.println("Incorrect user ID/pin. " + "Please try again.");
            }
        } while (authUser == null);
        return authUser;
    }
}

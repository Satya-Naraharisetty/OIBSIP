/*

TASK 3 OF THE JAVA PROGRAMMING INTERNSHIP BY OASIS INFOBYTE.

ATM INTERFACE USING JAVA PROGRAMMING LANGUAGE.

*/
import java.util.*;

class UserAccount {
    static void MakingRegistration() {
        Scanner sc = new Scanner(System.in);
        System.out.println("####################################");
        System.out.println("Enter your Name : ");
        String Name = sc.nextLine();
        System.out.println("Enter your Account Number : ");
        Main1.acc_num = sc.nextLine();
        System.out.println("Enter your User Name : ");
        Main1.User_Name = sc.nextLine();
        System.out.println("Enter your Password : ");
        String Pswd = sc.nextLine();
        System.out.println("Your registration has been completed successfully.");
        System.out.println("####################################");
        Main1.NextEvent();

        while (true) {
            show(Main1.User_Name);
            int key = sc.nextInt();
            if (key == 1) {
                login(Name, Pswd);
            } else if (key == 2) {
                System.exit(0);
            } else {
                System.out.println("Invalid entry, Try again");
            }
        }
    }

    static void show(String User_Name) {
    }

    static void login(String Name, String Pswd) {
    }
}

class Depositing {
    static void Deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("####################################");
        System.out.println("Enter Deposit Amount : ");
        int Deposit_value = sc.nextInt();
        Main1.Update_Balance(Deposit_value);
        Main1.Transfer.add("Amount Deposited : ");
        Main1.Transfer.add(Integer.toString(Deposit_value));
        System.out.println("An Amount of " + Deposit_value + "has deposited successfully.");
        System.out.println("####################################");
        Main1.NextEvent();
    }
}

class Withdrawing {
    static void Withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("####################################");
        System.out.println("Enter the Amount to be withdrawn : ");
        int Withdraw_value = sc.nextInt();
        if (Withdraw_value <= Main1.Curr_Bal) {
            Main1.Curr_Bal = Main1.Curr_Bal - Withdraw_value;
            Main1.Transfer.add("Amount withdrawn : ");
            Main1.Transfer.add(Integer.toString(Withdraw_value));
            System.out.println("An Amount of " + Withdraw_value + " was withdrawn successfully.");
            System.out.println("####################################");
        } else {
            System.out.println("Insufficient funds, Please check your balance.");
            System.out.println("####################################");
        }
    }
}

class Transfering {
    static void Transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("####################################");
        System.out.println("Enter the name of Receiver : ");
        String Receiver_Name = sc.nextLine();
        System.out.println("Enter the Account Number of Receiver : ");
        int Rec_Acc_No = sc.nextInt();
        System.out.println("Enter the value of amount to be transferred : ");
        int Transfer_Amount = sc.nextInt();
        if (Transfer_Amount <= Main1.Curr_Bal) {
            Main1.Curr_Bal = Main1.Curr_Bal - Transfer_Amount;
            Main1.Transfer.add("Transferred Amount : ");
            Main1.Transfer.add(Integer.toString(Transfer_Amount));
            System.out.println("An Amount of " + Transfer_Amount + "was transferred to " + Receiver_Name
                    + "with Account number " + Rec_Acc_No + "successfully.");
            System.out.println("####################################");
        } else {
            System.out.println("Insufficient funds, Please check your balance.");
            System.out.println("####################################");
        }
    }
}

class Balance {
    static void Show_Balance() {
        System.out.println("####################################");
        System.out.println("Available amount in your account is : ");
        Main1.Available_Balance();
        System.out.println("####################################");
        Main1.NextEvent();
    }
}

class History {
    static void Transaction_History() {
        System.out.println("####################################");
        System.out.println("Transaction history : ");
        int a = 0;
        if (Main1.Curr_Bal > 0) {
            for (int i = 0; i < (Main1.Transfer.size() / 2); i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.println(Main1.Transfer.get(a) + " ");
                    a++;
                }
                System.out.println("####################################");
            }
        } else {
            System.out.println("Unable to show any transaction history (or) your balance is 0.");
            System.out.println("####################################");
        }
        Main1.NextEvent();
    }
}

public class Main1 {
    public static String User_Name;

    public static int Curr_Bal = 0;

    public static String acc_num;

    public static ArrayList<String> Transfer = new ArrayList<String>();

    static void Update_Balance(int Deposit_value) {
        Curr_Bal = Curr_Bal + Deposit_value;
    }

    static void Available_Balance() {
        System.out.println(Curr_Bal);
    }

    public static void Home() {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("####################################");
        System.out.println("Welcome to Our Bank.");
        System.out.println("####################################");
        System.out.println("Choose one from the below : ");
        System.out.println("####################################");
        System.out.println("1. Register.");
        System.out.println("2. Exit.");
        int key = sc.nextInt();
        if (key == 1) {
            UserAccount.MakingRegistration();
        } else if (key == 2) {
            System.exit(0);
        } else {
            System.out.println("Invalid option. Select either 1 or 2.");
            Home();
        }
    }

    static void NextEvent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + Main1.User_Name + " to ATM.");
        System.out.println("####################################");
        System.out.println("Choose an option : ");
        System.out.println("1. Deposit.");
        System.out.println("2. Withdraw.");
        System.out.println("3. Transfer.");
        System.out.println("4. Check Balance.");
        System.out.println("5. Transaction History.");
        System.out.println("6. Exit.");
        System.out.println("####################################");
        System.out.println("Enter your choice : ");
        int key = sc.nextInt();
        switch (key) {
            case 1:
                Depositing.Deposit();
            case 2:
                Withdrawing.Withdraw();
            case 3:
                Transfering.Transfer();
            case 4:
                Balance.Show_Balance();
            case 5:
                History.Transaction_History();
            case 6:
                System.out.println("Thank you, Visit again.");
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        Home();
    }
}

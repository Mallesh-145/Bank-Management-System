import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Bank {


    static LinkedHashMap<String,Account> Accounts = new LinkedHashMap<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int option;
        boolean flag = true;
        // Loading the database
        LoadDatabase();

        System.out.println("Hello all..........");
        Thread.sleep(3000);
        System.out.println("Welcome to D bank.........");
        Thread.sleep(3000);
        System.out.println("These are the services our bank is providing ....... please select according to your needs......");
        Thread.sleep(3000);

        while (flag) {

            System.out.println("1. Create an Account.................. ");
            Thread.sleep(1000);
            System.out.println("2. Deposit Money in the Account................");
            Thread.sleep(1000);
            System.out.println("3. Withdraw from Account................");
            Thread.sleep(1000);
            System.out.println("4. Check Balance Amount...................");
            Thread.sleep(1000);
            System.out.println("5. Change Name of the Accountant ............................");
            Thread.sleep(1000);
            System.out.println("6. Change Date of Birth...................");
            Thread.sleep(1000);
            System.out.println("7. Change Age of the Accountant...............");
            Thread.sleep(1000);
            System.out.println("8. Details of All users in the bank.................");
            Thread.sleep(1000);
            System.out.println("9. User Details...................");
            Thread.sleep(1000);
            System.out.println("10. Deactivating or Deleting an Account............");
            Thread.sleep(1000);
            System.out.println("11. Exit from the Bank..........................");
            option = sc.nextInt();

            switch (option) {
                // Creating new Account
                case 1:
                    Account NewAccount = new Account();
                    Accounts.put(NewAccount.GetAccountNumber(), NewAccount);
                    System.out.println(NewAccount.GetAccountNumber());
                    System.out.println("Your account is Created Successfully..........");
                    break;
                // Depositing Money in the Account
                case 2:
                    Deposit_Money();
                    break;
                // Withdrawing Money from the Account
                case 3:
                    Withdraw_Money();
                    break;
                // Checking the Total balance in the Account
                case 4:
                    Balance_Enquiry();
                    break;
                // Updating name of the Accountant
                case 5:
                    Update_Name();
                    break;
                // Updating DOB of the Accountant
                case 6:
                    Update_Date_of_Birth();
                    break;
                // Updating Age of the Accountant
                case 7:
                    Update_Age();
                    break;
                // Display the details of all the users in the Bank
                case 8:
                    PrintAllUsers();
                    break;
                // Display the details of the single user
                case 9:
                    PrintUser();
                    break;
                // Deleting or Deactivating the Account
                case 10:
                    DeleteAccount();
                    break;
                // Exiting from the Bank
                case 11:
                    flag = false;
                    try {
                        // Save the data in the 
                        SaveDatabase();
                        // Creating or Opening AccountNumbers File
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("AccountNumbers.txt"));
                        // Writing in to file
                        for(String a : Accounts.keySet())
                        {
                            bufferedWriter.write(a);
                            bufferedWriter.append("\n");
                        }
                        // Closing Resources
                        bufferedWriter.flush();
                        bufferedWriter.close();

                        // Saving AccountCount info into a file
                        Account.SaveAccountCount();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;

            }
        }

    }

    // Function to Deposit money in the Account
    public static void Deposit_Money() throws InterruptedException {

        System.out.println("Enter the id number...............");
        String IdNo = sc.next();
        Thread.sleep(3000);

            if ( Accounts.containsKey(IdNo)) {
                Account curr = Accounts.get(IdNo);
                System.out.println("Enter the Amount you want to deposit in your bank Account..........");
                double DepositAmount = sc.nextDouble();
                Thread.sleep(3000);
                curr.SetBalance(curr.GetBalance()+DepositAmount);
                System.out.println("Money is successfully Deposited in your Account ");
                Thread.sleep(3000);
                System.out.println("The current Balance in your Account is  - "+curr.GetBalance());
            }
            else System.out.println("Account with the Given Id is Not Existed in our Database , Please Try again with a valid Account Number..... ");

        System.out.println("ThankYou for using our Service.............");
        Thread.sleep(3000);
        System.out.println("Would you like to use any of other Services ..........");

    }

    // Function to withdraw money from the Account
    public static void Withdraw_Money() throws InterruptedException {

        System.out.println("Enter the id number...............");
        String IdNo = sc.next();
        Thread.sleep(3000);
        Thread.sleep(3000);

            if(Accounts.containsKey(IdNo))
            {
                Account curr = Accounts.get(IdNo);
                System.out.println("Enter the Amount you want to withdraw from your bank Account..........");
                double WithdrawAmount = sc.nextDouble();
                double Curr_Balance = curr.GetBalance();
                if(Curr_Balance >= WithdrawAmount)
                {
                    curr.SetBalance(Curr_Balance - WithdrawAmount);
                    System.out.println("Money is Withdrawn Successfully........");
                    Thread.sleep(3000);
                    System.out.println("The current Balance in your Account is - "+curr.GetBalance());
                }
                else System.out.println("Your Transaction is terminated due to insufficient funds in your Account.........");
            }
            else System.out.println("Account with the Given Id is Not Existed in our Database , Please Try again with a valid Account Number..... ");

        System.out.println("ThankYou for using our Service.............");
        Thread.sleep(3000);
        System.out.println("Would you like to use any of other Services ..........");

    }

    // Function to Check the balance in the Account
    public static void Balance_Enquiry() throws InterruptedException {

        System.out.println("Enter the Account Number of the Accountant .");
        String AccountNumber = sc.next();
        Thread.sleep(3000);
        if(Accounts.containsKey(AccountNumber))
        {
            Account curr = Accounts.get(AccountNumber);
            System.out.println("Your Current Account Balance - "+curr.GetBalance());
        }
        else System.out.println("Account with the Given Id is Not Existed in our Database , Please Try again with a valid Account Number..... ");

        System.out.println("ThankYou for using our Service.............");
        Thread.sleep(3000);
        System.out.println("Would you like to use any of other Services ..........");

    }

    // Function to update the name of the Accountant
    public static void Update_Name() throws InterruptedException {

        System.out.println("Please Enter your Account Number........");
        String AccountNumber = sc.next();
        Thread.sleep(3000);
        if(Accounts.containsKey(AccountNumber))
        {
            Account curr = Accounts.get(AccountNumber);
            System.out.println("Please Enter the new Name ");
            String new_name = sc.next();
            curr.SetName(new_name);
            System.out.println("New name Updated successfully........");
        }
        else System.out.println("Account with the Given Id is Not Existed in our Database , Please Try again with a valid Account Number..... ");

        System.out.println("ThankYou for using our Service.............");
        Thread.sleep(3000);
        System.out.println("Would you like to use any of other Services ..........");
    }

    // Function to update the DOB of the Accountant
    public static void Update_Date_of_Birth() throws InterruptedException {

        System.out.println("Please Enter your Account Number........");
        String AccountNumber = sc.next();
        Thread.sleep(3000);
        if(Accounts.containsKey(AccountNumber))
        {
            Account curr = Accounts.get(AccountNumber);
            System.out.println("Please Enter the new DOB to update ");
            String new_dob = sc.next();
            curr.SetDOB(new_dob);
            System.out.println("New DOB Updated successfully........");
        }
        else System.out.println("Account with the Given Id is Not Existed in our Database , Please Try again with a valid Account Number..... ");

        System.out.println("ThankYou for using our Service.............");
        Thread.sleep(3000);
        System.out.println("Would you like to use any of other Services ..........");

    }

    // Function to update the Age of the Accountant
    public static void Update_Age() throws InterruptedException {

        System.out.println("Please Enter your Account Number........");
        String AccountNumber = sc.next();
        Thread.sleep(3000);
        if(Accounts.containsKey(AccountNumber))
        {
            Account curr = Accounts.get(AccountNumber);
            System.out.println("Please Enter the new Age to update ");
            int new_age = sc.nextInt();
            curr.SetAge(new_age);
            System.out.println("New Age Updated successfully........");
        }
        else System.out.println("Account with the Given Id is Not Existed in our Database , Please Try again with a valid Account Number..... ");

        System.out.println("ThankYou for using our Service.............");
        Thread.sleep(3000);
        System.out.println("Would you like to use any of other Services ..........");

    }

    // Function to print the details of the all users in the bank
    public static void PrintAllUsers() throws InterruptedException {

        System.out.println("        ----------These are the Details of the All Active users from the Bank----------");
        Thread.sleep(2000);
        System.out.println(" Name        AccountNumber       Age        CurrentBalance\n");
        Thread.sleep(1000);
        if(!(Accounts.isEmpty()))
        {
            for(String a: Accounts.keySet())
            {
                System.out.println(Accounts.get(a));
                Thread.sleep(1000);
            }
        }
        else System.out.println("Currently there are no Active users in this bank Our ..........");

        System.out.println("ThankYou for using our Service.............");
        Thread.sleep(3000);
        System.out.println("Would you like to use any of other Services ..........");
    }

    // Function to print the details of the user
    public static void PrintUser() throws InterruptedException {

        System.out.println("Please Enter the AccountNumber of the User to know the details .........");
        String AccountNumber = sc.next();
        Thread.sleep(3000);
        if(Accounts.containsKey(AccountNumber))
        {
            Account curr = Accounts.get(AccountNumber);
            System.out.println(" Name        AccountNumber       Age        CurrentBalance");
            System.out.println(curr);
        }
        else System.out.println("Account with the Given Id is Not Existed in our Database , Please Try again with a valid Account Number..... ");

    }

    // Function to Delete or Deactivating the Account
    public static void DeleteAccount() throws InterruptedException {
        System.out.println("Enter the AccountNumber of the Account you want to delete........");
        String AccountNumber = sc.next();
        Thread.sleep(3000);
        if(Accounts.containsKey(AccountNumber))
        {
            System.out.println("Are u sure you want to delete this Account Permanently............Please Enter yes or No");
            Thread.sleep(4000);
            String option = sc.next().toLowerCase();
            switch (option) {
                case "yes":
                    Accounts.remove(AccountNumber);
                    System.out.println("The Account has been permanently deleted from the bank database ");
                    Thread.sleep(1000);
                    System.out.println("You are currently been redirecting to the main page");
                    Thread.sleep(5000);
                    break;
                case "no":
                    System.out.println("The transaction is cancelled you are currently redirecting to the main page ");
                    Thread.sleep(5000);
                    break;
            }
        }
        else System.out.println("Account with the Given Id is Not Existed in our Database , Please Try again with a valid Account Number..... ");

    }

    //    ---------------------------File Handling---------------------------------

    // To Load Database in to the system
    public static void LoadDatabase() throws Exception
    {
        try {
            FileInputStream Fis = new FileInputStream("Accounts.ser");
            ObjectInputStream Ois = new ObjectInputStream(Fis);

            // Deserializing the Hashmap
            Accounts = (LinkedHashMap<String, Account>) Ois.readObject();

            // Closing the resources
            Fis.close();
            Ois.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Saving the Data into the Database
    public static void SaveDatabase() {

        try {
            // Creating Or Opening Accounts File
            FileOutputStream fos = new FileOutputStream("Accounts.ser");
            ObjectOutputStream Oos = new ObjectOutputStream(fos);

            // Serializing the Hashmap
            Oos.writeObject(Accounts);

            // Closing the resources
            fos.close();
            Oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = -8191581416873684869L;


    private final String Account_number;
    private String Name;
    private int Age;
    private double Balance;
    private String DOB;
    static int Count ;
    Account()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the Accountant - ");
        this.Name = sc.next().trim();
        System.out.println("Enter the Age of the Accountant - ");
        this.Age = sc.nextInt();
        System.out.println("Enter the Date of birth of the Accountant in the YYYY-MM-DD format - ");
        this.DOB = sc.next();
        LoadAccountCount();
        Count++;
        this.Account_number = LocalDate.now().toString().replace("-","")+Count;
        this.Balance = 0.0;
    }

    // Setters for the Global variables
    public void SetName(String name)
    {
        Name = name;
    }
    public void SetDOB(String dob)
    {
        DOB = dob;
    }
    public void SetAge(int age)
    {
        Age = age;
    }
    public void SetBalance(double balance)
    {
        Balance = balance;
    }

    // Getters gor the Global Variables
    public String GetName()
    {
        return Name;
    }
    public String GetAccountNumber()
    {
        return Account_number;
    }
    public int GetAge()
    {
        return Age;
    }
    public String GetDOB()
    {
        return DOB;
    }
    public double GetBalance()
    {
        return Balance;
    }

    // Overriding toString to print the account details
    public String toString()
    {
        return " "+Name+"        "+Account_number+"      "+Age+"        "+Balance;
    }

    // Writing method to read a file while loading class
    public static void LoadAccountCount()
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("AccountCount.txt"));
            Count = Integer.parseInt(bufferedReader.readLine());
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Writing method to write a file while closing class
    public static void SaveAccountCount()
    {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("AccountCount.txt"));
            bufferedWriter.write(Count+"");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
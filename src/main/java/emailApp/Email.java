package emailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 1000;
    private int defaultPasswordLength = 12;
    private String alternateEmail;
    private String companydomain = "TADEON.COM";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
//        System.out.println("Name : " + this.firstName + " " + this.lastName);

        this.department = setDepartment();
//        System.out.println("Department: " + this.department);

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        email = firstName.toLowerCase()+ "." + lastName.toLowerCase()+ "@"+ department +"."+ companydomain.toLowerCase();
        System.out.println("Your email addess is: " + email);
    }

    private String setDepartment() {
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting \n0 for none\nEnter your department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    //Generating random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        char[]password = new char[length];
        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }return new String(password);
    }

    public void  setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    public void changePassword(String password){
        this.password= password;
    }

    public int getMailboxCapacity(){ return mailboxCapacity; }
    public  String getAlternateEmail(){ return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return "Display Name: " + firstName + " "+ lastName + " "+
                "\nCompany email: " + email +" " +
                "\nMailbox capacity: " + mailboxCapacity + "mb";
    }

}

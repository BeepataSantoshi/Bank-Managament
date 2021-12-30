import java.util.Scanner;
class Bank{
	private String accno;
	private String name;
	private long Balance;
	Scanner sc=new Scanner(System.in);
	//method to open an account
	void openAccount() {
		System.out.println("Enter Account no:");
		accno=sc.nextLine();
		System.out.println("Enter Account Holder name:");
		name=sc.nextLine();
		System.out.println("Enter Balance:");
		Balance=sc.nextLong();
	}
	//method to display account details
	void showAccount() {
		System.out.println(accno+","+name+","+Balance);
	}
	//method to deposit money
	void deposit() {
		long amount;
		System.out.println("Enter the Amount u want to deposit: ");
		amount=sc.nextLong();
		Balance=Balance+amount;
	}
	//method to withdraw money
	void withdrawal() {
		long amount;
		System.out.println("Enter the Amount u want to withdraw: ");
		amount=sc.nextLong();
		if(Balance>=amount) {
			Balance=Balance-amount;
		}
		else
		{
			System.out.println("Less Balance...Transaction Failed.");
		}
	}
	//method to search an account number
	boolean search(String acc) {
		if(accno.equals(acc)) {
			showAccount();
			return(true);
		}
		return(false);
	}
}
public class BankManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
System.out.println("How many customers u want to input: ");
int n=sc.nextInt();
Bank c[]=new Bank[n];
for(int i=0;i<c.length;i++) {
	c[i]=new Bank();
    c[i].openAccount();	
}
int ch;
do {
	System.out.println("Main Menu\n 1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.Exit ");
    System.out.println("Ur Choice :");
    ch = sc.nextInt();
    switch(ch){
    case 1:
    	for(int i=0;i<c.length;i++) {
    		c[i].showAccount();
    	}
    	break;
    case 2:
    	System.out.print("Enter Account No. u want to serach:");
    	String acn=sc.next();
    	boolean found=false;
    	for(int i=0;i<c.length;i++) {
    		found=c[i].search(acn);
    		if(found) {
    			break;
    		}
    	}
    	if(!found) {
    		System.out.println("Search Failed...Account doesn't Exist ");
    	}
    	break;
    case 3:
    	System.out.print("Enter Account No:");
          acn=sc.next();
    	 found=false;
    	for(int i=0;i<c.length;i++) {
    		found=c[i].search(acn);
    		if(found) {
    			c[i].deposit();
    			break;
    		}
    	}
    	if(!found) {
    		System.out.println("Search Failed...Account doesn't Exist ");
    	}
    	break;
    case 4:
    	System.out.print("Enter Account No:");
        acn=sc.next();
  	 found=false;
  	for(int i=0;i<c.length;i++) {
  		found=c[i].search(acn);
  		if(found) {
  			c[i].withdrawal();
  			break;
  		}
  	}
  	if(!found) {
  		System.out.println("Search Failed...Account doesn't Exist ");
  	}
  	break;
    case 5:
    	System.out.println("Good Bye...");
    }
}while(ch!=5);
	}

}

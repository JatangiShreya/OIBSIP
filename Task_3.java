import java.util.*;
class NotFoundException extends Exception
{
	public String toString()
	{
		return "Invalid Password or Username";
	}
}
class MinBalanceException extends Exception
{
	public String toString()
	{
		return "Insufficient Balance";
	}
}
class TransferBalanceException extends Exception
{
	public String toString()
	{
		return "Insufficient Balance";
	}
}
interface bank{

	public void Details(String Username,String Password) throws NotFoundException;
	void Deposit(double balance);
	public void Withdraw(double balance) throws MinBalanceException;
	void displayBalance();
	void Quit();
	public void Transfer(double balance,long acc) throws TransferBalanceException;
}
class Customer implements bank
{
	String username[]=new String[10];
	String password[]=new String[10];
	double total;
	int flag=0;
	Customer(double cash)
	{
		total=cash;
	}
	public void Details(String u,String p) throws NotFoundException
	{
		int i,j,flag1=0,flag2=0;
		for(i=0;i<username.length;i++)
		{
			if(u.equals(username[i]))
			{
				flag1=1;
			}
		}
		for(j=0;j<password.length;j++)
		{
			if(p.equals(password[j]))
			{
				flag2=1;
			}
		}
		if(flag1==0 || flag2==0)
		{
			throw new NotFoundException();
		}
		System.out.println("Password and Username matched");
		flag=1;
	}
	public void Deposit(double balance)
	{
		System.out.println(balance+" deposited succesfully");
		total=total+balance;
	}
	public void Withdraw(double balance) throws MinBalanceException
	{
		if(balance>total)
		{
			throw new MinBalanceException();
		}
		System.out.println(balance+" withdraw succesfully");
		total=total-balance;
	}
	public void displayBalance()
	{
		System.out.println("Your current bank balance is: "+total);
	}
	public void Quit()
	{
			System.out.println("Excited");
	}
	public void Transfer(double balance,long acc) throws TransferBalanceException
	{
		if(balance>total)
		{
			throw new TransferBalanceException();
		}
		System.out.println("Amount transfered succesfully");
		total=total-balance;
	}	
}
class Task_3
{
	public static void main(String args[])
	{
		System.out.println("WELCOME TO SBI ATM");  
        System.out.println("__________________");

		Scanner sc=new Scanner(System.in);
		Customer c=new Customer(0);
		List<String> li=new LinkedList<String>();
		Date d=new Date();
		String u,p;
		int s,z=0,se;
		long acc;
		do
		{
			System.out.println("1.New Account \n 2.Login \n 3.Exit");
            System.out.print("Choose the operation you want to perform:"); 
            se=sc.nextInt();
            if(se==1)
            {
            	System.out.print("Enter new Username : ");
                c.username[z]=sc.next();
            	System.out.print("Enter password : ");
            	c.password[z]=sc.next();
            	z++;
            }
            else if(se==2)
            {
            	System.out.println("Enter your details: ");
            	System.out.println("Enter your Username: ");
            	u=sc.next();
            	System.out.print("Enter your password : ");
            	p=sc.next();
            	try
            	{
            		c.Details(u,p);
            	}
            	catch(NotFoundException e)
            	{
            		System.out.println(e);
            	}
            	if(c.flag==0)
            	{
            		System.out.println("Try Again!");
            	}
            	else
            	{
            		int ch;
            		double b;
                    do
                    {
                    	System.out.println("********************");
                    	System.out.println("Automated Teller Machine");  
                        System.out.println("Choose 1 for Transaction History");
                        System.out.println("Choose 2 for Withdraw");  
                        System.out.println("Choose 3 for Deposit");
                        System.out.println("Choose 4 for Transfer");  
                        System.out.println("Choose 5 for Check Balance");  
                        System.out.println("Choose 6 for EXIT\n");  
                        System.out.print("Choose the operation you want to perform:"); 
                        ch=sc.nextInt();
                        switch(ch)
                        {
                        	case 1: 
                                   System.out.println("Transaction History");  
                                   for(String mm:li)
                                   {
                                   	System.out.println(li);
                                   	break;
                                   }
                                   break;

  
                            case 2:  
                                   System.out.print("Enter money to be withdrawn:");  
                                   b=sc.nextDouble();  
                                   try
                                   {
                                   	    c.Withdraw(b);
                                   	    li.add("Withdraw"+b+" "+d.toString()); 
                                   	    break;
                                   } 
                                   catch(MinBalanceException e)
                                   {
                                   	    System.out.println(e);
                                   	    break;
                                   }  
                
                            case 3:  
                                   System.out.print("Enter money to be deposited:");  
                                   b = sc.nextDouble();  
                                   c.Deposit(b);
                                   li.add("Deposited"+b+" "+d.toString());
                                   System.out.println("");  
                                   break; 

                            case 4:
                                   System.out.println("Enter Account number which you want to transfer");
                                   acc=sc.nextLong();
                                   System.out.println("Enter Amount you want to transfer");
                                   b=sc.nextDouble();
                                   try
                                   {
                                   	    c.Transfer(b,acc);
                                   	    li.add("transfered"+b+" "+d.toString()); 
                                   	    break;
                                   } 
                                   catch(TransferBalanceException t)
                                   {
                                   	    System.out.println(t);
                                   	    break;
                                   }   
                                   
   
                            case 5:  
                                   c.displayBalance();
                                   li.add("Balance "+d.toString());
                                   break; 

   
                            case 6:   
                                   c.Quit();
                                   break;
                            default:
                                   System.out.println("Invalid Choice");
                                   break; 
                        }
                    }
                    while(ch!=6);
            	}

            }
            else
            {
                System.out.println("Excited");
            }
            
        }
        while(se!=3);
	}

}
import java.util.*;
import java.util.Random.*;
class Task2
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int c=0,s=0,f=0,l=0;
		double r,n;
		
		System.out.println("The system generated a random number.");
		r=Math.ceil(Math.random()*100);

        System.out.println("Enter the number of limits: ");
        l=sc.nextInt();

	    while(l>0){
			System.out.println("Enter your number: ");
		    n=sc.nextInt();
			if(n==r){
				s=s+100;
				System.out.println("Generated number is "+r);
				System.out.println("your guess correct!");
				System.out.println("your score : "+s);
				f=1;
				break;
			}
			else if(n>r){
				System.out.println("The number is lesser than "+n);
				l--;
				s=s-10;
			}
			else if(n<r){
				System.out.println("The number is greater than "+n);
				l--;
				s=s-10;
			}
		}
		if(f==0){
			System.out.println("Generated number is "+r);
			System.out.println("your unable to guess!");
	        System.out.println("your score "+s+ "out of 100");
	    }
	}
}
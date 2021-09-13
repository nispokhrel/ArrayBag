/**
 * Name: Nishant Pokhrel 
 * Date: September 12, 2021 
 * Subject: CS 216- Data Structures & Algorithms 
 * Assignemt: Week02 
 * Purpose: This program selects n number of integers
 * in the range 1 to m and matches with the user's guess.
 * @author npokhrel
 */
import java.util.*;

public class ArrayBagAssignment {

	//creating displayBag method to print items stored in a bag
		private static void displayBag(ArrayBag<Integer> rBag)
		{
			Object[] bArray = rBag.toArray();
			for(int index = 0; index < bArray.length; index++)
			{
				System.out.print(bArray[index] +" ");
			}
			System.out.println(" ");
			
			

		}
		
	public static void main(String[] args) {

		int m; // Max value in the range 1 to m
		int n; // numbers of integers to be selected from the set range
		int rNumbers; //to hold the generated random numbers
		int gNumbers; // to hold the user inputed guess
		String cont="Yes"; //user input to continue the game
		int check=1; //checker for the game continuation
		
		// Creating scanner object to record user input
		Scanner input = new Scanner(System.in);

		// creating random class object
		Random rand = new Random();
		
		//Creating bags to hold items
		ArrayBag<Integer> rBag= new ArrayBag(); //Bag that holds generated random numbers
		ArrayBag<Integer> gBag= new ArrayBag(); // Bag that holds user's guess
		

		System.out.print("Enter the value(m) for the range(1 to m): ");
		m = input.nextInt(); //storing the user input value for maximum value

		System.out.print("Enter the number of intergers(n) you want to choose from the range: ");
		n = input.nextInt(); //storing the user input value for number of integers to be selected


		// Generating random numbers in the user-inputed range  using for loop
		for (int index = 0; index < n; index++) 
		{
			rNumbers=rand.nextInt(m)+1;
			//System.out.println(rNumbers); 
			rBag.add(rNumbers);
		

		} 
		
		//Running a do-while loop 
		do
		{
			
			if (check==0)
			{
				System.out.println("*********************************");
				
				//repeating the same process for user input as above
				System.out.print("Enter the value(m) for the range(1 to m): ");
				m = input.nextInt();

				System.out.println("Enter the number of intergers(n) you want to choose from the range: ");
				n = input.nextInt();
				
				//Creating a for loop to generate random numbers and storing  it in the bag
				for (int index=0; index<n; index++)
				{
					rNumbers=rand.nextInt(m)+1;
					rBag.add(rNumbers);
				}
			}
			
			check=0;
			
			//Storing the user guess for and matching it with generated random numbers 
			if(check<n)
			{
				System.out.println("Enter " + n +" numbers of your choice in the range from 1 to " + m + ". ");
				
				//using for loop to store user-inputed guess for the random number
				for(int index=0; index<n; index++)
				{
					System.out.print(" Guess " + (index+1) + " : ");
					gNumbers=input.nextInt();
					gBag.add(gNumbers); //storing user guess in the bag gBag
					
					//matching user guess with that of random numbers stored in a bag rBag
					if (rBag.contains(gNumbers))
					{
						check++;
					}
				}
				
				//Checking success count
				if ( check==n)
				{
					System.out.println(" ");
					System.out.println("Your guess is correct. You are genius. ");
					System.out.println("*******************************************");
					System.out.print("Generated random numbers were: ");
					displayBag(rBag); //displaying the generated random numbers, stored in a bag rBag
					
					
					System.out.println("Do you want to continue the guess, Yes or No ??");
					cont=input.next();
					check=0;
					rBag.clear();
					
				}
				else if (check<n)
				{
					System.out.println(check + " of your guesses are correct. ");
					check=1;
					gBag.clear();
				}
			}
			
			
		}while(cont.equalsIgnoreCase("Yes"));
		
		input.close(); //closing scanner
		System.out.println("Thank you for playing the guessing game.");
		System.exit(0); // terminating the running java virtual machine
		

	}
	
       
}

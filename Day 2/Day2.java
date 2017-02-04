/** Zack Peters
1/30/17
Advent of Code


Elves class will read the text file for the dimensions
convert the numbers to integer, find the two smallest
and determine the amount of wrapping paper
needed. 

*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2 {
	
	public static void main(String[] args)throws FileNotFoundException{
		
	presents();
	
	}
	




	/**
	@param N/A 
	@return void
	@throws-FileNotFoundException
	*/
	public static void presents() throws FileNotFoundException {
		
		String dimensions;
		String[] data;
		String length = ""; 	//empty string in order to gurantee to enter the loop
		String width = "";
		String height = "";
		int min1 = 200;			//set min to high number
		int min2 = 200;			// set min2 to a high number
		int calc = 0;
		int total = 0;

		int ribonTotal = 0;
		
		Scanner fileInput = new Scanner(new File("text1.txt"));	//new scanner		
		
		while(fileInput.hasNext()) {		//continue until each line does not have a next
			dimensions = fileInput.nextLine();
			data = dimensions.split("x");			//split the data on the 'x'
			
			min1 = 200;		//reset min 
			min2 = 200;
			
			for(String s_dim: data){
				length = data[0];	//get each dimension
				width = data[1];
				height = data[2];
			}
			int length1 = Integer.parseInt(length);
			int width1 = Integer.parseInt(width);
			int height1 = Integer.parseInt(height);


			//determine the two minimum numbers out of the three
			if (length1<=width1 && length1<=height1){
				min1 = length1;
			}
			if ((length1<=width1 && length1>=height1)||(length1>=width1 && length1<=height1)){
				min2 = length1;
			}
			if (width1<=length1 && width1<=height1){
				min1 = width1;
			}	
			if ((width1<=length1 && width1>=height1)||(width1>=length1 && width1<=height1)){
				min2 = width1;
			}	
			if (height1<=length1 && height1<=width1){
				min1 = height1;
			}	
			if ((height1<=length1 && height1>=width1)||(height1>=length1 && height1<=width1)){
				min2 = height1;
			}

			calc = (2*length1*width1+2*width1*height1+2*height1*length1);		//calculate the amount needed
			calc = calc+(min1*min2);			//add the extra space needed
				

			ribonTotal =  ribonTotal + ((min1+min1) + (min2+min2));	//find ribon needed
			ribonTotal = ribonTotal + (length1*width1*height1);

			
		
			total = total+calc;

			
		}
		System.out.println(total);				//print the total wrapping paper needed
		System.out.println(ribonTotal);		// print the total ribontotal
	
	}
}	




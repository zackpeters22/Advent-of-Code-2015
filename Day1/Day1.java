//Zack Peters 
//2/1/17
//Advent of Code Day 1
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1 {

	public static void main(String[] args) throws FileNotFoundException{

		int floorNum = santaFloor();
		System.out.println(floorNum);
	}
	public static int santaFloor()throws FileNotFoundException{

		int floorNum = 0;
		String data = "";
		char paren = 'f';
		
		int position = 0;

		Scanner fileRead = new Scanner(new File("test1.txt"));
		while(fileRead.hasNext()) {		//continue until each line does not have a next
			data = fileRead.nextLine();
			
			//loop through string of directions to get individual parenthese
			
			for (int i = 0; i < data.length(); i++){
				paren = data.charAt(i);
		
				if (paren == '('){
					floorNum = floorNum+1;
					position += 1;
				}
				
				else if (paren == ')'){
					floorNum = floorNum-1;
					position += 1;

				}

				if (floorNum == -1){
					System.out.println(position);
				}

			}
		}

	return floorNum;	
	}

}

package labPartnerPicker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Sorter {
	public static void main(String[] args){
		String fileName = "src/labPartnerPicker/allMembers.txt";
		BufferedReader buffer;
		
		try {
			FileReader reader = new FileReader(fileName);
			buffer = new BufferedReader(reader);
			
			List<String> members = new ArrayList<String>();
			
			String line = null;
			while( (line = buffer.readLine()) != null){
				members.add(line.toLowerCase());
			}
			
			System.out.println("Here are the lab partners for this week: ");
			System.out.println("");
			
			int halfSize = members.size() /2 ;
			
			for(int i = 0; i < halfSize; i++){
				int partner1Index = (int)(Math.random() * members.size());
				int partner2Index = (int)(Math.random() * members.size());
				while(partner1Index == partner2Index){
					partner2Index = (int)(Math.random() * members.size());
				}
				System.out.print( members.get(partner1Index) + " : " + members.get(partner2Index) );
				if( partner1Index < partner2Index ){
					members.remove(partner1Index);
					members.remove(partner2Index-1);
				} else {
					members.remove(partner2Index);
					members.remove(partner1Index-1);
				}
				
				if(i == (halfSize-1) && members.size() != 0){
					System.out.println(" : " + members.get(0));
				}
				System.out.println("");
				System.out.println("");
			}
			
			
			buffer.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("a file was not found");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}

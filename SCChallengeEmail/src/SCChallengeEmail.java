import java.net.*;
import java.io.*;


public class SCChallengeEmail {

	public static void main(String[] args) throws Exception{

		//Gets user input and saves to var input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter ID: ");
	    String input = reader.readLine();
	    reader.close();
	    
	    
	    String address = ("http://www.ecs.soton.ac.uk/people/"+ input);
	    URL website = new URL(address);
	    
	    BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));
	    String inputLine;
	    
	    String titleLine = "";
	    
	    //Loops through text and saves line that contains "<title>" to var titleLine
	    while ((inputLine = in.readLine()) != null) {
	    	if(inputLine.toLowerCase().contains("<title>")){
	    		titleLine = inputLine;
	    	}
	    }
	    in.close();
	    
	    //Gets substring from titleLine using the indexs of the <,> symbols
	    int index1 = titleLine.indexOf('>', 0);
	    int index2 = titleLine.indexOf('|', 10);
	    String name = titleLine.substring(index1+1, index2-1);
	    System.out.println("Name: " + name);
	    
	    
	}

}

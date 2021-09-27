/**
 * This class is the user interface class that handles reads the input commands of the client 
 * and requests the appropriate functions to be performed
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {
	
	private Scanner inputObj;				//Scanner object to store the input
	private String inputString;				//String value of the input scanner object 
	private StringTokenizer input;			//Tokenized input value
	String command;							//Input Command requested by the user
	public static Collection collection;	//a collection object that stores albums 

	/**
	 * This method reads the input command and calls the method readInput()
	 * to perform necessary actions on the collection
	 */
	public void run() {
		
		System.out.println("Collection Manager starts running");
		System.out.println();
		
		collection = new Collection();
		
		//Loop that keeps running until command is "Q"
		do {
			
			try {	
			
				inputObj = new Scanner(System.in);			
		
				inputString = inputObj.nextLine();	
				
				//Input String is Tokenized by the delimiter ","
				input = new StringTokenizer(inputString, ",");		
		 		
				//gets the input command
				command = input.nextToken();
		 
				readInput();
		 
			} catch(Exception e){
			
				System.out.println("Invalid command!");
			
			}
		 
		} while(!command.equals("Q"));
		
		System.out.println("Collection Manager Terminated");		
		
	}
	
	/**
	 * A private method that handles necessary functions (add, remove, lend, return, print) 
	 * to be called as per the command
	 */
	private void readInput(){
		
		switch(command) {
		case "A":							//Add album
				 addCommand();
				 break;
		
		case "D":							//Delete album
				 deleteCommand();
				 break;
				 
		case "L":							//Lend album
				 lendCommand();
				 break;
	
		case "R":							//Return album
				 returnCommand();
				 break;
	
		case "P":							//Display collection without specifying the order
				 collection.print();
				 break;
			
		
		case "PD":							//Display the collection sorted by the release dates
				 collection.printByReleaseDate();
				 break;
		
		case "PG":							//Display the collection sorted by the genres
				 collection.printByGenre();
				 break;
			
		
		default:
			
			System.out.println("Invalid Command!");
			
		}
		
		return;
	}
	
	/**
	 * A private method that creates an Album object
	 * and checks if the input attributes are valid to add the album to
	 * the collection. 
	 * Calls Collection.add(Album album) from the Collection class. 
	 */
	private void addCommand() {
		
		//creates the attributes of album
		String newTitle = input.nextToken();
		String newArtist = input.nextToken();
		String newGenreString = input.nextToken();
		Date newReleaseDate = new Date(input.nextToken());
		
		//Checks if the Date entered is Valid. 
		if(!newReleaseDate.isValid()) {
			System.out.println("Invalid Date!");
			return;
		}
		
		Genre newGenre;
		
		//Creates a Genre object based on the input value
		
		if (newGenreString.equals("Classical") || newGenreString.equals("classical")) {	
			newGenre = Genre.Classical;				
		}
		else if (newGenreString.equals("Country") || newGenreString.equals("country")) {	
			newGenre = Genre.Country;
		}
		else if (newGenreString.equals("Jazz") || newGenreString.equals("jazz")) {	
			newGenre = Genre.Jazz;
		}
		else if (newGenreString.equals("Pop") || newGenreString.equals("pop")) {	
			newGenre = Genre.Pop;
		}
		else {
			newGenre = Genre.Unknown;
		}
		
		//Instantiates a new Album Object called newAlbum
		Album newAlbum = new Album(newTitle, newArtist, newGenre, newReleaseDate, true);
		
		//Adds the new album to the collection
		if (collection.add(newAlbum)) { 
			System.out.println(newAlbum.toString() + " >> added");
		}
		else {
			System.out.println(newAlbum.toString() + " >> is already in the collection");
		}
		
		return;
		
	}
	
	/**
	 * Creates an new temporary album object with the input attributes and passes them to 
	 * Collection.remove(Album album) method to remove the album from the collection
	 */
	private void deleteCommand() {
		
	
		String title = input.nextToken();
		String artist = input.nextToken();
		Album delAlbum = new Album(title, artist);
		
		if (collection.remove(delAlbum)) {
			System.out.println(title + "::" + artist + " >> deleted");
		}
		else {
			System.out.println(title + "::" + artist + " >> is not in the collection");
		}
		
		return;
		
	}
	
	/**
	 * This method creates a new temporary album object with the given attributes 
	 * and passes it to Collection.lend(Album album) method 
	 */
	private void lendCommand() {
		
		String title = input.nextToken();
		String artist = input.nextToken();
		Album lendAlbum = new Album(title, artist);
		
			
			if (collection.lendingOut(lendAlbum)) {
				System.out.println(title + "::" + artist + " >> lending out and set to not available");
			}
			else {
				System.out.println(title + "::" + artist + " >> is not available");
			}
	}
	
	/**
	 * This method creates a temporary album object with the given attributes 
	 * and passes it to Collection.returnAlbum(Album album) method. 
	 */
	private void returnCommand() {
		
		String title = input.nextToken();
		String artist = input.nextToken();
		Album returningAlbum = new Album(title, artist);
			
			if (collection.returnAlbum(returningAlbum)) {
				System.out.println(title + "::" + artist + " >> returing and set to available");
			}
			else {
				System.out.println(title + "::" + artist + " >> return cannot be completed");
			}
		
	}	
	
}

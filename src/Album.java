/**
 * This class defines the abstract data type album, and it encapsulates the methods and data relevant to each album object.
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

public class Album {

	private String title;
	private String artist;
	private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown 
	private Date releaseDate;
	private boolean isAvailable; 
	
	/**
	 * Checks if two Album objects are equal by comparing their titles and artists
	 */
	@Override
	public boolean equals(Object obj) { 
		
		if (obj instanceof Album) {
			
			Album tempAlbum = (Album) obj;
			
			return (this.title.equals(tempAlbum.title) && this.artist.equals(tempAlbum.artist));
		}
		
		return false;
	}
	
	/**
	 * Prints out the Album object's data fields in a neatly formatted string, separating each data field with "::"
	 * @return String format of Album Object
	 */
	@Override
	public String toString() { 
		final String buffer = "::"; 
		
		String tempString = this.title + buffer + this.artist + buffer + this.genre + buffer + releaseDate.toString() + buffer;
		
		if (this.isAvailable) {
			
			tempString += "is available";
		}
		else {
			
			tempString += "is not available";
		}
		
		return tempString;
	}
	
	/**
	 * This is the constructor method for Album Class;
	 * Creates an Album object with the given parameters as its data fields
	 * @param title
	 * @param artist
	 * @param genre
	 * @param releaseDate
	 * @param isAvailable
	 */
	public Album(String title, String artist, Genre genre, Date releaseDate, boolean isAvailable) {
		
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.isAvailable = isAvailable;	
	}
	
	/**
	 * Another Constructor for Album class. 
	 * Creates and Album object with the given parameters as its data fields
	 * This method uses Constructor overloading.
	 * @param title
	 * @param artist
	 */
	public Album(String title, String artist) {
		
		this.title = title;
		this.artist = artist;
	}
	
	/**
	 * Getter method for album genre
	 * @return genre of album
	 */
	public Genre getGenre() {
		
		return this.genre;
	}
	
	/**
	 * Getter method for album release date
	 * @return release date of album
	 */
	public Date getReleaseDate() {
		
		return this.releaseDate;
	}
	
	/**
	 * Getter method for album status
	 * @return true if Album is available, false if not
	 */
	public boolean getStatus() {
		
		return this.isAvailable;
	}
	
	/**
	 * Setter method for album status
	 * @param status (true if album is being set to available, false if it is being set to unavailable)
	 * @return status (true if album has just been set to available, false if it has just been set to unavailable)
	 */
	public boolean setStatus(boolean status) {
		
		this.isAvailable = status;
		return status;
	}
	
}

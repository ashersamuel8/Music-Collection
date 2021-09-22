
public class Album {

	private String title;
	private String artist;
	private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown 
	private Date releaseDate;
	private boolean isAvailable; 
	
//	public enum Genre {
//        Classical, Country, Jazz, Pop, Unknown;
//    }
	
	@Override
	public boolean equals(Object obj) { 
		if (obj instanceof Album) {
			Album tempAlbum = (Album) obj;
			
			return (this.title.equals(tempAlbum.title) && this.artist.equals(tempAlbum.artist));
		}
		
		return false;
	}
	
	@Override
	public String toString() { 
		final String buffer = "::"; 
		
		String tempString = this.title + buffer + this.artist + buffer + this.genre + buffer + this.releaseDate.toString() + buffer;
		
		if (this.isAvailable) {
			tempString += "is available";
		}
		else {
			tempString += "is not available";
		}
		
		return tempString;
	}
	
	public Album(String title, String artist, Genre genre, Date releaseDate, boolean isAvailable) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.isAvailable = isAvailable;	
	}
	
	public Album(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	public String getTitle() {
		
		return this.title;
		
	}
	public String getArtist() {
		
		return this.artist;
	}
	public Genre getGenre() {
		
		return this.genre;
		
	}
	public Date getReleaseDate() {
		
		return this.releaseDate;
		
	}
	public boolean getStatus() {
		
		return this.isAvailable;
		
	}
	public boolean setStatus(boolean status) {
		
		this.isAvailable = status;
		
		return status;
	}
	
}

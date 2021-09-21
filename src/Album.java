
public class Album {

	private String title;
	private String artist;
	private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown private 
	Date releaseDate;
	private boolean isAvailable; 
	
	
	@Override
	public boolean equals(Object obj) { }
	
	@Override
	public String toString() { }
	
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
	
	public String getTitle(Album album) {
		
		return album.title;
		
	}
	public String getArtist(Album album) {
		
		return album.artist;
	}
	public boolean getStatus(Album album) {
		
		return album.isAvailable;
		
	}
	
	
}

/**
 * This is the container class which creates a song library and manages the operations (add, remove, lend, return, print)
 * on the collection. This class uses an array list to store albums in the Collection. 
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */
public class Collection {
	
	private Album[] albums;		//An array list to store albums		
	private int numAlbums;   	
	
	/**
	 * A private method to return the index of a given album in the albums Array List 
	 * @param album
	 * @return index of the album in the Collection Array List
	 */
	private int find(Album album) {		
		
		int albumIndex = -1;
		for ( int i = 0; i < albums.length; i++ ) {
			
			if (albums[i] == null) break;
			
			if (album.equals(albums[i])) {
				
				albumIndex = i;
				break;
				
			}
			
		}
		
		return albumIndex;
		
	} 
	
	/**
	 * A method to grow the albums array list by a capacity of 4.
	 * The array list does not shrink in size.
	 */
	private void grow() {				
		
		Album[] buffArray = new Album[albums.length + 4];
		
		for (int i = 0; i < albums.length; i++) {
			
			buffArray[i] = albums[i];
			
		}
		
		albums = buffArray;
		
	} 
	
	/**
	 * A method to add an album to the Collection. This method checks if the album already
	 * exists in the albums array list. If the album already exists, the new album is not added. 
	 * @param takes an album to be added to the Collection
	 * @return true if the album is added, false otherwise
	 */
	public boolean add(Album album) {
		
		boolean exists = false;
		
		//Checks if the album exists in the albums array list 
		for (int i = 0; i < albums.length; i++) {
			
			if (albums[i] == null) break;
			
			if(albums[i].equals(album)) {
				exists = true;
				break;
			}
			
		}
		
		//Adds album to the Collection if it doesn't exist
		if ( exists == false ) {
		
			if ( numAlbums == albums.length ) {
				
				//Grows size if the albums array list is full
				grow();
				albums[numAlbums] = album;
				numAlbums++;
			
			}
			else {
				
				albums[numAlbums] = album;
				numAlbums++;
				
			}
			
		}
		
		return !exists;
		
	}
	
	/**
	 * A method to remove an album from the Collection.
	 * @param album
	 * @return true if the album is removed, false otherwise 
	 */
	public boolean remove(Album album) {
		
		
		boolean exists = false;
		int albumIndex = 0;
		
		//Checks if the album already exists
		for ( int i = 0; i < albums.length; i++ ) {
			
			if ( albums[i] == null ) break;
			
			if( albums[i].equals(album)) {
				
				exists = true;
				albumIndex = i;
				break;
				
			}
			
		}
		
		//Removes album if it exists and rearranges the albums array list
		if (exists == true) {
			
			for (int i = albumIndex + 1; i < albums.length; i++ ) {
				
				albums[i-1] = albums[i];
					
			}	
			numAlbums--;
			
		}
		
		return exists;
		
	}
	
	/**
	 * A method to lend out an album requested. When the album is lent out,
	 * this method sets the availability of the album to false. 
	 * @param album
	 * @return true if album is lent out, false otherwise
	 */
	public boolean lendingOut(Album album) {			
		
		
		int albumIndex = find(album);
		
		//Returns false if album does not exist or album is not available
		if(albumIndex == -1 || albums[albumIndex].getStatus() == false) return false;
	
		else {
			
			albums[albumIndex].setStatus(false);
			return true;
			
		}	
		
	} 
	
	/**
	 * This method to return the album given. This method sets the availability 
	 * of the returned album to true( which means the album is available). 
	 * @param album
	 * @return true if album is successfully returned, false otherwise
	 */
	public boolean returnAlbum(Album album) {			
		
		int albumIndex = find(album);
		
		//Checks if album exists in the Collection
		if(albumIndex == -1) return false;
		
		//if Album exists and is not available, return false
		if (albums[albumIndex].getStatus() == true) return false;
		
		else {
			
			albums[albumIndex].setStatus(true);
			return true;
				
		}
		
	} 
	
	/**
	 * A method to print out the Collection in an unspecified order
	 */
	public void print() {	
		
		if (albums[0] == null ) {
			System.out.println("Collection is Empty");
			return;
		}
		
		System.out.println("*List of albums in the Collection.");
		
		for(int i = 0; i < albums.length; i++) {
			
			if (albums[i] == null) break;
			
			System.out.println(albums[i].toString());	
			
		}	
		
		System.out.println("*End of list");
		return;
		
	}
	
	/**
	 * A method to print out the Collection that is sorted by release dates (oldest to latest) 
	 */
	public void printByReleaseDate() {
		
		if (albums[0] == null ) {
			System.out.println("Collection is empty");
			return;
		}
		
		//Sorts the albums array list by release date
		for( int i = 0; i < albums.length; i++ ) {
			
			if (albums[i] == null) break;
			
		    for( int j=0; j < albums.length - 1; j++ ) {
		    	
		    	if(albums[j] == null || albums[j+1] == null) break;
		    	
		        if( albums[j].getReleaseDate().compareTo(albums[j+1].getReleaseDate()) > 0 ) {
		        	
		            Album temp = albums[j];
		            albums[j] = albums[j+1];
		            albums[j+1] = temp;
		       }
		    }
		}
		
		System.out.println("*Album Collection by release dates.");
		
		//Prints out the albums array list
		for (int i = 0; i < albums.length; i++) {
			
			if (albums[i] == null) break;
			
			System.out.println(albums[i].toString());
			
		}	
		
		System.out.println("*End of list");
		return;
		
		
	}
	
	/**
	 * A method to print the Collection sorted by genres
	 */
	public void printByGenre() {
		
		if (albums[0] == null ) {
			System.out.println("Collection is Empty");
			return;
		}
		
		System.out.println("*Album Collection by genre.");
		
		//Sorts the albums Array List by Genre
		for( int i = 0; i < albums.length; i++ ) {
			
			if (albums[i] == null) break;
			
		    for( int j=0; j < albums.length - 1; j++ ) {
		    	
		    	if(albums[j] == null || albums[j+1] == null) break;
		    	
		        if( albums[j].getGenre().compareTo(albums[j+1].getGenre()) > 0 ) {
		        	
		            Album temp = albums[j];
		            albums[j] = albums[j+1];
		            albums[j+1] = temp;
		       }
		    }
		    
		}
		
		//Prints the albums array list 
		for (int i = 0; i < albums.length; i++) {
			
			if (albums[i] == null) break;
			
			System.out.println(albums[i].toString());
			
		}
		
		System.out.println("*End of list");
		return;
		
	}

	/**
	 * A constructor that creates a collection that stores an array list data structure (albums)
	 * and the number of albums (numAlbums) in the collection.  
	 */
	public Collection() {
		
		albums = new Album[4];
		numAlbums = 0;
		
		
	}
	
	
}

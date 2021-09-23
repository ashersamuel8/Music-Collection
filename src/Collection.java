
public class Collection {
	
	private Album[] albums;
	private int numAlbums; //number of albums currently in the collection
	
	private int find(Album album) {		//find the album index, or return NOT_FOUND 
		
		int albumIndex = -1;
		for (int i = 0; i < albums.length; i++ ) {
			
			if (album.equals(albums[i])) {
				
				albumIndex = i;
				break;
				
			}
			
		}
		
		return albumIndex;
		
	} 
	private void grow() {				//increase the capacity of the array list by 4 
		
		Album[] buffArray = new Album[albums.length + 4];
		
		for (int i = 0; i < albums.length; i++) {
			
			buffArray[i] = albums[i];
			
		}
		
		albums = buffArray;
		
		
	} 
	public boolean add(Album album) {
		
		//checks if the album already exists
		
		boolean exists = false;
		
		
		for (int i = 0; i < albums.length; i++) {
			
			if (albums[i] == null) break;
			
			if(albums[i].equals(album)) {
				exists = true;
				break;
			}
			
		}
		
		
		if ( exists == false ) {
		
			if ( numAlbums == albums.length && album.getReleaseDate().isValid() ) {
			
				grow();
				albums[numAlbums] = album;
				numAlbums++;
			
			}
			else if (album.getReleaseDate().isValid()) {
				
				albums[numAlbums] = album;
				numAlbums++;
				
			}
		}
		
		return exists;
		
	}
	public boolean remove(Album album) {
		
		//checks if the album already exists
		boolean exists = false;
		int albumIndex = 0;
		
		for ( int i = 0; i < albums.length; i++ ) {
			
			if ( albums[i] == null ) break;
			
			if( albums[i].equals(album)) {
				
				exists = true;
				albumIndex = i;
				break;
				
			}
			
		}
		
		if (exists == true) {
			
			for (int i = albumIndex + 1; i < albums.length; i++ ) {
				
				albums[i-1] = albums[i];
					
			}	
			
		}
		
		return exists;
		
	}
	public boolean lendingOut(Album album) {			//set to not available 
		
		
		int albumIndex = find(album);
		
		if(albumIndex == -1 || albums[albumIndex].getStatus() == false) return false;
	
		else {
			
			albums[albumIndex].setStatus(false);
			return true;
			
		}	
		
	} 
	public boolean returnAlbum(Album album) {			//set to available
		
		int albumIndex = find(album);
		
		if(albumIndex != -1 || albums[albumIndex].getStatus() == true) return false;
		
		else {
			
			albums[albumIndex].setStatus(true);
			return true;
				
		}
		
	} 
	public void print() {								//display the list without specifying the order 
		
		for(int i = 0; i < albums.length; i++) {
			
			if (albums[i] == null) break;
			
			System.out.println(albums[i].toString());	
			
		}	
		
	} 								
	public void printByReleaseDate() {
		
		for( int i = 0; i < albums.length; i++ ) {
			
		    for( int j=0; j < albums.length - 1; j++ ) {
		    	
		        if( albums[j].getReleaseDate().compareTo(albums[j+1].getReleaseDate()) > 0 ) {
		        	
		            Album temp = albums[j];
		            albums[j] = albums[j+1];
		            albums[j+1] = temp;
		       }
		    }
		}
		
		for (int i = 0; i < albums.length; i++) {
			
			System.out.println(albums[i].toString());
			
		}	
		
		
	}
	public void printByGenre() {
		
		
		for( int i = 0; i < albums.length; i++ ) {
			
		    for( int j=0; j < albums.length - 1; j++ ) {
		    	
		        if( albums[j].getGenre().compareTo(albums[j+1].getGenre()) > 0 ) {
		        	
		            Album temp = albums[j];
		            albums[j] = albums[j+1];
		            albums[j+1] = temp;
		       }
		    }
		}
		
		for (int i = 0; i < albums.length; i++) {
			
			System.out.println(albums[i].toString());
			
		}
		
	}


	public Collection() {
		
		albums = new Album[4];
		numAlbums = 0;
		
		
	}
	
	
}

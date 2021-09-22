
public class Collection {
	
	private Album[] albums;
	private int numAlbums; //number of albums currently in the collection
	
	private int find(Album album) {		//find the album index, or return NOT_FOUND 
		
		int albumIndex = -1;
		for (int i = 0; i < this.albums.length; i++ ) {
			
			if (album.equals(albums[i])) {
				
				albumIndex = i;
				break;
				
			}
			
		}
		
		return albumIndex;
		
	} 
	private void grow() {				//increase the capacity of the array list by 4 
		
		Album[] buffArray = new Album[this.albums.length + 4];
		
		for (int i = 0; i < this.albums.length; i++) {
			
			buffArray[i] = this.albums[i];
			
		}
		
		this.albums = buffArray;
		
		
	} 
	public boolean add(Album album) {
		
		//checks if the album already exists
		
		boolean exists = false;
		
		for ( int i = 0; i <= this.albums.length; i++) {
			
			if(this.albums[i].equals(album)) {
				exists = true;
				break;
			}
			
		}
		
		
		if ( exists == false ) {
		
			if ( this.numAlbums == this.albums.length ) {
			
				this.grow();
				this.numAlbums++;
				albums[this.numAlbums] = album;
			
			}
			else {
				
				this.numAlbums++;
				albums[this.numAlbums] = album;
				
			}
		}
		
		return exists;
		
	}
	public boolean remove(Album album) {
		
		//checks if the album already exists
		boolean exists = false;
		int albumIndex = 0;
		
		for ( int i = 0; i < this.albums.length; i++ ) {
			
			if( this.albums[i].equals(album)) {
				
				exists = true;
				albumIndex = i;
				break;
				
			}
			
		}
		
		if (exists == true) {
			
			for (int i = albumIndex + 1; i < this.albums.length; i++ ) {
				
				this.albums[i-1] = this.albums[i];
					
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
		
		for (int i = 0; i < numAlbums; i++) {
			
			System.out.println(albums[i].toString());	
			
		}	
		
	} 								
	public void printByReleaseDate() {}
	public void printByGenre() {}


	public Collection() {
		
		this.albums = new Album[4];
		this.numAlbums = 0;
		
		
	}
	
	
}

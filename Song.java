package JBproj2;

/*	
Song.java - Implement the Song class with relevant data fields, constructors, setters, getters, and other methods.
*/

public class Song {
// Private data fields for Song object
private int id;
private String artist;
private String genre;
private String name;
private String album;
private int year;
private double longitude;

// Default Constructor
public Song () {
	id = -1;
	artist = "No Artist Set";
	genre = "No Genre Set";
	name = "No Name Set";
	album = "No Album Set";
	year = -1;
	longitude = -1.0;
}

// Constructor w/ ID
public Song (int id) {
	this.id = id;
	artist = "No Artist Set";
	genre = "No Genre Set";
	name = "No Name Set";
	album = "No Album Set";
	year = -1;
	longitude = -1.0;
}

// Constructor w/ All Values
public Song (int id, String artist, String genre, String name, String album, int year, double longitude) {
	this.id = id;
	this.artist = artist;
	this.genre = genre;
	this.name = name;
	this.album = album;
	this.year = year;
	this.longitude = longitude;
}

// Getters
public int getID() {
	return id;
}

public String getArtist() {
	return artist;
}

public String getGenre() {
	return genre;
}

public String getName() {
	return name;
}

public String getAlbum() {
	return album;
}

public int getYear() {
	return year;
}

public double getLongitude() {
	return longitude;
}


// Setters
public void setID(int id) {
	this.id = id;
}

public void setArtist(String artist) {
	this.artist = artist;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public void setName(String name) {
	this.name = name;
}

public void setAlbum(String album) {
	this.album = album;
}

public void setYear(int year) {
	this.year = year;
}

public void setLongitude(double longitude) {
	this.longitude = longitude;
}


// ToString method to allow printing/displaying this Song object.
public String toString() {
	String toReturn = "";
	toReturn += id + "," + artist.toString() + "," + genre.toString() + ","
	+ name.toString() + "," + album.toString() + "," + year + "," + longitude;
	return toReturn;
}

// Equals method to test for equality between two Songs.
public boolean equals (Song rhs) {
	if (rhs.id == this.id)
		return true;
	return false;
}
}


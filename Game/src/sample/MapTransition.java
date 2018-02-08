//Members Responsible: Callum, Daniel, Danilo
//Exists to hold the required information so that a Map Transition can occur

package sample;

public class MapTransition extends tileObject{
	private String path;

	//Sets Default values for the global variables
	public MapTransition(String path) {
		super(5);
		this.path = path;
	}

	//Returns a string with the path of the Map file to be loaded
	public String getPath(){
		return this.path;
	}
}

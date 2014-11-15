
public class LeopoldsTomb {
	
	boolean isRunning = true;
	static public int gameState = 0;
	static int currentRoom = 0;
	private String inventory = "Nothing";
	String[] rooms = {"Tomb Entrance", "Main Hall", "Altar Room", "Flooded Room", "Tomb"};
	
	public LeopoldsTomb(){
		System.out.println("######################################################");
		System.out.println("###############    Leopold's Tomb      ###############");
		System.out.println("---------------  A game by Ashbrooke   ---------------");
		System.out.println("------Enter numbers to play, type 'exit' to quit------");
		
	}
	
	public static int getCurrentRoom(){
		return currentRoom;
	}
	
	public String getRoom(){
		String room = rooms[currentRoom];
		return room;
	}
	
	public void changeRoom(int nextRoom){
		 currentRoom = nextRoom;
	}


	public String getInventory() {
		return inventory;
	}


	public void addInventory(String item) {
		inventory = item;
	}


	public static String getRoomDescription() {
		String description = "";
		switch (currentRoom) {
        	case 0:  	description = "There is nothing interesting here, go on inside!";
        				break;
        	case 1:		description = "You walk inside of a large room with four support pillars. Engraved into the pillars are images of ships and large sea monsters.";
        				break;
        	case 2:		description = "The room is empty save a stone alter with the words 'The most important thing required for a well built ship.'";
        				break;
        	case 3:		if(gameState >= 3){
        					description = "A large grate in the floor has drained all of the water.";
           				}else{
        					description = "A wall of water falls from the ceiling. Any attemt to pass through just washes you back to the door.";
        				}
        				break;
		}
		return description;
	}

	
}

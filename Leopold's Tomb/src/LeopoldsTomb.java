
public class LeopoldsTomb {
	
	boolean isRunning = true;
	int gameStage = 0;
	int currentRoom = 0;
	String[] rooms = {"Tomb Entrance", "Main Hall", "Altar Room", "Flooded Room", "Tomb"};
	
	public LeopoldsTomb(){
		System.out.println("###########################");
		System.out.println("##    Leopold's Tomb     ##");
		System.out.println("--  A game by Ashbrooke  --");
		System.out.println("---------------------------");
	}
	
	
	public String getRoom(){
		String room = rooms[currentRoom];
		return room;
	}
	
	public void changeRoom(int nextRoom){
		 currentRoom = nextRoom;
	}

	
}

import java.util.Scanner;


public class Main {

	public static void main(String[] args){
		Scanner scannerInput = new Scanner(System.in);
		LeopoldsTomb GameInstance = new LeopoldsTomb();
		
		
		while(GameInstance.isRunning){
			
			System.out.println("You are in the " + GameInstance.getRoom());
			System.out.println("What would you like to do?");
			System.out.println("\t 1 - Move to a new room");
			System.out.println("\t 2 - Search the " + GameInstance.getRoom());
			System.out.println("\t 3 - Check your inventory");
			
			
			String input = scannerInput.nextLine();
			int nextRoom = 0;
			
			if(input.equals("exit")){
				scannerInput.close();
				break;
			}else if(input.equals("1")){
				switch (GameInstance.currentRoom) {
		         case 0:  	nextRoom = 1;
		                  	break;
		         case 1:  	System.out.println("Which room would you like to enter?");
		         			System.out.println("1 - Altar Room");
		         			System.out.println("2 - Flooded Room");
		         			System.out.println("3 - Tomb");
		         			input = scannerInput.nextLine();
		         			if(input.equals("1")){
		         				nextRoom = 2;
		         			}else if(input.equals("2")){
		         				nextRoom = 3;
		         			}else if(input.equals("3")){
		         				if(GameInstance.gameStage == 4){
		         					nextRoom = 4;
		         				}else{
		         					nextRoom = GameInstance.currentRoom;
		         					System.out.println("The Tomb doors are locked firmly in place! You can't enter.");
		         				}
		         			}else{
		         				nextRoom = GameInstance.currentRoom;
		         				System.out.println("You can't go there, it's not a valid destination!");
		         			}
		         			break;
		         case 2:  	nextRoom = 1;
		                  	break;
		         case 3:  	nextRoom = 1;
		                  	break;
		         case 4:  	nextRoom = 1;
		                  	break;
		         default: 	nextRoom = 0;
		         			System.out.println("How did you even get here?! Teleporting you back to the enterance...");
		                  	break;
				}
							
				
				GameInstance.changeRoom(nextRoom);
			}else if(input.equals("2")){
				System.out.println("You search the room!");
			}else if(input.equals("3")){
				System.out.println("You check your inventory!");
			}else{
				System.out.println("Not a valid command");
			}
			
		}
		
	}
	
	
}

import java.util.Scanner;


public class Main {

	public static void main(String[] args){
		boolean playerWin = false;
		boolean showDialog = true;
		Scanner scannerInput = new Scanner(System.in);
		LeopoldsTomb GameInstance = new LeopoldsTomb();
		
		GameLoop:
		while(GameInstance.isRunning){
			
			System.out.println("------------------------------------------------------");
			System.out.println("> You are in the " + GameInstance.getRoom() + " <");
			if(showDialog){
				System.out.println(LeopoldsTomb.getRoomDescription());
			}

			System.out.println("What would you like to do?");
			System.out.println("\t 1 - Move to a new room");
			System.out.println("\t 2 - Search the " + GameInstance.getRoom());
			System.out.println("\t 3 - Open your inventory");
			
			
			showDialog = false;
			String input = scannerInput.nextLine();
			int nextRoom = 0;
			
			if(input.equals("exit")){
				scannerInput.close();
				break;
			}else if(input.equals("1")){
				switch (LeopoldsTomb.getCurrentRoom()) {
		         case 0:  	nextRoom = 1;
		                  	break;
		         case 1:  	System.out.println("> Which room would you like to enter? <");
		         			System.out.println("\t 1 - Altar Room");
		         			System.out.println("\t 2 - Flooded Room");
		         			System.out.println("\t 3 - Tomb");
		         			input = scannerInput.nextLine();
		         			if(input.equals("1")){
		         				nextRoom = 2;
		         			}else if(input.equals("2")){
		         				nextRoom = 3;
		         			}else if(input.equals("3")){
		         				if(LeopoldsTomb.gameState == 4){
		         					nextRoom = 4;
		         					playerWin = true;
		         					GameInstance.isRunning = false;
		         					break GameLoop;
		         				}else{
		         					nextRoom = LeopoldsTomb.getCurrentRoom();
		         					System.out.println("The Tomb doors are locked firmly in place! You can't enter.");
		         				}
		         			}else{
		         				nextRoom = LeopoldsTomb.getCurrentRoom();
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
							
				showDialog = true;
				GameInstance.changeRoom(nextRoom);
			}else if(input.equals("2")){
				if((LeopoldsTomb.getCurrentRoom() == 1)){
					if(LeopoldsTomb.gameState == 0){
						LeopoldsTomb.gameState = 1;
						GameInstance.addInventory("Sacrificial Dagger");
						System.out.println("You found a sacrificial dagger! It has been added to your inventory.");
					}else{
						System.out.println("You search the room thoroughly but find nothing of use.");
					}
				}else if(LeopoldsTomb.getCurrentRoom() == 2){
					System.out.println("The only object here is the altar, and you can't carry that.");
				}else if(LeopoldsTomb.getCurrentRoom() == 3){
					if(LeopoldsTomb.gameState <= 2){
						System.out.println("If you searched the room now you would surely drown.");
					}else{
						LeopoldsTomb.gameState = 4;
						System.out.println("A large lever is located on the back wall of the room. You pull it and hear doors open.");
					}
				}else{
					System.out.println("You find nothing usefull.");
				}
			}else if(input.equals("3")){
				System.out.println("------------------------------------------------------");
				if(LeopoldsTomb.getCurrentRoom() == 2 && LeopoldsTomb.gameState == 1){
					LeopoldsTomb.gameState = 3;
					GameInstance.addInventory("Bloody Sacrificial Dagger");
					System.out.println("You use the dagger to prick your finger. A drop of blood falls onto the altar, representing the hard work that goes into shipbuilding.");
					System.out.println("The tomb rumbles and the rushing sound of water has now stopped.");
				}else{
					
					System.out.println("> You look inside of your adventurers bag and see: <");
     				System.out.println("\t" + GameInstance.getInventory());
     				System.out.println("\n ||| Press 'Enter' to continue |||");
     				scannerInput.nextLine();
				}
			}else{
				System.out.println("Not a valid command");
			}
			
		}
		
		scannerInput.close();
		if(playerWin){
			System.out.println("Congratulations! You have entered the Tomb! You go on to be the greatest archaeologist in history!");
		}else{
			System.out.println("You have exited the game.");
		}
		
		System.out.println("Thanks for playing!");
		
	}
	
	
}

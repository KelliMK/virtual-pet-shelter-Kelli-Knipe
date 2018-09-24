package petshelter;

import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")
public class VirtualPetShelterApp {
	public static void main(String args[]) {
		String cowName = "Rose";							// Default name for cow
		String cowDesc = (cowName + " goes moo so muuuuch");// Default cow description
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		int currentTurn = 0;								// ranges from 1 to 8
		int currentDay = 0;									// no limit
		boolean dayTime = true;								// Is it day or night
		boolean localKillSwitch = false;					// When true, ends smaller individual cow loop
		boolean marketKillSwitch = false;					// When true, ends smaller "market" loop 
		boolean mainKillSwitch = false;						// When true, ends game loop
		int randBoredom = rand.nextInt((8 - 3) + 1) + 3; 	// reduce boredom
		int randSales = rand.nextInt((35 - 15) + 1) + 15;	// Sales of Milk
		int randDesc = rand.nextInt((9 - 0) + 1);
		String[] cowDescriptions = {" seems to be in a good mood whenever you scratch her head", " has some spots that look like they make a face",
				" does not seem too fond of you", " loves playing with other cows", " once won a ribbon at the Ohio State Fair", " is terrified of people with blue hair",
				" will nibble your hand if you let her", " enjoys getting your attention", " once stepped on a rat that got in her stall", " goes moo so muuuuuuch"};
		
		System.out.println("Welcome to Cow Sanctuary Simulator!\nby Kelli Knipe\nASCII art by Christopher Johnson");
		System.out.println("\n \nPlease input the name of your new cow sanctuary");
		System.out.print("> ");
		String sanctuaryName = input.next();
		VirtualPetShelter sanctuary = new VirtualPetShelter(sanctuaryName);
		String userInput = " ";
		sanctuary.addCowToSanctuary("Rose",cowDesc, 30, 10);
		System.out.println("You currently have one cow, named Rose");
		sanctuary.displayStats();
		
		while (!mainKillSwitch) {
			System.out.println("\nChoose an option\n1) Display stats of every cow (stats)\n2) Feed cows (feed)\n3) "
					+ "Give cows water (water)\n4) Look at specific cow (look at) \n5) Go to the Market (market)\n6) "
					+ "Rescue a new cow (rescue) \n7) Give a cow to a new owner (give)\n8) Do nothing for a bit (nope) \n9) Exit Game (exit)");
			System.out.print("> ");
			String userInput1 = input.next();
			String userInput2 = userInput1.toLowerCase();
			System.out.println(" ");
			
			if (userInput2.equals("stats") || userInput2.equals("1")) {
				sanctuary.displayStats();
				System.out.println("You have " + sanctuary.totalFeed + " bag(s) (out of 50) of regular feed");
				System.out.println("You have " + sanctuary.totalFancyFeed + " bag(s) (out of 15) of fancy feed");
				System.out.println("Your water trough has " + sanctuary.waterTrough + "/200 unit(s) right now");
				System.out.println("The cows have made " + sanctuary.unitsMilk + " bottles of milk (the sanctuary can hold 50)");
			
			
			} else if (userInput2.equals("feed") || userInput2.equals("2")) {
				System.out.println("You currently have:\nFeed: " + sanctuary.totalFeed + "\nFancy Feed: " + sanctuary.totalFancyFeed);
				System.out.println("Would you like to feed the cows regular (1) or fancy (2) feed?");
				System.out.print("> ");
				String feedChoice1 = input.next();
				String feedChoice2 = feedChoice1.toLowerCase();	
				sanctuary.feedAllCows(feedChoice2);
				sanctuary.tick();
				sanctuary.limit();
			
			} else if (userInput2.equals("water") || userInput2.equals("3")) {
				System.out.println("You currently have " + sanctuary.waterTrough + " units of water in your water trough");
				sanctuary.waterAllCows();
				System.out.println("You now have " + sanctuary.waterTrough + " units of water in your water trough");
				sanctuary.tick();
				sanctuary.limit();

			} else if (userInput2.equals("look at") || userInput2.equals("4")) {
				System.out.println("Who would you like to look at more closely?\n> ");
				String cowToExamine = input.next();
				String cowToExamine1 = cowToExamine.toUpperCase();
				VirtualPet cowToExamine2 = sanctuary.cowsInThisBitch.get(cowToExamine1);
				localKillSwitch = false;
				while (!localKillSwitch) {
					System.out.println("What would you like to do with " + cowToExamine1 + "?\n1) look at more closely (look at)\n2) play with (play)\n3)Nothin' else (exit)\n> ");
					String anotherInput = input.next();
					if (anotherInput.equals("look at") || anotherInput.equals("1")) {
						cowToExamine2.calculateMood();
						cowToExamine2.moodGraphic();
					} else if (anotherInput.equals("play") || anotherInput.equals("2")) {
						cowToExamine2.playCow();
						sanctuary.tick();
						sanctuary.limit();
					} else if (anotherInput.equals("exit") || anotherInput.equals("3")) {
						System.out.println("You say goodbye to " + cowToExamine2.cowName);
						localKillSwitch = true;
					} else {
						System.out.println("Didn't catch that");
					}
				}
				

			} else if (userInput2.equals("market") || userInput2.equals("5")) {
				System.out.println("Welcome to the market!");
				System.out.println("   _        ,\n" + "  (_\\______/________\n" + "     \\-|-|/|-|-|-|-|/\n"
						+ "      \\==/-|-|-|-|-/\n" + "       \\/|-|-|-|,-'\n" + "        \\--|-'''\n"
						+ "         \\_j________\n" + "         (_)      (_)");
				int cashMade = (sanctuary.unitsMilk * randSales);
				System.out.println("You sold your " + sanctuary.unitsMilk + " units of milk for $" + cashMade);
				sanctuary.currentMoney += cashMade;
				sanctuary.unitsMilk = 0;
				System.out.println("You have $" + sanctuary.currentMoney);
				System.out.print("What would you like to do?\n1) Buy Water ($5 each)\n2) Buy Regular Feed ($20 each)\n3) Buy Fancy Feed ($50 each)\n4) Leave Market\n> ");
				String marketInput = input.nextLine();
				String inputMarket = marketInput.toLowerCase();
				marketKillSwitch = false;
				while (!marketKillSwitch) 
				{
					if (inputMarket.equals("1") || inputMarket.equals("buy water") || inputMarket.equals("water")) {
						System.out.print("How many units of water would you like to buy?\nYour barn's trough can't handle more than 40 units at a time\n> ");
						int waterWanted = input.nextInt();
						if ((waterWanted * 5) > sanctuary.currentMoney) 
						{
						System.out.println("You don't have enough money!");
						} 
						else 
						{
							if ((sanctuary.waterTrough + waterWanted) > 40) {
								System.out.println("You can't have more than 40 units of water in your trough at a time\n"
										+ "You currently have" + sanctuary.waterTrough + ", which means you'd have" + (sanctuary.waterTrough + waterWanted));
							}
							else 
							{
								sanctuary.currentMoney -= (waterWanted * 5);
								sanctuary.totalFancyFeed += waterWanted;
								System.out.println("You now have " + sanctuary.waterTrough + " units of water in your trough\n");
							}
						}
					} 
					else if (inputMarket.equals("2") || inputMarket.equals("buy regular feed") || inputMarket.equals("regular feed") || inputMarket.equals("regular")) 
					{
						System.out.print("How many bags of regular feed would you like to buy?\nYour barn can't handle more than 5 bags at a time\n> ");
						int feedWanted = input.nextInt();
						if ((feedWanted * 20) > sanctuary.currentMoney) 
						{
							System.out.println("You don't have enough money!");
						} 
						else 
						{
							if ((sanctuary.totalFeed + feedWanted) > 50) {
								System.out.println("You can't have more than 50 bags of regular feed in your barn at a time\n"
										+ "You currently have" + sanctuary.totalFeed + ", which means you'd have" + (sanctuary.totalFeed + feedWanted));
							}
							else 
							{
								sanctuary.currentMoney -= (feedWanted * 20);
								sanctuary.totalFeed += feedWanted;
								System.out.println("You now have " + sanctuary.totalFeed + " bags of regular feed\n");
							}							
						}
					} 
					else if (inputMarket.equals("3") || inputMarket.equals("buy fancy feed") || inputMarket.equals("fancy feed") || inputMarket.equals("fancy")) 
					{
						System.out.print("How many bags of fancy feed would you like to buy?\nYour barn can't handle more than 5 bags at a time\n> ");
						int fancyFeedWanted = input.nextInt();
						if ((fancyFeedWanted * 50) > sanctuary.currentMoney) 
						{
							System.out.println("You don't have enough money!");
						} 
						else 
						{
							if ((sanctuary.totalFancyFeed + fancyFeedWanted) > 15) {
								System.out.println("You can't have more than 15 bags of fancy feed in your barn at a time\n"
										+ "You currently have" + sanctuary.totalFancyFeed + ", which means you'd have" + (sanctuary.totalFancyFeed + fancyFeedWanted));
							}
							else 
							{
								sanctuary.currentMoney -= (fancyFeedWanted * 50);
								sanctuary.totalFancyFeed += fancyFeedWanted;
								System.out.println("You now have " + sanctuary.totalFancyFeed + " bags of fancy feed\n");
							}
						}
					} 
					else if (inputMarket.equals("feed")) 
					{
						System.out.println("What type of feed?");
					} 
					else if (inputMarket.equals("4") || inputMarket.equals("leave market") || inputMarket.equals("leave")) 
					{
						System.out.println("Goodbye!");
					} 
					else 
					{
						System.out.println("Sorry, I didn't understand that");
					}
				}
				sanctuary.tick();
				sanctuary.limit();

				
				
				
			} else if (userInput2.equals("rescue") || userInput2.equals("6")) {
				System.out.println("What would you like to name the new cow?\n> ");
				String newCowName = input.next();
				String newCowDesc = cowDescriptions[randDesc];
				sanctuary.addCowToSanctuary(newCowName, newCowDesc);
				sanctuary.tick();
				sanctuary.limit();
				
				
			} else if (userInput2.equals("give") || userInput2.equals("7")) {
				System.out.println("Who would you like to give to a good home?\n> ");
				String cowToGive = input.next();
				sanctuary.goodByeMoo(cowToGive);
				sanctuary.tick();
				sanctuary.limit();
			
			} else if (userInput2.equals("nope") || userInput2.equals("8")) {
				System.out.println("Okay, lazy bones");
				sanctuary.tick();
				sanctuary.limit();

			} else if (userInput2.equals("exit") || userInput2.equals("9")) {
				System.out.println("Thanks for playing!");
				mainKillSwitch = true;

			} else {
				System.out.println(
						"...I didn't catch that. Enter a non-zero integer or one of the commands in parentheses");
			} 
		}
		input.close();
	}

}

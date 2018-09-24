package petshelter;

import java.util.Random;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class VirtualPetShelter {
	Random rand = new Random();
	String sanctuaryName = "";							// The name of the player's shelter
	int unitsMilk = 0;									// How much milk your shelter has, max of 50 units
	int currentMoney = 0;								// The funds your shelter has for supplies, no limit
	int totalFeed = 5;									// How many bags of regular feed your shelter has, shelter can store up to 50
	int totalFancyFeed = 3;								// How many bags of fancy feed your shelter has, shelter can store up to 15
	int waterTrough = 0;								// How many units of water your shelter has, can store up to 200
	int currentTurn = 0;								// Player must "go home" at night, which will be turns 9 and 10 of a 10 turn cycle
	int currentDay = 0;									// How many days has the player worked at the shelter
	boolean dayTime = true;								// Is it day or night for the player
	
	public VirtualPetShelter(String inputSanctuaryName) {
		sanctuaryName = inputSanctuaryName;
	}
	
	// Map that houses the names of cows currently in the sanctuary 
	Map<String, VirtualPet> cowsInThisBitch = new HashMap<String, VirtualPet>(5);
	
	// ArrayList that has the names of every cow 
	ArrayList<VirtualPet> cowsInSanctuary = new ArrayList<VirtualPet>(5);
	
	// For putting new cows in the shelter
	public int addCowToSanctuary(String inputArrivalName, String inputDescription, int inputHunger, int inputThirst) {
		if (cowsInSanctuary.size() < 5) {
			String upperCaseArrival = inputArrivalName.toUpperCase();
			VirtualPet fuck = new VirtualPet(upperCaseArrival, inputDescription, inputHunger, inputThirst);
			cowsInSanctuary.add(fuck);
			cowsInThisBitch.put(upperCaseArrival, fuck);
			return 0;
		}
		else if (cowsInSanctuary.size() == 5) {
			System.out.println(sanctuaryName + " is at capacity!");
			return 1;
		} 
		else {
			return 2;
		}
	}
	
	// Duplicate for second constructor
	public int addCowToSanctuary(String inputArrivalName, String inputDescription) {
		if (cowsInSanctuary.size() < 5) {
			String upperCaseArrival = inputArrivalName.toUpperCase();
			VirtualPet fuck = new VirtualPet(upperCaseArrival, inputDescription);
			cowsInSanctuary.add(fuck);
			cowsInThisBitch.put(upperCaseArrival, fuck);
			return 0;
		}
		else if (cowsInSanctuary.size() == 5) {
			System.out.println(sanctuaryName + " is at capacity!");
			return 1;
		} 
		else {
			return 2;
		}
	}
	
	// Method that shows the name, hunger, thirst, boredom of all cows
	public void displayStats() {
		System.out.println("");
		System.out.println("Name\t| Hunger\t| Thirst\t| Boredom\t| Milk");
		System.out.println("Max \t| 100   \t| 50\t\t| 50\t\t| 30");
		for (VirtualPet foo : cowsInSanctuary) {
			System.out.println(foo.cowName + "\t| " + foo.cowHunger + "\t\t| " + foo.cowThirst + "\t\t| " + foo.cowBoredom + "\t\t| " + foo.cowMilk);
		}
	}
	
 	public boolean limit() {
		if (waterTrough > 40) 
		{
			waterTrough = 40;
		} 
		else if (waterTrough < 0) 
		{
			waterTrough = 0;
		}
		if (totalFeed > 50) {
			totalFeed = 50;
		}
		if (totalFeed > 50) {
			totalFeed = 50;
		}
		if (totalFeed < 0) {
			totalFeed = 0;
		}
		if (totalFancyFeed > 15) {
			totalFancyFeed = 15;
		}
		if (totalFancyFeed < 0) {
			totalFancyFeed = 0;
		}

		return true;
	}
	
	public boolean tick() {
		if (currentTurn >= 0 && currentTurn <= 8) {
			++currentTurn;
			for (VirtualPet foo: cowsInSanctuary) {
				foo.tick();
				foo.drain();
				foo.limitCow();
			}
			return true;
		} else if (currentTurn == 9) {
			++currentTurn;
			for (VirtualPet foo: cowsInSanctuary) {
				foo.tick();
				foo.drain();
				foo.limitCow();
			}
			return true;
		} else if (currentTurn == 10) {
			currentTurn = 0;
			for (VirtualPet foo: cowsInSanctuary) {
				foo.tick();
				foo.drain();
				foo.limitCow();
			}
			++currentDay;
			return true;
		} else {
			return false;
		}
	}
	
	// Method that feeds all cows
	public int feedAllCows(String feedInput) {
		if ((feedInput.equals("1") || feedInput.equals("regular") || feedInput.equals("regular feed")) && totalFeed >= cowsInSanctuary.size()) {
			for (VirtualPet foo : cowsInSanctuary) {
				foo.feedCow(feedInput);
				--totalFeed;
			}
			return 0;
		} else if ((feedInput.equals("1") || feedInput.equals("regular") || feedInput.equals("regular feed")) && totalFeed < cowsInSanctuary.size()) {
			System.out.println("you don't have enough feed for everyone!!");
			return 1;
		} else if ((feedInput.equals("2") || feedInput.equals("fancy") || feedInput.equals("fancy feed")) && totalFancyFeed >= cowsInSanctuary.size()) {
			for (VirtualPet foo : cowsInSanctuary) {
				foo.feedCow(feedInput);
				--totalFancyFeed;
			}
			return 0;
		} else if ((feedInput.equals("2") || feedInput.equals("fancy") || feedInput.equals("fancy feed")) && totalFancyFeed < cowsInSanctuary.size()) {
			System.out.println("you don't have enough fancy feed for everyone!!");
			return 1;
		} else {
			System.out.println("I didn't understand that");
			return 2;
		}
	}

	// Method that waters all cows
	public boolean waterAllCows() {
		if (waterTrough >= cowsInSanctuary.size()) {
			for (VirtualPet foo : cowsInSanctuary) {
				int randTrough = (rand.nextInt((4 - 2) + 1) + 2);
				
				if (waterTrough >= 4) {
					foo.waterCow(waterTrough);
					System.out.println(foo.cowName + " had some water!");
					waterTrough -= randTrough;
				} else if (waterTrough < 4 && waterTrough >= 0) {
					waterTrough = 0;
					System.out.println(foo.cowName + " had some water!");
					foo.waterCow(waterTrough);
				} else {
					System.out.println("You don't have any water!");
				}
			}
			return true;
		} else {
			return false;
		}
	}
	// Method that chooses a specific cow to .playCow() with
	
	// Method that allows the adoption of a cow, releasing it from the shelter
	@SuppressWarnings("unlikely-arg-type")
	public boolean goodByeMoo(String MooIsLeaving) {
		if (cowsInSanctuary.contains(MooIsLeaving)) {
			cowsInSanctuary.remove(MooIsLeaving);
			return true;
		} else {
			System.out.println("That's not a name I recognize");
			return false;
		}
	}
	
	// Method that allows the user to look at a specific cow
	// Should not make time move forward
	
}

package petshelter;

import java.util.Random;

public class VirtualPet {
	Random rand = new Random();
	String cowName = "Rose";							// Default name for cow
	String cowDesc = (cowName + " go moo");				// Default cow description
	int cowHunger = 0;									// out of 100
	int cowThirst = 0; 									// out of 50
	int cowTired = 0; 									// Cow can play twice a day
	int cowBoredom = 0;									// out of 50
	int cowMilk = 0;									// out of 30
	int cowMood = 0;									// out of 100, determined by +Hunger, +Thirst, +Boredom, and -Milk
	int randBoredom = rand.nextInt((8 - 3) + 1) + 3; 	// reduce boredom
	boolean cowAwake = true;							// Is the cow awake or asleep
	int currentTurn = 0;								// ranges from 1 to 8
	int currentDay = 0;									// no limit
	int unitsMilk = 0;									// placeholder variable for PetShelter to use as reference

	// Constructor with name and description
	public VirtualPet(String inputCowName, String inputCowDescription) {
		cowName = inputCowName;
		cowDesc = inputCowDescription;
	}
	
	public VirtualPet(String inputCowName, String inputCowDescription, int inputCowHunger, int inputCowThirst) {
		cowName = inputCowName;
		cowDesc = inputCowDescription;
		cowHunger = inputCowHunger;
		cowThirst = inputCowThirst;
	}
	
	// graphic display
	public boolean affectionateGraphic() {
		if (cowMood <= 20 && cowAwake) {
			System.out.println(cowName + " is very happy!");
			System.out.println("		           \\|/\n" + "   (___)      %            =+=\n"
					+ "   (^#^)_____/		   /|\\\n" + "    @@ `     \\         \n"
					+ "     \\ ____, /		\"moooo~\"\n" + "     //    //  \n" + "    ^^    ^^");
			return true;
		} else {
			return false;
		}
	}
	
	// graphic display
	public boolean angryGraphic() {
		if (cowMood > 80 && cowMood <= 100 && cowAwake) {
			System.out.println(cowName + " is upset\nYou probably need to do something or let her sleep");
			//System.out.println("                    \\|/\n" + "   (___)            =+=\n"
			//		+ "   (\\ /)_____/      /|\\\n" + "    @@ `     \\  \n" + "     \\ __~~, /    \"MRRRRRRR\"\n"
			//		+ "     //    //  \n" + "    ^^    ^^");
			System.out.println("		           \\|/\n" + "   (___)                   =+=\n"
					+ "   (\\ /)______		   /|\\\n" + "    @@ `     \\\\        \n"
					+ "     \\ ____, /		\"MRRRRRRR\"\n" + "     //    //  \n" + "    ^^    ^^");
			return true;
		} else {
			return false;
		}
	}
	
	// graphic display
	public boolean asleepGraphic() {
		if (!cowAwake) {
			System.out.println(cowName + " is asleep in the field");
			System.out.println("                     ,-,\n" + "   (___)            / {   \n"
					+ "   (_ _)______	    \\ {    \n" + "    @@ `     \\\\      `-`\n" + "     \\ ____, / \\	 \n"
					+ "     //    //  		\"zzzz\"\n" + "     ``    ``");
			return true;
		} else {
			return false;
		}
	}

	// Calculate individual cow's mood
	public boolean calculateMood() {
		cowMood = (((cowThirst + cowHunger + cowBoredom) / 2) + (cowMilk / 2));
		if (cowMood <= 100 && cowMood >= 0) {
			return true;
		} else {
			return false;
		}
	}

	// As time goes forward, virtual cow's emotions wear down
	// No need to make a test, will always return true
	public boolean drain() {
		int moreHunger = rand.nextInt((7 - 2) + 1) + 2;
		int moreThirst = rand.nextInt((4 - 2) + 1) + 1;
		int moreBored = rand.nextInt((4 - 2) + 1) + 2;
		int moreMilk = rand.nextInt((3 - 1) + 1) + 1;
		cowHunger += moreHunger;
		cowThirst += moreThirst;
		cowBoredom += moreBored;
		cowMilk += moreMilk;
		return true;
	}
	
	// Feeds the cow, reducing Hunger
 	public boolean feedCow(String inputFeed) {
		if (inputFeed.equals("regular") ||  inputFeed.equals("regular feed") || inputFeed.equals("1")) {
				int randFeed = (rand.nextInt((15 - 5) + 1) + 5);
				cowHunger -= randFeed;
				System.out.println("You fed " + cowName + "!");
				return true;
		} else if (inputFeed.equals("fancy") || inputFeed.equals("fancy feed") || inputFeed.equals("2")) {
				int randFancyFeed = (rand.nextInt((60 - 30) + 1) + 30);
				cowHunger -= randFancyFeed;
				System.out.println("You fed " + cowName + "!");
				return true;
		} else {
			System.out.println("Sorry, I didn't understand that");
			return false;
		}
	}
 	
	// graphic display
	public boolean happyGraphic() {
		if (cowMood > 20 && cowMood <= 40 && cowAwake) {
			System.out.println(cowName + " is happy");
			// System.out.println(" \\|/\n" + " (___) =+=\n"
			// + " (^ ^)______% /|\\\n" + " @@ ` \\ \n"
			// + " \\ ____, / \"Moooo!\"\n" + " // // \n" + " ^^ ^^");
			System.out.println("		           \\|/\n" + "   (___)      %            =+=\n"
					+ "   (^ ^)_____/		   /|\\\n" + "    @@ `     \\         \n"
					+ "     \\ ____, /		\"moooo!\"\n" + "     //    //  \n" + "    ^^    ^^");
			return true;
		} else {
			return false;
		}
	}
	
	// check to make sure that no stats exceed upper or lower limits
	// Purely a limiter, no need to test
  	public boolean limitCow() {
		if (cowHunger > 100) 
		{
			cowHunger = 100;
		} 
		else if (cowHunger < 0) 
		{
			cowHunger = 0;
		}
		if (cowThirst > 50) 
		{
			cowThirst = 50;
		} 
		else if (cowThirst < 0) 
		{
			cowThirst = 0;
		}
		if (cowBoredom < 0) 
		{
			cowBoredom = 0;
		} 
		else if (cowBoredom > 50) 
		{
			cowBoredom = 50;
		}
		if (cowMilk > 30) 
		{
			cowMilk = 30;
		} 
		else if (cowMilk < 0) 
		{
			cowMilk = 0;
		}
		if (cowTired >= 1 && cowAwake == false) 
		{
			cowTired = 0;
		}
		if (cowMood > 100) 
		{
			cowMood = 100;
		} 
		else if (cowMood < 0) 
		{
			cowMood = 0;
		}
		return true;
	}
	
  	// Milk your cow to sell, so that you can make money to buy food and water for your cows
  	// Look up M-C-M because that's mostly what this whole game is
	public boolean milkCow() {
		if (cowMilk > 4) {
			unitsMilk += (cowMilk/5);
			cowBoredom -= 5;
			System.out.println(cowName + " was milked and gave you " + (cowMilk/5) + " units of Milk");
			cowMilk = 0;
			return true;
		} else {
			System.out.println("You tried milking " + cowName + ", but she didn't have enough milk to give");
			return false;
		}
	}
	
	// Display ASCII art based on cow's mood
	// No need to make a test, will always return true
	public boolean moodGraphic() {
		affectionateGraphic();
		happyGraphic();
		normalGraphic();
		sadGraphic();
		angryGraphic();
		asleepGraphic();
		System.out.println(cowName + "\nHunger: " + cowHunger + "\nThirst: " + cowThirst + "\nBoredom: " + cowBoredom + "\nMilk: " + cowMilk);
		return true;
	}
	
	// graphic display
	public boolean normalGraphic() {
		if (cowMood > 40 && cowMood <= 60 && cowAwake) {
			System.out.println(cowName + " seems melancholy");
			// System.out.println("					          \\|/\n" + "   (___)			      =+=\n"
			//		+ "   (o o)_____/      /|\\\n" + "    @@ `     \\  \n" + "     \\ ____, /		\"moo\"\n"
			//		+ "     //    //  \n" + "    ^^    ^^");
			System.out.println("		           \\|/\n" + "   (___)                   =+=\n"
					+ "   (o o)_____/		   /|\\\n" + "    @@ `     \\         \n"
					+ "     \\ ____, /		\"moo\"\n" + "     //    //  \n" + "    ^^    ^^");
			return true;
		} else {
			return false;
		}
	}
	
	// Play with your cow so it stays happy, but it can only play up to three times a day
	public boolean playCow() {
		if (cowTired >= 2) {
			System.out.println(cowName +  " is tired as hell, and does NOT want to play");
			return false;
		} else if (cowBoredom <= 0) {
			System.out.println(cowName + "is content, and doesn't want to play");
			return false;
		} else {
			++cowTired;
			System.out.println(cowName + " is happy you played with her!");
			cowBoredom -= randBoredom;
			return true;
		}
	}
	
	// graphic display
	public boolean sadGraphic() {
		if (cowMood > 60 && cowMood <= 80 && cowAwake) {
			System.out.println(cowName + " is sad\nMaybe you should check up on her.");
			// System.out.println("					          \\|/\n" + "   (___)	          =+=\n"
			// 		+ "   (- -)______      /|\\\n" + "    @@ `     \\\\        \n" + "     \\ ____, /		\"...\"\n"
			//		+ "     //    //  \n" + "    ^^    ^^    ");
			System.out.println("		           \\|/\n" + "   (___)      %            =+=\n"
					+ "   (- -)______		   /|\\\n" + "    @@ `     \\\\        \n"
					+ "     \\ ____, /		\"...\"\n" + "     //    //  \n" + "    ^^    ^^");
			return true;
		} else {
			return false;
		}
	}
	
	// Makes time go forward in cows day/night cycle
	public boolean tick() {
		if (currentTurn >= 0 && currentTurn < 8) {
			++currentTurn;
			cowAwake = true;
			return true;
		} else if (currentTurn >= 8 && currentTurn < 10) {
			++currentTurn;
			cowAwake = false;
			cowTired = 0;
			return true;
		} else if (currentTurn == 10) {
			currentTurn = 0;
			cowAwake = true;
			if (cowHunger <= 50 && cowThirst <= 25) {
				cowBoredom -= 17;
			}
			++currentDay;
			return true;
		} else {
			return false;
		}
	}

	public boolean waterCow(int inputWaterTrough) {
		int randThirst = (rand.nextInt((7 - 3) + 1) + 3);
		if (inputWaterTrough >= 4) {
			cowThirst -= randThirst;
			System.out.println("You gave " + cowName + " some water!");
			return true;
		} else if (inputWaterTrough > 0 && inputWaterTrough < 4) {
			cowThirst -= randThirst;
			System.out.println("You gave " + cowName + " some water!");
			return true;
		} else if (inputWaterTrough <= 0) {
			System.out.println("You don't have any water!");
			System.out.println(cowName + " is annoyed!");
			++cowThirst;
			return true;
		} else {
			System.out.println("How the fuck did you get this result?");
			return false;
		}
	}
}

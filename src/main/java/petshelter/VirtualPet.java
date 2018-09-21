package petshelter;

import java.util.Random;
import java.util.Scanner;

public class VirtualPet {
	Scanner input = new Scanner(System.in);
	Random rand = new Random();
	String cowName = "Rose";							// Default name for cow
	String cowDesc = (cowName + " go moo");				// Default cow description
	int cowHunger = 0;									// out of 100
	int cowThirst = 0; 									// out of 50
	int cowTired = 0; 									// out of 3
	int cowBoredom = 0;									// out of 50
	int cowMilk = 0;									// out of 30
	int cowMood = 0;									// out of 100, determined by +Hunger, +Thirst, +Boredom, and -Milk
	int cowMetabolism = 0;								// 1 through 3, so three different metabolisms
	int randBoredom = rand.nextInt((8 - 3) + 1) + 3; 	// reduce boredom
	boolean dayTime = true;								// Is it day or night
	int currentTurn = 0;								// ranges from 1 to 8
	int currentDay = 0;									// no limit
	int unitsMilk = 0;									// placeholder variable for PetShelter to use as reference

	// Constructor with name and description
	public VirtualPet(String inputCowName, String inputCowDescription) {
		cowName = inputCowName;
		cowDesc = inputCowDescription;
	}
	
	public VirtualPet(String inputCowName, String inputCowDescription, int inputCowMetabolism, int inputCowHunger, int inputCowThirst) {
		cowName = inputCowName;
		cowDesc = inputCowDescription;
		cowMetabolism = inputCowMetabolism;
		cowHunger = inputCowHunger;
		cowThirst = inputCowThirst;
	}
	
	// graphic display
	// Need test
	public boolean affectionateGraphic() {
		if (cowMood <= 20 && dayTime) {
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
	// Need test
	public boolean angryGraphic() {
		if (cowMood > 80 && cowMood <= 100 && dayTime) {
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
	// Need test
	public boolean asleepGraphic() {
		if (!dayTime) {
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
		cowMood = (((cowThirst + cowHunger + cowBoredom)/2) + (cowMilk/2));
		if (cowMood <= 100 && cowMood >= 0) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	// graphic display
	// Need test
	public boolean happyGraphic() {
		if (cowMood > 20 && cowMood <= 40 && dayTime) {
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
		return true;
	}
	
	// graphic display
	// Need test
	public boolean normalGraphic() {
		if (cowMood > 40 && cowMood <= 60 && dayTime) {
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
	// Need to make tests
	public boolean playCow() {
		if (cowTired >= 2) {
			System.out.println(cowName +  " is tired as hell, and does NOT want to play");
			return false;
		} else if (cowBoredom <= 0) {
			System.out.println(cowName + "is content, and doesn't need to play");
			return false;
		} else {
			++cowTired;
			cowBoredom -= randBoredom;
			return true;
		}
	}
	
	// graphic display
	// Need test
	public boolean sadGraphic() {
		if (cowMood > 60 && cowMood <= 80 && dayTime) {
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
	
}

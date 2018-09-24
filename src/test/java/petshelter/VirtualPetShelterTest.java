package petshelter;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;
import org.junit.Assert;

@SuppressWarnings("unused")
public class VirtualPetShelterTest {
	
	@Test
	public void sanctuaryShouldHave3() {
		VirtualPetShelter underTest = new VirtualPetShelter("Balls");
		underTest.addCowToSanctuary("fuck", "piss", 4, 5);
		underTest.addCowToSanctuary("Ass", "piss", 3, 4);
		underTest.addCowToSanctuary("penis", "Motherfuck", 7, 8);
		int foo = underTest.cowsInThisBitch.size();
		assertThat(foo,is(3));
	}

	@Test
	public void addCowShouldReturn0() {
		VirtualPetShelter underTest = new VirtualPetShelter("Balls");
		underTest.addCowToSanctuary("fuck", "piss", 4, 5);
		underTest.addCowToSanctuary("Ass", "piss", 3, 4);
		underTest.addCowToSanctuary("penis", "Motherfuck", 7, 8);
		int foo = underTest.addCowToSanctuary("Shit", "Ass", 5, 10);
		assertThat(foo,is(0));
	}
	
	@Test
	public void addCowShouldReturn1() {
		VirtualPetShelter underTest = new VirtualPetShelter("Balls");
		underTest.addCowToSanctuary("fuck", "piss", 4, 5);
		underTest.addCowToSanctuary("Ass", "piss", 3, 4);
		underTest.addCowToSanctuary("penis", "Motherfuck", 7, 8);
		underTest.addCowToSanctuary("Pug", "piss", 3, 4);
		underTest.addCowToSanctuary("blah", "Motherfuck", 7, 8);
		int foo = underTest.addCowToSanctuary("Shit", "Ass", 5, 10);
		assertThat(foo,is(1));
	}
	
	@Test
	public void addCowShouldReturn2() {
		VirtualPetShelter underTest = new VirtualPetShelter("Balls");
		VirtualPet soo = new VirtualPet("go", "fast");
		VirtualPet too = new VirtualPet("be", "nice");
		underTest.addCowToSanctuary("fuck", "piss", 4, 5);
		underTest.addCowToSanctuary("Ass", "pies", 3, 4);
		underTest.addCowToSanctuary("penis", "Motherfuck", 7, 8);
		underTest.addCowToSanctuary("Pug", "piss", 3, 4);
		underTest.addCowToSanctuary("blah", "M", 7, 8);
		underTest.cowsInSanctuary.add(soo);
		underTest.cowsInSanctuary.add(too);
		int foo = underTest.addCowToSanctuary("Shit", "Ass", 5, 10);
		assertThat(foo,is(2));
	}
	
	@Test
	public void feedShouldReturn0() {
		VirtualPetShelter underTest = new VirtualPetShelter("Balls");
		underTest.addCowToSanctuary("fuck", "piss", 4, 5);
		underTest.totalFeed = 10;
		int balls = underTest.feedAllCows("regular");
		assertThat(balls,is(0));
	}
	
	@Test
	public void feedShouldReturn1() {
		VirtualPetShelter underTest = new VirtualPetShelter("Balls");
		underTest.addCowToSanctuary("fuck", "piss", 4, 5);
		underTest.totalFeed = 0;
		int balls = underTest.feedAllCows("regular");
		assertThat(balls,is(1));
	}
	
	@Test
	public void feedShouldReturn2() {
		VirtualPetShelter underTest = new VirtualPetShelter("Balls");
		underTest.addCowToSanctuary("fuck", "piss", 4000000, 5);
		underTest.totalFeed = 0;
		int balls = underTest.feedAllCows("regula");
		assertThat(balls,is(2));
	}
	
	@Test
	public void tickShouldReturnTrue() {
		VirtualPetShelter underTest = new VirtualPetShelter("Balls");
		for (underTest.currentTurn = 0; underTest.currentTurn <= 10; underTest.currentTurn++) {
			boolean foo = underTest.tick();
			assertThat(foo,is(true));
		}
	}
	
	@Test
	public void tickShouldReturnFalse() {
		VirtualPetShelter underTest = new VirtualPetShelter("Balls");
		underTest.currentTurn = 11;
		boolean foo = underTest.tick();
		assertThat(foo,is(false));
	}
}

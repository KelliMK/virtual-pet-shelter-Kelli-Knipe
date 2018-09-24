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
public class VirtualPetTest {
	/*
	@Test
	public void testExample() {
		// Arrange
		// VirtualPet underTest = new VirtualPet("Rose", "she has some big udders");
		// act
		// String anName = underTest.cowName;
		//assert
		// Assert.assertEquals("Rose", anName);
	}
	*/
	
	@Test
	public void shouldBeName() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "she has some big udders");
		// act
		String anName = underTest.cowName;
		//assert
		Assert.assertEquals("Rose", anName);
	}
	
	@Test
	public void shouldNotBeName() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "she has some big udders");
		// act
		String anName = underTest.cowName;
		//assert
		boolean blah = anName.equalsIgnoreCase("Barf");
		Assert.assertFalse(" ", blah);
	}
	
	@Test
	public void shouldBeDescription() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "she has some big udders");
		// act
		String anDesc = underTest.cowDesc;
		//assert
		Assert.assertEquals("she has some big udders", anDesc);
	}
	
	@Test
	public void shouldNotBeDescription() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "she has some big udders");
		// act
		String anDesc = underTest.cowDesc;
		boolean shouldBeFalse = anDesc.equalsIgnoreCase("barf nuggets");
		//assert
		Assert.assertFalse("", shouldBeFalse);
	}
	
	@Test
	public void shouldBeCowHunger() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 20, 15);
		// act
		int anHunger = underTest.cowHunger;
		// assert
		assertThat(anHunger,is(20));
	}
	
	@Test
	public void shouldNotBeCowHunger() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 20, 15);
		// act
		int anHunger = underTest.cowHunger;
		// assert
		assertThat(anHunger,is(not(5)));
	}
	
	@Test
	public void shouldBeCowThirst() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 20, 15);
		// act
		int aThirst = underTest.cowThirst;
		// assert
		assertThat(aThirst,is(15));
	}
	
	@Test
	public void shouldNotBeCowThirst() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 20, 15);
		// act
		int aMetabolism = underTest.cowThirst;
		// assert
		assertThat(aMetabolism,is(not(5)));
	}
	
	@Test
	public void shouldBeAcceptableMood() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 20, 15);
		// act
		boolean balls = underTest.calculateMood();
		// assert
		// Assert.assertTrue("", balls);
		assertThat(balls,is(true));
	}
	
	@Test
	public void shouldNotBeAcceptableMood() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 20000000, 15);
		// act
		boolean balls = underTest.calculateMood();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(false));
	}
	
	@Test
	public void shouldBeAffectionate() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 0, 15);
		// act
		underTest.calculateMood();
		boolean balls = underTest.affectionateGraphic();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(true));
	}
	
	@Test
	public void shouldNotBeAffectionate() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 20000000, 15);
		// act
		underTest.calculateMood();
		boolean balls = underTest.affectionateGraphic();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(false));
	}
	
	@Test
	public void shouldBeAngry() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 80, 100);
		// act
		underTest.calculateMood();
		boolean balls = underTest.angryGraphic();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(true));
	}
	
	@Test
	public void shouldNotBeAngry() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 20000000, 15);
		// act
		underTest.calculateMood();
		boolean balls = underTest.angryGraphic();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(false));
	}
	
	@Test
	public void shouldBeAsleep() {
		// tests asleepGraphic(), not tick()
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 80, 100);
		// act
		underTest.cowAwake = false;
		boolean balls = underTest.asleepGraphic();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(true));
	}
	
	@Test
	public void shouldNotBeAsleep() {
		// tests asleepGraphic(), not tick()
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 20000000, 15);
		// act
		underTest.cowAwake = true;
		boolean balls = underTest.asleepGraphic();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(false));
	}
	
	@Test
	public void shouldMakeMilk() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 80, 100);
		// act
		underTest.cowMilk = 10;
		boolean balls = underTest.milkCow();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(true));
	}
	
	@Test
	public void shouldNotMakeMilk() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 20000000, 15);
		// act
		underTest.cowMilk = 0;
		boolean balls = underTest.milkCow();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(false));
	}
	
	@Test
	public void shouldBeNormal() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 100, 0);
		// act
		underTest.calculateMood();
		boolean balls = underTest.normalGraphic();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(true));
	}
	
	@Test
	public void shouldNotBeNormal() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 0, 0);
		// act
		underTest.calculateMood();
		boolean balls = underTest.normalGraphic();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(false));
	}
	
	@Test
	public void shouldPlay() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 80, 100);
		// act
		underTest.cowBoredom = 5;
		underTest.cowTired = 0;
		boolean balls = underTest.playCow();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(true));
	}
	
	@Test
	public void tooTiredToPlay() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 20000000, 15);
		// act
		underTest.cowBoredom = 5;
		underTest.cowTired = 2;
		boolean balls = underTest.playCow();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(false));
	}
	
	@Test
	public void tooContentToPlay() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 20000000, 15);
		// act
		underTest.cowBoredom = 0;
		underTest.cowTired = 0;
		boolean balls = underTest.playCow();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(false));
	}
	
	@Test
	public void shouldBeSad() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 100, 40);
		// act
		underTest.calculateMood();
		boolean balls = underTest.sadGraphic();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(true));
	}
	
	@Test
	public void shouldNotBeSad() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 10, 40);
		// act
		underTest.calculateMood();
		boolean foo = underTest.sadGraphic();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(foo,is(false));
	}
	
	@Test
	public void shouldBeAwake() {
		// tests tick(), not asleepGraphic()
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 10, 40);
		// act
		for (underTest.currentTurn = 0; underTest.currentTurn < 8; underTest.currentTurn++) {
			underTest.tick();
			boolean foo = underTest.cowAwake;
			// assert
			// Assert.assertTrue("", balls);
			assertThat(foo,is(true));
		}
	}
	
	@Test
	public void shouldNotBeAwake() {
		// tests tick(), not asleepGraphic()
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 10, 40);
		boolean foo = underTest.cowAwake;
		underTest.currentTurn = 8;
		// act
		for (underTest.currentTurn = 8; underTest.currentTurn < 10; ++underTest.currentTurn) {
			underTest.tick();
			foo = underTest.cowAwake;
			
			// assert
			// Assert.assertFalse("", foo);
			assertThat(foo,is(false));
		}
	}
	
	@Test
	public void turnLimitSurpassed() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah");
		underTest.currentTurn = 11;
		// act
		boolean foo = underTest.tick();
		// assert
		assertThat(foo,is(false));
	}
}


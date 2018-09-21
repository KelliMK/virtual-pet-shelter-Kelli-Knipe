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
	public void shouldBeCowMetabolism() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 1, 20, 15);
		// act
		int aMetabolism = underTest.cowMetabolism;
		//assert
		Assert.assertEquals(1, aMetabolism);
	}
	
	@Test
	public void shouldNotBeCowMetabolism() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 1, 20, 15);
		// act
		int aMetabolism = underTest.cowMetabolism;
		// boolean shouldBeFalse = (aMetabolism == 5);
		// assert
		// Assert.assertFalse("", shouldBeFalse);
		assertThat(aMetabolism,is(not(5)));
	}
	
	@Test
	public void shouldBeCowHunger() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 1, 20, 15);
		// act
		int anHunger = underTest.cowHunger;
		// assert
		assertThat(anHunger,is(20));
	}
	
	@Test
	public void shouldNotBeCowHunger() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 1, 20, 15);
		// act
		int anHunger = underTest.cowHunger;
		// assert
		assertThat(anHunger,is(not(5)));
	}
	
	@Test
	public void shouldBeCowThirst() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 1, 20, 15);
		// act
		int aThirst = underTest.cowThirst;
		// assert
		assertThat(aThirst,is(15));
	}
	
	@Test
	public void shouldNotBeCowThirst() {
		// Arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 1, 20, 15);
		// act
		int aMetabolism = underTest.cowThirst;
		// assert
		assertThat(aMetabolism,is(not(5)));
	}
	
	@Test
	public void shouldBeAcceptableMood() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 1, 20, 15);
		// act
		boolean balls = underTest.calculateMood();
		// assert
		// Assert.assertTrue("", balls);
		assertThat(balls,is(true));
	}
	
	@Test
	public void shouldNotBeAcceptableMood() {
		// arrange
		VirtualPet underTest = new VirtualPet("Rose", "blah blah blah", 1, 200000000, 15);
		// act
		boolean balls = underTest.calculateMood();
		// assert
		// Assert.assertFalse("", balls);
		assertThat(balls,is(false));
	}
}


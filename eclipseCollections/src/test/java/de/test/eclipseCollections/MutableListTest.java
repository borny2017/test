package de.test.eclipseCollections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class MutableListTest {

	/**
	 * Mutable ('veraenderliche') list
	 */
	private MutableList<Person> people;

//	@BeforeEach
//	public void setUp() {
//		this.people = Lists.mutable.with(new Person("Harry", "Hamster").addPet(PetType.HAMSTER, "Fuzzy", 1).addPet(PetType.HAMSTER, "Wuzzy", 1));
//	}
	
	@BeforeEach
	public void setUp() {
		this.people = Lists.mutable.with(new Person("Mary", "Smith").addPet(PetType.CAT, "Tabby", 2),
				new Person("Bob", "Smith").addPet(PetType.CAT, "Dolly", 3).addPet(PetType.DOG, "Spot", 2),
				new Person("Ted", "Smith").addPet(PetType.DOG, "Spike", 4),
				new Person("Jake", "Snake").addPet(PetType.SNAKE, "Serpy", 1),
				new Person("Barry", "Bird").addPet(PetType.BIRD, "Tweety", 2),
				new Person("Terry", "Turtle").addPet(PetType.TURTLE, "Speedy", 1),
				new Person("Harry", "Hamster").addPet(PetType.HAMSTER, "Fuzzy", 1).addPet(PetType.HAMSTER, "Wuzzy", 1));
	}

	/**
	 * anySatisfyWith returns true, if the people list contains Person instance with Person.hasPet(PetType.CAT)==true
	 */
	@Test
	public void testAnySatisfyWith() {
		boolean anyPeopleHaveCats =
				  this.people
				    .anySatisfyWith(Person::hasPet, PetType.CAT);
		Assert.assertTrue(anyPeopleHaveCats);
	}

	/**
	 * countWith returns the found person instance with Person.hasPet(PetType.CAT)==true
	 */
	@Test
	public void testCountWith() {
		int countPeopleWithCats =
				  this.people
				    .countWith(Person::hasPet, PetType.CAT);
		Assert.assertEquals(new Integer(2), new Integer(countPeopleWithCats));
	}
	
	/**
	 * selectWith filters by given Predicate2 e.g. Person::hasPet, PetType.CAT
	 */
	@Test
	public void testSelectWith() {
		MutableList<Person> peopleWithCats = this.people
				    .selectWith(Person::hasPet, PetType.CAT);
		
		Assert.assertEquals(new Integer(2), new Integer(peopleWithCats.size()));
		for(Person person: peopleWithCats) {
			Assert.assertTrue(person.getPetTypes().contains(PetType.CAT));
		}
	}
	
	
	
}

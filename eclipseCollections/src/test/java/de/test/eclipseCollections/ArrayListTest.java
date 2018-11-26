package de.test.eclipseCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;


public class ArrayListTest {

	@Test
	public void testModify() {
		List<String> myList = new ArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");
		


		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println("List Value:" + value);
			if (value.equals("3"))
				myList.remove(value);
		}
		System.out.println(myList);
	}
}

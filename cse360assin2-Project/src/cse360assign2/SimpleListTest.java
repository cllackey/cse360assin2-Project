// 		 Author: Caden Lackey
// 	   Class ID: 333
// Assignment #: 1
// 	Description: This program uses JUnit to run test cases for SimpleList.java

package cse360assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//Test cases for SimpleList.java
class SimpleListTest {

	//Tests if the list is initialized
	@Test
	void testSimpleList() {
		SimpleList list = new SimpleList();
		assertNotNull(list);
	}
	
	//Checks if an element is added by checking the count
	@Test
	void testAdd() {
		SimpleList list = new SimpleList();
		list.add(1);
		assertEquals(list.count(), 1);
	}
	
	//Checks if an element is removed by checking the count
	@Test
	void testRemove() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(3);
		assertEquals(list.count(), 2);
		list.remove(1);
		assertEquals(list.count(), 1);
	}
	
	//Checks if the correct value of count is returned
	@Test
	void testCount() {
		SimpleList list = new SimpleList();
		list.add(2);
		assertEquals(list.count(), 1);
	}
	
	//Checks if the String is returned properly
	@Test
	void testToString() {
		SimpleList list = new SimpleList();
		assertEquals(list.toString(), "");
		list.add(1);
		list.add(2);
		list.add(4);
		assertEquals(list.toString(), "4 2 1");
	}
	
	//Checks if the added element can be found
	@Test
	void testSearch() {
		SimpleList list = new SimpleList();
		list.add(1);
		assertEquals(list.search(1), 0);
	}
}

// 		 Author: Caden Lackey
// 	   Class ID: 333
// Assignment #: 1
// 	Description: This program consists of a class, SimpleList, which creates a
//				 list of 10 elements that can be changed and specific 
//				 information can be returned. 

package cse360assign2;

/**
 * SimpleClass is the base class for a ten element list and its methods.
 * A SimpleClass object is capable of adding elements, removing elements,
 * returning the number of elements, searching for an element, and listing
 * the elements in a String.
 * <p>
 * The size of the list is based on the number of values added to it, and no
 * more than 10 elements can be added. If more 10 elements are added, the last
 * elements are removed from the list to keep the length at 10.
 * 
 * @author Caden Lackey
 *
 */
public class SimpleList {

	private int[] list;
	private int count;

	/**
	 * The sole constructor of the SimpleList {@link class}.
	 * <p>
	 * This constructor initializes the list array and count Integer.
	 */
	public SimpleList() {
		list = new int[10];

		for (int index = 0; index < 10; index++)
			list[index] = 0;

		count = 0;
	}

	/**
	 * Adds an element to the first index of the list.
	 * <p>
	 * This method has no return value and will shift all of the elements in
	 * the list to the right by one before adding the value argument. If all
	 * 10 indices are full, the last value will be removed from the list. The
	 * search method is used to determine the existence of the value.
	 * 
	 * @param value	the value that will be added to the beginning of the list
	 * @see			#search(int)
	 */
	
	public void add(int value) {
		for (int index = list.length - 2; index > -1; index--) {
			list[index + 1] = list[index];
		}

		list[0] = value;

		if (count < 10)
			count++;
	}

	/**
	 * Removes a specified element from the list.
	 * <p>
	 * This method has no return value and will shift all of the elements
	 * in the list proceeding the removed element to the left by one.
	 * If the element does not exist, nothing will happen
	 * 
	 * @param value	the value that will be removed from the list
	 */
	public void remove(int value) {
		int valueIndex = search(value);

		if (valueIndex != -1) {
			for (int index = valueIndex; index < count - 1; index++) {
				list[index] = list[index + 1];
				list[9] = 0;
			}

			count--;
		}
	}

	/**
	 * Returns the number of elements in the list.
	 * <p>
	 * This method returns the value of the variable count.
	 * 
	 * @return	the value of the variable count
	 */
	public int count() {
		return count;
	}

	/**
	 * Returns the list in a String.
	 * <p>
	 * This method returns puts the values of the list into a String with spaces between the 
	 * values and returns the final Strings.
	 * 
	 * @return	a String containing the values of the array list
	 */
	public String toString() {
		String listString = "";

		if (count > 0) {
			for (int index = 0; index < count - 1; index++)
				listString = listString + list[index] + " ";

			listString = listString + list[count - 1];
		}

		return listString;
	}

	/**
	 * Searches for index of the argument value in the list array.
	 * <p>
	 * This method determines the index of the argument value and returns the
	 * index as an integer. If the value does not exists in the list array,
	 * the method returns the value -1.
	 * 
	 * @param value	the value of which the index is being searched for
	 * @return		the index of the argument value
	 */
	public int search(int value) {
		int searchIndex = -1;

		for (int index = 0; index < count; index++)
			if (list[index] == value)
				searchIndex = index;

		return searchIndex;
	}
}
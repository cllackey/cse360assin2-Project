// 		 Author: Caden Lackey
// 	   Class ID: 333
// Assignment #: 1
// 	Description: This program consists of a class, SimpleList, which creates a
//				 list of 10 elements that can be changed and specific 
//				 information can be returned. 

package cse360assign2;
import java.lang.Math;

/**
 * SimpleClass is the base class for a ten element list and its methods.
 * A SimpleClass object is capable of adding elements, removing elements,
 * returning the number of elements, searching for an element, listing
 * the elements in a String, appending elements, and getting the first or
 * last element in the list.
 * <p>
 * The size of the list is based on the number of values added to it, and
 * will change in size to increase or decrease as necessary.
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

		//for (int index = 0; index < 10; index++)
		//	list[index] = 0;

		count = 0;
	}

	/**
	 * Adds an element to the first index of the list and increases the size
	 * if necessary.
	 * <p>
	 * This method has no return value and will shift all of the elements in
	 * the list to the right by one before adding the value argument. If all
	 * of the indices have elements, the size of the array is increased by
	 * 50%, rounded down to the lowest integer.
	 * 
	 * @param value	the value that will be added to the beginning of the list
	 */
	public void add(int value) {
		if (count == list.length) {
			int[] biggerList = new int[(int)Math.floor(list.length * 1.5f)];
			for (int index = 0; index < count; index++)
				biggerList[index] = list[index];
			list = biggerList;
		}
		for (int index = list.length - 2; index > -1; index--) {
			list[index + 1] = list[index];
		}

		list[0] = value;

		count++;
	}
	
	/**
	 * Adds an element to the end list and increases the size
	 * if necessary.
	 * <p>
	 * This method has no return value and adds the value to the end. If all
	 * of the indices have elements, the size of the array is increased by
	 * 50%, rounded down to the lowest integer.
	 * 
	 * @param value	the value that will be added to the end of the list
	 */
	public void append(int value)
	{
		if (count == list.length) {
			int[] biggerList = new int[(int)Math.floor(list.length * 1.5f)];
			for (int index = 0; index < count; index++)
				biggerList[index] = list[index];
			list = biggerList;
		}
		list[count + 1] = value;
		
		count++;
	}

	/**
	 * Removes a specified element from the list.
	 * <p>
	 * This method has no return value and will shift all of the elements
	 * in the list proceeding the removed element to the left by one. If the
	 * array is more than 25% empty, the size is decreased by 25%  rounded down
	 * to the nearest integer. If the element does not exist, nothing will happen
	 * 
	 * @param value	the value that will be removed from the list
	 * @see			#search(int)
	 */
	public void remove(int value) {
		int valueIndex = search(value);
		
		if (valueIndex != -1) {
			for (int index = valueIndex; index < count - 1; index++) {
				list[index] = list[index + 1];
				list[list.length - 1] = 0;
			}

			count--;
		}
		float emptyRatio = (float)(list.length - count) / (float)list.length;
		if (emptyRatio > 0.25 && list.length > 1)
		{
			int[] smallerList = new int[(int)Math.floor(list.length * 0.75f)];
			for (int index = 0; index < smallerList.length; index++)
				smallerList[index] = list[index];
			list = smallerList;
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
	
	/**
	 * Returns the first element in the list.
	 * <p>
	 * This method will return the first value in the list. If there are no
	 * values in the list, then the method will return -1.
	 * 
	 * @return	the first value in the list. If empty, then returns -1.
	 */
	public int first()
	{
		int returnValue = -1;
		if (count > 0)
			returnValue = list[0];
		return returnValue;
	}
	
	/**
	 * Returns the last element in the list.
	 * <p>
	 * This method will return the last value in the list. If there are no
	 * values in the list, then the method will return -1.
	 * 
	 * @return	the last value in the list. If empty, then returns -1.
	 */
	public int last()
	{
		int returnValue = -1;
		if (count > 0)
			returnValue = list[count - 1];
		return returnValue;
	}
	
	/**
	 * Returns the number of possible locations in the list;
	 * <p>
	 * This method will return all possible locations in the list whether or
	 * not a value has been assigned to them.
	 * 
	 * @return	the number of possible locations in the list.
	 */
	public int size()
	{
		return list.length;
	}
}
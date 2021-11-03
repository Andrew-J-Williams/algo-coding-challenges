package com.challenges.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * 
	Product Sum
	
	Write a function that takes in a special array and returns its product sum.
	
	A "special array" is a non-empty array that either contains integers or other "special" arrays. The product sum of a "special array" is the sum of its elements,
	where "special" arrays inside it are summed themselves and then multiplied by their level of depth.
	
	The depth of a "special" array is how far nested it is. For instance, the depth of '[]' is 1; the depth of the inner array in '[[]]' is 2; the depth of the innermost
	array in '[[[]]]' is 3.
	
	Therefore, the product sum of '[x, y]' is x + y; the product sum of [x, [y, x] is x + 2 * (y + z); the product sum of [x, [y, [z]]] is x + 2 * (y + 3z).
	
	Sample Input:
	array = [ 5, 2, [ 7, -1 ], 3, [ 6, [ -13, 8 ], 4 ]]
	
	Sample Output:
	12 // calculated as 5 + 2 + 2 * (7 - 1) + 3 + 2 * (6 + 3 * (-13 + 8) + 4) 
 * 
 */

public class ProductSum {

	// Tip: You can use `element instanceof ArrayList` to check whether an item
	// is an array or an integer.

	// 1. We create a method that takes in an ArrayList of objects
	public static int productSum(List<Object> array) {

		// 2. We return our recursive method that accepts the ArrayList, the array depth level (m), and the running sum.
		return productSumCalc(array, 1, 0);
		
	}
	
	// 3. Our recursive function accepts the parameters previously listed, returning an integer.
	public static int productSumCalc(List<Object> array, int m, int sum) {
		
		// 4. We use a 'for' loop to iterate over each object in the array, represented by 'x'.
		for(Object x : array) {
			
			// 5. If x is a "special" array (which we determine through the use of 'instanceof'...
			if(x instanceof ArrayList) {
				
				// ...then we create a new ArrayList and set it equal to x converted to and ArrayList type...
				ArrayList<Object> newArray = (ArrayList<Object>) x;
				
				// ...and run our function again with the new ArrayList plus incrementing m by 1. We add the result to our running sum.
				sum += productSumCalc(newArray, m+1, 0);
			
			// 6. If the object is just an number...	
			} else {
				
				// ...then we convert x's type to 'int' and add it to our running sum.
				sum += (int) x;
			}
		}
		
		// 7. Once we have iterated over the entire ArrayList, we return our running sum times m.
		return sum * m;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object> array1 = new ArrayList<>();
		List<Object> array2 = new ArrayList<>();
		List<Object> array3 = new ArrayList<>();
		List<Object> array4 = new ArrayList<>();
		
		array4.add(7);
		array4.add(-1);
		
		array3.add(-13);
		array3.add(8);
		
		array2.add(6);
		array2.add(array3);
		array2.add(4);
		
		array1.add(5);
		array1.add(2);
		array1.add(array4);
		array1.add(3);
		array1.add(array2);
		

		System.out.println(productSum(array1));
	}

}

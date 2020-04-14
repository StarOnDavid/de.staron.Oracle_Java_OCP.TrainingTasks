package _200414_Deque_Palindrom;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deque_Palindrom {

	public static void main(String[] args) {
		Character[] arr = { 'a', 'n', 'n', 'a' };
	    
		boolean erg = isPalindrome(arr);
		System.out.println(erg); // true
	  
		arr = new Character[] { 'r', 'o', 't', 'o', 'r' };
		erg = isPalindrome(arr);
		System.out.println(erg); // true

		arr = new Character[] { 'm', 'o', 't', 'o', 'r' };
		erg = isPalindrome(arr);
		System.out.println(erg); // false 
	}
	
	public static boolean isPalindrome(Character[] arr) {
		Deque<Character> deque = new ArrayDeque<>();
		for(Character c : arr) {
			deque.add(c);
		}
		while(!deque.isEmpty()) {
			if(deque.size() == 1) {
				return true;
			}

			if(deque.removeFirst() != deque.removeLast()) {
				return false;
			}
		}
		return true;
	}
}

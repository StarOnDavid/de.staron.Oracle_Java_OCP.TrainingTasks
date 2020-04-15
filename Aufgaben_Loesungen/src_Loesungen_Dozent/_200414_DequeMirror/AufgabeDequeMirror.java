package _200414_DequeMirror;

import java.util.ArrayDeque;
import java.util.Deque;

class Mirror {
	private Deque<Character> deque = new ArrayDeque<>();
	
	public Mirror() {
		deque.add('|');
	}
	
	public void add(char ch) {
		deque.addFirst(ch);
		deque.addLast(ch);
	}
	
	public void remove() {
		deque.removeFirst();
		deque.removeLast();
	}
	
	public boolean isEmpty() {
		return deque.size()==1;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Character c : deque) {
			sb.append(c);
		}
		
		return sb.toString();
	}
}

public class AufgabeDequeMirror {

	public static void main(String[] args) {

		Mirror m = new Mirror();
		
		for (char ch = 'a'; ch < 'g'; ch++) {
			m.add(ch);
			System.out.println(m);
		}
		
		while( !m.isEmpty() ) {
			System.out.println(m);
			m.remove();
		}
		
	}

}

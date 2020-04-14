package _200414_Deque_Mirror;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Mirror {
	private Deque<Character> mir = new ArrayDeque<>();
	
	public void add(Character c) {
		mir.addFirst(c);
		mir.addLast(c);
	}
	
	public void remove() {
		mir.removeFirst();
		mir.removeLast();
	}
	
	public boolean isEmpty( ) {
		return mir.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		Iterator<Character> it = mir.iterator();
		for(int i = 0; i < mir.size(); i++) {
			out.append(it.next());
			if(i == (mir.size()/2)-1) {
				out.append(" | ");
			}
		}
		return out.toString();
	}
	
	

}

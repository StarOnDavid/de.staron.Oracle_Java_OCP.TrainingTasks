package _200407_List_Iterable;

import java.util.Iterator;

public class MyList implements Iterable<String>{
	private String[] list = new String[10];
	
	public void add(String element) {
		for(int i = 0; i < list.length; i++) {
			if(list[i] == null) {
			list[i] = element;
			return;
			}		
		}
		throw new MyListIsFullException();
	}
	
	public int size() {
		int size = 0;
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				size++;
			}
		}
		return size;
	}
	
	public String get(int idx) {
		if(idx < 0 || idx > 9)
			throw new MyListIndexOutOfBoundsException();
		return list[idx];
	}
	
	public boolean remove(int idx) {
		if(idx < 0 || idx > 9)
			throw new MyListIndexOutOfBoundsException();
		if(list[idx] == null)
			return false;
		list[idx] = null;
		return true;
	}
	
	
	@SuppressWarnings("serial")
	public static class MyListIsFullException extends RuntimeException {
		MyListIsFullException() {
			super("'MyList' can only store 10 elements!");
		}
	}
	
	@SuppressWarnings("serial")
	public static class MyListIndexOutOfBoundsException extends IndexOutOfBoundsException {
		MyListIndexOutOfBoundsException() {
			super("Index out of bounds! 'MyList' Index reach from 0 to 9!!!");
		}
	}

	@Override
	public Iterator<String> iterator() {
		Iterator<String> it = new Iterator<String>() {
			private int[] elementsIdx;
			private int idx = 0;
			{
				this.elementsIdx = new int[size()];
				for(int i = 0; i < list.length; i++) {
					if(list[i] != null) {
						elementsIdx[idx++] = i;
					}
				}
				idx = 0;
			}
			
			@Override
			public boolean hasNext() {
				if (idx < elementsIdx.length)
					return true;
				return false;
			}

			@Override
			public String next() {
				return list[elementsIdx[idx++]];
			}
		};
		return it;
	}
}


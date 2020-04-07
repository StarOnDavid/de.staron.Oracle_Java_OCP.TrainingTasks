package _200407_List_Iterable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import _200407_List_Iterable.MyList.MyListIndexOutOfBoundsException;
import _200407_List_Iterable.MyList.MyListIsFullException;

class MyListTest {

	@Test
	void testCreateList() {
		MyList list = new MyList();
		assertTrue(list instanceof MyList);
	}

	@Test
	void testAddToList() {
		MyList list = new MyList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		list.add("h");
		list.add("i");
		list.add("j");
		try {
			list.add("k");
		} catch (MyListIsFullException e) {
			assertEquals("'MyList' can only store 10 elements!", e.getMessage());
		}
	}
	
	@Test
	void testSizeOfList() {
		MyList list = new MyList();
		assertEquals(0, list.size());
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		assertEquals(4, list.size());
		list.add("e");
		list.add("f");
		assertEquals(6, list.size());
		list.add("g");
		list.add("h");
		list.add("i");
		list.add("j");
		assertEquals(10, list.size());
	}
	
	@Test
	void testGetFromList() {
		MyList list = new MyList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		assertEquals("a", list.get(0));
		assertEquals("d", list.get(3));
		assertEquals(null, list.get(8));
		
		try {
			list.get(-1);
		} catch (MyListIndexOutOfBoundsException e) {
			assertTrue(e instanceof MyListIndexOutOfBoundsException);
		}
		try {
			list.get(10);
		} catch (MyListIndexOutOfBoundsException e) {
			assertTrue(e instanceof MyListIndexOutOfBoundsException);
		}
	}
	
	@Test
	void testRemoveFromList() {
		MyList list = new MyList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		assertFalse(list.remove(7));
		assertTrue(list.remove(2));
		assertFalse(list.remove(2));
		
		try {
			list.remove(10);
		} catch (MyListIndexOutOfBoundsException e) {
			assertTrue(e instanceof MyListIndexOutOfBoundsException);
		}
	}
	
	@Test
	void testIterratorForList() {
		MyList list = new MyList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.remove(2);
		Iterator<String> it = list.iterator();
		assertTrue(it.hasNext());
		assertEquals("a", it.next());
		assertTrue(it.hasNext());
		assertEquals("b", it.next());
		assertTrue(it.hasNext());
		assertEquals("d", it.next());
		assertFalse(it.hasNext());
	}
	
	@Test
	void testIterratorForListWithForEach() {
		MyList list = new MyList();
		list.add("1");
		list.add("2");
		list.add("7");
		list.add("3");
		list.remove(2);
		int i = 1;
		for(String e : list) {
			assertEquals(i++, Integer.parseInt(e));
		}
	}
}

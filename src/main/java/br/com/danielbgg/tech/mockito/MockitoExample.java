package br.com.danielbgg.tech.mockito;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

public class MockitoExample {

	public static void main(String[] args) {
//		a();
//		b();
//		c();
//		d();
		e();
	}

	public static void a() {
		// mock creation
		List mockedList = mock(List.class);

		// using mock object
		mockedList.add("one");
		mockedList.clear();

		// verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}

	public static void b() {
		// You can mock concrete classes, not only interfaces
		LinkedList mockedList = mock(LinkedList.class);

		// stubbing
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());

		// following prints "first"
		System.out.println(mockedList.get(0));

		try {
			// following throws runtime exception
			System.out.println(mockedList.get(1));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// following prints "null" because get(999) was not stubbed
		System.out.println(mockedList.get(999));

		// Although it is possible to verify a stubbed invocation, usually it's
		// just redundant
		// If your code cares what get(0) returns then something else breaks
		// (often before even verify() gets executed).
		// If your code doesn't care what get(0) returns then it should not be
		// stubbed. Not convinced? See here.
		verify(mockedList).get(0);
	}

	public static void c() {
		LinkedList mockedList = mock(LinkedList.class);

		// using mock
		mockedList.add("once");

		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		// following two verifications work exactly the same - times(1) is used
		// by default
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");

		// exact number of invocations verification
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");

		// verification using never(). never() is an alias to times(0)
		verify(mockedList, never()).add("never happened");

		// verification using atLeast()/atMost()
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("five times");
		verify(mockedList, atMost(5)).add("three times");
	}

	public static void d() {
		LinkedList mockedList = mock(LinkedList.class);
		doThrow(new RuntimeException()).when(mockedList).clear();

		// following throws RuntimeException:
		mockedList.clear();
	}

	public static void e() {
		List list = new LinkedList();
		List spy = spy(list);

		// optionally, you can stub out some methods:
		when(spy.size()).thenReturn(100);

		// using the spy calls *real* methods
		spy.add("one");
		spy.add("two");

		// prints "one" - the first element of a list
		System.out.println(spy.get(0));

		// size() method was stubbed - 100 is printed
		System.out.println(spy.size());

		// optionally, you can verify
		verify(spy).add("one");
		verify(spy).add("two");
	}

}

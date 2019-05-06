package sdet_course;

import java.util.ArrayList;
import java.util.Arrays;

class A {

	public String compareTwoStrings(String word1, String word2) {

		try {
			if (word1.equals(word2)) {
				return "These 2 words are equal";
			} else {
				return "These 2 words are not equal";
			}
		} catch (NullPointerException ex) {
			return "You can't compare null objects";
		}

	}

	public void greaterThanFour(String value) {

		if (value.length() > 4) {
			System.out.println(value);
		} else {
			char[] charArray = value.toCharArray();
			System.out.println(Arrays.toString(charArray));
		}
	}

	public enum Sort {
		ASC, DESC
	}

	public void sortAscDesc(ArrayList<String> arrayList, Sort sort) {

		String temp;

		if (sort == Sort.ASC) {

			for (int i = 0; i < arrayList.size() - 1; i++) {

				for (int j = i + 1; j < arrayList.size(); j++) {

					if (arrayList.get(i) != null && arrayList.get(j) != null) {

						if (arrayList.get(i).compareTo(arrayList.get(j)) > 0) { // > for Ascending order

							temp = arrayList.get(i);

							arrayList.set(i, arrayList.get(j));

							arrayList.set(j, temp);
						}

					}

				}

			}

			System.out.println(arrayList);

		}

		if (sort == Sort.DESC) {

			for (int i = 0; i < arrayList.size() - 1; i++) {

				for (int j = i + 1; j < arrayList.size(); j++) {

					if (arrayList.get(i) != null && arrayList.get(j) != null) {

						if (arrayList.get(i).compareTo(arrayList.get(j)) < 0) { // < for Descending order

							temp = arrayList.get(i);

							arrayList.set(i, arrayList.get(j));

							arrayList.set(j, temp);
						}

					}

				}

			}

			System.out.println(arrayList);

		}

	}

	public void withoutNull(ArrayList<String> arrayList2) {

		while (arrayList2.remove(null)) {

		}
		
		for (String object : arrayList2) {
			System.out.println(object);

		}

	}

	public void missingNumber() {
		
		int[] input = {2,2,3,4,4,5,6,7,8,10};

		int[] register = new int[input.length + 1];		
		
		
		for (int i : input) {
			register[i] = 1;	
		}

		
		for (int i = 1; i < register.length; i++) {
			if (register[i] == 0) {
				System.out.println(i);
			}

		}

	}
}

class B extends A implements one {

	@Override
	public void greaterThanFour(String value) {
		System.out.println("Printing from class B");
		super.greaterThanFour(value);
	}

	@Override
	public void printHello() {
		System.out.println("Hello Interface");

	}

}

interface one {

	public void printHello();

}

public class Main {

	public static void main(String[] args) {

		A aClass = new A();
		aClass.greaterThanFour("hol");

		B greaterB = new B();
		greaterB.greaterThanFour("Jua");

		B print = new B();
		print.printHello();

		A sorting = new A();
		ArrayList<String> arrayList = new ArrayList<String>();

		// Add elements to ArrayList
		arrayList.add("Text");
		arrayList.add("Baseball");
		arrayList.add("Automation");
		arrayList.add("Java");
		arrayList.add("Laptop");
		arrayList.add(null);

		sorting.sortAscDesc(arrayList, A.Sort.ASC);
		
		A without = new A();
		
		ArrayList<String> arrayList2 = new ArrayList<String>();

		// Add elements to ArrayList
		arrayList2.add("Text");
		arrayList2.add("Baseball");
		arrayList2.add("Automation");
		arrayList2.add("Java");
		arrayList2.add(null);
		arrayList2.add("Laptop");
		
		without.withoutNull(arrayList2);
		
		aClass.missingNumber();
	}
}

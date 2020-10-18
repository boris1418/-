package com.company;

import java.util.ArrayList;

public class Main {

	public static int errors = 0;
	public static boolean allTestsPassed = true;

    public static void main(String[] args) {
		whiteListTest();
		boundedWhiteListTest();
		unfairWaitListTest();
		if (Main.allTestsPassed) {
			System.out.println("All tests work good!");
		}
    }

    public static void whiteListTest() {

		WaitList<Integer> wl0 = new WaitList<>();
		wl0.add(5);
		wl0.add(100);
		wl0.add(134);
		wl0.add(200);

		myAssert(wl0.remove() == 5, "Error in add or remove");

		ArrayList<Integer> list = new ArrayList<>();
		list.add(7);
		list.add(99);
		WaitList<Integer> wl1 = new WaitList<>(list);

		myAssert(wl1.remove() == 99, "Collection cunstructor is wrong");

		if (Main.errors == 0) {
			System.out.println("WaitList works without errors!");
		}
		Main.errors = 0;

	}

	public static void boundedWhiteListTest() {

		BoundedWaitList<Integer> bwl0 = new BoundedWaitList<>(3);

		bwl0.add(5);
		bwl0.add(100);
		bwl0.add(134);
		bwl0.add(200);
		bwl0.add(55);

		myAssert(bwl0.remove() == 5, "Error in add or remove");

		ArrayList<Integer> listCont = new ArrayList<>();

		while (!bwl0.isEmpty()) {
			listCont.add(bwl0.remove());
		}

		myAssert(listCont.size() == 2, "Error with bounds, too much elements");

		if (Main.errors == 0) {
			System.out.println("BoundedWaitList works without errors!");
		}
		Main.errors = 0;
	}

	public static void unfairWaitListTest() {
		UnfairWaitList<Integer> uwl0 = new UnfairWaitList<>();
		uwl0.add(5);
		uwl0.add(100);
		uwl0.add(134);
		uwl0.add(200);

		uwl0.moveToBack(5);
		myAssert(uwl0.remove() == 100, "Move to back works wrong");
		uwl0.add(9);
		uwl0.remove(134);
		myAssert(uwl0.remove() == 200, "Remove by Element works wrong");
		if (Main.errors == 0) {
			System.out.println("BoundedWaitList works without errors!");
		}
		Main.errors = 0;
	}

	public static void myAssert(boolean f, String errorMessage) {
    	if (!f) {
			System.out.println(errorMessage);
			Main.errors++;
			Main.allTestsPassed = false;
		}
	}
}

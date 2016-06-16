package org.adamsmith.stage2;

import java.util.Comparator;


class ListOfArraysComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		Object[] a1 = (Object[]) o1; // could throw ClassCastException -- good
		Object[] a2 = (Object[]) o2;
		
		if(a1.length != a2.length) {
			throw new RuntimeException();
		}

		float f1 = ((Float) a1[0]).floatValue();
		float f2 = ((Float) a2[0]).floatValue();
		
		return Float.compare(f1, f2);
	}
}
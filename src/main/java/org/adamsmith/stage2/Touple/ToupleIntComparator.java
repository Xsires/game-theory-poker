package org.adamsmith.stage2.Touple;

import java.util.Comparator;

/**
 * @author Adam
 *
 */
public class ToupleIntComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		// these are ToupleFloatInts...sort on float value
		int thisV = ((ToupleFloatInt) arg0).o2;
		int thatV = ((ToupleFloatInt) arg1).o2;
		if(thisV < thatV) {
			return -1;
		} else if(thisV > thatV) {
			return 1;
		} else {
			return 0;
		}
	}

}

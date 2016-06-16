package org.adamsmith.stage2.Touple;

import java.util.Comparator;
import java.util.Map;

/**
 * @author Adam
 *
 */
public class ToupleFloatComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		// these are ToupleFloatInts...sort on float value
		float thisV = ((ToupleFloatInt) arg0).o1;
		float thatV = ((ToupleFloatInt) arg1).o1;
		if(thisV < thatV) {
			return -1;
		} else if(thisV > thatV) {
			return 1;
		} else {
			return 0;
		}
	}
}

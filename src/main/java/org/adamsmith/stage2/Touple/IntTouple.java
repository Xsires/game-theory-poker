package org.adamsmith.stage2.Touple;

import java.util.*;
import org.adamsmith.misc.*;

/**
 * @author Adam
 *
 */
public class IntTouple {

	public int[] x;
	
	public IntTouple(int[] x) {
		this.x = x;
	}
	
	public int hashCode() {
		return Helper.hashIntArray(x);
	}
	
	public boolean equals(Object obj) {
		// assume obj is an IntTouple
		return Arrays.equals(x, ((IntTouple) obj).x);
	}

}

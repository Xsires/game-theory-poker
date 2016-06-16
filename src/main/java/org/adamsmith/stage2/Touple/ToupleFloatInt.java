package org.adamsmith.stage2.Touple;

/**
 * @author Adam
 *
 */
public class ToupleFloatInt {

	public float o1;
	public int o2;
	
	public ToupleFloatInt(float o1, int o2) {
		this.o1 = o1;
		this.o2 = o2;
	}
	
	public String toString() {
		return "(" + o1 + ", " + o2 + ")";
	}
}

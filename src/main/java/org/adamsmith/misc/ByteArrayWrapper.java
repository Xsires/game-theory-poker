package org.adamsmith.misc;

import java.util.Arrays;

/**
 * @author Adam
 *
 */
public class ByteArrayWrapper {
	public byte[] array;
	
	public ByteArrayWrapper(byte[] array) {
		this.array = array;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof ByteArrayWrapper)) {
			return false;
		}
		return Arrays.equals(array, ((ByteArrayWrapper)obj).array);
	}
	
	public int hashCode() {
		return Helper.hashByteArray(array);
	}
}

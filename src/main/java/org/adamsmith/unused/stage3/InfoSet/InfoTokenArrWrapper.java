package org.adamsmith.unused.stage3.InfoSet;
import org.adamsmith.stage3.InfoSet.InfoToken;
import java.io.*;

/**
 * @author Adam
 *
 */
public class InfoTokenArrWrapper implements Serializable {

	public final InfoToken[] itArray;
	
	public InfoTokenArrWrapper(InfoToken[] x) {
		itArray = x;
	}
	
	public int hashCode() {
		int result = 0;
		for(int i = 0; i < itArray.length; i++) {
			result ^= itArray[i].hashCode();
		}
		
		return result;
	}
	
	public boolean equals(Object obj) {
		InfoTokenArrWrapper other = (InfoTokenArrWrapper) obj;
		if(other.itArray.length != itArray.length) {
			return false;
		}
		for(int i = 0; i < itArray.length; i++) {
			if(!other.itArray[i].equals(itArray[i])) {
				return false;
			}
		}
		return true;
	}
	
}

package  org.adamsmith.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

import org.adamsmith.misc.Constants;

/**
 * @author Adam
 *
 */
public class ReadBinarySolutionMap {

	public static Map getSolutionMap(String fileName, boolean isP1Solution) throws Exception {

		FileInputStream fis = new FileInputStream(fileName);
		DataInputStream dis = new DataInputStream(fis);
		
		// read and verify format ID
		short formatID = dis.readShort();
		if(formatID != Constants.vidSolutionMap) {
			throw new RuntimeException();
		}
		
		// read header from file
		short header[] = new short[10];
		for(int i = 0; i < 10; i++) {
			header[i] = dis.readShort();
		}
		
		// process header
		if(header[0] == 1) {
			if(!isP1Solution) {
				throw new RuntimeException();
			}
		} else if(header[0] == 2) {
			if(isP1Solution) {
				throw new RuntimeException();
			}
		} else {
			throw new RuntimeException();
		}

		ObjectInputStream ois = new ObjectInputStream(dis);
		
		Map solWeights = (HashMap) ois.readObject();
		
		ois.close();
		dis.close();
		fis.close();

		return solWeights;
	}
	
}

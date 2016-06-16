package org.adamsmith.io;

import java.io.DataInputStream;
import java.io.FileInputStream;

import org.adamsmith.misc.Constants;

/**
 * @author Adam
 *
 */
public class ReadBinarySubtreeGame {
	
	public static Object[] getSubtreeGame(String fileName) throws Exception {

		FileInputStream fis = new FileInputStream(fileName);
		DataInputStream dis = new DataInputStream(fis);
		
		// read and verify format ID
		short formatID = dis.readShort();
		if(formatID != Constants.vidSubtreeGameDescription) {
			throw new RuntimeException();
		}
		
		// read header from file
		short header[] = new short[10];
		for(int i = 0; i < 10; i++) {
			header[i] = dis.readShort();
		}
		
		// process header
		// ...
		
		float p1Pot = dis.readFloat();
		float p2Pot = dis.readFloat();
		float[] pots = new float[] {p1Pot, p2Pot};
		
		int size = dis.readInt();
		double[][] startClusterPDT = new double[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				startClusterPDT[i][j] = dis.readDouble();
			}
		}
		
		dis.close();
		fis.close();

		return new Object[] {pots, startClusterPDT};
	}
	
}

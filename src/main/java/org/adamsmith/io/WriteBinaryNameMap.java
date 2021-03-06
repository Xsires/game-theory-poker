package org.adamsmith.io;

import java.io.*;

import org.adamsmith.misc.Constants;
import org.adamsmith.stage3.NameMap;

/**
 * @author Adam
 *
 */
public class WriteBinaryNameMap {

	public static void writeNameMap(String outFile, NameMap nameMap,
			int[] numClusters, int maxNumBoardCards) throws Exception{
		
		if(new File(outFile).exists()) {
			throw new RuntimeException("file already exists: " + outFile);
		}
		
		if(numClusters.length != 6) {
			throw new RuntimeException();
		}

		FileOutputStream fos = new FileOutputStream(outFile);
		DataOutputStream dos = new DataOutputStream(fos);
		
		// write version ID
		dos.writeShort(Constants.vidTreeNodeNameMap);

		//build header
		short[] header = new short[10];
		for(int i = 0; i < 6; i++) {
			header[i] = (short) numClusters[i];
		}
		header[6] = (short) maxNumBoardCards;
		for(int i = 7; i < 10; i++) {
			header[i] = 0;
		}

		//write header
		for(int i = 0; i < 10; i++) {
			dos.writeShort(header[i]);
		}

		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(nameMap);
		
		oos.close();
		dos.close();
		fos.close();
		
	}
	
}

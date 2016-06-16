package org.adamsmith.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.util.*;

import org.adamsmith.misc.Constants;

/**
 * @author Adam
 *
 */
public class WriteBinarySolutionMap {
	
	public static void writeSolutionMap(String outFile, Map solutionWeights, 
			boolean isP1Solution) throws Exception {
		
		if(new File(outFile).exists()) {
			throw new RuntimeException("file already exists: " + outFile);
		}

		FileOutputStream fos = new FileOutputStream(outFile);
		DataOutputStream dos = new DataOutputStream(fos);
		
		// write version ID
		dos.writeShort(Constants.vidSolutionMap);

		//build header
		short[] header = new short[10];
		if(isP1Solution) {
			header[0] = 1;
		} else {
			header[0] = 2;
		}
		for(int i = 1; i < 10; i++) {
			header[i] = 0;
		}

		//write header
		for(int i = 0; i < 10; i++) {
			dos.writeShort(header[i]);
		}
		
		ObjectOutputStream oos = new ObjectOutputStream(dos);

		oos.writeObject(solutionWeights);
		
		oos.close();
		dos.close();
		fos.close();
		
	}
}

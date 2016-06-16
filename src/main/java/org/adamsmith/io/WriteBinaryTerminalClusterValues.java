package org.adamsmith.io;

import java.io.File;
import java.io.IOException;

import org.adamsmith.misc.Constants;

/**
 * @author Adam
 *
 */
public class WriteBinaryTerminalClusterValues {
	
	public static void writeTerminalMatrix(String outFile, double[][] terminalValues, 
			int numClusters, int bufferSize) throws IOException {

		if(new File(outFile).exists()) {
			throw new RuntimeException("file already exists: " + outFile);
		}
		
		if(terminalValues.length != numClusters || terminalValues[0].length != numClusters) {
			throw new RuntimeException();
		}
		
		BurstBufferedWriter out = new BurstBufferedWriter(outFile, bufferSize);
		
		// write version ID
		out.writeShort(Constants.vidTerminalClusterValues);

		//build header
		short[] header = new short[10];
		header[0] = (short) numClusters;
		for(int i = 1; i < 10; i++) {
			header[i] = 0;
		}

		//write header
		for(int i = 0; i < 10; i++) {
			out.writeShort(header[i]);
		}
		
		for(int i = 0; i < numClusters; i++) {
			for(int j = 0; j < numClusters; j++) {
				out.writeDouble(terminalValues[i][j]);
			}
		}
		
		out.close();
	}
	
}

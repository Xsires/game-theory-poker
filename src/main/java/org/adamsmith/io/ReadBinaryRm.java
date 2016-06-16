package org.adamsmith.io;

import org.adamsmith.stage3.*;
import java.util.*;
import java.io.*;
import java.nio.*;

import org.adamsmith.misc.Constants;

/**
 * @author Adam
 *
 */
public class ReadBinaryRm {

	public static Object[] getRewardMatrix(String fileName, int bufferSize,
			int[] numClusters) throws IOException {
		
		BurstBufferedReader in = new BurstBufferedReader(fileName, bufferSize);
		
		// read and verify format ID
		short formatID = in.readShort();
		if(formatID != Constants.vidRewardMatrixElementList) {
			throw new RuntimeException();
		}

		// read header from file
		short header[] = new short[10];
		for(int i = 0; i < 10; i++) {
			header[i] = in.readShort();
		}
		
		// process header
		for(int i = 0; i < 6; i++) {
			if(header[i] != numClusters[i]) {
				throw new RuntimeException();
			}
		}
		int maxNumBoardCards = header[6];
			   
		List rewardMatrix = new ArrayList();
		int firstDim;
		int secondDim;
		float value;
		
		while(true) {
			try {
				firstDim = in.readInt();
				secondDim = in.readInt();
				value = in.readFloat();
				
				rewardMatrix.add(new RewardMatrixElement(firstDim, secondDim, value));
			} catch (BufferUnderflowException bue) {
				break;
			}
		}
		
		in.close();
		
		return new Object[] {rewardMatrix, new Integer(maxNumBoardCards)};
	}
}

package org.adamsmith.io;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.*;

import org.adamsmith.misc.Constants;

/**
 * @author Adam
 *
 */
public class WriteBinaryActionWeightList {
	
	public static void writeSolutionList(List in, String outFile, 
			int bufferSize) throws IOException {
		
		if(new File(outFile).exists()) {
			throw new RuntimeException("file already exists: " + outFile);
		}
		
		BurstBufferedWriter out = new BurstBufferedWriter(outFile, bufferSize);
		
		out.writeShort(Constants.vidSolutionList);
		
		//build header
		short[] header = new short[10];
		int listSize = in.size();
		header[0] = (short) listSize;
		header[1] = (short) (listSize>>16);
		for(int i = 2; i < 10; i++) {
			header[i] = 0;
		}
		
		//write header
		for(int i = 0; i < 10; i++) {
			out.writeShort(header[i]);
		}
		
		for(Iterator i = in.iterator(); i.hasNext(); ) {
			Map.Entry record = (Map.Entry) i.next();
			Integer name = (Integer) record.getKey();
			Float weight = (Float) record.getValue();
			
			out.writeInt(name.intValue());
			out.writeFloat(weight.floatValue());
		}
		
		out.close();		
	}
}

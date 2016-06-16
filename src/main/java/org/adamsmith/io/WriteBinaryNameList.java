package org.adamsmith.io;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.adamsmith.misc.Constants;
import org.adamsmith.stage3.InfoSet.InfoString;
import org.adamsmith.stage3.InfoSet.InfoToken;
import org.adamsmith.stage3.NameMap;

/**
 * @author Adam
 *
 */
public class WriteBinaryNameList {
	
	public static void writeNameList(List longNames, NameMap nm, int maxLongNameLength,
			String outFile, int bufferSize) throws IOException {
		
		if(new File(outFile).exists()) {
			throw new RuntimeException("file already exists: " + outFile);
		}
		
		BurstBufferedWriter out = new BurstBufferedWriter(outFile, bufferSize);
		
		out.writeShort(Constants.vidNameList);
		
		//build header
		short[] header = new short[10];
		int listSize = longNames.size();
		header[0] = (short) listSize;
		header[1] = (short) (listSize>>16);
		header[2] = (short) maxLongNameLength;
		for(int i = 3; i < 10; i++) {
			header[i] = 0;
		}
		
		//write header
		for(int i = 0; i < 10; i++) {
			out.writeShort(header[i]);
		}
		
		for(Iterator i = longNames.iterator(); i.hasNext(); ) {
			InfoString longName = (InfoString) i.next();
			
			for(int j = maxLongNameLength - 1; j >= longName.arr.length; j--) {
				out.writeByte(InfoToken.reservedToken);
			}
			for(int j = longName.arr.length - 1; j >= 0; j--) {
				out.writeByte(longName.arr[j]);
			}
			
			int shortName = nm.getShort(longName, false);
			if(shortName < 0) {
				throw new RuntimeException();
			}
			
			out.writeInt(shortName);
		}
		
		out.close();		
	}
}

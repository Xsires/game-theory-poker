package org.adamsmith.io;

import java.io.DataInputStream;
import java.io.*;
import java.io.ObjectInputStream;

import org.adamsmith.misc.Constants;
import org.adamsmith.stage3.NameMap;

/**
 * @author Adam
 *
 */
public class ReadBinaryNameMap {
	
	public static NameMap getNameMap(String fileName) throws Exception {

		FileInputStream fis = new FileInputStream(fileName);
		DataInputStream dis = new DataInputStream(fis);
		
		// read and verify format ID
		short formatID = dis.readShort();
		if(formatID != Constants.vidTreeNodeNameMap) {
			throw new RuntimeException();
		}
		
		// read header from file
		short header[] = new short[10];
		for(int i = 0; i < 10; i++) {
			header[i] = dis.readShort();
		}
		
		// process header
		// [...]

		ObjectInputStream ois = new ObjectInputStream(dis);
		
		NameMap toReturn = (NameMap) ois.readObject();

		ois.close();
		dis.close();
		fis.close();

		return toReturn;
	}

}

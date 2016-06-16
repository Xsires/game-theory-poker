package org.adamsmith.unused;
import org.adamsmith.misc.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Adam
 *
 */
public class CorrectBeginningOffset {
	static final int BUFFER_SIZE = -1;

	public static void fixOffset(String inFile) {
		try{
			String outFile = inFile + "cc";
    		BufferedWriter out = new BufferedWriter(new FileWriter(outFile), BUFFER_SIZE);
			BufferedReader in = new BufferedReader(new FileReader(inFile), BUFFER_SIZE);
			String line;

			line = in.readLine();
			char lastVal = line.charAt(0);
			char thisVal;
			int stage = 0;
			int counter = 0;
			while ((line = in.readLine()) != null) {
				thisVal = line.charAt(0);
				if(thisVal < lastVal) {
					stage++;
				}
				lastVal = thisVal;
				if(stage == 2) {
					break;
				}
				counter++;
			}
			
			out.write(line + "\n");
			while ((line = in.readLine()) != null) {
				out.write(line + "\n");
			}
			
			in.close();
			in = new BufferedReader(new FileReader(inFile), BUFFER_SIZE);
			for(int i = 0; i <= counter; i++) {
				out.write(in.readLine() + "\n");
			}
			
			in.close();
			out.close();
			
			
			File original = new File(inFile);
			File tmp = new File(outFile);
			
			original.delete();
			tmp.renameTo(new File(inFile+"c"));
			
		} catch (IOException e) {
			throw new RuntimeException();
		}
		
	}
}

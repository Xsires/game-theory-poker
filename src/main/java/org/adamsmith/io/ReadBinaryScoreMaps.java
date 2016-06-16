package org.adamsmith.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.adamsmith.stage1.HandRecord;
import org.adamsmith.stage1.ScoreMaps;
import org.adamsmith.misc.Constants;

/**
 * @author Adam
 *
 */
public class ReadBinaryScoreMaps {
	
	public static ScoreMaps getScoreMap(String fileName, int numBoardCards, int bufferSize) throws IOException {
		
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName), bufferSize));
		
		// read and verify format ID
		short formatID = dis.readShort();
		if(formatID != Constants.vidScoreMap_holeCardsConstant_boardCardsImplicit) {
			throw new RuntimeException();
		}
		
		// read header from file
		short header[] = new short[10];
		for(int i = 0; i < 10; i++) {
			header[i] = dis.readShort();
		}
		
		// process header
		byte[] holeCards = new byte[] { (byte)header[0], (byte)header[1] };
		if(numBoardCards != (byte)header[2]) {
			throw new RuntimeException("not right number of board cards");
		}

		ScoreMaps sm = new ScoreMaps((byte)numBoardCards, holeCards);
		HandRecord iterator = new HandRecord(numBoardCards, holeCards);
		short length;
		short score;
		int count;
		
		// THIS CODE HAS BEEN TESTED -- DO NOT TOUCH!!!!!!!!!!!!!!!!!!!!
		while(iterator.hasMoreElements) {
			iterator.advanceRecord();
			
			length = dis.readShort();
			
			for(int i = 0; i < length/6; i++) {
				score = dis.readShort();
				count = dis.readInt();
				sm.addScoreCountFromFile(iterator, score, count);
			}
		}
		
		dis.close();

		return sm;
	}
}

package org.adamsmith.stage1;


/**
 * @author Adam
 *
 */
public class HandRecordScore extends HandRecord {

	// CONTRACT SAYS THESE ARE for read only
	public short score;

	public HandRecordScore(int numBoardCards, byte[] holeCards) {
		super(numBoardCards, holeCards);
	}
	
	public HandRecordScore copy() {
		HandRecordScore yo = new HandRecordScore(this.numBoardCards, new byte[] {holeCards[0], holeCards[1]});
		super.copy(yo);

		yo.score = this.score;
		
		return yo;
	}
}
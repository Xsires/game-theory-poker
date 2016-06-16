package org.adamsmith.stage1;

/**
 * @author Adam
 *
 */
public class HandRecordScoreGroups extends HandRecord {

	public int[] scoreGroups;
	public int numScoreGroups;

	public HandRecordScoreGroups(int numBoardCards, byte[] holeCards, int numScoreGroups) {
		super(numBoardCards, holeCards);
		scoreGroups = new int[numScoreGroups];
		this.numScoreGroups = numScoreGroups;
	}
	
	public HandRecordScoreGroups copy() {
		HandRecordScoreGroups yo = new HandRecordScoreGroups(
				this.numBoardCards, new byte[] {holeCards[0], holeCards[1]}, numScoreGroups);
		super.copy(yo);

		for(int i = 0; i < scoreGroups.length; i++) {
			yo.scoreGroups[i] = this.scoreGroups[i];
		}
		
		return yo;
	}

}

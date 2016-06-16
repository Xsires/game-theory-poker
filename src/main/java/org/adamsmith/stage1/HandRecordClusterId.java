package org.adamsmith.stage1;

/**
 * @author Adam
 *
 */
public class HandRecordClusterId extends HandRecord {

	// CONTRACT SAYS THESE ARE for read only
	public byte clusterId;

	public HandRecordClusterId(int numBoardCards, byte[] holeCards) {
		super(numBoardCards, holeCards);
	}
	
	public HandRecordClusterId copy() {
		HandRecordClusterId yo = new HandRecordClusterId(this.numBoardCards, new byte[] {holeCards[0], holeCards[1]});
		super.copy(yo);

		yo.clusterId = this.clusterId;
		
		return yo;
	}

}

package org.adamsmith.unused.stage3.GameTree;

import org.adamsmith.stage3.InfoSet.InfoToken;
import org.adamsmith.unused.stage3.ContinueItem;
import org.adamsmith.unused.stage3.InfoSet.InfoSetPair;

import java.util.HashSet;
/**
 * @author Adam
 *
 */
public class EndRoundChoiceNode extends Node implements ChoiceNode {

	public TerminalLeafNode gtnFold;
	public ContinueItem ciCall;
	
	public EndRoundChoiceNode(ContinueItem ciToFill, int infoType) {
		super(ciToFill, new HashSet());
		
		InfoSetPair ispThisNode = ciToFill.ispChild;
		
		// we now must create two outcomes corresponding to the player's 2 choices
		/*
		// Choice 1: Fold
		InfoSetPair ispFold = ispThisNode.addInfoToBoth(
				new InfoToken(infoType, InfoToken.s_fold));
		gtnFold = new TerminalLeafNode(new ContinueItem(ispFold, this));

		// Choice 2: Call
		ciCall = new ContinueItem(
				ispThisNode.addInfoToBoth(new InfoToken(infoType, InfoToken.s_call)),
				this);
*/	}
}

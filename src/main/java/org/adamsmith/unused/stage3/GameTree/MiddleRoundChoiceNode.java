package org.adamsmith.unused.stage3.GameTree;


import org.adamsmith.stage3.InfoSet.InfoToken;
import org.adamsmith.unused.stage3.ContinueItem;
import org.adamsmith.unused.stage3.InfoSet.InfoSetPair;

import java.util.*;

/**
 * @author Adam
 *
 */
public class MiddleRoundChoiceNode extends Node implements ChoiceNode {

	public TerminalLeafNode gtnFold;
	public ContinueItem ciRaise;
	public ContinueItem ciCall;
	
	public MiddleRoundChoiceNode(ContinueItem ciToFill, int infoType) {
		super(ciToFill, new HashSet());
		
		InfoSetPair ispThisNode = ciToFill.ispChild;
		
		// we now must create three outcomes corresponding to the player's 3 choices
		
		// Choice 1: Fold
/*		InfoSetPair ispFold = ispThisNode.addInfoToBoth( );
		gtnFold = new TerminalLeafNode(new ContinueItem(ispFold, this));

		// Choice 2: Raise
		ciRaise = new ContinueItem(
				ispThisNode.addInfoToBoth(new InfoToken(infoType, InfoToken.s_raise)),
				this);

		// Choice 3: Check
		ciCall = new ContinueItem(
				ispThisNode.addInfoToBoth(new InfoToken(infoType, InfoToken.s_call)),
				this);*/
	}
	
}

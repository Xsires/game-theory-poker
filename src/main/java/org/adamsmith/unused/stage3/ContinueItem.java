package org.adamsmith.unused.stage3;

import org.adamsmith.unused.stage3.GameTree.Node;
import org.adamsmith.unused.stage3.InfoSet.InfoSetPair;

/**
 * @author Adam
 *
 */
public class ContinueItem {

	public InfoSetPair ispChild;
	public Node gtnParent;
	
	public ContinueItem(InfoSetPair ispChild, Node gtnParent) {
		this.ispChild = ispChild;
		this.gtnParent = gtnParent;
	}
}

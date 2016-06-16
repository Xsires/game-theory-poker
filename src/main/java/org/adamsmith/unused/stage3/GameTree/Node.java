package org.adamsmith.unused.stage3.GameTree;

import org.adamsmith.unused.stage3.ContinueItem;
import org.adamsmith.unused.stage3.InfoSet.InfoSetPair;

import java.util.*;

/**
 * @author Adam
 *
 */
public abstract class Node {			
	
	// IMMUTABLE (?)
	// represents a node in the game tree
	

	// tree information
	protected Node parent;  // null if this is the root
	protected Set children;  // a set of Nodes
	
	// corresponding infoset information
	//   (the global information set is the union of iP1 and iP2)
	protected InfoSetPair isp;

	
	protected Node(ContinueItem ciAppend, Set children) {
		this.parent = ciAppend.gtnParent;
		this.children = children;
		this.isp = ciAppend.ispChild;
		//isp.addGtnToBoth(this);
		parent.children.add(this);
	}

	// root node constructor
	protected Node(Set children) {
		this.children = children;
	}

}

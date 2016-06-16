package org.adamsmith.unused.stage3.GameTree;

import org.adamsmith.unused.stage3.ContinueItem;

import java.util.*;


/**
 * @author Adam
 *
 */
public class TerminalLeafNode extends Node {

	public TerminalLeafNode(ContinueItem ciTerminal) {
		super(ciTerminal, null);
	}
	
	public static Set terminateSet(Set ciLeafs) {
		Set terminalNodes = new HashSet();
		
		for(Iterator i = ciLeafs.iterator(); i.hasNext(); ) {
			terminalNodes.add(new TerminalLeafNode((ContinueItem) i.next()));
		}
		
		return terminalNodes;
	}
}

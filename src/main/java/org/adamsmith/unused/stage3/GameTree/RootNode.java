package org.adamsmith.unused.stage3.GameTree;

import java.util.*;

/**
 * @author Adam
 *
 */
public class RootNode extends Node {

	
	private static RootNode gtnRoot = null;
	
	public static RootNode getRoot() {
		if(gtnRoot == null) {
			gtnRoot = new RootNode(new HashSet());
		}
		return gtnRoot;
	}
	
	private RootNode(Set children) {
		super(children);
	}
}

package org.adamsmith.unused.stage3.InfoSet;

import org.adamsmith.stage3.InfoSet.InfoToken;

import java.util.*;



/**
 * @author Adam
 *
 */
public class InfoSet {		
	
	// represents the info set FOR ONE PLAYER
	// there are two infoset trees -- one for each player

	// info set tree data
	private InfoSet parent;  // null if this is a root node
	private Set children; // a set of InfoSets

	// the real meat and potatoes
	private InfoToken info; // each child can only contain ONE more InfoToken
	
	protected InfoSet addInfo(InfoToken info) {
		InfoSet aChild;
		for(Iterator i = children.iterator(); i.hasNext(); ) {
			aChild = (InfoSet) i.next();
			if(aChild.info.equals(info)) {
				return aChild;
			}
		}
		
		// this is a ginuinely new InfoSet
		InfoSet isnNew = new InfoSet(this);
		isnNew.info = info;
		
		// this's info is expressed by inheritance
		return isnNew;
	}
	
	protected InfoSet(InfoSet parent) {
		this.parent = parent;
		children = new HashSet();
		
//		treeNodes = new HashSet();
	}
	
	public boolean equals(Object obj) {
		throw new RuntimeException();
	}
}

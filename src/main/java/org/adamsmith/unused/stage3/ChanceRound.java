package org.adamsmith.unused.stage3;



import org.adamsmith.unused.stage3.GameTree.ChanceNode;

import java.util.*;

/**
 * @author Adam
 *
 */
public class ChanceRound {

	public static Set chanceRound(Set ciSet, int numClusters) {

		Set newIspLeaves = new HashSet();
		
		for(Iterator i = ciSet.iterator(); i.hasNext(); ) {
			
			ContinueItem ciAppend = (ContinueItem) i.next();
			ChanceNode cn = new ChanceNode(ciAppend, numClusters);
			newIspLeaves.addAll(cn.ciNext);
			
		}
		
		return newIspLeaves;
	}
}

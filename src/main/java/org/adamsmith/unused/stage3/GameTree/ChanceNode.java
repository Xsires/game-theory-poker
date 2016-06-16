package org.adamsmith.unused.stage3.GameTree;


import org.adamsmith.stage3.DoGT;
import org.adamsmith.stage3.InfoSet.InfoToken;
import org.adamsmith.unused.stage3.ContinueItem;
import org.adamsmith.unused.stage3.InfoSet.InfoSetPair;

import java.util.*;

/**
 * @author Adam
 *
 */
public class ChanceNode extends Node {

	// note that the only chance nodes are for dealing cards (or,
	//   in the abstract game, jumping from a pair of cluster 
	//   assignments to the next)
	
	public Set ciNext;
	
	public ChanceNode(ContinueItem ciAppend, int numClusters) {
		super(ciAppend, new HashSet());
		
		ciNext = new HashSet();
		
		for(int i = 0; i < numClusters; i++) {
			for(int j = 0; j < numClusters; j++) {
				// players {1,2} are assigned to clusters {i,j}
				/*
				InfoToken iP1 = new InfoToken(InfoToken.s_holeCardsCluster
						[DoGT.s_bc0][DoGT.s_player1], i);
				
				InfoToken iP2 = new InfoToken(InfoToken.s_holeCardsCluster
						[DoGT.s_bc0][DoGT.s_player2], j);
				
				InfoSetPair ispNew = isp.addInfoToOnePlayer(iP1, DoGT.s_player1)
						.addInfoToOnePlayer(iP2, DoGT.s_player2);
				ciNext.add(new ContinueItem(ispNew, this));*/
			}
		}
	}
	
	
}

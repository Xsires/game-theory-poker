package org.adamsmith.unused.stage3;

import org.adamsmith.stage3.DoGT;
import org.adamsmith.stage3.InfoSet.InfoToken;
import org.adamsmith.unused.stage3.GameTree.BeginRoundChoiceNode;
import org.adamsmith.unused.stage3.GameTree.EndRoundChoiceNode;
import org.adamsmith.unused.stage3.GameTree.MiddleRoundChoiceNode;

import java.util.*;


/**
 * @author Adam
 *
 */
public class BettingRound {

	public static Set bettingRound(Set ciSet, int bcRound, Set leafNodes) {
		
		Set newIspLeaves = new HashSet();
		
		for(Iterator i = ciSet.iterator(); i.hasNext(); ) {
			ContinueItem ciAppend = (ContinueItem) i.next();
/*
			BeginRoundChoiceNode beginCurrent;
			MiddleRoundChoiceNode middleCurrent;
			EndRoundChoiceNode endCurrent;
			
			// -------------------------------------------------------------
			// Construct a betting round tree...code listed in DFS order
			// -------------------------------------------------------------
			beginCurrent = new BeginRoundChoiceNode(ciAppend, InfoToken.s_betChoice[bcRound][0]);
			leafNodes.add(beginCurrent.gtnFold);
			
			
			
			
			// Root right (raise) branch
			middleCurrent = new MiddleRoundChoiceNode(beginCurrent.ciRaise, 
					InfoToken.s_betChoice[bcRound][1]);
			leafNodes.add(middleCurrent.gtnFold);
			newIspLeaves.add(middleCurrent.ciCall);
			
			middleCurrent = new MiddleRoundChoiceNode(middleCurrent.ciRaise, 
					InfoToken.s_betChoice[bcRound][2]);
			leafNodes.add(middleCurrent.gtnFold);
			newIspLeaves.add(middleCurrent.ciCall);
			
			if(bcRound != DoGT.s_bc0) {
				
				middleCurrent = new MiddleRoundChoiceNode(middleCurrent.ciRaise, 
						InfoToken.s_betChoice[bcRound][3]);
				leafNodes.add(middleCurrent.gtnFold);
				newIspLeaves.add(middleCurrent.ciCall);
				
			}
			
			endCurrent = new EndRoundChoiceNode(middleCurrent.ciRaise, 
					InfoToken.s_betChoice[bcRound][((bcRound == DoGT.s_bc0) ? 3 : 4)]);
			leafNodes.add(endCurrent.gtnFold);
			newIspLeaves.add(endCurrent.ciCall);
			
			
			
			
			// Root left (check) branch
			middleCurrent = new MiddleRoundChoiceNode(beginCurrent.ciCheck, 
					InfoToken.s_betChoice[bcRound][1]);
			leafNodes.add(middleCurrent.gtnFold);
			newIspLeaves.add(middleCurrent.ciCall);
			
			middleCurrent = new MiddleRoundChoiceNode(middleCurrent.ciRaise, 
					InfoToken.s_betChoice[bcRound][2]);
			leafNodes.add(middleCurrent.gtnFold);
			newIspLeaves.add(middleCurrent.ciCall);
			
			middleCurrent = new MiddleRoundChoiceNode(middleCurrent.ciRaise, 
					InfoToken.s_betChoice[bcRound][3]);
			leafNodes.add(middleCurrent.gtnFold);
			newIspLeaves.add(middleCurrent.ciCall);
			
			if(bcRound != DoGT.s_bc0) {
				
				middleCurrent = new MiddleRoundChoiceNode(middleCurrent.ciRaise, 
						InfoToken.s_betChoice[bcRound][4]);
				leafNodes.add(middleCurrent.gtnFold);
				newIspLeaves.add(middleCurrent.ciCall);
				
			}
			
			endCurrent = new EndRoundChoiceNode(middleCurrent.ciRaise, 
					InfoToken.s_betChoice[bcRound][(bcRound == DoGT.s_bc0) ? 4 : 5]);
			leafNodes.add(endCurrent.gtnFold);
			newIspLeaves.add(endCurrent.ciCall);
			*/
		}
		
		// note that the contents of, and set backing, ispLeaves should probably
		//   be gc'ed here
		
		return newIspLeaves;
	}
}

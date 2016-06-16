package org.adamsmith.unused.stage3.InfoSet;

import org.adamsmith.stage3.DoGT;
import org.adamsmith.stage3.InfoSet.InfoToken;

/**
 * @author Adam
 *
 */
public class InfoSetPair {
	
	private static InfoSetPair ispRoot;

	public static InfoSetPair getRoot() {
		if(ispRoot == null) {
			ispRoot = new InfoSetPair(new InfoSet(null), new InfoSet(null));
		}
		return ispRoot;
	}
	

	public InfoSet p1Isn;
	public InfoSet p2Isn;
	public InfoSet[] isn = new InfoSet[] {p1Isn, p2Isn};
	
	public InfoSetPair(InfoSet p1Isn, InfoSet p2Isn) {
		this.p1Isn = p1Isn;
		this.p2Isn = p2Isn;
	}
	
	public InfoSetPair addInfoToBoth(InfoToken info) {
		return new InfoSetPair(p1Isn.addInfo(info), p2Isn.addInfo(info));
	}
	
	public InfoSetPair addInfoToOnePlayer(InfoToken info, int player) {
		if(player == DoGT.s_player1) {
			return new InfoSetPair(p1Isn.addInfo(info), p2Isn);
		} else if(player == DoGT.s_player2) {
			return new InfoSetPair(p1Isn, p2Isn.addInfo(info));
		} else {
			throw new RuntimeException();
		}
	}	
}

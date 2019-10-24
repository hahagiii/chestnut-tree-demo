package io.chestnut.server.playerServer.ranklist;

import io.chestnut.core.Chestnut;

public class RankList extends Chestnut{
	
	public RankList() {
	}

	public static RankList newInstance() {
		return new RankList();
	}

	@Override
	public String getId() {
		return "RankList";
	}
	
	
}

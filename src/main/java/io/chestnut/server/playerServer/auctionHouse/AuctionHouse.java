package io.chestnut.server.playerServer.auctionHouse;

import io.chestnut.core.Chestnut;

public class AuctionHouse  extends Chestnut{


	public static Chestnut newInstance() {
		return new AuctionHouse();
	}

	@Override
	public String getId() {
		return "auctionHouse";
	}
}

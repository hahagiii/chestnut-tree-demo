package io.chestnut.server.playerServer.linkGateWay;

import io.chestnut.core.Chestnut;

public class LinkGateWayChestnut extends Chestnut{

	@Override
	public String getId() {
		return "LinkGateWayChestnut";
	}

	public static LinkGateWayChestnut newInstance() {
		LinkGateWayChestnut playerLoginChestnut = new LinkGateWayChestnut();
		playerLoginChestnut.addComponent(new AccountComponent());
		return playerLoginChestnut;
	}

}



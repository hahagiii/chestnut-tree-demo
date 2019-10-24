package io.chestnut.server.playerServer.player;

import io.chestnut.server.playerServer.player.property.Property;
import io.chestnut.server.playerServer.player.scene.SceneComponent;
import io.chestnut.server.playerServer.player.wing.WingComponent;

public class PlayerFactory {
	public static Player newPlayer(String playerId) {
		Player player = new Player(playerId);
		player.addComponent(new Property());
		player.addComponent(new WingComponent());
		player.addComponent(new SceneComponent());
		return player;
	}
}

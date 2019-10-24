package io.chestnut.server.playerServer.player;

import io.chestnut.core.Chestnut;
import io.chestnut.core.SocketConnection;

public class Player extends Chestnut{
	private SocketConnection clientConnection;
	public String playerId;
	public String sceneId;
	
	public Player(String playerId) {
		this.playerId = playerId;
	}

	public SocketConnection clientConnection() {
		return clientConnection;
	}

	public void setClientConnection(SocketConnection clientConnection) {
		this.clientConnection = clientConnection;
	}

	@Override
	public String getId() {
		return playerId;
	}

}

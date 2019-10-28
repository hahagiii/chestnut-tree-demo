package io.chestnut.server.client.Robot;

import io.chestnut.core.Chestnut;
import io.chestnut.core.network.SocketConnection;

public class Robot extends Chestnut{
	private SocketConnection clientConnection;
	public String playerId;
	public Robot(String playerId) {
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

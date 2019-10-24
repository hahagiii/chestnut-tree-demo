package io.chestnut.server.playerServer.protocol.gameProtocol;

import io.chestnut.server.playerServer.protocol.ServerProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

public class ProtocolAuthReq extends ProtocolIn{
	public String playerId;
	
	public  ProtocolAuthReq() {
	}
	
	@Override
	public short id() {
		return ServerProtocolDefine.ProtocolAuthReq;
	}

	@Override
	public void unpackBody(ByteBuf data) {
		this.playerId = SimpleProtocolUtil.getString(data);
	}
}

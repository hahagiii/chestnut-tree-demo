package io.chestnut.server.playerServer.protocol.gameProtocol;

import io.chestnut.server.playerServer.protocol.ServerProtocolDefine;
import io.chestnut.core.protocol.SimpleProtocolOut;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

public class ProtocolAuthRep extends SimpleProtocolOut{

	public String playerId;
	
	public ProtocolAuthRep() {
	}
	
	public ProtocolAuthRep(String playerId) {
		this.playerId = playerId;
	}
	
	@Override
	public void packBody(ByteBuf buf) throws Exception {
		 SimpleProtocolUtil.putString(buf, playerId);
	}

	@Override
	public short id() {
		return ServerProtocolDefine.ProtocolAuthRep;
	}



}

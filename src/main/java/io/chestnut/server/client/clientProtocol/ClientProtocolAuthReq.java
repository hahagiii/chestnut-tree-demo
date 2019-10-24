package io.chestnut.server.client.clientProtocol;

import io.chestnut.server.playerServer.protocol.ServerProtocolDefine;
import io.chestnut.core.protocol.SimpleProtocolOut;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

public class ClientProtocolAuthReq extends SimpleProtocolOut{
	public String playerId;
	
	public ClientProtocolAuthReq() {
	}
	
	public ClientProtocolAuthReq(String playerId) {
		this.playerId = playerId;
	}
	
	@Override
	public short id() {
		return ServerProtocolDefine.ProtocolAuthReq;
	}

	@Override
	public void packBody(ByteBuf buf) throws Exception {
		 SimpleProtocolUtil.putString(buf, playerId);
	}



	
}

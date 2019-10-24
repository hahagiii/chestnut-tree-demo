package io.chestnut.server.client.clientProtocol;

import io.chestnut.server.playerServer.protocol.ServerProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

public class ClientProtocolAuthRep extends ProtocolIn{

	public String playerId;
	
	@Override
	public short id() {
		return ServerProtocolDefine.ProtocolAuthRep;
	}

	@Override
	public void unpackBody(ByteBuf in) throws Exception {
		this.playerId = SimpleProtocolUtil.getString(in);
	}



}

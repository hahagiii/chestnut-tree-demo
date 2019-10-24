package io.chestnut.server.client.clientProtocol;

import io.chestnut.server.playerServer.protocol.ServerProtocolDefine;
import io.chestnut.core.protocol.SimpleProtocolOut;
import io.netty.buffer.ByteBuf;

public class ClientProtocolWingUpReq extends SimpleProtocolOut{



	@Override
	public short id() {
		return ServerProtocolDefine.ProtocolWingUpReq;
	}

	@Override
	public void packBody(ByteBuf buf) throws Exception {
		
	}

	

}

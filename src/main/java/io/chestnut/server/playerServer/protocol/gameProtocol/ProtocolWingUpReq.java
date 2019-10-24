package io.chestnut.server.playerServer.protocol.gameProtocol;

import io.chestnut.server.playerServer.protocol.ServerProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.netty.buffer.ByteBuf;

public class ProtocolWingUpReq extends ProtocolIn{



	@Override
	public short id() {
		return ServerProtocolDefine.ProtocolWingUpReq;
	}

	@Override
	public void unpackBody(ByteBuf data) {
		
	}

}

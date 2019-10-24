package io.chestnut.server.playerServer.protocol.gameProtocol;

import io.chestnut.server.playerServer.protocol.ServerProtocolDefine;
import io.chestnut.core.protocol.SimpleProtocolOut;
import io.netty.buffer.ByteBuf;

public class ProtocolWingUpRep extends SimpleProtocolOut{

	public int wingExp = 0;
	
	public ProtocolWingUpRep(int wingExp) {
		this.wingExp = wingExp;
	}
	
	@Override
	public void packBody(ByteBuf buf) {		
	}


	@Override
	public short id() {
		return ServerProtocolDefine.ProtocolWingUpRep;
	}
}

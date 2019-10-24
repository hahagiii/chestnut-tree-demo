package io.chestnut.server.client.clientProtocol;

import io.chestnut.server.playerServer.protocol.ServerProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.netty.buffer.ByteBuf;

public class ClientProtocolWingUpRep extends ProtocolIn{

	public int wingExp = 0;
	
	public ClientProtocolWingUpRep() {
		
	}
	public ClientProtocolWingUpRep(int wingExp) {
		this.wingExp = wingExp;
	}

	@Override
	public short id() {
		return ServerProtocolDefine.ProtocolWingUpRep;
	}

	@Override
	public void unpackBody(ByteBuf in) throws Exception {
		
	}
}

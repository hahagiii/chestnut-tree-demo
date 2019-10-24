package io.chestnut.server.playerServer.protocol.gameProtocol;

import io.chestnut.server.playerServer.protocol.ServerProtocolDefine;
import io.chestnut.core.protocol.SimpleProtocolOut;
import io.netty.buffer.ByteBuf;

public class ProtocolErrorCodeRep extends SimpleProtocolOut{

	int errorCode;
	short protocolId;
	
	public ProtocolErrorCodeRep(short protocolId, int errorCode) {
		this.protocolId = protocolId;
		this.errorCode = errorCode;
	}
	
	@Override
	public short id() {
		return  ServerProtocolDefine.ProtocolErrorCodeRep;
	}

	@Override
	public void packBody(ByteBuf buf) throws Exception {
		buf.writeShort(protocolId);
		buf.writeInt(errorCode);
	}

}

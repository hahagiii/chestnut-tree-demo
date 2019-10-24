package io.chestnut.server.client.clientProtocol;

import io.chestnut.server.playerServer.protocol.ServerProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.netty.buffer.ByteBuf;

public class ClientProtocolErrorCodeRep extends ProtocolIn{

	public int errorCode;
	public short protocolId;
	
	public ClientProtocolErrorCodeRep() {
		
	}
	
	public ClientProtocolErrorCodeRep(short protocolId, int errorCode) {
		this.protocolId = protocolId;
		this.errorCode = errorCode;
	}
	
	@Override
	public short id() {
		return  ServerProtocolDefine.ProtocolErrorCodeRep;
	}

	@Override
	public void unpackBody(ByteBuf in) throws Exception {
		this.protocolId = in.readShort();
		this.errorCode = in.readInt();
	}


}

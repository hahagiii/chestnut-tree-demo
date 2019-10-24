package io.chestnut.server.playerServer.protocol.outProtocol;

import io.chestnut.server.playerServer.protocol.ProtocolDefine;
import io.chestnut.core.protocol.SimpleProtocolOut;
import io.netty.buffer.ByteBuf;

public class PtOutErrorCode extends SimpleProtocolOut{

	int errorCode;
	short protocolId;
	
	public PtOutErrorCode(short protocolId, int errorCode) {
		this.protocolId = protocolId;
		this.errorCode = errorCode;
	}
	
	@Override
	public short id() {
		return  ProtocolDefine.PtOutErrorCode;
	}

	@Override
	public void packBody(ByteBuf buf) throws Exception {
		buf.writeShort(protocolId);
		buf.writeInt(errorCode);
	}

}

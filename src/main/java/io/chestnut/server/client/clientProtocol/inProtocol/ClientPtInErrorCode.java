package io.chestnut.server.client.clientProtocol.inProtocol;

import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.client.clientProtocol.ClientProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.netty.buffer.ByteBuf;

@MsgAnnotate(id=ClientProtocolDefine.ClientPtInErrorCode)
public class ClientPtInErrorCode extends ProtocolIn{

	public int errorCode;
	public short protocolId;
	
	public ClientPtInErrorCode() {
		
	}
	
	public ClientPtInErrorCode(short protocolId, int errorCode) {
		this.protocolId = protocolId;
		this.errorCode = errorCode;
	}
	
	@Override
	public short id() {
		return  ClientProtocolDefine.ClientPtInErrorCode;
	}

	@Override
	public void unpackBody(ByteBuf in) throws Exception {
		this.protocolId = in.readShort();
		this.errorCode = in.readInt();
	}


}

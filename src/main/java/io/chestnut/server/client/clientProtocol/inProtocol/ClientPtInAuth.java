package io.chestnut.server.client.clientProtocol.inProtocol;

import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.client.clientProtocol.ClientProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

@MsgAnnotate(id=ClientProtocolDefine.ClientPtInAuth)
public class ClientPtInAuth extends ProtocolIn{

	public String playerId;
	
	@Override
	public short id() {
		return ClientProtocolDefine.ClientPtInAuth;
	}

	@Override
	public void unpackBody(ByteBuf in) throws Exception {
		this.playerId = SimpleProtocolUtil.getString(in);
	}



}

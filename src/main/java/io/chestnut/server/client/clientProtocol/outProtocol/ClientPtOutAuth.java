package io.chestnut.server.client.clientProtocol.outProtocol;

import io.chestnut.server.client.clientProtocol.ClientProtocolDefine;
import io.chestnut.core.protocol.SimpleProtocolOut;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

public class ClientPtOutAuth extends SimpleProtocolOut{
	public String playerId;
	
	public ClientPtOutAuth() {
	}
	
	public ClientPtOutAuth(String playerId) {
		this.playerId = playerId;
	}
	
	@Override
	public short id() {
		return ClientProtocolDefine.ClientPtOutAuth;
	}

	@Override
	public void packBody(ByteBuf buf) throws Exception {
		 SimpleProtocolUtil.putString(buf, playerId);
	}



	
}

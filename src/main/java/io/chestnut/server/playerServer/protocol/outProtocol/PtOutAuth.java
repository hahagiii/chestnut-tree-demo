package io.chestnut.server.playerServer.protocol.outProtocol;

import io.chestnut.server.playerServer.protocol.ProtocolDefine;
import io.chestnut.core.protocol.SimpleProtocolOut;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

public class PtOutAuth extends SimpleProtocolOut{

	public String playerId;
	
	public PtOutAuth() {
	}
	
	public PtOutAuth(String playerId) {
		this.playerId = playerId;
	}
	
	@Override
	public void packBody(ByteBuf buf) throws Exception {
		 SimpleProtocolUtil.putString(buf, playerId);
	}

	@Override
	public short id() {
		return ProtocolDefine.PtOutAuth;
	}



}

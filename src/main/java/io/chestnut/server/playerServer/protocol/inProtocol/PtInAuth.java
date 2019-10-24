package io.chestnut.server.playerServer.protocol.inProtocol;

import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.playerServer.protocol.ProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

@MsgAnnotate(id=ProtocolDefine.PtInAuth)
public class PtInAuth extends ProtocolIn{
	public String playerId;
	
	public  PtInAuth() {
	}
	
	@Override
	public short id() {
		return ProtocolDefine.PtInAuth;
	}

	@Override
	public void unpackBody(ByteBuf data) {
		this.playerId = SimpleProtocolUtil.getString(data);
	}
}

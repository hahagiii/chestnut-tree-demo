package io.chestnut.server.playerServer.protocol.inProtocol;

import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.playerServer.protocol.ProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.netty.buffer.ByteBuf;

@MsgAnnotate(id=ProtocolDefine.PtInWingUp)
public class PtInWingUp extends ProtocolIn{

	@Override
	public short id() {
		return ProtocolDefine.PtInWingUp;
	}

	@Override
	public void unpackBody(ByteBuf data) {
		
	}

}

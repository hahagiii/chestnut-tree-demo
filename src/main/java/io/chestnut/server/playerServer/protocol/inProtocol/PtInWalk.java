package io.chestnut.server.playerServer.protocol.inProtocol;

import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.playerServer.protocol.ProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.netty.buffer.ByteBuf;

@MsgAnnotate(id=ProtocolDefine.PtInWalk)
public class PtInWalk extends ProtocolIn{

	public short x;
	public short y;
	
	public PtInWalk() {
	}
	
	@Override
	public short id() {
		return ProtocolDefine.PtInWalk;
	}

	@Override
	public void unpackBody(ByteBuf in) throws Exception {
		this.x = in.readShort();
		this.y = in.readShort();
	}



}

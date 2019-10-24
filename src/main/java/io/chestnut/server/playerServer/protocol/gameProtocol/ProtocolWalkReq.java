package io.chestnut.server.playerServer.protocol.gameProtocol;

import io.chestnut.server.playerServer.protocol.ServerProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.netty.buffer.ByteBuf;

public class ProtocolWalkReq extends ProtocolIn{

	public short x;
	public short y;
	
	public ProtocolWalkReq() {
	}
	
	@Override
	public short id() {
		return ServerProtocolDefine.ProtocolWalkReq;
	}

	@Override
	public void unpackBody(ByteBuf in) throws Exception {
		this.x = in.readShort();
		this.y = in.readShort();
	}



}

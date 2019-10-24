package io.chestnut.server.playerServer.protocol.outProtocol;

import io.chestnut.server.playerServer.protocol.ProtocolDefine;
import io.chestnut.core.protocol.SimpleProtocolOut;
import io.netty.buffer.ByteBuf;

public class PtOutWingUp extends SimpleProtocolOut{

	public int wingExp = 0;
	
	public PtOutWingUp(int wingExp) {
		this.wingExp = wingExp;
	}
	
	@Override
	public void packBody(ByteBuf buf) {		
	}


	@Override
	public short id() {
		return ProtocolDefine.PtOutWingUp;
	}
}

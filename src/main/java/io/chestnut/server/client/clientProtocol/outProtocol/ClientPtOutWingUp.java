package io.chestnut.server.client.clientProtocol.outProtocol;

import io.chestnut.server.client.clientProtocol.ClientProtocolDefine;
import io.chestnut.core.protocol.SimpleProtocolOut;
import io.netty.buffer.ByteBuf;

public class ClientPtOutWingUp extends SimpleProtocolOut{



	@Override
	public short id() {
		return ClientProtocolDefine.ClientPtOutWingUp;
	}

	@Override
	public void packBody(ByteBuf buf) throws Exception {
		
	}

	

}

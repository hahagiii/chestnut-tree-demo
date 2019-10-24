package io.chestnut.server.client.clientProtocol.inProtocol;

import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.client.clientProtocol.ClientProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.netty.buffer.ByteBuf;

@MsgAnnotate(id=ClientProtocolDefine.ClientPtInWingUp)
public class ClientPtInWingUp extends ProtocolIn{

	public int wingExp = 0;
	
	public ClientPtInWingUp() {
		
	}
	public ClientPtInWingUp(int wingExp) {
		this.wingExp = wingExp;
	}

	@Override
	public short id() {
		return ClientProtocolDefine.ClientPtInWingUp;
	}

	@Override
	public void unpackBody(ByteBuf in) throws Exception {
		wingExp = in.readInt();
		
	}
}

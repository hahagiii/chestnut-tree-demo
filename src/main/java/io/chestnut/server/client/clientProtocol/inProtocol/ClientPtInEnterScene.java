package io.chestnut.server.client.clientProtocol.inProtocol;

import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.client.clientProtocol.ClientProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

@MsgAnnotate(id=ClientProtocolDefine.ClientPtInEnterScene)
public class ClientPtInEnterScene extends ProtocolIn{

	public String sceneId;
	
	public ClientPtInEnterScene() {
	}


	@Override
	public short id() {
		return ClientProtocolDefine.ClientPtInEnterScene;
	}

	@Override
	public void unpackBody(ByteBuf in) throws Exception {
		this.sceneId = SimpleProtocolUtil.getString(in);
	}



}

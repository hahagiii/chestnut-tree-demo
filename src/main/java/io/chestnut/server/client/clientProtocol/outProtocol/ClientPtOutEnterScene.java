package io.chestnut.server.client.clientProtocol.outProtocol;

import io.chestnut.server.client.clientProtocol.ClientProtocolDefine;
import io.chestnut.core.protocol.SimpleProtocolOut;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

public class ClientPtOutEnterScene extends SimpleProtocolOut{

	public String sceneId;
	
	public ClientPtOutEnterScene() {
	}
	

	public ClientPtOutEnterScene(String sceneId) {
		this.sceneId = sceneId;
	}
	
	@Override
	public void packBody(ByteBuf buf) throws Exception {
		 SimpleProtocolUtil.putString(buf, sceneId);
	}

	@Override
	public short id() {
		return ClientProtocolDefine.ClientPtOutEnterScene;
	}



}

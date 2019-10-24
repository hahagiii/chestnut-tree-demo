package io.chestnut.server.playerServer.protocol.outProtocol;

import io.chestnut.server.playerServer.protocol.ProtocolDefine;
import io.chestnut.core.protocol.SimpleProtocolOut;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

public class PtOutEnterScene extends SimpleProtocolOut{

	public String sceneId;
	
	public PtOutEnterScene() {
	}
	
	public PtOutEnterScene(String sceneId) {
		this.sceneId = sceneId;
	}
	
	@Override
	public void packBody(ByteBuf buf) throws Exception {
		 SimpleProtocolUtil.putString(buf, sceneId);
	}

	@Override
	public short id() {
		return ProtocolDefine.PtOutEnterScene;
	}



}

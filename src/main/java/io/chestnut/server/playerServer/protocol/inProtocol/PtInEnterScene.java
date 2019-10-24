package io.chestnut.server.playerServer.protocol.inProtocol;

import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.playerServer.protocol.ProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

@MsgAnnotate(id=ProtocolDefine.PtInEnterScene)
public class PtInEnterScene extends ProtocolIn{

	public String sceneId;
	
	public PtInEnterScene() {
	}


	@Override
	public short id() {
		return ProtocolDefine.PtInEnterScene;
	}

	@Override
	public void unpackBody(ByteBuf in) throws Exception {
		this.sceneId = SimpleProtocolUtil.getString(in);
	}



}

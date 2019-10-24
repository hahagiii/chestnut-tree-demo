package io.chestnut.server.playerServer.protocol.gameProtocol;

import io.chestnut.server.playerServer.protocol.ServerProtocolDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

public class ProtocolEnterSceneReq extends ProtocolIn{

	public String sceneId;
	public String playerId;
	
	public ProtocolEnterSceneReq() {
	}


	@Override
	public short id() {
		return ServerProtocolDefine.ProtocolEnterSceneReq;
	}

	@Override
	public void unpackBody(ByteBuf in) throws Exception {
		this.sceneId = SimpleProtocolUtil.getString(in);
	}



}

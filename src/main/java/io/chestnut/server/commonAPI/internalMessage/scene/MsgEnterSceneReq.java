package io.chestnut.server.commonAPI.internalMessage.scene;

import io.chestnut.core.InternalMessage;
import io.chestnut.server.commonAPI.internalMessage.MessageDefine;
import io.netty.buffer.ByteBuf;

public class MsgEnterSceneReq  extends InternalMessage{
	public String sceneId;
	public String playerId;
	
	public  MsgEnterSceneReq(String sceneId) {
		this.sceneId = sceneId;
	}
	
	public  MsgEnterSceneReq() {
	}

	@Override
	public short id() {
		return MessageDefine.MsgEnterSceneReq;
	}
	
	@Override
	public void packBody(ByteBuf buf){
		
	}

	@Override
	public void unpackBody(ByteBuf in) {
		
	};

}

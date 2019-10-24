package io.chestnut.server.commonAPI.internalMessage.scene;

import io.chestnut.core.InternalMessage;
import io.chestnut.server.commonAPI.internalMessage.MessageDefine;
import io.netty.buffer.ByteBuf;

public class MsgEnterSceneRep  extends InternalMessage{

	@Override
	public short id() {
		return MessageDefine.MsgEnterSceneRep;
	}

	@Override
	public void unpackBody(ByteBuf in) {
		
	}

	@Override
	public void packBody(ByteBuf out) {
		
	}


}

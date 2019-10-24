package io.chestnut.server.commonAPI.internalMessage.property;

import io.chestnut.core.InternalMessage;
import io.chestnut.server.commonAPI.internalMessage.MessageDefine;

public class MsgPlayerGoldRep  extends InternalMessage{
	public int num;
	
	public MsgPlayerGoldRep(int num) {
		this.num = num;
	}
	
	public MsgPlayerGoldRep() {
	}

	@Override
	public short id() {
		return MessageDefine.MsgPlayerGoldRep;
	}


}

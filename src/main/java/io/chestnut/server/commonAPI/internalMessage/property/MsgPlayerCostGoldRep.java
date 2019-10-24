package io.chestnut.server.commonAPI.internalMessage.property;

import io.chestnut.core.InternalMessage;
import io.chestnut.server.commonAPI.internalMessage.MessageDefine;

public class MsgPlayerCostGoldRep extends InternalMessage{
	public int remainderNum;
	
	public  MsgPlayerCostGoldRep(int remainderNum) {
		this.remainderNum = remainderNum;
	}

	@Override
	public short id() {
		return MessageDefine.MsgPlayerCostGoldRep;
	}

	
}

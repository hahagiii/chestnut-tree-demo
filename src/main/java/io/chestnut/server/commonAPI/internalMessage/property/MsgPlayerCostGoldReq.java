package io.chestnut.server.commonAPI.internalMessage.property;

import io.chestnut.core.InternalMessage;
import io.chestnut.server.commonAPI.internalMessage.MessageDefine;

public class MsgPlayerCostGoldReq  extends InternalMessage{
	public int costNum;
	
	public  MsgPlayerCostGoldReq(int costNum) {
		this.costNum = costNum;
	}

	@Override
	public short id() {
		return MessageDefine.MsgPlayerCostGoldReq;
	}

}

package io.chestnut.server.commonAPI.property;

import io.chestnut.core.InternalMessage;
import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.commonAPI.MessageDefine;

@MsgAnnotate(id = MessageDefine.MsgPlayerCostGoldRep)
public class MsgPlayerCostGoldRep extends InternalMessage{
	private int remainderNum;

	public int getRemainderNum() {
		return remainderNum;
	}

	public void setRemainderNum(int remainderNum) {
		this.remainderNum = remainderNum;
	}
}

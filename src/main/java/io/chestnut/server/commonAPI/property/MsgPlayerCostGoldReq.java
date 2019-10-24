package io.chestnut.server.commonAPI.property;

import io.chestnut.core.InternalMessage;
import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.commonAPI.MessageDefine;

@MsgAnnotate(id = MessageDefine.MsgPlayerCostGoldReq)
public class MsgPlayerCostGoldReq  extends InternalMessage{
	private int costNum;

	public int getCostNum() {
		return costNum;
	}

	public void setCostNum(int costNum) {
		this.costNum = costNum;
	}
	

}

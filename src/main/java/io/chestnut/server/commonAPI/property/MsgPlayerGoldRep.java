package io.chestnut.server.commonAPI.property;

import io.chestnut.core.InternalMessage;
import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.commonAPI.MessageDefine;

@MsgAnnotate(id =MessageDefine.MsgPlayerGoldRep)
public class MsgPlayerGoldRep  extends InternalMessage{
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	


}

package io.chestnut.server.commonAPI.login;

import io.chestnut.core.InternalMessage;
import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.commonAPI.MessageDefine;

@MsgAnnotate(id = MessageDefine.MsgPlayerLogin)
public class MsgPlayerLogin extends InternalMessage{
	private int remainderNum;

	public int getRemainderNum() {
		return remainderNum;
	}

	public void setRemainderNum(int remainderNum) {
		this.remainderNum = remainderNum;
	}
}

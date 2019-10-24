package io.chestnut.server.commonAPI.property;

import io.chestnut.core.InternalMessage;
import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.commonAPI.MessageDefine;

@MsgAnnotate(id =MessageDefine.MsgPlayerExpRep)
public class MsgPlayerExpRep  extends InternalMessage{
	private int exp;

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}


}

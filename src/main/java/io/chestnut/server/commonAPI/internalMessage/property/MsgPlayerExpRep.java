package io.chestnut.server.commonAPI.internalMessage.property;

import io.chestnut.core.InternalMessage;
import io.chestnut.server.commonAPI.internalMessage.MessageDefine;

public class MsgPlayerExpRep  extends InternalMessage{
	public int exp;

	@Override
	public short id() {
		return MessageDefine.MsgPlayerExpRep;
	}


}

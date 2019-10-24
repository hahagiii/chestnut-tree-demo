package io.chestnut.server.commonAPI.internalMessage.property;

import io.chestnut.core.InternalMessage;
import io.chestnut.server.commonAPI.internalMessage.MessageDefine;

public class MsgPlayerExpReq  extends InternalMessage{

	@Override
	public short id() {
		return MessageDefine.MsgPlayerExpReq;
	}


}

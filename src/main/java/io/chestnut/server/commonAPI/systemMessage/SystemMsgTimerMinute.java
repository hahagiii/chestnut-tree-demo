package io.chestnut.server.commonAPI.systemMessage;

import io.chestnut.core.InternalMessage;

public class SystemMsgTimerMinute extends InternalMessage{
	

	@Override
	public short id() {
		return  SystemMessageDefine.SystemMsgTimerMinute;
	}
}

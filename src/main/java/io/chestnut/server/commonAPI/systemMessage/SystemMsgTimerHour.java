package io.chestnut.server.commonAPI.systemMessage;

import io.chestnut.core.InternalMessage;

public class SystemMsgTimerHour extends InternalMessage{
	
	public SystemMsgTimerHour() {
	}

	@Override
	public short id() {
		return SystemMessageDefine.SystemMsgTimerHour;
	}
}

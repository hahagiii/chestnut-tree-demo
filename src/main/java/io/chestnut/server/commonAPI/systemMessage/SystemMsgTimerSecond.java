package io.chestnut.server.commonAPI.systemMessage;

import io.chestnut.core.InternalMessage;

public class SystemMsgTimerSecond extends InternalMessage{
	

	@Override
	public short id() {
		return SystemMessageDefine.SystemMsgTimerSecond;
	}
}

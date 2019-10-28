package io.chestnut.server.commonAPI.gateWay;

import io.chestnut.core.InternalMessage;
import io.chestnut.core.MsgAnnotate;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.chestnut.server.commonAPI.MessageDefine;
import io.netty.buffer.ByteBuf;

@MsgAnnotate(id = MessageDefine.MsgEnterPlayerServer)
public class MsgEnterPlayerServer extends InternalMessage{
	private String playerId;

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	
	@Override
	public void unpackBody(ByteBuf in) {
		playerId = SimpleProtocolUtil.getString(in);
	}

	@Override
	public void packBody(ByteBuf out) {
		SimpleProtocolUtil.putString(out, playerId);
	}

}

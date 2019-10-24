package io.chestnut.server.commonAPI.scene;

import io.chestnut.core.InternalMessage;
import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.commonAPI.MessageDefine;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

@MsgAnnotate(id =MessageDefine.MsgEnterSceneReq)
public class MsgEnterSceneReq  extends InternalMessage{
	private String sceneId;
	private String playerId;
	
	public void setParameter(String sceneId,String playerId) {
		this.sceneId = sceneId;
		this.playerId = playerId;
	}
	public String getPlayerId() {
		return playerId;
	}
	public String getSceneId() {
		return sceneId;
	}
	
	@Override
	public void packBody(ByteBuf buf){
		SimpleProtocolUtil.putString(buf, this.sceneId);
		SimpleProtocolUtil.putString(buf, this.playerId);
		
	}

	@Override
	public void unpackBody(ByteBuf in) {
		this.sceneId = SimpleProtocolUtil.getString(in);
		this.playerId = SimpleProtocolUtil.getString(in);
	};
	


}

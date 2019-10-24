package io.chestnut.server.commonAPI.scene;

import io.chestnut.core.InternalMessage;
import io.chestnut.core.MsgAnnotate;
import io.chestnut.server.commonAPI.MessageDefine;
import io.chestnut.core.protocol.SimpleProtocolUtil;
import io.netty.buffer.ByteBuf;

@MsgAnnotate(id =MessageDefine.MsgEnterSceneRep)
public class MsgEnterSceneRep  extends InternalMessage{
	private int errorCode;
	private String sceneId;
	
	public void setParameter(int errorCode,String sceneId) {
		this.errorCode = errorCode;
		this.sceneId = sceneId;
	}
	
	public int getErrorCode() {
		return errorCode;
	}

	public String getSceneId() {
		return sceneId;
	}

	
	@Override
	public void unpackBody(ByteBuf in) {
		errorCode = in.readInt();
		sceneId = SimpleProtocolUtil.getString(in);
	}

	@Override
	public void packBody(ByteBuf out) {
		out.writeInt(errorCode);
		SimpleProtocolUtil.putString(out, sceneId);
	}


	

}

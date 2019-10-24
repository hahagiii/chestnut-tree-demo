package io.chestnut.server.sceneServer.scene;

import io.chestnut.core.ChestnutComponent;
import io.chestnut.core.HandleCast;
import io.chestnut.core.InternalMsgFactory;
import io.chestnut.core.Message;
import io.chestnut.server.commonAPI.MessageDefine;
import io.chestnut.server.commonAPI.scene.MsgEnterSceneRep;
import io.chestnut.server.commonAPI.scene.MsgEnterSceneReq;
import io.chestnut.server.sceneServer.sprite.player.ScenePlayer;
import io.chestnut.server.sceneServer.sprite.player.ScenePlayerFactory;

public class SpriteMrgComponent extends ChestnutComponent<Scene> {
	
	@HandleCast(id = MessageDefine.MsgEnterSceneReq)
	public void enterSceneReq(Message message) throws Exception {
		MsgEnterSceneReq msgEnterSceneReq = (MsgEnterSceneReq) message;
		ScenePlayer scenePlayer = ScenePlayerFactory.newPlayer(msgEnterSceneReq.getPlayerId());
		MsgEnterSceneRep res = InternalMsgFactory.getMessage(MessageDefine.MsgEnterSceneRep);
		res.setParameter(0, getOwner().getId());
		msgEnterSceneReq.reply(res);
	}

}

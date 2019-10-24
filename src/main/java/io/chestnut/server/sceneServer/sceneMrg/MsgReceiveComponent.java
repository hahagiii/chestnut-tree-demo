package io.chestnut.server.sceneServer.sceneMrg;

import io.chestnut.core.ChestnutComponent;
import io.chestnut.core.HandleCast;
import io.chestnut.core.Message;
import io.chestnut.server.commonAPI.MessageDefine;
import io.chestnut.server.commonAPI.scene.MsgEnterSceneReq;
import io.chestnut.server.sceneServer.SceneServer;
import io.chestnut.server.sceneServer.scene.Scene;

public class MsgReceiveComponent  extends ChestnutComponent<SceneMrg> {
	
	@HandleCast(id = MessageDefine.MsgEnterSceneReq)
	public void enterSceneReq(Message message) throws Exception {
		MsgEnterSceneReq msgEnterSceneReq = (MsgEnterSceneReq) message;
	    Scene scene = SceneServer.chestnutTree.getChestnut(msgEnterSceneReq.getSceneId());
		if(scene == null) {
			scene = getOwner().createScene(msgEnterSceneReq.getSceneId());
		}
		scene.cast(message);
	}
}

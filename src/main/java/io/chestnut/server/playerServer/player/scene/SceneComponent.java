package io.chestnut.server.playerServer.player.scene;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.chestnut.core.ChestnutComponent;
import io.chestnut.core.HandleCast;
import io.chestnut.core.Message;
import io.chestnut.server.commonAPI.MessageDefine;
import io.chestnut.server.commonAPI.scene.MsgEnterSceneRep;
import io.chestnut.server.commonAPI.scene.MsgEnterSceneReq;
import io.chestnut.server.playerServer.PlayerServer;
import io.chestnut.server.playerServer.player.Player;
import io.chestnut.server.playerServer.protocol.ProtocolDefine;
import io.chestnut.server.playerServer.protocol.inProtocol.PtInEnterScene;
import io.chestnut.server.playerServer.protocol.outProtocol.PtOutEnterScene;

public class SceneComponent extends ChestnutComponent<Player>{
	public boolean isChangeScene = false;
	private static final Logger logger = LoggerFactory.getLogger(SceneComponent.class);

	@HandleCast(id = ProtocolDefine.PtInEnterScene)
	public void enterSceneReq(Message message) throws Exception {
		isChangeScene = true;
		PtInEnterScene ptInEnterScene = (PtInEnterScene) message;
		MsgEnterSceneReq requset =  getOwner().chestnutTree().getMessage(MessageDefine.MsgEnterSceneReq);
		requset.setParameter(ptInEnterScene.sceneId, getOwner().getId());
		PlayerServer.chestnutTree.request("sceneService", "SceneMrg", requset , getOwner(),  res ->{
			MsgEnterSceneRep msgEnterSceneReq = (MsgEnterSceneRep) res;
			getOwner().sceneId = msgEnterSceneReq.getSceneId();
			logger.info("进入场景成功 " + msgEnterSceneReq.getSceneId());
			PlayerServer.sendProtocol(getOwner(), new PtOutEnterScene(getOwner().sceneId));
			isChangeScene = false;
		});
		
	}
	
	@HandleCast(id = ProtocolDefine.PtInWalk)
	public void walk(Message message) {
		if(isChangeScene) {
			return;
		}
		
	}

}

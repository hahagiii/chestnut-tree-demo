package io.chestnut.server.sceneServer.sceneMrg;

import io.chestnut.core.Chestnut;
import io.chestnut.server.sceneServer.SceneServer;
import io.chestnut.server.sceneServer.scene.Scene;
import io.chestnut.server.sceneServer.scene.SceneFactory;

public class SceneMrg extends Chestnut{
		
	public static SceneMrg newSceneMrg() {
		SceneMrg sceneMrg = new SceneMrg();
		sceneMrg.addComponent(new MsgReceiveComponent());
		return sceneMrg;
	}

	@Override
	public String getId() {
		return "SceneMrg";
	}
	
	public Scene createScene(String sceneId) throws Exception {
		Scene scene = SceneServer.chestnutTree.getChestnut(sceneId);
		if(scene != null) {
			return scene;
		}
		scene = SceneFactory.newScene(sceneId);
		SceneServer.chestnutTree.deployChestnut(scene);
		return scene;
	}

}

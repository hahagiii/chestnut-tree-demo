package io.chestnut.server.sceneServer.scene;

import io.chestnut.core.Chestnut;

public class Scene extends Chestnut{
	public String sceneId;
	
	public Scene(String sceneId) {
		this.sceneId = sceneId;
	}

	@Override
	public String getId() {
		return sceneId;
	}

}

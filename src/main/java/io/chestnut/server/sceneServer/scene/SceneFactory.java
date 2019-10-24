package io.chestnut.server.sceneServer.scene;

import io.chestnut.server.sceneServer.scene.sceneAoiComponent.ArenaAoiComponet;

public class SceneFactory {

	public static Scene newScene(String sceneId) {
		Scene scene = new Scene(sceneId);
		scene.addComponent(new SpriteMrgComponent());
		scene.addComponent(new ArenaAoiComponet());
		return scene;
	}

}

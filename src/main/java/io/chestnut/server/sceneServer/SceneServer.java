package io.chestnut.server.sceneServer;


import io.chestnut.core.ChestnutTree;
import io.chestnut.core.ChestnutTreeOption;
import io.chestnut.server.sceneServer.sceneMrg.SceneMrg;

public class SceneServer {
	public static ChestnutTree chestnutTree;
	
	public static void main(String args[]) throws Exception {
		 ChestnutTreeOption chestnutTreeOption = new ChestnutTreeOption();
		 chestnutTreeOption.addMessagePathList("io.chestnut.server.commonAPI");
		 chestnutTreeOption.serviceOpt(4, "sceneService", 6677);
		 chestnutTree = new ChestnutTree(chestnutTreeOption);
		 chestnutTree.run();
		 chestnutTree.deployChestnut(SceneMrg.newSceneMrg());
	 }

}

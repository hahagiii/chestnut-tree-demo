package io.chestnut.server.sceneServer;


import io.chestnut.core.ChestnutTree;
import io.chestnut.core.ChestnutTreeOption;
import io.chestnut.core.InternalMsgFactory;
import io.chestnut.server.sceneServer.sceneMrg.SceneMrg;

public class SceneServer {
	public static ChestnutTree chestnutTree;
	
	public static void main(String args[]) throws Exception {
		 InternalMsgFactory.init("io.chestnut.core.example.commonAPI");
		 ChestnutTreeOption chestnutTreeOption = new ChestnutTreeOption();
		 chestnutTreeOption.serviceOpt("sceneService", 6677, "127.0.0.1:8012");
		 chestnutTree = new ChestnutTree(chestnutTreeOption);
		 chestnutTree.run();
		 chestnutTree.deployChestnut(SceneMrg.newSceneMrg());
		 
	 }

}

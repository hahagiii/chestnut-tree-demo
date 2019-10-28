package io.chestnut.server.gateway;

import java.util.HashMap;
import java.util.Map;

import io.chestnut.core.ChestnutTree;
import io.chestnut.core.ChestnutTreeOption;

public class GateWay {
	public static ChestnutTree chestnutTree;
	public static Map<String, ClientConnection> clientConnectionMap = new HashMap<>();

	public static void main(String[] args) throws Exception {
		ChestnutTreeOption chestnutTreeOption = new ChestnutTreeOption();
		chestnutTreeOption.gateWayOpt(8011,8012,8013, 8,ClientConnection.class,ServiceConnection.class);
		chestnutTreeOption.addMessagePathList("io.chestnut.server.commonAPI");
		chestnutTree = new ChestnutTree(chestnutTreeOption);
		chestnutTree.run();
	}
}

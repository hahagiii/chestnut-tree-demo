package io.chestnut.server.playerServer.protocol;

public class ProtocolService {

	public static String serviceName(short id) {
		if(ProtocolDefine.PtInWalk == id) {
			return "sceneService";
		}
		return "playerService";
	}

}

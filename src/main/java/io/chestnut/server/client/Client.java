package io.chestnut.server.client;



import io.chestnut.core.ChestnutEventLoopGroup;
import io.chestnut.core.ChestnutTree;
import io.chestnut.core.ChestnutTreeOption;
import io.chestnut.core.ThreadGroupOptions;
import io.chestnut.core.message.systemMsg.SystemMsgTimerSecond;


public class Client {
	public static ChestnutTree chestnutTree;
	static final SystemMsgTimerSecond systemMsgTimerSecond = new SystemMsgTimerSecond();

	 public static void main(String args[]) throws Exception{
		 ChestnutTreeOption chestnutTreeOption = new ChestnutTreeOption();
		 chestnutTreeOption.addMessagePathList("io.chestnut.server.commonAPI");
		 chestnutTree = new ChestnutTree(chestnutTreeOption.clientOpt(1));
		 chestnutTree.run();
		 ThreadGroupOptions options = new ThreadGroupOptions().setThreadGroupInfo("robot", 4);
		 final ChestnutEventLoopGroup playerGroup = chestnutTree.newChestnutEventLoopGroup(options);
		 playerGroup.addTimerEvent(1000, ()->  playerGroup.castAll(systemMsgTimerSecond));
		 chestnutTree.connect("127.0.0.1", 8011, ClientSocketConnection.class,"firstRobot");
	  } 
}

package io.chestnut.server.client;



import java.util.TimerTask;

import io.chestnut.core.ChestnutEventLoopGroup;
import io.chestnut.core.ChestnutTree;
import io.chestnut.core.ChestnutTreeOption;
import io.chestnut.core.InternalMsgFactory;
import io.chestnut.core.ThreadGroupOptions;
import io.chestnut.core.systemMessage.SystemMsgTimerSecond;


public class Client {
	public static ChestnutTree chestnutTree;
	 
	 public static void main(String args[]) throws Exception{
		 InternalMsgFactory.init("io.chestnut.server.commonAPI");

		 chestnutTree = new ChestnutTree(new ChestnutTreeOption().clientOpt(1));
		 ThreadGroupOptions options = new ThreadGroupOptions().setThreadGroupInfo("robot", 4);
		 final ChestnutEventLoopGroup playerGroup = chestnutTree.newChestnutEventLoopGroup(options);
		 
		 final SystemMsgTimerSecond systemMsgTimerSecond = new SystemMsgTimerSecond();
		 
		 playerGroup.addTimerEvent(new TimerTask() { //每秒给player线程组里面所有的实例发送一个SystemMsgTimerSecond事件
				@Override
				public void run() {
					 playerGroup.castAll(systemMsgTimerSecond);
				}
			},  1000, 1000);
		 
		 
		try {
			chestnutTree.connect("127.0.0.1", 4789,new ClientSocketConnection().setRobotId("firstRobot"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	  } 
}

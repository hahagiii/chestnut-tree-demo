package io.chestnut.server.playerServer;


import java.util.TimerTask;

import io.chestnut.core.ChestnutEventLoopGroup;
import io.chestnut.core.ChestnutTree;
import io.chestnut.core.ChestnutTreeOption;
import io.chestnut.core.DeployOptions;
import io.chestnut.core.InternalMsgFactory;
import io.chestnut.core.ThreadGroupOptions;
import io.chestnut.server.playerServer.auctionHouse.AuctionHouse;
import io.chestnut.server.playerServer.ranklist.RankList;
import io.chestnut.core.orm.EntityMrg;
import io.chestnut.core.systemMessage.SystemMsgTimerSecond;

public class PlayerServer {
	public static ChestnutTree chestnutTree;
	public static EntityMrg entityMrg;
	 public static void main(String args[]) throws Exception {
		 InternalMsgFactory.init("io.chestnut.core.example.commonAPI");
		 ChestnutTreeOption opt = new ChestnutTreeOption();
		 opt.serviceMrgAddress("127.0.0.1:8012");
		 opt.serverOpt(PlayerSocketConnection.class,4789);
		 chestnutTree = new ChestnutTree(opt);
		 chestnutTree.run();
		
		 ThreadGroupOptions options = new ThreadGroupOptions().setThreadGroupInfo("player", 4);
		 ChestnutEventLoopGroup playerGroup = chestnutTree.newChestnutEventLoopGroup(options);
		 
		 SystemMsgTimerSecond systemMsgTimerSecond = new SystemMsgTimerSecond();
		 playerGroup.addTimerEvent(new TimerTask() {

				@Override
				public void run() {
					 playerGroup.castAll(systemMsgTimerSecond);
				}
			},  1000, 1000);
		 
		 
		 
		 ThreadGroupOptions systemFunctionOptions = new ThreadGroupOptions().setThreadGroupInfo("systemFunction", 4);
		 chestnutTree.newChestnutEventLoopGroup(systemFunctionOptions);
		 
		 chestnutTree.deployChestnut(RankList.newInstance(), new DeployOptions().setThreadGroupName("systemFunction"));
		 chestnutTree.deployChestnut(AuctionHouse.newInstance(), new DeployOptions().setThreadGroupName("systemFunction"));
		 
		 chestnutTree.connectService("sceneService");
		 
		
	  } 
}

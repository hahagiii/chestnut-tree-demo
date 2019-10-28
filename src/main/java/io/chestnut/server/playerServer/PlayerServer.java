package io.chestnut.server.playerServer;


import java.io.FileInputStream;
import java.net.URL;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import io.chestnut.core.ChestnutEventLoopGroup;
import io.chestnut.core.ChestnutTree;
import io.chestnut.core.ChestnutTreeOption;
import io.chestnut.core.DeployOptions;
import io.chestnut.core.ThreadGroupOptions;
import io.chestnut.core.message.systemMsg.SystemMsgTimerSecond;
import io.chestnut.core.network.SocketConnection;
import io.chestnut.core.orm.EntityMrg;
import io.chestnut.core.protocol.ProtocolOut;
import io.chestnut.server.playerServer.auctionHouse.AuctionHouse;
import io.chestnut.server.playerServer.linkGateWay.LinkGateWayChestnut;
import io.chestnut.server.playerServer.player.Player;
import io.chestnut.server.playerServer.ranklist.RankList;

public class PlayerServer {
	public static final SystemMsgTimerSecond systemMsgTimerSecond = new SystemMsgTimerSecond();
	public static SocketConnection gateWaySocketConnection;
	public static ChestnutTree chestnutTree;
	public static EntityMrg entityMrg;
	
	@SuppressWarnings("rawtypes")
	public static void main(String args[]) throws Exception {
		 ChestnutTreeOption opt = new ChestnutTreeOption();
		 opt.addMessagePathList("io.chestnut.server.commonAPI");
		 opt.addInProtocolPath("io.chestnut.server.playerServer.protocol.inProtocol");
		 
         URL url = PlayerServer.class.getClassLoader().getResource("playerServiceConfig.yml");
         Map cinfigMap = new Yaml().loadAs(new FileInputStream(url.getFile()),Map.class);
         int listenPort = (int) cinfigMap.get("listenPort");
         
         if(cinfigMap.get("runMode").equals("service")) {//服务模式启动
    		 opt.serviceOpt("playerService", listenPort);
         }else { //服务器模式启动，该节点直接面向客户端
    		 opt.serverOpt(PlayerSocketConnection.class,listenPort);
         }
         chestnutTree = new ChestnutTree(opt);
		 chestnutTree.run();
		 Object gateWayIp = cinfigMap.get("gateWayIp");
		 
		 if(gateWayIp!= null && !gateWayIp.equals("")) {// 连接到网关
			 gateWaySocketConnection =  chestnutTree.linkGateWay((String) gateWayIp, 8012, "playerService", 1, 100);
			 chestnutTree.deployChestnut(LinkGateWayChestnut.newInstance());
		 }
		 
		 if(cinfigMap.get("sceneServiceFindMode").equals("gateWayFind")) {
			 chestnutTree.connectServiceFromGateWay("sceneService", 1, (String)cinfigMap.get("sceneServiceFindIp"), (int)cinfigMap.get("sceneServiceFindPort"));
		 }else if(cinfigMap.get("sceneServiceFindMode").equals("direct")){
    		 chestnutTree.connectService("sceneService", (String)cinfigMap.get("sceneServiceFindIp"), (int)cinfigMap.get("sceneServiceFindPort"));
		 }
		 
		 chestnutTree.newChestnutEventLoopGroup(new ThreadGroupOptions().setThreadGroupInfo("systemFunction", 4));
		 ThreadGroupOptions options = new ThreadGroupOptions().setThreadGroupInfo("player", 4);
		 ChestnutEventLoopGroup playerGroup = chestnutTree.newChestnutEventLoopGroup(options);
		 playerGroup.addTimerEvent(1000,() -> playerGroup.castAll(systemMsgTimerSecond));
		 chestnutTree.deployChestnut(RankList.newInstance(), new DeployOptions().setThreadGroupName("systemFunction"));
		 chestnutTree.deployChestnut(AuctionHouse.newInstance(), new DeployOptions().setThreadGroupName("systemFunction"));
	  } 
	
	public static void sendProtocol(Player player,ProtocolOut protocolOut) {
		protocolOut.setMessageDest(player);
		if(gateWaySocketConnection != null) {
			gateWaySocketConnection.sendProtocol(protocolOut);
		}else {
			player.clientConnection().sendProtocol(protocolOut);
		}
	}
}


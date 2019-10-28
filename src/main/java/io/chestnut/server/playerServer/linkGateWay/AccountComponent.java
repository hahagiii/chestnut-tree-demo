package io.chestnut.server.playerServer.linkGateWay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.chestnut.core.ChestnutComponent;
import io.chestnut.core.DeployOptions;
import io.chestnut.core.HandleCast;
import io.chestnut.core.Message;
import io.chestnut.server.commonAPI.MessageDefine;
import io.chestnut.server.commonAPI.gateWay.MsgEnterPlayerServer;
import io.chestnut.server.playerServer.PlayerServer;
import io.chestnut.server.playerServer.player.Player;
import io.chestnut.server.playerServer.player.PlayerFactory;
import io.chestnut.server.playerServer.protocol.outProtocol.PtOutAuth;

public class AccountComponent extends ChestnutComponent<LinkGateWayChestnut>{
	private static final Logger logger = LoggerFactory.getLogger(AccountComponent.class);

	@HandleCast(id = MessageDefine.MsgEnterPlayerServer)
	public void msgEnterPlayerServer(Message message) throws Exception {
		MsgEnterPlayerServer msgEnterPlayerServer = (MsgEnterPlayerServer) message;
		logger.debug("收到来自网关的登录消息 " + msgEnterPlayerServer.getPlayerId());
		Player player = PlayerFactory.newPlayer(msgEnterPlayerServer.getPlayerId());
		PlayerServer.chestnutTree.deployChestnut(player, new DeployOptions().setThreadGroupName("player"));
		PlayerServer.sendProtocol(player, new PtOutAuth(msgEnterPlayerServer.getPlayerId()));
	}
}

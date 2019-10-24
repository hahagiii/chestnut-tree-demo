package io.chestnut.server.playerServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.chestnut.core.Chestnut;
import io.chestnut.core.DeployOptions;
import io.chestnut.core.SocketConnection;
import io.chestnut.server.playerServer.player.Player;
import io.chestnut.server.playerServer.player.PlayerFactory;
import io.chestnut.server.playerServer.protocol.ProtocolDefine;
import io.chestnut.server.playerServer.protocol.inProtocol.PtInAuth;
import io.chestnut.server.playerServer.protocol.outProtocol.PtOutAuth;
import io.chestnut.core.protocol.ProtocolIn;
import io.chestnut.core.protocol.ProtocolInFactory;
import io.chestnut.core.protocol.ProtocolOut;
import io.chestnut.core.protocol.SimpleProtocolInFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

public class PlayerSocketConnection implements SocketConnection{
	private static final Logger logger = LoggerFactory.getLogger(PlayerSocketConnection.class);
	public Chestnut player;
	public Channel channel;
	public static ProtocolInFactory decodeFactory = new SimpleProtocolInFactory("io.chestnut.server.playerServer.protocol.inProtocol");
	@Override
	public void receiveData(ByteBuf in) throws Exception {
		while(true) {
			ProtocolIn messageDecode = decodeFactory.getProtocolIn(in);
			if(messageDecode == null) {
				return;
			}
			if(messageDecode.id() == ProtocolDefine.PtInAuth) {//登录验证
				PtInAuth protocolAuthRequest = (PtInAuth) messageDecode;
				Player player = PlayerFactory.newPlayer(protocolAuthRequest.playerId);
				PlayerServer.chestnutTree.deployChestnut(player, new DeployOptions().setThreadGroupName("player"));
				player.setClientConnection(this);
				this.player = player;
				logger.info("玩家登录成功  " + protocolAuthRequest.playerId);
				sendProtocol(new PtOutAuth(protocolAuthRequest.playerId));
			}else {
				player.cast(messageDecode);
			}
		}
	}


	@Override
	public void channelInactive() {
		if(player != null) {
			logger.info("连接断开 " + player);
			PlayerServer.chestnutTree.removeChestnut(player.getId());
		}else {
			logger.info("未能登录连接就断开 了");
		}
		
	}

	@Override
	public void channelActive(Channel channel) {
		logger.info("一个新客户端连接到来");
		this.channel = channel;
	}


	@Override
	public void sendProtocol(ProtocolOut protocolOut) {
		this.channel.writeAndFlush(protocolOut);
	}

}

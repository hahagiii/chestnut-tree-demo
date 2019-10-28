package io.chestnut.server.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.chestnut.core.gateway.ServiceNode;
import io.chestnut.core.network.SocketConnection;
import io.chestnut.core.protocol.ProtocolInFactory;
import io.chestnut.core.protocol.SimpleProtocolInFactory;
import io.chestnut.server.commonAPI.MessageDefine;
import io.chestnut.server.commonAPI.gateWay.MsgEnterPlayerServer;
import io.chestnut.server.playerServer.protocol.ProtocolDefine;
import io.chestnut.server.playerServer.protocol.ProtocolService;
import io.chestnut.server.playerServer.protocol.inProtocol.PtInAuth;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

public class ClientConnection implements SocketConnection{
	public static final Logger logger = LoggerFactory.getLogger(ClientConnection.class);
	public static ProtocolInFactory decodeFactory = new SimpleProtocolInFactory("io.chestnut.server.playerServer.protocol.inProtocol");

	public Channel channel;
	public int serverId;
	public String sceneId;
	public String playerId;
	public ClientConnection() {
	}

	@Override
	public void receiveData(ByteBuf in) throws Exception {
		while(true) {
			final int readableBytes = in.readableBytes();
			if(readableBytes < 2)
				return;

			 short length = in.readShort();
			 if(length < 2){
				 throw new Exception("length 小于2");	
			 }
			 if(in.readableBytes() < length){
				 in.readerIndex(in.readerIndex() - 2);
				 return;
			}
			short id = in.readShort();
			switch (id) {
			case ProtocolDefine.PtInAuth:{ //玩家登录
				PtInAuth ptInAuth = new PtInAuth();
				ptInAuth.unpackBody(in);
				playerId = ptInAuth.playerId;
				logger.info("玩家登录网关 " + playerId);
				serverId = 1;
				ServiceNode serviceNode = NodeLoad.getServiceNode("playerService",serverId);
				MsgEnterPlayerServer msgEnterPlayerServer = GateWay.chestnutTree.getMessage(MessageDefine.MsgEnterPlayerServer);
				msgEnterPlayerServer.setPlayerId(playerId);
				GateWay.clientConnectionMap.put(playerId, this);
				serviceNode.transmitMessage("LinkGateWayChestnut", msgEnterPlayerServer);
				}break;
			default:
				String serviceName = ProtocolService.serviceName(id);
				byte [] dst = new byte[length-2];
			    in.readBytes(dst);
			    ServiceNode serviceNode = NodeLoad.getServiceNode(serviceName,serverId);
			    serviceNode.transmitProtocol(playerId, id, dst);
			}
			
		}
		
	}

	@Override
	public void channelActive(Channel channel,Object[] parameter) {
		this.channel = channel;
		logger.info("收到一个新连接 " + channel);
		
	}

	@Override
	public void channelInactive() {
		logger.info(" 断开一个连接 " + channel);

	}

	@Override
	public Channel channel() {
		return channel;
	}

}

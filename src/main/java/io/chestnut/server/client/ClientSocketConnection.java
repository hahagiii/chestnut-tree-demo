package io.chestnut.server.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.chestnut.core.Chestnut;
import io.chestnut.core.DeployOptions;
import io.chestnut.core.SocketConnection;
import io.chestnut.server.client.Robot.Robot;
import io.chestnut.server.client.Robot.RobotFactory;
import io.chestnut.server.client.clientProtocol.ClientProtocolDefine;
import io.chestnut.server.client.clientProtocol.inProtocol.ClientPtInAuth;
import io.chestnut.server.client.clientProtocol.outProtocol.ClientPtOutAuth;
import io.chestnut.server.commonAPI.MessageDefine;
import io.chestnut.core.protocol.ProtocolIn;
import io.chestnut.core.protocol.ProtocolInFactory;
import io.chestnut.core.protocol.ProtocolOut;
import io.chestnut.core.protocol.SimpleProtocolInFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

public class ClientSocketConnection implements SocketConnection{
	private static final Logger logger = LoggerFactory.getLogger(ClientSocketConnection.class);
	public static ProtocolInFactory decodeFactory = new SimpleProtocolInFactory("io.chestnut.server.client.clientProtocol.inProtocol");

	private String robotId;
	public Chestnut robot;
	public Channel channel;
	
	public SocketConnection setRobotId(String robotId) {
		this.robotId = robotId;
		return this;
	}
	
	@Override
	public void receiveData(ByteBuf in) throws Exception {
		while(true) {
			ProtocolIn messageDecode = decodeFactory.getProtocolIn(in);
			if(messageDecode == null) {
				return;
			}
			if(messageDecode.id() == ClientProtocolDefine.ClientPtInAuth) {//登录验证
				ClientPtInAuth protocolAuthRep = (ClientPtInAuth) messageDecode;
				Robot robot = RobotFactory.newRobot(protocolAuthRep.playerId);
				Client.chestnutTree.deployChestnut(robot, new DeployOptions().setThreadGroupName("robot"));
				robot.setClientConnection(this);
				this.robot = robot;
				logger.info("服务器返回登录成功: " + protocolAuthRep.playerId);
				robot.cast(MessageDefine.MsgPlayerLogin);
			}else {
				robot.cast(messageDecode);
			}
		}
	}


	@Override
	public void channelInactive() {
		logger.info("连接断开 " + robot);
	}

	@Override
	public void channelActive(Channel channel) {
		logger.info("与服务器建立连接成功，开始发送登录账号验证信息: " + robotId);
		this.channel = channel;
		sendProtocol(new ClientPtOutAuth(robotId));
	}


	@Override
	public void sendProtocol(ProtocolOut protocolOut) {
		channel.writeAndFlush(protocolOut);
	}

}

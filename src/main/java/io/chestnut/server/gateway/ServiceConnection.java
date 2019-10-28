package io.chestnut.server.gateway;

import io.chestnut.core.InternalMessage;
import io.chestnut.core.gateway.GateWayRecConnection;
import io.chestnut.server.commonAPI.MessageDefine;
import io.netty.buffer.ByteBuf;

public class ServiceConnection implements GateWayRecConnection{

	@Override
	public void toClient(String playerId, byte[] dest) {
		ClientConnection clientConnection = GateWay.clientConnectionMap.get(playerId);
		ByteBuf ByteBuf = clientConnection.channel.alloc().directBuffer(dest.length);
		ByteBuf.writeBytes(dest);
		clientConnection.channel.writeAndFlush(ByteBuf);
	}

	@Override
	public void toGateWay(String serviceName, InternalMessage internalMessage) {
		switch (internalMessage.id()) {
		case MessageDefine.MsgEnterSceneRep: //玩家进入场景成功
			
			break;

		default:
			break;
		}
	}
	
}

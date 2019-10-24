package io.chestnut.server.client.Robot.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.chestnut.core.ChestnutComponent;
import io.chestnut.core.HandleCast;
import io.chestnut.core.Message;
import io.chestnut.server.client.Robot.Robot;
import io.chestnut.server.client.clientProtocol.ClientProtocolDefine;
import io.chestnut.server.client.clientProtocol.inProtocol.ClientPtInEnterScene;
import io.chestnut.server.client.clientProtocol.inProtocol.ClientPtInErrorCode;
import io.chestnut.server.client.clientProtocol.inProtocol.ClientPtInWingUp;
import io.chestnut.server.client.clientProtocol.outProtocol.ClientPtOutEnterScene;
import io.chestnut.server.client.clientProtocol.outProtocol.ClientPtOutWingUp;
import io.chestnut.server.commonAPI.MessageDefine;

public class TestComponet extends ChestnutComponent<Robot>{
	private static final Logger logger = LoggerFactory.getLogger(TestComponet.class);

	
	@HandleCast(id = MessageDefine.MsgPlayerLogin)
	public void ProtocolTest(Message message) {
		logger.info("机器人登录成功，现在进行协议测试"); 
		getOwner().clientConnection().sendProtocol(new ClientPtOutWingUp());
		getOwner().clientConnection().sendProtocol(new ClientPtOutEnterScene("S001"));
	}
	
	
	@HandleCast(id = ClientProtocolDefine.ClientPtInWingUp)
	public void protocolWingUpRep(Message Message) {
		ClientPtInWingUp clientProtocolWingUpRep = (ClientPtInWingUp) Message;
		logger.info("ClientProtocolWingUpRep " + clientProtocolWingUpRep.wingExp);

		
	}
	
	@HandleCast(id = ClientProtocolDefine.ClientPtInEnterScene)
	public void clientPtInEnterScene(Message Message) {
		ClientPtInEnterScene clientPtInEnterScene = (ClientPtInEnterScene) Message;
		logger.info("玩家进入场景成功 " + clientPtInEnterScene.sceneId);
	}
	
	@HandleCast(id = ClientProtocolDefine.ClientPtInErrorCode)
	public void ProtocolErrorCodeRep(Message Message) {
		ClientPtInErrorCode clientProtocolErrorCodeRep = (ClientPtInErrorCode) Message;
		logger.info("通用协议返回 " + clientProtocolErrorCodeRep.protocolId + " errorCode: " + clientProtocolErrorCodeRep.errorCode);
		
	}
}

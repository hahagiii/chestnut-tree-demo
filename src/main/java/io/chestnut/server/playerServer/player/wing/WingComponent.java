package io.chestnut.server.playerServer.player.wing;

import io.chestnut.core.ChestnutComponent;
import io.chestnut.core.HandleCast;
import io.chestnut.core.Message;
import io.chestnut.core.exception.CallFail;
import io.chestnut.server.commonAPI.ErrorCode;
import io.chestnut.server.commonAPI.MessageDefine;
import io.chestnut.server.commonAPI.property.MsgPlayerCostGoldReq;
import io.chestnut.server.commonAPI.property.MsgPlayerExpRep;
import io.chestnut.server.commonAPI.property.MsgPlayerExpReq;
import io.chestnut.server.commonAPI.property.MsgPlayerGoldRep;
import io.chestnut.server.commonAPI.property.MsgPlayerGoldReq;
import io.chestnut.server.playerServer.PlayerServer;
import io.chestnut.server.playerServer.player.Player;
import io.chestnut.server.playerServer.protocol.ProtocolDefine;
import io.chestnut.server.playerServer.protocol.outProtocol.PtOutErrorCode;
import io.chestnut.server.playerServer.protocol.outProtocol.PtOutWingUp;

public class WingComponent extends ChestnutComponent<Player>{
	
	@HandleCast(id = ProtocolDefine.PtInWingUp)
	public void WingUp(Message protocolWingUpRequest) throws Exception {
		try {
			MsgPlayerGoldReq goldReq =  getOwner().chestnutTree().getMessage(MessageDefine.MsgPlayerGoldReq);
			MsgPlayerGoldRep goldRep = getOwner().call(goldReq);
			MsgPlayerExpReq  playerExpReq =  getOwner().chestnutTree().getMessage(MessageDefine.MsgPlayerExpReq);
			MsgPlayerExpRep expRep  = getOwner().call(playerExpReq);
			if(expRep.getExp() < 10) {
				PlayerServer.sendProtocol(getOwner(),new PtOutErrorCode(ProtocolDefine.PtInWingUp, ErrorCode.ExpNotEnough));
				return;
			}
			if(goldRep.getNum() < 10) {
				PlayerServer.sendProtocol(getOwner(),new PtOutErrorCode(ProtocolDefine.PtInWingUp, ErrorCode.GoldNotEnough));
				return;
			}
			MsgPlayerCostGoldReq res = getOwner().chestnutTree().getMessage(MessageDefine.MsgPlayerCostGoldReq);
			res.setCostNum(10);
			getOwner().execute(res);
			Wing wing = PlayerServer.entityMrg.getEntityById(Wing.class, getOwner().getId());
			wing.wingExp += 100;
			PlayerServer.entityMrg.updateField(wing,"wingExp");
			PlayerServer.sendProtocol(getOwner(),new PtOutWingUp(wing.wingExp));
		} catch (CallFail e) {
			PlayerServer.sendProtocol(getOwner(),new PtOutErrorCode(ProtocolDefine.PtInWingUp, e.getErrorCode()));
		}
		
	}
	
}

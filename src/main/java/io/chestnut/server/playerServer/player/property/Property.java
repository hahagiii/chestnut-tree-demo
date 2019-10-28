package io.chestnut.server.playerServer.player.property;

import io.chestnut.core.ChestnutComponent;
import io.chestnut.core.HandleCall;
import io.chestnut.core.HandleCast;
import io.chestnut.core.Message;
import io.chestnut.core.exception.CallFail;
import io.chestnut.core.message.systemMsg.SystemMessageDefine;
import io.chestnut.server.commonAPI.MessageDefine;
import io.chestnut.server.commonAPI.property.MsgPlayerCostGoldRep;
import io.chestnut.server.commonAPI.property.MsgPlayerCostGoldReq;
import io.chestnut.server.commonAPI.property.MsgPlayerExpRep;
import io.chestnut.server.commonAPI.property.MsgPlayerGoldRep;
import io.chestnut.server.playerServer.player.Player;

public class Property extends ChestnutComponent<Player>{
	public int playerExp;
	public int playerGold;
	
	@HandleCast(id = SystemMessageDefine.SystemMsgTimerSecond)
	public void addExpPerSecond(Message protocolTimerSecond) {
		playerExp += 20;
	}
	
	@HandleCast(id = SystemMessageDefine.SystemMsgTimerMinute)
	public void addMoney(Message protocolTimerSecond) {
		playerGold += 20;
	}
	
	@HandleCall(id = MessageDefine.MsgPlayerExpReq)
	public Message playerExpReq(Message message) throws Exception {
		MsgPlayerExpRep res = getOwner().chestnutTree().getMessage(MessageDefine.MsgPlayerExpRep);
		res.setExp(playerExp);
		return res;
		
	}
	
	
	@HandleCall(id = MessageDefine.MsgPlayerGoldReq)
	public Message playerGoldReq(Message MsgPlayerGoldReq) throws Exception {
		MsgPlayerGoldRep res = getOwner().chestnutTree().getMessage(MessageDefine.MsgPlayerGoldRep);
		res.setNum(playerGold);
		return res;
	}
	
	@HandleCall(id = MessageDefine.MsgPlayerCostGoldReq)
	public Message playerCostGoldReq(Message requstMessage) throws Exception {
		MsgPlayerCostGoldReq msgPlayerCostGoldReq =  (MsgPlayerCostGoldReq) requstMessage;
		if(msgPlayerCostGoldReq.getCostNum() > playerGold) {
			throw new CallFail("playerGold is not en");
		}
		MsgPlayerCostGoldRep res =  getOwner().chestnutTree().getMessage(MessageDefine.MsgPlayerCostGoldRep);
		res.setRemainderNum(playerGold);
		return res;
	}
}

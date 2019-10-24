package io.chestnut.server.playerServer.player.bag;

import java.util.List;

import io.chestnut.core.ChestnutComponent;
import io.chestnut.core.HandleCast;
import io.chestnut.core.Message;
import io.chestnut.server.playerServer.player.Player;
import io.chestnut.core.orm.EntityMrg;
import io.chestnut.core.systemMessage.SystemMessageDefine;

public class BagComponet extends ChestnutComponent<Player>{
	
	public List<Bag> bagList;
	
	@HandleCast(id = SystemMessageDefine.SystemMsgPlayerDbInit,asyn = true)
	public void init(Message protocolTimerSecond) {
		bagList =  EntityMrg.getEntityList("_id",getOwner().getId());
		sendItemList(bagList);
	}
	
	public void sendItemList(List<Bag> bagList) {
		
	}
}

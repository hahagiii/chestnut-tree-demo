package io.chestnut.server.playerServer.player.bag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import io.chestnut.core.orm.Column;
import io.chestnut.core.orm.Entity;
import io.chestnut.core.orm.Id;
import io.chestnut.core.orm.RelatedData;

@Entity(name="bag")
public class Bag{
	@Id()
	private String id;
	
	@Column()
	private String playerId;
	
	@Column()
	private int slotNum;
	
	@Column()
	private int bagType;
	
	@RefDB(look= {"playerId","bagType"})
	public Map<String, Item> itemMap;
	
	@RelatedData(method="slotItemListInit")
	public List<ItemSlot> slotItemList;
	
	
	public int slotItemListInit() {
		slotItemList = new ArrayList<ItemSlot>(this.slotNum);
		for (Item item : itemMap.values()) {
			itemMap.put(item.itemId, item);
			slotItemList.set(item.index, new ItemSlot(item.index, item));
		}
		return 0;
	}

}

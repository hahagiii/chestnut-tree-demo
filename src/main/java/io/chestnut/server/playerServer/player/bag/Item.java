package io.chestnut.server.playerServer.player.bag;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import io.chestnut.core.orm.Column;
import io.chestnut.core.orm.Entity;
import io.chestnut.core.orm.Id;

@Entity(name="item")
public class Item{
	@Id()
	public String itemId;

	@Column()
	public String playerId;
	
	@Column()
	public int index;
	
	@Column()
	public List<EquipAttr> equipAttrList;
	
	@Column()
	public WashAttr washAttr;
	
	@Column()
	public HashMap<Integer, Box> boxMap;
	
	@Column()
	public HashSet<Gemstone> gemstoneSet;
	
	@Column()
	public HashMap<Integer, Integer> test2;
	
	@Column()
	public HashMap<Integer, Integer> test3;
	
	@Column()
	public HashMap<Integer, List<String>> test4;
	
	

}

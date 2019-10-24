package io.chestnut.server.playerServer.player.wing;

import io.chestnut.core.orm.Column;
import io.chestnut.core.orm.Entity;
import io.chestnut.core.orm.Id;

@Entity(name="wing",cacheOwner="playerId")
public class Wing{
	
	@Id()
	public String playerId;
	
	@Column(name="wingExp")
	public int wingExp;

}

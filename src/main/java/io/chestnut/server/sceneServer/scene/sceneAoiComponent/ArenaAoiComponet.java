package io.chestnut.server.sceneServer.scene.sceneAoiComponent;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.chestnut.server.playerServer.player.Player;
import io.chestnut.server.sceneServer.Position;
import io.chestnut.server.sceneServer.sprite.FightSprite;
import io.chestnut.server.sceneServer.sprite.Sprite;
import io.chestnut.server.sceneServer.sprite.monster.Monster;
import io.chestnut.core.protocol.ProtocolOut;

public class ArenaAoiComponet extends AOIComponent{	
	public Set<Monster> monsterSet = new HashSet<>();
	public Set<Player> playerSet = new HashSet<>();
	
	
	@Override
	public void getFightSpritesInHalfMoon(List<Sprite> fightSpriteList, Position pos, byte direction, int nGrid,byte gamespriteMonster) {
		
	}
	@Override
	public void getFightSpritesInCircular(List<Sprite> fightSpriteList, Position center, int radiusGrid,
			byte spriteType) {
		
		
	}
	@Override
	public void getFightSpritesInDirection(List<Sprite> fightSpriteList, Position pos, byte direction, int radiusWidth,
			int nGrid, byte gamespriteMonster) {
		
		
	}
	@Override
	public Collection<Sprite> getAttackSprites(int aoiX, int aoiY, byte spriteType) {
		
		return null;
	}
	@Override
	public void enterMap(Sprite sprite, Position postion, boolean needBroadcast) {
		
	}
	@Override
	public void leaveMap(Sprite sprite, boolean needBroadcast, Position leavePosition) {
		
	}
	@Override
	public void spriteJump(Sprite sprite, Position CurrentPosition, Position position) {
		
	}
	@Override
	public void spriteMove(FightSprite sprite, Position lastPosition, Position CurrentPosition, Position targetPosition,byte clientState) {
		
		
	}
	@Override
	public void spriteSilentMove(FightSprite sprite, Position lastPosition, Position CurrentPosition,
			Position targetPosition) {
		
		
	}
	@Override
	public void getAoiInfo(FightSprite player, Position position) {
		
		
	}
	@Override
	public void broadcast(Sprite sprite, ProtocolOut protocolOut, Position position) {
		
		
	}
	@Override
	public Sprite getSpriteInPoint(int x, int y, byte type) {
		
		return null;
	}



}

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
	public void getFightSpritesInHalfMoon(List<Sprite> fightSpriteList, Position pos, byte direction, int nGrid,
			byte gamespriteMonster) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getFightSpritesInCircular(List<Sprite> fightSpriteList, Position center, int radiusGrid,
			byte spriteType) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getFightSpritesInDirection(List<Sprite> fightSpriteList, Position pos, byte direction, int radiusWidth,
			int nGrid, byte gamespriteMonster) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Collection<Sprite> getAttackSprites(int aoiX, int aoiY, byte spriteType) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void enterMap(Sprite sprite, Position postion, boolean needBroadcast) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void leaveMap(Sprite sprite, boolean needBroadcast, Position leavePosition) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void spriteJump(Sprite sprite, Position CurrentPosition, Position position) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void spriteMove(FightSprite sprite, Position lastPosition, Position CurrentPosition, Position targetPosition,
			byte clientState) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void spriteSilentMove(FightSprite sprite, Position lastPosition, Position CurrentPosition,
			Position targetPosition) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getAoiInfo(FightSprite player, Position position) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void broadcast(Sprite sprite, ProtocolOut protocolOut, Position position) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Sprite getSpriteInPoint(int x, int y, byte type) {
		// TODO Auto-generated method stub
		return null;
	}



}

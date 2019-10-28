/**
 *   Copyright 2013-2015 Sophia
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package io.chestnut.server.sceneServer.scene.sceneAoiComponent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import io.chestnut.core.ChestnutComponent;
import io.chestnut.server.sceneServer.Position;
import io.chestnut.server.sceneServer.SceneDefine;
import io.chestnut.server.sceneServer.scene.Scene;
import io.chestnut.server.sceneServer.sprite.FightSprite;
import io.chestnut.server.sceneServer.sprite.Sprite;
import io.chestnut.core.protocol.ProtocolOut;
import io.chestnut.core.util.DebugUtil;


public abstract class AOIComponent extends ChestnutComponent<Scene> {
	private static final Logger logger = LoggerFactory.getLogger(AOIComponent.class.getName());

	
	public List<Sprite> attackTargetList = new ArrayList<>();

	
	public List<Sprite> attackTargetList() {
		if(!attackTargetList.isEmpty()) {
			logger.error("attackTargetList is null " + DebugUtil.printStack());
			attackTargetList = new ArrayList<>();
		}
		return attackTargetList;
	}
	
	public AOIComponent () {
		this.componentId = "AOIComponent";
	}
	public abstract void getFightSpritesInHalfMoon(List<Sprite> fightSpriteList, Position pos, byte direction, int nGrid,byte gamespriteMonster);
	public abstract void getFightSpritesInCircular(List<Sprite> fightSpriteList,Position center, int radiusGrid,byte spriteType);
	public abstract void getFightSpritesInDirection(List<Sprite> fightSpriteList, Position pos, byte direction,int radiusWidth, int nGrid, byte gamespriteMonster);
	
	public abstract Collection<Sprite> getAttackSprites(int aoiX, int aoiY,byte spriteType);
	public abstract void enterMap(Sprite sprite, Position postion, boolean needBroadcast);
	public abstract void leaveMap(Sprite sprite, boolean needBroadcast,Position leavePosition);
	public abstract void spriteJump(Sprite sprite,Position CurrentPosition,Position position);
	public abstract void spriteMove(FightSprite sprite,Position lastPosition, Position CurrentPosition, Position targetPosition,byte clientState);
	public abstract void spriteSilentMove(FightSprite sprite,Position lastPosition, Position CurrentPosition, Position targetPosition);
	public abstract void getAoiInfo(FightSprite player,Position position);
	public abstract void broadcast(Sprite sprite, ProtocolOut protocolOut,Position position);
	public abstract Sprite getSpriteInPoint(int x, int y, byte type);


	public static boolean isAcrossBorder(Position CurrentPosition, Position targetPosition) {
		int oldAoiX = CurrentPosition.getX() /  SceneDefine.aoiWidthX;
		int oldAoiY = CurrentPosition.getY() /  SceneDefine.aoiWidthY;
		int aoiX = targetPosition.getX() /  SceneDefine.aoiWidthX;
		int aoiY = targetPosition.getY() /  SceneDefine.aoiWidthY;
		if(oldAoiX!=aoiX||oldAoiY!=aoiY)
			return true;
		return false;
	}
	
}



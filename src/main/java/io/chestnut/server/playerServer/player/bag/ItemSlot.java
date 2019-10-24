package io.chestnut.server.playerServer.player.bag;

public class ItemSlot {
	public ItemSlot(int index, Item item) {
		this.index = index;
		this.item = item;
	}
	public Item item;
	public int index;
}

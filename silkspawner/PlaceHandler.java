public class PlaceEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	
	Player placer;
	Block spawner;
	ItemStack item;
	
	public PlaceEvent(Player placer, Block spawner, ItemStack item) {
		this.placer = placer;
		this.spawner = spawner;
		this.item = item;
	}
	
	public Player getPlacer() {
		return placer;
	}
	
	public Block getSpawner() {
		return spawner;
	}
	
	public ItemStack getItem() {
		return item;
	}
	
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
}

public class BreakEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	
	Player breaker;
	Block spawner;
	
	public BreakEvent(Player breaker, Block spawner) {
		this.breaker = breaker;
		this.spawner = spawner;
	}
	
	public Player getBreaker() {
		return breaker;
	}
	
	public Block getSpawner() {
		return spawner;
	}
	
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
}

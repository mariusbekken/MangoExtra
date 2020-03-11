public class PlaceListener implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Block bp = e.getBlock();
		if(bp.getType().equals(Material.SPAWNER)) {
			Bukkit.getServer().getPluginManager().callEvent(new PlaceEvent(e.getPlayer(), bp, e.getItemInHand()));;
		}
	}
	
}

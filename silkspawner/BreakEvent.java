public class BreakListener implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Block bb = e.getBlock();
		if(bb.getType().equals(Material.SPAWNER)) {
			e.setExpToDrop(0);
			Bukkit.getServer().getPluginManager().callEvent(new BreakEvent(e.getPlayer(), bb));
		}
	}
	
}

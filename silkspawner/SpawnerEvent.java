public class SpawnerListener implements Listener { 

	@EventHandler
	public void onSpawnerBreak(BreakEvent e) {
		CreatureSpawner cs = (CreatureSpawner) e.getSpawner().getState();
		EntityType mob = cs.getSpawnedType();
		String mobname = WordUtils.capitalizeFully(mob.name().replaceAll("_", " "));

		ItemStack spawner_itemstack = new ItemStack(Material.SPAWNER);
		
		BlockStateMeta meta = (BlockStateMeta) spawner_itemstack.getItemMeta();
		CreatureSpawner csp = (CreatureSpawner) meta.getBlockState();
		
		csp.setSpawnedType(cs.getSpawnedType());
		meta.setBlockState(csp);
		meta.setDisplayName(ChatColor.YELLOW + mobname + ChatColor.WHITE + " spawner");
		
		spawner_itemstack.setItemMeta(meta);
		if((e.getBreaker().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) && e.getBreaker().getInventory().getItemInMainHand().getType().toString().endsWith("PICKAXE")) && e.getBreaker().hasPermission("silkspawner.use")) {
            Block block = e.getSpawner();
            Location centerOfBlock = block.getLocation().add(0.5, 0.5, 0.5);
            block.getWorld().dropItemNaturally(centerOfBlock, spawner_itemstack);
		}
		
	}
	
	@EventHandler
	public void onSpawnerPlace(PlaceEvent e) {
        CreatureSpawner cs = (CreatureSpawner) e.getSpawner().getState();
        ItemStack item = e.getItem();
        
        BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
        CreatureSpawner csp = (CreatureSpawner) meta.getBlockState();
        cs.setSpawnedType(csp.getSpawnedType());
        cs.update();
	}
}

package com.keanu.boatentity;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
//import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;


public class BoatEntity implements Listener {

	@EventHandler
	//public void onCreatureSpawn(LivingEntity spawnee, CreatureSpawnEvent.SpawnReason spawnReason){
	public void onCreatureSpawn(CreatureSpawnEvent event){
		Entity entity = event.getEntity();
		CreatureSpawnEvent.SpawnReason spawnReason = event.getSpawnReason();
		if(spawnReason.name().equals(CreatureSpawnEvent.SpawnReason.SPAWNER_EGG.toString())){
			Location loca = entity.getLocation();
			World wld = entity.getWorld();
			Entity boat = wld.spawnEntity(loca, EntityType.BOAT);
			boat.addPassenger(entity);
		}
	}
}

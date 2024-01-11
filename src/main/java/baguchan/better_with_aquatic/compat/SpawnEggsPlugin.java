package baguchan.better_with_aquatic.compat;

import baguchan.better_with_aquatic.entity.EntityAnglerFish;
import baguchan.better_with_aquatic.entity.EntityDrowned;
import baguchan.better_with_aquatic.entity.EntityFish;
import useless.spawneggs.SpawnEggsEntrypoint;
import useless.spawneggs.SpawnEggsMod;

import java.awt.*;

public class SpawnEggsPlugin implements SpawnEggsEntrypoint {
	@Override
	public void onLoad() {
		SpawnEggsMod.createSpawnEgg(EntityFish.class, new Color(0x6B9F93), new Color(0xADBEDB));
		SpawnEggsMod.createSpawnEgg(EntityAnglerFish.class, new Color(0x7B3E3E), new Color(0x3D1818));
		SpawnEggsMod.createSpawnEgg(EntityDrowned.class, new Color(0xFF79CCB6, true), new Color(0x425538));
	}
}

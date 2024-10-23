package com.kairos.randomItems;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Disaster {
    private DisasterType getRandomDisaster() {
        Random rand = new Random();

        DisasterType[] disasters = DisasterType.values();

        int length = disasters.length;
        return disasters[rand.nextInt(length)];
    }

    public void applyDisasterEffect(@NotNull Player player) {
        DisasterType randomDisaster = getRandomDisaster();
        Location location = player.getLocation();
        switch (randomDisaster) {
            case THUNDER:
                int AMOUNT_OF_STRIKES = 4;
                Random tempRand = new Random();

                for (int i = 0; i < AMOUNT_OF_STRIKES; i++) {
                    Location newLocation = location.clone();

                    int offsetX = tempRand.nextInt(3) - 1;
                    int offsetZ = tempRand.nextInt(3) - 1;
                    newLocation.add(offsetX, 0, offsetZ);

                    player.getWorld().strikeLightning(newLocation);
                }
                break;
            case EXPLOSION:
                TNTPrimed tnt = location.getWorld().spawn(location, TNTPrimed.class);
                tnt.setFuseTicks(40);
                tnt.setYield(1f);
                break;
            case LAVA:
                Location newLocation = location.clone();
                newLocation.add(0, 5, 0);

                player.getWorld().getBlockAt(newLocation).setType(Material.LAVA);
                break;
            case LAUNCH:
                PotionEffect potionEffect = new PotionEffect(PotionEffectType.LEVITATION, 1, 100, false);
                player.addPotionEffect(potionEffect);
                break;
            case FIREWORK:
                Firework firework = player.getWorld().spawn(location, Firework.class);
                FireworkMeta meta = firework.getFireworkMeta();
                meta.addEffect(FireworkEffect.builder()
                        .withColor(Color.RED, Color.BLUE, Color.GREEN)
                        .withFade(Color.YELLOW)
                        .with(FireworkEffect.Type.BURST)
                        .withFlicker()
                        .build()
                );
                meta.setPower(2);
                firework.setFireworkMeta(meta);

                break;
            case SUMMON_MOB:
                Random tempRandMobs = new Random();
                World world = player.getWorld();
                int mobTypeInt = tempRandMobs.nextInt(4); // 4 Types of mobs

                switch (mobTypeInt) {
                    case 0:
                        for (int i = 0; i < 5; i++) {
                            Skeleton skeleton = world.spawn(location, Skeleton.class);
                        }
                        break;
                    case 1:
                        for (int i = 0; i < 5; i++) {
                            Zombie zombie = world.spawn(location, Zombie.class);
                        }
                        break;
                    case 2:
                        for (int i = 0; i < 5; i++) {
                            Creeper creeper = world.spawn(location, Creeper.class);
                        }
                        break;
                    case 3:
                        for (int i = 0; i < 5; i++) {
                            Spider spider = world.spawn(location, Spider.class);
                        }
                        break;
                }
                break;
            case TELEPORT:
                Random tempRandTeleport = new Random();
                List<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
                Player randomPlayer = onlinePlayers.get(tempRandTeleport.nextInt(onlinePlayers.size()));

                player.teleport(randomPlayer);
                break;
        }
    }
}

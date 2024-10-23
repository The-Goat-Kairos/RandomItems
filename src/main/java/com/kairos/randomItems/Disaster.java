package com.kairos.randomItems;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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
        switch (randomDisaster) {
            case THUNDER:
                Location location = player.getLocation();
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
                player.sendPlainMessage("Explosion!!!");
                break;
            case LAVA:
                player.sendPlainMessage("Lava!");
                break;
            case LAUNCH:
                player.sendPlainMessage("LAUNCH");
                break;
            case FIREWORK:
                player.sendPlainMessage("Firework");
                break;
            case SUMMON_MOB:
                player.sendPlainMessage("Summon MOB");
                break;
            case TELEPORT:
                player.sendPlainMessage("Teleport");
                break;
        }
    }
}

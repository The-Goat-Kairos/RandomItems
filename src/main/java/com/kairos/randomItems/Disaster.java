package com.kairos.randomItems;

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

                break;
            case EXPLOSION:

                break;
            case LAVA:

                break;
            case LAUNCH:

                break;
            case FIREWORK:

                break;
            case SUMMON_MOB:

                break;
            case TELEPORT:

                break;
        }
    }
}

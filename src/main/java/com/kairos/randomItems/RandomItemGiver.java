package com.kairos.randomItems;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class RandomItemGiver extends BukkitRunnable {
    public final JavaPlugin plugin;
    private final Random random = new Random();
    private BukkitTask task = null;

    private long time = 20 * 10; // Seconde is 20 ticks.

    public RandomItemGiver(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            giveRandomItems(player);
        }
    }

    private Material getRandomItem() {
        Material[] materials = Material.values(); // Je kan gewoon Material.values() gebruiken ik wist niet dat dit bestond lol
        Material material;

        do {
            material = materials[random.nextInt(materials.length)];
        } while (BannedItems.BANNED_MATERIALS.contains(material) || !material.isItem() || material.isLegacy()); // Blijft dingen kiezen tot het niet verbannen is.
                                                                    // Interface want class leek overkill en voor een enum zou ik een functie moeten schrijven en dat is moeite :D

        return material;
    }

    private void giveRandomItems(@NotNull Player player) {
        int itemAmount = random.nextInt(8) + 1; // 8 klinkt fair
        Material material = getRandomItem();
        ItemStack itemStack;

        itemStack = new ItemStack(material, itemAmount);

        if (player.getInventory().firstEmpty() != -1) { // Inventory niet vol
            player.getInventory().addItem(itemStack);
        } else {
            Component message = MiniMessage
                    .miniMessage()
                    .deserialize("<u><bold><red>Inventory vol!</red></bold></u>");
            player.sendActionBar(message);
        }
    }

    public void setTimer(int newTime) {
        this.time = newTime;
    }

    public void startEvent() {
        stopEvent(); // Probeer eerst de event te vernietigen

        System.out.println("Event gestart");
        run(); //Anders begint ie *tijd* later.
        task = new RandomItemGiver(plugin).runTaskTimerAsynchronously(plugin, time, time); // ??????????
    }

    public void stopEvent() {
        if (task != null) {
            System.out.println("Event gestopt");
            task.cancel();
            task = null;
        } // Dit voelt lelijk maar ik weet niet zo goed hoe dit beter kan
        // Volgens mij is dit flink scuffed
    }
}

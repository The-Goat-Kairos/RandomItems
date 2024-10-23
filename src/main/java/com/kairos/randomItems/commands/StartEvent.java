package com.kairos.randomItems.commands;

import com.kairos.randomItems.RandomItemGiver;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.Duration;
import java.util.logging.Logger;

@SuppressWarnings("UnstableApiUsage")
public class StartEvent {
    private static RandomItemGiver itemGiver;

    public static void setItemGiver(RandomItemGiver giver) {
        itemGiver = giver;
    }

    public static int execute(CommandContext<CommandSourceStack> ctx) {
        new BukkitRunnable() {
            int countdown = 5;

            @Override
            public void run() {
                itemGiver.plugin.getComponentLogger().debug(Component.text("Oke hij runt?"));
                if (countdown > 0) {
                    itemGiver.plugin.getComponentLogger().debug(Component.text("Elke seconde"));
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        Component miniMessage = MiniMessage.miniMessage().deserialize("<red><b>" + countdown + "</red></b>");
                        Title.Times times = Title.Times.times(Duration.ofMillis(10), Duration.ofMillis(800), Duration.ofMillis(180));
                        Title countdownTitle = Title.title(miniMessage, Component.empty(), times);

                        player.showTitle(countdownTitle);
                    }
                    countdown--;
                } else {
                    itemGiver.plugin.getComponentLogger().debug(Component.text("Begin event"));
                    itemGiver.startEvent();
                    cancel();
                }
            }
        }.runTaskTimer(itemGiver.plugin, 0L, 20L);

        return Command.SINGLE_SUCCESS;
    }
}

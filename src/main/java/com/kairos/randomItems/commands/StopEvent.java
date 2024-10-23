package com.kairos.randomItems.commands;

import com.kairos.randomItems.Disaster;
import com.kairos.randomItems.RandomItemGiver;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.time.Duration;

@SuppressWarnings("UnstableApiUsage")
public class StopEvent {
    private static RandomItemGiver itemGiver;
    private final static Disaster disaster = new Disaster();
    private final static int NUM_OF_DISASTERS = 3;

    private final static Title.Times times = Title.Times.times(Duration.ofMillis(500), Duration.ofMillis(2000), Duration.ofMillis(500));
    private final static Title title = Title.title(
            MiniMessage.miniMessage().deserialize(""),
            Component.empty(),
            times
    );

    public static void setItemGiver(RandomItemGiver giver) {
        itemGiver = giver;
    }

    public static int execute(CommandContext<CommandSourceStack> ctx) {
        ctx.getSource().getLocation().getWorld().setTime(18000);

        for (Player player : Bukkit.getOnlinePlayers()) {
            for (int i = 0; i < NUM_OF_DISASTERS; i++) {
                disaster.applyDisasterEffect(player);
            }
        }
        itemGiver.stopEvent();

        return Command.SINGLE_SUCCESS;
    }
}

package com.kairos.randomItems.commands;

import com.kairos.randomItems.RandomItemGiver;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@SuppressWarnings("UnstableApiUsage")
public class StartEvent {
    private static RandomItemGiver itemGiver;

    public static void setItemGiver(RandomItemGiver giver) {
        itemGiver = giver;
    }

    public static int execute(CommandContext<CommandSourceStack> ctx) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendPlainMessage("EVENEMENT BEGINT!!!");
        }
        itemGiver.startEvent();

        return Command.SINGLE_SUCCESS;
    }
}

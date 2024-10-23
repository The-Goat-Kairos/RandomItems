package com.kairos.randomItems.commands;

import com.kairos.randomItems.Disaster;
import com.kairos.randomItems.RandomItemGiver;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@SuppressWarnings("UnstableApiUsage")
public class StopEvent {
    private static RandomItemGiver itemGiver;
    private final static Disaster disaster = new Disaster();

    public static void setItemGiver(RandomItemGiver giver) {
        itemGiver = giver;
    }

    public static int execute(CommandContext<CommandSourceStack> ctx) {
        if (itemGiver.isCancelled() || itemGiver == null) {return 0;}

        ctx.getSource().getLocation().getWorld().setTime(18000);
        for (Player player : Bukkit.getOnlinePlayers()) {
//          player.sendPlainMessage("EVENEMENT STOPT!!!!!");
            for (int i = 0; i < 3; i++) {
                disaster.applyDisasterEffect(player);
            }
        }
        itemGiver.stopEvent();

        return Command.SINGLE_SUCCESS;
    }
}

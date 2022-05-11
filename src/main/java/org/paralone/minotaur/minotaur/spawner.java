package org.paralone.minotaur.minotaur;

import jdk.tools.jlink.plugin.Plugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.jetbrains.annotations.NotNull;

public class spawner implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return false;
    }
}

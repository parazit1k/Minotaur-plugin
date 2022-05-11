package org.paralone.minotaur.minotaur;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public final class Minotaur extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public @NotNull Logger getSLF4JLogger() {
        return super.getSLF4JLogger();
    }



    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();

            Random rn = new Random();
            int answer = rn.nextInt(10) + 1;

            if(answer >= 3 && answer <= 5) {

                World world = p.getWorld();
                Location loc = p.getLocation();

                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
                p.playSound(loc, Sound.ENTITY_COW_AMBIENT, 50, 0.2f);

                WitherSkeleton wither = (WitherSkeleton) world.spawnEntity(loc.add(0, 1, 0), EntityType.WITHER_SKELETON);

                Objects.requireNonNull(wither.getEquipment()).setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                wither.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                wither.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        wither.damage(10000);
                    }
                }, 0, 500);
            }
        }
    }
}

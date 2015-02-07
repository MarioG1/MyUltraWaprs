/*
 * Decompiled with CFR 0_95.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Server
 *  org.bukkit.World
 *  org.bukkit.block.Block
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitScheduler
 *  org.bukkit.util.Vector
 */
package REALDrummer;

import REALDrummer.myUltraWarps;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class myUltraWarps$1
implements Runnable {
    private CommandSender sender;
    private String method;
    private Object[] objects;
    private byte seconds_passed = 20;

    public /* varargs */ myUltraWarps$1(CommandSender my_sender, String my_method, Object ... my_objects) {
        this.sender = my_sender;
        this.method = my_method;
        this.objects = my_objects;
    }

    @Override
    public void run() {
        if (this.method.equals("remove cooldown")) {
            myUltraWarps.cooling_down_players.remove((String)this.objects[0]);
            myUltraWarps.debug(String.valueOf((String)this.objects[0]) + " was removed from the list of cooling down players.");
        } else if (this.method.equals("follow through on /to request")) {
            this.followThroughOnToRequest((Player)this.objects[0], (ArrayList)this.objects[1]);
        } else if (this.method.equals("perform teleportation") || this.method.equals("teleport between worlds")) {
            if (this.method.equals("teleport between worlds")) {
                myUltraWarps.debug("trying again to teleport between worlds...");
            }
            myUltraWarps$1.performTeleportation((Player)this.sender, (Location)this.objects[0]);
        } else if (this.method.equals("remove interworldly teleportation delay")) {
            myUltraWarps.debug("interworldly teleportation delay satisfied; changing boolean to \"false\"");
            myUltraWarps.delay_teleportation_between_worlds = false;
        } else {
            myUltraWarps.tellOps((Object)ChatColor.DARK_RED + "Hey! What the heck does \"" + this.method + "\" mean? Get REALDrummer over here and tell him to fix this!", true, new String[0]);
        }
    }

    private void followThroughOnToRequest(Player target_player, ArrayList<String> previous_requests) {
        if (!(myUltraWarps.to_teleport_requests.get(target_player.getName()) != null && myUltraWarps.to_teleport_requests.get(target_player.getName()).contains(this.sender.getName()))) {
            return;
        }
        if (this.seconds_passed == 20 && myUltraWarps.to_teleport_requests.get(target_player.getName()).equals(previous_requests)) {
            target_player.sendMessage((Object)ChatColor.GREEN + "Hey, " + target_player.getName() + ", " + this.sender.getName() + " still wants to teleport to you. Is that okay?");
            this.seconds_passed = 40;
            myUltraWarps.server.getScheduler().scheduleSyncDelayedTask(myUltraWarps.mUW, (Runnable)this, 400);
        } else if (this.seconds_passed == 40 && myUltraWarps.to_teleport_requests.get(target_player.getName()).equals(previous_requests)) {
            target_player.sendMessage((Object)ChatColor.GREEN + "Hey, " + target_player.getName() + ", can " + this.sender.getName() + " teleport to you? Yes or no?");
            this.seconds_passed = 60;
            myUltraWarps.server.getScheduler().scheduleSyncDelayedTask(myUltraWarps.mUW, (Runnable)this, 400);
        } else if (this.seconds_passed == 60 && myUltraWarps.to_teleport_requests.get(target_player.getName()) != null && myUltraWarps.to_teleport_requests.get(target_player.getName()).contains(this.sender.getName())) {
            target_player.sendMessage((Object)ChatColor.GREEN + "I'll assume your silence means that you don't want " + this.sender.getName() + " to teleport to you.");
            this.sender.sendMessage((Object)ChatColor.RED + "Despite my best efforts, " + target_player.getName() + " won't respond. They might be busy. Try again in a bit.");
            ArrayList<String> requests = myUltraWarps.to_teleport_requests.get(target_player.getName());
            requests.remove(target_player.getName());
            myUltraWarps.to_teleport_requests.put(this.sender.getName(), requests);
        } else if (!myUltraWarps.to_teleport_requests.get(target_player.getName()).equals(previous_requests)) {
            myUltraWarps.server.getScheduler().scheduleSyncDelayedTask(myUltraWarps.mUW, (Runnable)this, (long)((60 - this.seconds_passed) * 20));
            this.seconds_passed = 60;
        }
    }

    public static boolean performTeleportation(Player player, Location to) {
        if (!player.getWorld().equals((Object)to.getWorld())) {
            if (myUltraWarps.delay_teleportation_between_worlds) {
                myUltraWarps.server.getScheduler().scheduleSyncDelayedTask(myUltraWarps.mUW, (Runnable)new myUltraWarps$1((CommandSender)player, "teleport between worlds", new Object[]{to}), 2);
                myUltraWarps.debug("recent interworldly teleportation; delaying teleportation...");
                return true;
            }
            myUltraWarps.delay_teleportation_between_worlds = true;
            myUltraWarps.server.getScheduler().scheduleSyncDelayedTask(myUltraWarps.mUW, (Runnable)new myUltraWarps$1((CommandSender)player, "remove interworldly teleportation delay", new Object[0]), 2);
            myUltraWarps.debug("ensuring safe interworldly teleportation...");
        }
        Entity vehicle = player.getVehicle();
        myUltraWarps.debug("Teleporting " + player.getName() + "...");
        boolean with_vehicle = false;
        if (player.isInsideVehicle() && (vehicle.getType() == EntityType.HORSE || vehicle.getType() == EntityType.PIG)) {
            with_vehicle = true;
        } else if (player.isInsideVehicle() && vehicle.getType() == EntityType.MINECART) {
            myUltraWarps.debug("Checking if the minecart should teleport with " + player.getName() + "...");
            if (to.getBlock().getType() == Material.ACTIVATOR_RAIL || to.getBlock().getType() == Material.POWERED_RAIL || to.getBlock().getType() == Material.DETECTOR_RAIL || to.getBlock().getType() == Material.RAILS) {
                with_vehicle = true;
                myUltraWarps.debug(String.valueOf(player.getName()) + " is teleporting in a minecart to a rail, so I'm teleporting the cart with them.");
            } else if (to.getBlock().getType() == Material.PORTAL) {
                myUltraWarps.debug(String.valueOf(player.getName()) + "'s minecart is going through a portal. Let me see if there's a rail in front of the minecart at the other end....");
                Vector velocity = player.getVehicle().getVelocity();
                Location rail_check = new Location(to.getWorld(), to.getX() + velocity.getX() / Math.abs(velocity.getX()), to.getY(), to.getZ() + velocity.getZ() / Math.abs(velocity.getZ()), to.getYaw(), to.getPitch());
                if (rail_check.getBlock().getType() == Material.ACTIVATOR_RAIL || rail_check.getBlock().getType() == Material.POWERED_RAIL || rail_check.getBlock().getType() == Material.DETECTOR_RAIL || rail_check.getBlock().getType() == Material.RAILS) {
                    with_vehicle = true;
                    myUltraWarps.debug("Yep. There's a rail at the other end of the portal. I'll teleport the minecart with " + player.getName() + ".");
                } else {
                    myUltraWarps.debug(String.valueOf(player.getName()) + "'s destination is not a rail, so I will not teleport their minecart with them.");
                }
            } else {
                myUltraWarps.debug(String.valueOf(player.getName()) + "'s destination is not a rail, so I will not teleport their minecart with them.");
            }
        } else if (player.isInsideVehicle()) {
            myUltraWarps.debug(String.valueOf(player.getName()) + " is not in a proper vehicle for teleportation. Ejecting player from their vehicle...");
        }
        if (with_vehicle && !player.getWorld().equals((Object)to.getWorld())) {
            myUltraWarps.debug(String.valueOf(player.getName()) + " tried to teleport between worlds with a vehicle, but I told them they couldn't.");
            player.sendMessage((Object)ChatColor.RED + "Sorry, but you can't teleport between worlds with vehicles right now. Don't blame REALDrummer; it's a bug with CraftBukkit and he's working with them to get it fixed as soon as possible.");
            return false;
        }
        if (player.isInsideVehicle() && !player.leaveVehicle()) {
            myUltraWarps.debug((Object)ChatColor.RED + "I couldn't get " + player.getName() + " to leave their vehicle.");
            return false;
        }
        if (!(with_vehicle || player.teleport(to))) {
            myUltraWarps.debug((Object)ChatColor.RED + "I couldn't teleport " + player.getName() + " properly.");
            return false;
        }
        if (with_vehicle && !vehicle.teleport(to)) {
            myUltraWarps.debug((Object)ChatColor.RED + "I couldn't teleport " + player.getName() + "'s vehicle with them properly.");
            return false;
        }
        if (with_vehicle && !vehicle.setPassenger((Entity)player)) {
            myUltraWarps.debug((Object)ChatColor.RED + "I couldn't get " + player.getName() + " back in their vehicle after teleporting them both.");
            return false;
        }
        return true;
    }
}


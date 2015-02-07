/*
 * Decompiled with CFR 0_95.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Location
 *  org.bukkit.Server
 *  org.bukkit.World
 *  org.bukkit.block.Block
 *  org.bukkit.command.ConsoleCommandSender
 */
package REALDrummer;

import REALDrummer.myUltraWarps;
import java.io.File;
import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.ConsoleCommandSender;

public class UltraSwitch {
    private static final Object[][] SWITCH_TYPES = new Object[][]{{63, "sign"}, {68, "sign"}, {69, "lever"}, {70, "pressure plate"}, {72, "pressure plate"}, {77, "button"}, {143, "button"}};
    public Block block;
    public String warp_name;
    public String warp_owner;
    public String switch_type;
    public double cost;
    public Location location;
    public int cooldown_time;
    public int max_uses;
    public int x;
    public int y;
    public int z;
    public boolean global_cooldown;
    public World world;
    public String[] exempted_players;

    public UltraSwitch(String warp_name, String warp_owner, Block block, int cooldown_time, int max_uses, boolean global_cooldown, double cost, String[] exempted_players) {
        this.warp_name = warp_name;
        this.warp_owner = warp_owner;
        this.block = block;
        this.switch_type = UltraSwitch.getSwitchType(block);
        if (this.switch_type == null) {
            myUltraWarps.console.sendMessage((Object)ChatColor.DARK_RED + "I couldn't find the switch type for this block!");
            myUltraWarps.console.sendMessage((Object)ChatColor.WHITE + block.toString());
        }
        this.cooldown_time = cooldown_time;
        this.max_uses = max_uses;
        this.global_cooldown = global_cooldown;
        this.cost = cost;
        this.exempted_players = exempted_players;
        this.location = block.getLocation();
        this.x = this.location.getBlockX();
        this.y = this.location.getBlockY();
        this.z = this.location.getBlockZ();
        this.world = this.location.getWorld();
    }

    public UltraSwitch(String save_line) {
        if (save_line.substring(4, 5).equals("b")) {
            this.switch_type = "button";
        } else if (save_line.substring(4, 5).equals("p")) {
            this.switch_type = "pressure plate";
        } else if (save_line.substring(4, 5).equals("l")) {
            this.switch_type = "lever";
        } else if (save_line.substring(4, 5).equals("s")) {
            this.switch_type = "sign";
        }
        String[] temp = save_line.substring(save_line.indexOf(40) + 1, save_line.indexOf(41)).split(", ");
        try {
            this.x = (int)Double.parseDouble(temp[0]);
            this.y = (int)Double.parseDouble(temp[1]);
            this.z = (int)Double.parseDouble(temp[2]);
        }
        catch (NumberFormatException exception) {
            myUltraWarps.console.sendMessage((Object)ChatColor.DARK_RED + "I got an error while trying to read the coordinates of this switch!");
            myUltraWarps.console.sendMessage((Object)ChatColor.DARK_RED + "save line: \"" + (Object)ChatColor.WHITE + save_line + (Object)ChatColor.DARK_RED + "\"");
            myUltraWarps.console.sendMessage((Object)ChatColor.DARK_RED + "I read the coordiantes as " + (Object)ChatColor.WHITE + "(" + temp[0] + ", " + temp[1] + ", " + temp[2] + ").");
            exception.printStackTrace();
            return;
        }
        this.world = myUltraWarps.server.getWorld(save_line.split("\"")[1]);
        if (this.world == null) {
            myUltraWarps.console.sendMessage((Object)ChatColor.DARK_RED + "I couldn't find a world called \"" + save_line.split("\"")[1] + "\"!");
            myUltraWarps.console.sendMessage((Object)ChatColor.DARK_RED + "save line: \"" + (Object)ChatColor.WHITE + save_line + (Object)ChatColor.DARK_RED + "\"");
            return;
        }
        this.location = new Location(this.world, (double)this.x, (double)this.y, (double)this.z);
        this.block = this.location.getBlock();
        temp = save_line.split("'s warp \"");
        this.warp_owner = temp[0].substring(save_line.indexOf(" is linked to ") + 14);
        if (save_line.contains((CharSequence)"\". It can be used ")) {
            temp = temp[1].split("\". It can be used ");
            this.warp_name = temp[0];
            temp = temp[1].split(" ");
            try {
                this.max_uses = Integer.parseInt(temp[0]);
            }
            catch (NumberFormatException exception) {
                myUltraWarps.console.sendMessage((Object)ChatColor.DARK_RED + "I got an error while trying to read the maximum number of uses for this switch!");
                myUltraWarps.console.sendMessage((Object)ChatColor.DARK_RED + "save line: \"" + (Object)ChatColor.WHITE + save_line + (Object)ChatColor.DARK_RED + "\"");
                myUltraWarps.console.sendMessage((Object)ChatColor.DARK_RED + "I read the max uses as " + (Object)ChatColor.WHITE + temp[0] + (Object)ChatColor.DARK_RED + ".");
                exception.printStackTrace();
                return;
            }
            if (temp[3].equals("that")) {
                this.global_cooldown = false;
            } else if (temp[3].equals("everyone")) {
                this.global_cooldown = true;
            } else {
                myUltraWarps.console.sendMessage((Object)ChatColor.DARK_RED + "I got an error while trying to read whether or not the cooldown on this switch was global!");
                myUltraWarps.console.sendMessage((Object)ChatColor.DARK_RED + "save line: \"" + (Object)ChatColor.WHITE + save_line + (Object)ChatColor.DARK_RED + "\"");
                myUltraWarps.console.sendMessage((Object)ChatColor.DARK_RED + "I read the temp[3] as " + (Object)ChatColor.WHITE + temp[3] + (Object)ChatColor.DARK_RED + ".");
                return;
            }
            this.cooldown_time = myUltraWarps.readTime(save_line.substring(save_line.indexOf(" has to wait ") + 13, save_line.indexOf("before using it again.")));
        } else {
            this.warp_name = temp[1].substring(0, temp[1].length() - 2);
            this.max_uses = -1;
            this.global_cooldown = false;
            this.cooldown_time = 0;
        }
    }

    public static String getSwitchType(Block block) {
        for (Object[] type : SWITCH_TYPES) {
            if (((Integer)type[0]).intValue() != block.getTypeId()) continue;
            return (String)type[1];
        }
        return null;
    }

    public static UltraSwitch getSwitch(Block block) {
        for (UltraSwitch _switch : myUltraWarps.switches) {
            if (!_switch.location.equals((Object)block.getLocation())) continue;
            return _switch;
        }
        return null;
    }

    public String toString() {
        String save_line = "The " + this.switch_type + " at (" + this.x + ", " + this.y + ", " + this.z + ") in \"" + this.world.getWorldFolder().getName() + "\" is linked to " + this.warp_owner + "'s warp \"" + this.warp_name + "\".";
        if (this.cooldown_time > 0) {
            save_line = this.max_uses != 1 ? String.valueOf(save_line) + " It can be used " + this.max_uses + " times before " : String.valueOf(save_line) + " It can be used once before ";
            save_line = this.global_cooldown ? String.valueOf(save_line) + "everyone has to wait " : String.valueOf(save_line) + "that player has to wait ";
            save_line = String.valueOf(save_line) + myUltraWarps.writeTime(this.cooldown_time, false) + " before using it again.";
        }
        return save_line;
    }
}


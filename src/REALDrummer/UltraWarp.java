/*
 * Decompiled with CFR 0_95.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Location
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 */
package REALDrummer;

import REALDrummer.myUltraWarps;
import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UltraWarp {
    public String owner;
    public String name;
    public String warp_message;
    public String no_warp_message;
    public String[] listed_users;
    public boolean listed;
    public boolean restricted;
    public Location location;

    public UltraWarp(String owner, String name, boolean listed, boolean restricted, String warp_message, String no_warp_message, String[] listed_users, Location location) {
        this.owner = owner;
        this.name = name;
        this.listed = listed;
        this.restricted = restricted;
        this.warp_message = warp_message;
        this.no_warp_message = no_warp_message;
        this.listed_users = listed_users;
        this.location = location;
        if (listed_users == null) {
            listed_users = new String[]{};
        }
    }

    public UltraWarp(String save_line) {
        try {
            String temp2;
            this.owner = save_line.split("'s warp \"")[0];
            this.name = save_line.substring(this.owner.length() + 9).split("\" is ")[0];
            String[] temp = save_line.split("listed, ");
            this.listed = !temp[0].endsWith("un");
            this.restricted = !temp[1].startsWith("un");
            this.location = myUltraWarps.readLocation(temp[1].substring(temp[1].indexOf(40), temp[1].indexOf(temp[1].contains((CharSequence)"\". P") ? "\". P" : "). P") + 1));
            if (this.location == null) {
                myUltraWarps.tellOps((Object)ChatColor.DARK_RED + "I had a problem reading the location of this warp; I read \"" + (Object)ChatColor.WHITE + temp[1].substring(temp[1].indexOf(40), temp[1].indexOf(temp[1].contains((CharSequence)"\". P") ? "\". P" : "). P") + 1) + "\" as the location of the warp.", true, new String[0]);
            }
            temp = temp[1].split(", ");
            boolean warp_message_first = true;
            if (temp[3].split(temp[3].contains((CharSequence)"\". ") ? "\". " : "\\). ")[1].startsWith("Pro")) {
                warp_message_first = false;
            } else if (!temp[3].substring(1).split(temp[3].contains((CharSequence)"\". ") ? "\". " : "\\). ")[1].startsWith("Per")) {
                myUltraWarps.tellOps((Object)ChatColor.DARK_RED + "I had trouble reading the beginning of the second sentence for this warp (\"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode(save_line) + (Object)ChatColor.DARK_RED + "\"; I read \"" + (Object)ChatColor.WHITE + temp[1].substring(1).split(temp[3].contains((CharSequence)"\". ") ? "\". " : "\\). ")[1] + (Object)ChatColor.DARK_RED + "\").", true, new String[0]);
            }
            temp = save_line.split("\" while ");
            if (warp_message_first) {
                try {
                    this.warp_message = temp[0].split(" users see \"")[1];
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    this.warp_message = "";
                }
                this.no_warp_message = temp[1].substring(temp[1].indexOf(34) + 1, temp[1].length() - 2);
                temp2 = temp[1].substring(0, temp[1].length() - this.no_warp_message.length() - 3);
            } else {
                this.warp_message = temp[1].substring(temp[1].indexOf(34) + 1, temp[1].length() - 2);
                try {
                    this.no_warp_message = temp[0].split(" users see \"")[1];
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    this.no_warp_message = "";
                }
                temp2 = temp[1].substring(0, temp[1].length() - this.warp_message.length() - 3);
            }
            if (temp2.startsWith("other users may see")) {
                this.listed_users = new String[0];
            } else if (temp2.endsWith(" sees ")) {
                this.listed_users = new String[1];
                this.listed_users[0] = temp2.substring(0, temp2.length() - 6);
            } else if (temp2.endsWith(" both see ")) {
                this.listed_users = temp2.substring(0, temp2.length() - 10).split(" and ");
            } else if (temp2.endsWith(" all see ")) {
                temp2 = temp2.substring(0, temp2.length() - 9);
                this.listed_users = temp2.split(", ");
                this.listed_users[this.listed_users.length - 1] = this.listed_users[this.listed_users.length - 1].substring(4);
            } else {
                myUltraWarps.tellOps((Object)ChatColor.DARK_RED + "I got a problem reading the listed users on this warp\"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode(save_line) + "\"!", true, new String[0]);
            }
        }
        catch (Exception e) {
            myUltraWarps.processException((Object)ChatColor.DARK_RED + "There was an issue reading this warp save line: \"" + (Object)ChatColor.WHITE + save_line + (Object)ChatColor.DARK_RED + "\"", e);
        }
    }

    public UltraWarp(String warp_message, Location location) {
        this("Sum1", "warp", false, false, warp_message, "No", null, location);
    }

    public String getColoredName() {
        if (this.listed && !this.restricted) {
            return (Object)ChatColor.WHITE + this.name;
        }
        if (this.listed) {
            return (Object)ChatColor.AQUA + this.name;
        }
        if (!this.listed && this.restricted) {
            return (Object)ChatColor.DARK_GRAY + this.name;
        }
        return (Object)ChatColor.GRAY + this.name;
    }

    public String getColoredOwner() {
        if (this.listed && !this.restricted) {
            return (Object)ChatColor.WHITE + this.owner;
        }
        if (this.listed) {
            return (Object)ChatColor.AQUA + this.owner;
        }
        if (!this.listed && this.restricted) {
            return (Object)ChatColor.DARK_GRAY + this.owner;
        }
        return (Object)ChatColor.GRAY + this.owner;
    }

    public String getType() {
        if (this.listed) {
            if (!this.restricted) {
                return "open";
            }
            return "advertised";
        }
        if (!this.restricted) {
            return "secret";
        }
        return "private";
    }

    public String getColoredType() {
        if (this.listed) {
            if (!this.restricted) {
                return (Object)ChatColor.WHITE + "open";
            }
            return (Object)ChatColor.AQUA + "advertised";
        }
        if (!this.restricted) {
            return (Object)ChatColor.GRAY + "secret";
        }
        return (Object)ChatColor.DARK_GRAY + "private";
    }

    public String getQualifiedName() {
        return String.valueOf(this.owner) + "'s " + this.name;
    }

    public static /* varargs */ UltraWarp getWarp(int extra_param, CommandSender sender, String ... parameters) {
        int index = UltraWarp.getWarpIndex(extra_param, sender, parameters);
        if (index != -1) {
            try {
                return myUltraWarps.warps.get(index);
            }
            catch (ArrayIndexOutOfBoundsException var4_4) {
                // empty catch block
            }
        }
        return null;
    }

    public static /* varargs */ int getWarpIndex(int extra_param, CommandSender sender, String ... parameters) {
        try {
            myUltraWarps.UWindex = -1;
            String qname = UltraWarp.readQualifiedName(extra_param, sender, parameters);
            myUltraWarps.UWowner = qname.contains((CharSequence)"'s") ? qname.substring(0, qname.indexOf(32) - 2) : null;
            myUltraWarps.UWname = qname.contains((CharSequence)" ") ? qname.substring(qname.indexOf(32) + 1) : qname;
            Player player = null;
            if (sender instanceof Player) {
                player = (Player)sender;
            }
            ArrayList<UltraWarp> possible_warps = new ArrayList<UltraWarp>();
            ArrayList<Integer> possible_indexes = new ArrayList<Integer>();
            for (int i = 0; i < myUltraWarps.warps.size(); ++i) {
                if (myUltraWarps.UWowner != null && (player == null || !myUltraWarps.UWowner.equals(player.getName())) && !myUltraWarps.warps.get((int)i).owner.equals(myUltraWarps.UWowner) || !myUltraWarps.warps.get((int)i).name.toLowerCase().startsWith(myUltraWarps.UWname.toLowerCase())) continue;
                possible_warps.add(myUltraWarps.warps.get(i));
                possible_indexes.add(i);
            }
            int[] priorities = new int[possible_warps.size()];
            for (int i2 = 0; i2 < possible_warps.size(); ++i2) {
                boolean user_is_listed = false;
                if (player == null) {
                    user_is_listed = true;
                } else {
                    for (String listed_user : ((UltraWarp)possible_warps.get((int)i2)).listed_users) {
                        if (!listed_user.equals(player.getName())) continue;
                        user_is_listed = true;
                    }
                }
                int priority = player != null && myUltraWarps.UWowner != null && myUltraWarps.UWowner.equals(((UltraWarp)possible_warps.get((int)i2)).owner) ? 3 : (((UltraWarp)possible_warps.get((int)i2)).listed ? (!((UltraWarp)possible_warps.get((int)i2)).restricted || !user_is_listed || ((UltraWarp)possible_warps.get((int)i2)).restricted && user_is_listed ? 6 : 12) : (!((UltraWarp)possible_warps.get((int)i2)).restricted && !user_is_listed || ((UltraWarp)possible_warps.get((int)i2)).restricted && user_is_listed ? 9 : 15));
                if (((UltraWarp)possible_warps.get((int)i2)).name.equalsIgnoreCase(myUltraWarps.UWname)) {
                    --priority;
                }
                if (((UltraWarp)possible_warps.get((int)i2)).name.equals(myUltraWarps.UWname)) {
                    --priority;
                }
                priorities[i2] = priority;
            }
            myUltraWarps.UWindex = -1;
            if (possible_warps.size() > 0) {
                myUltraWarps.UWindex = (Integer)possible_indexes.get(0);
                if (possible_warps.size() > 1) {
                    int first_priority_index = 0;
                    for (int i3 = 1; i3 < priorities.length; ++i3) {
                        if (priorities[i3] >= priorities[first_priority_index]) continue;
                        myUltraWarps.UWindex = (Integer)possible_indexes.get(i3);
                        first_priority_index = i3;
                    }
                }
            }
            return myUltraWarps.UWindex;
        }
        catch (Exception e) {
            myUltraWarps.processException("There was a problem finding the index of a warp!", e);
            return -1;
        }
    }

    public static /* varargs */ String readQualifiedName(int extra_param, CommandSender sender, String ... parameters) {
        String owner;
        String name;
        Player player = null;
        if (sender instanceof Player) {
            player = (Player)sender;
        }
        if (parameters[extra_param].toLowerCase().endsWith("'s")) {
            name = parameters[extra_param + 1];
            owner = parameters[extra_param].substring(0, parameters[extra_param].length() - 2);
            ++extra_param;
        } else {
            owner = player != null ? player.getName() : null;
            name = parameters[extra_param];
        }
        if (!(owner == null || player != null && owner.equals(player.getName()))) {
            owner = myUltraWarps.autoCompleteName(owner);
        }
        return owner != null ? String.valueOf(owner) + "'s " + name : name;
    }

    public boolean equals(Object object) {
        if (object instanceof UltraWarp && ((UltraWarp)object).name.equals(this.name) && ((UltraWarp)object).owner.equals(this.owner)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.valueOf(this.owner) + "'s warp \"" + this.name + "\" is " + (this.listed ? "a " : "an un") + "listed, " + (this.restricted ? "" : "un") + "restricted warp at " + myUltraWarps.writeLocation(this.location, false, true) + ". " + (this.restricted ? "Prohibited" : "Permitted") + " users see \"" + (this.restricted ? this.no_warp_message : this.warp_message) + "\" while " + (this.listed_users == null || this.listed_users.length == 0 ? "other users may see \"" : (this.listed_users.length == 1 ? new StringBuilder(String.valueOf(this.listed_users[0])).append(" sees \"").toString() : (this.listed_users.length == 2 ? new StringBuilder(String.valueOf(this.listed_users[0])).append(" and ").append(this.listed_users[1]).append(" both see \"").toString() : new StringBuilder(String.valueOf(myUltraWarps.writeArray(this.listed_users, new String[0]))).append(" all see \"").toString()))) + (this.restricted ? this.warp_message : this.no_warp_message) + "\".";
    }
}


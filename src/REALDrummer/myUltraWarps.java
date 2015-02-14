/*
 * Decompiled with CFR 0_95.
 * 
 * Could not load the following classes:
 *  REALDrummer.myScribe
 *  net.milkbowl.vault.economy.Economy
 *  net.milkbowl.vault.permission.Permission
 *  org.bukkit.ChatColor
 *  org.bukkit.Chunk
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.OfflinePlayer
 *  org.bukkit.Server
 *  org.bukkit.World
 *  org.bukkit.block.Block
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandSender
 *  org.bukkit.command.ConsoleCommandSender
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.Action
 *  org.bukkit.event.block.BlockBreakEvent
 *  org.bukkit.event.entity.EntityDamageEvent
 *  org.bukkit.event.entity.EntityExplodeEvent
 *  org.bukkit.event.entity.EntityTargetEvent
 *  org.bukkit.event.entity.PlayerDeathEvent
 *  org.bukkit.event.player.AsyncPlayerChatEvent
 *  org.bukkit.event.player.PlayerInteractEvent
 *  org.bukkit.event.player.PlayerJoinEvent
 *  org.bukkit.event.player.PlayerRespawnEvent
 *  org.bukkit.event.world.ChunkLoadEvent
 *  org.bukkit.event.world.ChunkUnloadEvent
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.PluginDescriptionFile
 *  org.bukkit.plugin.PluginManager
 *  org.bukkit.plugin.RegisteredServiceProvider
 *  org.bukkit.plugin.ServicesManager
 *  org.bukkit.plugin.java.JavaPlugin
 *  org.bukkit.scheduler.BukkitScheduler
 *  org.bukkit.util.ChatPaginator
 *  org.bukkit.util.ChatPaginator$ChatPage
 */
package REALDrummer;

import REALDrummer.SettingsSet;
import REALDrummer.UltraSwitch;
import REALDrummer.UltraWarp;
//import REALDrummer.myScribe;
import REALDrummer.myUltraWarps$1;
import com.evilmidget38.UUIDFetcher;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.ChatPaginator;

/*
 * Failed to analyse overrides
 */
public class myUltraWarps
extends JavaPlugin
implements Listener {
    public static Plugin mUW;
    public static Plugin Vault;
    public static Server server;
    public static ConsoleCommandSender console;
    public static final ChatColor COLOR;
    public static final Short[] NON_SOLID_BLOCK_IDS;
    private static final String[] COLOR_COLOR_CODE_CHARS;
    private static final String[] FORMATTING_COLOR_CODE_CHARS;
    public static ArrayList<UltraWarp> warps;
    public static ArrayList<UltraSwitch> switches;
    public static HashMap<String, SettingsSet> settings;
    public static String UWname;
    public static String UWowner;
    public static int UWindex;
    private ArrayList<Object[]> help_pages = new ArrayList();
    public static boolean use_group_settings;
    public static boolean autosave_warps;
    public static boolean autosave_switches;
    public static boolean autosave_config;
    public static boolean auto_update;
    public static boolean delay_teleportation_between_worlds;
    private static ArrayList<String> debuggers;
    private boolean parsing_warp_message = false;
    private boolean parsing_no_warp_message = false;
    private static HashMap<World, String> spawn_messages_by_world;
    private static HashMap<String, Boolean> full_list_organization_by_user;
    private static HashMap<String, Location> spawning_players;
    private static HashMap<String, Object[]> teleporting_players;
    public static HashMap<String, ArrayList<String>> info_messages_for_players;
    public static HashMap<String, ArrayList<String>> to_teleport_requests;
    public static HashMap<String, ArrayList<String>> from_teleport_requests;
    public static HashMap<String, ArrayList<String>> blocked_players;
    public static HashMap<String, ArrayList<String>> trusted_players;
    private static HashMap<String, ArrayList<UltraWarp>> warp_histories;
    private static HashMap<String, ArrayList<Location>> death_histories;
    private static HashMap<String, Integer> last_warp_indexes;
    private static HashMap<String, Integer> last_warp_to_death_indexes;
    public static HashMap<String, Long> cooling_down_players;
    private static Permission permissions;
    private static Economy economy;
    public HashMap<String, UUID> UUIDs = new HashMap();
    public static ArrayList<String> players;

    static {
        Vault = null;
        COLOR = ChatColor.GREEN;
        NON_SOLID_BLOCK_IDS = new Short[]{0, 6, 27, 28, 30, 31, 32, 37, 38, 39, 40, 50, 51, 55, 59, 63, 64, 65, 66, 68, 69, 70, 71, 72, 75, 76, 77, 78, 83, 90, 93, 94, 104, 105, 115, 119, 131, 132, 140, 141, 142, 142, 144, 147, 148, 149, 150, 157, 171, 175};
        COLOR_COLOR_CODE_CHARS = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        FORMATTING_COLOR_CODE_CHARS = new String[]{"k", "l", "m", "n", "o", "r"};
        warps = new ArrayList();
        switches = new ArrayList();
        settings = new HashMap();
        use_group_settings = true;
        autosave_warps = false;
        autosave_switches = false;
        autosave_config = true;
        auto_update = true;
        delay_teleportation_between_worlds = false;
        debuggers = new ArrayList();
        spawn_messages_by_world = new HashMap();
        full_list_organization_by_user = new HashMap();
        spawning_players = new HashMap();
        teleporting_players = new HashMap();
        info_messages_for_players = new HashMap();
        to_teleport_requests = new HashMap();
        from_teleport_requests = new HashMap();
        blocked_players = new HashMap();
        trusted_players = new HashMap();
        warp_histories = new HashMap();
        death_histories = new HashMap();
        last_warp_indexes = new HashMap();
        last_warp_to_death_indexes = new HashMap();
        cooling_down_players = new HashMap();
        permissions = null;
        economy = null;
        players = new ArrayList();
    }

    public void onEnable() {
        try {
            mUW = this;
            server = this.getServer();
            console = server.getConsoleSender();
            server.getPluginManager().registerEvents((Listener)this, (Plugin)this);
            for (Player player : server.getOnlinePlayers()) {
                warp_histories.put(player.getName(), new ArrayList());
            }
            this.loadTheConfig((CommandSender)console);
            this.loadTheWarps((CommandSender)console);
            this.loadTheSwitches((CommandSender)console);
            this.loadTheUniqueIDs((CommandSender)console);
            this.loadTheTemporaryData();
            if (auto_update) {
                this.checkForUpdates((CommandSender)console);
            }
            debuggers.add("console");
            int i = 0;
            while (i < 43) {
                Object[] help_line = new Object[4];
                if (i == 0) {
                    help_line[0] = "&a&o/create (\"warp\") [warp name] (settings) &fcreates a warp called \"[warp name]\". You can also use &a&o/make warp &for &a&o/set warp.&f\nFor the \"(settings)&f\" parameter, you can put in one or more of these settings to customize the warp:\n&a&otype:[type] &fallows you to decide whether the warp private (restricted and unlisted), secret (unlisted but unrestricted), advertised (listed but restricted), or open (listed and unrestricted).";
                    help_line[1] = "myultrawarps.create";
                    help_line[2] = true;
                    help_line[3] = 10;
                } else if (i == 1) {
                    help_line[0] = "&a&ogiveto:[player] &fallows you to give the warp to another player.";
                    help_line[1] = "myultrawarps.create";
                    help_line[2] = true;
                    help_line[3] = 1;
                } else if (i == 2) {
                    help_line[0] = "&f&oYou &fcan give warps to other players even if they already have a warp with the same name.";
                    help_line[1] = "myultrawarps.create.other";
                    help_line[2] = false;
                    help_line[3] = 2;
                } else if (i == 3) {
                    help_line[0] = "&a&owarp:[message] &fallows you to customize the message that appears when someone warps to your warp. The message can be as long as you like and may have spaces and you can use color codes! I love colors.\n&a&onowarp:[message] &fallows you to customize the message that appears when someone tries to warp to your warp, but is not allowed to.";
                    help_line[1] = "myultrawarps.create";
                    help_line[2] = true;
                    help_line[3] = 7;
                } else if (i == 4) {
                    help_line[0] = "&a&olist:[player1],[player2] &fallows you to add players to the warp's list. The warp's list works both as a blacklist for unrestricted warps and as a whitelist for restricted warps. You may list as many people as you want at once by separating usernames with commas and no spaces.\n&a&ounlist:[player1],[player2] &fallows you to remove people from the warp's list.";
                    help_line[1] = "myultrawarps.create";
                    help_line[2] = true;
                    help_line[3] = 7;
                } else if (i == 5) {
                    help_line[0] = "&a&o/warp (owner\"'s\") [warp name] &fwarps you to the specified warp.";
                    help_line[1] = "myultrawarps.warptowarp";
                    help_line[2] = true;
                    help_line[3] = 2;
                } else if (i == 6) {
                    help_line[0] = "&f&oYou &fcan warp to other people's warps, too--even restricted ones.";
                    help_line[1] = "myultrawarps.warptowarp.other";
                    help_line[2] = false;
                    help_line[3] = 2;
                } else if (i == 7) {
                    help_line[0] = "&a&o/warp (world) [x] [y] [z] (world) &fwarps you to the specified coordinates in (world). You do not need to type the world name both before and after the coordinates; one or the other will do. If (world) is left blank, you will warp to those coordinates in your current world.";
                    help_line[1] = "myultrawarps.warptocoord";
                    help_line[2] = true;
                    help_line[3] = 5;
                } else if (i == 8) {
                    help_line[0] = "&a&o/change (\"warp\") (owner\"'s\") [warp name] [settings] &fchanges the settings of an existing warp. The settings are the same as the ones for &a&o/create&f, but you can also use &a&oname:[new name] &fto change the name of a warp. You can also use &a&o/modify&f.";
                    help_line[1] = "myultrawarps.change";
                    help_line[2] = true;
                    help_line[3] = 4;
                } else if (i == 9) {
                    help_line[0] = "&f&oYou &fcan also change other players' warps.";
                    help_line[1] = "myultrawarps.change.other";
                    help_line[2] = false;
                    help_line[3] = 1;
                } else if (i == 10) {
                    help_line[0] = "&a&o/move (\"warp\") (owner\"'s\") [warp name] &fmoves the warp to your current location. You can also use &a&o/translate warp&f.";
                    help_line[1] = "myultrawarps.move";
                    help_line[2] = true;
                    help_line[3] = 2;
                } else if (i == 11) {
                    help_line[0] = "&f&oYou &fcan also move other players' warps.";
                    help_line[1] = "myultrawarps.move.other";
                    help_line[2] = false;
                    help_line[3] = 1;
                } else if (i == 12) {
                    help_line[0] = "&a&o/delete (\"warp\") (owner\"'s\") [warp name] &fdeletes the specified warp. You can also use &a&o/remove warp&f.";
                    help_line[1] = "myultrawarps.delete";
                    help_line[2] = true;
                    help_line[3] = 2;
                } else if (i == 13) {
                    help_line[0] = "&f&oYou &fcan also delete other players' warps.";
                    help_line[1] = "myultrawarps.move.other";
                    help_line[2] = false;
                    help_line[3] = 1;
                } else if (i == 14) {
                    help_line[0] = "&a&o/warp(\"s\") list &fdisplays all of your warps and all listed warps with color coding. White warps are open, red warps are advertised, gray warps are secret, and dark red warps are private.";
                    help_line[1] = "myultrawarps.list";
                    help_line[2] = true;
                    help_line[3] = 4;
                } else if (i == 15) {
                    help_line[0] = "&a&o/full warp list (\"page\" [#]) (\"by owner\"/\"by name\") (\"owner:\"[owner]) (\"type:\"[type]) &flists all of the warps for the entire server whether they're listed or not. You can use the parameters above to go page by page, organize the list by owner or by name, or create filters on your search. You can also use &a&o/entire warp list &for &a&o/complete warp list &fand you can put an \"s\" at the end of \"warp\" if you like.";
                    help_line[1] = "myultrawarps.list.full";
                    help_line[2] = false;
                    help_line[3] = 7;
                } else if (i == 16) {
                    help_line[0] = "&a&o/warp info (owner\"'s\") [warp name] &fdisplays all the information about the specified warp.";
                    help_line[1] = "myultrawarps.warpinfo";
                    help_line[2] = true;
                    help_line[3] = 2;
                } else if (i == 17) {
                    help_line[0] = "&f&oYou &fcan also see information on other players' warps.";
                    help_line[1] = "myultrawarps.warpinfo.other";
                    help_line[2] = false;
                    help_line[3] = 1;
                } else if (i == 18) {
                    help_line[0] = "&a&o/back &fwarps you back to the last place you warped. You can also use &a&o/return &for &a&o/last&f.";
                    help_line[1] = "myultrawarps.back";
                    help_line[2] = true;
                    help_line[3] = 2;
                } else if (i == 19) {
                    help_line[0] = "&a&o/set home &fcreates a special unlisted, restricted warp called \"home\" with special default messages.";
                    help_line[1] = "myultrawarps.sethome";
                    help_line[2] = true;
                    help_line[3] = 2;
                } else if (i == 20) {
                    help_line[0] = "&f&oYou &fcan also add the parameter (owner\"'s\") to set other players' home warps.";
                    help_line[1] = "myultrawarps.sethome.other";
                    help_line[2] = false;
                    help_line[3] = 2;
                } else if (i == 21) {
                    help_line[0] = "&a&o/home &fwarps you to your home.";
                    help_line[1] = "myultrawarps.home";
                    help_line[2] = true;
                    help_line[3] = 1;
                } else if (i == 22) {
                    help_line[0] = "&f&oYou &fcan also add the parameter (owner\"'s\") to warp to other players' homes.";
                    help_line[1] = "myultrawarps.home.other";
                    help_line[2] = false;
                    help_line[3] = 2;
                } else if (i == 23) {
                    help_line[0] = "&a&o/set spawn &fsets the spawn point for the world you're in.";
                    help_line[1] = "myultrawarps.admin";
                    help_line[2] = false;
                    help_line[3] = 1;
                } else if (i == 24) {
                    help_line[0] = "&a&o/spawn &fteleports you to your world's spawn point.";
                    help_line[1] = "myultrawarps.spawn";
                    help_line[2] = true;
                    help_line[3] = 1;
                } else if (i == 25) {
                    help_line[0] = "&a&o/jump &fteleports you to the spot you're pointing at.";
                    help_line[1] = "myultrawarps.jump";
                    help_line[2] = true;
                    help_line[3] = 1;
                } else if (i == 26) {
                    help_line[0] = "&a&o/top &fteleports you to the highest solid block directly above or below you.";
                    help_line[1] = "myultrawarps.top";
                    help_line[2] = true;
                    help_line[3] = 2;
                } else if (i == 27) {
                    help_line[0] = "&a&o/link (owner\"'s\") [warp name] (settings) &flinks a warp to a button, lever, or pressure plate that you are pointing at. Once a warp is linked to one of these switches, right-clicking that button, lever, or sign or stepping on the pressure plate will warp you to the warp that the switch is linked to.";
                    help_line[1] = "myultrawarps.link";
                    help_line[2] = true;
                    help_line[3] = 5;
                } else if (i == 28) {
                    help_line[0] = "&f&oYou &fcan also link other players' warps to your switches.";
                    help_line[1] = "myultrawarps.link.other";
                    help_line[2] = false;
                    help_line[3] = 1;
                } else if (i == 29) {
                    help_line[0] = "&a&o/unlink (owner\"'s\") (warp name) &funlinks a warp from a button, pressure plate, sign, or lever that you are pointing at or unlinks all switches from the specified warp if a warp is specified.";
                    help_line[1] = "myultrawarps.unlink";
                    help_line[2] = true;
                    help_line[3] = 4;
                } else if (i == 30) {
                    help_line[0] = "&f&oYou &fcan also unlink other players' switches.";
                    help_line[1] = "myultrawarps.unlink.other";
                    help_line[2] = false;
                    help_line[3] = 1;
                } else if (i == 31) {
                    help_line[0] = "&a&o/switch(\"es\") list &flists all your switches by warp that they're linked to and how many switches are linked to each warp.";
                    help_line[1] = "myultrawarps.list";
                    help_line[2] = true;
                    help_line[3] = 2;
                } else if (i == 32) {
                    help_line[0] = "&a&o/switch info (owner\"'s\") (warp name) &fdisplays the information on the switch that you are pointing at or displays the information on all the switches that are linked to the specified warp if a warp is specified.";
                    help_line[1] = "myultrawarps.switchinfo";
                    help_line[2] = true;
                    help_line[3] = 4;
                } else if (i == 33) {
                    help_line[0] = "&f&oYou &fcan also see information on other players' switches.";
                    help_line[1] = "myultrawarps.switchinfo.other";
                    help_line[2] = false;
                    help_line[3] = 1;
                } else if (i == 34) {
                    help_line[0] = "&a&o/to [player] &fteleports you to the designated player. If the admins configure it so that you have to ask the person if you can teleport to them before doing so, &a&o/to &fwill ask them if it's okay. The target player can then just type their answer into the chat box. It's that easy. You can also use &a&o/find&f.";
                    help_line[1] = "myultrawarps.to";
                    help_line[2] = true;
                    help_line[3] = 5;
                } else if (i == 35) {
                    help_line[0] = "&a&o/from [player] &fforcibly teleports the designated player to you. You can also use &a&o/pull&f, &a&o/yank&f, &a&o/bring&f, or &a&o/get&f.";
                    help_line[1] = "myultrawarps.from";
                    help_line[2] = false;
                    help_line[3] = 2;
                } else if (i == 36) {
                    help_line[0] = "&a&o/warp all (\"to\") [\"here\"/\"there\"/\"warp\" [warp]/\"player\" [player]] &fwarps everyone on the server to your current location, the spot you're pointing at, or the designated warp or player.";
                    help_line[1] = "myultrawarps.warpall";
                    help_line[2] = false;
                    help_line[3] = 4;
                } else if (i == 37) {
                    help_line[0] = "&a&o/send [player] (\"to\") [\"there\"/\"warp\" [warp]/\"player\" [player]] &fwarps the designated player to the spot you're pointing at or the designated warp or player.";
                    help_line[1] = "myultrawarps.send";
                    help_line[2] = false;
                    help_line[3] = 3;
                } else if (i == 38) {
                    help_line[0] = "&a&o/warps [\"around\"/\"near\"] [\"here\"/\"there\"/\"warp\" [warp]/\"player\" [player]] (search radius) &flists all the warps within the search radius of the designated warp, player, or other specified location. By default, the search radius is 20 blocks.";
                    help_line[1] = "myultrawarps.warpsaround";
                    help_line[2] = true;
                    help_line[3] = 5;
                } else if (i == 39) {
                    help_line[0] = "&a&o/default [\"warp\"/\"no warp\"] (\"message\") (\"for\" [player]/\"group:\"[group]/\"server\") [message] &fchanges the default warp or no warp message for a player, a group, or the entire server.";
                    help_line[1] = "myultrawarps.config";
                    help_line[2] = true;
                    help_line[3] = 4;
                } else if (i == 40) {
                    help_line[0] = "&a&o/max warps(\"for\" [player]/\"group:\"[group]/\"server\") [max warps] &fallows admins to change the maximum number of warps that a player, a group, or the entire server can make.";
                    help_line[1] = "myultrawarps.admin";
                    help_line[2] = false;
                    help_line[3] = 3;
                } else if (i == 41) {
                    help_line[0] = "&a&o/myUltraWarps load (\"the\") [\"warps\"/\"switches\"/\"config\"] &freloads all the data on the server for the warps, switches, or configurations straight from the warps.txt, switches.txt, or config.txt file and formats the file. You can also use &a&o/mUW&f.";
                    help_line[1] = "myultrawarps.admin";
                    help_line[2] = false;
                    help_line[3] = 4;
                } else if (i == 42) {
                    help_line[0] = "&a&o/myUltraWarps save (\"the\") [\"warps\"/\"switches\"/\"config\"] &fsaves all the data on the server and updates and formats the warps.txt, switches.txt, or config.txt file. You can also use &a&o/mUW&f.";
                    help_line[1] = "myultrawarps.admin";
                    help_line[2] = false;
                    help_line[3] = 4;
                }
                this.help_pages.add(help_line);
                ++i;
            }
            for (OfflinePlayer player2 : server.getOfflinePlayers()) {
                myUltraWarps.debug("loaded player name: \"" + player2.getName() + "\"");
                players.add(player2.getName());
            }
            String[] enable_messages = new String[]{"Scotty can now beam you up.", "The warps have entered the building.", "These ARE the warps you're looking for.", "May the warps be with you.", "Let's rock these warps.", "Warp! Warp! Warp! Warp! Warp! Warp!", "What warp through yonder server breaks?", "Wanna see me warp to that mountain and back?\nWanna see me do it again?", "/jump is much less lethal now!", "/top used to take people above the Nether's ceiling!"};
            myUltraWarps.tellOps((Object)COLOR + enable_messages[(int)(Math.random() * (double)enable_messages.length)], true, new String[0]);
        }
        catch (Exception exception) {
            myUltraWarps.processException("There was a problem enabling myUltraWarps!", exception);
        }
    }

    public void onDisable() {
        try {
            Plugin permissions_plugin;
            if (!(permissions == null || (permissions_plugin = server.getPluginManager().getPlugin(permissions.getName())) == null || permissions_plugin.isEnabled())) {
                server.getPluginManager().enablePlugin(permissions_plugin);
            }
            this.saveTheWarps((CommandSender)console, true);
            this.saveTheSwitches((CommandSender)console, true);
            this.saveTheConfig((CommandSender)console, true);
            this.saveTheUniqueIDs((CommandSender)console, true);
            this.saveTheTemporaryData();
            String[] disable_messages = new String[]{"Ta ta for now!", "See you soon!", "I'll miss you!", "Don't forget me!", "Don't forget to write!", "Don't leave me here all alone!", "Hasta la vista, baby.", "Wait for me!"};
            myUltraWarps.tellOps((Object)COLOR + disable_messages[(int)(Math.random() * (double)disable_messages.length)], true, new String[0]);
        }
        catch (Exception exception) {
            myUltraWarps.processException("There was a problem disabling myUltraWarps!", exception);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean onCommand(CommandSender sender, Command cmd, String command, String[] parameters) {
        boolean success;
        block335 : {
            success = false;
            if (command.equalsIgnoreCase("setspawn") || command.equalsIgnoreCase("set") && parameters.length > 0 && parameters[0].equalsIgnoreCase("spawn")) {
                success = true;
                if (sender instanceof Player && sender.hasPermission("myultrawarps.admin")) {
                    this.setSpawn(sender);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "You can't decide where the spawn point goes. You can't point it out to me. Sorry.");
                    return success;
                } else if (command.equalsIgnoreCase("set") && parameters.length > 0 && parameters[0].equalsIgnoreCase("spawn")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/set spawn" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/setspawn" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("sethome") || command.equalsIgnoreCase("set") && parameters.length > 0 && parameters[0].equalsIgnoreCase("home")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.sethome") || sender.hasPermission("myultrawarps.sethome.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin"))) {
                    this.setHome(sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "You can't have a home! YOU...ARE...A...CONSOLE!");
                    return success;
                } else if (!(parameters.length != 0 && parameters[0].equalsIgnoreCase("home"))) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/sethome" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/set home" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("warplist") || command.equalsIgnoreCase("warpslist") || (command.equalsIgnoreCase("warp") || command.equalsIgnoreCase("warps")) && parameters.length > 0 && parameters[0].equalsIgnoreCase("list")) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.list") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) {
                    this.warpList(sender, parameters);
                    return success;
                } else if (!(parameters.length != 0 && parameters[0].equalsIgnoreCase("list"))) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + " list" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("full") || command.equalsIgnoreCase("entire") || command.equalsIgnoreCase("complete")) && parameters.length > 1 && (parameters[0].equalsIgnoreCase("warp") || parameters[0].equalsIgnoreCase("warps")) && parameters[1].equalsIgnoreCase("list") || command.equalsIgnoreCase("fullwarplist") || command.equalsIgnoreCase("entirewarplist") || command.equalsIgnoreCase("completewarplist") || command.equalsIgnoreCase("fullwarpslist") || command.equalsIgnoreCase("entirewarpslist") || command.equalsIgnoreCase("completewarpslist") || command.equalsIgnoreCase("fwl") || command.equalsIgnoreCase("cwl") || command.equalsIgnoreCase("ewl")) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.list.full") || sender.hasPermission("myultrawarps.admin")) {
                    this.fullWarpList(sender, parameters);
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + " warps list" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("switchlist") || command.equalsIgnoreCase("switcheslist") || (command.equalsIgnoreCase("switch") || command.equalsIgnoreCase("switches")) && parameters.length > 0 && parameters[0].equalsIgnoreCase("list")) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.list") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) {
                    this.switchList(sender, parameters);
                    return success;
                } else if (!(parameters.length != 0 && parameters[0].equalsIgnoreCase("list"))) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + " list" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("full") || command.equalsIgnoreCase("entire") || command.equalsIgnoreCase("complete")) && parameters.length > 1 && (parameters[0].equalsIgnoreCase("switch") || parameters[0].equalsIgnoreCase("switches")) && parameters[1].equalsIgnoreCase("list") || command.equalsIgnoreCase("fullswitchlist") || command.equalsIgnoreCase("entireswitchlist") || command.equalsIgnoreCase("completeswitchlist") || command.equalsIgnoreCase("fullswitcheslist") || command.equalsIgnoreCase("entireswitcheslist") || command.equalsIgnoreCase("completeswitcheslist") || command.equalsIgnoreCase("fsl") || command.equalsIgnoreCase("csl") || command.equalsIgnoreCase("esl")) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.list.full") || sender.hasPermission("myultrawarps.admin")) {
                    this.fullSwitchList(sender, parameters);
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + " switches list" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("spawn")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.spawn") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin"))) {
                    this.spawn(sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "You cannot warp! Stop trying to warp! You have no body! Stop trying to warp!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/spawn" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("createwarp") || command.equalsIgnoreCase("makewarp") || command.equalsIgnoreCase("setwarp") || (command.equalsIgnoreCase("create") || command.equalsIgnoreCase("make") || command.equalsIgnoreCase("set")) && (parameters.length == 0 || !parameters[0].equalsIgnoreCase("warp"))) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.create") || sender.hasPermission("myultrawarps.create.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 0) {
                    this.createWarp(0, sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "Silly console! You can't make a warp to your current location! You have no body! :P");
                    return success;
                } else if (parameters.length == 0) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me what you want to name the warp!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("create") || command.equalsIgnoreCase("make") || command.equalsIgnoreCase("set")) && parameters.length > 0 && parameters[0].equalsIgnoreCase("warp")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.create") || sender.hasPermission("myultrawarps.create.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 1) {
                    this.createWarp(1, sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "Silly console! You can't make a warp! You have no body! :P");
                    return success;
                } else if (parameters.length <= 1) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me what you want to name the warp!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + " warp" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("warpinfo")) {
                success = true;
                if ((!(sender instanceof Player) || sender.hasPermission("myultrawarps.warpinfo") || sender.hasPermission("myultrawarps.warpinfo.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 0) {
                    this.warpInfo(0, sender, parameters);
                    return success;
                } else if (parameters.length == 0) {
                    sender.sendMessage((Object)ChatColor.RED + "You need to tell me the name of the warp you want info on!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/warpinfo" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("warp") && parameters.length > 0 && parameters[0].equalsIgnoreCase("info")) {
                success = true;
                if ((!(sender instanceof Player) || sender.hasPermission("myultrawarps.warpinfo") || sender.hasPermission("myultrawarps.warpinfo.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 1) {
                    this.warpInfo(1, sender, parameters);
                    return success;
                } else if (parameters.length == 1) {
                    sender.sendMessage((Object)ChatColor.RED + "You need to tell me the name of the warp you want info on!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/warp info" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("warpall")) {
                success = true;
                if (parameters.length > 0 && (!(sender instanceof Player) || sender.hasPermission("myultrawarps.warpall") || sender.hasPermission("myultrawarps.admin"))) {
                    this.warpAll(0, sender, parameters);
                    return success;
                } else if (parameters.length == 0) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me where you want all the players warped!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/warpall" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("warp") && parameters.length > 0 && parameters[0].equalsIgnoreCase("all")) {
                success = true;
                if (parameters.length > 1 && (!(sender instanceof Player) || sender.hasPermission("myultrrawarps.warpall") || sender.hasPermission("myultrawarps.admin"))) {
                    this.warpAll(1, sender, parameters);
                    return success;
                } else if (parameters.length == 1) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me where you want all the players warped!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/warpall" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("warp")) {
                success = true;
                if (parameters.length == 0) {
                    if (sender instanceof Player) {
                        sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me what warp you want to warp to!");
                        return success;
                    } else {
                        console.sendMessage((Object)ChatColor.RED + "Silly console! You can't warp! You have no body! :P");
                    }
                    return success;
                } else if (parameters.length < 3) {
                    if (sender instanceof Player && (sender.hasPermission("myultrawarps.warptowarp") || sender.hasPermission("myultrawarps.warptowarp.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin"))) {
                        this.warp(sender, parameters);
                        return success;
                    } else if (!(sender instanceof Player)) {
                        console.sendMessage((Object)ChatColor.RED + "Silly console! You can't warp! You have no body! :P");
                        return success;
                    } else {
                        sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to warp to preset warps.");
                    }
                    return success;
                } else if (sender instanceof Player && (sender.hasPermission("myultrawarps.warptocoord") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin"))) {
                    this.warpToCoordinate(sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "Silly console! You can't warp! You have no body! :P");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to warp to specific coordinates.");
                }
                return success;
            }
            if (command.equalsIgnoreCase("warptocoord")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.warptocoord") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length >= 3) {
                    this.warpToCoordinate(sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "Silly console! You can't warp! You have no body! :P");
                    return success;
                } else if (parameters.length < 3) {
                    sender.sendMessage("You forgot to tell me where you want to warp to!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to warp to specific coordinates.");
                }
                return success;
            }
            if (command.equalsIgnoreCase("default") && parameters.length > 0 && (parameters[0].equalsIgnoreCase("warp") || parameters[0].toLowerCase().startsWith("warp:") || parameters[0].equalsIgnoreCase("nowarp") || parameters[0].toLowerCase().startsWith("nowarp:") || parameters.length > 1 && parameters[0].equalsIgnoreCase("no") && (parameters[1].equalsIgnoreCase("warp") || parameters[1].toLowerCase().startsWith("warp:")))) {
                success = true;
                int extra_param = 1;
                if (parameters[0].equalsIgnoreCase("no")) {
                    ++extra_param;
                }
                if (parameters.length > extra_param && parameters[extra_param].equalsIgnoreCase("message")) {
                    ++extra_param;
                }
                if (parameters.length >= extra_param && (!(sender instanceof Player) || sender.hasPermission("myultrawarps.config") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin"))) {
                    this.changeDefaultMessage(extra_param, sender, parameters);
                    return success;
                } else if (!(!(sender instanceof Player) || sender.hasPermission("myultrawarps.config") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin"))) {
                    if (parameters[0].equalsIgnoreCase("no")) {
                        sender.sendMessage((Object)ChatColor.RED + "Sorry, but you're not allowed to use " + (Object)COLOR + "/default no " + parameters[1].toLowerCase() + (Object)ChatColor.RED + ".");
                        return success;
                    } else {
                        sender.sendMessage((Object)ChatColor.RED + "Sorry, but you're not allowed to use " + (Object)COLOR + "/default " + parameters[0].toLowerCase() + (Object)ChatColor.RED + ".");
                    }
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me the new default message!");
                }
                return success;
            }
            if (command.equalsIgnoreCase("changewarp") || command.equalsIgnoreCase("modifywarp") || (command.equalsIgnoreCase("change") || command.equalsIgnoreCase("modify")) && (parameters.length == 0 || !parameters[0].equalsIgnoreCase("warp"))) {
                success = true;
                if ((!(sender instanceof Player) || sender.hasPermission("myultrawarps.change") || sender.hasPermission("myultrawarps.change.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 1) {
                    this.changeWarp(0, sender, parameters);
                    return success;
                } else if (parameters.length == 0) {
                    sender.sendMessage((Object)ChatColor.RED + "You didn't tell me what warp to change or how to change it!");
                    return success;
                } else if (parameters.length == 1) {
                    sender.sendMessage((Object)ChatColor.RED + "You didn't tell me what to change!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("change") || command.equalsIgnoreCase("modify")) && parameters.length > 0 && parameters[0].equalsIgnoreCase("warp")) {
                success = true;
                if ((!(sender instanceof Player) || sender.hasPermission("myultrawarps.change") || sender.hasPermission("myultrawarps.change.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 2) {
                    this.changeWarp(1, sender, parameters);
                    return success;
                } else if (parameters.length < 2) {
                    sender.sendMessage((Object)ChatColor.RED + "You didn't tell me what warp to change or how to change it!");
                    return success;
                } else if (parameters.length == 2) {
                    sender.sendMessage((Object)ChatColor.RED + "You didn't tell me what to change!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + " warp" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("deletewarp") || command.equalsIgnoreCase("removewarp") || (command.equalsIgnoreCase("delete") || command.equalsIgnoreCase("remove")) && (parameters.length == 0 || !parameters[0].equalsIgnoreCase("warp"))) {
                success = true;
                if ((!(sender instanceof Player) || sender.hasPermission("myultrawarps.delete") || sender.hasPermission("myultrawarps.delete.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 0) {
                    this.deleteWarp(0, sender, parameters);
                    return success;
                } else if (parameters.length == 0) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me what warp to delete!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("delete") || command.equalsIgnoreCase("remove")) && parameters.length > 0 && parameters[0].equalsIgnoreCase("warp")) {
                success = true;
                if ((!(sender instanceof Player) || sender.hasPermission("myultrawarps.delete") || sender.hasPermission("myultrawarps.delete.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 1) {
                    this.deleteWarp(1, sender, parameters);
                    return success;
                } else if (parameters.length == 1) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me what warp to delete!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + " warp" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("back") || command.equalsIgnoreCase("return") || command.equalsIgnoreCase("last")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.back") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin"))) {
                    this.back(sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "How exactly can you go back to your last warp if you can't warp in the first place?");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("jump") || command.equalsIgnoreCase("j")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.jump") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin"))) {
                    this.jump(sender);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)COLOR + "You jumped! " + (Object)ChatColor.RED + "Just kidding. You're a console and you have no body.");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/jump" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("linkwarp") || command.equalsIgnoreCase("link") && (parameters.length == 0 || !parameters[0].equalsIgnoreCase("warp"))) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.link") || sender.hasPermission("myultrawarps.link.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 0) {
                    this.linkWarp(0, sender, parameters);
                    return success;
                } else if (parameters.length == 0) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me what warp I should use!");
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "Point out the switch you want to link \"" + parameters[0] + "\" to. Oh, wait. You can't. You're a console.");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("link") && parameters.length > 0 && parameters[0].equalsIgnoreCase("warp")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.link") || sender.hasPermission("myultrawarps.link.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 1) {
                    this.linkWarp(1, sender, parameters);
                    return success;
                } else if (parameters.length == 1) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me what warp I should use!");
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "Point out the switch you want to link \"" + parameters[0] + "\" to. Oh, wait. You can't. You're a console.");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/link warp" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("unlinkwarp") || command.equalsIgnoreCase("unlink") && (parameters.length == 0 || !parameters[0].equalsIgnoreCase("warp"))) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.unlink") || sender.hasPermission("myultrawarps.unlink.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) {
                    this.unlinkWarp(0, sender, parameters);
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("unlink") && parameters.length > 0 && parameters[0].equalsIgnoreCase("warp")) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.unlink") || sender.hasPermission("myultrawarps.unlink.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) {
                    this.unlinkWarp(1, sender, parameters);
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/unlink warp" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("movewarp") || command.equalsIgnoreCase("translatewarp") || (command.equalsIgnoreCase("move") || command.equalsIgnoreCase("translate")) && (parameters.length == 0 || !parameters[0].equalsIgnoreCase("warp"))) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.change") || sender.hasPermission("myultrawarps.change.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 0) {
                    this.moveWarp(0, sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "You can't move any warps because you can't point out a new location for the warp! You have no body!");
                    return success;
                } else if (parameters.length == 0) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me which warp to move!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("move") || command.equalsIgnoreCase("translate")) && parameters.length > 0 && parameters[0].equalsIgnoreCase("warp")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.change") || sender.hasPermission("myultrawarps.change.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 1) {
                    this.moveWarp(1, sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "You can't move any warps because you can't point out a new location for the warp! You have no body!");
                    return success;
                } else if (parameters.length == 1) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me which warp to move!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + " warp" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (command.equalsIgnoreCase("home") || command.equalsIgnoreCase("h")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.home") || sender.hasPermission("myultrawarps.home.other") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin"))) {
                    this.home(sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "You can't have a home! YOU...ARE...A...CONSOLE!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/home" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("mUW") || command.equalsIgnoreCase("myUltraWarps")) && (parameters.length == 0 || parameters.length > 0 && parameters[0].equalsIgnoreCase("help"))) {
                success = true;
                this.displayHelp(sender, parameters);
                return success;
            }
            if ((command.equalsIgnoreCase("mUW") || command.equalsIgnoreCase("myUltraWarps")) && parameters.length > 1 && parameters[0].equalsIgnoreCase("save") && (parameters[1].equalsIgnoreCase("warps") || parameters.length > 2 && parameters[1].equalsIgnoreCase("the") && parameters[2].equalsIgnoreCase("warps"))) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.admin")) {
                    this.saveTheWarps(sender, true);
                    return success;
                } else if (command.equalsIgnoreCase("myUltraWarps")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/myUltraWarps save" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/mUW save" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("mUW") || command.equalsIgnoreCase("myUltraWarps")) && parameters.length > 1 && parameters[0].equalsIgnoreCase("save") && (parameters[1].equalsIgnoreCase("switches") || parameters.length > 2 && parameters[1].equalsIgnoreCase("the") && parameters[2].equalsIgnoreCase("switches"))) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.admin")) {
                    this.saveTheSwitches(sender, true);
                    return success;
                } else if (command.equalsIgnoreCase("myUltraWarps")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/myUltraWarps save" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/mUW save" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("mUW") || command.equalsIgnoreCase("myUltraWarps")) && parameters.length > 1 && parameters[0].equalsIgnoreCase("save") && (parameters[1].equalsIgnoreCase("config") || parameters.length > 2 && parameters[1].equalsIgnoreCase("the") && parameters[2].equalsIgnoreCase("config"))) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.admin")) {
                    this.saveTheConfig(sender, true);
                    return success;
                } else if (command.equalsIgnoreCase("myUltraWarps")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/myUltraWarps save" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/mUW save" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("mUW") || command.equalsIgnoreCase("myUltraWarps")) && parameters.length == 1 && parameters[0].equalsIgnoreCase("save")) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.admin")) {
                    this.saveTheWarps(sender, true);
                    this.saveTheSwitches(sender, true);
                    this.saveTheConfig(sender, true);
                    return success;
                } else if (command.equalsIgnoreCase("myUltraWarps")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/myUltraWarps save" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/mUW save" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("myUltraWarps") || command.equalsIgnoreCase("mUW")) && parameters.length > 1 && parameters[0].equalsIgnoreCase("load") && (parameters[1].equalsIgnoreCase("warps") || parameters.length > 2 && parameters[1].equalsIgnoreCase("the") && parameters[2].equalsIgnoreCase("warps"))) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.admin")) {
                    this.loadTheWarps(sender);
                    return success;
                } else if (command.equalsIgnoreCase("myUltraWarps")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/myUltraWarps load" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/mUW load" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("myUltraWarps") || command.equalsIgnoreCase("mUW")) && parameters.length > 1 && parameters[0].equals("load") && (parameters[1].equalsIgnoreCase("switches") || parameters.length > 2 && parameters[1].equalsIgnoreCase("the") && parameters[2].equalsIgnoreCase("switches"))) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.admin")) {
                    this.loadTheSwitches(sender);
                    return success;
                } else if (command.equalsIgnoreCase("myUltraWarps")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/myUltraWarps load" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/mUW load" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("myUltraWarps") || command.equalsIgnoreCase("mUW")) && parameters.length > 1 && parameters[0].equalsIgnoreCase("load") && (parameters[1].equalsIgnoreCase("config") || parameters.length > 2 && parameters[1].equalsIgnoreCase("the") && parameters[2].equalsIgnoreCase("config"))) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.admin")) {
                    this.loadTheConfig(sender);
                    return success;
                } else if (command.equalsIgnoreCase("myUltraWarps")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/myUltraWarps load" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/mUW load" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("myUltraWarps") || command.equalsIgnoreCase("mUW")) && parameters.length == 1 && parameters[0].equalsIgnoreCase("load")) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.admin")) {
                    this.loadTheWarps(sender);
                    this.loadTheSwitches(sender);
                    this.loadTheConfig(sender);
                    return success;
                } else if (command.equalsIgnoreCase("myUltraWarps")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/myUltraWarps load" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/mUW load" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if ((command.equalsIgnoreCase("myUltraWarps") || command.equalsIgnoreCase("mUW")) && parameters.length >= 1 && parameters[0].toLowerCase().startsWith("update")) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.admin")) {
                    this.checkForUpdates(sender);
                    return success;
                } else if (command.equalsIgnoreCase("myUltraWarps")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/myUltraWarps update" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/mUW update" + (Object)ChatColor.RED + ".");
                }
                return success;
            }
            if (!command.equalsIgnoreCase("mUW") && !command.equalsIgnoreCase("myUltraWarps") || parameters.length <= 0 || !parameters[0].toLowerCase().startsWith("debug")) break block335;
            if (sender instanceof Player && !sender.hasPermission("myultrawarps.admin")) {
                if (command.equalsIgnoreCase("myUltraWarps")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/myUltraWarps debug" + (Object)ChatColor.RED + ".");
                    return true;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/mUW debug" + (Object)ChatColor.RED + ".");
                }
                return true;
            } else {
                String sender_name = "console";
                if (sender instanceof Player) {
                    sender_name = ((Player)sender).getName();
                }
                if (debuggers.contains(sender_name)) {
                    debuggers.remove(sender_name);
                    sender.sendMessage((Object)COLOR + "Bugs swatted!");
                    return true;
                } else {
                    debuggers.add(sender_name);
                    sender.sendMessage((Object)COLOR + "Let's fix some bugs! I'll get the fly swatter!");
                }
            }
            return true;
        }
        try {
            if (command.equalsIgnoreCase("mUW") || command.equalsIgnoreCase("myUltraWarps")) {
                String[] new_parameters = new String[]{};
                if (parameters.length <= 0) return this.onCommand(sender, cmd, parameters[0], new_parameters);
                new_parameters = new String[parameters.length - 1];
                for (int i = 1; i < parameters.length; ++i) {
                    new_parameters[i - 1] = parameters[i];
                }
                return this.onCommand(sender, cmd, parameters[0], new_parameters);
            }
            if (command.equalsIgnoreCase("top") || command.equalsIgnoreCase("t")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.top") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin"))) {
                    this.top(sender);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "You don't have a body! Stop trying to warp!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/top" + (Object)ChatColor.RED + ".");
                }
                return success;
            } else if (command.equalsIgnoreCase("switchinfo")) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.switchinfo") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) {
                    this.switchInfo(0, sender, parameters);
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/switchinfo" + (Object)ChatColor.RED + ".");
                }
                return success;
            } else if (command.equalsIgnoreCase("switch") && parameters.length > 0 && parameters[0].equalsIgnoreCase("info")) {
                success = true;
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.switchinfo") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) {
                    this.switchInfo(1, sender, parameters);
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/switch info" + (Object)ChatColor.RED + ".");
                }
                return success;
            } else if (command.equalsIgnoreCase("to") || command.equalsIgnoreCase("find")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.to") || sender.hasPermission("myultrawarps.to.norequest") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 0) {
                    this.to(sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "For the last time: You cannot warp! YOU HAVE NO BODY!");
                    return success;
                } else if (parameters.length == 0) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me who I should teleport you to!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                }
                return success;
            } else if (command.equalsIgnoreCase("from") || command.equalsIgnoreCase("pull") || command.equalsIgnoreCase("yank") || command.equalsIgnoreCase("bring") || command.equalsIgnoreCase("get")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.from") || sender.hasPermission("myultrawarps.from.norequest") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 0) {
                    this.from(sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    console.sendMessage((Object)ChatColor.RED + "No more trying to warp! It's not going to work! You're a CONSOLE!");
                    return success;
                } else if (parameters.length == 0) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me who I should teleport to you!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                }
                return success;
            } else if (command.equalsIgnoreCase("send")) {
                success = true;
                if ((!(sender instanceof Player) || sender.hasPermission("myultrawarps.send") || sender.hasPermission("myultrawarps.admin")) && parameters.length >= 2) {
                    this.send(sender, parameters);
                    return success;
                } else if (parameters.length == 0) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me who you want me to send where!");
                    return success;
                } else if (parameters.length == 1) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me where to send " + parameters[0] + "!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/send" + (Object)ChatColor.RED + ".");
                }
                return success;
            } else if (command.equalsIgnoreCase("warps") && parameters.length > 0 && (parameters[0].equalsIgnoreCase("around") || parameters[0].equalsIgnoreCase("near"))) {
                success = true;
                if ((!(sender instanceof Player) || sender.hasPermission("myultrawarps.warpsaround") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 1) {
                    this.warpsAround(1, sender, parameters);
                    return success;
                } else if (parameters.length > 1) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you're not allowed to use " + (Object)COLOR + "/warps " + parameters[0].toLowerCase() + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me where you want the search to be centered!");
                }
                return success;
            } else if (command.equalsIgnoreCase("warpsaround") || command.equalsIgnoreCase("warpsnear")) {
                success = true;
                if ((!(sender instanceof Player) || sender.hasPermission("myultrawarps.warpsaround") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 0) {
                    this.warpsAround(0, sender, parameters);
                    return success;
                } else if (parameters.length > 0) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you're not allowed to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me where you want the search to be centered!");
                }
                return success;
            } else if (command.equalsIgnoreCase("maxwarps") || command.equalsIgnoreCase("maximumwarps")) {
                success = true;
                if (parameters.length > 0 && (!(sender instanceof Player) || sender.hasPermission("myultrawarps.admin"))) {
                    this.changeMaxWarps(0, sender, parameters);
                    return success;
                } else if (sender instanceof Player && !sender.hasPermission("myultrawarps.admin")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me what you want me to change the max warps to!");
                }
                return success;
            } else if ((command.equalsIgnoreCase("max") || command.equalsIgnoreCase("maximum")) && parameters.length > 0 && parameters[0].equalsIgnoreCase("warps")) {
                success = true;
                if (parameters.length > 1 && (!(sender instanceof Player) || sender.hasPermission("myultrawarps.admin"))) {
                    this.changeMaxWarps(1, sender, parameters);
                    return success;
                } else if (sender instanceof Player && !sender.hasPermission("myultrawarps.admin")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + " warps" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me what you want me to change the max warps to!");
                }
                return success;
            } else if (command.equalsIgnoreCase("forward") || command.equalsIgnoreCase("fwd")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.admin") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.back"))) {
                    this.forward(sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    sender.sendMessage((Object)ChatColor.RED + "You're a console!! How can I warp you somewhere you've already warped if you can't warp at all in the first place?!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                }
                return success;
            } else if (command.equalsIgnoreCase("deathfwd") || command.equals("fwddeath") || command.equalsIgnoreCase("dfwd") || command.equalsIgnoreCase("fwdd") || command.equalsIgnoreCase("death") && parameters.length > 0 && (parameters[0].equalsIgnoreCase("fwd") || parameters[0].equalsIgnoreCase("forward"))) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.admin") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.death"))) {
                    this.deathForward(sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    sender.sendMessage((Object)ChatColor.RED + "You can't die, you can't warp, and you can't warp to your death location. How do you suppose I would move you forward in your death history?");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                }
                return success;
            } else if (command.equalsIgnoreCase("death")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.death") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin"))) {
                    this.death(sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    sender.sendMessage((Object)ChatColor.RED + "You can't go back to your last death location! You can't warp! You can't even die!");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/" + command.toLowerCase() + (Object)ChatColor.RED + ".");
                }
                return success;
            } else if (command.equalsIgnoreCase("blocklist") || command.equalsIgnoreCase("block") && parameters.length > 0 && parameters[0].equalsIgnoreCase("list")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.block") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin"))) {
                    if (command.equalsIgnoreCase("blocklist")) {
                        this.blockList(0, sender, parameters);
                        return success;
                    } else {
                        this.blockList(1, sender, parameters);
                    }
                    return success;
                } else if (!(sender instanceof Player)) {
                    sender.sendMessage((Object)ChatColor.RED + "You can't even block people!");
                    return success;
                } else if (command.equalsIgnoreCase("block")) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/block list" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/blocklist" + (Object)ChatColor.RED + ".");
                }
                return success;
            } else if (command.equalsIgnoreCase("block")) {
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.block") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 0) {
                    this.block(sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    sender.sendMessage((Object)ChatColor.RED + "You can't block anyone! People can't even send you requests in the first place!");
                    return success;
                } else if (parameters.length > 0) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/block" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me who you want to block!");
                }
                return success;
            } else {
                if (!command.equalsIgnoreCase("unblock")) return success;
                success = true;
                if (sender instanceof Player && (sender.hasPermission("myultrawarps.block") || sender.hasPermission("myultrawarps.user") || sender.hasPermission("myultrawarps.admin")) && parameters.length > 0) {
                    this.unblock(sender, parameters);
                    return success;
                } else if (!(sender instanceof Player)) {
                    sender.sendMessage((Object)ChatColor.RED + "Do I even need to explain why you can't use this command?");
                    return success;
                } else if (parameters.length > 0) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to use " + (Object)COLOR + "/unblock" + (Object)ChatColor.RED + ".");
                    return success;
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me who you want to unblock!");
                }
            }
            return success;
        }
        catch (Exception exception) {
            myUltraWarps.processException("There was a problem in onCommand()!", exception);
            return false;
        }
    }

    public static /* varargs */ String replaceAll(String text, String ... changes) {
        if (changes.length == 0) {
            return text;
        }
        block0 : for (int j = 0; j < changes.length; j+=2) {
            if (!text.toLowerCase().contains((CharSequence)changes[j].toLowerCase())) {
                return text;
            }
            int i = 0;
            while (text.length() >= i + changes[j].length()) {
                if (text.substring(i, i + changes[j].length()).equalsIgnoreCase(changes[j])) {
                    text = String.valueOf(text.substring(0, i)) + changes[j + 1] + text.substring(i + changes[j].length());
                    i+=changes[j + 1].length() - 1;
                }
                if (!text.toLowerCase().contains((CharSequence)changes[j].toLowerCase())) continue block0;
                ++i;
            }
        }
        return text;
    }

    public static Boolean getResponse(CommandSender sender, String unformatted_response, String current_status_line, String current_status_is_true_message) {
        try {
            String[] yeses = new String[]{"yes", "yeah", "yea", "yep", "sure", "why not", "ok", "okay", "do it", "fine", "whatever", "very well", "accept", "tpa", "cool", "hell yeah", "hells yeah", "hells yes", "come", "ya", "ja", "k ", "kk"};
            String[] nos = new String[]{"no", "nah", "nope", "no thanks", "no don't", "hell no", "shut up", "ignore", "it's not", "its not", "creeper", "unsafe", "wait", "one ", "1 "};
            boolean said_yes = false;
            boolean said_no = false;
            String formatted_response = unformatted_response;
            while (formatted_response.startsWith(" ")) {
                formatted_response = formatted_response.substring(1);
            }
            while (formatted_response.endsWith(" ")) {
                formatted_response = formatted_response.substring(0, formatted_response.length() - 1);
            }
            formatted_response = formatted_response.toLowerCase();
            for (String yes : yeses) {
                if (!formatted_response.startsWith(yes)) continue;
                said_yes = true;
            }
            if (said_yes) {
                return true;
            }
            for (String no : nos) {
                if (!formatted_response.startsWith(no)) continue;
                said_no = true;
            }
            if (said_no) {
                return false;
            }
            if (current_status_line != null) {
                if (!formatted_response.equals("")) {
                    if (unformatted_response.substring(0, 1).equals(" ")) {
                        unformatted_response = unformatted_response.substring(1);
                    }
                    sender.sendMessage((Object)ChatColor.RED + "I don't know what \"" + unformatted_response + "\" means.");
                }
                while (current_status_line.startsWith(" ")) {
                    current_status_line = current_status_line.substring(1);
                }
                if (current_status_line.startsWith(current_status_is_true_message)) {
                    return true;
                }
                return false;
            }
            return null;
        }
        catch (Exception exception) {
            myUltraWarps.processException("There was a problem in onEnable()!", exception);
            return null;
        }
    }

    public static String autoCompleteName(String name) {
        String full_name = null;
        for (String player : players) {
            if (!player.toLowerCase().startsWith(name.toLowerCase()) || full_name != null && full_name.length() <= player.length() && (full_name.length() != player.length() || server.getPlayer(full_name) != null || server.getPlayer(player) == null)) continue;
            full_name = player;
        }
        return full_name;
    }

    public static int readTime(String written) {
        int time = 0;
        String[] temp = written.split(" ");
        ArrayList<String> words = new ArrayList<String>();
        for (String word : temp) {
            if (word.equalsIgnoreCase("and") || word.equalsIgnoreCase("&")) continue;
            words.add(word.toLowerCase().replaceAll(",", ""));
        }
        while (words.size() > 0) {
            try {
                double amount = Double.parseDouble((String)words.get(0));
                if (((String)words.get(0)).contains((CharSequence)"d") || ((String)words.get(0)).contains((CharSequence)"h") || ((String)words.get(0)).contains((CharSequence)"m") || ((String)words.get(0)).contains((CharSequence)"s")) {
                    throw new NumberFormatException();
                }
                int factor = 0;
                if (words.size() > 1) {
                    if (((String)words.get(1)).startsWith("d")) {
                        factor = 86400000;
                    } else if (((String)words.get(1)).startsWith("h")) {
                        factor = 3600000;
                    } else if (((String)words.get(1)).startsWith("m")) {
                        factor = 60000;
                    } else if (((String)words.get(1)).startsWith("s")) {
                        factor = 1000;
                    }
                    if (factor > 0) {
                        time+=(int)(amount * (double)factor + 0.1);
                    }
                    words.remove(0);
                    words.remove(0);
                    continue;
                }
                words.remove(0);
                continue;
            }
            catch (NumberFormatException exception) {
                double amount = 0.0;
                int factor = 0;
                try {
                    if (((String)words.get(0)).contains((CharSequence)"d") && (!((String)words.get(0)).contains((CharSequence)"s") || ((String)words.get(0)).indexOf("s") > ((String)words.get(0)).indexOf("d"))) {
                        amount = Double.parseDouble(((String)words.get(0)).split("d")[0]);
                        factor = 86400000;
                    } else if (((String)words.get(0)).contains((CharSequence)"h")) {
                        amount = Double.parseDouble(((String)words.get(0)).split("h")[0]);
                        factor = 3600000;
                    } else if (((String)words.get(0)).contains((CharSequence)"m")) {
                        amount = Double.parseDouble(((String)words.get(0)).split("m")[0]);
                        factor = 60000;
                    } else if (((String)words.get(0)).contains((CharSequence)"s")) {
                        amount = Double.parseDouble(((String)words.get(0)).split("s")[0]);
                        factor = 1000;
                    }
                    if (factor > 0) {
                        time+=(int)(amount * (double)factor + 0.1);
                    }
                }
                catch (NumberFormatException var8_12) {
                    // empty catch block
                }
                words.remove(0);
            }
        }
        return time;
    }

    public static String writeTime(long time, boolean round_seconds) {
        ArrayList<String> values = new ArrayList<String>();
        if (time > 86400000) {
            values.add(String.valueOf((int)(time / 86400000)) + " days");
            time%=86400000;
        }
        if (time > 3600000) {
            values.add(String.valueOf((int)(time / 3600000)) + " hours");
            time%=3600000;
        }
        if (time > 60000) {
            values.add(String.valueOf((int)(time / 60000)) + " minutes");
            time%=60000;
        }
        if (time > 0 || values.size() == 0) {
            if (!((double)time / 1000.0 == (double)(time / 1000) || round_seconds)) {
                values.add(String.valueOf((double)time / 1000.0) + " seconds");
            } else {
                values.add(String.valueOf(Math.round(time / 1000)) + " seconds");
            }
        }
        if (values.size() >= 2) {
            values.add(values.size() - 1, "and");
        }
        String written = "";
        for (int i = 0; i < values.size(); ++i) {
            if (i > 0) {
                written = String.valueOf(written) + " ";
            }
            written = String.valueOf(written) + (String)values.get(i);
            if (values.size() < 4 || i >= values.size() - 1 || ((String)values.get(i)).equals("and")) continue;
            written = String.valueOf(written) + ",";
        }
        if (!written.equals("")) {
            return written;
        }
        return null;
    }

    public static /* varargs */ String combine(Object[] strings, String separator, int ... indices) {
        if (separator == null) {
            separator = "";
        }
        int start_index = 0;
        int end_index = strings.length;
        if (indices.length > 0) {
            start_index = indices[0];
            if (indices.length > 1) {
                end_index = indices[1];
            }
        }
        String combination = "";
        for (int i = start_index; i < end_index; ++i) {
            try {
                combination = String.valueOf(combination) + strings[i].toString();
            }
            catch (ArrayIndexOutOfBoundsException e) {
                myUltraWarps.processException("Someone gave me bad indices!", e);
            }
            if (i >= end_index - 1) continue;
            combination = String.valueOf(combination) + separator;
        }
        return combination;
    }

    public static String paginate(String message, String command_format, String not_enough_pages, int page_number, boolean not_console) {
        ChatPaginator.ChatPage chat_page;
        if (not_console) {
            chat_page = ChatPaginator.paginate((String)message, (int)page_number, (int)64, (int)10);
            if (chat_page.getTotalPages() > 1) {
                chat_page = ChatPaginator.paginate((String)message, (int)page_number, (int)64, (int)8);
            }
        } else {
            chat_page = ChatPaginator.paginate((String)message, (int)page_number, (int)64, (int)20);
        }
        if (page_number > chat_page.getTotalPages()) {
            String total_pages = String.valueOf(chat_page.getTotalPages()) + " pages";
            if (chat_page.getTotalPages() == 1) {
                total_pages = "1 page";
            }
            return myUltraWarps.replaceAll((Object)ChatColor.RED + not_enough_pages, "[total]", total_pages);
        }
        String page = null;
        for (String line : chat_page.getLines()) {
            page = page == null ? line : String.valueOf(page) + "\n" + line;
        }
        if (chat_page.getTotalPages() > 1) {
            String prefix = (Object)COLOR + "Here's page " + page_number + " of " + chat_page.getTotalPages() + "!\n";
            if (page_number > 1) {
                prefix = String.valueOf(prefix) + (Object)ChatColor.WHITE + "...";
            }
            page = String.valueOf(prefix) + page;
        }
        if (chat_page.getTotalPages() > page_number) {
            page = String.valueOf(page) + (Object)ChatColor.WHITE + "...\n" + (Object)COLOR + "Use " + myUltraWarps.replaceAll(new StringBuilder().append((Object)ChatColor.ITALIC).append(command_format).toString(), "[#]", String.valueOf(page_number + 1)) + (Object)COLOR + " to see more.";
        }
        return page;
    }

    public static String writeLocation(Location location, boolean use_block_coordinates, boolean force_pitch_and_yaw) {
        String string = "(";
        string = use_block_coordinates ? String.valueOf(string) + location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ() + ") " : String.valueOf(string) + location.getX() + ", " + location.getY() + ", " + location.getZ() + ") ";
        if (!use_block_coordinates && ((double)location.getPitch() != 0.0 || (double)location.getYaw() != 0.0 || force_pitch_and_yaw)) {
            string = String.valueOf(string) + "facing (" + location.getPitch() + ", " + location.getYaw() + ") ";
        }
        return String.valueOf(string) + "in \"" + location.getWorld().getWorldFolder().getName() + "\"";
    }

    public static Location readLocation(String string) {
        World world;
        String[] coordinates = string.substring(1, string.indexOf(41)).split(", ");
        float[] facing_coordinates = new float[]{0.0f, 0.0f};
        if (string.contains((CharSequence)"facing") || string.contains((CharSequence)"aiming at")) {
            String[] facing_coordinates_string = string.contains((CharSequence)"facing") ? string.substring(string.indexOf(" facing ") + 9, string.lastIndexOf(41)).split(", ") : string.substring(string.indexOf(" aiming at ") + 12, string.lastIndexOf(41)).split(", ");
            try {
                facing_coordinates = new float[]{Float.parseFloat(facing_coordinates_string[0]), Float.parseFloat(facing_coordinates_string[1])};
            }
            catch (NumberFormatException e) {
                myUltraWarps.tellOps((Object)ChatColor.DARK_RED + "I got an error trying to read the direction on this location String!\n" + (Object)ChatColor.WHITE + "\"" + string + "\"\n" + "I read these as the coordinates: " + (Object)ChatColor.WHITE + "\"" + facing_coordinates[0] + "\", \"" + facing_coordinates[1] + "\"", true, new String[0]);
                return null;
            }
        }
        if ((world = server.getWorld(string.substring(string.indexOf(" in \"") + 5, string.lastIndexOf(34)))) == null) {
            myUltraWarps.tellOps((Object)ChatColor.DARK_RED + "I got an error trying to read the world on this location String!\n" + (Object)ChatColor.WHITE + "\"" + string + "\"\n" + "I read this as the world name: " + (Object)ChatColor.WHITE + "\"" + string.substring(string.indexOf(" in \"") + 5, string.length() - 1) + "\"", true, new String[0]);
            return null;
        }
        try {
            return new Location(world, Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]), Double.parseDouble(coordinates[2]), facing_coordinates[1], facing_coordinates[0]);
        }
        catch (NumberFormatException e) {
            myUltraWarps.tellOps((Object)ChatColor.DARK_RED + "I got an error trying to read this location String!\n" + (Object)ChatColor.WHITE + "\"" + string + "\"\n" + "I read these as the coordinates: " + (Object)ChatColor.WHITE + "\"" + coordinates[0] + "\", \"" + coordinates[1] + "\", \"" + coordinates[2] + "\"", true, new String[0]);
            return null;
        }
    }

    public static String colorCode(String text) {
        try {
            text = "&f" + text;
            for (int i = 0; i < text.length() - 3; ++i) {
                if (!myUltraWarps.isColorCode(text.substring(i, i + 2), false, true).booleanValue() || !myUltraWarps.isColorCode(text.substring(i + 2, i + 4), true, true).booleanValue()) continue;
                text = String.valueOf(text.substring(0, i)) + text.substring(i + 2, i + 4) + text.substring(i, i + 2) + text.substring(i + 4);
            }
            String current_color_code = "";
            for (int i2 = 0; i2 < text.length() - 1; ++i2) {
                if (myUltraWarps.isColorCode(text.substring(i2, i2 + 2), null, true).booleanValue()) {
                    current_color_code = String.valueOf(current_color_code) + text.substring(i2, i2 + 2);
                    continue;
                }
                if (!myUltraWarps.isColorCode(text.substring(i2, i2 + 2), null, false).booleanValue()) continue;
                while (text.length() > i2 + 2 && myUltraWarps.isColorCode(text.substring(i2, i2 + 2), null, false).booleanValue()) {
                    if ((current_color_code = current_color_code.replaceAll("&" + text.substring(i2 + 1, i2 + 2), "")).equals("")) {
                        current_color_code = "&f";
                    }
                    text = String.valueOf(text.substring(0, i2)) + text.substring(i2 + 2);
                }
                text = String.valueOf(text.substring(0, i2)) + current_color_code + text.substring(i2);
            }
            String colored_text = ChatColor.translateAlternateColorCodes((char)'&', (String)text);
            return colored_text;
        }
        catch (Exception exception) {
            myUltraWarps.processException("There was a problem in onEnable()!", exception);
            return null;
        }
    }

    public static Boolean isColorCode(String text, Boolean color, Boolean non_anti) {
        try {
            if (!(text.startsWith("&") || text.startsWith("%"))) {
                return false;
            }
            if (non_anti != null) {
                if (non_anti.booleanValue() && text.startsWith("%")) {
                    return false;
                }
                if (!non_anti.booleanValue() && text.startsWith("&")) {
                    return false;
                }
            }
            if (color == null || color.booleanValue()) {
                for (String color_color_code_char : COLOR_COLOR_CODE_CHARS) {
                    if (!text.substring(1, 2).equalsIgnoreCase(color_color_code_char)) continue;
                    return true;
                }
            }
            if (!(color != null && color.booleanValue())) {
                for (String formatting_color_code_char : FORMATTING_COLOR_CODE_CHARS) {
                    if (!text.substring(1, 2).equalsIgnoreCase(formatting_color_code_char)) continue;
                    return true;
                }
            }
            return false;
        }
        catch (Exception exception) {
            myUltraWarps.processException("There was a problem in onEnable()!", exception);
            return null;
        }
    }

    public static boolean contains(Object[] objects, Object object) {
        for (Object listed_object : objects) {
            if (!listed_object.equals(object)) continue;
            return true;
        }
        return false;
    }

    public static /* varargs */ String writeArray(Object[] objects, String ... options) {
        String separator = ", ";
        String final_conjunction = "and";
        if (options.length > 0 && options[0] != null) {
            separator = options[0];
        }
        if (options.length > 1 && options[1] != null) {
            final_conjunction = options[1];
        }
        if (objects.length == 0) {
            return "";
        }
        if (objects.length == 1) {
            return String.valueOf(objects[0]);
        }
        if (objects.length == 2) {
            return objects[0] + " " + final_conjunction + " " + objects[1];
        }
        String list = "";
        for (int i = 0; i < objects.length; ++i) {
            list = String.valueOf(list) + objects[i];
            if (i > objects.length - 1) continue;
            list = String.valueOf(list) + separator;
            if (i != objects.length - 2) continue;
            list = String.valueOf(list) + final_conjunction + " ";
        }
        return list;
    }

    public static void debug(String message) {
        if (debuggers.size() == 0) {
            return;
        }
        if (debuggers.contains("console")) {
            console.sendMessage((Object)COLOR + message);
            if (debuggers.size() == 1) {
                return;
            }
        }
        for (Player player : server.getOnlinePlayers()) {
            if (!debuggers.contains(player.getName())) continue;
            player.sendMessage((Object)COLOR + message);
        }
    }

    public static /* varargs */ void tellOps(String message, boolean also_tell_console, String ... exempt_ops) {
        if (message.length() > 1) {
            message = String.valueOf(message.substring(0, 1).toUpperCase()) + message.substring(1);
        }
        for (Player player : server.getOnlinePlayers()) {
            if (!player.isOp() || myUltraWarps.contains(exempt_ops, player.getName())) continue;
            player.sendMessage((Object)COLOR + myUltraWarps.colorCode(message));
        }
        if (also_tell_console) {
            console.sendMessage((Object)COLOR + myUltraWarps.colorCode(message));
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static void processException(String message, Throwable e) {
    tellOps(ChatColor.DARK_RED + message, true, new String[0]);
    

    int lines_to_skip = 0;
    do
    {
      lines_to_skip++;
      if (lines_to_skip >= e.getStackTrace().length) {
        break;
      }
    } while ((e.getStackTrace()[lines_to_skip].getLineNumber() < 0) || (e.getStackTrace()[lines_to_skip].getClassName().startsWith("java")));
    while (e != null)
    {
      tellOps(
        ChatColor.DARK_RED + e.getClass().getName().substring(e.getClass().getName().lastIndexOf('.') + 1) + " at line " + e.getStackTrace()[lines_to_skip].getLineNumber() + " of " + e.getStackTrace()[lines_to_skip].getClassName() + ".java (myUltraWarps)", true, new String[0]);
      if (lines_to_skip + 1 < e.getStackTrace().length) {
        tellOps(
          ChatColor.DARK_RED + "  ...and at line " + e.getStackTrace()[(lines_to_skip + 1)].getLineNumber() + " of " + e.getStackTrace()[(lines_to_skip + 1)].getClassName() + ".java (myUltraWarps)", true, new String[0]);
      }
      if (lines_to_skip + 2 < e.getStackTrace().length) {
        tellOps(
          ChatColor.DARK_RED + "  ...and at line " + e.getStackTrace()[(lines_to_skip + 2)].getLineNumber() + " of " + e.getStackTrace()[(lines_to_skip + 2)].getClassName() + ".java (myUltraWarps)", true, new String[0]);
      }
      e = e.getCause();
      if (e != null) {
        tellOps(ChatColor.DARK_RED + "...which was caused by:", true, new String[0]);
      }
    }
  }

    public String stopParsingMessages(String warp_message, String no_warp_message, String true_warp_name, String true_owner_name, boolean player_is_owner, CommandSender sender, String result_message) {
        if (this.parsing_warp_message) {
            this.parsing_warp_message = false;
            if (!result_message.equals("")) {
                result_message = String.valueOf(result_message) + "\n";
            }
            result_message = player_is_owner ? (warp_message.endsWith(".") || warp_message.endsWith("!") || warp_message.endsWith("?") ? String.valueOf(result_message) + (Object)COLOR + "Now people who successfully warp to \"" + true_warp_name + "\" will see \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode(warp_message) + (Object)COLOR + "\"" : (warp_message.equals("") ? String.valueOf(result_message) + (Object)COLOR + "Now people who successfully warp to \"" + true_warp_name + "\" won't see a message." : String.valueOf(result_message) + (Object)COLOR + "Now people who successfully warp to \"" + true_warp_name + "\" will see \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode(warp_message) + (Object)COLOR + ".\"")) : (warp_message.endsWith(".") || warp_message.endsWith("!") || warp_message.endsWith("?") ? String.valueOf(result_message) + (Object)COLOR + "Now people who successfully warp to " + true_owner_name + "'s \"" + true_warp_name + "\" will see \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode(warp_message) + (Object)COLOR + "\"" : (warp_message.equals("") ? String.valueOf(result_message) + (Object)COLOR + "Now people who successfully warp to " + true_owner_name + "'s \"" + true_warp_name + "\" won't see a message." : String.valueOf(result_message) + (Object)COLOR + "Now people who successfully warp to " + true_owner_name + "'s \"" + true_warp_name + "\" will see \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode(warp_message) + (Object)COLOR + ".\""));
        } else if (this.parsing_no_warp_message) {
            this.parsing_no_warp_message = false;
            if (!result_message.equals("")) {
                result_message = String.valueOf(result_message) + "\n";
            }
            result_message = player_is_owner ? (warp_message.endsWith(".") || warp_message.endsWith("!") || warp_message.endsWith("?") ? String.valueOf(result_message) + (Object)COLOR + "Now people who aren't allowed to warp to \"" + true_warp_name + "\" will see \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode(no_warp_message) + (Object)COLOR + "\"" : (no_warp_message.equals("") ? String.valueOf(result_message) + (Object)COLOR + "Now people who aren't allowed to warp to \"" + true_warp_name + "\" won't see a message." : String.valueOf(result_message) + (Object)COLOR + "Now people who aren't allowed to warp to \"" + true_warp_name + "\" will see \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode(no_warp_message) + (Object)COLOR + ".\"")) : (no_warp_message.endsWith(".") || no_warp_message.endsWith("!") || no_warp_message.endsWith("?") ? String.valueOf(result_message) + (Object)COLOR + "Now people who aren't allowed to warp to " + true_owner_name + "'s \"" + true_warp_name + "\" will see \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode(no_warp_message) + (Object)COLOR + "\"" : (no_warp_message.equals("") ? String.valueOf(result_message) + (Object)COLOR + "Now people who aren't allowed to warp to " + true_owner_name + "'s \"" + true_warp_name + "\" won't see a message." : String.valueOf(result_message) + (Object)COLOR + "Now people who aren't allowed to warp to " + true_owner_name + "'s \"" + true_warp_name + "\" will see \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode(no_warp_message) + (Object)COLOR + ".\""));
        }
        return result_message;
    }

    public SettingsSet getSettings(Player player) {
        if (settings.get(player.getName()) != null) {
            myUltraWarps.debug("retrieved settings: individual (" + player.getName() + ")");
            return settings.get(player.getName());
        }
        if (permissions != null && permissions.getPlayerGroups(player) != null) {
            myUltraWarps.debug("acknowledged " + player + "'s " + permissions.getPrimaryGroup(player) + " group membership");
            if (use_group_settings && settings.get("[" + permissions.getPrimaryGroup(player) + "]") != null) {
                myUltraWarps.debug("retrieved settings: group (" + permissions.getPrimaryGroup(player) + ")");
                return settings.get("[" + permissions.getPrimaryGroup(player) + "]");
            }
        } else if (permissions == null) {
            myUltraWarps.debug("no permissions available; no group found");
        } else {
            myUltraWarps.debug("no permissions group found");
        }
        if (settings.get("[server]") != null) {
            myUltraWarps.debug("retrieved settings: global");
            return settings.get("[server]");
        }
        myUltraWarps.tellOps((Object)ChatColor.DARK_RED + "I couldn't retrieve " + player + "'s settings!", true, new String[0]);
        return new SettingsSet();
    }
    
        public SettingsSet getSettings(String group) {
        if (settings.get("[server]") != null) {
            myUltraWarps.debug("retrieved settings: global");
            return settings.get("[server]");
        }
        myUltraWarps.tellOps((Object)ChatColor.DARK_RED + "I couldn't retrieve " + group + "'s settings!", true, new String[0]);
        return new SettingsSet();
    }

    public static Block getTargetBlock(Player player, boolean skip_switches) {
        for (int d = 0; d < 5000; ++d) {
            double yaw = player.getLocation().getYaw();
            double pitch = player.getLocation().getPitch();
            Location location = new Location(player.getWorld(), player.getLocation().getX() + (double)d / 10.0 * Math.cos(Math.toRadians(yaw + 90.0)) * Math.cos(Math.toRadians(- pitch)), player.getEyeLocation().getY() + (double)d / 10.0 * Math.sin(Math.toRadians(- pitch)), player.getLocation().getZ() + (double)d / 10.0 * Math.sin(Math.toRadians(yaw + 90.0)) * Math.cos(Math.toRadians(- pitch)));
            Block block = location.getBlock();
            if (block == null || Math.abs(location.getBlockX()) >= 2000000 || Math.abs(location.getBlockZ()) >= 2000000 || location.getY() < 0.0 || location.getY() > (double)location.getWorld().getMaxHeight()) {
                myUltraWarps.debug("No good target found; search ended at " + myUltraWarps.writeLocation(location, true, false));
                return null;
            }
            if (myUltraWarps.contains(NON_SOLID_BLOCK_IDS, (short)block.getTypeId()) && (skip_switches || UltraSwitch.getSwitchType(block) == null)) continue;
            myUltraWarps.debug("found target block at " + myUltraWarps.writeLocation(block.getLocation(), true, false));
            return block;
        }
        return null;
    }

    public boolean teleport(Player player, UltraWarp from, UltraWarp to, boolean send_warp_message, CommandSender non_teleporting_player) {
        SettingsSet set = this.getSettings(player);
        if (cooling_down_players.containsKey(player.getName()) && !player.hasPermission("myultrawarps.admin") && (non_teleporting_player == null || non_teleporting_player instanceof Player && !non_teleporting_player.hasPermission("myultrawarps.admin"))) {
            player.sendMessage((Object)ChatColor.RED + "Sorry, but you still have to wait " + myUltraWarps.writeTime(set.cooldown - (long)((int)(Calendar.getInstance().getTimeInMillis() - cooling_down_players.get(player.getName()))), true) + " before you can teleport again.");
            if (non_teleporting_player != null) {
                non_teleporting_player.sendMessage((Object)ChatColor.RED + "Sorry, but " + player.getName() + " can't teleport for another " + myUltraWarps.writeTime(set.cooldown - (long)((int)(Calendar.getInstance().getTimeInMillis() - cooling_down_players.get(player.getName()))), true) + ".");
            }
            return false;
        }
        if (Math.abs(to.location.getX()) > 2000000.0 || Math.abs(to.location.getZ()) > 2000000.0) {
            myUltraWarps.debug((Object)ChatColor.RED + "Teleportation cancelled; |coords| > (2,000,000, 2,000,000)");
            player.sendMessage((Object)ChatColor.RED + "Sorry, but you can't teleport past x = \u00b12,000,000 or z = \u00b12,000,000. because it crashes most Minecraft servers.");
            if (non_teleporting_player != null) {
                non_teleporting_player.sendMessage((Object)ChatColor.RED + "Sorry, but " + player.getName() + " can't teleport past x = \u00b12,000,000 or z = \u00b12,000,000. because it crashes most Minecraft servers.");
            }
            return false;
        }
        if (!to.location.getChunk().isLoaded()) {
            myUltraWarps.debug(String.valueOf(player.getName()) + "'s target chunk hasn't been loaded yet; I'll load it and teleport them there when it's ready.");
            this.teleportPartII(player, from, to, send_warp_message, non_teleporting_player);
            if (!to.location.getChunk().load()) {
                myUltraWarps.debug((Object)ChatColor.RED + "I couldn't load the target chunk!");
                player.sendMessage((Object)ChatColor.DARK_RED + "I'm sorry, but I couldn't load the chunk that you're supposed to teleport to!");
                if (non_teleporting_player != null) {
                    non_teleporting_player.sendMessage((Object)ChatColor.DARK_RED + "I couldn't load the chunk that you were teleporting " + player.getName() + " to!");
                }
                return false;
            }
        }
        this.teleportPartII(player, from, to, send_warp_message, non_teleporting_player);
        return true;
    }

    public void teleportPartII(Player player, UltraWarp from, UltraWarp to, boolean send_warp_message, CommandSender non_teleporting_player) {
        if (player.isInsideVehicle()) {
            myUltraWarps.debug("When teleporting, " + player.getName() + " was riding a(n) " + player.getVehicle().getType().name());
        }
        server.getScheduler().scheduleSyncDelayedTask(mUW, (Runnable)new myUltraWarps$1((CommandSender)player, "perform teleportation", new Object[]{to.location}), 0);
        SettingsSet set = this.getSettings(player);
        if (send_warp_message && !to.warp_message.equals("")) {
            player.sendMessage(myUltraWarps.colorCode(to.warp_message.replaceAll("\\[player\\]", player.getName())));
        }
        if (from != null) {
            ArrayList replacement = warp_histories.get(player.getName());
            Integer last_warp_index = last_warp_indexes.get(player.getName());
            if (replacement != null && last_warp_index != null) {
                while (replacement.size() > last_warp_index + 1) {
                    replacement.remove(replacement.size() - 1);
                }
            } else if (replacement == null) {
                replacement = new ArrayList();
            }
            replacement.add((UltraWarp)from);
            replacement.add(to);
            while (replacement.size() > set.warp_history_length) {
                replacement.remove(0);
            }
            warp_histories.put(player.getName(), replacement);
            last_warp_indexes.put(player.getName(), replacement.size() - 1);
        }
        if (!(set.cooldown <= 0 || player.hasPermission("myultrawarps.admin"))) {
            cooling_down_players.put(player.getName(), Calendar.getInstance().getTimeInMillis());
            server.getScheduler().scheduleSyncDelayedTask((Plugin)this, (Runnable)new myUltraWarps$1((CommandSender)player, "remove cooldown", player.getName()), set.cooldown / 50);
        }
    }

    @EventHandler
    public void captureAndHandleUUIDStuff(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPlayedBefore()) {
            myUltraWarps.debug("adding newbie " + event.getPlayer().getName() + " to players...");
            players.add(event.getPlayer().getName());
        }
        if (this.UUIDs.containsKey(event.getPlayer().getName()) && !this.UUIDs.get(event.getPlayer().getName()).equals(event.getPlayer().getUniqueId())) {
            UUID old_ID = this.UUIDs.get(event.getPlayer().getName());
            for (UltraWarp warp : warps) {
                if (!warp.owner.equals(event.getPlayer().getName())) continue;
                warp.owner = old_ID.toString();
            }
            myUltraWarps.tellOps((Object)ChatColor.GREEN + "myUltraWarps has prevented username sniping takeover!\n" + event.getPlayer().getName() + " is not the same " + event.getPlayer().getName() + " you once new, but a different person!\nI changed all of " + event.getPlayer().getName() + "'s warps so that this new person can't use them and when the old " + event.getPlayer().getName() + " logs back in, I will change all their warps to work for them with their new username.", true, new String[0]);
        }else if (this.UUIDs.containsValue(event.getPlayer().getUniqueId()) && !this.UUIDs.containsKey(event.getPlayer().getName())) {
            myUltraWarps.debug("detected changed username: " + event.getPlayer().getName() + "; finding old value...");
            String old_username = null;
            for (String key : this.UUIDs.keySet()) {
                if (!this.UUIDs.get(key).equals(event.getPlayer().getUniqueId())) continue;
                old_username = key;
                break;
            }
            if (old_username == null) {
                myUltraWarps.tellOps((Object)ChatColor.DARK_RED + "I detected that " + event.getPlayer().getName() + " changed their username, but I couldn't find their old username!", true, new String[0]);
                return;
            }
            
            myUltraWarps.debug("found " + event.getPlayer().getName() + "'s old username: " + old_username + "; changing warps ownerships accordingly...");
            for (UltraWarp warp : warps) {
                
                //Convert List Users
                String[] new_listed_users = new String[warp.listed_users.length];
                int i = 0;
                for(String member : warp.listed_users){
                    if(member.equals(old_username)){
                        new_listed_users[i] = event.getPlayer().getName();
                        myUltraWarps.debug("found player " + event.getPlayer().getName() + " on someones warp list; updating....");
                    } else {
                        new_listed_users[i] = member;
                    }
                    i++;
                }
                warp.listed_users = new_listed_users;
                
                //Convert Owner
                if (!warp.owner.equals(old_username) && !warp.owner.equals(event.getPlayer().getUniqueId().toString())) continue;
                myUltraWarps.debug("found one of " + event.getPlayer().getName() + "'s warps: \"" + warp.name + "\"; updating owner...");
                warp.owner = event.getPlayer().getName();
                
            }
            for (UltraSwitch sw: switches) {
                if (!sw.warp_owner.equals(old_username) && !sw.warp_owner.equals(event.getPlayer().getUniqueId().toString())) continue;
                myUltraWarps.debug("found one of " + event.getPlayer().getName() + "'s switches: \"" + sw.warp_name + "\"; updating owner...");
                sw.warp_owner = event.getPlayer().getName();
            }
            
            //Updatin the UUID list
            //Alten Eintrag löschen
            this.UUIDs.remove(event.getPlayer().getName());
            //Neuen Eintrag erstellen
            this.UUIDs.put(event.getPlayer().getName(), event.getPlayer().getUniqueId());
            
        } else if (!this.UUIDs.containsKey(event.getPlayer().getName())) {
            myUltraWarps.debug("detected new player: " + event.getPlayer().getName() + "; logging UUID (" + event.getPlayer().getUniqueId() + ")...");
            this.UUIDs.put(event.getPlayer().getName(), event.getPlayer().getUniqueId());
            Iterator<UltraWarp> warp = warps.iterator();
            do {
                if (warp.hasNext()) {
                    UltraWarp warp2 = warp.next();
                    if (!warp2.owner.equals(event.getPlayer().getUniqueId().toString())) continue;
                    myUltraWarps.debug("found UUID owner corresponding to " + event.getPlayer().getName() + "; changing warp \"" + warp2.name + "\" owner...");
                    warp2.owner = event.getPlayer().getName();
                    continue;
                } else {
                    break;
                }
            } while (true);
        } else {
            myUltraWarps.debug("confirmed " + event.getPlayer().getName() + "'s UUID");
        }
    }

    @EventHandler
    public void teleportOnTargetChunkLoad(ChunkLoadEvent event) {
        for (String name2 : teleporting_players.keySet()) {
            if (server.getPlayerExact(name2) == null) {
                myUltraWarps.debug(String.valueOf(name2) + "'s target loaded for teleportation, but they were nowhere to be found.");
                teleporting_players.remove(name2);
                continue;
            }
            if (!((UltraWarp)myUltraWarps.teleporting_players.get((Object)name2)[0]).location.getChunk().equals((Object)event.getChunk())) continue;
            myUltraWarps.debug(String.valueOf(name2) + "'s target chunk loaded for teleportation!");
            Object[] objects = teleporting_players.get(name2);
            this.teleportPartII(server.getPlayerExact(name2), (UltraWarp)objects[0], (UltraWarp)objects[1], (Boolean)objects[2], (CommandSender)objects[3]);
            teleporting_players.remove(name2);
        }
        for (String name2 : spawning_players.keySet()) {
            if (server.getPlayerExact(name2) == null) {
                myUltraWarps.debug(String.valueOf(name2) + "'s target loaded for spawning, but they were nowhere to be found.");
                spawning_players.remove(name2);
                continue;
            }
            if (!spawning_players.get(name2).getChunk().equals((Object)event.getChunk())) continue;
            myUltraWarps.debug(String.valueOf(name2) + "'s target chunk loaded for spawning!");
            spawning_players.remove(name2);
            server.getScheduler().scheduleSyncDelayedTask(mUW, (Runnable)new myUltraWarps$1((CommandSender)server.getPlayerExact(name2), "perform teleportation", new Object[]{spawning_players.get(name2)}), 0);
        }
    }

    @EventHandler
    public void preventUnloadingOfTargetChunks(ChunkUnloadEvent event) {
        for (String name2 : teleporting_players.keySet()) {
            if (server.getPlayerExact(name2) == null) {
                myUltraWarps.debug(String.valueOf(name2) + "'s target for teleportation unloaded, but they were nowhere to be found.");
                teleporting_players.remove(name2);
                continue;
            }
            if (!((UltraWarp)myUltraWarps.teleporting_players.get((Object)name2)[0]).location.getChunk().equals((Object)event.getChunk())) continue;
            myUltraWarps.debug("I stopped the server from unloading the chunk that " + name2 + " was trying to teleport to.");
            event.setCancelled(true);
        }
        for (String name2 : spawning_players.keySet()) {
            if (server.getPlayerExact(name2) == null) {
                myUltraWarps.debug(String.valueOf(name2) + "'s target for spawning unloaded, but they were nowhere to be found.");
                spawning_players.remove(name2);
                continue;
            }
            if (!spawning_players.get(name2).getChunk().equals((Object)event.getChunk())) continue;
            myUltraWarps.debug("I stopped the server from unloading the chunk that " + name2 + " was trying to spawn in.");
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void fixFallSuffocationOnSpawn(PlayerJoinEvent event) {
        if (!event.getPlayer().getLocation().getChunk().isLoaded()) {
            myUltraWarps.debug(String.valueOf(event.getPlayer().getName()) + "'s target chunk for spawning hasn't been loaded yet; I'll load it and teleport them there when it's ready.");
            spawning_players.put(event.getPlayer().getName(), event.getPlayer().getLocation());
            if (!event.getPlayer().getLocation().getChunk().load()) {
                myUltraWarps.debug((Object)ChatColor.RED + "I couldn't load the target chunk!");
                event.getPlayer().kickPlayer((Object)ChatColor.RED + "I'm sorry, but I couldn't load the chunk that you're supposed to spawn in! Try again in a minute!");
            }
        } else {
            myUltraWarps.debug(String.valueOf(event.getPlayer().getName()) + "'s login chunk was already loaded.");
        }
    }

    @EventHandler
    public void stopSpawningPlayersFromTakingDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player && spawning_players.containsKey(((Player)event.getEntity()).getName())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void protectSpawningPlayers(EntityTargetEvent event) {
        if (event.getEntity() instanceof Player && spawning_players.containsKey(((Player)event.getEntity()).getName())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void informPlayersOfStuffAndRemoveTheirCoolingDownStatusIfNecessary(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPlayedBefore()) {
            event.getPlayer().sendMessage(myUltraWarps.colorCode(spawn_messages_by_world.get((Object)event.getPlayer().getWorld()).replaceAll("\\[player\\]", event.getPlayer().getName())));
        } else {
            if (event.getPlayer().hasPermission("myultrawarps.admin") && new File(this.getDataFolder(), "myUltraWarps.jar").exists()) {
                event.getPlayer().sendMessage((Object)COLOR + "myUltraWarps has been updated! You should put in the new version right now! I already downloaded it into the myUltraWarps plugin data folder (the place where you find the config.txt and stuff). All you have to do is stop the server and replace the myUltraWarps in the plugins folder with the new one.\nDo it now!");
            }
            if (debuggers.contains(event.getPlayer().getName())) {
                event.getPlayer().sendMessage((Object)COLOR + "Your debugging messages are still on for myUltraWarps!");
            } else if (info_messages_for_players.get(event.getPlayer().getName()) != null) {
                for (String message : info_messages_for_players.get(event.getPlayer().getName())) {
                    event.getPlayer().sendMessage(message);
                }
            }
            if (cooling_down_players.containsKey(event.getPlayer().getName()) && cooling_down_players.get(event.getPlayer().getName()) + this.getSettings(event.getPlayer()).cooldown < Calendar.getInstance().getTimeInMillis()) {
                cooling_down_players.remove(event.getPlayer().getName());
            }
        }
    }

    @EventHandler
    public void teleportToHomeOnRespawn(PlayerRespawnEvent event) {
        if (!(event.getPlayer().hasPermission("myultrawarps.respawnhome") || event.getPlayer().hasPermission("myultrawarps.user") || event.getPlayer().hasPermission("myultrawarps.admin") || this.getSettings(event.getPlayer()).home_on_death)) {
            return;
        }
        UltraWarp home = null;
        for (UltraWarp warp : warps) {
            if (!warp.owner.equals(event.getPlayer().getName()) || !warp.name.equals("home")) continue;
            home = warp;
        }
        if (home != null) {
            event.setRespawnLocation(home.location);
            event.getPlayer().sendMessage(myUltraWarps.colorCode(home.warp_message));
        } else {
            event.getPlayer().sendMessage((Object)ChatColor.RED + "I would teleport you to your home, but you haven't set one yet!");
        }
    }

    @EventHandler(priority=EventPriority.HIGH)
    public void warpViaSwitch(PlayerInteractEvent event) {
        if (warps != null && warps.size() > 0 && switches != null && switches.size() > 0) {
            Block target_block = event.getClickedBlock();
            UltraSwitch target = null;
            UltraWarp warp_target = null;
            if (target_block == null || UltraSwitch.getSwitchType(target_block) == null) {
                return;
            }
            for (UltraSwitch my_switch : switches) {
                if (!target_block.getLocation().equals((Object)my_switch.location) || (!my_switch.switch_type.equals("pressure plate") || !event.getAction().equals((Object)Action.PHYSICAL)) && (my_switch.switch_type.equals("pressure plate") || !event.getAction().equals((Object)Action.RIGHT_CLICK_BLOCK))) continue;
                target = my_switch;
                break;
            }
            if (target == null) {
                return;
            }
            if (target_block.getType() == Material.WALL_SIGN || target_block.getType() == Material.SIGN_POST) {
                event.setCancelled(true);
            }
            for (UltraWarp warp : warps) {
                if (!warp.owner.equals(target.warp_owner) || !warp.name.equals(target.warp_name)) continue;
                warp_target = warp;
            }
            if (warp_target == null) {
                event.getPlayer().sendMessage((Object)ChatColor.RED + "Uh...the warp this switch was linked to seems to have disappeared without my knowledge. Sorry. Talk to your server admin.");
                return;
            }
            boolean listed = false;
            for (String listed_user : warp_target.listed_users) {
                if (!listed_user.equals(event.getPlayer().getName())) continue;
                listed = true;
            }
            if (event.getPlayer().getName().equals(warp_target.owner) || !warp_target.restricted && !listed || warp_target.restricted && listed || event.getPlayer().hasPermission("myultrawarps.warptowarp.other") || event.getPlayer().hasPermission("myultrawarps.admin")) {
                String warp_name = warp_target.name;
                if (!warp_target.owner.equals(event.getPlayer().getName())) {
                    warp_name = String.valueOf(warp_target.owner) + "'s " + warp_target.name;
                }
                this.teleport(event.getPlayer(), new UltraWarp("God", "coordinates", false, false, "&aThis is the spot you were at before you warped to " + warp_name + ".", "", null, event.getPlayer().getLocation()), warp_target, true, null);
            } else {
                event.getPlayer().sendMessage(myUltraWarps.colorCode(warp_target.no_warp_message.replaceAll("\\[player\\]", event.getPlayer().getName())));
            }
        }
    }

    @EventHandler
    public void playerBrokeASwitch(BlockBreakEvent event) {
        if (warps != null && warps.size() > 0 && switches != null && switches.size() > 0 && UltraSwitch.getSwitchType(event.getBlock()) != null) {
            for (int i = 0; i < switches.size(); ++i) {
                if (!myUltraWarps.switches.get((int)i).location.equals((Object)event.getBlock().getLocation()) || !myUltraWarps.switches.get((int)i).switch_type.equals(UltraSwitch.getSwitchType(event.getBlock()))) continue;
                if ((event.getPlayer().hasPermission("myultrawarps.unlink") || event.getPlayer().hasPermission("myultrawarps.user")) && myUltraWarps.switches.get((int)i).warp_owner.equals(event.getPlayer().getName())) {
                    event.getPlayer().sendMessage((Object)COLOR + "You unlinked \"" + myUltraWarps.switches.get((int)i).warp_name + "\" from this " + UltraSwitch.getSwitchType(event.getBlock()) + ".");
                    switches.remove(i);
                    continue;
                }
                if (event.getPlayer().hasPermission("myultrawarps.unlink.other") || event.getPlayer().hasPermission("myultrawarps.admin")) {
                    event.getPlayer().sendMessage((Object)COLOR + "You unlinked " + myUltraWarps.switches.get((int)i).warp_owner + "'s " + myUltraWarps.switches.get((int)i).switch_type + " that was linked to \"" + myUltraWarps.switches.get((int)i).warp_name + ".\"");
                    boolean owner_found = false;
                    for (Player player : server.getOnlinePlayers()) {
                        if (!player.getName().equals(myUltraWarps.switches.get((int)i).warp_owner)) continue;
                        owner_found = true;
                        player.sendMessage((Object)ChatColor.RED + event.getPlayer().getName() + " broke your " + myUltraWarps.switches.get((int)i).switch_type + " at (" + myUltraWarps.switches.get((int)i).x + ", " + myUltraWarps.switches.get((int)i).y + ", " + myUltraWarps.switches.get((int)i).z + ") in \"" + myUltraWarps.switches.get((int)i).world.getName() + ".\"");
                    }
                    if (!owner_found) {
                        ArrayList messages = info_messages_for_players.get(myUltraWarps.switches.get((int)i).warp_owner);
                        if (messages == null) {
                            messages = new ArrayList();
                        }
                        messages.add((Object)ChatColor.RED + event.getPlayer().getName() + " broke your " + myUltraWarps.switches.get((int)i).switch_type + " at (" + myUltraWarps.switches.get((int)i).x + ", " + myUltraWarps.switches.get((int)i).y + ", " + myUltraWarps.switches.get((int)i).z + ") in \"" + myUltraWarps.switches.get((int)i).world.getName() + ".\"");
                        info_messages_for_players.put(myUltraWarps.switches.get((int)i).warp_owner, messages);
                    }
                    switches.remove(i);
                    continue;
                }
                event.setCancelled(true);
                event.getPlayer().sendMessage((Object)ChatColor.RED + "This switch doesn't belong to you. You're not allowed to break it.");
            }
        }
    }

    @EventHandler
    public void explosionBrokeASwitch(EntityExplodeEvent event) {
        if (warps != null && warps.size() > 0 && switches != null && switches.size() > 0) {
            for (int i = 0; i < event.blockList().size(); ++i) {
                if (UltraSwitch.getSwitchType((Block)event.blockList().get(i)) == null) continue;
                for (int j = 0; j < switches.size(); ++j) {
                    if (!myUltraWarps.switches.get((int)j).location.equals((Object)((Block)event.blockList().get(i)).getLocation()) || !myUltraWarps.switches.get((int)j).switch_type.equals(UltraSwitch.getSwitchType((Block)event.blockList().get(i)))) continue;
                    String cause = "An explosion of some sort";
                    if (event.getEntityType() == null) {
                        cause = "Some genius trying to use a bed in the Nether";
                    } else if (event.getEntityType() == EntityType.CREEPER) {
                        cause = "A creeper";
                    } else if (event.getEntityType() == EntityType.FIREBALL) {
                        cause = "A Ghast";
                    } else if (event.getEntityType() == EntityType.PRIMED_TNT) {
                        cause = "A T.N.T. blast";
                    }
                    boolean owner_found = false;
                    for (Player player : server.getOnlinePlayers()) {
                        if (!player.getName().equals(myUltraWarps.switches.get((int)j).warp_owner)) continue;
                        owner_found = true;
                        player.sendMessage((Object)ChatColor.RED + "Your " + myUltraWarps.switches.get((int)j).switch_type + " at (" + myUltraWarps.switches.get((int)j).x + ", " + myUltraWarps.switches.get((int)j).y + ", " + myUltraWarps.switches.get((int)j).z + ") in \"" + myUltraWarps.switches.get((int)j).world.getName() + "\" linked to \"" + myUltraWarps.switches.get((int)j).warp_name + "\" was broken by " + cause + "!");
                        break;
                    }
                    if (!owner_found) {
                        ArrayList messages = info_messages_for_players.get(myUltraWarps.switches.get((int)j).warp_owner);
                        if (messages == null) {
                            messages = new ArrayList();
                        }
                        messages.add((Object)ChatColor.RED + cause + " broke your " + myUltraWarps.switches.get((int)j).switch_type + " at (" + myUltraWarps.switches.get((int)j).x + ", " + myUltraWarps.switches.get((int)j).y + ", " + myUltraWarps.switches.get((int)j).z + ") in \"" + myUltraWarps.switches.get((int)j).world.getName() + ".\"");
                        info_messages_for_players.put(myUltraWarps.switches.get((int)j).warp_owner, messages);
                    }
                    switches.remove(j);
                }
            }
        }
    }

    @EventHandler(priority=EventPriority.LOWEST)
    public void readTeleportAcceptancesOrRefusals(AsyncPlayerChatEvent event) {
        if (to_teleport_requests.get(event.getPlayer().getName()) != null && to_teleport_requests.get(event.getPlayer().getName()).size() > 0) {
            Player teleporting_player = null;
            for (Player player : server.getOnlinePlayers()) {
                if (!player.getName().equals(to_teleport_requests.get(event.getPlayer().getName()).get(0))) continue;
                teleporting_player = player;
                break;
            }
            if (teleporting_player == null) {
                event.getPlayer().sendMessage((Object)ChatColor.RED + to_teleport_requests.get(event.getPlayer().getName()).get(0) + " must have gone offline. Sorry.");
                event.setCancelled(true);
                ArrayList<String> requesting_players = to_teleport_requests.get(event.getPlayer().getName());
                if (requesting_players == null) {
                    requesting_players = new ArrayList();
                } else {
                    String remove = requesting_players.get(0);
                    while (requesting_players.contains(remove)) {
                        requesting_players.remove(remove);
                    }
                }
                to_teleport_requests.put(event.getPlayer().getName(), requesting_players);
                return;
            }
            Boolean accepted = myUltraWarps.getResponse((CommandSender)event.getPlayer(), event.getMessage(), null, null);
            if (accepted != null && accepted.booleanValue()) {
                ArrayList<String> requesting_players;
                event.setCancelled(true);
                if (this.teleport(teleporting_player, new UltraWarp("God", "coordinates", false, false, "&aThis is the spot you were at before you teleported to " + event.getPlayer().getName() + ".", "", null, teleporting_player.getLocation()), new UltraWarp("God", "coordinates", false, false, "&aThis is the spot you were at when you teleported to " + event.getPlayer().getName() + ".", "", null, event.getPlayer().getLocation()), false, (CommandSender)event.getPlayer())) {
                    teleporting_player.sendMessage((Object)COLOR + event.getPlayer().getName() + " said \"" + event.getMessage() + "\"!");
                    event.getPlayer().sendMessage((Object)COLOR + "Cool. I'll go get " + teleporting_player.getName() + ".");
                }
                if ((requesting_players = to_teleport_requests.get(event.getPlayer().getName())) == null) {
                    requesting_players = new ArrayList();
                } else {
                    String remove = requesting_players.get(0);
                    while (requesting_players.contains(remove)) {
                        requesting_players.remove(remove);
                    }
                }
                to_teleport_requests.put(event.getPlayer().getName(), requesting_players);
            } else if (accepted != null) {
                event.setCancelled(true);
                if (!(event.getMessage().endsWith(".") || event.getMessage().endsWith("!") || event.getMessage().endsWith("?"))) {
                    event.getPlayer().sendMessage((Object)COLOR + "Okay. I'll tell " + teleporting_player.getName() + " that you said \"" + event.getMessage() + ".\"");
                    teleporting_player.sendMessage((Object)ChatColor.RED + "Sorry, but " + event.getPlayer().getName() + " said \"" + event.getMessage() + ".\"");
                } else {
                    event.getPlayer().sendMessage((Object)COLOR + "Okay. I'll tell " + teleporting_player.getName() + " that you said \"" + event.getMessage() + "\"");
                    teleporting_player.sendMessage((Object)ChatColor.RED + "Sorry, but " + event.getPlayer().getName() + " said \"" + event.getMessage() + "\"");
                }
                ArrayList<String> requesting_players = to_teleport_requests.get(event.getPlayer().getName());
                if (requesting_players == null) {
                    requesting_players = new ArrayList();
                } else {
                    String remove = requesting_players.get(0);
                    while (requesting_players.contains(remove)) {
                        requesting_players.remove(remove);
                    }
                }
                to_teleport_requests.put(event.getPlayer().getName(), requesting_players);
            }
        } else if (from_teleport_requests.get(event.getPlayer().getName()) != null && from_teleport_requests.get(event.getPlayer().getName()).size() > 0) {
            Player non_teleporting_player = server.getPlayer(from_teleport_requests.get(event.getPlayer().getName()).get(0));
            if (non_teleporting_player == null) {
                event.getPlayer().sendMessage((Object)ChatColor.RED + from_teleport_requests.get(event.getPlayer().getName()).get(0) + " must have gone offline. Sorry.");
                event.setCancelled(true);
                ArrayList<String> requesting_players = from_teleport_requests.get(event.getPlayer().getName());
                if (requesting_players == null) {
                    requesting_players = new ArrayList();
                } else {
                    String remove = requesting_players.get(0);
                    while (requesting_players.contains(remove)) {
                        requesting_players.remove(remove);
                    }
                }
                from_teleport_requests.put(event.getPlayer().getName(), requesting_players);
                return;
            }
            Boolean accepted = myUltraWarps.getResponse((CommandSender)event.getPlayer(), event.getMessage(), null, null);
            if (accepted != null && accepted.booleanValue()) {
                ArrayList<String> requesting_players;
                event.setCancelled(true);
                if (this.teleport(event.getPlayer(), new UltraWarp("God", "coordinates", false, false, "&aThis is the spot you were at before " + non_teleporting_player.getName() + " teleported you to them.", "", null, event.getPlayer().getLocation()), new UltraWarp("God", "coordinates", false, false, "&aThis is the spot you were at when you were teleported to " + non_teleporting_player.getName() + ".", "", null, non_teleporting_player.getLocation()), false, (CommandSender)non_teleporting_player)) {
                    event.getPlayer().sendMessage((Object)COLOR + "Here's your " + non_teleporting_player.getName() + "!");
                    non_teleporting_player.sendMessage((Object)COLOR + "Look! I brought you a " + event.getPlayer().getName() + "!");
                }
                if ((requesting_players = from_teleport_requests.get(event.getPlayer().getName())) == null) {
                    requesting_players = new ArrayList();
                } else {
                    String remove = requesting_players.get(0);
                    while (requesting_players.contains(remove)) {
                        requesting_players.remove(remove);
                    }
                }
                from_teleport_requests.put(event.getPlayer().getName(), requesting_players);
            } else if (accepted != null) {
                event.setCancelled(true);
                if (!(event.getMessage().endsWith(".") || event.getMessage().endsWith("!") || event.getMessage().endsWith("?"))) {
                    event.getPlayer().sendMessage((Object)COLOR + "Okay. I'll tell " + non_teleporting_player.getName() + " that you said \"" + event.getMessage() + ".\"");
                    non_teleporting_player.sendMessage((Object)ChatColor.RED + "Sorry, but " + event.getPlayer().getName() + " said \"" + event.getMessage() + ".\"");
                } else {
                    event.getPlayer().sendMessage((Object)COLOR + "Okay. I'll tell " + non_teleporting_player.getName() + " that you said \"" + event.getMessage() + "\"");
                    non_teleporting_player.sendMessage((Object)ChatColor.RED + "Sorry, but " + event.getPlayer().getName() + " said \"" + event.getMessage() + "\"");
                }
                ArrayList<String> requesting_players = from_teleport_requests.get(event.getPlayer().getName());
                if (requesting_players == null) {
                    requesting_players = new ArrayList();
                } else {
                    String remove = requesting_players.get(0);
                    while (requesting_players.contains(remove)) {
                        requesting_players.remove(remove);
                    }
                }
                from_teleport_requests.put(event.getPlayer().getName(), requesting_players);
            }
        }
    }

    @EventHandler
    public void trackDeathHistories(PlayerDeathEvent event) {
        ArrayList replacement = death_histories.get(event.getEntity().getName());
        if (replacement == null) {
            replacement = new ArrayList();
        }
        replacement.add((Location)event.getEntity().getLocation());
        while (replacement.size() > this.getSettings(event.getEntity()).death_history_length) {
            replacement.remove(0);
        }
        death_histories.put(event.getEntity().getName(), replacement);
        last_warp_to_death_indexes.put(event.getEntity().getName(), replacement.size() - 1);
    }

    private void oldVehiclePortalFixingCode() {
    }

    private void loadTheWarps(CommandSender sender) {
        warps = new ArrayList();
        File warps_file = new File(this.getDataFolder(), "warps.txt");
        try {
            if (!warps_file.exists()) {
                this.getDataFolder().mkdir();
                console.sendMessage((Object)COLOR + "I couldn't find a warps.txt file. I'll make a new one.");
                warps_file.createNewFile();
                return;
            }
            BufferedReader in = new BufferedReader(new FileReader(warps_file));
            String save_line = in.readLine();
            while (save_line != null) {
                if (!(save_line = save_line.trim()).equals("")) {
                    warps.add(new UltraWarp(save_line));
                }
                save_line = in.readLine();
            }
            in.close();
            if (warps.size() > 1) {
                ArrayList<UltraWarp> temp_warps = new ArrayList<UltraWarp>();
                for (UltraWarp warp : warps) {
                    temp_warps.add(warp);
                }
                warps = new ArrayList();
                while (temp_warps.size() > 0) {
                    UltraWarp first_warp = (UltraWarp)temp_warps.get(0);
                    int delete_index = 0;
                    for (int j = 0; j < temp_warps.size(); ++j) {
                        if (((UltraWarp)temp_warps.get((int)j)).name.compareToIgnoreCase(first_warp.name) >= 0 && (((UltraWarp)temp_warps.get((int)j)).name.compareToIgnoreCase(first_warp.name) != 0 || ((UltraWarp)temp_warps.get((int)j)).owner.compareToIgnoreCase(first_warp.owner) >= 0)) continue;
                        first_warp = (UltraWarp)temp_warps.get(j);
                        delete_index = j;
                    }
                    if (!(first_warp.name.equalsIgnoreCase("info") || first_warp.name.equalsIgnoreCase("all") || first_warp.name.equalsIgnoreCase("list"))) {
                        warps.add(first_warp);
                    } else {
                        UltraWarp renamed_first_warp = new UltraWarp(first_warp.owner, "my" + first_warp.name, first_warp.listed, first_warp.restricted, first_warp.warp_message, first_warp.no_warp_message, first_warp.listed_users, first_warp.location);
                        warps.add(renamed_first_warp);
                        boolean found = false;
                        for (Player renamed_warp_owner : server.getOnlinePlayers()) {
                            if (!renamed_warp_owner.getName().equals(first_warp.owner)) continue;
                            renamed_warp_owner.sendMessage((Object)ChatColor.RED + "I found a warp of yours that was named \"" + first_warp.name + ".\" Unfortunately, it interferes with the command " + (Object)COLOR + "/warp " + first_warp.name + (Object)ChatColor.RED + ", so I had to rename it \"my" + first_warp.name + ".\" Sorry for the inconvenience.");
                            found = true;
                        }
                        if (!found) {
                            ArrayList messages = info_messages_for_players.get(first_warp.owner);
                            if (messages == null) {
                                messages = new ArrayList();
                            }
                            messages.add((Object)ChatColor.RED + "I found a warp of yours that was named \"" + first_warp.name + ".\" Unfortunately, it interferes with the command " + (Object)COLOR + "/warp " + first_warp.name + (Object)ChatColor.RED + ", so I had to rename it \"my" + first_warp.name + ".\" Sorry for the inconvenience.");
                            info_messages_for_players.put(first_warp.owner, messages);
                        }
                    }
                    temp_warps.remove(delete_index);
                }
            }
            this.saveTheWarps(sender, false);
        }
        catch (IOException exception) {
            myUltraWarps.processException("I got an IOException while trying to save your warps.", exception);
            return;
        }
        if (warps.size() > 1) {
            sender.sendMessage((Object)COLOR + "Your " + warps.size() + " warps have been loaded.");
        } else if (warps.size() == 1) {
            sender.sendMessage((Object)COLOR + "Your 1 warp has been loaded.");
        } else {
            sender.sendMessage((Object)COLOR + "You have no warps to load!");
        }
        if (sender instanceof Player) {
            if (warps.size() > 1) {
                console.sendMessage((Object)COLOR + ((Player)sender).getName() + " loaded " + warps.size() + " warps from file.");
            } else if (warps.size() == 1) {
                console.sendMessage((Object)COLOR + ((Player)sender).getName() + " loaded the server's 1 warp from file.");
            } else {
                console.sendMessage((Object)COLOR + ((Player)sender).getName() + " loaded the server's warps from file, but there were no warps on file.");
            }
        }
    }

    private void loadTheSwitches(CommandSender sender) {
        switches = new ArrayList();
        File switches_file = new File(this.getDataFolder(), "switches.txt");
        try {
            if (!switches_file.exists()) {
                this.getDataFolder().mkdir();
                sender.sendMessage((Object)COLOR + "I couldn't find a switches.txt file. I'll make a new one.");
                switches_file.createNewFile();
                return;
            }
            BufferedReader in = new BufferedReader(new FileReader(switches_file));
            String save_line = in.readLine();
            while (save_line != null) {
                if (!(save_line = save_line.trim()).equals("")) {
                    switches.add(new UltraSwitch(save_line));
                }
                save_line = in.readLine();
            }
            in.close();
        }
        catch (IOException exception) {
            myUltraWarps.processException("I got you a present. It's an IOEcxeption in config.txt.", exception);
            return;
        }
        if (switches.size() > 1) {
            ArrayList<UltraSwitch> temp_switches = new ArrayList<UltraSwitch>();
            for (UltraSwitch my_switch : switches) {
                temp_switches.add(my_switch);
            }
            switches = new ArrayList();
            while (temp_switches.size() > 0) {
                UltraSwitch first_switch = (UltraSwitch)temp_switches.get(0);
                int delete_index = 0;
                for (int j = 0; j < temp_switches.size(); ++j) {
                    if (((UltraSwitch)temp_switches.get((int)j)).warp_name.compareToIgnoreCase(first_switch.warp_name) >= 0 && (((UltraSwitch)temp_switches.get((int)j)).warp_name.compareToIgnoreCase(first_switch.warp_name) != 0 || ((UltraSwitch)temp_switches.get((int)j)).warp_owner.compareToIgnoreCase(first_switch.warp_owner) >= 0)) continue;
                    first_switch = (UltraSwitch)temp_switches.get(j);
                    delete_index = j;
                }
                switches.add(first_switch);
                temp_switches.remove(delete_index);
            }
        }
        this.saveTheSwitches(sender, false);
        if (switches.size() > 1) {
            sender.sendMessage((Object)COLOR + "Your " + switches.size() + " switches have been loaded.");
        } else if (switches.size() == 1) {
            sender.sendMessage((Object)COLOR + "Your 1 switch has been loaded.");
        } else {
            sender.sendMessage((Object)COLOR + "You have no switches to load!");
        }
        if (sender instanceof Player) {
            if (switches.size() > 1) {
                console.sendMessage((Object)COLOR + ((Player)sender).getName() + " loaded " + warps.size() + " switches from file.");
            } else if (switches.size() == 1) {
                console.sendMessage((Object)COLOR + ((Player)sender).getName() + " loaded the server's 1 switch from file.");
            } else {
                console.sendMessage((Object)COLOR + ((Player)sender).getName() + " loaded the server's switches from file, but there were no switches on file.");
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Lifted jumps to return sites
     */
  private void loadTheConfig(CommandSender sender)
  {
    Vault = server.getPluginManager().getPlugin("Vault");
    if (Vault != null)
    {
      try
      {
        permissions = (Permission)server.getServicesManager().getRegistration(Permission.class).getProvider();
      }
      catch (NullPointerException exception)
      {
        permissions = null;
      }
      try
      {
        economy = (Economy)server.getServicesManager().getRegistration(Economy.class).getProvider();
      }
      catch (NullPointerException exception)
      {
        economy = null;
      }
      if (permissions != null)
      {
        Plugin permissions_plugin = server.getPluginManager().getPlugin(permissions.getName());
        if ((permissions_plugin != null) && (!permissions_plugin.isEnabled())) {
          server.getPluginManager().enablePlugin(permissions_plugin);
        }
      }
      console.sendMessage(COLOR + "I see your Vault...");
      if ((permissions == null) && (economy == null))
      {
        console.sendMessage(ChatColor.RED + "...but I can't find any economy or permissions plugins.");
      }
      else if (permissions != null)
      {
        console.sendMessage(COLOR + "...and raise you a " + permissions.getName() + "...");
        if (economy != null) {
          console.sendMessage(COLOR + "...as well as a " + economy.getName() + ".");
        } else {
          console.sendMessage(ChatColor.RED + "...but I can't find your economy plugin.");
        }
      }
      else if ((permissions == null) && (economy != null))
      {
        console.sendMessage(COLOR + "...and raise you a " + economy.getName() + "...");
        console.sendMessage(ChatColor.RED + "...but I can't find your permissions plugin.");
      }
    }
    settings = new HashMap();
    spawn_messages_by_world = new HashMap();
    for (World world : server.getWorlds())
    {
      String world_name = world.getName();
      if (world_name.endsWith("_nether")) {
        world_name = "The Nether";
      } else if (world_name.endsWith("_the_end")) {
        world_name = "The End";
      }
      spawn_messages_by_world.put(world, "&aWelcome to " + world_name + ", [player]!");
    }
    File config_file = new File(getDataFolder(), "config.txt");
    String save_line;
    try
    {
      if (!config_file.exists())
      {
        getDataFolder().mkdir();
        sender.sendMessage(COLOR + "I couldn't find a config.txt file. I'll make a new one.");
        config_file.createNewFile();
        saveTheConfig(sender, false);
        return;
      }
      BufferedReader in = new BufferedReader(new FileReader(config_file));
      save_line = in.readLine();String parsing = "";String parsing_group = null;String parsing_player = null;
      while (save_line != null)
      {
        while ((save_line != null) && (save_line.trim().equals("")))
        {
          debug("skipped empty save line: \"" + ChatColor.WHITE + save_line + COLOR + "\"");
          save_line = in.readLine();
        }
        if (save_line == null) {
          break;
        }
        save_line = save_line.trim();
        debug("\"" + ChatColor.WHITE + save_line + COLOR + "\"");
        if (save_line.startsWith("Do you want to be able to change settings for permissions-based groups of users?"))
        {
          use_group_settings = getResponse(sender, save_line.substring(80), in.readLine(), "Group settings are enabled").booleanValue();
          debug("retrieved use group settings setting: " + use_group_settings);
        }
        else if (save_line.startsWith("Do you want myUltraWarps to check for updates every time it is enabled?"))
        {
          auto_update = getResponse(sender, save_line.substring(71), in.readLine(), "Right now, myUltraWarps will auto-update.").booleanValue();
          debug("retrieved auto update setting: " + auto_update);
        }
        else if (save_line.startsWith("Do you want myUltraWarps to automatically save the warps file every time a change is made?"))
        {
          autosave_warps = getResponse(sender, save_line.substring(90), in.readLine(), "Right now, autosave is on for warps.").booleanValue();
          debug("retrieved autosave warps setting: " + autosave_warps);
        }
        else if (save_line.startsWith("Do you want myUltraWarps to automatically save the switches file every time a change is made?"))
        {
          autosave_switches = getResponse(sender, save_line.substring(93), in.readLine(), "Right now, autosave is on for switches.").booleanValue();
          debug("retrieved autosave switches setting: " + autosave_switches);
        }
        else if (save_line.startsWith("Do you want myUltraWarps to automatically save the config file every time a change is made?"))
        {
          autosave_config = getResponse(sender, save_line.substring(91), in.readLine(), "Right now, autosave is on for the config.").booleanValue();
          debug("retrieved autosave config setting: " + autosave_config);
        }
        else if (save_line.startsWith("You can set the messages that appear when someone teleports to the spawn point for each world here."))
        {
          parsing = "spawn messages";
          debug("began parsing spawn messages");
          save_line = in.readLine();
          debug("\"" + ChatColor.WHITE + save_line + COLOR + "\"");
        }
        else if (save_line.startsWith("global settings:"))
        {
          parsing = "global";
          debug("began parsing global settings");
          save_line = save_line.substring(16);
          debug("\"" + ChatColor.WHITE + save_line + COLOR + "\"");
        }
        else if (save_line.startsWith("group settings:"))
        {
          parsing = "group";
          debug("began parsing group settings");
          save_line = save_line.substring(15);
          debug("\"" + ChatColor.WHITE + save_line + COLOR + "\"");
        }
        else if (save_line.startsWith("individual settings:"))
        {
          parsing = "individual";
          debug("began parsing individual settings");
          save_line = save_line.substring(20);
          debug("\"" + ChatColor.WHITE + save_line + COLOR + "\"");
        }
        while ((save_line != null) && (save_line.trim().equals("")))
        {
          debug("skipped empty save line: \"" + ChatColor.WHITE + save_line + COLOR + "\"");
          save_line = in.readLine();
        }
        if (save_line == null) {
          break;
        }
        save_line = save_line.trim();
        debug("\"" + ChatColor.WHITE + save_line + COLOR + "\"");
        if (parsing.equals("spawn messages"))
        {
          String[] temp = save_line.split(":");
          String world_name = temp[0];String spawn_message = temp[1].trim();
          if (!world_name.equals(""))
          {
            if (world_name.endsWith(" (The Nether)")) {
              world_name = world_name.substring(0, world_name.length() - 13) + "_nether";
            } else if (world_name.endsWith(" (The End)")) {
              world_name = world_name.substring(0, world_name.length() - 10) + "_the_end";
            }
            World world = server.getWorld(world_name);
            if (world != null)
            {
              spawn_messages_by_world.put(world, spawn_message);
              debug("read world spawn message for " + world_name + ": \"" + spawn_message + "\"");
            }
            else
            {
              sender.sendMessage(ChatColor.RED + "I've never heard of a world called \"" + temp[0] + ".\"");
              debug(ChatColor.DARK_RED + "could not find world \"" + ChatColor.WHITE + temp[0] + ChatColor.DARK_RED + "\"");
            }
          }
        }
        else if (parsing.equals("global"))
        {
          SettingsSet global_set = (SettingsSet)settings.get("[server]");
          if (global_set == null) {
            global_set = new SettingsSet();
          }
          if (save_line.startsWith("Do you want players to automatically teleport to their homes when they respawn?"))
          {
            global_set = 
              global_set.setHomeOnDeath(getResponse(sender, save_line.substring(79), in.readLine(), 
              "Right now, players automatically teleport home after they die.").booleanValue());
            debug("read home on death global setting: " + global_set.home_on_death);
          }
          else if (save_line.toLowerCase().startsWith("default warp message: "))
          {
            global_set = global_set.setDefaultWarpMessage(save_line.substring(22));
            debug("read default warp message global setting: " + global_set.default_warp);
          }
          else if (save_line.toLowerCase().startsWith("default no warp message: "))
          {
            global_set = global_set.setDefaultNoWarpMessage(save_line.substring(25));
            debug("read default no warp message global setting: " + global_set.default_no_warp);
          }
          else if (save_line.toLowerCase().startsWith("max warps: "))
          {
            try
            {
              global_set = global_set.setMaxWarps(Integer.parseInt(save_line.substring(11)));
              debug("read max warps global setting: " + global_set.max_warps);
            }
            catch (NumberFormatException exception)
            {
              if (save_line.substring(11).equalsIgnoreCase("infinite"))
              {
                global_set = global_set.setMaxWarps(-1);
              }
              else
              {
                sender.sendMessage(ChatColor.RED + "There was an error in your global settings.");
                sender.sendMessage(ChatColor.RED + "The maximum number of warps that someone can have has to be an integer or \"infinite.\"");
              }
            }
          }
          else if (save_line.toLowerCase().startsWith("cool down time: "))
          {
            global_set = global_set.setCooldownTime(readTime(save_line.substring(16)));
            debug("read cool down time global setting: " + global_set.cooldown);
          }
          else if (save_line.toLowerCase().startsWith("warp history length: "))
          {
            try
            {
              global_set = global_set.setWarpHistoryLength(Integer.parseInt(save_line.substring(21)));
              debug("read warp history length global setting: " + global_set.warp_history_length);
            }
            catch (NumberFormatException exception)
            {
              if (save_line.substring(21).equalsIgnoreCase("infinite"))
              {
                global_set = global_set.setWarpHistoryLength(-1);
              }
              else
              {
                sender.sendMessage(ChatColor.RED + "There was an error in your global settings.");
                sender.sendMessage(ChatColor.RED + "The warp history length has to be an integer or \"infinite.\"");
              }
            }
          }
          else if (save_line.toLowerCase().startsWith("death history length: "))
          {
            try
            {
              global_set = global_set.setDeathHistoryLength(Integer.parseInt(save_line.substring(22)));
              debug("read death history length global setting: " + global_set.death_history_length);
            }
            catch (NumberFormatException exception)
            {
              if (save_line.substring(22).equalsIgnoreCase("infinite"))
              {
                global_set = global_set.setDeathHistoryLength(-1);
              }
              else
              {
                sender.sendMessage(ChatColor.RED + "There was an error in your global settings.");
                sender.sendMessage(ChatColor.RED + "The death history length has to be an integer or \"infinite.\"");
              }
            }
          }
          settings.put("[server]", global_set);
        }
        else if ((parsing.equals("group")) && (use_group_settings) && (permissions != null))
        {
          if (!save_line.split(":")[0].contains(" ")) {
            if (save_line.endsWith(":"))
            {
              parsing_group = save_line.substring(0, save_line.length() - 1);
              save_line = in.readLine();
            }
            else if (save_line.split(":").length > 1)
            {
              parsing_group = save_line.split(":")[0];
              save_line = save_line.split(":")[1];
              while (save_line.startsWith(" ")) {
                save_line = save_line.substring(1);
              }
            }
          }
          if ((parsing_group != null) && (!parsing_group.equals("")))
          {
            SettingsSet group_set = (SettingsSet)settings.get("[" + parsing_group + "]");
            if (group_set == null) {
              if (settings.get("[server]") != null) {
                group_set = (SettingsSet)settings.get("[server]");
              } else {
                group_set = new SettingsSet();
              }
            }
            save_line = save_line.trim();
            if (save_line.startsWith("Do you want players in this group to automatically teleport to their homes when they respawn?")) {
              group_set = 
                group_set.setHomeOnDeath(getResponse(sender, save_line.substring(93), in.readLine(), 
                "Right now, players in this group automatically teleport home after they die.").booleanValue());
            } else if (save_line.toLowerCase().startsWith("default warp message: ")) {
              group_set = group_set.setDefaultWarpMessage(save_line.substring(22));
            } else if (save_line.toLowerCase().startsWith("default no warp message: ")) {
              group_set = group_set.setDefaultNoWarpMessage(save_line.substring(25));
            } else if (save_line.toLowerCase().startsWith("max warps: ")) {
              try
              {
                group_set = group_set.setMaxWarps(Integer.parseInt(save_line.substring(11)));
              }
              catch (NumberFormatException exception)
              {
                if (save_line.substring(11).equalsIgnoreCase("infinite")) {
                  group_set = group_set.setMaxWarps(-1);
                } else {
                  sender.sendMessage(ChatColor.RED + 
                    "There was an error in your group settings.\nThe maximum number of warps that someone can have has to be an integer or \"infinite.\"");
                }
              }
            } else if (save_line.toLowerCase().startsWith("cool down time: ")) {
              group_set = group_set.setCooldownTime(readTime(save_line.substring(16)));
            } else if (save_line.toLowerCase().startsWith("warp history length: ")) {
              try
              {
                group_set = group_set.setWarpHistoryLength(Integer.parseInt(save_line.substring(21)));
              }
              catch (NumberFormatException exception)
              {
                if (save_line.substring(21).equalsIgnoreCase("infinite")) {
                  group_set = group_set.setWarpHistoryLength(-1);
                } else {
                  sender.sendMessage(ChatColor.RED + "There was an error in your group settings.\nThe warp history length to be an integer or \"infinite.\"");
                }
              }
            } else if (save_line.toLowerCase().startsWith("death history length: ")) {
              try
              {
                group_set = group_set.setDeathHistoryLength(Integer.parseInt(save_line.substring(22)));
              }
              catch (NumberFormatException exception)
              {
                if (save_line.substring(22).equalsIgnoreCase("infinite")) {
                  group_set = group_set.setDeathHistoryLength(-1);
                } else {
                  sender.sendMessage(ChatColor.RED + 
                    "There was an error in your group settings.\nThe death history length has to be an integer or \"infinite.\"");
                }
              }
            }
            settings.put("[" + parsing_group + "]", group_set);
          }
        }
        else if (parsing.equals("individual"))
        {
          if (!save_line.split(":")[0].contains(" ")) {
            if (save_line.endsWith(":"))
            {
              parsing_player = save_line.substring(0, save_line.length() - 1);
              save_line = in.readLine();
            }
            else if (save_line.split(":").length > 1)
            {
              parsing_player = save_line.split(":")[0];
              save_line = save_line.split(":")[1];
              while (save_line.startsWith(" ")) {
                save_line = save_line.substring(1);
              }
            }
          }
          if ((parsing_player != null) && (!parsing_player.equals("")) && (!parsing_player.equals("1mAnExampl3")))
          {
            SettingsSet player_set = (SettingsSet)settings.get(parsing_player);
            if (player_set == null) {
              if ((use_group_settings) && (permissions != null) && (permissions.getPrimaryGroup(parsing_player, null) != null) && 
                (settings.get(permissions.getPrimaryGroup(parsing_player, null)) != null)) {
                player_set = (SettingsSet)settings.get(permissions.getPrimaryGroup(parsing_player, null));
              } else if (settings.get("[server]") != null) {
                player_set = (SettingsSet)settings.get("[server]");
              } else {
                player_set = new SettingsSet();
              }
            }
            while (save_line.startsWith(" ")) {
              save_line = save_line.substring(1);
            }
            if (save_line.startsWith("Do you want " + parsing_player + " to automatically teleport to their home when they respawn?")) {
              player_set = 
                player_set.setHomeOnDeath(getResponse(sender, save_line.substring(71 + parsing_player.length()), in.readLine(), "Right now, " + 
                parsing_player + " automatically teleports home after they die.").booleanValue());
            } else if (save_line.toLowerCase().startsWith("default warp message: ")) {
              player_set = player_set.setDefaultWarpMessage(save_line.substring(22));
            } else if (save_line.toLowerCase().startsWith("default no warp message: ")) {
              player_set = player_set.setDefaultNoWarpMessage(save_line.substring(25));
            } else if (save_line.toLowerCase().startsWith("max warps: ")) {
              try
              {
                player_set = player_set.setMaxWarps(Integer.parseInt(save_line.substring(11)));
              }
              catch (NumberFormatException exception)
              {
                if (save_line.substring(11).equalsIgnoreCase("infinite"))
                {
                  player_set = player_set.setMaxWarps(-1);
                }
                else
                {
                  sender.sendMessage(ChatColor.RED + "There was an error in your individual settings.");
                  sender.sendMessage(ChatColor.RED + "The maximum number of warps that someone can have has to be an integer or \"infinite.\"");
                }
              }
            } else if (save_line.toLowerCase().startsWith("cool down time: ")) {
              player_set = player_set.setCooldownTime(readTime(save_line.substring(16)));
            } else if (save_line.toLowerCase().startsWith("warp history length: ")) {
              try
              {
                player_set = player_set.setWarpHistoryLength(Integer.parseInt(save_line.substring(21)));
              }
              catch (NumberFormatException exception)
              {
                if (save_line.substring(21).equalsIgnoreCase("infinite"))
                {
                  player_set = player_set.setWarpHistoryLength(-1);
                }
                else
                {
                  sender.sendMessage(ChatColor.RED + "There was an error in your individual settings.");
                  sender.sendMessage(ChatColor.RED + "The warp history length has to be an integer or \"infinite.\"");
                  sender.sendMessage(ChatColor.RED + "I'm setting the warp history length for " + parsing_player + " to \"infinite.\"");
                }
              }
            } else if (save_line.toLowerCase().startsWith("death history length: ")) {
              try
              {
                player_set = player_set.setDeathHistoryLength(Integer.parseInt(save_line.substring(22)));
              }
              catch (NumberFormatException exception)
              {
                if (save_line.substring(22).equalsIgnoreCase("infinite"))
                {
                  player_set = player_set.setDeathHistoryLength(-1);
                }
                else
                {
                  sender.sendMessage(ChatColor.RED + "There was an error in your individual settings.");
                  sender.sendMessage(ChatColor.RED + "The death history length has to be an integer or \"infinite.\"");
                  sender.sendMessage(ChatColor.RED + "I'm setting the death history length for " + parsing_player + " to \"infinite.\"");
                }
              }
            }
            settings.put(parsing_player, player_set);
          }
        }
        save_line = in.readLine();
      }
      in.close();
    }
    catch (IOException exception)
    {
      processException("I got you a present. It's an IOEcxeption in config.txt.", exception);
    }
    for (World world : server.getWorlds()) {
      if (!spawn_messages_by_world.containsKey(world))
      {
        String world_name = world.getWorldFolder().getName();
        if (world_name.endsWith("_nether")) {
          world_name = "The Nether";
        } else if (world_name.endsWith("_the_end")) {
          world_name = "The End";
        }
        spawn_messages_by_world.put(world, "&aWelcome to " + world_name + ", [player].");
      }
    }
    saveTheConfig(sender, false);
    sender.sendMessage(COLOR + "Your configurations have been loaded.");
    if ((sender instanceof Player)) {
      console.sendMessage(COLOR + sender.getName() + " loaded the myUltraWarps config from file.");
    }
  }

    private void loadTheUniqueIDs(CommandSender sender) {
        try {
            File UUID_file = new File(this.getDataFolder(), "uuids.raf");
            if (!UUID_file.exists()) {
                myUltraWarps.debug("no UUID file found; using UUIDFetcher...");
                ArrayList<String> owners = new ArrayList<String>();
                for (UltraWarp warp : warps) {
                    if (warp.owner.length() >= 16 || owners.contains(warp.owner)) continue;
                    owners.add(warp.owner);
                }
                try {
                    myUltraWarps.debug("fetching UUIDs via UUIDFetcher...");
                    this.UUIDs = new UUIDFetcher(owners).call();
                    for (String player : this.UUIDs.keySet()) {
                        myUltraWarps.debug(String.valueOf(player) + ": " + this.UUIDs.get(player));
                    }
                }
                catch (Exception exception) {
                    myUltraWarps.processException("The UUIDFetcher didn't work!", exception);
                }
                this.saveTheUniqueIDs(sender, false);
                return;
            }
            try {
                RandomAccessFile in = new RandomAccessFile(UUID_file, "r");
                for (String line = in.readUTF(); line != null; line = line.trim()) {
                    myUltraWarps.debug("reading UUID info line: \"" + line + "\"");
                    if (!line.contains((CharSequence)";")) {
                        myUltraWarps.debug("UUID file line not properly formatted; line=\"" + line + "\"");
                        continue;
                    }
                    this.UUIDs.put(line.substring(0, line.indexOf(59)), UUID.fromString(line.substring(line.indexOf(59) + 1)));
                    line = in.readUTF();
                }
                in.close();
            }
            catch (EOFException exception) {
                myUltraWarps.debug("reached end of file; finishing load...");
            }
        }
        catch (IOException exception) {
            myUltraWarps.processException("There was a problem trying to read the UUID file!", exception);
            return;
        }
        catch (IllegalArgumentException exception) {
            myUltraWarps.processException("I couldn't read the UUID from this line!", exception);
            return;
        }
    }

    private void loadTheTemporaryData() {
        File temp_file = new File(this.getDataFolder(), "temp.txt");
        if (temp_file.exists()) {
            try {
                BufferedReader in = new BufferedReader(new FileReader(temp_file));
                String save_line = in.readLine();
                String data_type = "";
                String player = "";
                while (save_line != null) {
                    save_line = save_line.trim();
                    while (save_line != null && save_line.equals("")) {
                        save_line = in.readLine();
                    }
                    if (save_line == null) break;
                    if (save_line.startsWith("==== ")) {
                        data_type = save_line.substring(5, save_line.length() - 5);
                    } else if (save_line.startsWith("== ")) {
                        player = save_line.split(" ")[1];
                    } else if (data_type.equals("warp histories")) {
                        try {
                            last_warp_indexes.put(player, Integer.parseInt(save_line));
                        }
                        catch (NumberFormatException exception) {
                            ArrayList warp_history = warp_histories.get(player);
                            if (warp_history == null) {
                                warp_history = new ArrayList();
                            }
                            warp_history.add(new UltraWarp(save_line));
                            warp_histories.put(player, warp_history);
                        }
                    } else if (data_type.equals("death histories")) {
                        try {
                            last_warp_to_death_indexes.put(player, Integer.parseInt(save_line));
                        }
                        catch (NumberFormatException exception) {
                            ArrayList death_history = death_histories.get(player);
                            if (death_history == null) {
                                death_history = new ArrayList();
                            }
                            try {
                                String[] temp = save_line.split(",");
                                World world = null;
                                for (World my_world : server.getWorlds()) {
                                    if (!my_world.getWorldFolder().getName().equals(temp[0])) continue;
                                    world = my_world;
                                    break;
                                }
                                death_history.add(new Location(world, Double.parseDouble(temp[1]), Double.parseDouble(temp[2]), Double.parseDouble(temp[3]), Float.parseFloat(temp[4]), Float.parseFloat(temp[5])));
                                death_histories.put(player, death_history);
                            }
                            catch (NumberFormatException exception2) {
                                myUltraWarps.processException("There was a problem reading the death history from the temporary data file!", exception2);
                            }
                        }
                    } else if (data_type.equals("blocked players")) {
                        ArrayList replacement = blocked_players.get(player);
                        if (replacement == null) {
                            replacement = new ArrayList();
                        }
                        replacement.add(save_line);
                        blocked_players.put(player, replacement);
                    } else if (data_type.equals("cool down times")) {
                        try {
                            cooling_down_players.put(player, Long.parseLong(save_line));
                        }
                        catch (NumberFormatException exception) {
                            myUltraWarps.processException("There was an error in loading the cool down time data for " + player + " from the temporary file!", exception);
                        }
                    }
                    save_line = in.readLine();
                }
                in.close();
                temp_file.setWritable(true);
                temp_file.delete();
            }
            catch (IOException exception) {
                myUltraWarps.processException("I got an IOException while trying to load the temporary data.", exception);
                return;
            }
        }
    }

    private void saveTheWarps(CommandSender sender, boolean display_message) {
        File warps_file = new File(this.getDataFolder(), "warps.txt");
        try {
            if (!warps_file.exists()) {
                this.getDataFolder().mkdir();
                sender.sendMessage((Object)COLOR + "I couldn't find a warps.txt file. I'll make a new one.");
                warps_file.createNewFile();
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(warps_file));
            for (int i = 0; i < warps.size(); ++i) {
                out.write(warps.get(i).toString());
                if (i >= warps.size() - 1) continue;
                out.newLine();
            }
            out.flush();
            out.close();
        }
        catch (IOException exception) {
            myUltraWarps.processException("I got an IOException while trying to save your warps.", exception);
            return;
        }
        if (display_message) {
            if (warps.size() > 1) {
                sender.sendMessage((Object)COLOR + "Your " + warps.size() + " warps have been saved.");
            } else if (warps.size() == 1) {
                sender.sendMessage((Object)COLOR + "Your 1 warp has been saved.");
            } else {
                sender.sendMessage((Object)COLOR + "You have no warps to save!");
            }
            if (sender instanceof Player) {
                if (warps.size() > 1) {
                    console.sendMessage((Object)COLOR + ((Player)sender).getName() + " saved " + warps.size() + " warps to file.");
                } else if (warps.size() == 1) {
                    console.sendMessage((Object)COLOR + ((Player)sender).getName() + " saved the server's 1 warp to file.");
                } else {
                    console.sendMessage((Object)COLOR + ((Player)sender).getName() + " tried to save the server's warps to file, but there were no warps on the server to save.");
                }
            }
        }
    }

    private void saveTheSwitches(CommandSender sender, boolean display_message) {
        File switches_file = new File(this.getDataFolder(), "switches.txt");
        try {
            if (!switches_file.exists()) {
                this.getDataFolder().mkdir();
                sender.sendMessage((Object)COLOR + "I couldn't find a switches.txt file. I'll make a new one.");
                switches_file.createNewFile();
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(switches_file));
            for (UltraSwitch my_switch : switches) {
                out.write(my_switch.toString());
                out.newLine();
            }
            out.flush();
            out.close();
        }
        catch (IOException exception) {
            myUltraWarps.processException("I got an IOException while trying to save your switches.", exception);
            exception.printStackTrace();
            return;
        }
        if (display_message) {
            if (switches.size() > 1) {
                sender.sendMessage((Object)COLOR + "Your " + switches.size() + " switches have been saved.");
            } else if (switches.size() == 1) {
                sender.sendMessage((Object)COLOR + "Your 1 switch has been saved.");
            } else {
                sender.sendMessage((Object)COLOR + "You have no switches to save!");
            }
            if (sender instanceof Player) {
                if (switches.size() > 1) {
                    console.sendMessage((Object)COLOR + ((Player)sender).getName() + " saved " + switches.size() + " switches to file.");
                } else if (switches.size() == 1) {
                    console.sendMessage((Object)COLOR + ((Player)sender).getName() + " saved the server's 1 switch to file.");
                } else {
                    console.sendMessage((Object)COLOR + ((Player)sender).getName() + " tried to save the server's warps to file, but there were no switches on the server to save.");
                }
            }
        }
    }

    private void saveTheConfig(CommandSender sender, boolean display_message) {
        File config_file = new File(this.getDataFolder(), "config.txt");
        try {
            if (!config_file.exists()) {
                this.getDataFolder().mkdir();
                sender.sendMessage((Object)COLOR + "I couldn't find a config.txt file. I'll make a new one.");
                config_file.createNewFile();
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(config_file));
            out.write("Remember to use /myUltraWarps save the config before you modify this file if autosave is off and use /myUltraWarps load the config when you're done.");
            out.newLine();
            out.newLine();
            out.write("Do you want to be able to change settings for permissions-based groups of users? ");
            out.newLine();
            if (use_group_settings) {
                if (Vault == null) {
                    out.write("   Group settings are enabled, but you don't have Vault! You need Vault and a compatible permissions plugin for group settings to work.");
                } else if (permissions == null) {
                    out.write("   Group settings are enabled, but you don't have a permissions plugin compatible with Vault! You need one for group settings to work.");
                } else {
                    out.write("   Group settings are enabled right now.");
                }
            } else {
                out.write("   Group settings are disabled right now.");
                out.newLine();
                out.write("   You need Vault and a compatible permissions plugin in order for this to work.");
            }
            out.newLine();
            out.newLine();
            out.write("Do you want myUltraWarps to check for updates every time it is enabled? ");
            out.newLine();
            if (auto_update) {
                out.write("   Right now, myUltraWarps will auto-update.");
            } else {
                out.write("   Right now, myUltraWarps will not auto-update! I REALLY think you should let it auto-update!");
            }
            out.newLine();
            out.newLine();
            out.write("Do you want myUltraWarps to automatically save the warps file every time a change is made? ");
            out.newLine();
            if (autosave_warps) {
                out.write("   Right now, autosave is on for warps.");
            } else {
                out.write("   Right now, autosave is off for warps.");
            }
            out.newLine();
            out.write("Do you want myUltraWarps to automatically save the switches file every time a change is made? ");
            out.newLine();
            if (autosave_switches) {
                out.write("   Right now, autosave is on for switches.");
            } else {
                out.write("   Right now, autosave is off for switches.");
            }
            out.newLine();
            out.write("Do you want myUltraWarps to automatically save the config file every time a change is made? ");
            out.newLine();
            if (autosave_config) {
                out.write("   Right now, autosave is on for the config.");
            } else {
                out.write("   Right now, autosave is off for the config.");
            }
            out.newLine();
            out.newLine();
            out.write("You can set the messages that appear when someone teleports to the spawn point for each world here.");
            out.newLine();
            for (World world : server.getWorlds()) {
                String spawn_message = spawn_messages_by_world.get((Object)world);
                if (spawn_message == null) continue;
                String world_name = world.getWorldFolder().getName();
                if (world_name.endsWith("_nether")) {
                    world_name = String.valueOf(world_name.substring(0, world_name.length() - 7)) + " (The Nether)";
                } else if (world_name.endsWith("_the_end")) {
                    world_name = String.valueOf(world_name.substring(0, world_name.length() - 8)) + " (The End)";
                }
                out.write("     " + world_name + ": " + spawn_message);
                out.newLine();
            }
            out.newLine();
            out.write("global settings:");
            out.newLine();
            SettingsSet global_set = settings.get("[server]");
            if (global_set == null) {
                global_set = new SettingsSet();
            }
            out.write("     Do you want players to automatically teleport to their homes when they respawn? ");
            out.newLine();
            if (global_set.home_on_death) {
                out.write("        Right now, players automatically teleport home after they die.");
            } else {
                out.write("        Right now, players don't automatically teleport home after they die.");
            }
            out.newLine();
            out.write("     default warp message: " + global_set.default_warp);
            out.newLine();
            out.write("     default no warp message: " + global_set.default_no_warp);
            out.newLine();
            if (global_set.max_warps != -1) {
                out.write("     max warps: " + global_set.max_warps);
            } else {
                out.write("     max warps: infinite");
            }
            out.newLine();
            out.write("     cool down time: " + myUltraWarps.writeTime(global_set.cooldown, false));
            out.newLine();
            if (global_set.warp_history_length != -1) {
                out.write("     warp history length: " + global_set.warp_history_length);
            } else {
                out.write("     warp history length: infinite");
            }
            out.newLine();
            if (global_set.death_history_length != -1) {
                out.write("     death history length: " + global_set.death_history_length);
            } else {
                out.write("     death history length: infinite");
            }
            out.newLine();
            out.newLine();
            if (use_group_settings && permissions != null && permissions.getGroups() != null && permissions.getGroups().length > 0) {
                out.write("group settings:");
                out.newLine();
                for (String group : permissions.getGroups()) {
                    if (group.equals("default")) continue;
                    SettingsSet group_set = settings.get("[" + group + "]");
                    if (group_set == null) {
                        group_set = global_set;
                    }
                    out.write("     " + group + ":");
                    out.newLine();
                    out.write("          Do you want players in this group to automatically teleport to their homes when they respawn? ");
                    out.newLine();
                    if (group_set.home_on_death) {
                        out.write("             Right now, players in this group automatically teleport home after they die.");
                    } else {
                        out.write("             Right now, players in this group don't automatically teleport home after they die.");
                    }
                    out.newLine();
                    out.write("          default warp message: " + group_set.default_warp);
                    out.newLine();
                    out.write("          default no warp message: " + group_set.default_no_warp);
                    out.newLine();
                    if (group_set.max_warps != -1) {
                        out.write("          max warps: " + group_set.max_warps);
                    } else {
                        out.write("          max warps: infinite");
                    }
                    out.newLine();
                    out.write("          cool down time: " + myUltraWarps.writeTime(group_set.cooldown, false));
                    out.newLine();
                    if (group_set.warp_history_length != -1) {
                        out.write("          warp history length: " + group_set.warp_history_length);
                    } else {
                        out.write("          warp history length: infinite");
                    }
                    out.newLine();
                    if (group_set.death_history_length != -1) {
                        out.write("          death history length: " + group_set.death_history_length);
                    } else {
                        out.write("          death history length: infinite");
                    }
                    out.newLine();
                }
                out.newLine();
            } else {
                if (!use_group_settings) {
                    out.write("Group settings are off; otherwise, group settings stuff would go here!");
                } else if (use_group_settings && permissions == null) {
                    out.write("You need Vault to change group settings!");
                } else {
                    out.write("I would put your group settings stuff here, but even though you have Vault and a good permissions plugin, you have no group set up yet!");
                }
                out.newLine();
                out.newLine();
            }
            HashMap<String, SettingsSet> player_sets = new HashMap<String, SettingsSet>();
            for (String key : settings.keySet()) {
                if (key.startsWith("[") || key.startsWith("]")) continue;
                player_sets.put(key, settings.get(key));
            }
            if (player_sets.size() == 0) {
                player_sets.put("1mAnExampl3", new SettingsSet());
            }
            out.write("individual settings:");
            out.newLine();
            for (String key2 : player_sets.keySet()) {
                SettingsSet player_set = (SettingsSet)player_sets.get(key2);
                out.write("     " + key2 + ":");
                out.newLine();
                out.write("          Do you want " + key2 + " to automatically teleport to their home when they respawn? ");
                out.newLine();
                if (player_set.home_on_death) {
                    out.write("             Right now, " + key2 + " automatically teleports home after they die.");
                } else {
                    out.write("             Right now, " + key2 + " doesn't automatically teleport home after they die.");
                }
                out.newLine();
                out.write("          default warp message: " + player_set.default_warp);
                out.newLine();
                out.write("          default no warp message: " + player_set.default_no_warp);
                out.newLine();
                if (player_set.max_warps != -1) {
                    out.write("          max warps: " + player_set.max_warps);
                } else {
                    out.write("          max warps: infinite");
                }
                out.newLine();
                out.write("          cool down time: " + myUltraWarps.writeTime(player_set.cooldown, false));
                out.newLine();
                if (player_set.warp_history_length != -1) {
                    out.write("          warp history length: " + player_set.warp_history_length);
                } else {
                    out.write("          warp history length: infinite");
                }
                out.newLine();
                if (player_set.death_history_length != -1) {
                    out.write("          death history length: " + player_set.death_history_length);
                } else {
                    out.write("          death history length: infinite");
                }
                out.newLine();
            }
            out.close();
        }
        catch (IOException exception) {
            myUltraWarps.processException("I got an IOException while trying to save your configurations.", exception);
            exception.printStackTrace();
            return;
        }
        if (display_message) {
            sender.sendMessage((Object)COLOR + "Your configurations have been saved.");
            if (sender instanceof Player) {
                console.sendMessage((Object)COLOR + ((Player)sender).getName() + " saved the server's configurations to file.");
            }
        }
    }

    private void saveTheUniqueIDs(CommandSender sender, boolean display_message) {
        try {
            File UUID_file = new File(this.getDataFolder(), "uuids.raf");
            if (!UUID_file.exists()) {
                myUltraWarps.debug("no UUID file found; creating new file...");
                UUID_file.createNewFile();
            }
            RandomAccessFile out = new RandomAccessFile(UUID_file, "rw");
            for (String username : this.UUIDs.keySet()) {
                String line = String.valueOf(username) + ";" + this.UUIDs.get(username).toString();
                myUltraWarps.debug("writing UUID info: \"" + line + "\"");
                out.writeUTF(line);
            }
            out.close();
        }
        catch (IOException exception) {
            myUltraWarps.processException("There was a problem trying to read the UUID file!", exception);
            return;
        }
    }

    private void saveTheTemporaryData() {
        File temp_file = new File(this.getDataFolder(), "temp.txt");
        try {
            if (!temp_file.exists()) {
                this.getDataFolder().mkdir();
                temp_file.createNewFile();
            }
            temp_file.setWritable(true);
            BufferedWriter out = new BufferedWriter(new FileWriter(temp_file));
            out.write("==== warp histories ====");
            out.newLine();
            for (String key222 : warp_histories.keySet()) {
                out.write("== " + key222 + " ==");
                out.newLine();
                for (UltraWarp warp : warp_histories.get(key222)) {
                    out.write(warp.toString());
                    out.newLine();
                }
                if (last_warp_indexes.get(key222) == null) continue;
                out.write(last_warp_indexes.get(key222));
                out.newLine();
            }
            out.write("==== death histories ====");
            out.newLine();
            for (String key222 : death_histories.keySet()) {
                out.write("== " + key222 + " ==");
                out.newLine();
                for (Location death : death_histories.get(key222)) {
                    out.write(String.valueOf(death.getWorld().getName()) + "," + death.getX() + "," + death.getY() + "," + death.getZ() + "," + death.getYaw() + "," + death.getPitch());
                    out.newLine();
                }
                if (last_warp_to_death_indexes.get(key222) == null) continue;
                out.write(last_warp_to_death_indexes.get(key222));
                out.newLine();
            }
            out.write("==== blocked players ====");
            out.newLine();
            for (String key222 : blocked_players.keySet()) {
                if (blocked_players.get(key222) == null || blocked_players.get(key222).size() <= 0) continue;
                out.write("== " + key222 + " ==");
                out.newLine();
                for (String blocked_player : blocked_players.get(key222)) {
                    out.write(blocked_player);
                    out.newLine();
                }
            }
            out.write("==== cool down times ====");
            out.newLine();
            for (String key222 : cooling_down_players.keySet()) {
                if (cooling_down_players.get(key222) == null) continue;
                out.write("== " + key222 + " ==");
                out.newLine();
                out.write(String.valueOf(cooling_down_players.get(key222)));
                out.newLine();
            }
            out.flush();
            out.close();
            temp_file.setReadOnly();
        }
        catch (IOException exception) {
            myUltraWarps.processException("I got an IOException while trying to save your temporary data.", exception);
            exception.printStackTrace();
            return;
        }
    }

    private void displayHelp(CommandSender sender, String[] parameters) {
        int lines_per_page = 27;
        if (sender instanceof Player) {
            lines_per_page = 10;
        }
        int page_number = 0;
        int extra_param = 0;
        if (parameters.length > 0 && parameters[0].equalsIgnoreCase("help")) {
            ++extra_param;
        }
        if (parameters.length > extra_param) {
            try {
                page_number = Integer.parseInt(parameters[extra_param]);
            }
            catch (NumberFormatException exception) {
                sender.sendMessage((Object)ChatColor.RED + "How long has \"" + parameters[extra_param] + "\" been an integer? I must really be out of the loop.");
            }
        }
        if (page_number == 0) {
            sender.sendMessage(myUltraWarps.colorCode("&f\"()\" indicate an optional parameter while \"[]\" indicate a required parameter. If a parameter is in quotes, it means that that word itself is the parameter; otherwise, substitute the piece of data for the parameter. Almost everything is not case-sensitive and you can use even just a single letter to search for it. For example, instead of typing &a&o/warp Play3r's house&f, you can just type &a&o/warp p's h &fif you like. Use &o&a/mUW help [page #] &fto go through the help pages. &cT&fh&ca&ft&c'&fs &ca&fl&cl&f, &cf&fo&cl&fk&cs&f!"));
        } else if (page_number < 0) {
            sender.sendMessage((Object)ChatColor.RED + "Last time I checked, negative page numbers don't make sense.");
        } else {
            int number_of_lines = 0;
            ArrayList<String> pages = new ArrayList<String>();
            String current_page = "";
            for (int i = 0; i < this.help_pages.size(); ++i) {
                String help_line = (String)this.help_pages.get(i)[0];
                String basic_permission_node = (String)this.help_pages.get(i)[1];
                boolean included_with_user = (Boolean)this.help_pages.get(i)[2];
                int chat_lines_in_this_line = (Integer)this.help_pages.get(i)[3];
                if (sender instanceof Player && !sender.hasPermission("myultrawarps.admin") && (!included_with_user || !sender.hasPermission("myultrawarps.user")) && !sender.hasPermission(basic_permission_node) && !sender.hasPermission(String.valueOf(basic_permission_node) + ".other")) continue;
                if (i != 0) {
                    current_page = String.valueOf(current_page) + "\n";
                }
                if ((number_of_lines+=chat_lines_in_this_line) > lines_per_page) {
                    pages.add(current_page);
                    current_page = "";
                    number_of_lines = chat_lines_in_this_line;
                }
                current_page = String.valueOf(current_page) + help_line;
            }
            pages.add(current_page);
            if (page_number > pages.size()) {
                if (pages.size() == 1) {
                    sender.sendMessage((Object)ChatColor.RED + "There is only one help page for you.");
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "There are only " + pages.size() + " help pages for you.");
                }
            } else {
                sender.sendMessage(myUltraWarps.colorCode((String)pages.get(page_number - 1)));
            }
        }
    }

    private void back(CommandSender sender, String[] parameters) {
        ArrayList<UltraWarp> warp_history;
        Player player = (Player)sender;
        int amount = 1;
        if (parameters.length > 0) {
            try {
                amount = Integer.parseInt(parameters[0]);
                if (amount == 0) {
                    sender.sendMessage((Object)COLOR + "Well, here you are. You went back 0 warps through your history.");
                    return;
                }
                if (amount < 0) {
                    sender.sendMessage((Object)ChatColor.RED + "Going back backwards.... Sorry, but I can't see into the future. At least...not that far ahead.");
                    return;
                }
            }
            catch (NumberFormatException exception) {
                sender.sendMessage((Object)ChatColor.RED + "Since when is \"" + parameters[0] + "\" an integer?");
                return;
            }
        }
        if ((warp_history = warp_histories.get(player.getName())) == null || warp_history.size() == 0) {
            sender.sendMessage((Object)ChatColor.RED + "You haven't warped anywhere yet!");
            return;
        }
        Integer last_warp_index = last_warp_indexes.get(player.getName());
        if (last_warp_index == null) {
            last_warp_index = warp_history.size() - 1;
        }
        UltraWarp last_warp = null;
        if (warp_history == null || last_warp_index < amount) {
            if (warp_history == null || warp_history.size() == 0) {
                sender.sendMessage((Object)ChatColor.RED + "You haven't warped anywhere yet!");
            } else if (last_warp_index > 1) {
                sender.sendMessage((Object)ChatColor.RED + "You can only go back " + last_warp_index + " more warps.");
            } else if (last_warp_index == 1) {
                sender.sendMessage((Object)ChatColor.RED + "You can only go back one more warp.");
            } else {
                sender.sendMessage((Object)ChatColor.RED + "Sorry, but I don't keep track of that many warps. This is as far back as you can go.");
            }
            return;
        }
        last_warp = warp_history.get(last_warp_index - amount);
        if (last_warp != null) {
            boolean player_is_listed = false;
            if (last_warp.listed_users != null) {
                for (String listed_player : last_warp.listed_users) {
                    if (!listed_player.equals(player.getName())) continue;
                    player_is_listed = true;
                }
            }
            if (player.hasPermission("myultrawarps.admin") || player.hasPermission("myultrawarps.warptowarp.other") || last_warp.owner.equals(player.getName()) || !last_warp.restricted && !player_is_listed || last_warp.restricted && player_is_listed) {
                this.teleport(player, null, last_warp, true, null);
                last_warp_indexes.put(player.getName(), last_warp_index - amount);
            } else {
                player.sendMessage(myUltraWarps.colorCode(last_warp.no_warp_message.replaceAll("\\[player\\]", player.getName())));
            }
        }
    }

    private void block(CommandSender sender, String[] parameters) {
        Player player = (Player)sender;
        String blocked_player = null;
        Player target_player = null;
        for (Player my_player2 : server.getOnlinePlayers()) {
            if (!my_player2.getName().toLowerCase().startsWith(parameters[0].toLowerCase()) || my_player2.getName().equals(player.getName())) continue;
            target_player = my_player2;
            blocked_player = my_player2.getName();
            break;
        }
        if (blocked_player == null) {
            for (OfflinePlayer my_player : server.getOfflinePlayers()) {
                if (!my_player.getName().toLowerCase().startsWith(parameters[0].toLowerCase()) || my_player.getName().equals(player.getName())) continue;
                blocked_player = my_player.getName();
                break;
            }
        }
        if (blocked_player == null) {
            blocked_player = parameters[0];
        }
        if (!(target_player != null && target_player.hasPermission("myultrawarps.admin"))) {
            ArrayList<String> my_blocked_players = blocked_players.get(player.getName());
            if (my_blocked_players == null) {
                my_blocked_players = new ArrayList();
            }
            my_blocked_players.add(blocked_player);
            blocked_players.put(player.getName(), (ArrayList<String>)my_blocked_players);
            sender.sendMessage((Object)COLOR + blocked_player + " can no longer send you teleportation requests.");
            ArrayList<String> requesting_players = from_teleport_requests.get(blocked_player);
            if (requesting_players == null) {
                requesting_players = new ArrayList();
            } else {
                String remove = requesting_players.get(0);
                while (requesting_players.contains(remove)) {
                    requesting_players.remove(remove);
                }
            }
            from_teleport_requests.put(blocked_player, requesting_players);
            requesting_players = to_teleport_requests.get(blocked_player);
            if (requesting_players == null) {
                requesting_players = new ArrayList();
            } else {
                String remove = (String)requesting_players.get(0);
                while (requesting_players.contains(remove)) {
                    requesting_players.remove(remove);
                }
            }
            to_teleport_requests.put(blocked_player, requesting_players);
        } else if (blocked_player != null && target_player != null) {
            player.sendMessage((Object)ChatColor.RED + "Sorry, but " + target_player.getName() + " is a myUltraWarps admin. They have power over everything myUltraWarps-related and you're not allowed to block them.");
        } else if (player.getName().toLowerCase().startsWith(blocked_player)) {
            player.sendMessage((Object)ChatColor.RED + "Now why would you want to block yourself?");
        }
    }

    private void blockList(int extra_param, CommandSender sender, String[] parameters) {
        String target = sender.getName();
        if (parameters.length > extra_param) {
            target = myUltraWarps.autoCompleteName(parameters[extra_param]);
        }
        if (target == null) {
            sender.sendMessage((Object)ChatColor.RED + "I don't know anyone whose name begins with \"" + parameters[extra_param] + "\"!");
            return;
        }
        if (blocked_players.get(target) != null && blocked_players.get(target).size() > 0 && (target.equals(sender.getName()) || sender.hasPermission("myultrawarps.blocklist.other") || sender.hasPermission("myultrawarps.admin"))) {
            ArrayList<String> players = blocked_players.get(target);
            String list = players.get(0);
            if (players.size() == 2) {
                list = String.valueOf(list) + " and " + players.get(1);
            } else if (players.size() > 2) {
                for (int i = 1; i < players.size(); ++i) {
                    list = String.valueOf(list) + ", ";
                    if (i == players.size() - 1) {
                        list = String.valueOf(list) + "and ";
                    }
                    list = String.valueOf(list) + players.get(i);
                }
            }
            if (target.equals(sender.getName())) {
                sender.sendMessage((Object)COLOR + "You've blocked " + list + ".");
            } else {
                sender.sendMessage((Object)COLOR + target + " blocked " + list + ".");
            }
        } else if (!(target.equals(sender.getName()) || sender.hasPermission("myultrawarps.blocklist.other") || sender.hasPermission("myultrawarps.admin"))) {
            sender.sendMessage((Object)ChatColor.RED + "Sorry, but you don't have permission to see who other people blocked.");
        } else if (target.equals(sender.getName())) {
            sender.sendMessage((Object)COLOR + "You haven't blocked anyone yet.");
        } else {
            sender.sendMessage((Object)COLOR + target + " hasn't blocked anyone yet.");
        }
    }

    private void createWarp(int extra_param, CommandSender sender, String[] parameters) {
        Player player = (Player)sender;
        boolean listed = false;
        boolean restricted = true;
        SettingsSet set = this.getSettings(player);
        String owner = player.getName();
        String warp_message = set.default_warp.replaceAll("\\[warp\\]", parameters[extra_param].replaceAll("_", " ")).replaceAll("\\[owner\\]", owner);
        String no_warp_message = set.default_no_warp.replaceAll("\\[warp\\]", parameters[extra_param].replaceAll("_", " ")).replaceAll("\\[owner\\]", owner);
        String[] listed_users = null;
        boolean player_is_owner = true;
        this.parsing_warp_message = false;
        this.parsing_no_warp_message = false;
        for (int j = extra_param + 1; j < parameters.length; ++j) {
            if (parameters[j].toLowerCase().startsWith("type:o")) {
                listed = true;
                restricted = false;
                continue;
            }
            if (parameters[j].toLowerCase().startsWith("type:s")) {
                listed = false;
                restricted = false;
                continue;
            }
            if (parameters[j].toLowerCase().startsWith("type:a")) {
                listed = true;
                restricted = true;
                this.stopParsingMessages(warp_message, no_warp_message, parameters[extra_param], owner, player_is_owner, sender, "");
                continue;
            }
            if (parameters[j].toLowerCase().startsWith("type:p")) {
                listed = false;
                restricted = true;
                this.stopParsingMessages(warp_message, no_warp_message, parameters[extra_param], owner, player_is_owner, sender, "");
                continue;
            }
            if (parameters[j].toLowerCase().startsWith("warp:")) {
                warp_message = parameters[j].substring(5);
                this.stopParsingMessages(warp_message, no_warp_message, parameters[extra_param], owner, player_is_owner, sender, "");
                this.parsing_warp_message = true;
                continue;
            }
            if (parameters[j].toLowerCase().startsWith("nowarp:")) {
                no_warp_message = parameters[j].substring(7);
                this.stopParsingMessages(warp_message, no_warp_message, parameters[extra_param], owner, player_is_owner, sender, "");
                continue;
            }
            if (parameters[j].toLowerCase().startsWith("giveto:")) {
                String temp_old_owner = owner;
                owner = myUltraWarps.autoCompleteName(parameters[j].substring(7));
                boolean bl = player_is_owner = player != null && player.getName().equals(owner);
                if (warp_message.contains((CharSequence)temp_old_owner)) {
                    warp_message = warp_message.replaceAll(temp_old_owner, owner);
                }
                if (no_warp_message.contains((CharSequence)temp_old_owner)) {
                    no_warp_message = no_warp_message.replaceAll(temp_old_owner, owner);
                }
                this.stopParsingMessages(warp_message, no_warp_message, parameters[extra_param], owner, player_is_owner, sender, "");
                continue;
            }
            if (parameters[j].toLowerCase().startsWith("list:")) {
                this.stopParsingMessages(warp_message, no_warp_message, parameters[extra_param], owner, player_is_owner, sender, "");
                listed_users = parameters[j].substring(5).split(",");
                if (listed_users.length <= 0 || listed_users.length == 1 && listed_users[0].equals("")) continue;
                for (int i = 0; i < listed_users.length; ++i) {
                    listed_users[i] = myUltraWarps.autoCompleteName(listed_users[i]);
                }
                continue;
            }
            if (this.parsing_warp_message) {
                warp_message = String.valueOf(warp_message) + " " + parameters[j];
                continue;
            }
            if (!this.parsing_no_warp_message) continue;
            no_warp_message = String.valueOf(no_warp_message) + " " + parameters[j];
        }
        if (listed_users == null) {
            listed_users = new String[]{};
        }
        boolean maxed_out = false;
        if (set.max_warps != -1) {
            int number_of_warps = 0;
            for (UltraWarp warp : warps) {
                if (!warp.owner.equalsIgnoreCase(player.getName())) continue;
                ++number_of_warps;
            }
            if (number_of_warps >= set.max_warps) {
                player.sendMessage((Object)ChatColor.RED + "Sorry, but you're only allowed to create " + Integer.valueOf(set.max_warps) + " warps and you've already reached your limit.");
                return;
            }
        }
        if (!(maxed_out && !player.hasPermission("myultrawarps.admin") || parameters[extra_param].equalsIgnoreCase("info") || parameters[extra_param].equalsIgnoreCase("all") || parameters[extra_param].equalsIgnoreCase("list") || parameters[extra_param].toLowerCase().endsWith("'s") || !player.getName().toLowerCase().startsWith(owner.toLowerCase()) && !player.hasPermission("myultrawarps.create.other") && !player.hasPermission("myultrawarps.admin"))) {
            for (int i = 0; i < warps.size(); ++i) {
                if (!myUltraWarps.warps.get((int)i).owner.equals(owner) || !myUltraWarps.warps.get((int)i).name.equals(parameters[extra_param])) continue;
                warps.remove(i);
            }
            int insertion_index = 0;
            for (UltraWarp warp : warps) {
                if (warp.name.compareToIgnoreCase(parameters[extra_param]) >= 0 && (warp.name.compareToIgnoreCase(parameters[extra_param]) != 0 || warp.owner.compareToIgnoreCase(owner) > 0)) continue;
                ++insertion_index;
            }
            warps.add(insertion_index, new UltraWarp(owner, parameters[extra_param], listed, restricted, warp_message, no_warp_message, listed_users, player.getLocation()));
            if (autosave_warps) {
                this.saveTheWarps(sender, false);
            }
            if (player.getName().toLowerCase().startsWith(owner.toLowerCase())) {
                player.sendMessage((Object)COLOR + "You made a warp called \"" + parameters[extra_param] + ".\"");
            } else {
                player.sendMessage((Object)COLOR + "You made a warp called \"" + parameters[extra_param] + "\" for " + owner + ".");
            }
        } else if (parameters[extra_param].equalsIgnoreCase("info")) {
            sender.sendMessage((Object)ChatColor.RED + "Sorry, but you can't name a warp \"info\" because it interferes with the command " + (Object)COLOR + "/warp info" + (Object)ChatColor.RED + ".");
        } else if (parameters[extra_param].equalsIgnoreCase("all")) {
            sender.sendMessage((Object)ChatColor.RED + "Sorry, but you can't name a warp \"all\" because it interferes with the command " + (Object)COLOR + "/warp all" + (Object)ChatColor.RED + ".");
        } else if (parameters[extra_param].equalsIgnoreCase("list")) {
            sender.sendMessage((Object)ChatColor.RED + "Sorry, but you can't name a warp \"list\" because it interferes with the command " + (Object)COLOR + "/warp list" + (Object)ChatColor.RED + ".");
        } else if (parameters[extra_param].toLowerCase().endsWith("'s")) {
            sender.sendMessage((Object)ChatColor.RED + "Sorry, but you can't make a warp with a name ending in \"'s\" because I check for that to see whether you're specifying an owner or just giving a warp name alone and if the warp name has that \"'s\", I get very confused.");
        } else if (!(player.getName().equalsIgnoreCase(owner) || player.hasPermission("myultrawarps.create.other") || player.hasPermission("myultrawarps.admin"))) {
            boolean warp_already_exists = false;
            for (int i = 0; i < warps.size(); ++i) {
                if (!myUltraWarps.warps.get((int)i).owner.toLowerCase().startsWith(owner.toLowerCase()) || !myUltraWarps.warps.get((int)i).name.toLowerCase().startsWith(parameters[extra_param].toLowerCase())) continue;
                warp_already_exists = true;
            }
            if (!warp_already_exists) {
                int insertion_index = 0;
                for (UltraWarp warp : warps) {
                    if (warp.name.compareToIgnoreCase(parameters[extra_param]) >= 0 && (warp.name.compareToIgnoreCase(parameters[extra_param]) != 0 || warp.owner.compareToIgnoreCase(owner) > 0)) continue;
                    ++insertion_index;
                }
                warps.add(insertion_index, new UltraWarp(owner, parameters[extra_param], listed, restricted, warp_message, no_warp_message, listed_users, player.getLocation()));
                player.sendMessage((Object)COLOR + "You made a warp called \"" + parameters[extra_param] + "\" for " + owner + ".");
            } else {
                player.sendMessage((Object)ChatColor.RED + owner + " already has a warp called \"" + parameters[extra_param] + "\" and you're not allowed to overwrite it.");
            }
        }
    }

    private void changeWarp(int extra_param, CommandSender sender, String[] parameters) {
        UltraWarp warp;
        Player player = null;
        if (sender instanceof Player) {
            player = (Player)sender;
        }
        if ((warp = UltraWarp.getWarp(extra_param, sender, parameters)) != null) {
            boolean listed = warp.listed;
            boolean restricted = warp.restricted;
            boolean old_listed = warp.listed;
            boolean old_restricted = warp.restricted;
            String warp_message = warp.warp_message;
            String no_warp_message = warp.no_warp_message;
            String old_warp_message = warp.warp_message;
            String old_no_warp_message = warp.no_warp_message;
            String owner = warp.owner;
            String name = warp.name;
            String old_owner = warp.owner;
            String old_name = warp.name;
            String result_message = "";
            String[] listed_users = warp.listed_users;
            String[] old_listed_users = warp.listed_users;
            boolean player_is_owner = false;
            if (player != null && player.getName().toLowerCase().startsWith(owner.toLowerCase())) {
                player_is_owner = true;
            }
            this.parsing_warp_message = false;
            this.parsing_no_warp_message = false;
            block0 : for (int j = extra_param + 1; j < parameters.length; ++j) {
                int i;
                int i2;
                boolean updated_warp_message;
                boolean updated_no_warp_message;
                if (parameters[j].toLowerCase().startsWith("type:o")) {
                    result_message = this.stopParsingMessages(warp_message, no_warp_message, name, owner, player_is_owner, sender, result_message);
                    listed = true;
                    restricted = false;
                    if (!result_message.equals("")) {
                        result_message = String.valueOf(result_message) + "\n";
                    }
                    if (player_is_owner) {
                        result_message = String.valueOf(result_message) + (Object)COLOR + "\"" + name + "\" is now an " + (Object)ChatColor.WHITE + "open " + (Object)COLOR + "warp.";
                        continue;
                    }
                    result_message = String.valueOf(result_message) + (Object)COLOR + owner + "'s \"" + name + "\" is now an " + (Object)ChatColor.WHITE + "open " + (Object)COLOR + "warp.";
                    continue;
                }
                if (parameters[j].toLowerCase().startsWith("type:s")) {
                    result_message = this.stopParsingMessages(warp_message, no_warp_message, name, owner, player_is_owner, sender, result_message);
                    listed = false;
                    restricted = false;
                    if (!result_message.equals("")) {
                        result_message = String.valueOf(result_message) + "\n";
                    }
                    if (player_is_owner) {
                        result_message = String.valueOf(result_message) + (Object)COLOR + "\"" + name + "\" is now a " + (Object)ChatColor.GRAY + "secret " + (Object)COLOR + "warp.";
                        continue;
                    }
                    result_message = String.valueOf(result_message) + (Object)COLOR + owner + "'s \"" + name + "\" is now a " + (Object)ChatColor.GRAY + "secret " + (Object)COLOR + "warp.";
                    continue;
                }
                if (parameters[j].toLowerCase().startsWith("type:a")) {
                    result_message = this.stopParsingMessages(warp_message, no_warp_message, name, owner, player_is_owner, sender, result_message);
                    listed = true;
                    restricted = true;
                    if (!result_message.equals("")) {
                        result_message = String.valueOf(result_message) + "\n";
                    }
                    if (player_is_owner) {
                        result_message = String.valueOf(result_message) + (Object)COLOR + "\"" + name + "\" is now an " + (Object)ChatColor.AQUA + "advertised " + (Object)COLOR + "warp.";
                        continue;
                    }
                    result_message = String.valueOf(result_message) + (Object)COLOR + owner + "'s \"" + name + "\" is now an " + (Object)ChatColor.AQUA + "advertised " + (Object)COLOR + "warp.";
                    continue;
                }
                if (parameters[j].toLowerCase().startsWith("type:p")) {
                    result_message = this.stopParsingMessages(warp_message, no_warp_message, name, owner, player_is_owner, sender, result_message);
                    listed = false;
                    restricted = true;
                    if (!result_message.equals("")) {
                        result_message = String.valueOf(result_message) + "\n";
                    }
                    if (player_is_owner) {
                        result_message = String.valueOf(result_message) + (Object)COLOR + "\"" + name + "\" is now a " + (Object)ChatColor.DARK_GRAY + "private " + (Object)COLOR + "warp.";
                        continue;
                    }
                    result_message = String.valueOf(result_message) + (Object)COLOR + owner + "'s \"" + name + "\" is now a " + (Object)ChatColor.DARK_GRAY + "private " + (Object)COLOR + "warp.";
                    continue;
                }
                if (parameters[j].toLowerCase().startsWith("name:")) {
                    result_message = this.stopParsingMessages(warp_message, no_warp_message, name, owner, player_is_owner, sender, result_message);
                    String temp_old_name = name;
                    name = parameters[j].substring(5);
                    if (!(name.equalsIgnoreCase("info") || name.equalsIgnoreCase("all") || name.equalsIgnoreCase("list"))) {
                        if (!result_message.equals("")) {
                            result_message = String.valueOf(result_message) + "\n";
                        }
                        result_message = player_is_owner ? String.valueOf(result_message) + (Object)COLOR + "\"" + old_name + "\" has been renamed \"" + name + ".\"" : String.valueOf(result_message) + (Object)COLOR + owner + "'s \"" + old_name + "\" has been renamed \"" + name + ".\"";
                        updated_warp_message = false;
                        updated_no_warp_message = false;
                        String temp_old_message_name = temp_old_name.replaceAll("_", " ");
                        String message_name = name.replaceAll("_", " ");
                        if (warp_message.contains((CharSequence)temp_old_message_name)) {
                            warp_message = warp_message.replaceAll(temp_old_message_name, message_name);
                            updated_warp_message = true;
                        }
                        if (no_warp_message.contains((CharSequence)temp_old_message_name)) {
                            no_warp_message = no_warp_message.replaceAll(temp_old_message_name, message_name);
                            updated_no_warp_message = true;
                        }
                        if (!result_message.equals("")) {
                            result_message = String.valueOf(result_message) + "\n";
                        }
                        if (updated_warp_message) {
                            if (updated_no_warp_message) {
                                result_message = String.valueOf(result_message) + (Object)COLOR + "I also updated the warp and no warp messages.";
                                continue;
                            }
                            result_message = String.valueOf(result_message) + (Object)COLOR + "I also updated the warp message.";
                            continue;
                        }
                        if (!updated_no_warp_message) continue;
                        result_message = String.valueOf(result_message) + (Object)COLOR + "I also updated the no warp message.";
                        continue;
                    }
                    if (!result_message.equals("")) {
                        result_message = String.valueOf(result_message) + "\n";
                    }
                    result_message = String.valueOf(result_message) + (Object)ChatColor.RED + "Sorry, but you can't make a warp called \"" + name + "\" because it interferes with the command " + (Object)COLOR + "/warp " + name + (Object)ChatColor.RED + ".";
                    name = temp_old_name;
                    continue;
                }
                if (parameters[j].toLowerCase().startsWith("warp:")) {
                    result_message = this.stopParsingMessages(warp_message, no_warp_message, name, owner, player_is_owner, sender, result_message);
                    warp_message = parameters[j].substring(5);
                    this.parsing_warp_message = true;
                    continue;
                }
                if (parameters[j].toLowerCase().startsWith("nowarp:")) {
                    result_message = this.stopParsingMessages(warp_message, no_warp_message, name, owner, player_is_owner, sender, result_message);
                    no_warp_message = parameters[j].substring(7);
                    this.parsing_no_warp_message = true;
                    continue;
                }
                if (parameters[j].toLowerCase().startsWith("giveto:")) {
                    result_message = this.stopParsingMessages(warp_message, no_warp_message, name, owner, player_is_owner, sender, result_message);
                    String temp_old_owner = owner;
                    owner = myUltraWarps.autoCompleteName(parameters[j].substring(7));
                    if (!result_message.equals("")) {
                        result_message = String.valueOf(result_message) + "\n";
                    }
                    result_message = player != null && player.getName().toLowerCase().startsWith(temp_old_owner.toLowerCase()) ? String.valueOf(result_message) + (Object)COLOR + "You gave \"" + name + "\" to " + owner + "." : String.valueOf(result_message) + (Object)COLOR + "You gave " + temp_old_owner + "'s \"" + name + "\" to " + owner + ".";
                    updated_warp_message = false;
                    updated_no_warp_message = false;
                    if (warp_message.contains((CharSequence)temp_old_owner)) {
                        warp_message = warp_message.replaceAll(temp_old_owner, owner);
                        updated_warp_message = true;
                    }
                    if (no_warp_message.contains((CharSequence)temp_old_owner)) {
                        no_warp_message = no_warp_message.replaceAll(temp_old_owner, owner);
                        updated_no_warp_message = true;
                    }
                    if (!result_message.equals("")) {
                        result_message = String.valueOf(result_message) + "\n";
                    }
                    if (updated_warp_message) {
                        if (updated_no_warp_message) {
                            result_message = String.valueOf(result_message) + (Object)COLOR + "I also updated the warp and no warp messages.";
                            continue;
                        }
                        result_message = String.valueOf(result_message) + (Object)COLOR + "I also updated the warp message.";
                        continue;
                    }
                    if (!updated_no_warp_message) continue;
                    result_message = String.valueOf(result_message) + (Object)COLOR + "I also updated the no warp message.";
                    continue;
                }
                if (parameters[j].toLowerCase().startsWith("list:")) {
                    result_message = this.stopParsingMessages(warp_message, no_warp_message, name, owner, player_is_owner, sender, result_message);
                    String[] listed_users_list = parameters[j].substring(5).split(",");
                    if (listed_users_list.length <= 0 || listed_users_list.length == 1 && listed_users_list[0].equals("")) continue;
                    for (i = 0; i < listed_users_list.length; ++i) {
                        listed_users_list[i] = myUltraWarps.autoCompleteName(listed_users_list[i]);
                    }
                    if (!result_message.equals("")) {
                        result_message = String.valueOf(result_message) + "\n";
                    }
                    if (restricted) {
                        if (player_is_owner) {
                            if (listed_users_list.length == 1) {
                                result_message = String.valueOf(result_message) + (Object)COLOR + listed_users_list[0] + " is now allowed to use \"" + name + ".\"";
                            } else if (listed_users_list.length == 2) {
                                result_message = String.valueOf(result_message) + (Object)COLOR + listed_users_list[0] + " and " + listed_users_list[1] + " are now allowed to use \"" + name + ".\"";
                            } else {
                                String message = COLOR  + "";;
                                for (i2 = 0; i2 < listed_users_list.length - 1; ++i2) {
                                    message = String.valueOf(message) + listed_users_list[i2] + ", ";
                                }
                                result_message = String.valueOf(result_message) + message + " and " + listed_users_list[listed_users_list.length - 1] + " are now allowed to use \"" + name + ".\"";
                            }
                        } else if (listed_users_list.length == 1) {
                            result_message = String.valueOf(result_message) + (Object)COLOR + listed_users_list[0] + " is now allowed to use " + owner + "'s \"" + name + ".\"";
                        } else if (listed_users_list.length == 2) {
                            result_message = String.valueOf(result_message) + (Object)COLOR + listed_users_list[0] + " and " + listed_users_list[1] + " are now allowed to use " + owner + "'s \"" + name + ".\"";
                        } else {
                            String message = COLOR  + "";
                            for (i2 = 0; i2 < listed_users_list.length - 1; ++i2) {
                                message = String.valueOf(message) + listed_users_list[i2] + ", ";
                            }
                            result_message = String.valueOf(result_message) + message + " and " + listed_users_list[listed_users_list.length - 1] + " are now allowed to use " + owner + "'s \"" + name + ".\"";
                        }
                    } else if (player_is_owner) {
                        if (listed_users_list.length == 1) {
                            result_message = String.valueOf(result_message) + (Object)COLOR + listed_users_list[0] + " is no longer allowed to use \"" + name + ".\"";
                        } else if (listed_users_list.length == 2) {
                            result_message = String.valueOf(result_message) + (Object)COLOR + listed_users_list[0] + " and " + listed_users_list[1] + " are no longer allowed to use \"" + name + ".\"";
                        } else {
                            String message = COLOR  + "";
                            for (i2 = 0; i2 < listed_users_list.length - 1; ++i2) {
                                message = String.valueOf(message) + listed_users_list[i2] + ", ";
                            }
                            result_message = String.valueOf(result_message) + message + " and " + listed_users_list[listed_users_list.length - 1] + " are no longer allowed to use \"" + name + ".\"";
                        }
                    } else if (listed_users_list.length == 1) {
                        result_message = String.valueOf(result_message) + (Object)COLOR + listed_users_list[0] + " is no longer allowed to use " + owner + "'s \"" + name + ".\"";
                    } else if (listed_users_list.length == 2) {
                        result_message = String.valueOf(result_message) + (Object)COLOR + listed_users_list[0] + " and " + listed_users_list[1] + " are no longer allowed to use " + owner + "'s \"" + name + ".\"";
                    } else {
                        String message = COLOR  + "";
                        for (i2 = 0; i2 < listed_users_list.length - 1; ++i2) {
                            message = String.valueOf(message) + listed_users_list[i2] + ", ";
                        }
                        result_message = String.valueOf(result_message) + message + " and " + listed_users_list[listed_users_list.length - 1] + " are no longer allowed to use " + owner + "'s \"" + name + ".\"";
                    }
                    String[] temp_listed_users = listed_users;
                    listed_users = new String[listed_users_list.length + temp_listed_users.length];
                    i2 = 0;
                    do {
                        if (i2 >= listed_users.length) continue block0;
                        listed_users[i2] = i2 < temp_listed_users.length ? temp_listed_users[i2] : listed_users_list[i2 - temp_listed_users.length];
                        ++i2;
                    } while (true);
                }
                if (parameters[j].toLowerCase().startsWith("unlist:")) {
                    result_message = this.stopParsingMessages(warp_message, no_warp_message, name, owner, player_is_owner, sender, result_message);
                    String[] unlisted_users_list = parameters[j].substring(7).split(",");
                    if (!(unlisted_users_list.length <= 0 || unlisted_users_list.length == 1 && unlisted_users_list[0].equals(""))) {
                        for (i = 0; i < unlisted_users_list.length; ++i) {
                            unlisted_users_list[i] = myUltraWarps.autoCompleteName(unlisted_users_list[i]);
                        }
                        if (!result_message.equals("")) {
                            result_message = String.valueOf(result_message) + "\n";
                        }
                        if (restricted) {
                            if (player_is_owner) {
                                if (unlisted_users_list.length == 1) {
                                    result_message = String.valueOf(result_message) + (Object)COLOR + unlisted_users_list[0] + " is no longer allowed to use \"" + name + ".\"";
                                } else if (unlisted_users_list.length == 2) {
                                    result_message = String.valueOf(result_message) + (Object)COLOR + unlisted_users_list[0] + " and " + unlisted_users_list[1] + " are no longer allowed to use \"" + name + ".\"";
                                } else {
                                    String message = COLOR + "";
                                    for (i2 = 0; i2 < unlisted_users_list.length - 1; ++i2) {
                                        message = String.valueOf(message) + unlisted_users_list[i2] + ", ";
                                    }
                                    result_message = String.valueOf(result_message) + message + " and " + unlisted_users_list[unlisted_users_list.length - 1] + " are no longer allowed to use \"" + name + ".\"";
                                }
                            } else if (unlisted_users_list.length == 1) {
                                result_message = String.valueOf(result_message) + (Object)COLOR + unlisted_users_list[0] + " is no longer allowed to use " + owner + "'s \"" + name + ".\"";
                            } else if (unlisted_users_list.length == 2) {
                                result_message = String.valueOf(result_message) + (Object)COLOR + unlisted_users_list[0] + " and " + unlisted_users_list[1] + " are no longer allowed to use " + owner + "'s \"" + name + ".\"";
                            } else {
                                String message = COLOR + "";
                                for (i2 = 0; i2 < unlisted_users_list.length - 1; ++i2) {
                                    message = String.valueOf(message) + unlisted_users_list[i2] + ", ";
                                }
                                result_message = String.valueOf(result_message) + message + " and " + unlisted_users_list[unlisted_users_list.length - 1] + " are no longer allowed to use " + owner + "'s \"" + name + ".\"";
                            }
                        } else if (player_is_owner) {
                            if (unlisted_users_list.length == 1) {
                                result_message = String.valueOf(result_message) + (Object)COLOR + unlisted_users_list[0] + " is now allowed to use \"" + name + ".\"";
                            } else if (unlisted_users_list.length == 2) {
                                result_message = String.valueOf(result_message) + (Object)COLOR + unlisted_users_list[0] + " and " + unlisted_users_list[1] + " are now allowed to use \"" + name + ".\"";
                            } else {
                                String message = COLOR + "";
                                for (i2 = 0; i2 < unlisted_users_list.length - 1; ++i2) {
                                    message = String.valueOf(message) + unlisted_users_list[i2] + ", ";
                                }
                                result_message = String.valueOf(result_message) + message + " and " + unlisted_users_list[unlisted_users_list.length - 1] + " are now allowed to use \"" + name + ".\"";
                            }
                        } else if (unlisted_users_list.length == 1) {
                            result_message = String.valueOf(result_message) + (Object)COLOR + unlisted_users_list[0] + " is now allowed to use " + owner + "'s \"" + name + ".\"";
                        } else if (unlisted_users_list.length == 2) {
                            result_message = String.valueOf(result_message) + (Object)COLOR + unlisted_users_list[0] + " and " + unlisted_users_list[1] + " are now allowed to use " + owner + "'s \"" + name + ".\"";
                        } else {
                            String message = COLOR + "";
                            for (i2 = 0; i2 < unlisted_users_list.length - 1; ++i2) {
                                message = String.valueOf(message) + unlisted_users_list[i2] + ", ";
                            }
                            result_message = String.valueOf(result_message) + message + " and " + unlisted_users_list[unlisted_users_list.length - 1] + " are now allowed to use " + owner + "'s \"" + name + ".\"";
                        }
                    }
                    ArrayList<String> listed_users_list = new ArrayList<String>();
                    for (String user : listed_users) {
                        listed_users_list.add(user);
                    }
                    for (String user2 : unlisted_users_list) {
                        while (listed_users_list.contains(user2)) {
                            listed_users_list.remove(user2);
                        }
                    }
                    listed_users = new String[listed_users_list.size()];
                    for (i2 = 0; i2 < listed_users_list.size(); ++i2) {
                        if (listed_users_list.get(i2) == null || ((String)listed_users_list.get(i2)).equals("")) continue;
                        listed_users[i2] = (String)listed_users_list.get(i2);
                    }
                    continue;
                }
                if (this.parsing_warp_message) {
                    warp_message = String.valueOf(warp_message) + " " + parameters[j];
                    continue;
                }
                if (!this.parsing_no_warp_message) continue;
                no_warp_message = String.valueOf(no_warp_message) + " " + parameters[j];
            }
            result_message = this.stopParsingMessages(warp_message, no_warp_message, name, owner, player_is_owner, sender, result_message);
            if (!name.equalsIgnoreCase("info") && !name.equalsIgnoreCase("list") && !name.equals("all") && (player == null || owner.equalsIgnoreCase(player.getName()) || player.hasPermission("myultrawarps.change.other") || player.hasPermission("myultrawarps.admin"))) {
                if (name.equals(old_name) && owner.equals(old_owner) && listed == old_listed && restricted == old_restricted && warp_message.equals(old_warp_message) && no_warp_message.equals(old_no_warp_message) && listed_users.equals(old_listed_users)) {
                    sender.sendMessage((Object)ChatColor.RED + "You didn't change anything!");
                } else {
                    UltraWarp new_warp = new UltraWarp(owner, name, listed, restricted, warp_message, no_warp_message, listed_users, warp.location);
                    warps.remove(UWindex);
                    int insertion_index = 0;
                    for (UltraWarp my_warp : warps) {
                        if (my_warp.name.compareToIgnoreCase(name) >= 0 && (my_warp.name.compareToIgnoreCase(name) != 0 || my_warp.owner.compareToIgnoreCase(owner) > 0)) continue;
                        ++insertion_index;
                    }
                    warps.add(insertion_index, new_warp);
                    sender.sendMessage(result_message);
                    if (autosave_warps) {
                        this.saveTheWarps(sender, false);
                    }
                    if (!(name.equals(old_name) && owner.equals(old_owner))) {
                        int number_of_affected_switches = 0;
                        for (int i = 0; i < switches.size(); ++i) {
                            if (!myUltraWarps.switches.get((int)i).warp_name.equals(old_name) || !myUltraWarps.switches.get((int)i).warp_owner.equals(old_owner)) continue;
                            ++number_of_affected_switches;
                            UltraSwitch new_switch = new UltraSwitch(name, owner, myUltraWarps.switches.get((int)i).block, myUltraWarps.switches.get((int)i).cooldown_time, myUltraWarps.switches.get((int)i).max_uses, myUltraWarps.switches.get((int)i).global_cooldown, myUltraWarps.switches.get((int)i).cost, myUltraWarps.switches.get((int)i).exempted_players);
                            switches.remove(i);
                            insertion_index = 0;
                            for (UltraSwitch my_switch : switches) {
                                if (my_switch.warp_name.compareToIgnoreCase(warp.name) >= 0 && (my_switch.warp_name.compareToIgnoreCase(warp.name) != 0 || my_switch.warp_owner.compareToIgnoreCase(warp.owner) > 0)) continue;
                                ++insertion_index;
                            }
                            switches.add(insertion_index, new_switch);
                        }
                        if (number_of_affected_switches == 1) {
                            sender.sendMessage((Object)COLOR + "The switch that was linked to \"" + old_name + "\" has also been updated.");
                        } else if (number_of_affected_switches > 1) {
                            sender.sendMessage((Object)COLOR + "The " + number_of_affected_switches + " switches that were linked to \"" + old_name + "\" have also been updated.");
                        }
                    }
                }
            } else if (name.equalsIgnoreCase("info")) {
                sender.sendMessage((Object)ChatColor.RED + "Sorry, but you can't name a warp \"info\" because it interferes with the command " + (Object)COLOR + "/warp info" + (Object)ChatColor.RED + ".");
            } else if (name.equalsIgnoreCase("all")) {
                sender.sendMessage((Object)ChatColor.RED + "Sorry, but you can't name a warp \"all\" because it interferes with the command " + (Object)COLOR + "/warp all" + (Object)ChatColor.RED + ".");
            } else if (name.equalsIgnoreCase("list")) {
                sender.sendMessage((Object)ChatColor.RED + "Sorry, but you can't name a warp \"list\" because it interferes with the command " + (Object)COLOR + "/warp list" + (Object)ChatColor.RED + ".");
            } else {
                boolean warp_already_exists = false;
                for (int i = 0; i < warps.size(); ++i) {
                    if (!myUltraWarps.warps.get((int)i).owner.toLowerCase().startsWith(owner.toLowerCase()) || !myUltraWarps.warps.get((int)i).name.toLowerCase().startsWith(parameters[extra_param].toLowerCase())) continue;
                    warp_already_exists = true;
                }
                if (!warp_already_exists || !(sender instanceof Player) || sender.hasPermission("myultrawarps.change.other") || sender.hasPermission("myultrawarps.admin")) {
                    warps.remove(UWindex);
                    int insertion_index = 0;
                    for (UltraWarp my_warp : warps) {
                        if (my_warp.name.compareToIgnoreCase(name) >= 0 && (my_warp.name.compareToIgnoreCase(name) != 0 || my_warp.owner.compareToIgnoreCase(owner) >= 0)) continue;
                        ++insertion_index;
                    }
                    warps.add(insertion_index, new UltraWarp(owner, name, listed, restricted, warp_message, no_warp_message, listed_users, warp.location));
                    sender.sendMessage(result_message);
                    if (autosave_warps) {
                        this.saveTheWarps(sender, false);
                    }
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "You're not allowed to modify " + owner + "'s \"" + name + ".\"");
                }
            }
        } else if (player != null && player.getName().equals(UWowner)) {
            player.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + ".\"");
        } else if (UWowner != null) {
            sender.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + "\" in " + UWowner + "'s warps.");
        } else {
            sender.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + ".\"");
        }
    }

    private void changeDefaultMessage(int extra_param, CommandSender sender, String[] parameters) {
        Player player = null;
        if (sender instanceof Player) {
            player = (Player)sender;
        }
        Player online_target_player = null;
        boolean change_warp_message = true;
        if (parameters[0].toLowerCase().startsWith("no")) {
            change_warp_message = false;
        }
        String config_target = "server";
        if (player != null) {
            config_target = player.getName();
        }
        boolean target_is_group = false;
        if (extra_param < parameters.length && parameters[extra_param].equalsIgnoreCase("for")) {
            config_target = parameters[extra_param + 1];
            if (config_target.toLowerCase().startsWith("group:")) {
                config_target = config_target.substring(6);
                target_is_group = true;
            } else if (config_target.equalsIgnoreCase("global")) {
                config_target = "server";
            } else if (!config_target.equals("server")) {
                for (Player my_player2 : server.getOnlinePlayers()) {
                    if (!my_player2.getName().toLowerCase().startsWith(config_target.toLowerCase())) continue;
                    config_target = my_player2.getName();
                    online_target_player = my_player2;
                }
                if (online_target_player == null) {
                    for (OfflinePlayer my_player : server.getOfflinePlayers()) {
                        if (!my_player.getName().toLowerCase().startsWith(config_target.toLowerCase())) continue;
                        config_target = my_player.getName();
                    }
                }
            }
            extra_param+=2;
        }
        String new_message = "";
        if (parameters[extra_param - 1].toLowerCase().startsWith("warp:")) {
            new_message = parameters[extra_param - 1].substring(5);
        } else if (parameters[extra_param - 1].toLowerCase().startsWith("nowarp:")) {
            new_message = parameters[extra_param - 1].substring(7);
        }
        for (int i = extra_param; i < parameters.length; ++i) {
            if (!new_message.equals("")) {
                new_message = String.valueOf(new_message) + " ";
            }
            new_message = String.valueOf(new_message) + parameters[i];
        }
        if (player != null && config_target.equals(player.getName()) || player == null || player.hasPermission("myultrawarps.admin")) {
            if (config_target.equals("server")) {
                if (change_warp_message) {
                    SettingsSet set = settings.get("[server]");
                    set = set.setDefaultWarpMessage((String)new_message);
                    settings.put("[server]", set);
                    if (new_message.endsWith(".") || new_message.endsWith("!") || new_message.endsWith("?") || new_message.equals("")) {
                        sender.sendMessage((Object)COLOR + "You changed the default warp message to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + "\"");
                    } else {
                        sender.sendMessage((Object)COLOR + "You changed the default warp message to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + ".\"");
                    }
                } else {
                    SettingsSet set = settings.get("[server]");
                    set = set.setDefaultNoWarpMessage((String)new_message);
                    settings.put("[server]", set);
                    if (new_message.endsWith(".") || new_message.endsWith("!") || new_message.endsWith("?") || new_message.equals("")) {
                        sender.sendMessage((Object)COLOR + "You changed the default no warp message to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + "\"");
                    } else {
                        sender.sendMessage((Object)COLOR + "You changed the default no warp message to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + ".\"");
                    }
                }
            } else if (target_is_group) {
                boolean group_exists = false;
                for (String group : permissions.getGroups()) {
                    if (!group.toLowerCase().startsWith(config_target.toLowerCase())) continue;
                    config_target = group;
                    group_exists = true;
                }
                if (group_exists) {
                    SettingsSet set = settings.get("[" + config_target + "]");
                    if (set == null) {
                        set = settings.get("[server]");
                    }
                    if (change_warp_message) {
                        set = set.setDefaultWarpMessage((String)new_message);
                        if (new_message.endsWith(".") || new_message.endsWith("!") || new_message.endsWith("?") || new_message.equals("")) {
                            sender.sendMessage((Object)COLOR + "You changed the default warp message for the " + config_target + " group to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + "\"");
                        } else {
                            sender.sendMessage((Object)COLOR + "You changed the default warp message for the " + config_target + " group to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + ".\"");
                        }
                    } else {
                        set = set.setDefaultNoWarpMessage((String)new_message);
                        if (new_message.endsWith(".") || new_message.endsWith("!") || new_message.endsWith("?") || new_message.equals("")) {
                            sender.sendMessage((Object)COLOR + "You changed the default no warp message for the " + config_target + " group to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + "\"");
                        } else {
                            sender.sendMessage((Object)COLOR + "You changed the default no warp message for the " + config_target + "mgroup to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + ".\"");
                        }
                    }
                    settings.put("[" + config_target + "]", set);
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but I couldn't find a group called \"" + config_target + ".\"");
                }
            } else {
                Player target = server.getPlayerExact(config_target);
                SettingsSet set = target == null ? this.getSettings(config_target) : this.getSettings(target.getName());
                if (change_warp_message) {
                    set = set.setDefaultWarpMessage((String)new_message);
                    if (player != null && player.getName().equals(config_target)) {
                        if (new_message.endsWith(".") || new_message.endsWith("!") || new_message.endsWith("?") || new_message.equals("")) {
                            sender.sendMessage((Object)COLOR + "You changed your default warp message to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + "\"");
                        } else {
                            sender.sendMessage((Object)COLOR + "You changed your default warp message to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + ".\"");
                        }
                    } else if (new_message.endsWith(".") || new_message.endsWith("!") || new_message.endsWith("?") || new_message.equals("")) {
                        sender.sendMessage((Object)COLOR + "You changed " + config_target + "'s default warp message to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + "\"");
                    } else {
                        sender.sendMessage((Object)COLOR + "You changed " + config_target + "'s default warp message to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + ".\"");
                    }
                } else {
                    set = set.setDefaultNoWarpMessage((String)new_message);
                    if (player != null && player.getName().equals(config_target)) {
                        if (new_message.endsWith(".") || new_message.endsWith("!") || new_message.endsWith("?") || new_message.equals("")) {
                            sender.sendMessage((Object)COLOR + "You changed your default no warp message to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + "\"");
                        } else {
                            sender.sendMessage((Object)COLOR + "You changed your default no warp message to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + ".\"");
                        }
                    } else if (new_message.endsWith(".") || new_message.endsWith("!") || new_message.endsWith("?") || new_message.equals("")) {
                        sender.sendMessage((Object)COLOR + "You changed " + config_target + "'s default no warp message to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + "\"");
                    } else {
                        sender.sendMessage((Object)COLOR + "You changed " + config_target + "'s default no warp message to \"" + (Object)ChatColor.WHITE + myUltraWarps.colorCode((String)new_message) + (Object)COLOR + ".\"");
                    }
                }
                settings.put(config_target, set);
            }
            if (autosave_config) {
                this.saveTheConfig(sender, false);
            }
        } else {
            player.sendMessage((Object)ChatColor.RED + "Sorry, but you're only allowed to change your own default messages.");
        }
    }

  private void changeMaxWarps(int extra_param, CommandSender sender, String[] parameters)
  {
    Player player = null;
    if ((sender instanceof Player)) {
      player = (Player)sender;
    }
    String config_target = "server";
    if (player != null) {
      config_target = player.getName();
    }
    boolean target_is_group = false;
    Player online_target_player = null;
    if (parameters[extra_param].equalsIgnoreCase("for"))
    {
      config_target = parameters[(extra_param + 1)];
      if (config_target.toLowerCase().startsWith("group:"))
      {
        config_target = config_target.substring(6);
        target_is_group = true;
      }
      else if (config_target.equalsIgnoreCase("global"))
      {
        config_target = "server";
      }
      else if (!config_target.equals("server"))
      {
        for (Player my_player : server.getOnlinePlayers()) {
          if (my_player.getName().toLowerCase().startsWith(config_target.toLowerCase()))
          {
            config_target = my_player.getName();
            online_target_player = my_player;
          }
        }
        if (online_target_player == null) {
          for (OfflinePlayer my_player : server.getOfflinePlayers()) {
            if (my_player.getName().toLowerCase().startsWith(config_target.toLowerCase())) {
              config_target = my_player.getName();
            }
          }
        }
      }
      extra_param += 2;
    }
    int new_max_warps = -2;
    if (parameters.length > extra_param) {
      try
      {
        new_max_warps = Integer.parseInt(parameters[extra_param]);
      }
      catch (NumberFormatException exception)
      {
        if ((parameters[extra_param].equalsIgnoreCase("infinite")) || (parameters[extra_param].equalsIgnoreCase("infinity"))) {
          new_max_warps = -1;
        } else {
          sender.sendMessage(ChatColor.RED + "I don't know what \"" + parameters[extra_param] + 
            "\" means, but I know it's not the word \"infinite\" or the word \"infinity\" or an integer.");
        }
      }
    } else {
      sender.sendMessage(ChatColor.RED + "You forgot to tell me what you want me to change the max warps to!");
    }
    if (new_max_warps != -2)
    {
      if (config_target.equals("server"))
      {
        SettingsSet set = (SettingsSet)settings.get("[server]");
        set = set.setMaxWarps(new_max_warps);
        settings.put("[server]", set);
        if (new_max_warps != -1) {
          sender.sendMessage(COLOR + "You changed the default maximum number of warps to " + new_max_warps + ".");
        } else {
          sender.sendMessage(COLOR + "Everyone can now make as many warps as they want.");
        }
      }
      else if (target_is_group)
      {
        boolean group_exists = false;
        for (String group : permissions.getGroups()) {
          if (group.toLowerCase().startsWith(config_target.toLowerCase()))
          {
            config_target = group;
            group_exists = true;
          }
        }
        if (group_exists)
        {
          SettingsSet set = (SettingsSet)settings.get("[" + config_target + "]");
          set = set.setMaxWarps(new_max_warps);
          if (new_max_warps != -1) {
            sender.sendMessage(COLOR + "You changed the default maximum number of warps for the " + config_target + " group to " + new_max_warps + ".");
          } else {
            sender.sendMessage(COLOR + "Everyone in the " + config_target + " group can now make as many warps as they want.");
          }
          settings.put("[" + config_target + "]", set);
        }
        else
        {
          sender.sendMessage(ChatColor.RED + "Sorry, but I couldn't find a group called \"" + config_target + ".\"");
        }
      }
      else
      {
        SettingsSet set = getSettings(config_target);
        set = set.setMaxWarps(new_max_warps);
        if ((player != null) && (player.getName().equals(config_target)))
        {
          if (new_max_warps != -1) {
            sender.sendMessage(COLOR + "You can now make a maximum of " + new_max_warps + 
              " warps\n...but, uh...you're a myUltraWarps admin, so you can still make as many warps as you want....");
          } else {
            sender.sendMessage(COLOR + 
              "You can now make as many warps as you want\n...but, uh...you're a myUltraWarps admin, so you could already make as many warps as you want....");
          }
        }
        else if (new_max_warps != -1)
        {
          sender.sendMessage(COLOR + config_target + " can now make a maximum of " + new_max_warps + " warps.");
          if ((online_target_player != null) && (online_target_player.hasPermission("myultrawarps.admin"))){
            sender.sendMessage(COLOR + "...but, uh..." + config_target + " is a myUltraWarps admin, so they can still make as many warps as they want....");
          }
        }
        else
        {
          sender.sendMessage(COLOR + config_target + " can now make a maximum of " + new_max_warps + " warps.");
          if ((online_target_player != null) && (online_target_player.hasPermission("myultrawarps.admin"))) {
            sender.sendMessage(COLOR + "...but, uh..." + config_target + " is a myUltraWarps admin, so they could already make as many warps as they want....");
          }
        }
        settings.put(config_target, set);
      }
      if (autosave_config) {
        saveTheConfig(sender, false);
      }
    }
  }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void checkForUpdates(CommandSender sender) {
        URL url = null;
        try {
            url = new URL("http://dev.bukkit.org/server-mods/myultrawarps-v0/files.rss/");
        }
        catch (MalformedURLException exception) {
            myUltraWarps.processException("Nooo! Bad U.R.L.! Bad U.R.L.! The updater screwed up!", exception);
        }
        if (url == null) return;
        String new_version_name = null;
        String new_version_link = null;
        try {
            String title = "";
            String link = "";
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream in = null;
            try {
                in = url.openStream();
            }
            catch (IOException exception) {
                sender.sendMessage((Object)ChatColor.DARK_RED + "The myUltraWarps updater can't connect to BukkitDev!");
                return;
            }
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            do {
                if (eventReader.hasNext()) {
                    XMLEvent event = eventReader.nextEvent();
                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart().equals("title")) {
                            event = eventReader.nextEvent();
                            title = event.asCharacters().getData();
                            continue;
                        }
                        if (!event.asStartElement().getName().getLocalPart().equals("link")) continue;
                        event = eventReader.nextEvent();
                        link = event.asCharacters().getData();
                        continue;
                    }
                    if (!event.isEndElement() || !event.asEndElement().getName().getLocalPart().equals("item")) continue;
                    new_version_name = title;
                    new_version_link = link;
                } else {
                    break;
                }
                break;
            } while (true);
        }
        catch (XMLStreamException exception) {
            myUltraWarps.processException("Gah! XMLStreamExceptionThing! Come quick! Tell REALDrummer!", exception);
            return;
        }
        boolean new_version_is_out = false;
        String version = this.getDescription().getVersion();
        String newest_online_version = "";
        if (new_version_name == null) {
            myUltraWarps.tellOps((Object)ChatColor.DARK_RED + "Awww. Something went wrong getting the name of the newest version of myUltraWarps.", true, new String[0]);
            return;
        }
        if (new_version_name.split("v").length == 2) {
            newest_online_version = new_version_name.split("v")[new_version_name.split("v").length - 1].split(" ")[0];
            if (!(version.contains((CharSequence)"-DEV") || version.contains((CharSequence)"-PRE") || version.equalsIgnoreCase(newest_online_version))) {
                try {
                    if (Double.parseDouble(version) < Double.parseDouble(newest_online_version)) {
                        new_version_is_out = true;
                    }
                }
                catch (NumberFormatException in) {}
            }
        } else {
            sender.sendMessage((Object)ChatColor.RED + "Oh, no! REALDrummer forgot to put the version number in the title of the plugin on BukkitDev! The updater won't work! Quick! Tell him he messed up and he needs to fix it right away!");
        }
        if (new_version_is_out) {
            String fileLink = null;
            try {
                String line;
                BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(new_version_link).openConnection().getInputStream()));
                while ((line = reader.readLine()) != null) {
                    if (!line.contains((CharSequence)"<li class=\"user-action user-action-download\">")) continue;
                    fileLink = line.split("<a href=\"")[1].split("\">Download</a>")[0];
                }
                reader.close();
                reader = null;
            }
            catch (Exception exception) {
                myUltraWarps.processException("Uh-oh! The myUltraWarps updater couldn't contact bukkitdev.org!", exception);
                return;
            }
            if (fileLink == null) return;
            if (!new File(this.getDataFolder(), "myUltraWarps.jar").exists()) {
                BufferedInputStream in = null;
                FileOutputStream fout = null;
                try {
                    try {
                        int count;
                        url = new URL(fileLink);
                        in = new BufferedInputStream(url.openStream());
                        fout = new FileOutputStream(String.valueOf(this.getDataFolder().getAbsolutePath()) + "/myUltraWarps.jar");
                        byte[] data = new byte[1024];
                        while ((count = in.read(data, 0, 1024)) != -1) {
                            fout.write(data, 0, count);
                        }
                        if (!(sender instanceof Player)) {
                            sender.sendMessage(COLOR + "" + ChatColor.UNDERLINE + "'DING!' Your myUltraWarps v" + newest_online_version + " is ready and it smells AWESOME!! I downloaded it to your myUltraWarps folder! Go get it!");
                        }
                        for (Player player : server.getOnlinePlayers()) {
                            if (!player.hasPermission("myultrawarps.admin") || sender instanceof Player && sender.getName().equals(player.getName())) continue;
                            player.sendMessage(COLOR + "" + ChatColor.UNDERLINE + "'DING!' Your myUltraWarps v" + newest_online_version + " is ready and it smells AWESOME!! I downloaded it to your myUltraWarps folder! Go get it!");
                        }
                        return;
                    }
                    catch (Exception exception) {
                        myUltraWarps.processException("Shoot. myUltraWarps v" + newest_online_version + " is out, but something messed up the download. You're gonna have to go to BukkitDev and get it yourself. Sorry.", exception);
                        try {
                            if (in != null) {
                                in.close();
                            }
                            if (fout == null) return;
                            fout.close();
                            return;
                        }
                        catch (Exception var18_24) {}
                    }
                    return;
                }
                finally {
                    try {
                        if (in != null) {
                            in.close();
                        }
                        if (fout != null) {
                            fout.close();
                        }
                    }
                    catch (Exception var18_26) {}
                }
            }
            sender.sendMessage((Object)ChatColor.RED + "O_O Why is the newest version of myUltraWarps still sitting in your plugin folder?! Hurry up and put it on your server!");
            return;
        }
        sender.sendMessage((Object)COLOR + "Sorry, but no new versions of myUltraWarps are out yet.");
    }

    private void death(CommandSender sender, String[] parameters) {
        ArrayList<Location> death_history;
        Player player = (Player)sender;
        int amount = 1;
        if (parameters.length > 0) {
            try {
                amount = Integer.parseInt(parameters[0]);
                if (amount == 0) {
                    sender.sendMessage((Object)COLOR + "Well, here you are. You went back 0 deaths through your history.");
                    return;
                }
                if (amount < 0) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but I can't see into the future. At least...not that far ahead.");
                    return;
                }
            }
            catch (NumberFormatException exception) {
                sender.sendMessage((Object)ChatColor.RED + "Since when is \"" + parameters[0] + "\" an integer?");
                return;
            }
        }
        if ((death_history = death_histories.get(player.getName())) == null || death_history.size() == 0) {
            sender.sendMessage((Object)ChatColor.RED + "You haven't died yet!");
            return;
        }
        Integer last_warp_to_death_index = last_warp_to_death_indexes.get(player.getName());
        Location last_death = null;
        if (last_warp_to_death_index == null) {
            last_warp_to_death_index = death_history.size() - 1;
        }
        if (last_warp_to_death_index + 1 < amount) {
            if (last_warp_to_death_index > 1) {
                sender.sendMessage((Object)ChatColor.RED + "You can only go back " + last_warp_to_death_index + " more deaths.");
            } else if (last_warp_to_death_index == 1) {
                sender.sendMessage((Object)ChatColor.RED + "You can only go back one more death.");
            } else {
                sender.sendMessage((Object)ChatColor.RED + "Sorry, but I don't keep track of that many deaths. This is as far back as you can go.");
            }
            return;
        }
        last_death = death_history.get(last_warp_to_death_index + 1 - amount);
        if (last_death != null) {
            this.teleport(player, null, new UltraWarp((Object)COLOR + "HERE LIES " + player.getName() + " (death #" + (death_history.size() - last_warp_to_death_index) + "/" + death_history.size() + ")", last_death), true, null);
            last_warp_to_death_indexes.put(player.getName(), last_warp_to_death_index - amount);
        }
    }

    private void deathForward(CommandSender sender, String[] parameters) {
        Player player = (Player)sender;
        ArrayList<Location> death_history = death_histories.get(player.getName());
        Integer last_warp_to_death_index = last_warp_to_death_indexes.get(player.getName());
        int amount = 1;
        if (parameters.length > 0) {
            try {
                amount = Integer.parseInt(parameters[0]);
                if (amount == 0) {
                    player.sendMessage((Object)ChatColor.RED + "You're already at the place you were at 0 deaths ago.");
                    return;
                }
                if (amount < 0) {
                    player.sendMessage((Object)ChatColor.RED + "Uh...negative forward? Can you just give me a positive integer, please?");
                    return;
                }
            }
            catch (NumberFormatException exception) {
                player.sendMessage((Object)ChatColor.RED + "Since when is \"" + parameters[0] + "\" an integer?");
                return;
            }
        }
        if (death_history == null || death_history.size() == 0 || last_warp_to_death_index == null) {
            player.sendMessage((Object)ChatColor.RED + "You haven't died yet!");
            death_histories.put(player.getName(), new ArrayList());
        } else if (death_history.size() <= last_warp_to_death_index + 1 + amount) {
            if (death_history.size() - last_warp_to_death_index - 2 > 1) {
                player.sendMessage((Object)ChatColor.RED + "You can only go forward " + (death_history.size() - last_warp_to_death_index - 2) + " deaths.");
            } else if (death_history.size() - last_warp_to_death_index - 2 == 1) {
                player.sendMessage((Object)ChatColor.RED + "You can only go forward one death.");
            } else {
                player.sendMessage((Object)ChatColor.RED + "You're already at the last death in your history.");
            }
        } else {
            Location death = death_history.get(last_warp_to_death_index + 1 + amount);
            if (death != null) {
                this.teleport(player, null, new UltraWarp((Object)COLOR + "HERE LIES " + player.getName() + " (death #" + (death_history.size() - last_warp_to_death_index - amount - 1) + "/" + death_history.size() + ")", death), true, null);
                last_warp_to_death_indexes.put(player.getName(), last_warp_to_death_index + amount);
            }
        }
    }

    private void deleteWarp(int extra_param, CommandSender sender, String[] parameters) {
        int index;
        Player player = null;
        if (sender instanceof Player) {
            player = (Player)sender;
        }
        if (warps.get(index = UltraWarp.getWarpIndex(extra_param, sender, parameters)) != null && (player == null || player.getName().equals(myUltraWarps.warps.get((int)index).owner) || player.hasPermission("myultrawarps.get(i)s.delete.other") || player.hasPermission("myultrawarps.get(i)s.admin"))) {
            if (player != null && myUltraWarps.warps.get((int)index).owner.equals(player.getName())) {
                player.sendMessage((Object)COLOR + "You deleted \"" + myUltraWarps.warps.get((int)index).name + ".\"");
            } else {
                sender.sendMessage((Object)COLOR + "You deleted " + myUltraWarps.warps.get((int)index).owner + "'s warp \"" + myUltraWarps.warps.get((int)index).name + ".\"");
            }
            int switches_deleted = 0;
            for (int i = 0; i < switches.size(); ++i) {
                if (!myUltraWarps.warps.get((int)i).name.equals(myUltraWarps.switches.get((int)i).warp_name) || !myUltraWarps.warps.get((int)i).owner.equals(myUltraWarps.switches.get((int)i).warp_owner)) continue;
                switches.remove(i);
                --i;
                ++switches_deleted;
            }
            if (switches_deleted > 0) {
                if (autosave_switches) {
                    this.saveTheSwitches(sender, false);
                }
                if (player != null && myUltraWarps.warps.get((int)index).owner.equals(player.getName())) {
                    if (switches_deleted == 1) {
                        player.sendMessage((Object)COLOR + "You also unlinked your switch that was linked to it.");
                    } else {
                        player.sendMessage((Object)COLOR + "You also unlinked your " + switches_deleted + " switches that were linked to it.");
                    }
                } else if (switches_deleted == 1) {
                    sender.sendMessage((Object)COLOR + "You also unlinked a switch that was linked to it.");
                } else {
                    sender.sendMessage((Object)COLOR + "You also unlinked " + switches_deleted + " switches that were linked to it.");
                }
            }
            warps.remove(index);
            if (autosave_warps) {
                this.saveTheWarps(sender, false);
            }
        } else if (warps.get(index) != null && player != null) {
            player.sendMessage((Object)ChatColor.RED + "You don't have permission to delete " + myUltraWarps.warps.get((int)index).owner + "'s \"" + myUltraWarps.warps.get((int)index).name + ".\"");
        } else if (player != null && (UWowner == null || player.getName().equals(UWowner))) {
            player.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + ".\"");
        } else if (UWowner != null) {
            sender.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + "\" in " + UWowner + "'s warps.");
        }
    }

    private void forward(CommandSender sender, String[] parameters) {
        Player player = (Player)sender;
        ArrayList<UltraWarp> warp_history = warp_histories.get(player.getName());
        Integer last_warp_index = last_warp_indexes.get(player.getName());
        int amount = 1;
        if (parameters.length > 0) {
            try {
                amount = Integer.parseInt(parameters[0]);
                if (amount == 0) {
                    player.sendMessage((Object)ChatColor.RED + "You're already at the place you were at 0 warps ago.");
                    return;
                }
                if (amount < 0) {
                    player.sendMessage((Object)ChatColor.RED + "Uh...negative forward? Can you just give me a positive integer, please?");
                    return;
                }
            }
            catch (NumberFormatException exception) {
                player.sendMessage((Object)ChatColor.RED + "Since when is \"" + parameters[0] + "\" an integer?");
                return;
            }
        }
        if (warp_history == null || warp_history.size() == 0 || last_warp_index == null) {
            player.sendMessage((Object)ChatColor.RED + "You haven't warped anywhere yet!");
            warp_histories.put(player.getName(), new ArrayList());
        } else if (warp_history.size() <= last_warp_index + amount) {
            if (warp_history.size() - last_warp_index - 2 > 1) {
                player.sendMessage((Object)ChatColor.RED + "You can only go forward " + (warp_history.size() - last_warp_index - 2) + " warps.");
            } else if (warp_history.size() - last_warp_index - 2 == 1) {
                player.sendMessage((Object)ChatColor.RED + "You can only go forward one warp.");
            } else {
                player.sendMessage((Object)ChatColor.RED + "You're already at the last warp in your history.");
            }
        } else {
            UltraWarp warp = warp_history.get(last_warp_index + amount);
            if (warp != null) {
                boolean player_is_listed = false;
                for (String listed_player : warp.listed_users) {
                    if (!listed_player.equals(player.getName())) continue;
                    player_is_listed = true;
                }
                if (player.hasPermission("myultrawarps.admin") || player.hasPermission("myultrawarps.warptowarp.other") || warp.owner.equals(player.getName()) || !warp.restricted && !player_is_listed || warp.restricted && player_is_listed) {
                    this.teleport(player, null, warp, true, null);
                    last_warp_indexes.put(player.getName(), last_warp_index + amount);
                } else {
                    player.sendMessage(myUltraWarps.colorCode(warp.no_warp_message.replaceAll("\\[player\\]", player.getName())));
                }
            }
        }
    }

    private void from(CommandSender sender, String[] parameters) {
        Player player = (Player)sender;
        Player target_player = null;
        for (Player my_player : server.getOnlinePlayers()) {
            if (!my_player.getName().toLowerCase().startsWith(parameters[0].toLowerCase())) continue;
            target_player = my_player;
        }
        if (target_player != null && !target_player.equals((Object)player) && (target_player.hasPermission("myultrawarps.from.accept") || target_player.hasPermission("myultrawarps.user") || target_player.hasPermission("myultrawarps.admin") || player.hasPermission("myultrawarps.admin")) && (blocked_players.get(target_player.getName()) == null || !blocked_players.get(target_player.getName()).contains(player.getName()))) {
            ArrayList requesting_players;
            if (player.hasPermission("myultrawarps.from.norequest") || player.hasPermission("myultrawarps.admin") || to_teleport_requests.get(player.getName()) != null && to_teleport_requests.get(player.getName()).contains(target_player.getName())) {
                requesting_players = to_teleport_requests.get(player.getName());
                if (requesting_players == null) {
                    requesting_players = new ArrayList();
                }
                while (requesting_players.contains(target_player.getName())) {
                    requesting_players.remove(target_player.getName());
                }
                to_teleport_requests.put(player.getName(), requesting_players);
                if (this.teleport((Player)target_player, new UltraWarp("&aThis is the spot you were at before " + player.getName() + " teleported you to them.", target_player.getLocation()), new UltraWarp("&aThis is the spot you were at when you were teleported to " + player.getName() + ".", player.getLocation()), false, (CommandSender)player)) {
                    target_player.sendMessage((Object)COLOR + "Here's your " + player.getName() + "!");
                    player.sendMessage((Object)COLOR + "Look! I brought you a " + target_player.getName() + "!");
                }
            } else {
                player.sendMessage((Object)COLOR + "Hang on. Let me ask " + target_player.getName() + " if it's okay.");
                target_player.sendMessage((Object)COLOR + player.getName() + " would like to teleport you to them. Is that okay?");
                requesting_players = from_teleport_requests.get(target_player.getName());
                if (requesting_players == null) {
                    requesting_players = new ArrayList();
                }
                requesting_players.add(player.getName());
                from_teleport_requests.put(target_player.getName(), requesting_players);
            }
        } else if (target_player != null && blocked_players.get(target_player.getName()) != null && blocked_players.get(target_player.getName()).contains(player.getName())) {
            player.sendMessage((Object)ChatColor.RED + "Sorry, but " + target_player.getName() + " has blocked you. You can't send them teleportation requests anymore.");
        } else if (target_player != null && target_player.equals((Object)player)) {
            player.sendMessage((Object)ChatColor.RED + "Can you explain to me how I'm supposed to teleport you to yourself?");
        } else if (!(target_player == null || target_player.hasPermission("myultrawarps.to") || target_player.hasPermission("myultrawarps.user") || target_player.hasPermission("myultrawarps.admin") || player.hasPermission("myultrawarps.admin"))) {
            player.sendMessage((Object)ChatColor.RED + "Sorry, but " + target_player.getName() + " doesn't have permission to teleport to other poeple.");
        } else {
            player.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + parameters[0] + "\" anywhere.");
        }
    }

    private void fullSwitchList(CommandSender sender, String[] parameters) {
        if (switches.size() == 0) {
            sender.sendMessage((Object)ChatColor.RED + "No one has made any switches yet!");
            return;
        }
        Player player = null;
        String sender_name = "[console]";
        if (sender instanceof Player) {
            player = (Player)sender;
            sender_name = player.getName();
        }
        boolean by_name = false;
        if (full_list_organization_by_user.containsKey(sender_name)) {
            by_name = full_list_organization_by_user.get(sender_name);
        }
        int extra_param = 0;
        if (parameters.length > 1 && parameters[0].equalsIgnoreCase("warp") && parameters[1].equalsIgnoreCase("list")) {
            extra_param = 2;
        }
        String owner = null;
        String type = null;
        int page_number = 1;
        for (int i = extra_param; i < parameters.length; ++i) {
            if (parameters[i].toLowerCase().startsWith("type:o")) {
                type = "open";
                continue;
            }
            if (parameters[i].toLowerCase().startsWith("type:a")) {
                type = "advertised";
                continue;
            }
            if (parameters[i].toLowerCase().startsWith("type:s")) {
                type = "secret";
                continue;
            }
            if (parameters[i].toLowerCase().startsWith("type:p")) {
                type = "private";
                continue;
            }
            if (parameters[i].toLowerCase().startsWith("owner:")) {
                owner = myUltraWarps.autoCompleteName(parameters[i].substring(6));
                by_name = false;
                continue;
            }
            if (parameters[i].equalsIgnoreCase("page")) {
                if (parameters.length <= i + 1) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me which page you want me to show you!");
                    return;
                }
                try {
                    page_number = Integer.parseInt(parameters[i + 1]);
                }
                catch (NumberFormatException exception) {
                    sender.sendMessage((Object)ChatColor.RED + "Since when is \"" + parameters[i + 1] + "\" an integer?");
                    return;
                }
                if (page_number == 0) {
                    sender.sendMessage((Object)ChatColor.RED + "I think you know very well that there is no page 0, you little trouble maker. Nice try.");
                    return;
                }
                if (page_number >= 0) continue;
                sender.sendMessage((Object)ChatColor.RED + "Negative page numbers? Really? Try again.");
                return;
            }
            if (!parameters[i].equals("by")) continue;
            if (parameters.length <= i + 1) {
                sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me how you want me to organize the list!");
                return;
            }
            if (parameters[i + 1].equalsIgnoreCase("owner")) {
                by_name = false;
                continue;
            }
            if (parameters[i + 1].equalsIgnoreCase("name")) {
                by_name = true;
                continue;
            }
            sender.sendMessage((Object)ChatColor.RED + "I'm not sure how to organize a list \"by " + parameters[i + 1] + "\". I can only organize this list by owner or by name.");
            return;
        }
        full_list_organization_by_user.put(sender_name, by_name);
        String output = "";
        if (by_name) {
            for (UltraSwitch _switch : switches) {
                UltraWarp warp = UltraWarp.getWarp(0, sender, String.valueOf(_switch.warp_owner) + "'s", _switch.warp_name);
                if (warp == null || type != null && !warp.getType().equals(type) || owner != null && !warp.owner.equals(owner)) continue;
                output = String.valueOf(output) + (output.equals("") ? "" : ", ") + warp.getColoredName();
            }
        } else {
            ArrayList<String> switch_items = new ArrayList<String>();
            for (int i2 = 0; i2 < switches.size(); ++i2) {
                UltraWarp warp = UltraWarp.getWarp(0, sender, String.valueOf(myUltraWarps.switches.get((int)i2).warp_owner) + "'s", myUltraWarps.switches.get((int)i2).warp_name);
                if (warp == null || type != null && !warp.getType().equals(type)) continue;
                if (owner != null && !warp.owner.equals(owner)) continue;
                int number = 1;
                while (i2 + 1 < switches.size() && myUltraWarps.switches.get((int)(i2 + 1)).warp_owner.equals(warp.owner) && myUltraWarps.switches.get((int)(i2 + 1)).warp_name.equals(warp.name)) {
                    ++number;
                    ++i2;
                }
                int switch_item_index = -1;
                for (int j = 0; j < switch_items.size(); ++j) {
                    if (!((String)switch_items.get(j)).startsWith((Object)COLOR + warp.owner)) continue;
                    switch_item_index = j;
                    break;
                }
                if (switch_item_index != -1) {
                    switch_items.set(switch_item_index, String.valueOf((String)switch_items.get(switch_item_index)) + (Object)ChatColor.WHITE + ", " + warp.getColoredName() + (number > 1 ? new StringBuilder().append((Object)ChatColor.WHITE).append(" x").append(number).toString() : ""));
                    continue;
                }
                String switch_item = (Object)COLOR + warp.owner + "'s switches: " + warp.getColoredName() + (number > 1 ? new StringBuilder().append((Object)ChatColor.WHITE).append(" x").append(number).toString() : "");
                for (switch_item_index = 0; switch_item_index < switch_items.size() && ((String)switch_items.get(switch_item_index)).compareTo(switch_item) < 0; ++switch_item_index) {
                }
                myUltraWarps.debug("new warp item's index: " + switch_item_index);
                switch_items.add(switch_item_index, switch_item);
            }
            output = myUltraWarps.combine(switch_items.toArray(), "\n", new int[0]);
        }
        sender.sendMessage(myUltraWarps.paginate(output, "/full switch list page [#]", "There are only [total] of switches.", page_number, sender instanceof Player));
    }

    private void fullWarpList(CommandSender sender, String[] parameters) {
        if (warps.size() == 0) {
            sender.sendMessage((Object)ChatColor.RED + "No one has made any warps yet!");
            return;
        }
        Player player = null;
        String sender_name = "[console]";
        if (sender instanceof Player) {
            player = (Player)sender;
            sender_name = player.getName();
        }
        boolean by_name = false;
        if (full_list_organization_by_user.containsKey(sender_name)) {
            by_name = full_list_organization_by_user.get(sender_name);
        }
        int extra_param = 0;
        if (parameters.length > 1 && parameters[0].equalsIgnoreCase("warp") && parameters[1].equalsIgnoreCase("list")) {
            extra_param = 2;
        }
        String owner = null;
        String type = null;
        int page_number = 1;
        for (int i = extra_param; i < parameters.length; ++i) {
            if (parameters[i].toLowerCase().startsWith("type:o")) {
                type = "open";
                continue;
            }
            if (parameters[i].toLowerCase().startsWith("type:a")) {
                type = "advertised";
                continue;
            }
            if (parameters[i].toLowerCase().startsWith("type:s")) {
                type = "secret";
                continue;
            }
            if (parameters[i].toLowerCase().startsWith("type:p")) {
                type = "private";
                continue;
            }
            if (parameters[i].toLowerCase().startsWith("owner:")) {
                owner = myUltraWarps.autoCompleteName(parameters[i].substring(6));
                by_name = false;
                continue;
            }
            if (parameters[i].equalsIgnoreCase("page")) {
                if (parameters.length <= i + 1) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me which page you want me to show you!");
                    return;
                }
                try {
                    page_number = Integer.parseInt(parameters[i + 1]);
                }
                catch (NumberFormatException exception) {
                    sender.sendMessage((Object)ChatColor.RED + "Since when is \"" + parameters[i + 1] + "\" an integer?");
                    return;
                }
                if (page_number == 0) {
                    sender.sendMessage((Object)ChatColor.RED + "I think you know very well that there is no page 0, you little trouble maker. Nice try.");
                    return;
                }
                if (page_number >= 0) continue;
                sender.sendMessage((Object)ChatColor.RED + "Negative page numbers? Really? Try again.");
                return;
            }
            if (!parameters[i].equals("by")) continue;
            if (parameters.length <= i + 1) {
                sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me how you want me to organize the list!");
                return;
            }
            if (parameters[i + 1].equalsIgnoreCase("owner")) {
                by_name = false;
                continue;
            }
            if (parameters[i + 1].equalsIgnoreCase("name")) {
                by_name = true;
                continue;
            }
            sender.sendMessage((Object)ChatColor.RED + "I'm not sure how to organize a list \"by " + parameters[i + 1] + "\". I can only organize this list by owner or by name.");
            return;
        }
        full_list_organization_by_user.put(sender_name, by_name);
        String output = "";
        if (by_name) {
            for (UltraWarp warp : warps) {
                if (type != null && !warp.getType().equals(type) || owner != null && !warp.owner.equals(owner)) continue;
                output = String.valueOf(output) + (output.equals("") ? "" : ", ") + warp.getColoredName();
            }
        } else {
            ArrayList<String> warp_items = new ArrayList<String>();
            for (UltraWarp warp : warps) {
                if (type != null && !warp.getType().equals(type)) continue;
                if (owner != null && !warp.owner.equals(owner)) continue;
                int warp_item_index = -1;
                for (int i2 = 0; i2 < warp_items.size(); ++i2) {
                    if (!((String)warp_items.get(i2)).startsWith((Object)COLOR + warp.owner)) continue;
                    warp_item_index = i2;
                    break;
                }
                if (warp_item_index != -1) {
                    warp_items.set(warp_item_index, String.valueOf((String)warp_items.get(warp_item_index)) + (Object)ChatColor.WHITE + ", " + warp.getColoredName());
                    continue;
                }
                String warp_item = (Object)COLOR + warp.owner + "'s warps: " + warp.getColoredName();
                for (warp_item_index = 0; warp_item_index < warp_items.size() && ((String)warp_items.get(warp_item_index)).compareTo(warp_item) < 0; ++warp_item_index) {
                }
                myUltraWarps.debug("new warp item's index: " + warp_item_index);
                warp_items.add(warp_item_index, warp_item);
            }
            output = myUltraWarps.combine(warp_items.toArray(), "\n", new int[0]);
        }
        sender.sendMessage(myUltraWarps.paginate(output, "/full warp list page [#]", "There are only [total] of warps.", page_number, sender instanceof Player));
    }

    private void jump(CommandSender sender) {
        Player player = (Player)sender;
        Block block = myUltraWarps.getTargetBlock(player, true);
        if (block != null) {
            Object[] half_height_block_IDs = new Short[]{44, 93, 94, 96, 111, 126, 149, 150, 151};
            Object[] over_height_block_IDs = new Short[]{85, 107, 113};
            double y = block.getLocation().getY() + 1.0;
            if (myUltraWarps.contains(half_height_block_IDs, (short)block.getTypeId()) && (block.getType() != Material.STEP || block.getData() < 8)) {
                y-=0.5;
            } else if (myUltraWarps.contains(over_height_block_IDs, (short)block.getTypeId())) {
                y+=0.5;
            }
            this.teleport(player, null, new UltraWarp((Object)COLOR + "You jumped!", new Location(block.getLocation().getWorld(), block.getLocation().getX() + 0.5, y, block.getLocation().getZ() + 0.5, player.getLocation().getYaw(), player.getLocation().getPitch())), true, null);
        } else {
            player.sendMessage((Object)ChatColor.RED + "Sorry, but I can't see that far!");
        }
    }

    private void home(CommandSender sender, String[] parameters) {
        Player player = (Player)sender;
        UltraWarp warp = null;
        String owner = parameters.length > 0 && parameters[0].toLowerCase().endsWith("'s") ? myUltraWarps.autoCompleteName(parameters[0].substring(0, parameters[0].length() - 2)) : player.getName();
        for (int i = 0; i < warps.size(); ++i) {
            if (!myUltraWarps.warps.get((int)i).name.equals("home") || !myUltraWarps.warps.get((int)i).owner.toLowerCase().startsWith(owner.toLowerCase())) continue;
            warp = warps.get(i);
        }
        if (warp != null) {
            if (player.getName().equals(owner) || player.hasPermission("myultrawarps.home.other") || player.hasPermission("myultrawarps.admin")) {
                if (this.teleport(player, new UltraWarp("&aThis is the spot you were at before you teleported home.", player.getLocation()), warp, false, null)) {
                    if (player.getName().equals(owner) && !warp.warp_message.equals("")) {
                        player.sendMessage(myUltraWarps.colorCode(warp.warp_message.replaceAll("\\[player\\]", player.getName())));
                    } else if (!warp.warp_message.equals("")) {
                        player.sendMessage(myUltraWarps.colorCode("&aWelcome home...wait, you're not " + warp.owner + "! &o" + warp.owner.toUpperCase() + "!!!!"));
                    }
                }
            } else {
                player.sendMessage(myUltraWarps.colorCode(warp.no_warp_message.replaceAll("\\[player\\]", player.getName())));
            }
        } else if (player.getName().toLowerCase().startsWith(owner.toLowerCase())) {
            player.sendMessage((Object)ChatColor.RED + "You need to set your home before you can warp to it!");
        } else {
            player.sendMessage((Object)ChatColor.RED + "I couldn't find " + owner + "'s home.");
        }
    }

    private void linkWarp(int extra_param, CommandSender sender, String[] parameters) {
        Player player = (Player)sender;
        Block target_block = myUltraWarps.getTargetBlock(player, false);
        UltraWarp warp = null;
        if (target_block != null && UltraSwitch.getSwitchType(target_block) != null) {
            for (UltraSwitch my_switch : switches) {
                if (!target_block.getLocation().equals((Object)my_switch.location) || !UltraSwitch.getSwitchType(target_block).equals(my_switch.switch_type)) continue;
                if (player.getName().equals(my_switch.warp_owner)) {
                    sender.sendMessage((Object)ChatColor.RED + "This " + my_switch.switch_type + " is already linked to \"" + my_switch.warp_name + "\".");
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "This " + my_switch.switch_type + " is already linked to " + my_switch.warp_owner + "'s \"" + my_switch.warp_name + "\".");
                }
                return;
            }
            warp = UltraWarp.getWarp(extra_param, sender, parameters);
            if (warp != null && (player.getName().equals(warp.owner) || player.hasPermission("myultrawarps.link.other") || player.hasPermission("myultrawarps.admin"))) {
                boolean parse_cooldown_time = false;
                boolean global = false;
                double cost = 0.0;
                int max_uses = 0;
                int cooldown_time = 0;
                String cooldown_time_string = null;
                String[] exempted_players = new String[]{};
                for (int j = 0; j < parameters.length; ++j) {
                    if (parameters[j].toLowerCase().startsWith("cooldown:")) {
                        parse_cooldown_time = true;
                        cooldown_time_string = parameters[j].substring(9);
                        continue;
                    }
                    if (parameters[j].toLowerCase().startsWith("uses:")) {
                        parse_cooldown_time = false;
                        try {
                            max_uses = Integer.parseInt(parameters[j].substring(5));
                            continue;
                        }
                        catch (NumberFormatException exception) {
                            sender.sendMessage((Object)ChatColor.RED + "You can't use something \"" + parameters[j].substring(5) + "\" times!");
                            return;
                        }
                    }
                    if (parameters[j].equalsIgnoreCase("global:true")) {
                        parse_cooldown_time = false;
                        global = true;
                        continue;
                    }
                    if (!parse_cooldown_time) continue;
                    cooldown_time_string = cooldown_time_string == null || cooldown_time_string.equals("") ? parameters[j] : String.valueOf(cooldown_time_string) + " " + parameters[j];
                }
                if (cooldown_time_string != null) {
                    cooldown_time = myUltraWarps.readTime(cooldown_time_string);
                }
                int insertion_index = 0;
                for (UltraSwitch my_switch2 : switches) {
                    if (my_switch2.warp_name.compareToIgnoreCase(warp.name) >= 0 && (my_switch2.warp_name.compareToIgnoreCase(warp.name) != 0 || my_switch2.warp_owner.compareToIgnoreCase(warp.owner) > 0)) continue;
                    ++insertion_index;
                }
                switches.add(insertion_index, new UltraSwitch(warp.name, warp.owner, target_block, cooldown_time, max_uses, global, cost, exempted_players));
                if (autosave_switches) {
                    this.saveTheSwitches(sender, false);
                }
                if (player.getName().toLowerCase().startsWith(warp.owner.toLowerCase())) {
                    player.sendMessage((Object)COLOR + "You linked \"" + warp.name + "\" to this " + UltraSwitch.getSwitchType(target_block) + ".");
                } else {
                    player.sendMessage((Object)COLOR + "You linked " + warp.owner + "'s \"" + warp.name + "\" to this " + UltraSwitch.getSwitchType(target_block) + ".");
                }
            } else if (warp != null) {
                player.sendMessage((Object)ChatColor.RED + "You're not allowed to link warps that don't belong to you!");
            } else if (player.getName().equals(UWowner)) {
                player.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + ".\"");
            } else {
                player.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + "\" in " + UWowner + "'s warps.");
            }
        } else if (target_block != null) {
            player.sendMessage((Object)ChatColor.RED + "You can only link warps to buttons, pressure plates (non-weighted), or levers.");
        } else {
            player.sendMessage((Object)ChatColor.RED + "Please point at the switch you want to link your warp to and try " + (Object)COLOR + "/link " + (Object)ChatColor.RED + "again.");
        }
    }

    private void moveWarp(int extra_param, CommandSender sender, String[] parameters) {
        Player player = (Player)sender;
        UltraWarp warp = UltraWarp.getWarp(extra_param, sender, parameters);
        if (warp != null && (player.getName().equals(warp.owner) || player.hasPermission("myultrawarps.change.other") || player.hasPermission("myultrawarps.admin"))) {
            warps.set(UWindex, new UltraWarp(warp.owner, warp.name, warp.listed, warp.restricted, warp.warp_message, warp.no_warp_message, warp.listed_users, player.getLocation()));
            if (autosave_warps) {
                this.saveTheWarps(sender, false);
            }
            if (player.getName().equals(warp.owner)) {
                player.sendMessage((Object)COLOR + "You moved \"" + myUltraWarps.warps.get((int)myUltraWarps.UWindex).name + ".\"");
            } else {
                player.sendMessage((Object)COLOR + "You moved " + myUltraWarps.warps.get((int)myUltraWarps.UWindex).owner + "'s warp \"" + myUltraWarps.warps.get((int)myUltraWarps.UWindex).name + ".\"");
            }
        } else if (warp != null) {
            player.sendMessage((Object)ChatColor.RED + "You don't have permission to modify this warp.");
        } else if (player.getName().equals(UWowner)) {
            player.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + ".\"");
        } else {
            player.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + "\" in " + UWowner + "'s warps.");
        }
    }

    private void send(CommandSender sender, String[] parameters) {
        Player player = null;
        if (sender instanceof Player) {
            player = (Player)sender;
        }
        Player target_player = null;
        for (Player my_player : server.getOnlinePlayers()) {
            if (!my_player.getName().toLowerCase().startsWith(parameters[0].toLowerCase())) continue;
            target_player = my_player;
        }
        int extra_param = 0;
        if (parameters[1].equalsIgnoreCase("to")) {
            ++extra_param;
        }
        if (target_player != null) {
            if (parameters[1 + extra_param].equalsIgnoreCase("there")) {
                if (player != null) {
                    Block target_block = myUltraWarps.getTargetBlock(player, true);
                    if (target_block != null) {
                        Location target_location = target_block.getLocation();
                        target_location.setY(target_location.getY() + 1.0);
                        if (this.teleport(target_player, new UltraWarp("God", "coordinates", false, false, "&aThis is the spot you were at before " + player.getName() + " teleported you elsewhere.", "", null, target_player.getLocation()), new UltraWarp("God", "coordinates", false, false, "&aThis is the spot you were at when you were teleported by " + player.getName() + ".", "", null, target_location), false, (CommandSender)player)) {
                            target_player.sendMessage((Object)COLOR + player.getName() + " teleported you here.");
                            if (target_player.getName().toLowerCase().startsWith("a") || target_player.getName().toLowerCase().startsWith("e") || target_player.getName().toLowerCase().startsWith("i") || target_player.getName().toLowerCase().startsWith("o") || target_player.getName().toLowerCase().startsWith("u")) {
                                player.sendMessage((Object)COLOR + "Hark! Over yonder! An " + target_player.getName() + " cometh!");
                            } else {
                                player.sendMessage((Object)COLOR + "Hark! Over yonder! A " + target_player.getName() + " cometh!");
                            }
                        }
                    } else {
                        player.sendMessage((Object)ChatColor.RED + "The block you targeted is too far away.");
                    }
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Please point out the place you want to teleport " + target_player.getName() + ". Oh, yeah. You still can't. You're still a console.");
                }
            } else if (parameters[1 + extra_param].equalsIgnoreCase("warp")) {
                if (parameters.length >= 3 + extra_param) {
                    UltraWarp warp = UltraWarp.getWarp(2 + extra_param, sender, parameters);
                    if (warp != null) {
                        String sender_name = "someone";
                        if (player != null) {
                            sender_name = player.getName();
                        }
                        if (this.teleport(target_player, new UltraWarp("God", "coordinates", false, false, "&aThis is the spot you were at before " + (String)sender_name + " teleported you elsewhere.", "", null, target_player.getLocation()), warp, false, (CommandSender)player)) {
                            if (sender_name.equals("someone")) {
                                sender_name = "Someone";
                            }
                            target_player.sendMessage((Object)COLOR + (String)sender_name + " telported you to " + warp.owner + "'s \"" + warp.name + ".\"");
                            if (player != null && warp.owner.equals(player.getName())) {
                                player.sendMessage((Object)COLOR + "I sent " + target_player.getName() + " to \"" + warp.name + ".\"");
                            } else {
                                sender.sendMessage((Object)COLOR + "I sent " + target_player.getName() + " to " + warp.owner + "'s \"" + warp.name + ".\"");
                            }
                        }
                    } else if (player != null && (UWowner == null || player.getName().equals(UWowner))) {
                        player.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + ".\"");
                    } else if (UWowner != null) {
                        sender.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + "\" in " + UWowner + "'s warps.");
                    }
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me what warp you want to warp " + target_player.getName() + " to!");
                }
            } else if (parameters[1 + extra_param].equalsIgnoreCase("player")) {
                if (parameters.length >= 3 + extra_param) {
                    Player final_destination_player = null;
                    for (Player online_player : server.getOnlinePlayers()) {
                        if (!online_player.getName().toLowerCase().startsWith(parameters[2 + extra_param].toLowerCase())) continue;
                        final_destination_player = online_player;
                    }
                    if (final_destination_player != null) {
                        String sender_name = "someone";
                        if (player != null) {
                            sender_name = player.getName();
                        }
                        if (this.teleport(target_player, new UltraWarp("God", "coordinates", false, false, "&aThis is the spot you were at before " + (String)sender_name + " teleported you elsewhere.", "", null, target_player.getLocation()), new UltraWarp("God", "coordinates", false, false, "&aThis is the spot you were at when you were teleported by " + (String)sender_name + ".", "", null, target_player.getLocation()), false, sender)) {
                            target_player.sendMessage((Object)COLOR + (String)sender_name + " teleported you to " + final_destination_player.getName() + ".");
                            sender.sendMessage((Object)COLOR + "I sent " + target_player.getName() + " to " + final_destination_player.getName() + ".");
                        }
                    } else {
                        for (OfflinePlayer offline_player : server.getOfflinePlayers()) {
                            if (!offline_player.getName().toLowerCase().startsWith(parameters[0].toLowerCase())) continue;
                            sender.sendMessage((Object)ChatColor.RED + offline_player.getName() + " is not online right now.");
                            return;
                        }
                        sender.sendMessage((Object)ChatColor.RED + "Sorry, but I've never seen anyone with a name starting with \"" + parameters[0] + "\" come on this server.");
                    }
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me which player you want me to warp " + target_player.getName() + " to!");
                }
            } else {
                sender.sendMessage("/send [player] (\"to\") [\"there\"/\"warp\" [warp]/\"player\" [player]]");
            }
        } else {
            OfflinePlayer[] arrofflinePlayer = server.getOfflinePlayers();
            int n = arrofflinePlayer.length;
            int offline_player = 0;
            while (offline_player < n) {
                OfflinePlayer offline_player2 = arrofflinePlayer[offline_player];
                if (offline_player2.getName().toLowerCase().startsWith(parameters[0].toLowerCase())) {
                    sender.sendMessage((Object)ChatColor.RED + offline_player2.getName() + " is not online right now.");
                    return;
                }
                ++offline_player;
            }
            sender.sendMessage((Object)ChatColor.RED + "Sorry, but I've never seen anyone with a name starting with \"" + parameters[0] + "\" come on this server.");
        }
    }

    private void setHome(CommandSender sender, String[] parameters) {
        Player player = (Player)sender;
        int extra_param = 0;
        if (parameters != null && parameters.length > 0 && parameters[0].equalsIgnoreCase("home")) {
            ++extra_param;
        }
        String owner = null;
        owner = parameters != null && parameters.length > extra_param && parameters[extra_param].toLowerCase().endsWith("'s") ? myUltraWarps.autoCompleteName(parameters[extra_param].substring(0, parameters[extra_param].length() - 2)) : player.getName();
        if (player.getName().toLowerCase().startsWith(owner.toLowerCase()) || player.hasPermission("myultrawarps.sethome.other") || player.hasPermission("myultrawarps.admin")) {
            for (int i = 0; i < warps.size(); ++i) {
                if (!myUltraWarps.warps.get((int)i).name.equals("home") || !myUltraWarps.warps.get((int)i).owner.toLowerCase().startsWith(owner.toLowerCase())) continue;
                warps.remove(i);
            }
            warps.add(new UltraWarp(owner, "home", false, true, "&aWelcome home, " + owner + ". We have awaited your return.", "&cYou're not allowed to just warp to other people's homes! The nerve!", new String[0], player.getLocation()));
            if (autosave_warps) {
                this.saveTheWarps(sender, false);
            }
            if (owner.equals(player.getName())) {
                player.sendMessage((Object)COLOR + "Henceforth, this shall be your new home.");
            } else {
                player.sendMessage((Object)COLOR + "Henceforth, this shall be " + owner + "'s new home.");
            }
        } else {
            player.sendMessage((Object)ChatColor.RED + "You can't set someone else's home!");
        }
    }

    private void setSpawn(CommandSender sender) {
        Player player = (Player)sender;
        player.getWorld().setSpawnLocation(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
        String world_name = player.getWorld().getWorldFolder().getName().endsWith("_nether") ? "The Nether" : (player.getWorld().getWorldFolder().getName().endsWith("_the_end") ? "The End" : player.getWorld().getWorldFolder().getName());
        player.sendMessage((Object)COLOR + "Henceforth, this shall be " + world_name + "'s new spawn point.");
    }

    private void spawn(CommandSender sender, String[] parameters) {
        Player player = (Player)sender;
        String world_name = player.getWorld().getWorldFolder().getName();
        if (world_name.endsWith("_nether")) {
            world_name = "The Nether";
        } else if (world_name.endsWith("_the_end")) {
            world_name = "The End";
        }
        String warp_message = spawn_messages_by_world.get((Object)player.getWorld());
        if (warp_message == null) {
            warp_message = (Object)COLOR + "Welcome to " + player.getWorld().getWorldFolder().getName() + ", " + player.getName() + ".";
        }
        this.teleport(player, new UltraWarp((Object)COLOR + "This is the spot you were at before you teleported to " + world_name + "'s spawn point.", player.getLocation()), new UltraWarp(warp_message, player.getWorld().getSpawnLocation()), true, null);
    }

    private void switchList(CommandSender sender, String[] parameters) {
        Player player = null;
        if (sender instanceof Player) {
            player = (Player)sender;
        }
        if (switches.size() > 0 && player == null) {
            this.fullSwitchList(sender, parameters);
        } else if (switches.size() > 0 && player != null) {
            byte page_number = 1;
            for (int i = 0; i < parameters.length; i = (int)((byte)(i + 1))) {
                if (!parameters[i].equalsIgnoreCase("page")) continue;
                if (parameters.length <= i + 1) {
                    sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me which page you want me to show you!");
                    return;
                }
                try {
                    page_number = Byte.parseByte(parameters[i + 1]);
                }
                catch (NumberFormatException exception) {
                    sender.sendMessage((Object)ChatColor.RED + "Since when is \"" + parameters[i + 1] + "\" an integer?");
                    return;
                }
                if (page_number == 0) {
                    sender.sendMessage((Object)ChatColor.RED + "I think you know very well that there is no page 0, you little trouble maker. Nice try.");
                    return;
                }
                if (page_number >= 0) continue;
                sender.sendMessage((Object)ChatColor.RED + "Negative page numbers? Really? Try again.");
                return;
            }
            ArrayList<Object> switch_warps = new ArrayList<Object>();
            ArrayList<Integer> switch_warp_quantities = new ArrayList<Integer>();
            for (int i2 = 0; i2 < switches.size(); ++i2) {
                if (!myUltraWarps.switches.get((int)i2).warp_owner.equals(player.getName())) continue;
                UltraWarp warp = null;
                for (UltraWarp my_warp : warps) {
                    if (!my_warp.name.equals(myUltraWarps.switches.get((int)i2).warp_name) || !my_warp.owner.equals(myUltraWarps.switches.get((int)i2).warp_owner)) continue;
                    warp = my_warp;
                }
                if (warp == null) {
                    switches.remove(i2);
                    --i2;
                    continue;
                }
                int counter = 0;
                int index = -1;
                for (int j = 0; j < switch_warps.size(); ++j) {
                    if (!((UltraWarp)switch_warps.get(j)).equals(warp)) continue;
                    counter = (Integer)switch_warp_quantities.get(j);
                    index = j;
                    j = switch_warps.size();
                }
                if (counter == 0) {
                    switch_warps.add(warp);
                    switch_warp_quantities.add(1);
                    continue;
                }
                switch_warp_quantities.set(index, counter + 1);
            }
            String output = "";
            if (switch_warps.size() > 0) {
                output = (Object)COLOR + "your switches: ";
                for (int i3 = 0; i3 < switch_warps.size(); ++i3) {
                    UltraWarp warp = (UltraWarp)switch_warps.get(i3);
                    if (i3 > 0) {
                        output = String.valueOf(output) + (Object)ChatColor.WHITE + ", ";
                    }
                    output = String.valueOf(output) + warp.getColoredName() + ((Integer)switch_warp_quantities.get(i3) > 1 ? new StringBuilder().append((Object)ChatColor.WHITE).append(" x").append(switch_warp_quantities.get(i3)).toString() : "");
                }
            } else {
                output = (Object)ChatColor.RED + "You don't have any switches yet!";
            }
            player.sendMessage(myUltraWarps.paginate(output, "/switch list page [#]", "You only have [total] of switches!", page_number, sender instanceof Player));
        } else {
            sender.sendMessage((Object)ChatColor.RED + "No one has made any switches yet!");
        }
    }

    private void switchInfo(int extra_param, CommandSender sender, String[] parameters) {
        Player player = null;
        Block target_block = null;
        if (sender instanceof Player) {
            player = (Player)sender;
        }
        if (player != null) {
            target_block = myUltraWarps.getTargetBlock(player, false);
        }
        if (parameters.length > extra_param) {
            UltraWarp.getWarp(extra_param, sender, parameters);
            if (player == null || player.getName().toLowerCase().startsWith(UWowner.toLowerCase()) || player.hasPermission("myultrawarps.switchinfo.other") || player.hasPermission("myultrawarps.admin")) {
                ArrayList<UltraSwitch> temp = new ArrayList<UltraSwitch>();
                for (UltraSwitch my_switch2 : switches) {
                    if (!my_switch2.warp_owner.equals(UWowner) || !my_switch2.warp_name.toLowerCase().startsWith(UWname.toLowerCase())) continue;
                    temp.add(my_switch2);
                }
                if (temp.size() == 0) {
                    if (player == null) {
                        console.sendMessage((Object)COLOR + "There are no switches linked to " + UWowner + "'s warp \"" + UWname + ".\"");
                    } else if (player.getName().equals(UWowner)) {
                        player.sendMessage((Object)COLOR + "There are no switches linked to \"" + UWname + ".\"");
                    } else {
                        player.sendMessage((Object)COLOR + "There are no switches linked to " + UWowner + "'s warp \"" + UWname + ".\"");
                    }
                } else if (temp.size() > 0) {
                    for (UltraSwitch my_switch2 : temp) {
                        if (player == null) {
                            console.sendMessage((Object)ChatColor.WHITE + myUltraWarps.colorCode(my_switch2.toString()));
                            continue;
                        }
                        player.sendMessage((Object)ChatColor.WHITE + myUltraWarps.colorCode(my_switch2.toString()));
                    }
                }
            } else {
                player.sendMessage((Object)ChatColor.RED + "You don't have permission to see info on other people's switches.");
            }
        } else if (target_block != null && UltraSwitch.getSwitchType(target_block) != null) {
            UltraSwitch switch_found = null;
            for (UltraSwitch my_switch : switches) {
                if (my_switch.x != target_block.getX() || my_switch.y != target_block.getY() || my_switch.z != target_block.getZ() || !my_switch.world.equals((Object)target_block.getWorld()) || !my_switch.switch_type.equals(UltraSwitch.getSwitchType(target_block))) continue;
                switch_found = my_switch;
            }
            if (switch_found != null && (player == null || switch_found.warp_owner.equals(player.getName()) || player.hasPermission("myultrawarps.switchinfo.other") || player.hasPermission("myultrawarps.admin"))) {
                if (player == null) {
                    console.sendMessage((Object)ChatColor.WHITE + switch_found.toString());
                } else {
                    player.sendMessage((Object)ChatColor.WHITE + switch_found.toString());
                }
            } else if (switch_found == null) {
                if (player == null) {
                    console.sendMessage((Object)COLOR + "There are no warps linked to this " + UltraSwitch.getSwitchType(target_block) + ".");
                } else {
                    player.sendMessage((Object)COLOR + "There are no warps linked to this " + UltraSwitch.getSwitchType(target_block) + ".");
                }
            } else if (player != null) {
                player.sendMessage((Object)ChatColor.RED + "You don't have permission to see info on other people's switches.");
            }
        } else if (!(sender instanceof Player)) {
            console.sendMessage((Object)ChatColor.RED + "You must specify a warp for me to check if any switches are linked to it.");
        } else if (player != null) {
            player.sendMessage((Object)ChatColor.RED + "You must either specify a warp for me to check or point at a switch for me to check.");
        }
    }

    private void to(CommandSender sender, String[] parameters) {
        ArrayList requesting_players;
        Player player = (Player)sender;
        Player target_player = null;
        for (Player my_player : server.getOnlinePlayers()) {
            if (!my_player.getName().toLowerCase().startsWith(parameters[0].toLowerCase()) || my_player.equals((Object)player)) continue;
            target_player = my_player;
        }
        if (target_player == null) {
            if (player.getName().toLowerCase().startsWith(parameters[0].toLowerCase())) {
                player.sendMessage((Object)ChatColor.RED + "You can't teleport to yourself! That makes no sense!");
            } else {
                player.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + parameters[0] + "\" anywhere.");
            }
            return;
        }
        if (blocked_players.get(target_player.getName()) != null && blocked_players.get(target_player.getName()).contains(player.getName()) && !player.hasPermission("myultrawarps.admin")) {
            player.sendMessage((Object)ChatColor.RED + "Sorry, but " + target_player.getName() + " has blocked you. You can't send them teleportation requests anymore.");
            return;
        }
        if (player.hasPermission("myultrawarps.to.norequest") || player.hasPermission("myultrawarps.admin") || from_teleport_requests.get(player.getName()) != null && from_teleport_requests.get(player.getName()).contains(target_player.getName())) {
            requesting_players = from_teleport_requests.get(player.getName());
            if (requesting_players == null) {
                requesting_players = new ArrayList();
            }
            while (requesting_players.contains(target_player.getName())) {
                requesting_players.remove(target_player.getName());
            }
            from_teleport_requests.put(player.getName(), requesting_players);
            if (this.teleport(player, new UltraWarp("God", "coordinates", false, false, "&aThis is the spot you were at before you teleported to " + target_player.getName() + ".", "", null, player.getLocation()), new UltraWarp("God", "coordinates", false, false, "&aThis is the spot you were at when you teleported to " + target_player.getName() + ".", "", null, target_player.getLocation()), false, (CommandSender)target_player)) {
                if (player.getName().toLowerCase().startsWith("a") || player.getName().toLowerCase().startsWith("e") || player.getName().toLowerCase().startsWith("i") || player.getName().toLowerCase().startsWith("o") || player.getName().toLowerCase().startsWith("u")) {
                    player.sendMessage((Object)COLOR + "You found an " + target_player.getName() + "!");
                } else {
                    player.sendMessage((Object)COLOR + "You found a " + target_player.getName() + "!");
                }
                target_player.sendMessage((Object)COLOR + player.getName() + " has come to visit you.");
            }
        } else {
            player.sendMessage((Object)COLOR + "Hang on. Let me ask " + target_player.getName() + " if it's okay.");
            target_player.sendMessage((Object)COLOR + player.getName() + " would like to teleport to you. Is that okay?");
            requesting_players = to_teleport_requests.get(target_player.getName());
            if (requesting_players == null) {
                requesting_players = new ArrayList();
            }
            requesting_players.add(player.getName());
            to_teleport_requests.put(target_player.getName(), requesting_players);
        }
    }

    private void top(CommandSender sender) {
        Player player = (Player)sender;
        boolean skipped_ceiling = true;
        boolean passed_air = false;
        if (player.getLocation().getWorld().getWorldFolder().getName().endsWith("_nether")) {
            skipped_ceiling = false;
        }
        Object[] half_height_block_IDs = new Short[]{44, 93, 94, 96, 111, 126, 149, 150, 151};
        Object[] over_height_block_IDs = new Short[]{85, 107, 113};
        for (float y = (float)(player.getWorld().getMaxHeight() - 1); y >= 0.0f; y-=1.0f) {
            Location location = new Location(player.getLocation().getWorld(), (double)player.getLocation().getBlockX() + 0.5, (double)y, (double)player.getLocation().getBlockZ() + 0.5, player.getLocation().getYaw(), player.getLocation().getPitch());
            if (!myUltraWarps.contains(NON_SOLID_BLOCK_IDS, (short)location.getBlock().getTypeId()) || location.getBlock().isLiquid()) {
                if (skipped_ceiling && passed_air) {
                    if (myUltraWarps.contains(half_height_block_IDs, (short)location.getBlock().getTypeId()) && (location.getBlock().getType() != Material.STEP || location.getBlock().getData() < 8)) {
                        y = (float)((double)y - 0.5);
                    } else if (myUltraWarps.contains(over_height_block_IDs, (short)location.getBlock().getTypeId())) {
                        y = (float)((double)y + 0.5);
                    }
                    location.setY((double)y + 1.0);
                    this.teleport(player, null, new UltraWarp("&aYou've reached the top!", location), true, null);
                    return;
                }
                if (skipped_ceiling) continue;
                skipped_ceiling = true;
                continue;
            }
            if (!skipped_ceiling) continue;
            passed_air = true;
        }
        player.sendMessage((Object)ChatColor.RED + "I can't find any solid blocks anywhere above or below you! What gives?");
    }

    private void unblock(CommandSender sender, String[] parameters) {
        Player player = (Player)sender;
        String blocked_player = myUltraWarps.autoCompleteName(parameters[0]);
        if (blocked_players.get(player.getName()) != null && blocked_players.get(player.getName()).contains(blocked_player)) {
            ArrayList<String> my_blocked_players = blocked_players.get(player.getName());
            my_blocked_players.remove(blocked_player);
            blocked_players.put(player.getName(), my_blocked_players);
        } else {
            player.sendMessage((Object)ChatColor.RED + "You never blocked " + blocked_player + ".");
        }
    }

    private void unlinkWarp(int extra_param, CommandSender sender, String[] parameters) {
        Player player = null;
        if (sender instanceof Player) {
            player = (Player)sender;
        }
        Block target_block = null;
        if (player != null) {
            target_block = myUltraWarps.getTargetBlock(player, false);
        }
        if (parameters.length > extra_param) {
            UltraWarp warp = UltraWarp.getWarp(extra_param, sender, parameters);
            if (warp.owner != null) {
                if (player == null || player.getName().equals(warp.owner) || player.hasPermission("myultrawarps.unlink.other") || player.hasPermission("myultrawarps.admin")) {
                    int number_of_switches_unlinked = 0;
                    for (int i = 0; i < switches.size(); ++i) {
                        if (!myUltraWarps.switches.get((int)i).warp_name.equals(warp.name) || !myUltraWarps.switches.get((int)i).warp_owner.equals(warp.owner)) continue;
                        switches.remove(i);
                        --i;
                        ++number_of_switches_unlinked;
                    }
                    if (autosave_switches) {
                        this.saveTheSwitches(sender, false);
                    }
                    String full_warp_name = "\"" + warp.name + "\"";
                    if (!(player != null && player.getName().equals(warp.owner))) {
                        full_warp_name = String.valueOf(warp.owner) + "'s \"" + warp.name + "\"";
                    }
                    if (number_of_switches_unlinked == 0) {
                        sender.sendMessage((Object)ChatColor.RED + "There are no switches linked to " + full_warp_name + "!");
                    } else if (number_of_switches_unlinked == 1) {
                        sender.sendMessage((Object)COLOR + "I unlinked the one switch linked to " + full_warp_name + ".");
                    } else {
                        sender.sendMessage((Object)COLOR + "I unlinked the " + number_of_switches_unlinked + " switches linked to " + full_warp_name + ".");
                    }
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "You don't have permission to unlink other people's switches.");
                }
            } else {
                sender.sendMessage((Object)ChatColor.RED + "You need to specify the owner's name. I can't look through your own warps! You're a console!");
            }
        } else if (target_block != null && UltraSwitch.getSwitchType(target_block) != null) {
            if (player != null) {
                int index = -1;
                for (int i = 0; i < switches.size(); ++i) {
                    if (!myUltraWarps.switches.get((int)i).location.equals((Object)target_block.getLocation()) || !myUltraWarps.switches.get((int)i).switch_type.equals(UltraSwitch.getSwitchType(target_block))) continue;
                    index = i;
                    break;
                }
                if (index != -1 && (player.getName().equals(myUltraWarps.switches.get((int)index).warp_owner) || player.hasPermission("myultrawarps.unlink.other") || player.hasPermission("myultrawarps.admin"))) {
                    if (player.getName().equals(myUltraWarps.switches.get((int)index).warp_owner)) {
                        sender.sendMessage((Object)COLOR + "You unlinked \"" + myUltraWarps.switches.get((int)index).warp_name + "\" from this " + UltraSwitch.getSwitchType(target_block) + ".");
                    } else {
                        sender.sendMessage((Object)COLOR + "You unlinked " + myUltraWarps.switches.get((int)index).warp_owner + "'s \"" + myUltraWarps.switches.get((int)index).warp_name + "\" from this " + UltraSwitch.getSwitchType(target_block) + ".");
                    }
                    switches.remove(index);
                    if (autosave_switches) {
                        this.saveTheSwitches(sender, false);
                    }
                } else if (index == -1) {
                    sender.sendMessage((Object)ChatColor.RED + "That " + UltraSwitch.getSwitchType(target_block) + " doesn't have a warp linked to it.");
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "You're not allowed to unlink other people's warps.");
                }
            } else {
                console.sendMessage((Object)ChatColor.RED + "You need to specify the warp that you want to unlink all switches from because you can't point out a specific switch to me...'cause you're a console!");
            }
        } else if (player != null) {
            sender.sendMessage((Object)ChatColor.RED + "You can either point out a switch you want to unlink a warp from or specify a warp that I will unlink all switches from.");
        } else {
            sender.sendMessage((Object)ChatColor.RED + "You need to specify the warp that you want to unlink all switches from because you can't point out a specific switch to me...'cause you're a console!");
        }
    }

    private void warp(CommandSender sender, String[] parameters) {
        Player player = (Player)sender;
        UltraWarp warp = UltraWarp.getWarp(0, sender, parameters);
        if (warp != null) {
            boolean listed = false;
            if (warp.listed_users != null && warp.listed_users.length > 0) {
                for (String user : warp.listed_users) {
                    if (!player.getName().equalsIgnoreCase(user)) continue;
                    listed = true;
                }
            }
            if (warp.owner.equals(player.getName()) || player.hasPermission("myultrawarps.warptowarp.other") || player.hasPermission("myultrawarps.admin") || !warp.restricted && !listed || warp.restricted && listed) {
                String warp_name = warp.name;
                if (!warp.owner.equals(player.getName())) {
                    warp_name = String.valueOf(warp.owner) + "'s " + warp.name;
                }
                this.teleport(player, new UltraWarp("God", "coordinates", false, false, "&aThis is the spot you were at before you warped to " + warp_name + ".", "", null, player.getLocation()), warp, true, null);
            } else {
                player.sendMessage(myUltraWarps.colorCode(warp.no_warp_message.replaceAll("\\[player\\]", player.getName())));
            }
        } else if (player.getName().equals(UWowner)) {
            player.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + ".\"");
        } else {
            player.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + "\" in " + UWowner + "'s warps.");
        }
    }

    private void warpAll(int extra_param, CommandSender sender, String[] parameters) {
        Player player = null;
        if (sender instanceof Player) {
            player = (Player)sender;
        }
        if (parameters[extra_param].equalsIgnoreCase("to")) {
            ++extra_param;
        }
        if (parameters[extra_param].equalsIgnoreCase("here")) {
            if (player != null) {
                for (Player everyone : server.getOnlinePlayers()) {
                    if (player != null && everyone.equals((Object)player)) continue;
                    this.teleport(everyone, new UltraWarp((Object)COLOR + "This is the spot you were at before " + player.getName() + " teleported everyone to them.", everyone.getLocation()), new UltraWarp((Object)COLOR + "This is the spot where " + player.getName() + " teleported everyone to them.", player.getLocation()), false, (CommandSender)player);
                    everyone.sendMessage((Object)COLOR + player.getName() + " brought everyone to this location for something important.");
                }
                player.sendMessage((Object)COLOR + "Everyone is present and accounted for.");
            } else {
                console.sendMessage((Object)ChatColor.RED + "I can't warp anyone to you! You have no location!");
            }
        } else if (parameters[extra_param].equalsIgnoreCase("there")) {
            if (player != null) {
                Block target_block = myUltraWarps.getTargetBlock(player, true);
                if (target_block != null) {
                    Location target_location = target_block.getLocation();
                    target_location.setY(target_location.getY() + 1.0);
                    if (target_location.getBlock().getType() != Material.AIR) {
                        target_location.getChunk().load();
                        for (Player everyone : server.getOnlinePlayers()) {
                            if (player != null && everyone.equals((Object)player)) continue;
                            this.teleport(everyone, new UltraWarp((Object)COLOR + "This is the spot you were at before " + player.getName() + " teleported everyone elsewhere.", everyone.getLocation()), new UltraWarp((Object)COLOR + "This is the spot where " + player.getName() + " teleported everyone.", target_location), false, (CommandSender)player);
                            everyone.sendMessage((Object)COLOR + player.getName() + " brought everyone to this location for something important.");
                        }
                        player.sendMessage((Object)COLOR + "Everyone is present and accounted for.");
                    } else {
                        player.sendMessage((Object)ChatColor.RED + "Sorry, but I can't see that far!");
                    }
                } else {
                    player.sendMessage((Object)ChatColor.RED + "Sorry, but I can't see that far!");
                }
            } else {
                console.sendMessage((Object)ChatColor.RED + "Please point out the place you want to teleport everyone. Oh, yeah. You still can't. You're still a console.");
            }
        } else if (parameters[extra_param].equalsIgnoreCase("warp")) {
            if (!(parameters.length < extra_param + 2 || parameters[extra_param + 1] == null || parameters[extra_param].equals(""))) {
                UltraWarp warp = UltraWarp.getWarp(extra_param + 1, sender, parameters);
                if (warp != null) {
                    warp.location.getChunk().load();
                    for (Player everyone : server.getOnlinePlayers()) {
                        if (player != null && everyone.equals((Object)player)) continue;
                        String sender_name = "someone";
                        if (player != null) {
                            sender_name = player.getName();
                        }
                        this.teleport(everyone, new UltraWarp((Object)COLOR + "This is the spot you were at before " + sender_name + " teleported everyone elsewhere.", everyone.getLocation()), new UltraWarp((Object)COLOR + "This is the spot where " + sender_name + " teleported everyone.", warp.location), false, sender);
                        if (sender_name.equals("someone")) {
                            sender_name = "Someone";
                        }
                        everyone.sendMessage((Object)COLOR + sender_name + " brought everyone to this location for something important.");
                    }
                    if (player != null && warp.owner.equals(player.getName())) {
                        player.sendMessage((Object)COLOR + "I sent everyone to \"" + warp.name + ".\"");
                    } else {
                        sender.sendMessage((Object)COLOR + "I sent everyone to " + warp.owner + "'s \"" + warp.name + ".\"");
                    }
                } else if (player != null && player.getName().equals(UWowner)) {
                    player.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + ".\"");
                } else if (UWowner != null) {
                    sender.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + "\" in " + UWowner + "'s warps.");
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + ".\"");
                }
            } else {
                sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me what warp you want to warp everyone to!");
            }
        } else if (parameters[extra_param].equalsIgnoreCase("player")) {
            if (!(parameters.length < extra_param + 2 || parameters[extra_param + 1] == null || parameters[extra_param].equals(""))) {
                Player target_player = null;
                for (Player online_player : server.getOnlinePlayers()) {
                    if (!online_player.getName().toLowerCase().startsWith(parameters[extra_param + 1].toLowerCase())) continue;
                    target_player = online_player;
                }
                if (target_player != null) {
                    for (Player everyone : server.getOnlinePlayers()) {
                        if (player != null && everyone.equals((Object)player)) continue;
                        String sender_name = "someone";
                        if (player != null) {
                            sender_name = player.getName();
                        }
                        this.teleport(everyone, new UltraWarp((Object)COLOR + "This is the spot you were at before " + sender_name + " teleported everyone elsewhere.", everyone.getLocation()), new UltraWarp((Object)COLOR + "This is the spot where " + sender_name + " teleported everyone.", target_player.getLocation()), false, sender);
                        if (sender_name.equals("someone")) {
                            sender_name = "Someone";
                        }
                        everyone.sendMessage((Object)COLOR + sender_name + " brought everyone to this location for something important.");
                    }
                    sender.sendMessage((Object)COLOR + "I teleported everyone to " + target_player.getName() + ".");
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "\"" + parameters[extra_param + 1] + "\" is not online right now.");
                }
            } else {
                sender.sendMessage((Object)ChatColor.RED + "You forgot to tell me which player you want me to warp everyone to!");
            }
        }
    }

    private void warpInfo(int extra_param, CommandSender sender, String[] parameters) {
        UltraWarp warp;
        Player player = null;
        if (sender instanceof Player) {
            player = (Player)sender;
        }
        if ((warp = UltraWarp.getWarp(extra_param, sender, parameters)) != null && (player == null || player.getName().equals(UWowner) || player.hasPermission("myultrawarps.warpinfo.other") || player.hasPermission("myultrawarps.admin"))) {
            String info = warp.toString();
            info = info.replaceAll("\"" + warp.warp_message + "\"", "\"" + warp.warp_message + "&f\"").replaceAll("\"" + warp.no_warp_message + "\"", "\"" + warp.no_warp_message + "&f\"");
            sender.sendMessage((Object)ChatColor.WHITE + myUltraWarps.colorCode(info));
        } else if (warp != null) {
            sender.sendMessage((Object)ChatColor.RED + "You don't have permission to view information about this warp.");
        } else if (player != null && player.getName().equals(UWowner) || UWowner == null) {
            sender.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + ".\"");
        } else {
            sender.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + UWname + "\" in " + UWowner + "'s warps.");
        }
    }

    private void warpList(CommandSender sender, String[] parameters) {
        String player = null;
        if (sender instanceof Player) {
            player = ((Player)sender).getName();
        }
        int page_number = 1;
        int extra_param = 0;
        if (parameters.length > 0 && parameters[0].equals("list")) {
            ++extra_param;
        }
        boolean other_player_specified = false;
        if (parameters.length > extra_param && parameters[extra_param].endsWith("'s")) {
            if (!(!(sender instanceof Player) || sender.hasPermission("myultrawarps.list.other") || sender.hasPermission("myultrawarps.list.full") || sender.hasPermission("myultrawarps.admin"))) {
                sender.sendMessage((Object)ChatColor.RED + "Sorry, but you're not allowed to see other people's warp lists.");
                return;
            }
            player = myUltraWarps.autoCompleteName(parameters[extra_param].substring(0, parameters[extra_param].length() - 2));
            if (player == null) {
                sender.sendMessage((Object)ChatColor.RED + "I'm not sure who \"" + parameters[extra_param].substring(0, parameters[extra_param].length() - 2) + "\" is.");
                return;
            }
            other_player_specified = true;
            ++extra_param;
        }
        if (parameters.length > extra_param) {
            try {
                page_number = Integer.parseInt(parameters[extra_param]);
                if (page_number <= 0) {
                    sender.sendMessage((Object)ChatColor.RED + "Okay, page " + parameters[extra_param] + "? Really?");
                    return;
                }
            }
            catch (NumberFormatException exception) {
                sender.sendMessage((Object)ChatColor.RED + "Since when is \"" + parameters[extra_param] + "\" an integer?");
                return;
            }
        }
        String your_warps_output = null;
        String listed_warps_output = null;
        for (UltraWarp warp : warps) {
            if (player != null && warp.owner.equals(player)) {
                if (your_warps_output == null) {
                    if (!other_player_specified) {
                        your_warps_output = (Object)COLOR + "your warps: " + warp.getColoredName();
                        continue;
                    }
                    your_warps_output = (Object)COLOR + player + "'s warps: " + warp.getColoredName();
                    continue;
                }
                your_warps_output = String.valueOf(your_warps_output) + (Object)ChatColor.WHITE + ", " + warp.getColoredName();
                continue;
            }
            if (!warp.listed || other_player_specified) continue;
            if (listed_warps_output == null) {
                if (player != null) {
                    listed_warps_output = (Object)COLOR + "other listed warps: " + warp.getColoredName();
                    continue;
                }
                listed_warps_output = (Object)COLOR + "listed warps: " + warp.getColoredName();
                continue;
            }
            listed_warps_output = String.valueOf(listed_warps_output) + (Object)ChatColor.WHITE + ", " + warp.getColoredName();
        }
        if (your_warps_output == null) {
            your_warps_output = player != null ? (sender instanceof Player && !other_player_specified ? (Object)ChatColor.RED + "You don't have any warps yet!" : (Object)ChatColor.RED + player + " doesn't have any warps yet!") : "";
        }
        if (listed_warps_output == null) {
            if (!other_player_specified) {
                listed_warps_output = (Object)ChatColor.RED + "No one else has any listed warps yet!";
                if (!(sender instanceof Player) || sender.hasPermission("myultrawarps.list.full")) {
                    listed_warps_output = String.valueOf(listed_warps_output) + "\nIf you would like to see a complete list of warps on the server, use " + (Object)ChatColor.ITALIC + "/full warp list" + (Object)ChatColor.RED + ".";
                }
            } else {
                listed_warps_output = "";
            }
        }
        if (!(your_warps_output.equals("") || listed_warps_output.equals(""))) {
            your_warps_output = String.valueOf(your_warps_output) + "\n";
        }
        String command_format = "/warp list [#]";
        String not_enough_pages_message = "You only have [total] of warps.";
        if (other_player_specified) {
            command_format = "/warp list " + player + "'s [#]";
            not_enough_pages_message = String.valueOf(player) + " only has [total] of warps.";
        }
        sender.sendMessage(myUltraWarps.paginate(String.valueOf(your_warps_output) + listed_warps_output, command_format, not_enough_pages_message, page_number, sender instanceof Player));
    }

    private void warpToCoordinate(CommandSender sender, String[] parameters) {
        String message;
        Player player = (Player)sender;
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        String world_name = "";
        World world = null;
        int extra_param = 0;
        boolean fail = true;
        while (fail && extra_param + 2 < parameters.length) {
            fail = false;
            try {
                x = Double.parseDouble(parameters[extra_param]);
                y = Double.parseDouble(parameters[extra_param + 1]);
                z = Double.parseDouble(parameters[extra_param + 2]);
                continue;
            }
            catch (NumberFormatException exception) {
                fail = true;
                world_name = !world_name.equals("") ? String.valueOf(world_name) + " " + parameters[extra_param] : parameters[extra_param];
                ++extra_param;
            }
        }
        if (Math.abs(x) >= 2000000.0 || Math.abs(z) >= 2000000.0) {
            sender.sendMessage((Object)ChatColor.RED + "Sorry, but you're not allowed to warp past 2,000,000 blocks from the center of the map.");
            return;
        }
        if (world_name.equals("") && parameters.length >= 4) {
            for (int i = 3; i < parameters.length; ++i) {
                world_name = String.valueOf(world_name) + parameters[i];
            }
        }
        if (!world_name.equals("")) {
            for (World my_world : server.getWorlds()) {
                if (!my_world.getWorldFolder().getName().toLowerCase().startsWith(world_name.toLowerCase())) continue;
                world = my_world;
            }
        } else {
            world = player.getWorld();
        }
        if (!(fail || world == null)) {
            message = (Object)COLOR + "Welcome to (" + Math.round(x) + ", " + Math.round(y) + ", " + Math.round(z) + ").";
            if (!world.equals((Object)player.getWorld())) {
                world_name = world.getWorldFolder().getName();
                if (world_name.endsWith("_nether")) {
                    world_name = "The Nether";
                } else if (world_name.endsWith("_the_end")) {
                    world_name = "The End";
                }
                message = (Object)COLOR + "&aWelcome to (" + Math.round(x) + ", " + Math.round(y) + ", " + Math.round(z) + ") in \"" + world_name + ".\"";
            }
            this.teleport(player, new UltraWarp("&aThis is the spot you were at before you warped to (" + Math.round(x) + ", " + Math.round(y) + ", " + Math.round(z) + ")", player.getLocation()), new UltraWarp(message, new Location(world, (double)((int)x) + 0.5, (double)((int)y), (double)((int)z) + 0.5, player.getLocation().getYaw(), player.getLocation().getPitch())), true, null);
        } else if (world == null) {
            player.sendMessage((Object)ChatColor.RED + "The world you specified doesn't exist.");
            if (server.getWorlds().size() == 1) {
                player.sendMessage((Object)ChatColor.RED + "Your server only has one world called \"" + ((World)server.getWorlds().get(0)).getWorldFolder().getName() + ".\"");
            } else if (server.getWorlds().size() == 2) {
                player.sendMessage((Object)ChatColor.RED + "Your server has two worlds: \"" + ((World)server.getWorlds().get(0)).getWorldFolder().getName() + "\" and \"" + ((World)server.getWorlds().get(1)).getWorldFolder().getName() + ".\"");
            } else if (server.getWorlds().size() > 2) {
                message = (Object)ChatColor.RED + "Your server has " + server.getWorlds().size() + " worlds: ";
                for (int i = 0; i < server.getWorlds().size(); ++i) {
                    message = i < server.getWorlds().size() - 1 ? String.valueOf(message) + "\"" + ((World)server.getWorlds().get(i)).getWorldFolder().getName() + "\", " : String.valueOf(message) + " and \"" + ((World)server.getWorlds().get(i)).getWorldFolder().getName() + ".\"";
                }
                player.sendMessage(message);
            }
        } else if (fail) {
            player.sendMessage((Object)ChatColor.RED + "Either you put too many parameters in for /warp or you put a letter in one of your coordinates.");
        } else {
            player.sendMessage((Object)ChatColor.RED + "I couldn't find \"" + world_name + ".\"");
        }
    }

    private void warpsAround(int extra_param, CommandSender sender, String[] parameters) {
        Player player = null;
        if (sender instanceof Player) {
            player = (Player)sender;
        }
        int radius = 20;
        Location target_location = null;
        String target_name = null;
        if (parameters[extra_param].equalsIgnoreCase("player")) {
            if (parameters.length <= ++extra_param) {
                sender.sendMessage((Object)ChatColor.RED + "You forgot which player you want the search centered around!");
            } else {
                for (Player target_player : server.getOnlinePlayers()) {
                    if (!target_player.getName().toLowerCase().startsWith(parameters[extra_param].toLowerCase())) continue;
                    target_name = target_player.getName();
                    target_location = target_player.getLocation();
                    break;
                }
                if (target_location == null) {
                    sender.sendMessage((Object)ChatColor.RED + "\"" + parameters[extra_param] + "\" is nowhere to be found.");
                }
            }
        } else if (parameters[extra_param].equalsIgnoreCase("warp")) {
            if (parameters.length > ++extra_param && parameters[extra_param].toLowerCase().endsWith("'s")) {
                ++extra_param;
            }
            if (parameters.length <= extra_param) {
                sender.sendMessage((Object)ChatColor.RED + "You forgot which warp you want the search centered around!");
            } else {
                UltraWarp warp = UltraWarp.getWarp(extra_param, sender, parameters);
                if (warp != null) {
                    target_location = new Location(warp.location.getWorld(), warp.location.getX(), warp.location.getY(), warp.location.getZ());
                    target_name = player != null && UWowner.equals(player.getName()) ? "\"" + warp.name + "\"" : String.valueOf(warp.owner) + "'s \"" + warp.name + "\"";
                } else if (player != null && player.getName().equals(UWowner)) {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but I couldn't find \"" + UWname + ".\"");
                } else {
                    sender.sendMessage((Object)ChatColor.RED + "Sorry, but I couldn't find " + UWowner + "'s \"" + UWname + ".\"");
                }
            }
        } else if (parameters[extra_param].equalsIgnoreCase("there")) {
            target_name = "that spot";
            if (player == null) {
                sender.sendMessage((Object)ChatColor.RED + "You want the search centered there? Where? Oh, wait. You're still a console and you still have no fingers to point out a location with.");
                return;
            }
            Block target_block = myUltraWarps.getTargetBlock(player, true);
            if (target_block == null) {
                sender.sendMessage((Object)ChatColor.RED + "Sorry, but I can't see that far!");
                return;
            }
            target_location = target_block.getLocation();
        } else if (parameters[extra_param].equalsIgnoreCase("here") || parameters[extra_param].equalsIgnoreCase("me")) {
            target_name = "you";
            if (player == null) {
                sender.sendMessage((Object)ChatColor.RED + "You have no body. How can I center a search around you, huh? Silly...");
            } else {
                target_location = player.getLocation();
            }
        } else {
            sender.sendMessage((Object)ChatColor.RED + "I don't understand what \"" + parameters[extra_param] + "\" means.");
        }
        if (target_location != null) {
            if (parameters.length > extra_param + 1) {
                try {
                    radius = Integer.parseInt(parameters[extra_param + 1]);
                }
                catch (NumberFormatException exception) {
                    sender.sendMessage((Object)ChatColor.RED + "Since when is \"" + parameters[extra_param + 1] + "\" an integer?");
                    return;
                }
            }
            ArrayList<UltraWarp> nearby_warps = new ArrayList<UltraWarp>();
            for (UltraWarp warp : warps) {
                if (warp.location.getX() < (double)(target_location.getBlockX() - radius) || warp.location.getX() > (double)(target_location.getBlockX() + radius) || warp.location.getY() < (double)(target_location.getBlockY() - radius) || warp.location.getY() > (double)(target_location.getBlockY() + radius) || warp.location.getZ() < (double)(target_location.getBlockZ() - radius) || warp.location.getZ() > (double)(target_location.getBlockZ() + radius) || !warp.location.getWorld().equals((Object)target_location.getWorld())) continue;
                nearby_warps.add(warp);
            }
            if (nearby_warps.size() > 0) {
                String output = (Object)COLOR + "There are " + nearby_warps.size() + " warps within " + radius + " blocks of " + target_name + ": ";
                if (nearby_warps.size() == 1) {
                    output = (Object)COLOR + "There is one warp within " + radius + " blocks of " + target_name + ": ";
                }
                for (UltraWarp warp2 : nearby_warps) {
                    if (!output.endsWith(": ")) {
                        output = String.valueOf(output) + (Object)ChatColor.WHITE + ", ";
                    }
                    output = String.valueOf(output) + warp2.getColoredOwner() + "'s " + warp2.name;
                }
                sender.sendMessage(output);
            } else {
                sender.sendMessage((Object)ChatColor.RED + "There are no warps within " + radius + " blocks of " + target_name + ".");
            }
        }
    }
}


/*
 * Decompiled with CFR 0_95.
 */
package REALDrummer;

public class SettingsSet {
    public String default_warp;
    public String default_no_warp;
    public boolean home_on_death;
    public int max_warps;
    public int warp_history_length;
    public int death_history_length;
    public long cooldown;

    public SettingsSet(boolean my_home_on_death, String my_default_warp, String my_default_no_warp, int my_max_warps, long my_cooldown, int my_warp_history_length, int my_death_history_length) {
        this.home_on_death = my_home_on_death;
        this.default_warp = my_default_warp;
        this.default_no_warp = my_default_no_warp;
        this.max_warps = my_max_warps;
        this.cooldown = my_cooldown;
        this.warp_history_length = my_warp_history_length;
        this.death_history_length = my_death_history_length;
    }

    public SettingsSet() {
        this.home_on_death = true;
        this.default_warp = "&aWelcome to the [warp].";
        this.default_no_warp = "&cYou're not allowed to warp to [owner]'s [warp].";
        this.max_warps = -1;
        this.cooldown = 0;
        this.warp_history_length = 20;
        this.death_history_length = 5;
    }

    public SettingsSet setHomeOnDeath(boolean new_home_on_death) {
        return new SettingsSet(new_home_on_death, this.default_warp, this.default_no_warp, this.max_warps, this.cooldown, this.warp_history_length, this.death_history_length);
    }

    public SettingsSet setDefaultWarpMessage(String new_default_warp) {
        return new SettingsSet(this.home_on_death, new_default_warp, this.default_no_warp, this.max_warps, this.cooldown, this.warp_history_length, this.death_history_length);
    }

    public SettingsSet setDefaultNoWarpMessage(String new_default_no_warp) {
        return new SettingsSet(this.home_on_death, this.default_warp, new_default_no_warp, this.max_warps, this.cooldown, this.warp_history_length, this.death_history_length);
    }

    public SettingsSet setMaxWarps(int new_max_warps) {
        return new SettingsSet(this.home_on_death, this.default_warp, this.default_no_warp, new_max_warps, this.cooldown, this.warp_history_length, this.death_history_length);
    }

    public SettingsSet setCooldownTime(long new_cooldown) {
        return new SettingsSet(this.home_on_death, this.default_warp, this.default_no_warp, this.max_warps, new_cooldown, this.warp_history_length, this.death_history_length);
    }

    public SettingsSet setWarpHistoryLength(int new_warp_history_length) {
        return new SettingsSet(this.home_on_death, this.default_warp, this.default_no_warp, this.max_warps, this.cooldown, new_warp_history_length, this.death_history_length);
    }

    public SettingsSet setDeathHistoryLength(int new_death_history_length) {
        return new SettingsSet(this.home_on_death, this.default_warp, this.default_no_warp, this.max_warps, this.cooldown, this.warp_history_length, new_death_history_length);
    }
}


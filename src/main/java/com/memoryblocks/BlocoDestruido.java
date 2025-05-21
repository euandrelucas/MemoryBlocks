package com.memoryblocks;

import org.bukkit.Location;
import org.bukkit.Material;

public class BlocoDestruido {
    public String mundo;
    public int x, y, z;
    public Material tipo;

    public BlocoDestruido(Location local, Material tipo) {
        this.mundo = local.getWorld().getName();
        this.x = local.getBlockX();
        this.y = local.getBlockY();
        this.z = local.getBlockZ();
        this.tipo = tipo;
    }

    public Location getLocation() {
        return new Location(org.bukkit.Bukkit.getWorld(mundo), x, y, z);
    }
}

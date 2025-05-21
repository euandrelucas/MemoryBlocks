package com.memoryblocks;

import org.bukkit.Location;
import org.bukkit.Material;

public class BlocoDestruido {
    public Location local;
    public Material tipo;

    public BlocoDestruido(Location local, Material tipo) {
        this.local = local;
        this.tipo = tipo;
    }
}

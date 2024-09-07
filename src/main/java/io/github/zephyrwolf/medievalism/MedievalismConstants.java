package io.github.zephyrwolf.medievalism;

import net.minecraft.resources.ResourceLocation;

public final class MedievalismConstants
{
    public static final String MOD_ID = "medievalism";
    public static final String PARTIAL_OVERHAUL_PACK_ID = "overhaul";
    public static final String OVERHAUL_PACK_ID_ASSET = PARTIAL_OVERHAUL_PACK_ID + "_client";
    public static final String OVERHAUL_PACK_ID_DATA = PARTIAL_OVERHAUL_PACK_ID + "_server";

    public static ResourceLocation resource(String path)
    {
        if (path.contains(":"))
        {
            return ResourceLocation.parse(path);
        }
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}

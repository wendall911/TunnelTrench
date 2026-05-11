package tunneltrench.data.integration;

import net.minecraft.resources.Identifier;

import static technology.roughness.whitenoise.util.ResourceLocationHelper.loc;

public final class ModIntegration {

    public static final String HOMEOSTATIC_MODID = "homeostatic";

    public static Identifier homeostaticLoc(String name) {
        return loc(HOMEOSTATIC_MODID, name);
    }

}


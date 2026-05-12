package tunneltrench;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TunnelTrench {

    public static final String MODID = "tunneltrench";
    public static final String MOD_NAME = "Tunnel & Trench";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
    }

    public static Identifier prefix (String path) {
        return Identifier.fromNamespaceAndPath(MODID, path);
    }

}

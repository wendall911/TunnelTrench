package tunneltrench;

import java.util.Random;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import technology.roughness.whitenoise.config.WhiteNoiseConfig;
import technology.roughness.whitenoise.config.WhiteNoiseConfigLoader;

import tunneltrench.config.ConfigHandler;

import static technology.roughness.whitenoise.util.ResourceLocationHelper.loc;

public class TunnelTrench {

    public static final String MODID = "tunneltrench";
    public static final String MOD_NAME = "Tunnel & Trench";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
    public static final Random RANDOM = new Random();

    public static void init() {
    }

    public static void initConfig() {
        WhiteNoiseConfigLoader.add(WhiteNoiseConfig.Type.COMMON, ConfigHandler.COMMON_SPEC, MODID);
    }

    public static Identifier prefix (String path) {
        return loc(MODID, path);
    }

}

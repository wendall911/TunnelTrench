package tunneltrench.platform;

import java.util.ServiceLoader;

import tunneltrench.TunnelTrench;
import tunneltrench.platform.services.IEffects;

public class Services {

    public static final IEffects EFFECTS = load(IEffects.class);

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
            .findFirst()
            .orElseThrow(
                () -> new NullPointerException("Failed to load service for " + clazz.getName()));
        TunnelTrench.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);

        return loadedService;
    }


}

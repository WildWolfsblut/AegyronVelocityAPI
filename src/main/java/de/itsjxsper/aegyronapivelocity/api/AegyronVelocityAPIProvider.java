package de.itsjxsper.aegyronapivelocity.api;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

/**
 * Provider class for the Aegyron Velocity API singleton.
 * Internal class - developers should use {@link AegyronVelocityAPI#getInstance()} instead.
 *
 * @author ItsJxsper
 * @version 1.0.0
 */
public final class AegyronVelocityAPIProvider {

    private static @Nullable AegyronVelocityAPI instance;

    private AegyronVelocityAPIProvider() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Gets the API instance.
     *
     * @return optional containing the instance, empty if not registered
     */
    static @NonNull Optional<AegyronVelocityAPI> getInstance() {
        return Optional.ofNullable(instance);
    }

    /**
     * Registers the API implementation.
     * This is called internally by the Aegyron Core plugin.
     *
     * @param api the API implementation
     * @throws IllegalStateException if API is already registered
     */
    public static void register(@NonNull AegyronVelocityAPI api) {
        if (instance != null) {
            throw new IllegalStateException("Aegyron Velocity API is already registered");
        }
        instance = api;
    }

    /**
     * Unregisters the API implementation.
     * This is called internally by the Aegyron Core plugin on shutdown.
     */
    public static void unregister() {
        instance = null;
    }

    /**
     * Checks if the API is registered.
     *
     * @return true if registered
     */
    public static boolean isRegistered() {
        return instance != null;
    }
}
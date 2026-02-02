package de.itsjxsper.aegyronapivelocity.api;

import org.jspecify.annotations.NonNull;

import java.util.Optional;

/**
 * Main API interface for Aegyron Velocity Plugin.
 * This is the primary entry point for developers to access Aegyron Core functionality.
 *
 * <p><b>Usage:</b></p>
 * <pre>{@code
 * AegyronVelocityAPI api = AegyronVelocityAPI.getInstance();
 * if (api.isPresent()) {
 *     api.get().messaging().broadcastToAll("Hello Network!");
 * }
 * }</pre>
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AegyronVelocityAPI {

    /**
     * Gets the singleton instance of the Aegyron Velocity API.
     *
     * @return optional containing the API instance, empty if Aegyron is not loaded
     */
    static @NonNull Optional<AegyronVelocityAPI> getInstance() {
        return AegyronVelocityAPIProvider.getInstance();
    }

    /**
     * Gets the messaging API for sending messages and broadcasts.
     *
     * @return the messaging API
     */
    @NonNull MessageAPI messaging();

    /**
     * Gets the group API for server group operations.
     *
     * @return the group API
     */
    @NonNull GroupAPI group();

    /**
     * Gets the vote API for vote system operations.
     *
     * @return the vote API
     */
    @NonNull VoteAPI vote();

    /**
     * Gets the network player API for cross-server player operations.
     *
     * @return the network player API
     */
    @NonNull NetworkPlayerAPI networkPlayer();

    /**
     * Gets the server API for server information and management.
     *
     * @return the server API
     */
    @NonNull ServerAPI server();

    /**
     * Gets the version of the Aegyron Core plugin.
     *
     * @return version string
     */
    @NonNull String getVersion();

    /**
     * Checks if Aegyron Core is fully loaded and operational.
     *
     * @return true if core is ready
     */
    boolean isReady();
}
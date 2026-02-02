package de.itsjxsper.aegyronapivelocity.api;

import net.kyori.adventure.text.Component;
import org.jspecify.annotations.NonNull;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API for sending messages and broadcasts across the network.
 *
 * <p><b>Examples:</b></p>
 * <pre>{@code
 * // Send message to specific player
 * api.messaging().sendMessage(playerUUID, Component.text("Hello!"));
 *
 * // Broadcast to all players
 * api.messaging().broadcastToAll(Component.text("Server restart in 5 minutes"));
 *
 * // Broadcast to specific group
 * api.messaging().broadcastToGroup("survival", Component.text("Event starting!"));
 *
 * // Broadcast to specific server
 * api.messaging().broadcastToServer("lobby-1", Component.text("Welcome!"));
 * }</pre>
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public interface MessageAPI {

    /**
     * Sends a message to a specific player by UUID.
     *
     * @param uuid the player's UUID
     * @param message the message to send
     * @return future that completes when message is sent
     */
    @NonNull CompletableFuture<Void> sendMessage(@NonNull UUID uuid, @NonNull Component message);

    /**
     * Sends a message to a specific player by UUID.
     *
     * @param uuid the player's UUID
     * @param message the message to send (legacy format with color codes)
     * @return future that completes when message is sent
     */
    @NonNull CompletableFuture<Void> sendMessage(@NonNull UUID uuid, @NonNull String message);

    /**
     * Broadcasts a message to all online players across all servers.
     *
     * @param message the message to broadcast
     * @return future that completes when broadcast is sent
     */
    @NonNull CompletableFuture<Void> broadcastToAll(@NonNull Component message);

    /**
     * Broadcasts a message to all online players across all servers.
     *
     * @param message the message to broadcast (legacy format with color codes)
     * @return future that completes when broadcast is sent
     */
    @NonNull CompletableFuture<Void> broadcastToAll(@NonNull String message);

    /**
     * Broadcasts a message to all players in a specific server group.
     *
     * @param groupName the name of the group
     * @param message the message to broadcast
     * @return future that completes when broadcast is sent
     */
    @NonNull CompletableFuture<Void> broadcastToGroup(@NonNull String groupName, @NonNull Component message);

    /**
     * Broadcasts a message to all players in a specific server group.
     *
     * @param groupName the name of the group
     * @param message the message to broadcast (legacy format with color codes)
     * @return future that completes when broadcast is sent
     */
    @NonNull CompletableFuture<Void> broadcastToGroup(@NonNull String groupName, @NonNull String message);

    /**
     * Broadcasts a message to all players on a specific server.
     *
     * @param serverName the name of the server
     * @param message the message to broadcast
     * @return future that completes when broadcast is sent
     */
    @NonNull CompletableFuture<Void> broadcastToServer(@NonNull String serverName, @NonNull Component message);

    /**
     * Broadcasts a message to all players on a specific server.
     *
     * @param serverName the name of the server
     * @param message the message to broadcast (legacy format with color codes)
     * @return future that completes when broadcast is sent
     */
    @NonNull CompletableFuture<Void> broadcastToServer(@NonNull String serverName, @NonNull String message);

    /**
     * Broadcasts a message to players with a specific permission.
     *
     * @param permission the permission node
     * @param message the message to broadcast
     * @return future that completes when broadcast is sent
     */
    @NonNull CompletableFuture<Void> broadcastToPermission(@NonNull String permission, @NonNull Component message);

    /**
     * Broadcasts a message to players with a specific permission.
     *
     * @param permission the permission node
     * @param message the message to broadcast (legacy format with color codes)
     * @return future that completes when broadcast is sent
     */
    @NonNull CompletableFuture<Void> broadcastToPermission(@NonNull String permission, @NonNull String message);

    /**
     * Creates a message builder for complex messages with click/hover events.
     *
     * @return a new message builder instance
     */
    @NonNull MessageBuilder builder();

    /**
     * Builder interface for creating complex messages with interactions.
     */
    interface MessageBuilder {

        /**
         * Sets the base text of the message.
         *
         * @param text the text
         * @return this builder
         */
        @NonNull MessageBuilder text(@NonNull String text);

        /**
         * Sets the base component of the message.
         *
         * @param component the component
         * @return this builder
         */
        @NonNull MessageBuilder component(@NonNull Component component);

        /**
         * Adds a click action to run a command.
         *
         * @param command the command to run (without /)
         * @return this builder
         */
        @NonNull MessageBuilder clickCommand(@NonNull String command);

        /**
         * Adds a click action to suggest a command.
         *
         * @param command the command to suggest
         * @return this builder
         */
        @NonNull MessageBuilder clickSuggest(@NonNull String command);

        /**
         * Adds a click action to open a URL.
         *
         * @param url the URL to open
         * @return this builder
         */
        @NonNull MessageBuilder clickUrl(@NonNull String url);

        /**
         * Adds a hover text.
         *
         * @param text the hover text
         * @return this builder
         */
        @NonNull MessageBuilder hoverText(@NonNull String text);

        /**
         * Adds a hover component.
         *
         * @param component the hover component
         * @return this builder
         */
        @NonNull MessageBuilder hoverComponent(@NonNull Component component);

        /**
         * Builds the final component.
         *
         * @return the built component
         */
        @NonNull Component build();

        /**
         * Builds and sends the message to a player.
         *
         * @param uuid the player's UUID
         * @return future that completes when sent
         */
        @NonNull CompletableFuture<Void> send(@NonNull UUID uuid);

        /**
         * Builds and broadcasts the message to all players.
         *
         * @return future that completes when sent
         */
        @NonNull CompletableFuture<Void> broadcast();
    }
}
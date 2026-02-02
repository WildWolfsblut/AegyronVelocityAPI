package de.itsjxsper.aegyronapivelocity.api;

import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * API for network-wide player operations.
 *
 * <p><b>Examples:</b></p>
 * <pre>{@code
 * // Get total online players
 * int online = api.networkPlayer().getOnlineCount();
 *
 * // Get players in a specific group
 * List<UUID> players = api.networkPlayer().getPlayersInGroup("survival");
 *
 * // Find which server a player is on
 * Optional<String> server = api.networkPlayer().getPlayerServer(playerUUID);
 *
 * // Check if player is online anywhere
 * boolean online = api.networkPlayer().isPlayerOnline(playerUUID);
 * }</pre>
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public interface NetworkPlayerAPI {

    /**
     * Gets the total number of online players across all servers.
     *
     * @return total online player count
     */
    int getOnlineCount();

    /**
     * Gets all online players in a specific group.
     *
     * @param groupName the name of the group
     * @return list of player UUIDs
     */
    @NonNull List<UUID> getPlayersInGroup(@NonNull String groupName);

    /**
     * Gets all online players in a specific group.
     *
     * @param groupUUID the UUID of the group
     * @return list of player UUIDs
     */
    @NonNull List<UUID> getPlayersInGroup(@NonNull UUID groupUUID);

    /**
     * Gets all online players on a specific server.
     *
     * @param serverName the name of the server
     * @return list of player UUIDs
     */
    @NonNull List<UUID> getPlayersOnServer(@NonNull String serverName);

    /**
     * Gets the server a player is currently connected to.
     *
     * @param uuid the player's UUID
     * @return optional containing the server name, empty if player is offline
     */
    @NonNull Optional<String> getPlayerServer(@NonNull UUID uuid);

    /**
     * Checks if a player is online anywhere on the network.
     *
     * @param uuid the player's UUID
     * @return true if player is online
     */
    boolean isPlayerOnline(@NonNull UUID uuid);

    /**
     * Gets a player's username from their UUID.
     *
     * @param uuid the player's UUID
     * @return optional containing the username, empty if not found
     */
    @NonNull Optional<String> getPlayerName(@NonNull UUID uuid);

    /**
     * Gets a player's UUID from their username.
     *
     * @param username the player's username
     * @return optional containing the UUID, empty if not found
     */
    @NonNull Optional<UUID> getPlayerUUID(@NonNull String username);

    /**
     * Gets all online player UUIDs across the network.
     *
     * @return list of all online player UUIDs
     */
    @NonNull List<UUID> getAllOnlinePlayers();

    /**
     * Gets all online player usernames across the network.
     *
     * @return list of all online player usernames
     */
    @NonNull List<String> getAllOnlinePlayerNames();

    /**
     * Gets the number of online players in a specific group.
     *
     * @param groupName the name of the group
     * @return number of online players
     */
    int getOnlineCountInGroup(@NonNull String groupName);

    /**
     * Gets the number of online players in a specific group.
     *
     * @param groupUUID the UUID of the group
     * @return number of online players
     */
    int getOnlineCountInGroup(@NonNull UUID groupUUID);

    /**
     * Gets the number of online players on a specific server.
     *
     * @param serverName the name of the server
     * @return number of online players
     */
    int getOnlineCountOnServer(@NonNull String serverName);

    /**
     * Checks if a player is in a specific group.
     *
     * @param uuid the player's UUID
     * @param groupName the name of the group
     * @return true if player is online and in the specified group
     */
    boolean isPlayerInGroup(@NonNull UUID uuid, @NonNull String groupName);

    /**
     * Checks if a player is on a specific server.
     *
     * @param uuid the player's UUID
     * @param serverName the name of the server
     * @return true if player is online on the specified server
     */
    boolean isPlayerOnServer(@NonNull UUID uuid, @NonNull String serverName);

    /**
     * Gets the group a player is currently in.
     *
     * @param uuid the player's UUID
     * @return optional containing the group name, empty if player is offline
     */
    @NonNull Optional<String> getPlayerGroup(@NonNull UUID uuid);
}
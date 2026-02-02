package de.itsjxsper.aegyronapivelocity.api;

import de.itsjxsper.aegyronapivelocity.models.ServerInfo;
import de.itsjxsper.aegyroncommon.enums.server.ServerStatus;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API for server information and management.
 *
 * <p><b>Examples:</b></p>
 * <pre>{@code
 * // Get server information
 * Optional<ServerInfo> server = api.server().getServerInfo("lobby-1");
 *
 * // Check if server is online
 * boolean online = api.server().isServerOnline("survival");
 *
 * // Get all online servers
 * List<ServerInfo> servers = api.server().getOnlineServers();
 *
 * // Find best server to join
 * Optional<ServerInfo> best = api.server().findBestServer("survival");
 * }</pre>
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ServerAPI {

    /**
     * Gets server information by server name.
     *
     * @param serverName the name of the server
     * @return optional containing server info, empty if not found
     */
    @NonNull Optional<ServerInfo> getServerInfo(@NonNull String serverName);

    /**
     * Gets server information by server UUID.
     *
     * @param serverUUID the UUID of the server
     * @return optional containing server info, empty if not found
     */
    @NonNull Optional<ServerInfo> getServerInfo(@NonNull UUID serverUUID);

    /**
     * Gets server information asynchronously.
     *
     * @param serverName the name of the server
     * @return future containing optional server info
     */
    @NonNull CompletableFuture<Optional<ServerInfo>> getServerInfoAsync(@NonNull String serverName);

    /**
     * Gets all registered servers.
     *
     * @return list of all server info
     */
    @NonNull List<ServerInfo> getAllServers();

    /**
     * Gets all online servers.
     *
     * @return list of online server info
     */
    @NonNull List<ServerInfo> getOnlineServers();

    /**
     * Gets all offline servers.
     *
     * @return list of offline server info
     */
    @NonNull List<ServerInfo> getOfflineServers();

    /**
     * Gets all servers in a specific group.
     *
     * @param groupName the name of the group
     * @return list of server info in the group
     */
    @NonNull List<ServerInfo> getServersInGroup(@NonNull String groupName);

    /**
     * Gets all servers in a specific group.
     *
     * @param groupUUID the UUID of the group
     * @return list of server info in the group
     */
    @NonNull List<ServerInfo> getServersInGroup(@NonNull UUID groupUUID);

    /**
     * Gets the status of a specific server.
     *
     * @param serverName the name of the server
     * @return the server status
     */
    @NonNull ServerStatus getServerStatus(@NonNull String serverName);

    /**
     * Checks if a server is online.
     *
     * @param serverName the name of the server
     * @return true if server is online
     */
    boolean isServerOnline(@NonNull String serverName);

    /**
     * Checks if a server is online.
     *
     * @param serverUUID the UUID of the server
     * @return true if server is online
     */
    boolean isServerOnline(@NonNull UUID serverUUID);

    /**
     * Checks if a server is full (at max capacity).
     *
     * @param serverName the name of the server
     * @return true if server is full
     */
    boolean isServerFull(@NonNull String serverName);

    /**
     * Gets the current player count on a server.
     *
     * @param serverName the name of the server
     * @return current player count, 0 if offline
     */
    int getPlayerCount(@NonNull String serverName);

    /**
     * Gets the maximum player capacity of a server.
     *
     * @param serverName the name of the server
     * @return maximum player capacity
     */
    int getMaxPlayers(@NonNull String serverName);

    /**
     * Finds the best server to join in a group based on load.
     * Returns the server with the lowest load that has capacity.
     *
     * @param groupName the name of the group
     * @return optional containing the best server, empty if no suitable server found
     */
    @NonNull Optional<ServerInfo> findBestServer(@NonNull String groupName);

    /**
     * Finds the best server to join in a group based on load.
     *
     * @param groupUUID the UUID of the group
     * @return optional containing the best server, empty if no suitable server found
     */
    @NonNull Optional<ServerInfo> findBestServer(@NonNull UUID groupUUID);

    /**
     * Finds the least populated server in a group.
     *
     * @param groupName the name of the group
     * @return optional containing the least populated server, empty if no online servers
     */
    @NonNull Optional<ServerInfo> findLeastPopulatedServer(@NonNull String groupName);

    /**
     * Gets all servers with available capacity.
     *
     * @return list of servers that are not full
     */
    @NonNull List<ServerInfo> getServersWithCapacity();

    /**
     * Gets all servers with available capacity in a specific group.
     *
     * @param groupName the name of the group
     * @return list of servers that are not full
     */
    @NonNull List<ServerInfo> getServersWithCapacity(@NonNull String groupName);

    /**
     * Gets the load percentage of a server (players / max players).
     *
     * @param serverName the name of the server
     * @return load percentage (0.0 to 1.0), 0.0 if offline
     */
    double getServerLoad(@NonNull String serverName);

    /**
     * Checks if a server exists (is registered).
     *
     * @param serverName the name of the server
     * @return true if server exists
     */
    boolean serverExists(@NonNull String serverName);

    /**
     * Checks if a server exists (is registered).
     *
     * @param serverUUID the UUID of the server
     * @return true if server exists
     */
    boolean serverExists(@NonNull UUID serverUUID);

    /**
     * Gets the total number of registered servers.
     *
     * @return total server count
     */
    int getTotalServerCount();

    /**
     * Gets the number of online servers.
     *
     * @return online server count
     */
    int getOnlineServerCount();

    /**
     * Gets the number of online servers in a group.
     *
     * @param groupName the name of the group
     * @return online server count in group
     */
    int getOnlineServerCountInGroup(@NonNull String groupName);
}
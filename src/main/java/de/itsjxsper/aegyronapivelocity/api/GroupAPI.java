package de.itsjxsper.aegyronapivelocity.api;

import de.itsjxsper.aegyronapivelocity.models.GroupInfo;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API for server group operations.
 *
 * <p><b>Examples:</b></p>
 * <pre>{@code
 * // Get a specific group
 * Optional<GroupInfo> group = api.group().getGroup("survival");
 *
 * // Get all groups
 * List<GroupInfo> groups = api.group().getAllGroups();
 *
 * // Check if server is in group
 * boolean inGroup = api.group().isServerInGroup("lobby-1", "lobby");
 *
 * // Get servers in a group
 * List<String> servers = api.group().getServersInGroup("survival");
 * }</pre>
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public interface GroupAPI {

    /**
     * Gets a server group by name.
     *
     * @param groupName the name of the group
     * @return optional containing the group info, empty if not found
     */
    @NonNull Optional<GroupInfo> getGroup(@NonNull String groupName);

    /**
     * Gets a server group by UUID.
     *
     * @param groupUUID the UUID of the group
     * @return optional containing the group info, empty if not found
     */
    @NonNull Optional<GroupInfo> getGroup(@NonNull UUID groupUUID);

    /**
     * Gets all server groups.
     *
     * @return list of all groups
     */
    @NonNull List<GroupInfo> getAllGroups();

    /**
     * Gets all server groups asynchronously.
     *
     * @return future containing list of all groups
     */
    @NonNull CompletableFuture<List<GroupInfo>> getAllGroupsAsync();

    /**
     * Checks if a server is in a specific group.
     *
     * @param serverName the name of the server
     * @param groupName the name of the group
     * @return true if server is in the group
     */
    boolean isServerInGroup(@NonNull String serverName, @NonNull String groupName);

    /**
     * Checks if a server is in a specific group.
     *
     * @param serverName the name of the server
     * @param groupUUID the UUID of the group
     * @return true if server is in the group
     */
    boolean isServerInGroup(@NonNull String serverName, @NonNull UUID groupUUID);

    /**
     * Gets all servers in a specific group.
     *
     * @param groupName the name of the group
     * @return list of server names in the group
     */
    @NonNull List<String> getServersInGroup(@NonNull String groupName);

    /**
     * Gets all servers in a specific group.
     *
     * @param groupUUID the UUID of the group
     * @return list of server names in the group
     */
    @NonNull List<String> getServersInGroup(@NonNull UUID groupUUID);

    /**
     * Gets the number of online players in a group.
     *
     * @param groupName the name of the group
     * @return number of online players
     */
    int getOnlinePlayersInGroup(@NonNull String groupName);

    /**
     * Gets the number of online players in a group.
     *
     * @param groupUUID the UUID of the group
     * @return number of online players
     */
    int getOnlinePlayersInGroup(@NonNull UUID groupUUID);

    /**
     * Gets the total player capacity of a group.
     *
     * @param groupName the name of the group
     * @return total player capacity
     */
    int getTotalCapacityInGroup(@NonNull String groupName);

    /**
     * Gets the total player capacity of a group.
     *
     * @param groupUUID the UUID of the group
     * @return total player capacity
     */
    int getTotalCapacityInGroup(@NonNull UUID groupUUID);

    /**
     * Checks if a group has available capacity.
     *
     * @param groupName the name of the group
     * @return true if group has available slots
     */
    boolean hasCapacity(@NonNull String groupName);

    /**
     * Checks if a group has available capacity.
     *
     * @param groupUUID the UUID of the group
     * @return true if group has available slots
     */
    boolean hasCapacity(@NonNull UUID groupUUID);

    /**
     * Gets the group that a server belongs to.
     *
     * @param serverName the name of the server
     * @return optional containing the group name, empty if server not found
     */
    @NonNull Optional<String> getServerGroup(@NonNull String serverName);

    /**
     * Reloads group configuration from the backend.
     *
     * @param groupName the name of the group to reload
     * @return future that completes when reload is done
     */
    @NonNull CompletableFuture<Void> reloadGroup(@NonNull String groupName);

    /**
     * Reloads all group configurations from the backend.
     *
     * @return future that completes when reload is done
     */
    @NonNull CompletableFuture<Void> reloadAllGroups();
}
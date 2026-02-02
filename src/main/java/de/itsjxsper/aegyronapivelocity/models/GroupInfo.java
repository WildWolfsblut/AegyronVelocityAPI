package de.itsjxsper.aegyronapivelocity.models;

import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents information about a server group.
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public class GroupInfo {

    private final UUID groupUUID;
    private final String groupName;
    private final List<String> servers;
    private final int totalPlayers;
    private final int totalCapacity;
    private final int onlineServers;

    public GroupInfo(
            @NonNull UUID groupUUID,
            @NonNull String groupName,
            @NonNull List<String> servers,
            int totalPlayers,
            int totalCapacity,
            int onlineServers
    ) {
        this.groupUUID = Objects.requireNonNull(groupUUID, "groupUUID");
        this.groupName = Objects.requireNonNull(groupName, "groupName");
        this.servers = List.copyOf(servers);
        this.totalPlayers = totalPlayers;
        this.totalCapacity = totalCapacity;
        this.onlineServers = onlineServers;
    }

    /**
     * Gets the UUID of this group.
     *
     * @return group UUID
     */
    public @NonNull UUID getGroupUUID() {
        return groupUUID;
    }

    /**
     * Gets the name of this group.
     *
     * @return group name
     */
    public @NonNull String getGroupName() {
        return groupName;
    }

    /**
     * Gets all servers in this group.
     *
     * @return unmodifiable list of server names
     */
    public @NonNull List<String> getServers() {
        return servers;
    }

    /**
     * Gets the total number of online players in this group.
     *
     * @return total online players
     */
    public int getTotalPlayers() {
        return totalPlayers;
    }

    /**
     * Gets the total player capacity of this group.
     *
     * @return total capacity
     */
    public int getTotalCapacity() {
        return totalCapacity;
    }

    /**
     * Gets the number of online servers in this group.
     *
     * @return online server count
     */
    public int getOnlineServers() {
        return onlineServers;
    }

    /**
     * Gets the total number of servers in this group.
     *
     * @return total server count
     */
    public int getTotalServers() {
        return servers.size();
    }

    /**
     * Calculates the load percentage of this group.
     *
     * @return load percentage (0.0 to 1.0)
     */
    public double getLoadPercentage() {
        return totalCapacity > 0 ? (double) totalPlayers / totalCapacity : 0.0;
    }

    /**
     * Checks if this group has available capacity.
     *
     * @return true if group has capacity
     */
    public boolean hasCapacity() {
        return totalPlayers < totalCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupInfo that)) return false;
        return groupUUID.equals(that.groupUUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupUUID);
    }

    @Override
    public String toString() {
        return "GroupInfo{" +
                "groupUUID=" + groupUUID +
                ", groupName='" + groupName + '\'' +
                ", servers=" + servers.size() +
                ", players=" + totalPlayers + "/" + totalCapacity +
                ", online=" + onlineServers +
                '}';
    }
}
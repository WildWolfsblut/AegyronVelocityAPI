package de.itsjxsper.aegyronapivelocity.events;

import net.kyori.adventure.text.Component;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

/**
 * Event fired when a network-wide announcement is made.
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public class NetworkAnnouncementEvent extends VelocityEvent {

    private final Component message;
    private final String type;
    private final String targetGroup;

    public NetworkAnnouncementEvent(
            @NonNull Component message,
            @NonNull String type,
            @Nullable String targetGroup
    ) {
        super();
        this.message = Objects.requireNonNull(message, "message");
        this.type = Objects.requireNonNull(type, "type");
        this.targetGroup = targetGroup;
    }

    /**
     * Gets the announcement message.
     *
     * @return announcement message component
     */
    public @NonNull Component getMessage() {
        return message;
    }

    /**
     * Gets the type of announcement (e.g., "info", "warning", "alert").
     *
     * @return announcement type
     */
    public @NonNull String getType() {
        return type;
    }

    /**
     * Gets the target group for this announcement.
     * If empty, the announcement is network-wide.
     *
     * @return optional containing target group name
     */
    public @NonNull Optional<String> getTargetGroup() {
        return Optional.ofNullable(targetGroup);
    }

    /**
     * Checks if this announcement targets a specific group.
     *
     * @return true if announcement is group-specific
     */
    public boolean isGroupSpecific() {
        return targetGroup != null;
    }

    /**
     * Checks if this announcement is network-wide.
     *
     * @return true if announcement is for all servers
     */
    public boolean isNetworkWide() {
        return targetGroup == null;
    }

    @Override
    public String toString() {
        return "NetworkAnnouncementEvent{" +
                "type='" + type + '\'' +
                ", targetGroup='" + targetGroup + '\'' +
                ", timestamp=" + getTimestamp() +
                '}';
    }
}
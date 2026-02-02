package de.itsjxsper.aegyronapivelocity.events;

import org.jspecify.annotations.NonNull;

import java.time.Instant;
import java.util.Objects;

/**
 * Base class for all Aegyron Velocity events.
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class VelocityEvent {

    private final Instant timestamp;

    protected VelocityEvent() {
        this.timestamp = Instant.now();
    }

    /**
     * Gets the timestamp when this event was created.
     *
     * @return event timestamp
     */
    public @NonNull Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VelocityEvent that)) return false;
        return timestamp.equals(that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp);
    }
}
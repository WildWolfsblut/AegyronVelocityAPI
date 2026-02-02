package de.itsjxsper.aegyronapivelocity.models;

import org.jspecify.annotations.NonNull;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents vote statistics for a player.
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public class VoteStats {

    private final UUID playerUUID;
    private final int totalVotes;
    private final int currentStreak;
    private final int longestStreak;
    private final Instant lastVoteTime;

    public VoteStats(
            @NonNull UUID playerUUID,
            int totalVotes,
            int currentStreak,
            int longestStreak,
            Instant lastVoteTime
    ) {
        this.playerUUID = Objects.requireNonNull(playerUUID, "playerUUID");
        this.totalVotes = totalVotes;
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
        this.lastVoteTime = lastVoteTime;
    }

    /**
     * Gets the UUID of the player.
     *
     * @return player UUID
     */
    public @NonNull UUID getPlayerUUID() {
        return playerUUID;
    }

    /**
     * Gets the total number of votes.
     *
     * @return total votes
     */
    public int getTotalVotes() {
        return totalVotes;
    }

    /**
     * Gets the current vote streak.
     *
     * @return current streak
     */
    public int getCurrentStreak() {
        return currentStreak;
    }

    /**
     * Gets the longest vote streak ever achieved.
     *
     * @return longest streak
     */
    public int getLongestStreak() {
        return longestStreak;
    }

    /**
     * Gets the timestamp of the last vote.
     *
     * @return optional containing last vote time, empty if never voted
     */
    public @NonNull Optional<Instant> getLastVoteTime() {
        return Optional.ofNullable(lastVoteTime);
    }

    /**
     * Checks if the player has an active streak.
     *
     * @return true if current streak is greater than 0
     */
    public boolean hasActiveStreak() {
        return currentStreak > 0;
    }

    /**
     * Checks if the player has voted today.
     * Assumes a vote within the last 24 hours counts as "today".
     *
     * @return true if voted within last 24 hours
     */
    public boolean hasVotedToday() {
        if (lastVoteTime == null) {
            return false;
        }
        Instant oneDayAgo = Instant.now().minusSeconds(86400);
        return lastVoteTime.isAfter(oneDayAgo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VoteStats voteStats)) return false;
        return playerUUID.equals(voteStats.playerUUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerUUID);
    }

    @Override
    public String toString() {
        return "VoteStats{" +
                "playerUUID=" + playerUUID +
                ", totalVotes=" + totalVotes +
                ", currentStreak=" + currentStreak +
                ", longestStreak=" + longestStreak +
                ", lastVoteTime=" + lastVoteTime +
                '}';
    }
}
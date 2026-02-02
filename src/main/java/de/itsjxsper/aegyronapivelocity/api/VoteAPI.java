package de.itsjxsper.aegyronapivelocity.api;

import de.itsjxsper.aegyronapivelocity.models.VotePartyStatus;
import de.itsjxsper.aegyronapivelocity.models.VoteStats;
import org.jspecify.annotations.NonNull;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API for vote system operations.
 *
 * <p><b>Examples:</b></p>
 * <pre>{@code
 * // Get vote statistics for a player
 * Optional<VoteStats> stats = api.vote().getVoteStats(playerUUID);
 *
 * // Get vote party status
 * VotePartyStatus status = api.vote().getVotePartyStatus();
 *
 * // Manually trigger vote party (admin command)
 * api.vote().triggerVoteParty();
 *
 * // Record a vote
 * api.vote().recordVote(playerUUID, "MinecraftServers");
 * }</pre>
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public interface VoteAPI {

    /**
     * Gets vote statistics for a specific player.
     *
     * @param uuid the player's UUID
     * @return optional containing vote stats, empty if player not found
     */
    @NonNull Optional<VoteStats> getVoteStats(@NonNull UUID uuid);

    /**
     * Gets vote statistics for a specific player asynchronously.
     *
     * @param uuid the player's UUID
     * @return future containing optional vote stats
     */
    @NonNull CompletableFuture<Optional<VoteStats>> getVoteStatsAsync(@NonNull UUID uuid);

    /**
     * Gets the current vote party status.
     *
     * @return the vote party status
     */
    @NonNull VotePartyStatus getVotePartyStatus();

    /**
     * Gets the current vote party status asynchronously.
     *
     * @return future containing the vote party status
     */
    @NonNull CompletableFuture<VotePartyStatus> getVotePartyStatusAsync();

    /**
     * Manually triggers a vote party.
     * This is typically used by admin commands.
     *
     * @return future that completes when vote party is triggered
     */
    @NonNull CompletableFuture<Void> triggerVoteParty();

    /**
     * Records a vote for a player.
     *
     * @param uuid the player's UUID
     * @param serviceName the name of the voting service
     * @return future that completes when vote is recorded
     */
    @NonNull CompletableFuture<Void> recordVote(@NonNull UUID uuid, @NonNull String serviceName);

    /**
     * Gets the total number of votes for a player.
     *
     * @param uuid the player's UUID
     * @return the total vote count
     */
    int getTotalVotes(@NonNull UUID uuid);

    /**
     * Gets the current vote streak for a player.
     *
     * @param uuid the player's UUID
     * @return the current vote streak
     */
    int getCurrentStreak(@NonNull UUID uuid);

    /**
     * Gets the longest vote streak for a player.
     *
     * @param uuid the player's UUID
     * @return the longest vote streak
     */
    int getLongestStreak(@NonNull UUID uuid);

    /**
     * Gets the number of votes needed until the next vote party.
     *
     * @return votes remaining until vote party
     */
    int getVotesUntilParty();

    /**
     * Gets the total number of votes collected for the current vote party.
     *
     * @return current vote party progress
     */
    int getCurrentPartyVotes();

    /**
     * Gets the vote party threshold (votes needed to trigger).
     *
     * @return vote party threshold
     */
    int getVotePartyThreshold();

    /**
     * Checks if a player has voted today.
     *
     * @param uuid the player's UUID
     * @return true if player has voted today
     */
    boolean hasVotedToday(@NonNull UUID uuid);

    /**
     * Gets the timestamp of a player's last vote.
     *
     * @param uuid the player's UUID
     * @return optional containing the timestamp in milliseconds, empty if never voted
     */
    @NonNull Optional<Long> getLastVoteTime(@NonNull UUID uuid);

    /**
     * Resets the vote party counter.
     * This is typically used by admin commands after manually triggering a party.
     *
     * @return future that completes when counter is reset
     */
    @NonNull CompletableFuture<Void> resetVotePartyCounter();
}
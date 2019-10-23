package seedu.address.model.statistics.exceptions;

public class DuplicateStatisticsException extends RuntimeException {
    public DuplicateStatisticsException() {
        super("Operation would result in duplicate statistics");
    }
}
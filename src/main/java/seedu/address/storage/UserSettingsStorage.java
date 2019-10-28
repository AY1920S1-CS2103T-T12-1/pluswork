package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyUserSettings;
import seedu.address.model.UserSettings;

/**
 * Represents a storage for {@link seedu.address.model.UserSettings}.
 */
public interface UserSettingsStorage {

    /**
     * Returns the file path of the UserSettings data file.
     *
     */
    Path getUserSettingsFilePath();

    /**
     * Returns UserSettings data from storage.
     *   Returns {@code Optional.empty()} if storage file is not found.
     *
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<UserSettings> readUserSettings() throws DataConversionException, IOException;

    /**
     * @see #getUserSettingsFilePath().
     */
    Optional<UserSettings> readUserSettings(Path filePath) throws DataConversionException;

    /**
     * Saves the given {@link seedu.address.model.ReadOnlyUserSettings} to the storage.
     *
     * @param userSettings cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveUserSettings(ReadOnlyUserSettings userSettings) throws IOException;

    void saveUserSettings(ReadOnlyUserSettings userSettings, Path filePath) throws IOException;
}
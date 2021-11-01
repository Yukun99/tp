package seedu.notor.guitest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import seedu.notor.AppParameters;
import seedu.notor.MainApp;
import seedu.notor.commons.core.trie.Trie;
import seedu.notor.logic.LogicManager;
import seedu.notor.logic.executors.Executor;
import seedu.notor.model.UserPrefs;
import seedu.notor.storage.JsonNotorStorage;
import seedu.notor.storage.JsonUserPrefsStorage;
import seedu.notor.storage.NotorStorage;
import seedu.notor.storage.StorageManager;
import seedu.notor.storage.UserPrefsStorage;
import seedu.notor.ui.UiManager;

public class MainAppStub extends MainApp {

    private static final Path TEST_FILE_PATH = Paths.get("data", "test.json");

    @Override
    public void init() throws Exception {
        logger.info("=============================[ Initializing Notor ]===========================");
        super.init();

        AppParameters appParameters = AppParameters.parse(getParameters());
        config = initConfig(appParameters.getConfigPath());

        UserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(config.getUserPrefsFilePath());
        UserPrefs userPrefs = initPrefs(userPrefsStorage);
        NotorStorage testStorage = new JsonNotorStorage(TEST_FILE_PATH);
        storage = new StorageManager(testStorage, userPrefsStorage);

        initLogging(config);

        model = initModelManager(storage, userPrefs);

        logic = new LogicManager(model, storage);

        ui = new UiManager(logic, model);

        Executor.setup(model);
    }

    /**
     * Removes TestCase For Reinitialisation.
     */
    public static void removeTestFile() {
        try {
            Files.deleteIfExists(TEST_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

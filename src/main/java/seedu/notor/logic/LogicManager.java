package seedu.notor.logic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.notor.commons.core.GuiSettings;
import seedu.notor.commons.core.LogsCenter;
import seedu.notor.logic.commands.Command;
import seedu.notor.logic.commands.CommandResult;
import seedu.notor.logic.commands.exceptions.CommandException;
import seedu.notor.logic.executors.exceptions.ExecuteException;
import seedu.notor.logic.parser.NotorParser;
import seedu.notor.logic.parser.exceptions.ParseException;
import seedu.notor.model.Model;
import seedu.notor.model.Notor;
import seedu.notor.model.ReadOnlyNotor;
import seedu.notor.model.group.SubGroup;
import seedu.notor.model.group.SuperGroup;
import seedu.notor.model.person.Person;
import seedu.notor.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final NotorParser notorParser;

    /**
     * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
     */
    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        notorParser = new NotorParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException, ExecuteException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");
        CommandResult commandResult;
        Command command = notorParser.parseCommand(commandText);
        commandResult = command.execute(model);

        try {
            storage.saveNotor(model.getNotor());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        return commandResult;
    }

    /**
     * Executes command to save Note of Person.
     * @param person The person with yet to edit notes.
     * @param editedPerson The person with newly edited notes.
     * @throws CommandException If an error occurs during command execution.
     */
    public void executeSaveNote(Person person, Person editedPerson) throws CommandException {
        model.setPerson(person, editedPerson);
        try {
            storage.saveNotor(model.getNotor());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }
    }

    /**
     * Executes command to save Note of Group.
     * @throws CommandException If an error occurs during command execution.
     */
    public void executeSaveNote() throws CommandException {
        try {
            storage.saveNotor(model.getNotor());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }
    }

    /**
     * Executes command to save general Note to Notor.
     * @param notor Notor with newly saved note.
     * @throws CommandException If an error occurs during command execution.
     */
    public void executeSaveNote(Notor notor) throws CommandException {
        // TODO: Update Group Display
        try {
            storage.saveNotor(notor);
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }
    }


    @Override
    public ReadOnlyNotor getNotor() {
        return model.getNotor();
    }

    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return model.getFilteredPersonList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public ObservableList<SuperGroup> getFilteredSuperGroupList() {
        // TODO: Probably need to check here. This is too hacky.
        return (ObservableList<SuperGroup>) model.getFilteredGroupList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public ObservableList<SubGroup> getFilteredSubGroupList() {
        // TODO: Probably need to check here. This is too hacky.
        return (ObservableList<SubGroup>) model.getFilteredGroupList();
    }

    @Override
    public boolean isPersonList() {
        return model.isPersonList();
    }

    @Override
    public boolean isSuperGroupList() {
        // TODO: BUG WHAT IF THERE IS NO ELEMENT.
        return model.isSuperGroupList();
    }

    @Override
    public Path getNotorFilePath() {
        return model.getNotorFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }
}

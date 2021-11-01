package seedu.notor.guitest;


import org.junit.jupiter.api.Test;

import javafx.scene.input.KeyCode;
import seedu.notor.logic.commands.ClearNoteCommand;


public class WarningWindowTest extends UiTest {

    public static final String COMMAND_BOX_ID = "#commandTextField";
    public static final String WARNING_WINDOW_CANCEL_BUTTON_ID = "#cancelButton";
    public static final String WARNING_WINDOW_CONTINUE_BUTTON_ID = "#continueButton";
    public static final String CLEAR_FIRST_INDEX_TAGS_COMMAND_STRING = "p 1 /ct";


    @Test
    public void should_promptWarningWindowAndPressCancel_onClearNote() {
        clickOn(COMMAND_BOX_ID).write(ClearNoteCommand.COMMAND_WORD);
        clickOn(COMMAND_BOX_ID).press(KeyCode.ENTER);
        clickOn(WARNING_WINDOW_CANCEL_BUTTON_ID);
        MainAppStub.removeTestFile();
    }

    @Test
    public void should_promptWarningWindowAndPressContinue_onClearTag() {
        clickOn(COMMAND_BOX_ID).write(CLEAR_FIRST_INDEX_TAGS_COMMAND_STRING);
        clickOn(COMMAND_BOX_ID).press(KeyCode.ENTER);
        clickOn(WARNING_WINDOW_CONTINUE_BUTTON_ID);
        MainAppStub.removeTestFile();
    }

    @Test
    public void should_promptWarningWindowAndPressCancel_onClearTag() {
        clickOn(COMMAND_BOX_ID).write(CLEAR_FIRST_INDEX_TAGS_COMMAND_STRING);
        clickOn(COMMAND_BOX_ID).press(KeyCode.ENTER);
        clickOn(WARNING_WINDOW_CANCEL_BUTTON_ID);
        MainAppStub.removeTestFile();
    }
}

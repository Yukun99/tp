package seedu.notor.guitest;

import static org.testfx.api.FxAssert.verifyThat;

import org.junit.jupiter.api.Test;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;


public class CommandHistoryTest extends UiTest {

    public static final String COMMAND_BOX_ID = "#commandTextField";
    public static final String VALID_LIST_COMMAND = "p /l";
    public static final String INVALID_COMMAND = "p 2/l";
    public static final String EMPTY_STRING = "";

    /**
     * Executes a valid command and checks if CommandHistory is available upon pressing Up key.
     */
    @Test
    public void should_haveCommandHistoryWhenPressedUp_onSuccessCommand() {
        clickOn(COMMAND_BOX_ID).write(VALID_LIST_COMMAND);
        clickOn(COMMAND_BOX_ID).press(KeyCode.ENTER);
        verifyThat(COMMAND_BOX_ID, (TextField textField) -> {
            clickOn(COMMAND_BOX_ID).press(KeyCode.UP);
            String commandHistoryText = textField.getText();
            return commandHistoryText.equals(VALID_LIST_COMMAND);
        });
        MainAppStub.removeTestFile();
    }

    /**
     * Executes a invalid command and checks if CommandHistory is empty upon pressing Up key.
     */
    @Test
    public void should_emptyCommandWhenPressedUp_onFailCommand() {
        clickOn(COMMAND_BOX_ID).write(INVALID_COMMAND);
        clickOn(COMMAND_BOX_ID).press(KeyCode.ENTER);
        verifyThat(COMMAND_BOX_ID, (TextField textField) -> {
            clickOn(COMMAND_BOX_ID).press(KeyCode.UP);
            String commandHistoryText = textField.getText();
            return commandHistoryText.equals(EMPTY_STRING);
        });
        MainAppStub.removeTestFile();
    }

}

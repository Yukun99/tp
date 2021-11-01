package seedu.notor.guitest;

import static org.testfx.api.FxAssert.verifyThat;

import org.junit.jupiter.api.Test;

import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import seedu.notor.logic.commands.NoteCommand;
import seedu.notor.ui.note.NoteWindow;



public class NoteWindowTest extends UiTest {
    public static final String COMMAND_BOX_ID = "#commandTextField";
    public static final String NOTE_TEXTAREA_ID = "#noteTextArea";
    public static final String GENERAL_NOTE_PANEL_ID = "#noteTextArea";
    public static final String TEST_TEXT = "hello world 121234~ hello world";


    public void setTestTextForTextArea() {
        clickOn(COMMAND_BOX_ID).write(NoteCommand.COMMAND_WORD);
        clickOn(COMMAND_BOX_ID).press(KeyCode.ENTER);
        TextArea textArea1 = lookup(NOTE_TEXTAREA_ID).query();
        textArea1.setText(TEST_TEXT);
    }

    @Test
    public void should_updateNoteWindowTextArea_onAddText() {
        setTestTextForTextArea();
        verifyThat(NOTE_TEXTAREA_ID, (TextArea textArea) -> textArea.getText().equals(TEST_TEXT));
        MainAppStub.removeTestFile();
    }

    @Test
    public void should_containsSameContentForNotePaneAndNoteWindow_onSaved() {
        clickOn(COMMAND_BOX_ID).write(NoteCommand.COMMAND_WORD);
        clickOn(COMMAND_BOX_ID).press(KeyCode.ENTER);
        TextArea textArea1 = lookup(NOTE_TEXTAREA_ID).query();
        String userText = textArea1.getText();
        textArea1.setText(TEST_TEXT);

        clickOn(NOTE_TEXTAREA_ID).push((KeyCodeCombination) NoteWindow.SAVE_KEY);

        verifyThat(NOTE_TEXTAREA_ID, (TextArea textArea) -> {
            TextArea generalNoteTextArea = lookup(GENERAL_NOTE_PANEL_ID).query();
            boolean isGeneralNotePanelUpdated = generalNoteTextArea.getText().equals(TEST_TEXT);
            textArea.setText(userText);
            clickOn(NOTE_TEXTAREA_ID).push((KeyCodeCombination) NoteWindow.EXIT_AND_SAVE_KEY);
            return isGeneralNotePanelUpdated;
        });
        MainAppStub.removeTestFile();
    }

    @Test
    public void should_promptConfirmationWindow_onExitNoteWithoutSaving() {
        setTestTextForTextArea();
        clickOn(NOTE_TEXTAREA_ID).push((KeyCodeCombination) NoteWindow.EXIT_KEY);
        clickOn("#doNotSaveButton");
        MainAppStub.removeTestFile();
    }

}

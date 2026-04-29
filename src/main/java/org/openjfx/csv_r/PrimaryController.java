package org.openjfx.csv_r;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    private void closeApplication() {
    	Platform.exit();
    }
    
    //TODO: Import Pop-up window
    @FXML
    private void spawnFileChooser() {
    	Stage stage = new Stage();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Import CSV");
    	fileChooser.showOpenDialog(stage);
    }
    //TODO: Import CSV
}

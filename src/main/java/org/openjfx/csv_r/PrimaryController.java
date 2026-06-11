package org.openjfx.csv_r;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    private void closeApplication() {
    	Platform.exit();
    }
    
    @FXML
    private void importData(){
    	Stage stage = new Stage();
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Import CSV");
    	File selectedFile = fileChooser.showOpenDialog(stage);
    	try {
    		FileReader fileReader = new FileReader(selectedFile);
    		CSVReader csvReader = new CSVReader(fileReader);
    		State programState = new State(csvReader.readAll());
    		csvReader.close();
    	}catch(FileNotFoundException e) {
    		//TODO: What if file reader is canceled? Handle exception.
    		e.printStackTrace();
    	}catch(IOException e) {
    		//TODO: What if the wrong file type is chosen? Implement better abstraction.
    		e.printStackTrace();
    	}
    }
    
}

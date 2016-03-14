/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfmcda;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author Arie Claassens <gy13awc@leeds.ac.uk>
 */
public class FXMLDocumentController implements Initializable {
    
    private int mycount = 1;
    public String[][] arrLayers;
    
    @FXML
    private Label label;
    
    @FXML
    private TextArea txtComments;
    
    @FXML
    private TextField lyrFileName1;

    @FXML
    private TextField lyrFileName2;

    @FXML
    private TextField lyrFileName3;

    @FXML
    private TextField lyrFileName4;

    @FXML
    private TextField lyrFileName5;

    @FXML
    private TextField lyrName1;

    @FXML
    private TextField lyrName2;

    @FXML
    private TextField lyrName3;

    @FXML
    private TextField lyrName4;
	
    @FXML
    private TextField lyrName5;

    @FXML
    private Button btnSelectFile1;
	
    @FXML
    private Button btnSelectFile2;
	
    @FXML
    private Button btnSelectFile3;
	
    @FXML
    private Button btnSelectFile4;
	
    @FXML
    private Button btnSelectFile5;

    @FXML
    private Slider slider4;

    @FXML
    private Slider slider1;

    @FXML
    private Slider slider2;

    @FXML
    private Slider slider3;
	
    @FXML
    private Slider slider5;
     
    
    @FXML 
    protected File locateFile() {
    FileChooser chooser = new FileChooser();
    chooser.setTitle("Select Layer Shape File");
    //ToDo Add support for more file formats than just shape files
    chooser.getExtensionFilters().addAll(
			new ExtensionFilter("Shape Files", "*.shp"));
    
    //See http://stackoverflow.com/questions/25491732/how-do-i-open-the-javafx-filechooser-from-a-controller-class
    File file = chooser.showOpenDialog(new Stage());
    return file;
}
       
    @FXML
    private void handleSelectFileAction1(ActionEvent event) {
        //TODO
        //Move to a single function that can handle all the buttons. Will need to accept a layer ID parameter        
        System.out.println("You clicked the Select File 1 button!");
        File file1 = locateFile();
        lyrFileName1.setText(file1.getAbsoluteFile().toString());
    }
       
    @FXML
    private void handleSelectFileAction2(ActionEvent event) {
        
        System.out.println("You clicked the Select File 2 button!");
        File file2 = locateFile();
        lyrFileName2.setText(file2.getAbsoluteFile().toString());
    }
    
    @FXML
    private void handleSelectFileAction3(ActionEvent event) {
        
        System.out.println("You clicked the Select File 3 button!");
        File file3 = locateFile();
        lyrFileName3.setText(file3.getAbsoluteFile().toString());
    }
    
    @FXML
    private void handleSelectFileAction4(ActionEvent event) {
        
        System.out.println("You clicked the Select File 4 button!");
        File file4 = locateFile();
        lyrFileName4.setText(file4.getAbsoluteFile().toString());
    }
    
    @FXML
    private void handleSelectFileAction5(ActionEvent event) {
        
        System.out.println("You clicked the Select File 5 button!");
        File file5 = locateFile();
        lyrFileName5.setText(file5.getAbsoluteFile().toString());
    }
    
    @FXML
    private void handleClearButton(ActionEvent event) {
        //Clear all the input from the text fields and reset the sliders to zero
        lyrName1.clear();
        lyrName2.clear();
        lyrName3.clear();
        lyrName4.clear();
        lyrName5.clear();
        lyrFileName1.clear();
        lyrFileName2.clear();
        lyrFileName3.clear();
        lyrFileName4.clear();
        lyrFileName5.clear();
        slider1.setValue(0);
        slider2.setValue(0);
        slider3.setValue(0);
        slider4.setValue(0);
        slider5.setValue(0);
        slider1.setStyle("-fx-background-color: transparent");
        slider2.setStyle("-fx-background-color: transparent");
        slider3.setStyle("-fx-background-color: transparent");
        slider4.setStyle("-fx-background-color: transparent");
        slider5.setStyle("-fx-background-color: transparent");
        txtComments.setText("");
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World "+mycount+" times!");
        mycount++;
    }
    
    @FXML
    private void handleAboutMenuAction(ActionEvent event) {
        System.out.println("You clicked the Help -> About menu item");
        label.setText("You clicked the Help -> About menu item");
        String currentWorkingDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentWorkingDir);
    }
    
    @FXML
    private void handleStartProcess(ActionEvent event) {
        String errMsg = "";
        boolean canStart = false;
        
        System.out.println("You clicked the 'Start the process' button!");
        label.setText("You clicked the 'Start the process' button!");
        //Start testing for logical errors before initiating the MCDA process
        //Check if layers have been assigned a user-friendly name
        if (("".equals(lyrName1.getText())) || ("Layer 1 Name".equals(lyrName1.getText()))) {
            errMsg += "Layer 1 does not have a NAME, please give it a name\n\r";
            lyrName1.setStyle("-fx-text-fill: red;");
          } else {
            lyrName1.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrName2.getText())) || ("Layer 2 Name".equals(lyrName2.getText()))) {
            errMsg += "Layer 2 does not have a NAME, please give it a name\n\r";
            lyrName2.setStyle("-fx-text-fill: red;");
          } else {
            lyrName2.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrName3.getText())) || ("Layer 3 Name".equals(lyrName3.getText()))) {
            errMsg += "Layer 3 does not have a NAME, please give it a name\n\r";
            lyrName3.setStyle("-fx-text-fill: red;");
          } else {
            lyrName3.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrName4.getText())) || ("Layer 4 Name".equals(lyrName4.getText()))) {
            errMsg += "Layer 4 does not have a NAME, please give it a name\n\r";
            lyrName4.setStyle("-fx-text-fill: red;");
          } else {
            lyrName4.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrName5.getText())) || ("Layer 5 Name".equals(lyrName5.getText()))) {
            errMsg += "Layer 5 does not have a NAME, please give it a name\n\r";
            lyrName5.setStyle("-fx-text-fill: red;");
          } else {
            lyrName5.setStyle("-fx-text-fill: black;");
        }
        
        //Check if the layer names are unique
        
        
        
        //Check if layer filenames have been captured, i.e. if all layers have been assigned
        if (("".equals(lyrFileName1.getText())) || ("Layer 1 Filename".equals(lyrFileName1.getText()))) {
            errMsg += "Please select a file for Layer 1\n\r";
            lyrFileName1.setStyle("-fx-text-fill: red;");
          } else {
            lyrFileName1.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrFileName2.getText())) || ("Layer 2 Filename".equals(lyrFileName2.getText()))) {
            errMsg += "Please select a file for Layer 2\n\r";
            lyrFileName2.setStyle("-fx-text-fill: red;");
          } else {
            lyrFileName2.setStyle("-fx-text-fill: black;");
        }

        if (("".equals(lyrFileName3.getText())) || ("Layer 3 Filename".equals(lyrFileName3.getText()))) {
            errMsg += "Please select a file for Layer 3\n\r";
            lyrFileName3.setStyle("-fx-text-fill: red;");
          } else {
            lyrFileName3.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrFileName4.getText())) || ("Layer 4 Filename".equals(lyrFileName4.getText()))) {
            errMsg += "Please select a file for Layer 4\n\r";
            lyrFileName4.setStyle("-fx-text-fill: red;");
          } else {
            lyrFileName4.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrFileName5.getText())) || ("Layer 5 Filename".equals(lyrFileName5.getText()))) {
            errMsg += "Please select a file for Layer 5\n\r";
            lyrFileName5.setStyle("-fx-text-fill: red;");
          } else {
            lyrFileName5.setStyle("-fx-text-fill: black;");
        }
        
        //Check if all the assigned layers have a weight assigned
        if (slider1.getValue() == 0) {
            errMsg += "Please assign a relative weight for Layer 1\n\r";
            slider1.setStyle("-fx-background-color: red;");
        } else {
            slider1.setStyle("-fx-background-color: transparent");
        }
        
        if (slider2.getValue() == 0) {
            errMsg += "Please assign a relative weight for Layer 2\n\r";
            slider2.setStyle("-fx-background-color: red;");
        } else {
            slider2.setStyle("-fx-background-color: transparent");
        }
        
        if (slider3.getValue() == 0) {
            errMsg += "Please assign a relative weight for Layer 3\n\r";
            slider3.setStyle("-fx-background-color: red;");
        } else {
            slider3.setStyle("-fx-background-color: transparent");
        }
        
        if (slider4.getValue() == 0) {
            errMsg += "Please assign a relative weight for Layer 4\n\r";
            slider4.setStyle("-fx-background-color: red;");
        } else {
            slider4.setStyle("-fx-background-color: transparent");
        }
        
        if (slider5.getValue() == 0) {
            errMsg += "Please assign a relative weight for Layer 5\n\r";
            slider5.setStyle("-fx-background-color: red;");
        } else {
            slider5.setStyle("-fx-background-color: transparent");
        }
        
        
        
        //Check if error message parameter is empty and we can proceed, otherwise require user to fix errors first
        if (errMsg.length() > 0) {
            System.out.println("Final Error Message:\n\r" + errMsg);
            //Notify user that errors need to be fixed first
            
            //Explicitly set canStart to false to ensure we do not proceed any further before the errors are fixed
            canStart = false;
        } else {
            //No errors encountered, the process can start
            System.out.println("No Errors Detected");
            canStart = true;
            //Start here with debugging
            populateLayersArray();
            
            
            
            //Generate the resultant layer using the supplied input layers
            //String resultLayer = runAnalysis(arrLayers);
        }
        
    }
    
    private void populateLayersArray() {
        arrLayers[0][0] = lyrName1.getText();
        arrLayers[1][0] = lyrName2.getText();
        arrLayers[2][0] = lyrName3.getText();
        arrLayers[3][0] = lyrName4.getText();
        arrLayers[5][0] = lyrName5.getText();
        arrLayers[0][1] = lyrFileName1.getText();
        arrLayers[1][1] = lyrFileName2.getText();
        arrLayers[2][1] = lyrFileName3.getText();
        arrLayers[3][1] = lyrFileName4.getText();
        arrLayers[4][1] = lyrFileName5.getText();
        //Check contents of the array
        for (int i = 0; i < arrLayers.length; i++) {
            for (int j = 0; j < arrLayers[i].length; j++) {
                System.out.print(arrLayers[i][j] + " ");
            }
            System.out.print("\n\r");
          }
    }
    
    @FXML
    /*
     * Method to run the spatial analysis routines against the input layers
     * @param Array with user-friendly names and filenames of input layers
     * @return String with the name of the output layer    
    */
     protected String runAnalysis(String[][] arrLayers) {
        String resultLayer = "";
        
        
        return resultLayer;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

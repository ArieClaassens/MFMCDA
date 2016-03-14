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
    //Variables
    public String[][] arrLayers = new String[5][3];
    //Set the initial directory to browse for layer files. Write to config and update to last used dir. Save settings on exit.
    public File startLocFile = new File("D:\\Projects\\Mondi\\4mHansie\\Mondi Data and Documents\\");
    
    @FXML // fx:id="txtComments"
    private TextArea txtComments; // Value injected by FXMLLoader

    @FXML // fx:id="lblLayerFileNames"
    private Label lblLayerFileNames; // Value injected by FXMLLoader

    @FXML // fx:id="lblLayerNames"
    private Label lblLayerNames; // Value injected by FXMLLoader

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML // fx:id="lyrName2"
    private TextField lyrName2; // Value injected by FXMLLoader

    @FXML // fx:id="lyrName3"
    private TextField lyrName3; // Value injected by FXMLLoader

    @FXML // fx:id="lyrName1"
    private TextField lyrName1; // Value injected by FXMLLoader

    @FXML // fx:id="lyrName4"
    private TextField lyrName4; // Value injected by FXMLLoader

    @FXML // fx:id="btnSelectFile5"
    private Button btnSelectFile5; // Value injected by FXMLLoader

    @FXML // fx:id="btnSelectFile4"
    private Button btnSelectFile4; // Value injected by FXMLLoader

    @FXML // fx:id="lyrName5"
    private TextField lyrName5; // Value injected by FXMLLoader

    @FXML // fx:id="slider5"
    private Slider slider5; // Value injected by FXMLLoader

    @FXML // fx:id="slider3"
    private Slider slider3; // Value injected by FXMLLoader

    @FXML // fx:id="slider4"
    private Slider slider4; // Value injected by FXMLLoader

    @FXML // fx:id="slider1"
    private Slider slider1; // Value injected by FXMLLoader

    @FXML // fx:id="slider2"
    private Slider slider2; // Value injected by FXMLLoader

    @FXML // fx:id="lyrFileName3"
    private TextField lyrFileName3; // Value injected by FXMLLoader

    @FXML // fx:id="lyrFileName2"
    private TextField lyrFileName2; // Value injected by FXMLLoader

    @FXML // fx:id="lyrFileName1"
    private TextField lyrFileName1; // Value injected by FXMLLoader

    @FXML // fx:id="btnSelectFile3"
    private Button btnSelectFile3; // Value injected by FXMLLoader

    @FXML // fx:id="btnSelectFile2"
    private Button btnSelectFile2; // Value injected by FXMLLoader

    @FXML // fx:id="btnSelectFile1"
    private Button btnSelectFile1; // Value injected by FXMLLoader

    @FXML // fx:id="lyrFileName5"
    private TextField lyrFileName5; // Value injected by FXMLLoader

    @FXML // fx:id="lyrFileName4"
    private TextField lyrFileName4; // Value injected by FXMLLoader

    @FXML // fx:id="lblLayerWeights"
    private Label lblLayerWeights; // Value injected by FXMLLoader

    @FXML // fx:id="btnStartProcess"
    private Button btnStartProcess; // Value injected by FXMLLoader

    @FXML // fx:id="lblLayerNames1"
    private Label lblLayerNames1; // Value injected by FXMLLoader
    
    @FXML 
    protected File locateFile() {
        FileChooser chooser = new FileChooser();    
        chooser.setInitialDirectory(startLocFile);
        chooser.setTitle("Select Layer File");
        //ToDo Add support for more file formats than just shape files
        chooser.getExtensionFilters().addAll(
                            new ExtensionFilter("Shape Files", "*.shp"),
                            new ExtensionFilter("DBF Files", "*.dbf"));

        File file = chooser.showOpenDialog(new Stage());
        if (file != null) {
            return file;
        } else {
            System.out.println("No file selected");
            //BS to get it to catch the error if you cancel on file selection
            //TODO - catch error when file selection is cancelled by user
            return new File(startLocFile+"Roads.shp");
        }
    }
       
    @FXML
    private void handleSelectFileAction1(ActionEvent event) {
        //TODO Move to a single function that can handle all the buttons. Will need to accept a layer ID parameter        
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
        slider1.setValue(1);
        slider2.setValue(1);
        slider3.setValue(1);
        slider4.setValue(1);
        slider5.setValue(1);
        slider1.setStyle("-fx-background-color: transparent");
        slider2.setStyle("-fx-background-color: transparent");
        slider3.setStyle("-fx-background-color: transparent");
        slider4.setStyle("-fx-background-color: transparent");
        slider5.setStyle("-fx-background-color: transparent");
        txtComments.setText("");
    }
      
    @FXML
    private void handleAboutMenuAction(ActionEvent event) {
        System.out.println("You clicked the Help -> About menu item");
        String currentWorkingDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentWorkingDir);
    }
    
    @FXML
    private void handleStartProcess(ActionEvent event) {
        String errMsg = "";
        boolean canStart = false;
        
        System.out.println("You clicked the 'Start the process' button!");
        //Start testing for logical errors before initiating the MCDA process
        //Check if layers have been assigned a user-friendly name
        if (("".equals(lyrName1.getText())) || ("Layer 1 Name".equals(lyrName1.getText()))) {
            errMsg += "Layer 1 does not have a NAME, please give it a name\n";
            lyrName1.setStyle("-fx-text-fill: red;");
          } else {
            lyrName1.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrName2.getText())) || ("Layer 2 Name".equals(lyrName2.getText()))) {
            errMsg += "Layer 2 does not have a NAME, please give it a name\n";
            lyrName2.setStyle("-fx-text-fill: red;");
          } else {
            lyrName2.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrName3.getText())) || ("Layer 3 Name".equals(lyrName3.getText()))) {
            errMsg += "Layer 3 does not have a NAME, please give it a name\n";
            lyrName3.setStyle("-fx-text-fill: red;");
          } else {
            lyrName3.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrName4.getText())) || ("Layer 4 Name".equals(lyrName4.getText()))) {
            errMsg += "Layer 4 does not have a NAME, please give it a name\n";
            lyrName4.setStyle("-fx-text-fill: red;");
          } else {
            lyrName4.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrName5.getText())) || ("Layer 5 Name".equals(lyrName5.getText()))) {
            errMsg += "Layer 5 does not have a NAME, please give it a name\n";
            lyrName5.setStyle("-fx-text-fill: red;");
          } else {
            lyrName5.setStyle("-fx-text-fill: black;");
        }
        
        //TODO Check if the layer names are unique
        
        
        
        //Check if layer filenames have been captured, i.e. if all layers have been assigned
        if (("".equals(lyrFileName1.getText())) || ("Layer 1 Filename".equals(lyrFileName1.getText()))) {
            errMsg += "Please select a file for Layer 1\n";
            lyrFileName1.setStyle("-fx-text-fill: red;");
          } else {
            lyrFileName1.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrFileName2.getText())) || ("Layer 2 Filename".equals(lyrFileName2.getText()))) {
            errMsg += "Please select a file for Layer 2\n";
            lyrFileName2.setStyle("-fx-text-fill: red;");
          } else {
            lyrFileName2.setStyle("-fx-text-fill: black;");
        }

        if (("".equals(lyrFileName3.getText())) || ("Layer 3 Filename".equals(lyrFileName3.getText()))) {
            errMsg += "Please select a file for Layer 3\n";
            lyrFileName3.setStyle("-fx-text-fill: red;");
          } else {
            lyrFileName3.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrFileName4.getText())) || ("Layer 4 Filename".equals(lyrFileName4.getText()))) {
            errMsg += "Please select a file for Layer 4\n";
            lyrFileName4.setStyle("-fx-text-fill: red;");
          } else {
            lyrFileName4.setStyle("-fx-text-fill: black;");
        }
        
        if (("".equals(lyrFileName5.getText())) || ("Layer 5 Filename".equals(lyrFileName5.getText()))) {
            errMsg += "Please select a file for Layer 5\n";
            lyrFileName5.setStyle("-fx-text-fill: red;");
          } else {
            lyrFileName5.setStyle("-fx-text-fill: black;");
        }
        
        //Check if all the assigned layers have a weight assigned
        if (slider1.getValue() == 0) {
            errMsg += "Please assign a relative weight for Layer 1\n";
            slider1.setStyle("-fx-background-color: red;");
        } else {
            slider1.setStyle("-fx-background-color: transparent");
        }
        
        if (slider2.getValue() == 0) {
            errMsg += "Please assign a relative weight for Layer 2\n";
            slider2.setStyle("-fx-background-color: red;");
        } else {
            slider2.setStyle("-fx-background-color: transparent");
        }
        
        if (slider3.getValue() == 0) {
            errMsg += "Please assign a relative weight for Layer 3\n";
            slider3.setStyle("-fx-background-color: red;");
        } else {
            slider3.setStyle("-fx-background-color: transparent");
        }
        
        if (slider4.getValue() == 0) {
            errMsg += "Please assign a relative weight for Layer 4\n";
            slider4.setStyle("-fx-background-color: red;");
        } else {
            slider4.setStyle("-fx-background-color: transparent");
        }
        
        if (slider5.getValue() == 0) {
            errMsg += "Please assign a relative weight for Layer 5\n";
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
            //TODO Display error message to user
            MessageBox.show(errMsg, "Errors found");
            
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
    
    @FXML
    public String[][] populateLayersArray() {
        /*
        System.out.println("lyrName1.getText() -->"+lyrName1.getText()+"\n\r");
        System.out.println("lyrName2.getText() -->"+lyrName2.getText()+"\n\r");
        System.out.println("lyrName3.getText() -->"+lyrName3.getText()+"\n\r");
        System.out.println("lyrName4.getText() -->"+lyrName4.getText()+"\n\r");
        System.out.println("lyrName5.getText() -->"+lyrName5.getText()+"\n\r");
        */
        
        arrLayers[0][0] = lyrName1.getText();
        arrLayers[1][0] = lyrName2.getText();
        arrLayers[2][0] = lyrName3.getText();
        arrLayers[3][0] = lyrName4.getText();
        arrLayers[4][0] = lyrName5.getText();
        
        /*
        System.out.println("lyrFileName1.getText() -->"+lyrFileName1.getText()+"\n\r");
        System.out.println("lyrFileName2.getText() -->"+lyrFileName2.getText()+"\n\r");
        System.out.println("lyrFileName3.getText() -->"+lyrFileName3.getText()+"\n\r");
        System.out.println("lyrFileName4.getText() -->"+lyrFileName4.getText()+"\n\r");
        System.out.println("lyrFileName5.getText() -->"+lyrFileName5.getText()+"\n\r");
        */
        
        arrLayers[0][1] = lyrFileName1.getText();
        arrLayers[1][1] = lyrFileName2.getText();
        arrLayers[2][1] = lyrFileName3.getText();
        arrLayers[3][1] = lyrFileName4.getText();
        arrLayers[4][1] = lyrFileName5.getText();
        
        
        //Get the slider value
        /*
        System.out.println("slider1.getValue() -->"+Double.toString(slider1.getValue())+"\n\r");
        System.out.println("slider2.getValue() -->"+Double.toString(slider2.getValue())+"\n\r");
        System.out.println("slider3.getValue() -->"+Double.toString(slider3.getValue())+"\n\r");
        System.out.println("slider4.getValue() -->"+Double.toString(slider4.getValue())+"\n\r");
        System.out.println("slider5.getValue() -->"+Double.toString(slider5.getValue())+"\n\r");
        */
        
        //Cast layer weight (a double) to string to store in the array
        arrLayers[0][2] = Double.toString(slider1.getValue());
        arrLayers[1][2] = Double.toString(slider2.getValue());
        arrLayers[2][2] = Double.toString(slider3.getValue());
        arrLayers[3][2] = Double.toString(slider4.getValue());
        arrLayers[4][2] = Double.toString(slider5.getValue());
        
        //Check contents of the array
        for (int i = 0; i < arrLayers.length; i++) {
            for (int j = 0; j < arrLayers[i].length; j++) {
                System.out.println("arrLayers["+i+"]["+j+"] is "+arrLayers[i][j]);
            }
            System.out.print("\n\r");
          }
        
        return arrLayers;
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
        assert txtComments != null : "fx:id=\"txtComments\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lblLayerFileNames != null : "fx:id=\"lblLayerFileNames\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lblLayerNames != null : "fx:id=\"lblLayerNames\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lyrName2 != null : "fx:id=\"lyrName2\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lyrName3 != null : "fx:id=\"lyrName3\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lyrName1 != null : "fx:id=\"lyrName1\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lyrName4 != null : "fx:id=\"lyrName4\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnSelectFile5 != null : "fx:id=\"btnSelectFile5\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnSelectFile4 != null : "fx:id=\"btnSelectFile4\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lyrName5 != null : "fx:id=\"lyrName5\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert slider5 != null : "fx:id=\"slider5\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert slider3 != null : "fx:id=\"slider3\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert slider4 != null : "fx:id=\"slider4\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert slider1 != null : "fx:id=\"slider1\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert slider2 != null : "fx:id=\"slider2\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lyrFileName3 != null : "fx:id=\"lyrFileName3\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lyrFileName2 != null : "fx:id=\"lyrFileName2\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lyrFileName1 != null : "fx:id=\"lyrFileName1\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnSelectFile3 != null : "fx:id=\"btnSelectFile3\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnSelectFile2 != null : "fx:id=\"btnSelectFile2\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnSelectFile1 != null : "fx:id=\"btnSelectFile1\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lyrFileName5 != null : "fx:id=\"lyrFileName5\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lyrFileName4 != null : "fx:id=\"lyrFileName4\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lblLayerWeights != null : "fx:id=\"lblLayerWeights\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnStartProcess != null : "fx:id=\"btnStartProcess\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lblLayerNames1 != null : "fx:id=\"lblLayerNames1\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
    }    
    
}

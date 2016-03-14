/*
 * Copyright 2016 Arie Claassens <gy13awc@leeds.ac.uk>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mfmcda;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

/**
 *
 * @author Arie Claassens <gy13awc@leeds.ac.uk>
 */

/* Method to display Messages in a modal window to the user
 * Sourced from JavaFX for Dummies; Listing 4-2: The MessageBox Class, p.79
 * Accepts a message and title string
 * @param message   The body of the message to display to the user
 * @param title     The title of the message to display to the user
*/
public class MessageBox {
    public static void show(String message, String title) 
    {
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle(title);
    stage.setMinWidth(300);
    Label lbl = new Label();
    lbl.setText(message);
    Button btnOK = new Button();
    btnOK.setText("OK");
    btnOK.setOnAction(e -> stage.close());
    VBox pane = new VBox(20);
    pane.getChildren().addAll(lbl, btnOK);
    pane.setAlignment(Pos.CENTER);
    Scene scene = new Scene(pane);
    stage.setScene(scene);
    stage.showAndWait();
}
}

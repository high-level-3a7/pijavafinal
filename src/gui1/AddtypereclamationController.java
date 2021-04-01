/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Typereclamation;
import service.ServiceTypereclamation;

/**
 * FXML Controller class
 *
 * @author karbo
 */
public class AddtypereclamationController implements Initializable {

    @FXML
    private TextField typeFid;
    ServiceTypereclamation str = new ServiceTypereclamation();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void adminorclient(MouseEvent event) {
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void saveact(MouseEvent event) {
        String ty = typeFid.getText();
        int x = str.veriftypeexist(ty); 
        if (ty.isEmpty()  ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Remplir tous les champs !");
            alert.showAndWait();
        }else if(x==1){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("ce type existe déja !");
            alert.showAndWait();
        }
        else{
        Typereclamation tr = new Typereclamation();
        tr.setType(typeFid.getText());
        str.ajouter(tr);
        }
    }

    @FXML
    private void clear(MouseEvent event) {
        typeFid.setText(null);
    }

     @FXML
    private void gogestmat(MouseEvent event) throws IOException {
         Parent parentacc2 = FXMLLoader.load(getClass().getResource("../gui/GestionMateriel.fxml"));
            Scene sceneacc2 = new Scene(parentacc2);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(sceneacc2);
            stage.show();
    }

    @FXML
    private void retour(MouseEvent event) throws IOException {
            Parent parentacc2 = FXMLLoader.load(getClass().getResource("/gui1/typereclamation.fxml"));
            Scene sceneacc2 = new Scene(parentacc2);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(sceneacc2);
            stage.show();
    }
    
}

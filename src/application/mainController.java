package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mainController implements Initializable {
	public String c2;
private String s;
public List<String> genPos(){
	List<String> posArr;
	posArr = new ArrayList<String>();
	posArr.add(new String("QB"));
	posArr.add(new String("RB"));
	posArr.add(new String("WR"));
	posArr.add(new String("TE"));
	return posArr;
}


public void pressButton(ActionEvent event) throws Exception {               
		

try{

	String s = comboBox.getValue().toString(); 
	((Node)event.getSource()).getScene().getWindow().hide();
	Stage stage = new Stage();
     FXMLLoader loader = new FXMLLoader();
     Pane root2 = loader.load(getClass().getResource("main2.fxml").openStream());

     Scene scene = new Scene(root2,300,300);
	main2Controller main2Controller = (main2Controller) loader.getController();
    main2Controller.qb(s);
    loader.setController(main2Controller);
	stage.setScene(scene);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	stage.show();

} catch(Exception e) {
e.printStackTrace();
}
}

 @FXML
 
public ComboBox<String> comboBox;
ObservableList<String> list=FXCollections.observableArrayList(genPos());
@Override
public void initialize(URL location, ResourceBundle resources) {
	
	comboBox.setItems(list);

}

}


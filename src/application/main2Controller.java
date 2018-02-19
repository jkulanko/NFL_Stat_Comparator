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
import javafx.scene.control.ComboBoxBase;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
 
public class main2Controller extends mainController implements Initializable {

	public List<String> qb(String c){
	    String csvFile = "C:/passers.csv";
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	    List<String> qbArr;
	    qbArr = new ArrayList<String>();

	    try {
	    	
	        br = new BufferedReader(new FileReader(csvFile));
	        if(c.equals("QB")){
	        	while ((line = br.readLine()) != null) {
	        	
	            // use comma as separator
	            String[] pos = line.split(cvsSplitBy);
	            int yds = 0;
	            
	            if(line.contains("QB") && !pos[35].contains("NULL"))
	             yds = Integer.parseInt(pos[35]);
	            if(line.contains("QB") && yds > 750){
	            qbArr.add(new String(pos[0]));
	            
	            }
	            
	        }
}
	     
	        else if (c.equals("RB")){
	        	while ((line = br.readLine()) != null) {
		        	
		            // use comma as separator
		            String[] pos = line.split(cvsSplitBy);
		            if (pos.length == 60){
		            int yds = 0;
		            
		            if(line.contains("RB") && !pos[59].contains("NULL"))
		             yds = Integer.parseInt(pos[59]);
		            if(line.contains("RB") && yds > 350){
		            qbArr.add(new String(pos[0]));
		            
		            }}
		            
		        }}
	        else if (c.equals("WR")){
	        	while ((line = br.readLine()) != null) {
		        	
		            // use comma as separator
		            String[] pos = line.split(cvsSplitBy);
		            
		            int receptions = 0;
		            if(line.contains("WR") && !pos[48].contains("NULL"))
		            	receptions = Integer.parseInt(pos[48]);
		            if(line.contains("WR") && receptions > 40){
		            qbArr.add(new String(pos[0]));
		            
		            }
		            
		        }}
	        else if (c.equals("TE")){
	        	while ((line = br.readLine()) != null) {
		        	
		            // use comma as separator
		            String[] pos = line.split(cvsSplitBy);
		            
		            int receptions = 0;
		            if(line.contains("TE") && !pos[48].contains("NULL"))
		            	receptions = Integer.parseInt(pos[48]);
		            if(line.contains("TE") && receptions > 25){
		            qbArr.add(new String(pos[0]));
		            
		            }
		            
		        }}
	        }
catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    
	    	
	    list=FXCollections.observableArrayList(qbArr);
	    p1Box.setItems(list);
	p2Box.setItems(list);
	 return qbArr;
	}
	public void back(ActionEvent event){
			try {
				((Node)event.getSource()).getScene().getWindow().hide();
				Stage stage = new Stage();
			     FXMLLoader loader = new FXMLLoader();
			     
			     Pane root2 = loader.load(getClass().getResource("/application/main.fxml").openStream());
			     Scene scene = new Scene(root2,600,300);
			     scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
	    }
	public void pressButton2(ActionEvent event) throws Exception {               
		

		try{
			String p1 = p1Box.getValue().toString();
			String p2 = p2Box.getValue().toString();
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage stage = new Stage();
		     FXMLLoader loader = new FXMLLoader();
		     Pane root2 = loader.load(getClass().getResource("main3.fxml").openStream());

		     Scene scene = new Scene(root2,600,300);
		     scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			main3Controller main3Controller = (main3Controller) loader.getController();
		    main3Controller.statDisplay(p1,p2);
		    loader.setController(main3Controller);
			stage.setScene(scene);
			
			stage.show();

		} catch(Exception e) {
		e.printStackTrace();
		}
		} 
@FXML
public ComboBox<String> p1Box;
public ComboBox<String> p2Box;
ObservableList<String> list;
@Override
public void initialize(URL location, ResourceBundle resources) {


}

}



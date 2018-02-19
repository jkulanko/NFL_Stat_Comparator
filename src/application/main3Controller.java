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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class main3Controller implements Initializable {
	@FXML
	public Label p1Label,  p2Label, // labels all the columns and rows
	col1,col2,col3,col4, 
	p1Col1, p1Col2, p1Col3, p1Col4, p2Col1, p2Col2, p2Col3, p2Col4;
	public GridPane p1Pane;
	public ImageView oneOne, oneTwo,oneThree, oneFour; // For the up and down arrow in the program
	public ImageView helm1, helm2; //for the helmets
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
	public void statDisplay(String p1, String p2){
		String csvFile = "C:/Users/betsy/Desktop/passers.csv";
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	     int p11Stat = 0, p12Stat = 0, p13Stat = 0 ,p14Stat = 0, //for the arrow comparator
	     p21Stat = 0, p22Stat = 0, p23Stat = 0, p24Stat = 0;
	    Image imgUp = new Image("UpArrow.jpg");
	    Image imgDown = new Image("DownArrow.jpg");

	    try {
	    	
	        br = new BufferedReader(new FileReader(csvFile));
	        
	        	while ((line = br.readLine()) != null) {
	        	
	            // use comma as separator
	            String[] pos = line.split(cvsSplitBy);

	            if(p1.equals(pos[0]) && line.contains("QB")){	            		
	            		p1Label.setText(pos[0]);
	            		p1Col1.setText(pos[35].toString());
	            		p1Col2.setText(pos[32].toString());
	            		p1Col3.setText(pos[31].toString());
	            		p1Col4.setText(pos[30]);
	            		p11Stat=Integer.parseInt(pos[35]);
	            	    p12Stat=Integer.parseInt(pos[32]);
	            	    p13Stat=Integer.parseInt(pos[31]);
	            	    p14Stat=Integer.parseInt(pos[30]);
	            		col1.setText("Passing Yards");
	            		col2.setText("Touchdowns");
	            		col3.setText("Interceptions");
	            		col4.setText("Completions");
	            		setImageH1(pos[3]);
	        }else if(p1.equals(pos[0]) && line.contains("RB")){
        		p1Label.setText(pos[0]);
        		p1Col1.setText(pos[59].toString());
        		p1Col2.setText(pos[56].toString());
        		p1Col3.setText(pos[12].toString());
        		p1Col4.setText(pos[53]);           		
        		col1.setText("Rushing Yards");
        		col2.setText("Touchdowns");
        		col3.setText("Fumbles");
        		col4.setText("Rushing Attempts");
        		p11Stat=Integer.parseInt(pos[59]);
        	    p12Stat=Integer.parseInt(pos[56]);
        	    p13Stat=Integer.parseInt(pos[12]);
        	    setImageH1(pos[3]);
	        }else if(p1.equals(pos[0]) && line.contains("WR")){
        		p1Label.setText(pos[0]);
        		p1Col1.setText(pos[52].toString());
        		p1Col2.setText(pos[49].toString());
        		p1Col3.setText(pos[12].toString());
        		p1Col4.setText(pos[48]);           		
        		col1.setText("Rec. Yards");
        		col2.setText("Touchdowns");
        		col3.setText("Fumbles");
        		col4.setText("Receptions");
        		p11Stat=Integer.parseInt(pos[52]);
        	    p12Stat=Integer.parseInt(pos[49]);
        	    p13Stat=Integer.parseInt(pos[12]);
        	    p14Stat=Integer.parseInt(pos[48]);
        	    setImageH1(pos[3]);
	        }
	        else if(p1.equals(pos[0]) && line.contains("TE")){
        		p1Label.setText(pos[0]);
        		p1Col1.setText(pos[52].toString());
        		p1Col2.setText(pos[49].toString());
        		p1Col3.setText(pos[12].toString());
        		p1Col4.setText(pos[48]);           		
        		col1.setText("Rec. Yards");
        		col2.setText("Touchdowns");
        		col3.setText("Fumbles");
        		col4.setText("Receptions");
        		p11Stat=Integer.parseInt(pos[52]);
        	    p12Stat=Integer.parseInt(pos[49]);
        	    p13Stat=Integer.parseInt(pos[12]);
        	    p14Stat=Integer.parseInt(pos[48]);
        	    setImageH1(pos[3]);
	        }
	            if(p2.equals(pos[0]) && line.contains("QB")){	            		
            		p2Label.setText(pos[0]);
            		p2Col1.setText(pos[35].toString());
            		p2Col2.setText(pos[32].toString());
            		p2Col3.setText(pos[31].toString());
            		p2Col4.setText(pos[30].toString());
            		p21Stat=Integer.parseInt(pos[35]);
            	    p22Stat=Integer.parseInt(pos[32]);
            	    p23Stat=Integer.parseInt(pos[31]);
            	    p24Stat=Integer.parseInt(pos[30]);
            	    setImageH2(pos[3]);
        }
	            else if(p2.equals(pos[0]) && line.contains("RB")){
	        		p2Label.setText(pos[0]);
	        		p2Col1.setText(pos[59].toString());
	        		p2Col2.setText(pos[56].toString());
	        		p2Col3.setText(pos[12].toString());
	        		p2Col4.setText(pos[53]);
	        		p21Stat=Integer.parseInt(pos[59]);
            	    p22Stat=Integer.parseInt(pos[56]);
            	    p23Stat=Integer.parseInt(pos[12]);
            	    setImageH2(pos[3]);
	            }else if(p2.equals(pos[0]) && line.contains("WR")){
	        		p2Label.setText(pos[0]);
	        		p2Col1.setText(pos[52].toString());
	        		p2Col2.setText(pos[49].toString());
	        		p2Col3.setText(pos[12].toString());
	        		p2Col4.setText(pos[48]); 
	        		p21Stat=Integer.parseInt(pos[52]);
            	    p22Stat=Integer.parseInt(pos[49]);
            	    p23Stat=Integer.parseInt(pos[12]);
            	    p24Stat=Integer.parseInt(pos[48]);
            	    setImageH2(pos[3]);
	            }else if(p2.equals(pos[0]) && line.contains("TE")){
	        		p2Label.setText(pos[0]);
	        		p2Col1.setText(pos[52].toString());
	        		p2Col2.setText(pos[49].toString());
	        		p2Col3.setText(pos[12].toString());
	        		p2Col4.setText(pos[48]); 
	        		p21Stat=Integer.parseInt(pos[52]);
            	    p22Stat=Integer.parseInt(pos[49]);
            	    p23Stat=Integer.parseInt(pos[12]);
            	    p24Stat=Integer.parseInt(pos[48]);
            	    setImageH2(pos[3]);
	            }
	            
	            
}
	        	if(p11Stat < p21Stat) //down arrows and up arrows
	            	oneOne.setImage(imgDown);
	            else
	            	oneOne.setImage(imgUp);
	        	if(p12Stat < p22Stat)
	            	oneTwo.setImage(imgDown);
	            else
	            	oneTwo.setImage(imgUp);
	        	if(p13Stat > p23Stat)
	            	oneThree.setImage(imgDown);
	            else
	            	oneThree.setImage(imgUp);
	        	
	    		if(p14Stat < p24Stat)
	    			oneFour.setImage(imgDown);
	    		else
	    			oneFour.setImage(imgUp);
	    			
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
	}
	public void setImageH1(String pos){
		Image ATL = new Image("ATL.jpg");
	    Image AZ = new Image("AZ.jpg");
	    Image BUF = new Image("BUF.jpg");
	    Image BAL = new Image("BAL.jpg");
	    Image CAR = new Image("CAR.jpg");
	    Image CHI = new Image("CHI.jpg");
	    Image CIN = new Image("CIN.jpg");
	    Image CLE = new Image("CLE.jpg");
	    Image DAL = new Image("DAL.jpg");
	    Image DEN = new Image("DEN.jpg");
	    Image DET = new Image("DET.jpg");
	    Image GB = new Image("GB.jpg");
	    Image HOU = new Image("HOU.jpg");
	    Image IND = new Image("IND.jpg");
	    Image JAX = new Image("JAX.jpg");
	    Image KC = new Image("KC.jpg");
	    Image MIA = new Image("MIA.jpg");
	    Image MIN = new Image("MIN.jpg");
	    Image NE = new Image("NE.jpg");
	    Image NO = new Image("NO.jpg");
	    Image NYG = new Image("NYG.jpg");
	    Image NYJ = new Image("NYJ.jpg");
	    Image OAK = new Image("OAK.jpg");
	    Image PHI = new Image("PHI.jpg");
	    Image PIT = new Image("PIT.jpg");
	    Image SD = new Image("SD.jpg");
	    Image SEA = new Image("SEA.jpg");
	    Image SF = new Image("SF.jpg");
	    Image TB = new Image("TB.jpg");
	    Image TEN = new Image("TEN.jpg");
	    Image STL = new Image("STL.jpg");
	    Image WAS = new Image("WAS.jpg");	            
		switch(pos){
	            case "ATL": helm1.setImage(ATL);break;
	            case "ARI": helm1.setImage(AZ);break;
	            case "BAL": helm1.setImage(BAL);break;
	            case "BUF": helm1.setImage(BUF);break;
	            case "CAR": helm1.setImage(CAR);break;
	            case "CHI": helm1.setImage(CHI);break;
	            case "CIN": helm1.setImage(CIN);break;
	            case "CLE": helm1.setImage(CLE);break;
	            case "DAL": helm1.setImage(DAL);break;
	            case "DEN": helm1.setImage(DEN);break;
	            case "DET": helm1.setImage(DET);break;
	            case "GB": helm1.setImage(GB);break;
	            case "HOU": helm1.setImage(HOU);break;
	            case "IND": helm1.setImage(IND);break;
	            case "JAX":
	            case "JAC": helm1.setImage(JAX);break;
	            case "KC": helm1.setImage(KC);break;
	            case "MIA": helm1.setImage(MIA);break;
	            case "MIN": helm1.setImage(MIN);break;
	            case "NE": helm1.setImage(NE);break;
	            case "NO": helm1.setImage(NO);break;
	            case "NYG": helm1.setImage(NYG);break;
	            case "NYJ": helm1.setImage(NYJ);break;
	            case "OAK": helm1.setImage(OAK);break;
	            case "PHI": helm1.setImage(PHI);break;
	            case "PIT": helm1.setImage(PIT);break;
	            case "SD": helm1.setImage(SD);break;
	            case "SEA": helm1.setImage(SEA);break;
	            case "SF": helm1.setImage(SF);break;
	            case "LA": helm1.setImage(STL);break;
	            case "TB": helm1.setImage(TB);break;
	            case "TEN": helm1.setImage(TEN);break;
	            case "WAS": helm1.setImage(WAS);break;
	            
	            }
	}
	public void setImageH2(String pos){
		Image ATL = new Image("ATL.jpg");
	    Image AZ = new Image("AZ.jpg");
	    Image BUF = new Image("BUF.jpg");
	    Image BAL = new Image("BAL.jpg");
	    Image CAR = new Image("CAR.jpg");
	    Image CHI = new Image("CHI.jpg");
	    Image CIN = new Image("CIN.jpg");
	    Image CLE = new Image("CLE.jpg");
	    Image DAL = new Image("DAL.jpg");
	    Image DEN = new Image("DEN.jpg");
	    Image DET = new Image("DET.jpg");
	    Image GB = new Image("GB.jpg");
	    Image HOU = new Image("HOU.jpg");
	    Image IND = new Image("IND.jpg");
	    Image JAX = new Image("JAX.jpg");
	    Image KC = new Image("KC.jpg");
	    Image MIA = new Image("MIA.jpg");
	    Image MIN = new Image("MIN.jpg");
	    Image NE = new Image("NE.jpg");
	    Image NO = new Image("NO.jpg");
	    Image NYG = new Image("NYG.jpg");
	    Image NYJ = new Image("NYJ.jpg");
	    Image OAK = new Image("OAK.jpg");
	    Image PHI = new Image("PHI.jpg");
	    Image PIT = new Image("PIT.jpg");
	    Image SD = new Image("SD.jpg");
	    Image SEA = new Image("SEA.jpg");
	    Image SF = new Image("SF.jpg");
	    Image TB = new Image("TB.jpg");
	    Image TEN = new Image("TEN.jpg");
	    Image STL = new Image("STL.jpg");
	    Image WAS = new Image("WAS.jpg");	            
		switch(pos){
	            case "ATL": helm2.setImage(ATL);break;
	            case "ARI": helm2.setImage(AZ);break;
	            case "BAL": helm2.setImage(BAL);break;
	            case "BUF": helm2.setImage(BUF);break;
	            case "CAR": helm2.setImage(CAR);break;
	            case "CHI": helm2.setImage(CHI);break;
	            case "CIN": helm2.setImage(CIN);break;
	            case "CLE": helm2.setImage(CLE);break;
	            case "DAL": helm2.setImage(DAL);break;
	            case "DEN": helm2.setImage(DEN);break;
	            case "DET": helm2.setImage(DET);break;
	            case "GB": helm2.setImage(GB);break;
	            case "HOU": helm2.setImage(HOU);break;
	            case "IND": helm2.setImage(IND);break;
	            case "JAX":
	            case "JAC": helm2.setImage(JAX);break;
	            case "KC": helm2.setImage(KC);break;
	            case "MIA": helm2.setImage(MIA);break;
	            case "MIN": helm2.setImage(MIN);break;
	            case "NE": helm2.setImage(NE);break;
	            case "NO": helm2.setImage(NO);break;
	            case "NYG": helm2.setImage(NYG);break;
	            case "NYJ": helm2.setImage(NYJ);break;
	            case "OAK": helm2.setImage(OAK);break;
	            case "PHI": helm2.setImage(PHI);break;
	            case "PIT": helm2.setImage(PIT);break;
	            case "SD": helm2.setImage(SD);break;
	            case "SEA": helm2.setImage(SEA);break;
	            case "SF": helm2.setImage(SF);break;
	            case "LA": helm2.setImage(STL);break;
	            case "TB": helm2.setImage(TB);break;
	            case "TEN": helm2.setImage(TEN);break;
	            case "WAS": helm2.setImage(WAS);break;
	            }
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}

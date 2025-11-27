package gui.guiGetraenk;


import java.io.IOException;

import business.Getraenke;
import business.GetraenkModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class GetraenkControl implements Observer{

	GetraenkModel atModel;
	GetraenkView atView;
	
	public GetraenkControl(Stage st){
    	
    atModel = GetraenkModel.getInstance();
    	atView = new GetraenkView(this,atModel, st);
    	this.atModel.addObserver(this);
    }
	void nehmeGetraenkAuf() {
	    try {
	        atModel.setGetraenk(
	            new Getraenke(
	                this.atView.getTxtArtikelnummer().getText(),
	                Float.parseFloat(this.atView.getTxtEinkaufspreis().getText()),
	                Float.parseFloat(this.atView.getTxtVerkaufspreis().getText()),
	                this.atView.getTxtMitAlkohol().getText(),
	                this.atView.getTxtBehaeltnisse().getText().split(";")));
	                atView.zeigeInformationsfensterAn("Das Getraenk wurde aufgenommen!");
	           
	    
	        
	    } catch (Exception exc) {
	        atView.zeigeFehlermeldungsfensterAn(exc.getMessage());
	    }
	}
	
	void leseAusDateiControl(String typ){
		try {
			if("csv".equals(typ)){
			this.atModel.leseAusDatei(typ);
			atView.zeigeInformationsfensterAn("Das Getraenk wurde gelesen!");
		}
			else if("txt".equals(typ)){
				this.atModel.leseAusDatei(typ);
				atView.zeigeInformationsfensterAn("Das Getraenk wurde gelesen!");
			}
			else{
	   			atView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}}
			catch(IOException exc){
				atView.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				atView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
			}
		
		
		
	}
	
	void schreibeGetraenkInCsvDatei() {
		try {
			atModel.schreibeGetraenkInCsvDatei();
			 atView.zeigeInformationsfensterAn("Das Getränk wurde gespeichert.");
		}	
		catch(IOException exc){
			atView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			atView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
	@Override
	public void update() {
		atView.zeigeGetraenkAn();
		
	}

}
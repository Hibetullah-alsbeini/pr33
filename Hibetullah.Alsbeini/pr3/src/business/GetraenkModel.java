package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import fileCreatorAlsbeini.ReaderCreatorAlsbeini;
import fileCreatorAlsbeini.ReaderCreatorCsvAlsbeini;
import fileCreatorAlsbeini.ReaderCreatorTxtAlsbeini;
import fileCreatorAlsbeini.ReaderProductAlsbeini;
import ownUtil.Observable;
import ownUtil.Observer;

public class GetraenkModel implements Observable{
    private Getraenke  Getraenk ;

    private Vector<Observer> observers = new Vector<Observer>();
    private static GetraenkModel getraenkModel;
    
    private GetraenkModel() {
    	
    }
    public static GetraenkModel getInstance() {
    	if (getraenkModel == null) {
    		getraenkModel = new GetraenkModel();
    	}
    	return getraenkModel;
    }

    public Getraenke getGetraenk() {
		return Getraenk;
	}
	public void setGetraenk (Getraenke  Getraenk ) {
        this.Getraenk  = Getraenk ;
      
    }
    public void leseAusDatei(String typ) throws IOException{
    	
    	ReaderProductAlsbeini product = null;
    	if(typ.equals("csv")){
    		ReaderCreatorAlsbeini creator= new ReaderCreatorCsvAlsbeini();
    		product= creator.factoryMethod();
    	}else {
    		ReaderCreatorAlsbeini creator= new ReaderCreatorTxtAlsbeini();
    		 product= creator.factoryMethod();
    	}
    	
    	

                  String[] zeile = product.leseAusDatei();
                  this.Getraenk  = new Getraenke (zeile[0], 
                          Float.parseFloat(zeile[1]), 
                          Float.parseFloat(zeile[2]), 
                      zeile[3], 
                      zeile[4].split("_"));
                  
                  
                  notifyObserver();
                      
        }
 
    public void schreibeGetraenkInCsvDatei() throws IOException {

            BufferedWriter aus = new BufferedWriter(new FileWriter("GetraenkAusgabe.csv", true));
            aus.write(Getraenk.gibGetraenkZurueck(';'));
            aus.close();
    }
	@Override
	public void addObserver(Observer obs) {
		this.observers.add(obs);
		
	}
	@Override
	public void removeObserver(Observer obs) {
		this.observers.remove(obs);
		
	}
	@Override
	public void notifyObserver() {
	for(int i =0; i<observers.size(); i++) {
		this.observers.elementAt(i).update();
	}
		
	}

}
package fileCreatorAlsbeini;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderProductTxtAlsbeini extends ReaderProductAlsbeini {

	
	BufferedReader ein; 
	public ReaderProductTxtAlsbeini () throws IOException{
		ein = new BufferedReader(new FileReader("D:\\Hibetullah.Alsbeini\\pr3\\src\\Getraenk.txt"));
	}
	@Override
	public String[] leseAusDatei() throws IOException {
	
		String [] ergbniszeile = new String[5];
		String zeile = ein.readLine();
		int i =0;
		while( i<ergbniszeile.length ) {
			ergbniszeile[i] = zeile; 
			zeile = ein.readLine();
			i++;
		}
		return ergbniszeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
		
	}

}

package fileCreatorAlsbeini;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderProductCsvAlsbeini extends ReaderProductAlsbeini {

	BufferedReader ein;
	public ReaderProductCsvAlsbeini() throws IOException{
		ein = new BufferedReader(new FileReader("D:\\Hibetullah.Alsbeini\\pr3\\src\\Getraenk(3).csv"));
	}
	@Override
	public String[] leseAusDatei() throws IOException {
		String zeile []= ein.readLine().split(";");
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
	}

}

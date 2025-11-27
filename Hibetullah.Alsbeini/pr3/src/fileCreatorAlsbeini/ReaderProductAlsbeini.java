package fileCreatorAlsbeini;

import java.io.IOException;

public abstract class ReaderProductAlsbeini {

	public abstract String[] leseAusDatei() throws IOException; 
	public abstract void schliesseDatei()throws IOException;
	
}

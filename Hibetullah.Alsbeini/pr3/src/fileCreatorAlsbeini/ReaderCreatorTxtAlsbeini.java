package fileCreatorAlsbeini;

import java.io.IOException;

public class ReaderCreatorTxtAlsbeini extends ReaderCreatorAlsbeini {

	@Override
	public ReaderProductAlsbeini factoryMethod() throws IOException {
	
		return new ReaderProductTxtAlsbeini();
	}

}

package fileCreatorAlsbeini;

import java.io.IOException;

public class ReaderCreatorCsvAlsbeini extends ReaderCreatorAlsbeini {

	@Override
	public ReaderProductAlsbeini factoryMethod() throws IOException {
		return new ReaderProductCsvAlsbeini();
	}
}

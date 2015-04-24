package articles;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;


public class Parser implements Closeable, Iterator<Article> {

	protected BufferedReader wikipediaReader;

	protected boolean hasReachedEnd = false;
	
	private final Random random;
	private final int rankingFactor;

	public Parser(File wikipedia) throws IOException {
		this.random = new Random();
		this.rankingFactor = 1000;
		wikipediaReader = new BufferedReader(new FileReader(wikipedia));
	}

	@Override
	public Article next() {
		try {
			String title = wikipediaReader.readLine();
			
			if (title == null) {
				throw new NoSuchElementException("Reached end of Wikipedia file");
			}
			
			StringBuilder content = new StringBuilder();
			String line;
			while ((line = wikipediaReader.readLine()) != null && line.length() > 0) {
				content.append(line).append(" ");
			}
			if (line == null) {
				hasReachedEnd = true;
			}
			
			double weight = random.nextDouble() * rankingFactor;
			return new Article(title, content.toString(), weight);
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/** TRUE if hasNext() will return a new page*/
	@Override
	public boolean hasNext() {
		return !hasReachedEnd;
	}

	/** Closes the reader*/
	@Override
	public void close() throws IOException {
		wikipediaReader.close();
	}

	/** Unsupported*/
	@Override
	public void remove() {
		throw new UnsupportedOperationException("Remove in Wikipedia parser");
	}
}

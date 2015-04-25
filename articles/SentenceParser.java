package articles;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SentenceParser implements Iterator<String> {

	private List<String> sentences;
	private int index = 0;
	
	protected boolean hasReachedEnd = false;
	
	public SentenceParser(Article article) {
		String content = article.getContent();
		sentences = Arrays.asList(content.split("./."));
	}

	@Override
	public boolean hasNext() {
		return !hasReachedEnd;
	}

	@Override
	public String next() {
		String toReturn = sentences.get(index);
		index++;
		if(index == sentences.size()) {
			hasReachedEnd = true;
		}
		
		return toReturn;
	}
}

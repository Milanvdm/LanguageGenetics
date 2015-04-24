package articles;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArticleExtractor {

	private String pathWiki = "C:\\Users\\Milan\\Desktop\\School\\CUHK\\AI\\Paper\\LanguageGenetics\\wikipedia_pos.txt";

	public List<Article> getArticles() throws IOException {

		List<Article> articles = new ArrayList<Article>();

		File file = new File(pathWiki);

		Parser parser = new Parser(file);

		while(parser.hasNext()) {
			Article article = parser.next();
			articles.add(article);
		}

		parser.close();

		return articles;
	}


}



package articles;

import java.io.File;
import java.io.IOException;

public class ArticleExtractor {

	private String pathWiki = "C:\\Users\\Milan\\Desktop\\School\\CUHK\\AI\\Paper\\LanguageGenetics\\wikipedia_test.txt";
	
	public ArticleExtractor() {
	}

	public void getArticles(ArticleDB articleDB) throws IOException {

		File file = new File(pathWiki);

		ArticleParser parser = new ArticleParser(file);

		while(parser.hasNext()) {
			Article article = parser.next();
			articleDB.addArticle(article.getWeight(), article);
		}

		parser.close();

	}

}



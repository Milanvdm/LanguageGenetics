package articles;

import java.io.File;
import java.io.IOException;

public class ArticleExtractor {

	private String pathWiki = "C:\\Users\\Milan\\Desktop\\School\\CUHK\\AI\\Paper\\LanguageGenetics\\wikipedia_pos.txt";
	private ArticleDB articleDB;
	
	public ArticleExtractor() throws ClassNotFoundException, IOException {
		articleDB = ArticleDB.getInstance();
	}

	public void getArticles() throws IOException {

		File file = new File(pathWiki);

		Parser parser = new Parser(file);

		while(parser.hasNext()) {
			Article article = parser.next();
			articleDB.addArticle(article.getWeight(), article);
		}

		parser.close();

	}

}



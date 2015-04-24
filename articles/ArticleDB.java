package articles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ArticleDB {

	private List<Article> articles;

	public ArticleDB() throws ClassNotFoundException, IOException {
		loadArticles();
		saveArticles();
	}
	
	public List<Article> getArticles() {
		return this.articles;
	}

	private void loadArticles() throws IOException, ClassNotFoundException {
		FileInputStream in;
		try {
			in = new FileInputStream("articles.out");
			
			ObjectInputStream ois = new ObjectInputStream(in);
			articles = (List<Article>) (ois.readObject());
			
			ois.close();
		} 
		catch (FileNotFoundException e) {
			ArticleExtractor articleExtractor = new ArticleExtractor();
			articles = articleExtractor.getArticles();
		}
		
	}

	private void saveArticles() throws IOException {
		FileOutputStream out = new FileOutputStream("articles.out");
		ObjectOutputStream oos = new ObjectOutputStream(out);
		
		oos.writeObject(articles);
		
		oos.flush();
		oos.close();
	}
}

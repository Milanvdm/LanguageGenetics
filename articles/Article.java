package articles;

import java.io.IOException;
import java.io.Serializable;

import operators.ArticleTreeGenerator;
import tree.Tree;

public class Article implements Serializable {

	private static final long serialVersionUID = -423208524655835319L;
	
	private String title;
	private String content;
	private double weight;


	public Article(String title, String content, double weight) {
		this.title = title;
		this.content = content;
		this.weight = weight;
	}
	
	public Tree getTree() throws IOException {
		ArticleTreeGenerator generator = new ArticleTreeGenerator();
		return generator.generateTree(this);
	}

	public String getTitle() {
		return this.title;
	}

	public String getContent() {
		return this.content;
	}
	
	public double getWeight() {
		return this.weight;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Article other = (Article) obj;
		if (content == null) {
			if (other.content != null) return false;
		} else if (!content.equals(other.content)) return false;
		if (title == null) {
			if (other.title != null) return false;
		} else if (!title.equals(other.title)) return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [title=" + title + " content=" + content.length() + " rank=" + weight + "]";
	}

}

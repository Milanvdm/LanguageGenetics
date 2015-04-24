package articles;

import java.io.Serializable;

public class Article implements Serializable {

	private static final long serialVersionUID = -423208524655835319L;

	/** Holds the page title*/
	private String title;

	/** Holds the page content*/
	private String content;


	/** Creates a page with title and content*/
	public Article(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return this.title;
	}

	public String getContent() {
		return this.content;
	}

	/** Returns the first sentence of the page, without brackets */
	public String firstSentence() {
		int dotPos = content.indexOf(". ");
		if (dotPos == -1) return (content.replaceAll("\\(.*?\\)", "") + ".");
		return (content.substring(0, dotPos).replaceAll("\\(.*?\\)", "") + ".");
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
		return "Page [title=" + title + "]";
	}

}

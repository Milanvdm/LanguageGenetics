package tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private Tag tag;
	private int probability;
	
	private List<Node> children;
	
	public Node(Tag tag, int probability) {
		this.tag = tag;
		this.probability = probability;
	}

	public List<Node> getAllChildren() {
		List<Node> allChildren = new ArrayList<Node>();
		
		for(Node child: children) {
			allChildren.addAll(child.getAllChildren());
		}
		
		return allChildren;
	}

	public double getDepth() {
		double maxDepth = 0;
		for(Node child: children) {
			double childDepth = child.getDepth();
			if(childDepth > maxDepth) {
				maxDepth = childDepth;
			}
		}
		
		return 1 + maxDepth;
	}

	public double getWidth() {
		double maxWidth = 1;
		for(Node child: children) {
			double currentWidth = children.size();
			if(currentWidth > maxWidth) {
				maxWidth = currentWidth;
			}
			
			double childMaxWidth = child.getWidth();
			if(childMaxWidth > maxWidth) {
				maxWidth = childMaxWidth;
			}
		}
		
		return maxWidth;
	}

	public int getProbability() {
		return probability;
	}

	public void setProbability(int probability) {
		this.probability = probability;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Node getParent(Node node) {
		if(children.contains(node)) {
			return this;
		}
		else {
			for(Node child: children) {
				return child.getParent(node);
			}
		}
		return null;
	}

}
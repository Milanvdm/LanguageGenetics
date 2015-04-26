package tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private Tag tag;
	private int probability;
	private int amount;
	
	private List<Node> children;
	
	public Node(Tag tag, int probability) {
		this.amount = 1;
		this.tag = tag;
		this.probability = probability;
		
		children = new ArrayList<Node>();
	}
	
	public List<Node> getChildren() {
		return children;
	}

	public List<Node> getAllChildren() {
		List<Node> allChildren = new ArrayList<Node>();
		
		allChildren.addAll(children);
		
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
		for(Node child: children) {
			if(child.getParent(node) != null) {
				return child.getParent(node);
			}
		}
		
		return null;
	}

	public void addAmount() {
		amount++;
	}
	
	public int getAmount() {
		return amount;
	}

	public void calculateProbabilities() {
		int totalAmount = 0;
		for(Node child: children) {
			totalAmount = totalAmount + child.getAmount();
		}
		for(Node child: children) {
			double tempProb = (double) child.getAmount() / totalAmount;
			int probability = (int) (tempProb * 100);
			child.setProbability(probability);
		}
	}

	public void addChild(Node node) {
		children.add(node);
	}

	public void printTree(String prefix, boolean isTail) {
		System.out.println(prefix + (isTail ? "└── " : "├── ") + "[" + tag.toString() + ", " + probability + ", " + amount + "]");
        for (int i = 0; i < children.size() - 1; i++) {
            children.get(i).printTree(prefix + (isTail ? "    " : "│   "), false);
        }
        if (children.size() > 0) {
            children.get(children.size() - 1).printTree(prefix + (isTail ?"    " : "│   "), true);
        }
	}

}

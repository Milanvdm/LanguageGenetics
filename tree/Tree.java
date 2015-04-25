package tree;

import java.util.List;

public class Tree {

	private List<Node> allNodes;
	
	private Node startNode;
	
	private double simplicityScore;
	
	private final double widthFactor = 1;
	private final double depthFactor = 1;
	
	public Tree() {
		startNode = new Node(Tag.START, 1);
		simplicityScore = getSimplicityScore();
	}
	

	public List<Node> getAllNodes() {
		findAllNodes();
		return allNodes;
	}
	
	public void changeNode(Node oldNode, Node newNode) {
		Node parentNode = getParent(oldNode);
		parentNode.getAllChildren().remove(oldNode);
		parentNode.getAllChildren().add(newNode);
	}
	
	public void removeNode(Node node) {
		Node parentNode = getParent(node);
		parentNode.getAllChildren().remove(node);
	}
	
	public void changeProbability(Node node, int probability) {
		int difference = node.getProbability() - probability;
		node.setProbability(probability);
		
		Node parentNode = getParent(node);
		int amountOfOtherChildren = parentNode.getAllChildren().size() - 1;
		
		int remainder = difference % amountOfOtherChildren;
		int restProbability = (int) Math.floor(difference / amountOfOtherChildren);
		
		for(Node child: node.getAllChildren()) {
			if(child != node) {
				int currentProbability = child.getProbability();
				child.setProbability(currentProbability + restProbability);
			}
		}
		
		for(Node child: node.getAllChildren()) {
			if(child != node) {
				int currentProbability = child.getProbability();
				child.setProbability(currentProbability + remainder);
				break;
			}
		}
		
		
	}
	
	private Node getParent(Node node) {
		return startNode.getParent(node);
	}

	private void findAllNodes() {
		allNodes = startNode.getAllChildren();
		
	}
	
	private double getSimplicityScore() {
		calculateSimplicity();
		return simplicityScore;
	}



	private void calculateSimplicity() {
		simplicityScore = widthFactor * getWidth() + depthFactor - getDepth();
	}



	private double getDepth() {
		return startNode.getDepth();
	}



	private double getWidth() {
		return startNode.getWidth();
	}



	public Node getStartNode() {
		return startNode;
	}

	
	
}

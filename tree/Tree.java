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

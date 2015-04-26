package tree;

import java.util.List;

public class Tree {

	private List<Node> allNodes;

	private Node startNode;

	private double simplicityScore;

	private final double widthFactor = 1;
	private final double depthFactor = 1;

	public Tree() {
		startNode = new Node(Tag.START, 100);
	}


	public List<Node> getAllNodes() {
		findAllNodes();
		return allNodes;
	}

	public void changeNode(Node oldNode, Node newNode) {
		Node parentNode = getParent(oldNode);
		parentNode.getChildren().remove(oldNode);
		parentNode.getChildren().add(newNode);
	}

	public void removeNode(Node node) {
		Node parentNode = getParent(node);
		parentNode.getChildren().remove(node);
	}

	public void changeProbability(Node node, int probability) {
		int difference = node.getProbability() - probability;
		node.setProbability(probability);

		System.out.println("difference: " + difference);

		Node parentNode = getParent(node);
		System.out.println(parentNode);
		int amountOfOtherChildren = parentNode.getChildren().size() - 1;

		System.out.println("#children: " + amountOfOtherChildren);

		if(amountOfOtherChildren == 0) {
			for(Node child: parentNode.getChildren()) {
				child.setProbability(100);
			}
		}
		else {
			int remainder = difference % amountOfOtherChildren;
			int restProbability = (int) Math.floor(difference / amountOfOtherChildren);

			System.out.println("remainder: " + remainder + " " + "prob: " +  restProbability);

			for(Node child: parentNode.getChildren()) {
				if(child != node) {
					int currentProbability = child.getProbability();
					child.setProbability(currentProbability + restProbability);
				}
			}

			for(Node child: parentNode.getChildren()) {
				if(child != node) {
					int currentProbability = child.getProbability();
					child.setProbability(currentProbability + remainder);
					break;
				}
			}
		}

	}

	private Node getParent(Node node) {
		return startNode.getParent(node);
	}

	private void findAllNodes() {
		allNodes = startNode.getAllChildren();

	}

	public double getSimplicityScore() {
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


	public void printTree() {
		startNode.printTree("", true);
	}


}

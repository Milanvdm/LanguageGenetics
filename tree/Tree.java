package tree;

import java.util.ArrayList;
import java.util.Collections;
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

		Node parentNode = getParent(node);
		System.out.println(parentNode);
		int amountOfOtherChildren = parentNode.getChildren().size() - 1;

		if(amountOfOtherChildren == 0) {
			for(Node child: parentNode.getChildren()) {
				child.setProbability(100);
			}
		}
		else {
			int remainder = difference % amountOfOtherChildren;
			int restProbability = (int) Math.floor(difference / amountOfOtherChildren);

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
		simplicityScore = widthFactor * getWidth() + depthFactor * getDepth();
	}



	public double getDepth() {
		return startNode.getDepth();
	}



	public double getWidth() {
		return startNode.getWidth();
	}



	public Node getStartNode() {
		return startNode;
	}


	public void printTree() {
		startNode.printTree("", true);
	}


	public List<Node> getLowestNodes() {
		List<Node> toReturn = new ArrayList<Node>();
		for(Node node: allNodes) {
			if(getDepth() == getDepthNode(node)) {
				toReturn.add(node);
			}
		}
		
		return toReturn;
	}
	
	private int getDepthNode(Node toFind) {
        List<Node> nodesAtCurrentLevel = Collections.singletonList(startNode);

        return recursiveSearch(0, toFind, nodesAtCurrentLevel);
    }

    private int recursiveSearch(int level, Node toFind, List<Node> nodesAtCurrentLevel) {
        List<Node> nodesAtNextLevel = new ArrayList<Node>();

        // Check if searchNode matches any node at current level
        for (Node node : nodesAtCurrentLevel) {
            // If it matches, we have found the node, return current level
            if (node == toFind) {
                return level;
            }

            // Add children of all nodes at current level in nodesAtNextLevel
            if (node.getChildren().size() != 0) {
                nodesAtNextLevel.addAll(node.getChildren());
            }
        }

        // searchNode is not found at current level, increment level and continue search at next level if next level exists in tree
        if (!nodesAtNextLevel.isEmpty()) {
            return recursiveSearch(level + 1, toFind, nodesAtNextLevel);
        }

        // We have traversed entire tree. Node not found. Return -1
        return -1;
    }


}

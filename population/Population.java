package population;

import java.util.ArrayList;
import java.util.List;

import tree.Tree;


public class Population {

	private List<Tree> population;

	private static Population instance = null;

	public static Population getInstance() {
		if(instance == null) {
			instance = new Population();
		}
		return instance;
	}

	private Population() {
		population = new ArrayList<Tree>();
	}

	public void removeMember(Tree member) {
		population.remove(member);
	}

	public void addMember(Tree member) {
		population.add(member);
	}	

	public List<Tree> getPopulation() {
		return population;
	}

}

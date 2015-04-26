package tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Tag {
	
	START {
		@Override
		public String toString() {
			return "START";
		}
	},
	CC {
		@Override
		public String toString() {
			return "CC";
		}
	},
	CD {
		@Override
		public String toString() {
			return "CD";
		}
	},
	DT {
		@Override
		public String toString() {
			return "DT";
		}
	},
	EX {
		@Override
		public String toString() {
			return "EX";
		}
	},
	FW {
		@Override
		public String toString() {
			return "FW";
		}
	},
	IN {
		@Override
		public String toString() {
			return "IN";
		}
	},
	JJ {
		@Override
		public String toString() {
			return "JJ";
		}
	},
	JJR {
		@Override
		public String toString() {
			return "JJR";
		}
	},
	JJS {
		@Override
		public String toString() {
			return "JJS";
		}
	},
	LS {
		@Override
		public String toString() {
			return "LS";
		}
	},
	MD {
		@Override
		public String toString() {
			return "MD";
		}
	},
	NN {
		@Override
		public String toString() {
			return "NN";
		}
	},
	NNS {
		@Override
		public String toString() {
			return "NNS";
		}
	},
	NNP {
		@Override
		public String toString() {
			return "NNP";
		}
	},
	NNPS {
		@Override
		public String toString() {
			return "NNPS";
		}
	},
	PDT {
		@Override
		public String toString() {
			return "PDT";
		}
	},
	POS {
		@Override
		public String toString() {
			return "POS";
		}
	},
	PRP {
		@Override
		public String toString() {
			return "PRP";
		}
	},
	PRP$ {
		@Override
		public String toString() {
			return "PRP$";
		}
	},
	RB {
		@Override
		public String toString() {
			return "RB";
		}
	},
	RBR {
		@Override
		public String toString() {
			return "RBR";
		}
	},
	RBS {
		@Override
		public String toString() {
			return "RBS";
		}
	},
	RP {
		@Override
		public String toString() {
			return "RP";
		}
	},
	SYM {
		@Override
		public String toString() {
			return "SYM";
		}
	},
	TO {
		@Override
		public String toString() {
			return "TO";
		}
	},
	UH {
		@Override
		public String toString() {
			return "UH";
		}
	},
	VB {
		@Override
		public String toString() {
			return "VB";
		}
	},
	VBD {
		@Override
		public String toString() {
			return "VBD";
		}
	},
	VBG {
		@Override
		public String toString() {
			return "VBG";
		}
	},
	VBN {
		@Override
		public String toString() {
			return "VBN";
		}
	},
	VBP {
		@Override
		public String toString() {
			return "VBP";
		}
	},
	VBZ {
		@Override
		public String toString() {
			return "VBZ";
		}
	},
	WDT {
		@Override
		public String toString() {
			return "WDT";
		}
	},
	WP {
		@Override
		public String toString() {
			return "WP";
		}
	},
	WP$ {
		@Override
		public String toString() {
			return "WP$";
		}
	},
	WRB {
		@Override
		public String toString() {
			return "WRB";
		}
	};


	private static final List<Tag> tags = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int tagSize = tags.size();
	private final static Random random = new Random();

	private Tag[] tagGroup;

	static {
		START.tagGroup = new Tag[]{};

		CC.tagGroup = new Tag[]{Tag.CD};
		CD.tagGroup = new Tag[]{Tag.CC};

		JJ.tagGroup = new Tag[]{Tag.JJR, Tag.JJS};
		JJR.tagGroup = new Tag[]{Tag.JJ, Tag.JJS};
		JJS.tagGroup = new Tag[]{Tag.JJ, Tag.JJR};

		NN.tagGroup = new Tag[]{Tag.NNS, Tag.NNP, Tag.NNPS};
		NNS.tagGroup = new Tag[]{Tag.NN, Tag.NNP, Tag.NNPS};
		NNP.tagGroup = new Tag[]{Tag.NN, Tag.NNS, Tag.NNPS};
		NNPS.tagGroup = new Tag[]{Tag.NN, Tag.NNS, Tag.NNP};

		PDT.tagGroup = new Tag[]{Tag.POS, Tag.PRP, Tag.PRP$};
		POS.tagGroup = new Tag[]{Tag.PDT, Tag.PRP, Tag.PRP$};
		PRP.tagGroup = new Tag[]{Tag.PDT, Tag.POS, Tag.PRP$};
		PRP$.tagGroup = new Tag[]{Tag.PDT, Tag.POS, Tag.PRP};

		RB.tagGroup = new Tag[]{Tag.RBR, Tag.RBS, Tag.RP};
		RBR.tagGroup = new Tag[]{Tag.RB, Tag.RBS, Tag.RP};
		RBS.tagGroup = new Tag[]{Tag.RB, Tag.RBR, Tag.RP};
		RP.tagGroup = new Tag[]{Tag.RB, Tag.RBR, Tag.RBS};

		VB.tagGroup = new Tag[]{Tag.VBD, Tag.VBG, Tag.VBN, Tag.VBP, Tag.VBZ};
		VBD.tagGroup = new Tag[]{Tag.VB, Tag.VBG, Tag.VBN, Tag.VBP, Tag.VBZ};
		VBG.tagGroup = new Tag[]{Tag.VB, Tag.VBD, Tag.VBN, Tag.VBP, Tag.VBZ};
		VBN.tagGroup = new Tag[]{Tag.VB, Tag.VBD, Tag.VBG, Tag.VBP, Tag.VBZ};
		VBP.tagGroup = new Tag[]{Tag.VB, Tag.VBD, Tag.VBG, Tag.VBN, Tag.VBZ};
		VBZ.tagGroup = new Tag[]{Tag.VB, Tag.VBD, Tag.VBG, Tag.VBN, Tag.VBP};

		WDT.tagGroup = new Tag[]{Tag.WP, Tag.WP$, Tag.WRB};
		WP.tagGroup = new Tag[]{Tag.WDT, Tag.WP$, Tag.WRB};
		WP$.tagGroup = new Tag[]{Tag.WDT, Tag.WP, Tag.WRB};
		WRB.tagGroup = new Tag[]{Tag.WDT, Tag.WP, Tag.WP$};		
	}

	public boolean sameGroup(Tag otherTag) {
		if(Arrays.asList(tagGroup).contains(otherTag) || this == otherTag) {
			return true;
		}
		return false;
	}

	public static Tag randomTag(Tag oldTag)  {
		Tag newTag = tags.get(random.nextInt(tagSize));
		while(newTag == oldTag || newTag == Tag.START) {
			newTag = tags.get(random.nextInt(tagSize));
		}
		return newTag;
	}


	
}

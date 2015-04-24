package tree;

import java.util.Arrays;

public enum Tag {
	START, CC, CD, DT, EX, FW, IN, JJ, JJR, JJS, LS, MD, NN, 
	NNS, NNP, NNPS, PDT, POS, PRP, PRP$, RB, RBR, RBS, RP, 
	SYM, TO, UH, VB, VBD, VBG, VBN, VBP, VBZ, WDT, WP, WP$, WRB;
	
	Tag[] tagGroup;

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

}

package edu.osucascades.finalexam;

import java.util.UUID;


public class MadLib {

    private String mNoun;
    private String mVerb;
    private String mAdjective;
    private UUID mId;

    public MadLib() {
        mId = UUID.randomUUID();
    }

    public String getNoun() {
        return mNoun;
    }

    public void setNoun(String noun) {
        mNoun = noun;
    }

    public String getVerb() {
        return mVerb;
    }

    public void setVerb(String verb) {
        mVerb = verb;
    }

    public String getAdjective() {
        return mAdjective;
    }

    public void setAdjective(String adjective) {
        mAdjective = adjective;
    }
}

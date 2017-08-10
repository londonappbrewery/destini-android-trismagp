package com.londonappbrewery.destini;

/**
 * Created by Tristan on 10/08/2017.
 */

public class StoryStage {

    private int mStoryIndex;
    private int mStoryText;
    private int mAnswer1;
    private int mNextStageIndexAnswer1;
    private int mAnswer2;
    private int mNextStageIndexAnswer2;

    public StoryStage(int storyIndex, int storyText, int answer1, int nextStageIndexAnswer1, int answer2, int nextStageIndexAnswer2) {
        mStoryIndex =storyIndex;
        mStoryText = storyText;
        mAnswer1 = answer1;
        mNextStageIndexAnswer1 = nextStageIndexAnswer1;
        mAnswer2 = answer2;
        mNextStageIndexAnswer2 = nextStageIndexAnswer2;
    }

    public int getStoryText() {
        return mStoryText;
    }

    public int getStoryIndex() {
        return mStoryIndex;
    }

    public void setStoryIndex(int storyIndex) {
        mStoryIndex = storyIndex;
    }

    public void setStoryText(int storyText) {
        mStoryText = storyText;
    }

    public int getAnswer1() {
        return mAnswer1;
    }

    public void setAnswer1(int answer1) {
        mAnswer1 = answer1;
    }

    public int getAnswer2() {
        return mAnswer2;
    }

    public void setAnswer2(int answer2) {
        mAnswer2 = answer2;
    }

    public int getNextStageIndexAnswer1() {
        return mNextStageIndexAnswer1;
    }

    public void setNextStageIndexAnswer1(int nextStageIndexAnswer1) {
        mNextStageIndexAnswer1 = nextStageIndexAnswer1;
    }

    public int getNextStageIndexAnswer2() {
        return mNextStageIndexAnswer2;
    }

    public void setNextStageIndexAnswer2(int nextStageIndexAnswer2) {
        mNextStageIndexAnswer2 = nextStageIndexAnswer2;
    }
}

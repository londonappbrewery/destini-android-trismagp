package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int END_OF_STORY = -1;
    public static int STAGE1 = 0;
    public static int STAGE2 = 1;
    public static int STAGE3 = 2;
    public static int STAGE4 = 3;
    public static int STAGE5 = 4;
    public static int STAGE6 = 5;

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;

    private StoryStage mCurrentStage;

    private StoryStage[] mStoryStageBank = new StoryStage[]{
        new StoryStage(STAGE1,R.string.t1_story,R.string.t1_ans1,STAGE3,R.string.t1_ans2,STAGE2),
        new StoryStage(STAGE2,R.string.t2_story,R.string.t2_ans1,STAGE3,R.string.t2_ans2,STAGE4),
        new StoryStage(STAGE3,R.string.t3_story,R.string.t3_ans1,STAGE6,R.string.t3_ans2,STAGE5),
        new StoryStage(STAGE4,R.string.t4_end,END_OF_STORY,END_OF_STORY,END_OF_STORY,END_OF_STORY),
        new StoryStage(STAGE5,R.string.t5_end,END_OF_STORY,END_OF_STORY,END_OF_STORY,END_OF_STORY),
        new StoryStage(STAGE6,R.string.t6_end,END_OF_STORY,END_OF_STORY,END_OF_STORY,END_OF_STORY)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            mCurrentStage = mStoryStageBank[STAGE1];
        }else{
            mCurrentStage = mStoryStageBank[savedInstanceState.getInt("StoryIndex")];
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateViews(mStoryStageBank[mCurrentStage.getNextStageIndexAnswer1()]);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateViews(mStoryStageBank[mCurrentStage.getNextStageIndexAnswer2()]);
            }
        });

        updateViews(mCurrentStage);
    }

    private void updateViews(StoryStage storyStage){
        mCurrentStage = storyStage;
        mStoryTextView.setText(storyStage.getStoryText());

        if(storyStage.getAnswer1()!= END_OF_STORY){
            mButtonTop.setText(storyStage.getAnswer1());
            mButtonBottom.setText(storyStage.getAnswer2());
        }else{
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }
    }

    @Override
    public  void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("StoryIndex",mCurrentStage.getStoryIndex());
    }
}

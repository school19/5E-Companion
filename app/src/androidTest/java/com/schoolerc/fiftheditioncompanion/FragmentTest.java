package com.schoolerc.fiftheditioncompanion;

import android.content.Intent;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.schoolerc.fiftheditioncompanion.ui.creator.CharacterCreatorActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Chaz on 5/9/2017.
 */

@RunWith(AndroidJUnit4.class)
@MediumTest
public class FragmentTest{

    @Rule
    public ActivityTestRule<CharacterCreatorActivity> activityRule = new ActivityTestRule<>(CharacterCreatorActivity.class);

    @Test
    public void fragmentTest()
    {

    }
}

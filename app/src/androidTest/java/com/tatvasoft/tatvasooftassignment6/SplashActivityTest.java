package com.tatvasoft.tatvasooftassignment6;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class SplashActivityTest{

    @Test
    public void testActivity() {
        ActivityScenario<SplashActivity> activityScenario = ActivityScenario.launch(SplashActivity.class);


        onView(allOf(withId(R.id.splash),isDisplayed()));
        onView(allOf(withId(R.id.image),isDisplayed()));

        onView(allOf(withId(R.id.btnSignUp),isDisplayed())).perform(click());

        onView(allOf(withId(R.id.main),isDisplayed()));

    }

    @Rule
    public IntentsTestRule<SplashActivity> intentsTestRule = new IntentsTestRule<>(SplashActivity.class);

    @Test
    public void intentTest() {
        onView(Matchers.allOf(withId(R.id.btnSignUp),isDisplayed())).perform(click());
        intended(hasComponent(MainActivity.class.getName()));
    }
}
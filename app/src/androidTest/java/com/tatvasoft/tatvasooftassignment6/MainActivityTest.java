package com.tatvasoft.tatvasooftassignment6;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.NoMatchingRootException;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest extends TestCase {


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void mainActivityTest() {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(allOf(withId(R.id.main),isDisplayed()));

        //textView- view test
        onView(allOf(withId(R.id.tvGender),isDisplayed()));
        onView(allOf(withId(R.id.tvHobby),isDisplayed()));

        //editText- input and view test
        onView(allOf(withId(R.id.etName),isDisplayed())).perform(typeText("John"),closeSoftKeyboard());
        onView(allOf(withId(R.id.etPhone),isDisplayed())).perform(typeText("1234567890"),closeSoftKeyboard());
        onView(allOf(withId(R.id.etMail),isDisplayed())).perform(typeText("xyz@gmail.com"),closeSoftKeyboard());
        onView(allOf(withId(R.id.etAddress),isDisplayed())).perform(typeText("Xyz Road"),closeSoftKeyboard());

        //editText- onclick and view test
        onView(allOf(withId(R.id.etDob),isDisplayed())).perform(click());

        onView(withText("OK")).perform(click());

        //spinnerDropDown- click, view and set data test
        onView(withId(R.id.countryDropDown)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("India"))).perform(click());
        onView(withId(R.id.countryDropDown)).check(matches(withSpinnerText(containsString("India"))));

        //radioButton- view and click test
        onView(withId(R.id.rbMale)).perform(ViewActions.scrollTo(),click())
                .check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.rbFemale)).perform(ViewActions.scrollTo(),click())
                .check(ViewAssertions.matches(isDisplayed()));

        //checkBox- view and click test
        onView(withId(R.id.chWriting)).perform(ViewActions.scrollTo(),click())
                .check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.chPlaying)).perform(ViewActions.scrollTo(),click())
                .check(ViewAssertions.matches(isDisplayed()));
        onView(withId(R.id.chReading)).perform(ViewActions.scrollTo(),click())
                .check(ViewAssertions.matches(isDisplayed()));

        //signIn button- view and click test
        onView(withId(R.id.btnSignIn)).perform(ViewActions.scrollTo(),click())
                .check(ViewAssertions.matches(isDisplayed()));

            boolean exceptionCaptured = false;
            try{
                onView(withText(R.string.valid_data))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
            }catch (NoMatchingRootException e)
            {
                exceptionCaptured = true;
            }finally {
                {
                    assertTrue(exceptionCaptured);
                }
            }
    }
    @Test
    public void testViewVisibility()
    {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.etName)).check(matches(isDisplayed()));
        onView(withId(R.id.etAddress)).check(matches(isDisplayed()));
        onView(withId(R.id.etDob)).check(matches(isDisplayed()));
        onView(withId(R.id.etPhone)).check(matches(isDisplayed()));
        onView(withId(R.id.etCountry)).check(matches(isDisplayed()));
        onView(withId(R.id.etMail)).check(matches(isDisplayed()));
        onView(withId(R.id.rbMale)).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.rbFemale)).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.chReading)).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.chPlaying)).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.chWriting)).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));

        onView(withId(R.id.btnSignIn)).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));

    }

    @Test
    public void testValidation() {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        //test that all editText value is non-empty
        onView(withId(R.id.etName)).check(ViewAssertions.matches(not("")));
        onView(withId(R.id.etAddress)).check(ViewAssertions.matches(not("")));
        onView(withId(R.id.etDob)).check(ViewAssertions.matches(not("")));
        onView(withId(R.id.etPhone)).check(ViewAssertions.matches(not("")));
        onView(withId(R.id.etCountry)).check(ViewAssertions.matches(not("")));
        onView(withId(R.id.etMail)).check(ViewAssertions.matches(not("")));

        onView(withId(R.id.etMail)).check(ViewAssertions.matches(not(hasErrorText(String.valueOf(R.string.err2_email)))));

        //radio button- checked event test
        //onView(allOf(withId(R.id.rbMale))).check(ViewAssertions.matches(isChecked()));
        onView(withId(R.id.rbFemale)).check(ViewAssertions.matches(isNotChecked())) ;

        //checkBox- checked event testisNotChecked
        onView(withId(R.id.chReading)).check(ViewAssertions.matches((isNotChecked())));
        onView(withId(R.id.chPlaying)).check(ViewAssertions.matches(isNotChecked()));
        onView(withId(R.id.chWriting)).check(ViewAssertions.matches(isNotChecked())) ;


    }
}
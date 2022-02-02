package com.tatvasoft.tatvasooftassignment6;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.tatvasoft.tatvasooftassignment6.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ApplicationTest {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Test
    public void applicationTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btnSignUp), withText("Sign Up"),
                        childAtPosition(
                                allOf(withId(R.id.splash),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.etName),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main),
                                        0),
                                0)));
        appCompatEditText.perform(scrollTo(), replaceText("Xya Vgu"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.etName), withText("Xya Vgu"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main),
                                        0),
                                0)));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.etPhone),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main),
                                        0),
                                1)));
        appCompatEditText3.perform(scrollTo(), replaceText("8521479635"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.etPhone), withText("8521479635"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main),
                                        0),
                                1)));
        appCompatEditText4.perform(pressImeActionButton());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.etMail),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main),
                                        0),
                                2)));
        appCompatEditText5.perform(scrollTo(), replaceText("abc@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.etMail), withText("abc@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main),
                                        0),
                                2)));
        appCompatEditText6.perform(pressImeActionButton());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.etAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main),
                                        0),
                                3)));
        appCompatEditText7.perform(scrollTo(), replaceText("xyzabc"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.etAddress), withText("xyzabc"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main),
                                        0),
                                3)));
        appCompatEditText8.perform(pressImeActionButton());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.etDob),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main),
                                        0),
                                4)));
        appCompatEditText9.perform(scrollTo(), click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton2.perform(scrollTo(), click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatSpinner = onView(
                allOf(withId(R.id.countryDropDown),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main),
                                        0),
                                6)));
        appCompatSpinner.perform(scrollTo(), click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DataInteraction materialTextView = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(3);
        materialTextView.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.rbFemale), withText("Female"),
                        childAtPosition(
                                allOf(withId(R.id.rgGender),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                8)),
                                1)));
        materialRadioButton.perform(scrollTo(), click());

        ViewInteraction materialRadioButton2 = onView(
                allOf(withId(R.id.rbMale), withText("Male"),
                        childAtPosition(
                                allOf(withId(R.id.rgGender),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                8)),
                                0)));
        materialRadioButton2.perform(scrollTo(), click());

        ViewInteraction materialCheckBox = onView(
                allOf(withId(R.id.chPlaying), withText("Playing"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        10),
                                0)));
        materialCheckBox.perform(scrollTo(), click());

        ViewInteraction materialCheckBox2 = onView(
                allOf(withId(R.id.chReading), withText("Reading"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        10),
                                1)));
        materialCheckBox2.perform(scrollTo(), click());

        ViewInteraction materialCheckBox3 = onView(
                allOf(withId(R.id.chWriting), withText("Writing"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        10),
                                2)));
        materialCheckBox3.perform(scrollTo(), click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.btnSignIn), withText("Sign in"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main),
                                        0),
                                11)));
        materialButton3.perform(scrollTo(), click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

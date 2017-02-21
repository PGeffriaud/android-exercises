package fr.android.androidexercises;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void check_login_activity() {
        onView(withId(R.id.usernameEdit)).check(matches(isDisplayed())).perform(typeText("pierre"), closeSoftKeyboard());
        onView(withId(R.id.passwordEdit)).check(matches(isDisplayed())).perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.loginButton)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.loggedText)).check(matches(isDisplayed()));
    }

    public void takeScreenshot(String name) {
        //Spoon.screenshot(getCurrentActivity(), name)
    }


}

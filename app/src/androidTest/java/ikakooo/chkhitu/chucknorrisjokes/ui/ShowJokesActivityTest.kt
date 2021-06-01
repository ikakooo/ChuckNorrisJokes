package ikakooo.chkhitu.chucknorrisjokes.ui

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import ikakooo.chkhitu.chucknorrisjokes.R
import org.hamcrest.Matchers.not
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class ShowJokesActivityTest {


    /**
     * ActivityScenarioRule:
     * https://developer.android.com/reference/androidx/test/ext/junit/rules/ActivityScenarioRule.html
     */
    @get:Rule
    val activityRule = ActivityScenarioRule(ShowJokesActivity::class.java)

    @Test
    fun testActivity_inView() {

        onView(withId(R.id.ShowJokesActivity))
            .check(matches(isDisplayed()))

        // Notice this does not effect the next test
        activityRule.scenario.moveToState(Lifecycle.State.DESTROYED)
    }

    // Visibility
    @Test
    fun testVisibility_title_jokes_and_buttons() {
        onView(withId(R.id.Text_viewID))
            .check(matches(isDisplayed()))

        onView(withId(R.id.favorite_ImageView_ID))
            .check(matches(isDisplayed()))

        onView(withId(R.id.random_Button_ID))
            .check(matches(isDisplayed()))

        onView(withId(R.id.choseCategory_Button_ID))
            .check(matches(isDisplayed()))

        onView(withId(R.id.favorite_Button_ID))
            .check(matches(isDisplayed()))
    }

    // Text
    @Test
    fun testTitleTextDisplayed() {


        onView(withId(R.id.Text_viewID)).perform(click())

        onView(allOf(withId(R.id.Text_viewID), not(withText(""))))

        onView(withId(R.id.Text_viewID)).perform(click())

        onView(allOf(withId(R.id.Text_viewID), not(withText(""))))
    }


}
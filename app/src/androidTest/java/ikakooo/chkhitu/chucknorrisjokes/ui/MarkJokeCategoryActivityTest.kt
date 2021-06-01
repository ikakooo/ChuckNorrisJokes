package ikakooo.chkhitu.chucknorrisjokes.ui

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import ikakooo.chkhitu.chucknorrisjokes.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MarkJokeCategoryActivityTest{

    /**
     * ActivityScenarioRule:
     * https://developer.android.com/reference/androidx/test/ext/junit/rules/ActivityScenarioRule.html
     */
    @get:Rule
    val activityRule = ActivityScenarioRule(MarkJokeCategoryActivity::class.java)

    @Test
    fun testActivity_inView() {

        Espresso.onView(ViewMatchers.withId(R.id.MarkJokeCategoryActivity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Notice this does not effect the next test
        activityRule.scenario.moveToState(Lifecycle.State.DESTROYED)
    }

}
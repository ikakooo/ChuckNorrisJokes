package ikakooo.chkhitu.chucknorrisjokes.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import ikakooo.chkhitu.chucknorrisjokes.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4ClassRunner::class)
class SplashScreenActivityUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(SplashScreenActivity::class.java)

    @Test
    fun testActivity_inView() {
       // val activityScenario = ActivityScenario.launch(SplashScreenActivity::class.java)

        onView(withId(R.id.splash_screen_layout)).check(matches(isDisplayed()))
    }

    // Visibility
    @Test
    fun testVisibility_title_nextButton() {
       // val activityScenario = ActivityScenario.launch(SplashScreenActivity::class.java)

        onView(withId(R.id.splash_screen_child_layout))
            .check(matches(isDisplayed())) // method 1

        onView(withId(R.id.splash_screen_child_layout))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE))) // method 2

    }

//    // Text
//    @Test
//    fun testTitleTextDisplayed() {
//        val activityScenario = ActivityScenario.launch(SplashScreenActivity::class.java)
//
//        onView(withId(R.id.splash_screen_child_layout))
//            .check(matches(withText(R.string.app_name)))
//    }


}
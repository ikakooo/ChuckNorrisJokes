package ikakooo.chkhitu.chucknorrisjokes

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import ikakooo.chkhitu.chucknorrisjokes.ui.SplashScreenActivity
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4ClassRunner::class)
class SplashScreenActivityUITest {



    @Test
    fun testActivity_inView() {
        val activityScenario = ActivityScenario.launch(SplashScreenActivity::class.java)

        onView(withId(R.id.splash_screen_layout)).check(matches(isDisplayed()))
    }

    // Visibility
    @Test
    fun testVisibility_title_nextButton() {
        val activityScenario = ActivityScenario.launch(SplashScreenActivity::class.java)

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
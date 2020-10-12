package com.shadowfx.shadowfxmoviefinder.ui.home



import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.intercepting.SingleActivityFactory
import com.shadowfx.shadowfxmoviefinder.R
import com.shadowfx.shadowfxmoviefinder.TestApp
import com.shadowfx.shadowfxmoviefinder.ui.home.HomeActivity
import com.shadowfx.shadowfxmoviefinder.ui.home.HomeViewModel
import com.shadowfx.shadowfxmoviefinder.util.RecyclerViewMatcher
import com.shadowfx.shadowfxmoviefinder.util.State
import com.shadowfx.shadowfxmoviefinder.util.TaskExecutorWithIdlingResourceRule
import com.shadowfx.shadowfxmoviefinder.util.TestUtil
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock


@RunWith(AndroidJUnit4::class)
class HomeActivityTest {
    @Rule
    @JvmField
    val executorRule = TaskExecutorWithIdlingResourceRule()
    lateinit var  testApp:TestApp
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val injectedFactory: SingleActivityFactory<HomeActivity> =
        object:SingleActivityFactory<HomeActivity>(HomeActivity::class.java){
            override fun create(intent: Intent?): HomeActivity {
                viewModelFactory = mock(ViewModelProvider.Factory::class.java)
                testApp = InstrumentationRegistry.getTargetContext().getApplicationContext() as TestApp
                viewModelFactory = testApp.daggerTestAppComponent?.vmFactory()!!
                val homeActivity = HomeActivity()
                homeActivity.viewModelFactory =  viewModelFactory
                return homeActivity
            }
        }

    @get:Rule
    var mActivityTestRule =
        ActivityTestRule(injectedFactory, false, false)

    @Before
    fun init() {
        val intent = Intent(InstrumentationRegistry.getTargetContext(), HomeActivity::class.java)
        mActivityTestRule.launchActivity(intent)
    }

    @Test
    fun testLoading() {
        onView(withId(R.id.progress_bar)).check(matches(isDisplayed()))
    }


    @Test
    fun testSearching() {
        onView(withId(R.id.search))
            .perform(click())
    }

    @Test
    fun testWithValue() {
        mActivityTestRule.activity.viewModel._moviesLiveData.postValue(State.success(TestUtil.getNewMovieList()))
        onView(listMatcher().atPosition(0)).check(matches(
            ViewMatchers.hasDescendant(
                ViewMatchers.withText(
                    "Batman v Superman: Dawn of Justice"
                )
            )
        ))
    }

    private fun listMatcher(): RecyclerViewMatcher {
        return RecyclerViewMatcher(R.id.recycler_view_movies)
    }

}
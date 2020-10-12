package com.shadowfx.shadowfxmoviefinder.ui.detail



import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.intercepting.SingleActivityFactory
import com.shadowfx.shadowfxmoviefinder.R
import com.shadowfx.shadowfxmoviefinder.TestApp
import com.shadowfx.shadowfxmoviefinder.ui.moviedetail.MovieDetailScrollingActivity
import com.shadowfx.shadowfxmoviefinder.util.State
import com.shadowfx.shadowfxmoviefinder.util.TaskExecutorWithIdlingResourceRule
import com.shadowfx.shadowfxmoviefinder.util.TestUtil
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock


@RunWith(AndroidJUnit4::class)
class MovieDetailsActivityTest {
    @Rule
    @JvmField
    val executorRule = TaskExecutorWithIdlingResourceRule()
    lateinit var  testApp:TestApp
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val injectedFactory: SingleActivityFactory<MovieDetailScrollingActivity> =
        object:SingleActivityFactory<MovieDetailScrollingActivity>(MovieDetailScrollingActivity::class.java){
            override fun create(intent: Intent?): MovieDetailScrollingActivity {
                viewModelFactory = mock(ViewModelProvider.Factory::class.java)
                testApp = InstrumentationRegistry.getTargetContext().getApplicationContext() as TestApp
                viewModelFactory = testApp.daggerTestAppComponent?.vmFactory()!!
                val movieDetailScrollingActivity = MovieDetailScrollingActivity()
                movieDetailScrollingActivity.viewModelFactory =  viewModelFactory
                return movieDetailScrollingActivity
            }
        }

    @get:Rule
    var mActivityTestRule =
        ActivityTestRule(injectedFactory, false, false)

    @Before
    fun init() {
        val intent = Intent(InstrumentationRegistry.getTargetContext(), MovieDetailScrollingActivity::class.java)
        mActivityTestRule.launchActivity(intent)
    }

    @Test
    fun testLoading() {
        onView(withId(R.id.progress_bar)).check(matches(isDisplayed()))
    }


    @Test
    fun testWithValue() {
        mActivityTestRule.activity.viewModel._movieDetailLiveData.postValue(State.success(TestUtil.getMovieDetail()))
        onView(withId(R.id.text_year)).check(matches(withText("Year: 1990")))
    }

}
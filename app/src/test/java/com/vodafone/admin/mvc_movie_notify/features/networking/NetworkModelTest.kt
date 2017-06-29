package com.vodafone.admin.mvc_movie_notify.features.networking

import com.vodafone.admin.mvc_movie_notify.features.networking.entities.UpcomingMovieResult
import com.vodafone.admin.mvc_movie_notify.features.networking.helpers.APIService
import com.vodafone.admin.mvc_movie_notify.features.networking.mocks.APIClientMock
import com.vodafone.admin.mvc_movie_notify.features.networking.mocks.UpcomingMovieModelMock
import com.vodafone.admin.mvc_movie_notify.features.shared.Constants
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior
import rx.observers.TestSubscriber
import java.util.concurrent.TimeUnit

/**
 * @author lpereira on 29/06/2017.
 */
class NetworkModelTest {
    private val behavior = NetworkBehavior.create()
    private val testUpcommingSubscriber = TestSubscriber.create<UpcomingMovieResult>()
    private var mockService: APIService? = null

    @Before
    fun setUp() {
        val networkMockUtils = NetworkMockUtils()
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constants.URL)
                .build()

        val mockRetrofit = MockRetrofit.Builder(retrofit).networkBehavior(networkMockUtils.getBehavior()).build()

        val delegate = mockRetrofit.create<APIService>(APIService::class.java)
        mockService = APIClientMock(delegate)

        networkMockUtils.givenNetworkFailurePercentIs(0)
    }

    @Test
    fun upcomingMovies() {
        //GIVEN
        val upcommingMock = UpcomingMovieModelMock().mock

        //WHEN
        mockService!!.upcomingMovies("").first().toBlocking().subscribe(testUpcommingSubscriber)

        //THEN
        Assert.assertNotNull(upcommingMock)
        testUpcommingSubscriber.assertNoErrors()
        testUpcommingSubscriber.assertReceivedOnNext(listOf(upcommingMock))
        testUpcommingSubscriber.assertCompleted()
    }
}

class NetworkMockUtils {
    private val mBehavior = NetworkBehavior.create()

    fun givenNetworkFailurePercentIs(failurePercent: Int) {
        mBehavior.setDelay(0, TimeUnit.MILLISECONDS)
        mBehavior.setVariancePercent(0)
        mBehavior.setFailurePercent(failurePercent)
    }

    fun getBehavior(): NetworkBehavior {
        return mBehavior
    }
}

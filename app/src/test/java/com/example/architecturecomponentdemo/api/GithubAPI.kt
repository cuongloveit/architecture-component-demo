package com.example.architecturecomponentdemo.api

import com.example.architecturecomponentdemo.api.entity.SearchResponse
import com.example.architecturecomponentdemo.base.AppTestRunner
import com.example.architecturecomponentdemo.base.BaseUnitTest
import io.reactivex.subscribers.TestSubscriber
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by cuong on 7/15/17.
 */
@RunWith(AppTestRunner::class)
class GithubAPI : BaseUnitTest() {




    @Test
    fun searchRepository() {
        val testSubscriber: TestSubscriber<SearchResponse> = getMyApi()
                .searchRepository("java").test()
        testSubscriber.assertNoTimeout()
        testSubscriber.assertNoErrors()

        Assertions.assertThat(testSubscriber).isNotNull()
        val searchResponse: SearchResponse = testSubscriber.events[0][0] as SearchResponse
        Assertions.assertThat(searchResponse).isNotNull()
        Assertions.assertThat(searchResponse.repositories).isNotNull

    }
}
package awssdk.admin

import awssdk.common.BaseAwsSdkSpec
import com.amazonaws.AmazonClientException
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.ListQueuesResult
import rx.Observable
import rx.observers.TestSubscriber
import tddmonkey.rxsqs.awssdk.AmazonSdkRxSqs

class FailingRequestSpec extends BaseAwsSdkSpec {
    def "raises an error"() {
        when:
            Observable<ListQueuesResult> queues = new AmazonSdkRxSqs(nonReachableClient()).listQueues()

        then:
            TestSubscriber subscriber = new TestSubscriber()
            queues.subscribe(subscriber)
            subscriber.awaitTerminalEvent()
            subscriber.assertError(AmazonClientException)
    }

    private AmazonSQSAsyncClient nonReachableClient() {
        new AmazonSQSAsyncClient()
    }
}

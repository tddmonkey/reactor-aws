package awssdk.admin

import awssdk.common.BaseAwsSdkSpec
import com.amazonaws.AmazonClientException
import com.amazonaws.services.sqs.model.ListQueuesResult
import rx.Observable
import rx.observers.TestSubscriber

class FailingRequestSpec extends BaseAwsSdkSpec {
    def "raises an error"() {
        when:
            Observable<ListQueuesResult> queues = rxSqs().listQueues()

        then:
            TestSubscriber subscriber = new TestSubscriber()
            queues.subscribe(subscriber)
            subscriber.awaitTerminalEvent()
            subscriber.assertError(AmazonClientException)
    }
}

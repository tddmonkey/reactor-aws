package admin

import com.amazonaws.AmazonClientException
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.ListQueuesResult
import rx.Observable
import rx.observers.TestSubscriber
import spock.lang.Specification
import tddmonkey.rxsqs.awssdk.AmazonSdkRxSqs

class FailingRequestSpec extends Specification {
    def "raises an error"() {
        given:
            AmazonSQSAsyncClient client = new AmazonSQSAsyncClient(new BasicAWSCredentials("ignored", "ignored"))
            client.setEndpoint("http://localhost:8025")

        when:
            Observable<ListQueuesResult> queues = new AmazonSdkRxSqs(client).listQueues()

        then:
            TestSubscriber subscriber = new TestSubscriber()
            queues.subscribe(subscriber)
            subscriber.awaitTerminalEvent()
            subscriber.assertError(AmazonClientException)
    }
}

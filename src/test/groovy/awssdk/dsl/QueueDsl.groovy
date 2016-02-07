package awssdk.dsl

import awssdk.common.VerifyableRxSqs
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import rx.observers.TestSubscriber
import tddmonkey.rxsqs.awssdk.AmazonSdkRxSqs

trait QueueDsl {
    abstract AmazonSQSAsyncClient client()

    TestableQueue queue(String queueName) {
        return new TestableQueue(name: queueName, client: client())
    }

    VerifyableRxSqs rxSqs() {
        return new VerifyableRxSqs(client: client())
    }
}

class AssertableDualResponse {
    def awsResult
    def rxResult

    void matches() {
        TestSubscriber subscriber = new TestSubscriber()
        rxResult.subscribe(subscriber)
        subscriber.awaitTerminalEvent()
        subscriber.assertValue(awsResult)
    }
}



class TestableQueue {
    String name
    AmazonSQSAsyncClient client

    TestableQueue exists() {
        client.createQueue(name)
        this
    }
}


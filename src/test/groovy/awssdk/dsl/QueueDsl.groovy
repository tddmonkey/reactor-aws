package awssdk.dsl

import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import tddmonkey.rxsqs.awssdk.AmazonSdkRxSqs

trait QueueDsl {
    abstract AmazonSQSAsyncClient client()

    TestableQueue queue(String queueName) {
        return new TestableQueue(name: queueName, client: client())
    }

    private AmazonSdkRxSqs rxSqs() {
        new AmazonSdkRxSqs(client())
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


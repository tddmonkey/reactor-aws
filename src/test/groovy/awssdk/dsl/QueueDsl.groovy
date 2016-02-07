package awssdk.dsl

import awssdk.common.VerifyableRxSqs
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
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



class TestableQueue {
    String name
    AmazonSQSAsyncClient client

    TestableQueue exists() {
        client.createQueue(name)
        this
    }
}


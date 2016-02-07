package dsl

import com.amazonaws.services.sqs.AmazonSQSAsyncClient

trait QueueDsl {
    abstract AmazonSQSAsyncClient client()

    TestableQueue queue(String queueName) {
        return new TestableQueue(name: queueName, client: client())
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


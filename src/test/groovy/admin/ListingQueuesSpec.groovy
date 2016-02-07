package admin

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.ListQueuesRequest
import com.amazonaws.services.sqs.model.ListQueuesResult
import com.shazam.tocker.DockerInstance
import com.shazam.tocker.PortMap
import com.spotify.docker.client.DefaultDockerClient
import rx.observers.TestSubscriber
import tddmonkey.rxsqs.awssdk.AmazonSdkRxSqs
import spock.lang.Specification

class ListingQueuesSpec extends Specification {
    def "lists all queues"() {
        given:
            DockerInstance elasticMq = DockerInstance
                    .fromImage("tddmonkey/elasticmq")
                    .mappingPorts(PortMap.of(9324, 8000))
                    .withContainerName("rx-sqs")
                    .withEnv("NODE_HOST=${DefaultDockerClient.fromEnv().build().host}", "NODE_PORT=8000")
                    .build()
            elasticMq.run()
            AmazonSQSAsyncClient client = new AmazonSQSAsyncClient(new BasicAWSCredentials("ignored", "ignored"))
            client.setEndpoint("http://${elasticMq.host()}:8000")
            client.createQueue("test-queue-1")
            client.createQueue("test-queue-2")

        when:
            TestSubscriber<ListQueuesResult> subscriber = new TestSubscriber<>();
            new AmazonSdkRxSqs(client).listQueues().subscribe(subscriber)
            subscriber.awaitTerminalEvent()

        then:
            subscriber.assertNoErrors()
            subscriber.assertValue(client.listQueues())
    }

    def "lists queues with request"() {
        given:
            DockerInstance elasticMq = DockerInstance
                    .fromImage("tddmonkey/elasticmq")
                    .mappingPorts(PortMap.of(9324, 8000))
                    .withContainerName("rx-sqs")
                    .withEnv("NODE_HOST=${DefaultDockerClient.fromEnv().build().host}", "NODE_PORT=8000")
                    .build()
            elasticMq.run()
            AmazonSQSAsyncClient client = new AmazonSQSAsyncClient(new BasicAWSCredentials("ignored", "ignored"))
            client.setEndpoint("http://${elasticMq.host()}:8000")
            client.createQueue("test-queue-1")
            client.createQueue("test-queue-2")
            client.createQueue("other-test-queue-2")
            ListQueuesRequest listQueuesRequest = new ListQueuesRequest("test")

        when:
            TestSubscriber<ListQueuesResult> subscriber = new TestSubscriber<>();
            new AmazonSdkRxSqs(client).listQueues(listQueuesRequest).subscribe(subscriber)
            subscriber.awaitTerminalEvent()

        then:
            subscriber.assertNoErrors()
            subscriber.assertValue(client.listQueues(listQueuesRequest))
    }

    def "lists queues with prefix"() {
        given:
            DockerInstance elasticMq = DockerInstance
                    .fromImage("tddmonkey/elasticmq")
                    .mappingPorts(PortMap.of(9324, 8000))
                    .withContainerName("rx-sqs")
                    .withEnv("NODE_HOST=${DefaultDockerClient.fromEnv().build().host}", "NODE_PORT=8000")
                    .build()
            elasticMq.run()
            AmazonSQSAsyncClient client = new AmazonSQSAsyncClient(new BasicAWSCredentials("ignored", "ignored"))
            client.setEndpoint("http://${elasticMq.host()}:8000")
            client.createQueue("test-queue-1")
            client.createQueue("test-queue-2")
            client.createQueue("other-test-queue-2")

        when:
            TestSubscriber<ListQueuesResult> subscriber = new TestSubscriber<>();
            new AmazonSdkRxSqs(client).listQueues("test").subscribe(subscriber)
            subscriber.awaitTerminalEvent()

        then:
            subscriber.assertNoErrors()
            subscriber.assertValue(client.listQueues("test"))
    }
}

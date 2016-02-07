package admin

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.ListQueuesRequest
import com.amazonaws.services.sqs.model.ListQueuesResult
import com.shazam.tocker.DockerInstance
import com.shazam.tocker.PortMap
import com.spotify.docker.client.DefaultDockerClient
import dsl.QueueDsl
import rx.Observable
import rx.observers.TestSubscriber
import spock.lang.Shared
import tddmonkey.rxsqs.awssdk.AmazonSdkRxSqs
import spock.lang.Specification

class ListingQueuesSpec extends Specification implements QueueDsl {
    @Shared AmazonSQSAsyncClient client = new AmazonSQSAsyncClient(new BasicAWSCredentials("ignored", "ignored"))

    def setupSpec() {
        Observable.metaClass.returns { val ->
            println "called returns"
            TestSubscriber<ListQueuesResult> subscriber = new TestSubscriber<>();
            delegate.subscribe(subscriber)
            subscriber.awaitTerminalEvent()
            subscriber.assertNoErrors()
            subscriber.assertValue(val)
            Void
        }

        DockerInstance elasticMq = DockerInstance
                .fromImage("tddmonkey/elasticmq")
                .mappingPorts(PortMap.of(9324, 8000))
                .withContainerName("rx-sqs")
                .withEnv("NODE_HOST=${DefaultDockerClient.fromEnv().build().host}", "NODE_PORT=8000")
                .build()
        elasticMq.run()
        client.setEndpoint("http://${elasticMq.host()}:8000")
    }

    def "lists all queues"() {
        given:
            queue("test-queue-1").exists()

        expect:
            new AmazonSdkRxSqs(client).listQueues().returns(client.listQueues())
    }


    def "lists queues with request"() {
        given:
            queue("test-queue-1").exists()
            queue("other-test-queue-2").exists()
            ListQueuesRequest listQueuesRequest = new ListQueuesRequest("test")

        expect:
            new AmazonSdkRxSqs(client).listQueues(listQueuesRequest).returns(client.listQueues(listQueuesRequest))
    }

    def "lists queues with prefix"() {
        given:
            queue("test-queue-1").exists()
            queue("other-test-queue-1").exists()

        expect:
            new AmazonSdkRxSqs(client).listQueues("test").returns(client.listQueues("test"))
    }

    @Override
    AmazonSQSAsyncClient client() {
        return client
    }
}

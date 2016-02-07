package admin

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.CreateQueueRequest
import com.amazonaws.services.sqs.model.ListQueuesResult
import com.shazam.tocker.DockerInstance
import com.shazam.tocker.PortMap
import com.spotify.docker.client.DefaultDockerClient
import dsl.QueueDsl
import rx.Observable
import rx.observers.TestSubscriber
import spock.lang.Shared
import spock.lang.Specification
import tddmonkey.rxsqs.awssdk.AmazonSdkRxSqs

class CreatingQueuesSpec extends Specification implements QueueDsl {
    @Shared AmazonSQSAsyncClient client = new AmazonSQSAsyncClient(new BasicAWSCredentials("ignored", "ignored"))

    def setupSpec() {
        Observable.metaClass.returns { val ->
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

    def "creates a queue with name"() {
        given:
            def queueName = "create-queue-test__queue1"

        expect:
            new AmazonSdkRxSqs(client).createQueue(queueName).returns(client.createQueue(queueName))
    }

    def "creates a queue with request"() {
        given:
            CreateQueueRequest createQueueRequest = new CreateQueueRequest("create-queue-test__queue2")

        expect:
            new AmazonSdkRxSqs(client).createQueue(createQueueRequest).returns(client.createQueue(createQueueRequest))
    }

    @Override
    AmazonSQSAsyncClient client() {
        return client
    }
}

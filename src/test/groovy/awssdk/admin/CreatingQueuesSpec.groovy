package awssdk.admin

import awssdk.common.BaseAwsSdkSpec
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.sqs.model.CreateQueueRequest
import com.amazonaws.services.sqs.model.ListQueuesResult
import com.shazam.tocker.DockerInstance
import com.shazam.tocker.PortMap
import com.spotify.docker.client.DefaultDockerClient
import awssdk.dsl.QueueDsl
import rx.Observable
import rx.observers.TestSubscriber
import spock.lang.Shared
import spock.lang.Specification
import tddmonkey.rxsqs.awssdk.AmazonSdkRxSqs

class CreatingQueuesSpec extends BaseAwsSdkSpec {
    def "creates a queue with name"() {
        given:
            def queueName = "create-queue-test__queue1"

        expect:
            rxSqs().createQueue(queueName).returns(client.createQueue(queueName))
    }

    def "creates a queue with request"() {
        given:
            CreateQueueRequest createQueueRequest = new CreateQueueRequest("create-queue-test__queue2")

        expect:
            rxSqs().createQueue(createQueueRequest).returns(client.createQueue(createQueueRequest))
    }
}

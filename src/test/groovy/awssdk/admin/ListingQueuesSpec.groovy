package awssdk.admin

import awssdk.common.BaseAwsSdkSpec
import awssdk.common.VerifyableRxSqs
import com.amazonaws.services.sqs.model.ListQueuesRequest

class ListingQueuesSpec extends BaseAwsSdkSpec{
    def "lists all queues"() {
        given:
            queue("test-queue-1").exists()

        expect:
            rxSqs().listQueues().matches()
    }

    def "lists queues with request"() {
        given:
            queue("test-queue-1").exists()
            queue("other-test-queue-2").exists()
            ListQueuesRequest listQueuesRequest = new ListQueuesRequest("test")

        expect:
            rxSqs().listQueues(listQueuesRequest).matches()
    }

    def "lists queues with prefix"() {
        given:
            queue("test-queue-1").exists()
            queue("other-test-queue-1").exists()

        expect:
            rxSqs().listQueues("test").matches()
    }
}

package awssdk.admin

import awssdk.common.BaseAwsSdkSpec
import com.amazonaws.services.sqs.model.CreateQueueRequest

class CreatingQueuesSpec extends BaseAwsSdkSpec {
    def "creates a queue with name"() {
        expect:
            rxSqs().createQueue("create-queue-test__queue1").matches()
    }

    def "creates a queue with request"() {
        expect:
            rxSqs().createQueue(new CreateQueueRequest("create-queue-test__queue2")).matches()
    }
}

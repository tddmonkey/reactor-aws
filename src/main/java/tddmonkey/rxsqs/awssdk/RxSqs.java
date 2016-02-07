package tddmonkey.rxsqs.awssdk;

import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import rx.Observable;

public interface RxSqs {
    Observable<ListQueuesResult> listQueues();
    Observable<ListQueuesResult> listQueues(ListQueuesRequest listQueuesRequest);

    Observable<ListQueuesResult> listQueues(String queueNamePrefix);
}

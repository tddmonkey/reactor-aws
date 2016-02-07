package tddmonkey.rxsqs.awssdk;

import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import rx.Observable;

import static tddmonkey.rxsqs.awssdk.AmazonWebServiceRequestAsyncHandler.handlerFor;

public class AmazonSdkRxSqs implements RxSqs {
    private AmazonSQSAsyncClient client;

    public AmazonSdkRxSqs(AmazonSQSAsyncClient client) {
        this.client = client;
    }

    @Override
    public Observable<ListQueuesResult> listQueues() {
        return Observable.create(subscriber -> client.listQueuesAsync(handlerFor(subscriber)));
    }

    @Override
    public Observable<ListQueuesResult> listQueues(ListQueuesRequest listQueuesRequest) {
        return Observable.create(subscriber -> client.listQueuesAsync(listQueuesRequest, handlerFor(subscriber)));
    }

    @Override
    public Observable<ListQueuesResult> listQueues(String queueNamePrefix) {
        return Observable.create(subscriber -> client.listQueuesAsync(queueNamePrefix, handlerFor(subscriber)));
    }

    public Observable<CreateQueueResult> createQueue(String queueName) {
        return Observable.create(subscriber -> client.createQueueAsync(queueName, handlerFor(subscriber)));
    }

    public Observable<CreateQueueResult> createQueue(CreateQueueRequest createQueueRequest) {
        return Observable.create(subscriber -> client.createQueueAsync(createQueueRequest, handlerFor(subscriber)));
    }


}

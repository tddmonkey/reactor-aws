package tddmonkey.rxsqs.awssdk;

import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import rx.Observable;

public class AmazonSdkRxSqs implements RxSqs {
    private AmazonSQSAsyncClient client;

    public AmazonSdkRxSqs(AmazonSQSAsyncClient client) {
        this.client = client;
    }

    @Override
    public Observable<ListQueuesResult> listQueues() {
        return Observable.create(subscriber -> {
            client.listQueuesAsync(new AsyncHandler<ListQueuesRequest, ListQueuesResult>() {
                @Override
                public void onError(Exception exception) {

                }

                @Override
                public void onSuccess(ListQueuesRequest request, ListQueuesResult listQueuesResult) {
                    subscriber.onNext(listQueuesResult);
                    subscriber.onCompleted();
                }
            });
        });
    }

    @Override
    public Observable<ListQueuesResult> listQueues(ListQueuesRequest listQueuesRequest) {
        return Observable.create(subscriber -> {
            client.listQueuesAsync(listQueuesRequest, new AsyncHandler<ListQueuesRequest, ListQueuesResult>() {
                @Override
                public void onError(Exception exception) {

                }

                @Override
                public void onSuccess(ListQueuesRequest request, ListQueuesResult listQueuesResult) {
                    subscriber.onNext(listQueuesResult);
                    subscriber.onCompleted();
                }
            });
        });
    }

    @Override
    public Observable<ListQueuesResult> listQueues(String queueNamePrefix) {
        return Observable.create(subscriber -> {
            client.listQueuesAsync(queueNamePrefix, new AsyncHandler<ListQueuesRequest, ListQueuesResult>() {
                @Override
                public void onError(Exception exception) {

                }

                @Override
                public void onSuccess(ListQueuesRequest request, ListQueuesResult listQueuesResult) {
                    subscriber.onNext(listQueuesResult);
                    subscriber.onCompleted();
                }
            });
        });
    }
}

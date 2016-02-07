package tddmonkey.rxsqs.awssdk;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import rx.Observable;
import rx.Subscriber;

public class AmazonSdkRxSqs implements RxSqs {
    private AmazonSQSAsyncClient client;

    public AmazonSdkRxSqs(AmazonSQSAsyncClient client) {
        this.client = client;
    }

    @Override
    public Observable<ListQueuesResult> listQueues() {
        return Observable.create(subscriber -> client.listQueuesAsync(asyncHandler(subscriber)));
    }

    @Override
    public Observable<ListQueuesResult> listQueues(ListQueuesRequest listQueuesRequest) {
        return Observable.create(subscriber -> client.listQueuesAsync(listQueuesRequest, asyncHandler(subscriber)));
    }

    @Override
    public Observable<ListQueuesResult> listQueues(String queueNamePrefix) {
        return Observable.create(subscriber -> client.listQueuesAsync(queueNamePrefix, asyncHandler(subscriber)));
    }

    private <RQ extends AmazonWebServiceRequest, RS> AsyncHandler<RQ, RS> asyncHandler(final Subscriber<? super RS> subscriber) {
        return new AsyncHandler<RQ, RS>() {
            @Override
            public void onError(Exception exception) {
                subscriber.onError(exception);
            }

            @Override
            public void onSuccess(RQ request, RS response) {
                subscriber.onNext(response);
                subscriber.onCompleted();
            }
        };
    }

}

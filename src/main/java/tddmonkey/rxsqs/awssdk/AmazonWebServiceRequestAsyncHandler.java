package tddmonkey.rxsqs.awssdk;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.handlers.AsyncHandler;
import rx.Subscriber;

class AmazonWebServiceRequestAsyncHandler<RQ extends AmazonWebServiceRequest, RS> implements AsyncHandler<RQ, RS> {
    private final Subscriber<? super RS> subscriber;

    private AmazonWebServiceRequestAsyncHandler(Subscriber<? super RS> subscriber) {
        this.subscriber = subscriber;
    }

    static <RQ extends AmazonWebServiceRequest, RS> AsyncHandler<RQ, RS> handlerFor(final Subscriber<? super RS> subscriber) {
        return new AmazonWebServiceRequestAsyncHandler<>(subscriber);
    }

    @Override
    public void onError(Exception exception) {
        subscriber.onError(exception);
    }

    @Override
    public void onSuccess(RQ request, RS response) {
        subscriber.onNext(response);
        subscriber.onCompleted();
    }
}

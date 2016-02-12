package tddmonkey.rxaws.common;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.handlers.AsyncHandler;
import rx.Subscriber;

public class AmazonWebServiceRequestAsyncHandler<RQ extends AmazonWebServiceRequest, RS> implements AsyncHandler<RQ, RS> {
    private final Subscriber<? super RS> subscriber;
    private boolean shouldEmitValue;

    private AmazonWebServiceRequestAsyncHandler(Subscriber<? super RS> subscriber, boolean shouldEmitValue) {
        this.subscriber = subscriber;
        this.shouldEmitValue = shouldEmitValue;
    }

    @Override
    public void onError(Exception exception) {
        subscriber.onError(exception);
    }

    @Override
    public void onSuccess(RQ request, RS response) {
        if (shouldEmitValue) {
            subscriber.onNext(response);
        }
        subscriber.onCompleted();
    }

    public static <RQ extends AmazonWebServiceRequest, RS> AsyncHandler<RQ, RS> valueEmittingHandlerFor(final Subscriber<? super RS> subscriber) {
        return new AmazonWebServiceRequestAsyncHandler<>(subscriber, true);
    }

    public static <RQ extends AmazonWebServiceRequest> AsyncHandler<RQ, Void> voidHandlerFor(Subscriber<? super Void> subscriber) {
        return new AmazonWebServiceRequestAsyncHandler<>(subscriber, false);
    }
}

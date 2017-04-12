package tddmonkey.reactoraws.common;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.handlers.AsyncHandler;
import reactor.core.publisher.MonoSink;

public class AmazonWebServiceRequestAsyncHandler<RQ extends AmazonWebServiceRequest, RS> implements AsyncHandler<RQ, RS> {
    private final MonoSink<? super RS> subscriber;
    private boolean shouldEmitValue;

    private AmazonWebServiceRequestAsyncHandler(MonoSink<? super RS> subscriber, boolean shouldEmitValue) {
        this.subscriber = subscriber;
        this.shouldEmitValue = shouldEmitValue;
    }

    @Override
    public void onError(Exception exception) {
        subscriber.error(exception);
    }

    @Override
    public void onSuccess(RQ request, RS response) {
        if (shouldEmitValue) {
            subscriber.success(response);
        } else {
            subscriber.success();
        }
    }

    public static <RQ extends AmazonWebServiceRequest, RS> AsyncHandler<RQ, RS> valueEmittingHandlerFor(final MonoSink<? super RS> subscriber) {
        return new AmazonWebServiceRequestAsyncHandler<>(subscriber, true);
    }

    public static <RQ extends AmazonWebServiceRequest> AsyncHandler<RQ, Void> voidHandlerFor(MonoSink<? super Void> subscriber) {
        return new AmazonWebServiceRequestAsyncHandler<>(subscriber, false);
    }
}

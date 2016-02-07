package awssdk.common

import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import rx.observers.TestSubscriber
import tddmonkey.rxsqs.awssdk.AmazonSdkRxSqs

class VerifyableRxSqs {
    AmazonSQSAsyncClient client
    @Lazy private AmazonSdkRxSqs rxSqs = new AmazonSdkRxSqs(client)

    @Override
    Object invokeMethod(String name, Object args) {
        def result = client.metaClass.invokeMethod(client, name, args)
        def rxResult = rxSqs.metaClass.invokeMethod(rxSqs, name, args)
        TestSubscriber subscriber = new TestSubscriber()
        rxResult.subscribe(subscriber)
        subscriber.awaitTerminalEvent()
        subscriber.assertValue(result)
        Void
    }
}

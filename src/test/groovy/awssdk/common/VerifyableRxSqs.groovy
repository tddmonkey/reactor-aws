package awssdk.common

import awssdk.dsl.AssertableDualResponse
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import rx.observers.TestSubscriber
import tddmonkey.rxsqs.awssdk.AmazonSdkRxSqs

class VerifyableRxSqs {
    AmazonSQSAsyncClient client
    @Lazy private AmazonSdkRxSqs rxSqs = new AmazonSdkRxSqs(client)

    @Override
    AssertableDualResponse invokeMethod(String name, Object args) {
        def result = client.metaClass.invokeMethod(client, name, args)
        def rxResult = rxSqs.metaClass.invokeMethod(rxSqs, name, args)
        return new AssertableDualResponse(awsResult: result, rxResult: rxResult)
    }
}

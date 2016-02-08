package tddmonkey.rxsqs.awssdk;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.*;
import rx.Observable;

public class AmazonSdkRxSqs {
  private final AmazonSQSAsync amazonClient;

  public AmazonSdkRxSqs(AmazonSQSAsync amazonClient) {
    this.amazonClient = amazonClient;
  }

  public Observable<Void> addPermission(AddPermissionRequest addPermissionRequest) {
    return Observable.create(subscriber -> amazonClient.addPermissionAsync(addPermissionRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> changeMessageVisibility(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) {
    return Observable.create(subscriber -> amazonClient.changeMessageVisibilityAsync(changeMessageVisibilityRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatch(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) {
    return Observable.create(subscriber -> amazonClient.changeMessageVisibilityBatchAsync(changeMessageVisibilityBatchRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<CreateQueueResult> createQueue(String string) {
    return Observable.create(subscriber -> amazonClient.createQueueAsync(string, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<CreateQueueResult> createQueue(CreateQueueRequest createQueueRequest) {
    return Observable.create(subscriber -> amazonClient.createQueueAsync(createQueueRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> deleteMessage(DeleteMessageRequest deleteMessageRequest) {
    return Observable.create(subscriber -> amazonClient.deleteMessageAsync(deleteMessageRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<DeleteMessageBatchResult> deleteMessageBatch(DeleteMessageBatchRequest deleteMessageBatchRequest) {
    return Observable.create(subscriber -> amazonClient.deleteMessageBatchAsync(deleteMessageBatchRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> deleteQueue(String string) {
    return Observable.create(subscriber -> amazonClient.deleteQueueAsync(string, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> deleteQueue(DeleteQueueRequest deleteQueueRequest) {
    return Observable.create(subscriber -> amazonClient.deleteQueueAsync(deleteQueueRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<GetQueueAttributesResult> getQueueAttributes(GetQueueAttributesRequest getQueueAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.getQueueAttributesAsync(getQueueAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetQueueUrlResult> getQueueUrl(String string) {
    return Observable.create(subscriber -> amazonClient.getQueueUrlAsync(string, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetQueueUrlResult> getQueueUrl(GetQueueUrlRequest getQueueUrlRequest) {
    return Observable.create(subscriber -> amazonClient.getQueueUrlAsync(getQueueUrlRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListDeadLetterSourceQueuesResult> listDeadLetterSourceQueues(ListDeadLetterSourceQueuesRequest listDeadLetterSourceQueuesRequest) {
    return Observable.create(subscriber -> amazonClient.listDeadLetterSourceQueuesAsync(listDeadLetterSourceQueuesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListQueuesResult> listQueues(String string) {
    return Observable.create(subscriber -> amazonClient.listQueuesAsync(string, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListQueuesResult> listQueues(ListQueuesRequest listQueuesRequest) {
    return Observable.create(subscriber -> amazonClient.listQueuesAsync(listQueuesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> purgeQueue(PurgeQueueRequest purgeQueueRequest) {
    return Observable.create(subscriber -> amazonClient.purgeQueueAsync(purgeQueueRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<ReceiveMessageResult> receiveMessage(String string) {
    return Observable.create(subscriber -> amazonClient.receiveMessageAsync(string, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ReceiveMessageResult> receiveMessage(ReceiveMessageRequest receiveMessageRequest) {
    return Observable.create(subscriber -> amazonClient.receiveMessageAsync(receiveMessageRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> removePermission(RemovePermissionRequest removePermissionRequest) {
    return Observable.create(subscriber -> amazonClient.removePermissionAsync(removePermissionRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<SendMessageResult> sendMessage(SendMessageRequest sendMessageRequest) {
    return Observable.create(subscriber -> amazonClient.sendMessageAsync(sendMessageRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<SendMessageBatchResult> sendMessageBatch(SendMessageBatchRequest sendMessageBatchRequest) {
    return Observable.create(subscriber -> amazonClient.sendMessageBatchAsync(sendMessageBatchRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> setQueueAttributes(SetQueueAttributesRequest setQueueAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.setQueueAttributesAsync(setQueueAttributesRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }
}

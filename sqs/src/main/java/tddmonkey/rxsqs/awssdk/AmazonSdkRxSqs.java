package tddmonkey.rxsqs.awssdk;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.AddPermissionRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResult;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResult;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesRequest;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesResult;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.PurgeQueueRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.RemovePermissionRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.amazonaws.services.sqs.model.SetQueueAttributesRequest;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import rx.Observable;
import tddmonkey.rxaws.common.AmazonWebServiceRequestAsyncHandler;

public class AmazonSdkRxSqs {
  private final AmazonSQSAsync amazonClient;

  public AmazonSdkRxSqs(AmazonSQSAsync amazonClient) {
    this.amazonClient = amazonClient;
  }

  public Observable<Void> addPermission(String queueUrl, String label, List<String> aWSAccountIds, List<String> actions) {
    return Observable.create(subscriber -> amazonClient.addPermissionAsync(queueUrl, label, aWSAccountIds, actions, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> addPermission(AddPermissionRequest addPermissionRequest) {
    return Observable.create(subscriber -> amazonClient.addPermissionAsync(addPermissionRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> changeMessageVisibility(String queueUrl, String receiptHandle, Integer visibilityTimeout) {
    return Observable.create(subscriber -> amazonClient.changeMessageVisibilityAsync(queueUrl, receiptHandle, visibilityTimeout, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> changeMessageVisibility(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) {
    return Observable.create(subscriber -> amazonClient.changeMessageVisibilityAsync(changeMessageVisibilityRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatch(String queueUrl, List<ChangeMessageVisibilityBatchRequestEntry> entries) {
    return Observable.create(subscriber -> amazonClient.changeMessageVisibilityBatchAsync(queueUrl, entries, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatch(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) {
    return Observable.create(subscriber -> amazonClient.changeMessageVisibilityBatchAsync(changeMessageVisibilityBatchRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<CreateQueueResult> createQueue(String queueName) {
    return Observable.create(subscriber -> amazonClient.createQueueAsync(queueName, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<CreateQueueResult> createQueue(CreateQueueRequest createQueueRequest) {
    return Observable.create(subscriber -> amazonClient.createQueueAsync(createQueueRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> deleteMessage(String queueUrl, String receiptHandle) {
    return Observable.create(subscriber -> amazonClient.deleteMessageAsync(queueUrl, receiptHandle, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> deleteMessage(DeleteMessageRequest deleteMessageRequest) {
    return Observable.create(subscriber -> amazonClient.deleteMessageAsync(deleteMessageRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<DeleteMessageBatchResult> deleteMessageBatch(String queueUrl, List<DeleteMessageBatchRequestEntry> entries) {
    return Observable.create(subscriber -> amazonClient.deleteMessageBatchAsync(queueUrl, entries, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<DeleteMessageBatchResult> deleteMessageBatch(DeleteMessageBatchRequest deleteMessageBatchRequest) {
    return Observable.create(subscriber -> amazonClient.deleteMessageBatchAsync(deleteMessageBatchRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> deleteQueue(String queueUrl) {
    return Observable.create(subscriber -> amazonClient.deleteQueueAsync(queueUrl, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> deleteQueue(DeleteQueueRequest deleteQueueRequest) {
    return Observable.create(subscriber -> amazonClient.deleteQueueAsync(deleteQueueRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<GetQueueAttributesResult> getQueueAttributes(String queueUrl, List<String> attributeNames) {
    return Observable.create(subscriber -> amazonClient.getQueueAttributesAsync(queueUrl, attributeNames, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetQueueAttributesResult> getQueueAttributes(GetQueueAttributesRequest getQueueAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.getQueueAttributesAsync(getQueueAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetQueueUrlResult> getQueueUrl(String queueName) {
    return Observable.create(subscriber -> amazonClient.getQueueUrlAsync(queueName, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetQueueUrlResult> getQueueUrl(GetQueueUrlRequest getQueueUrlRequest) {
    return Observable.create(subscriber -> amazonClient.getQueueUrlAsync(getQueueUrlRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListDeadLetterSourceQueuesResult> listDeadLetterSourceQueues(ListDeadLetterSourceQueuesRequest listDeadLetterSourceQueuesRequest) {
    return Observable.create(subscriber -> amazonClient.listDeadLetterSourceQueuesAsync(listDeadLetterSourceQueuesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListQueuesResult> listQueues(String queueNamePrefix) {
    return Observable.create(subscriber -> amazonClient.listQueuesAsync(queueNamePrefix, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListQueuesResult> listQueues(ListQueuesRequest listQueuesRequest) {
    return Observable.create(subscriber -> amazonClient.listQueuesAsync(listQueuesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> purgeQueue(PurgeQueueRequest purgeQueueRequest) {
    return Observable.create(subscriber -> amazonClient.purgeQueueAsync(purgeQueueRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<ReceiveMessageResult> receiveMessage(String queueUrl) {
    return Observable.create(subscriber -> amazonClient.receiveMessageAsync(queueUrl, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ReceiveMessageResult> receiveMessage(ReceiveMessageRequest receiveMessageRequest) {
    return Observable.create(subscriber -> amazonClient.receiveMessageAsync(receiveMessageRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> removePermission(String queueUrl, String label) {
    return Observable.create(subscriber -> amazonClient.removePermissionAsync(queueUrl, label, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> removePermission(RemovePermissionRequest removePermissionRequest) {
    return Observable.create(subscriber -> amazonClient.removePermissionAsync(removePermissionRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<SendMessageResult> sendMessage(String queueUrl, String messageBody) {
    return Observable.create(subscriber -> amazonClient.sendMessageAsync(queueUrl, messageBody, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<SendMessageResult> sendMessage(SendMessageRequest sendMessageRequest) {
    return Observable.create(subscriber -> amazonClient.sendMessageAsync(sendMessageRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<SendMessageBatchResult> sendMessageBatch(String queueUrl, List<SendMessageBatchRequestEntry> entries) {
    return Observable.create(subscriber -> amazonClient.sendMessageBatchAsync(queueUrl, entries, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<SendMessageBatchResult> sendMessageBatch(SendMessageBatchRequest sendMessageBatchRequest) {
    return Observable.create(subscriber -> amazonClient.sendMessageBatchAsync(sendMessageBatchRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> setQueueAttributes(String queueUrl, Map<String, String> attributes) {
    return Observable.create(subscriber -> amazonClient.setQueueAttributesAsync(queueUrl, attributes, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> setQueueAttributes(SetQueueAttributesRequest setQueueAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.setQueueAttributesAsync(setQueueAttributesRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }
}

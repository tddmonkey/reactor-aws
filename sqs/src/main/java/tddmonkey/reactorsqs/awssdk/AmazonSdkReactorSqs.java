package tddmonkey.reactorsqs.awssdk;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.AddPermissionRequest;
import com.amazonaws.services.sqs.model.AddPermissionResult;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResult;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityResult;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResult;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.DeleteQueueResult;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesRequest;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesResult;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.PurgeQueueRequest;
import com.amazonaws.services.sqs.model.PurgeQueueResult;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.RemovePermissionRequest;
import com.amazonaws.services.sqs.model.RemovePermissionResult;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.amazonaws.services.sqs.model.SetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.SetQueueAttributesResult;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import reactor.core.publisher.Mono;
import tddmonkey.reactoraws.common.AmazonWebServiceRequestAsyncHandler;

public class AmazonSdkReactorSqs {
  private final AmazonSQSAsync amazonClient;

  public AmazonSdkReactorSqs(AmazonSQSAsync amazonClient) {
    this.amazonClient = amazonClient;
  }

  public Mono<ChangeMessageVisibilityResult> changeMessageVisibility(String queueUrl, String receiptHandle, Integer visibilityTimeout) {
    return Mono.create(subscriber -> amazonClient.changeMessageVisibilityAsync(queueUrl, receiptHandle, visibilityTimeout, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ChangeMessageVisibilityResult> changeMessageVisibility(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) {
    return Mono.create(subscriber -> amazonClient.changeMessageVisibilityAsync(changeMessageVisibilityRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<AddPermissionResult> addPermission(AddPermissionRequest addPermissionRequest) {
    return Mono.create(subscriber -> amazonClient.addPermissionAsync(addPermissionRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<AddPermissionResult> addPermission(String queueUrl, String label, List<String> aWSAccountIds, List<String> actions) {
    return Mono.create(subscriber -> amazonClient.addPermissionAsync(queueUrl, label, aWSAccountIds, actions, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatch(String queueUrl, List<ChangeMessageVisibilityBatchRequestEntry> entries) {
    return Mono.create(subscriber -> amazonClient.changeMessageVisibilityBatchAsync(queueUrl, entries, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatch(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) {
    return Mono.create(subscriber -> amazonClient.changeMessageVisibilityBatchAsync(changeMessageVisibilityBatchRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<CreateQueueResult> createQueue(String queueName) {
    return Mono.create(subscriber -> amazonClient.createQueueAsync(queueName, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<CreateQueueResult> createQueue(CreateQueueRequest createQueueRequest) {
    return Mono.create(subscriber -> amazonClient.createQueueAsync(createQueueRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteMessageResult> deleteMessage(String queueUrl, String receiptHandle) {
    return Mono.create(subscriber -> amazonClient.deleteMessageAsync(queueUrl, receiptHandle, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteMessageResult> deleteMessage(DeleteMessageRequest deleteMessageRequest) {
    return Mono.create(subscriber -> amazonClient.deleteMessageAsync(deleteMessageRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteMessageBatchResult> deleteMessageBatch(String queueUrl, List<DeleteMessageBatchRequestEntry> entries) {
    return Mono.create(subscriber -> amazonClient.deleteMessageBatchAsync(queueUrl, entries, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteMessageBatchResult> deleteMessageBatch(DeleteMessageBatchRequest deleteMessageBatchRequest) {
    return Mono.create(subscriber -> amazonClient.deleteMessageBatchAsync(deleteMessageBatchRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteQueueResult> deleteQueue(String queueUrl) {
    return Mono.create(subscriber -> amazonClient.deleteQueueAsync(queueUrl, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteQueueResult> deleteQueue(DeleteQueueRequest deleteQueueRequest) {
    return Mono.create(subscriber -> amazonClient.deleteQueueAsync(deleteQueueRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetQueueAttributesResult> getQueueAttributes(String queueUrl, List<String> attributeNames) {
    return Mono.create(subscriber -> amazonClient.getQueueAttributesAsync(queueUrl, attributeNames, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetQueueAttributesResult> getQueueAttributes(GetQueueAttributesRequest getQueueAttributesRequest) {
    return Mono.create(subscriber -> amazonClient.getQueueAttributesAsync(getQueueAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetQueueUrlResult> getQueueUrl(String queueName) {
    return Mono.create(subscriber -> amazonClient.getQueueUrlAsync(queueName, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetQueueUrlResult> getQueueUrl(GetQueueUrlRequest getQueueUrlRequest) {
    return Mono.create(subscriber -> amazonClient.getQueueUrlAsync(getQueueUrlRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListDeadLetterSourceQueuesResult> listDeadLetterSourceQueues(ListDeadLetterSourceQueuesRequest listDeadLetterSourceQueuesRequest) {
    return Mono.create(subscriber -> amazonClient.listDeadLetterSourceQueuesAsync(listDeadLetterSourceQueuesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListQueuesResult> listQueues(String queueNamePrefix) {
    return Mono.create(subscriber -> amazonClient.listQueuesAsync(queueNamePrefix, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListQueuesResult> listQueues(ListQueuesRequest listQueuesRequest) {
    return Mono.create(subscriber -> amazonClient.listQueuesAsync(listQueuesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<PurgeQueueResult> purgeQueue(PurgeQueueRequest purgeQueueRequest) {
    return Mono.create(subscriber -> amazonClient.purgeQueueAsync(purgeQueueRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ReceiveMessageResult> receiveMessage(String queueUrl) {
    return Mono.create(subscriber -> amazonClient.receiveMessageAsync(queueUrl, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ReceiveMessageResult> receiveMessage(ReceiveMessageRequest receiveMessageRequest) {
    return Mono.create(subscriber -> amazonClient.receiveMessageAsync(receiveMessageRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<RemovePermissionResult> removePermission(String queueUrl, String label) {
    return Mono.create(subscriber -> amazonClient.removePermissionAsync(queueUrl, label, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<RemovePermissionResult> removePermission(RemovePermissionRequest removePermissionRequest) {
    return Mono.create(subscriber -> amazonClient.removePermissionAsync(removePermissionRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SendMessageResult> sendMessage(String queueUrl, String messageBody) {
    return Mono.create(subscriber -> amazonClient.sendMessageAsync(queueUrl, messageBody, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SendMessageResult> sendMessage(SendMessageRequest sendMessageRequest) {
    return Mono.create(subscriber -> amazonClient.sendMessageAsync(sendMessageRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SendMessageBatchResult> sendMessageBatch(String queueUrl, List<SendMessageBatchRequestEntry> entries) {
    return Mono.create(subscriber -> amazonClient.sendMessageBatchAsync(queueUrl, entries, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SendMessageBatchResult> sendMessageBatch(SendMessageBatchRequest sendMessageBatchRequest) {
    return Mono.create(subscriber -> amazonClient.sendMessageBatchAsync(sendMessageBatchRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SetQueueAttributesResult> setQueueAttributes(String queueUrl, Map<String, String> attributes) {
    return Mono.create(subscriber -> amazonClient.setQueueAttributesAsync(queueUrl, attributes, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SetQueueAttributesResult> setQueueAttributes(SetQueueAttributesRequest setQueueAttributesRequest) {
    return Mono.create(subscriber -> amazonClient.setQueueAttributesAsync(setQueueAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }
}

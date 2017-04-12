package tddmonkey.reactorsns.awssdk;

import com.amazonaws.services.sns.AmazonSNSAsync;
import com.amazonaws.services.sns.model.AddPermissionRequest;
import com.amazonaws.services.sns.model.AddPermissionResult;
import com.amazonaws.services.sns.model.CheckIfPhoneNumberIsOptedOutRequest;
import com.amazonaws.services.sns.model.CheckIfPhoneNumberIsOptedOutResult;
import com.amazonaws.services.sns.model.ConfirmSubscriptionRequest;
import com.amazonaws.services.sns.model.ConfirmSubscriptionResult;
import com.amazonaws.services.sns.model.CreatePlatformApplicationRequest;
import com.amazonaws.services.sns.model.CreatePlatformApplicationResult;
import com.amazonaws.services.sns.model.CreatePlatformEndpointRequest;
import com.amazonaws.services.sns.model.CreatePlatformEndpointResult;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.DeleteEndpointRequest;
import com.amazonaws.services.sns.model.DeleteEndpointResult;
import com.amazonaws.services.sns.model.DeletePlatformApplicationRequest;
import com.amazonaws.services.sns.model.DeletePlatformApplicationResult;
import com.amazonaws.services.sns.model.DeleteTopicRequest;
import com.amazonaws.services.sns.model.DeleteTopicResult;
import com.amazonaws.services.sns.model.GetEndpointAttributesRequest;
import com.amazonaws.services.sns.model.GetEndpointAttributesResult;
import com.amazonaws.services.sns.model.GetPlatformApplicationAttributesRequest;
import com.amazonaws.services.sns.model.GetPlatformApplicationAttributesResult;
import com.amazonaws.services.sns.model.GetSMSAttributesRequest;
import com.amazonaws.services.sns.model.GetSMSAttributesResult;
import com.amazonaws.services.sns.model.GetSubscriptionAttributesRequest;
import com.amazonaws.services.sns.model.GetSubscriptionAttributesResult;
import com.amazonaws.services.sns.model.GetTopicAttributesRequest;
import com.amazonaws.services.sns.model.GetTopicAttributesResult;
import com.amazonaws.services.sns.model.ListEndpointsByPlatformApplicationRequest;
import com.amazonaws.services.sns.model.ListEndpointsByPlatformApplicationResult;
import com.amazonaws.services.sns.model.ListPhoneNumbersOptedOutRequest;
import com.amazonaws.services.sns.model.ListPhoneNumbersOptedOutResult;
import com.amazonaws.services.sns.model.ListPlatformApplicationsRequest;
import com.amazonaws.services.sns.model.ListPlatformApplicationsResult;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.services.sns.model.ListSubscriptionsRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsResult;
import com.amazonaws.services.sns.model.ListTopicsRequest;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.OptInPhoneNumberRequest;
import com.amazonaws.services.sns.model.OptInPhoneNumberResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.RemovePermissionRequest;
import com.amazonaws.services.sns.model.RemovePermissionResult;
import com.amazonaws.services.sns.model.SetEndpointAttributesRequest;
import com.amazonaws.services.sns.model.SetEndpointAttributesResult;
import com.amazonaws.services.sns.model.SetPlatformApplicationAttributesRequest;
import com.amazonaws.services.sns.model.SetPlatformApplicationAttributesResult;
import com.amazonaws.services.sns.model.SetSMSAttributesRequest;
import com.amazonaws.services.sns.model.SetSMSAttributesResult;
import com.amazonaws.services.sns.model.SetSubscriptionAttributesRequest;
import com.amazonaws.services.sns.model.SetSubscriptionAttributesResult;
import com.amazonaws.services.sns.model.SetTopicAttributesRequest;
import com.amazonaws.services.sns.model.SetTopicAttributesResult;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.amazonaws.services.sns.model.UnsubscribeRequest;
import com.amazonaws.services.sns.model.UnsubscribeResult;
import java.lang.String;
import java.util.List;
import reactor.core.publisher.Mono;
import tddmonkey.reactoraws.common.AmazonWebServiceRequestAsyncHandler;

public class AmazonSdkReactorSns {
  private final AmazonSNSAsync amazonClient;

  public AmazonSdkReactorSns(AmazonSNSAsync amazonClient) {
    this.amazonClient = amazonClient;
  }

  public Mono<CheckIfPhoneNumberIsOptedOutResult> checkIfPhoneNumberIsOptedOut(CheckIfPhoneNumberIsOptedOutRequest checkIfPhoneNumberIsOptedOutRequest) {
    return Mono.create(subscriber -> amazonClient.checkIfPhoneNumberIsOptedOutAsync(checkIfPhoneNumberIsOptedOutRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ConfirmSubscriptionResult> confirmSubscription(ConfirmSubscriptionRequest confirmSubscriptionRequest) {
    return Mono.create(subscriber -> amazonClient.confirmSubscriptionAsync(confirmSubscriptionRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ConfirmSubscriptionResult> confirmSubscription(String topicArn, String token, String authenticateOnUnsubscribe) {
    return Mono.create(subscriber -> amazonClient.confirmSubscriptionAsync(topicArn, token, authenticateOnUnsubscribe, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ConfirmSubscriptionResult> confirmSubscription(String topicArn, String token) {
    return Mono.create(subscriber -> amazonClient.confirmSubscriptionAsync(topicArn, token, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<CreatePlatformApplicationResult> createPlatformApplication(CreatePlatformApplicationRequest createPlatformApplicationRequest) {
    return Mono.create(subscriber -> amazonClient.createPlatformApplicationAsync(createPlatformApplicationRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<CreatePlatformEndpointResult> createPlatformEndpoint(CreatePlatformEndpointRequest createPlatformEndpointRequest) {
    return Mono.create(subscriber -> amazonClient.createPlatformEndpointAsync(createPlatformEndpointRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<CreateTopicResult> createTopic(CreateTopicRequest createTopicRequest) {
    return Mono.create(subscriber -> amazonClient.createTopicAsync(createTopicRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<CreateTopicResult> createTopic(String name) {
    return Mono.create(subscriber -> amazonClient.createTopicAsync(name, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteEndpointResult> deleteEndpoint(DeleteEndpointRequest deleteEndpointRequest) {
    return Mono.create(subscriber -> amazonClient.deleteEndpointAsync(deleteEndpointRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeletePlatformApplicationResult> deletePlatformApplication(DeletePlatformApplicationRequest deletePlatformApplicationRequest) {
    return Mono.create(subscriber -> amazonClient.deletePlatformApplicationAsync(deletePlatformApplicationRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteTopicResult> deleteTopic(String topicArn) {
    return Mono.create(subscriber -> amazonClient.deleteTopicAsync(topicArn, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteTopicResult> deleteTopic(DeleteTopicRequest deleteTopicRequest) {
    return Mono.create(subscriber -> amazonClient.deleteTopicAsync(deleteTopicRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetEndpointAttributesResult> getEndpointAttributes(GetEndpointAttributesRequest getEndpointAttributesRequest) {
    return Mono.create(subscriber -> amazonClient.getEndpointAttributesAsync(getEndpointAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetPlatformApplicationAttributesResult> getPlatformApplicationAttributes(GetPlatformApplicationAttributesRequest getPlatformApplicationAttributesRequest) {
    return Mono.create(subscriber -> amazonClient.getPlatformApplicationAttributesAsync(getPlatformApplicationAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetSMSAttributesResult> getSMSAttributes(GetSMSAttributesRequest getSMSAttributesRequest) {
    return Mono.create(subscriber -> amazonClient.getSMSAttributesAsync(getSMSAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetSubscriptionAttributesResult> getSubscriptionAttributes(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest) {
    return Mono.create(subscriber -> amazonClient.getSubscriptionAttributesAsync(getSubscriptionAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetSubscriptionAttributesResult> getSubscriptionAttributes(String subscriptionArn) {
    return Mono.create(subscriber -> amazonClient.getSubscriptionAttributesAsync(subscriptionArn, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetTopicAttributesResult> getTopicAttributes(String topicArn) {
    return Mono.create(subscriber -> amazonClient.getTopicAttributesAsync(topicArn, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetTopicAttributesResult> getTopicAttributes(GetTopicAttributesRequest getTopicAttributesRequest) {
    return Mono.create(subscriber -> amazonClient.getTopicAttributesAsync(getTopicAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListEndpointsByPlatformApplicationResult> listEndpointsByPlatformApplication(ListEndpointsByPlatformApplicationRequest listEndpointsByPlatformApplicationRequest) {
    return Mono.create(subscriber -> amazonClient.listEndpointsByPlatformApplicationAsync(listEndpointsByPlatformApplicationRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListPhoneNumbersOptedOutResult> listPhoneNumbersOptedOut(ListPhoneNumbersOptedOutRequest listPhoneNumbersOptedOutRequest) {
    return Mono.create(subscriber -> amazonClient.listPhoneNumbersOptedOutAsync(listPhoneNumbersOptedOutRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListPlatformApplicationsResult> listPlatformApplications(ListPlatformApplicationsRequest listPlatformApplicationsRequest) {
    return Mono.create(subscriber -> amazonClient.listPlatformApplicationsAsync(listPlatformApplicationsRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListSubscriptionsResult> listSubscriptions(String nextToken) {
    return Mono.create(subscriber -> amazonClient.listSubscriptionsAsync(nextToken, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListSubscriptionsResult> listSubscriptions(ListSubscriptionsRequest listSubscriptionsRequest) {
    return Mono.create(subscriber -> amazonClient.listSubscriptionsAsync(listSubscriptionsRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListSubscriptionsByTopicResult> listSubscriptionsByTopic(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest) {
    return Mono.create(subscriber -> amazonClient.listSubscriptionsByTopicAsync(listSubscriptionsByTopicRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListSubscriptionsByTopicResult> listSubscriptionsByTopic(String topicArn) {
    return Mono.create(subscriber -> amazonClient.listSubscriptionsByTopicAsync(topicArn, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListSubscriptionsByTopicResult> listSubscriptionsByTopic(String topicArn, String nextToken) {
    return Mono.create(subscriber -> amazonClient.listSubscriptionsByTopicAsync(topicArn, nextToken, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListTopicsResult> listTopics(ListTopicsRequest listTopicsRequest) {
    return Mono.create(subscriber -> amazonClient.listTopicsAsync(listTopicsRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListTopicsResult> listTopics(String nextToken) {
    return Mono.create(subscriber -> amazonClient.listTopicsAsync(nextToken, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<OptInPhoneNumberResult> optInPhoneNumber(OptInPhoneNumberRequest optInPhoneNumberRequest) {
    return Mono.create(subscriber -> amazonClient.optInPhoneNumberAsync(optInPhoneNumberRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<PublishResult> publish(PublishRequest publishRequest) {
    return Mono.create(subscriber -> amazonClient.publishAsync(publishRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<PublishResult> publish(String topicArn, String message, String subject) {
    return Mono.create(subscriber -> amazonClient.publishAsync(topicArn, message, subject, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<PublishResult> publish(String topicArn, String message) {
    return Mono.create(subscriber -> amazonClient.publishAsync(topicArn, message, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SetEndpointAttributesResult> setEndpointAttributes(SetEndpointAttributesRequest setEndpointAttributesRequest) {
    return Mono.create(subscriber -> amazonClient.setEndpointAttributesAsync(setEndpointAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SetPlatformApplicationAttributesResult> setPlatformApplicationAttributes(SetPlatformApplicationAttributesRequest setPlatformApplicationAttributesRequest) {
    return Mono.create(subscriber -> amazonClient.setPlatformApplicationAttributesAsync(setPlatformApplicationAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SetSMSAttributesResult> setSMSAttributes(SetSMSAttributesRequest setSMSAttributesRequest) {
    return Mono.create(subscriber -> amazonClient.setSMSAttributesAsync(setSMSAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SetSubscriptionAttributesResult> setSubscriptionAttributes(String subscriptionArn, String attributeName, String attributeValue) {
    return Mono.create(subscriber -> amazonClient.setSubscriptionAttributesAsync(subscriptionArn, attributeName, attributeValue, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SetSubscriptionAttributesResult> setSubscriptionAttributes(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest) {
    return Mono.create(subscriber -> amazonClient.setSubscriptionAttributesAsync(setSubscriptionAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SetTopicAttributesResult> setTopicAttributes(SetTopicAttributesRequest setTopicAttributesRequest) {
    return Mono.create(subscriber -> amazonClient.setTopicAttributesAsync(setTopicAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SetTopicAttributesResult> setTopicAttributes(String topicArn, String attributeName, String attributeValue) {
    return Mono.create(subscriber -> amazonClient.setTopicAttributesAsync(topicArn, attributeName, attributeValue, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SubscribeResult> subscribe(String topicArn, String protocol, String endpoint) {
    return Mono.create(subscriber -> amazonClient.subscribeAsync(topicArn, protocol, endpoint, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<SubscribeResult> subscribe(SubscribeRequest subscribeRequest) {
    return Mono.create(subscriber -> amazonClient.subscribeAsync(subscribeRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<UnsubscribeResult> unsubscribe(UnsubscribeRequest unsubscribeRequest) {
    return Mono.create(subscriber -> amazonClient.unsubscribeAsync(unsubscribeRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<UnsubscribeResult> unsubscribe(String subscriptionArn) {
    return Mono.create(subscriber -> amazonClient.unsubscribeAsync(subscriptionArn, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<AddPermissionResult> addPermission(String topicArn, String label, List<String> aWSAccountIds, List<String> actionNames) {
    return Mono.create(subscriber -> amazonClient.addPermissionAsync(topicArn, label, aWSAccountIds, actionNames, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<AddPermissionResult> addPermission(AddPermissionRequest addPermissionRequest) {
    return Mono.create(subscriber -> amazonClient.addPermissionAsync(addPermissionRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<RemovePermissionResult> removePermission(String topicArn, String label) {
    return Mono.create(subscriber -> amazonClient.removePermissionAsync(topicArn, label, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<RemovePermissionResult> removePermission(RemovePermissionRequest removePermissionRequest) {
    return Mono.create(subscriber -> amazonClient.removePermissionAsync(removePermissionRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }
}

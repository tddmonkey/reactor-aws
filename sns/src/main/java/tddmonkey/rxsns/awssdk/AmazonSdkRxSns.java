package tddmonkey.rxsns.awssdk;

import com.amazonaws.services.sns.AmazonSNSAsync;
import com.amazonaws.services.sns.model.AddPermissionRequest;
import com.amazonaws.services.sns.model.ConfirmSubscriptionRequest;
import com.amazonaws.services.sns.model.ConfirmSubscriptionResult;
import com.amazonaws.services.sns.model.CreatePlatformApplicationRequest;
import com.amazonaws.services.sns.model.CreatePlatformApplicationResult;
import com.amazonaws.services.sns.model.CreatePlatformEndpointRequest;
import com.amazonaws.services.sns.model.CreatePlatformEndpointResult;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.DeleteEndpointRequest;
import com.amazonaws.services.sns.model.DeletePlatformApplicationRequest;
import com.amazonaws.services.sns.model.DeleteTopicRequest;
import com.amazonaws.services.sns.model.GetEndpointAttributesRequest;
import com.amazonaws.services.sns.model.GetEndpointAttributesResult;
import com.amazonaws.services.sns.model.GetPlatformApplicationAttributesRequest;
import com.amazonaws.services.sns.model.GetPlatformApplicationAttributesResult;
import com.amazonaws.services.sns.model.GetSubscriptionAttributesRequest;
import com.amazonaws.services.sns.model.GetSubscriptionAttributesResult;
import com.amazonaws.services.sns.model.GetTopicAttributesRequest;
import com.amazonaws.services.sns.model.GetTopicAttributesResult;
import com.amazonaws.services.sns.model.ListEndpointsByPlatformApplicationRequest;
import com.amazonaws.services.sns.model.ListEndpointsByPlatformApplicationResult;
import com.amazonaws.services.sns.model.ListPlatformApplicationsRequest;
import com.amazonaws.services.sns.model.ListPlatformApplicationsResult;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.services.sns.model.ListSubscriptionsRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsResult;
import com.amazonaws.services.sns.model.ListTopicsRequest;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.RemovePermissionRequest;
import com.amazonaws.services.sns.model.SetEndpointAttributesRequest;
import com.amazonaws.services.sns.model.SetPlatformApplicationAttributesRequest;
import com.amazonaws.services.sns.model.SetSubscriptionAttributesRequest;
import com.amazonaws.services.sns.model.SetTopicAttributesRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.amazonaws.services.sns.model.UnsubscribeRequest;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import rx.Observable;
import tddmonkey.rxaws.common.AmazonWebServiceRequestAsyncHandler;

public class AmazonSdkRxSns {
  private final AmazonSNSAsync amazonClient;

  public AmazonSdkRxSns(AmazonSNSAsync amazonClient) {
    this.amazonClient = amazonClient;
  }

  public Observable<Void> addPermission(String topicArn, String label, List<String> aWSAccountIds, List<String> actionNames) {
    return Observable.create(subscriber -> amazonClient.addPermissionAsync(topicArn, label, aWSAccountIds, actionNames, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> addPermission(AddPermissionRequest addPermissionRequest) {
    return Observable.create(subscriber -> amazonClient.addPermissionAsync(addPermissionRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<ConfirmSubscriptionResult> confirmSubscription(String topicArn, String token, String authenticateOnUnsubscribe) {
    return Observable.create(subscriber -> amazonClient.confirmSubscriptionAsync(topicArn, token, authenticateOnUnsubscribe, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ConfirmSubscriptionResult> confirmSubscription(String topicArn, String token) {
    return Observable.create(subscriber -> amazonClient.confirmSubscriptionAsync(topicArn, token, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ConfirmSubscriptionResult> confirmSubscription(ConfirmSubscriptionRequest confirmSubscriptionRequest) {
    return Observable.create(subscriber -> amazonClient.confirmSubscriptionAsync(confirmSubscriptionRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<CreatePlatformApplicationResult> createPlatformApplication(CreatePlatformApplicationRequest createPlatformApplicationRequest) {
    return Observable.create(subscriber -> amazonClient.createPlatformApplicationAsync(createPlatformApplicationRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<CreatePlatformEndpointResult> createPlatformEndpoint(CreatePlatformEndpointRequest createPlatformEndpointRequest) {
    return Observable.create(subscriber -> amazonClient.createPlatformEndpointAsync(createPlatformEndpointRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<CreateTopicResult> createTopic(String name) {
    return Observable.create(subscriber -> amazonClient.createTopicAsync(name, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<CreateTopicResult> createTopic(CreateTopicRequest createTopicRequest) {
    return Observable.create(subscriber -> amazonClient.createTopicAsync(createTopicRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> deleteEndpoint(DeleteEndpointRequest deleteEndpointRequest) {
    return Observable.create(subscriber -> amazonClient.deleteEndpointAsync(deleteEndpointRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> deletePlatformApplication(DeletePlatformApplicationRequest deletePlatformApplicationRequest) {
    return Observable.create(subscriber -> amazonClient.deletePlatformApplicationAsync(deletePlatformApplicationRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> deleteTopic(String topicArn) {
    return Observable.create(subscriber -> amazonClient.deleteTopicAsync(topicArn, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> deleteTopic(DeleteTopicRequest deleteTopicRequest) {
    return Observable.create(subscriber -> amazonClient.deleteTopicAsync(deleteTopicRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<GetEndpointAttributesResult> getEndpointAttributes(GetEndpointAttributesRequest getEndpointAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.getEndpointAttributesAsync(getEndpointAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetPlatformApplicationAttributesResult> getPlatformApplicationAttributes(GetPlatformApplicationAttributesRequest getPlatformApplicationAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.getPlatformApplicationAttributesAsync(getPlatformApplicationAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetSubscriptionAttributesResult> getSubscriptionAttributes(String subscriptionArn) {
    return Observable.create(subscriber -> amazonClient.getSubscriptionAttributesAsync(subscriptionArn, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetSubscriptionAttributesResult> getSubscriptionAttributes(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.getSubscriptionAttributesAsync(getSubscriptionAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetTopicAttributesResult> getTopicAttributes(String topicArn) {
    return Observable.create(subscriber -> amazonClient.getTopicAttributesAsync(topicArn, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetTopicAttributesResult> getTopicAttributes(GetTopicAttributesRequest getTopicAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.getTopicAttributesAsync(getTopicAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListEndpointsByPlatformApplicationResult> listEndpointsByPlatformApplication(ListEndpointsByPlatformApplicationRequest listEndpointsByPlatformApplicationRequest) {
    return Observable.create(subscriber -> amazonClient.listEndpointsByPlatformApplicationAsync(listEndpointsByPlatformApplicationRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListPlatformApplicationsResult> listPlatformApplications(ListPlatformApplicationsRequest listPlatformApplicationsRequest) {
    return Observable.create(subscriber -> amazonClient.listPlatformApplicationsAsync(listPlatformApplicationsRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListSubscriptionsResult> listSubscriptions(String nextToken) {
    return Observable.create(subscriber -> amazonClient.listSubscriptionsAsync(nextToken, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListSubscriptionsResult> listSubscriptions(ListSubscriptionsRequest listSubscriptionsRequest) {
    return Observable.create(subscriber -> amazonClient.listSubscriptionsAsync(listSubscriptionsRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListSubscriptionsByTopicResult> listSubscriptionsByTopic(String topicArn) {
    return Observable.create(subscriber -> amazonClient.listSubscriptionsByTopicAsync(topicArn, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListSubscriptionsByTopicResult> listSubscriptionsByTopic(String topicArn, String nextToken) {
    return Observable.create(subscriber -> amazonClient.listSubscriptionsByTopicAsync(topicArn, nextToken, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListSubscriptionsByTopicResult> listSubscriptionsByTopic(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest) {
    return Observable.create(subscriber -> amazonClient.listSubscriptionsByTopicAsync(listSubscriptionsByTopicRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListTopicsResult> listTopics(String nextToken) {
    return Observable.create(subscriber -> amazonClient.listTopicsAsync(nextToken, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListTopicsResult> listTopics(ListTopicsRequest listTopicsRequest) {
    return Observable.create(subscriber -> amazonClient.listTopicsAsync(listTopicsRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<PublishResult> publish(String topicArn, String message) {
    return Observable.create(subscriber -> amazonClient.publishAsync(topicArn, message, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<PublishResult> publish(String topicArn, String message, String subject) {
    return Observable.create(subscriber -> amazonClient.publishAsync(topicArn, message, subject, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<PublishResult> publish(PublishRequest publishRequest) {
    return Observable.create(subscriber -> amazonClient.publishAsync(publishRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> removePermission(String topicArn, String label) {
    return Observable.create(subscriber -> amazonClient.removePermissionAsync(topicArn, label, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> removePermission(RemovePermissionRequest removePermissionRequest) {
    return Observable.create(subscriber -> amazonClient.removePermissionAsync(removePermissionRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> setEndpointAttributes(SetEndpointAttributesRequest setEndpointAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.setEndpointAttributesAsync(setEndpointAttributesRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> setPlatformApplicationAttributes(SetPlatformApplicationAttributesRequest setPlatformApplicationAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.setPlatformApplicationAttributesAsync(setPlatformApplicationAttributesRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> setSubscriptionAttributes(String subscriptionArn, String attributeName, String attributeValue) {
    return Observable.create(subscriber -> amazonClient.setSubscriptionAttributesAsync(subscriptionArn, attributeName, attributeValue, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> setSubscriptionAttributes(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.setSubscriptionAttributesAsync(setSubscriptionAttributesRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> setTopicAttributes(String topicArn, String attributeName, String attributeValue) {
    return Observable.create(subscriber -> amazonClient.setTopicAttributesAsync(topicArn, attributeName, attributeValue, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> setTopicAttributes(SetTopicAttributesRequest setTopicAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.setTopicAttributesAsync(setTopicAttributesRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<SubscribeResult> subscribe(String topicArn, String protocol, String endpoint) {
    return Observable.create(subscriber -> amazonClient.subscribeAsync(topicArn, protocol, endpoint, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<SubscribeResult> subscribe(SubscribeRequest subscribeRequest) {
    return Observable.create(subscriber -> amazonClient.subscribeAsync(subscribeRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> unsubscribe(String subscriptionArn) {
    return Observable.create(subscriber -> amazonClient.unsubscribeAsync(subscriptionArn, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> unsubscribe(UnsubscribeRequest unsubscribeRequest) {
    return Observable.create(subscriber -> amazonClient.unsubscribeAsync(unsubscribeRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }
}

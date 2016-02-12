package tddmonkey.rxsns.awssdk;

import com.amazonaws.services.sns.AmazonSNSAsync;
import com.amazonaws.services.sns.model.*;
import rx.Observable;
import tddmonkey.rxaws.common.AmazonWebServiceRequestAsyncHandler;

public class AmazonSdkRxSns {
  private final AmazonSNSAsync amazonClient;

  public AmazonSdkRxSns(AmazonSNSAsync amazonClient) {
    this.amazonClient = amazonClient;
  }

  public Observable<ConfirmSubscriptionResult> confirmSubscription(ConfirmSubscriptionRequest confirmSubscriptionRequest) {
    return Observable.create(subscriber -> amazonClient.confirmSubscriptionAsync(confirmSubscriptionRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> addPermission(AddPermissionRequest addPermissionRequest) {
    return Observable.create(subscriber -> amazonClient.addPermissionAsync(addPermissionRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<CreatePlatformApplicationResult> createPlatformApplication(CreatePlatformApplicationRequest createPlatformApplicationRequest) {
    return Observable.create(subscriber -> amazonClient.createPlatformApplicationAsync(createPlatformApplicationRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<CreatePlatformEndpointResult> createPlatformEndpoint(CreatePlatformEndpointRequest createPlatformEndpointRequest) {
    return Observable.create(subscriber -> amazonClient.createPlatformEndpointAsync(createPlatformEndpointRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<CreateTopicResult> createTopic(String string) {
    return Observable.create(subscriber -> amazonClient.createTopicAsync(string, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
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

  public Observable<Void> deleteTopic(String string) {
    return Observable.create(subscriber -> amazonClient.deleteTopicAsync(string, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
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

  public Observable<GetSubscriptionAttributesResult> getSubscriptionAttributes(String string) {
    return Observable.create(subscriber -> amazonClient.getSubscriptionAttributesAsync(string, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetSubscriptionAttributesResult> getSubscriptionAttributes(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.getSubscriptionAttributesAsync(getSubscriptionAttributesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetTopicAttributesResult> getTopicAttributes(String string) {
    return Observable.create(subscriber -> amazonClient.getTopicAttributesAsync(string, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
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

  public Observable<ListSubscriptionsResult> listSubscriptions(String string) {
    return Observable.create(subscriber -> amazonClient.listSubscriptionsAsync(string, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListSubscriptionsResult> listSubscriptions(ListSubscriptionsRequest listSubscriptionsRequest) {
    return Observable.create(subscriber -> amazonClient.listSubscriptionsAsync(listSubscriptionsRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListSubscriptionsByTopicResult> listSubscriptionsByTopic(String string) {
    return Observable.create(subscriber -> amazonClient.listSubscriptionsByTopicAsync(string, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListSubscriptionsByTopicResult> listSubscriptionsByTopic(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest) {
    return Observable.create(subscriber -> amazonClient.listSubscriptionsByTopicAsync(listSubscriptionsByTopicRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListTopicsResult> listTopics(String string) {
    return Observable.create(subscriber -> amazonClient.listTopicsAsync(string, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListTopicsResult> listTopics(ListTopicsRequest listTopicsRequest) {
    return Observable.create(subscriber -> amazonClient.listTopicsAsync(listTopicsRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<PublishResult> publish(PublishRequest publishRequest) {
    return Observable.create(subscriber -> amazonClient.publishAsync(publishRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
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

  public Observable<Void> setSubscriptionAttributes(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.setSubscriptionAttributesAsync(setSubscriptionAttributesRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> setTopicAttributes(SetTopicAttributesRequest setTopicAttributesRequest) {
    return Observable.create(subscriber -> amazonClient.setTopicAttributesAsync(setTopicAttributesRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<SubscribeResult> subscribe(SubscribeRequest subscribeRequest) {
    return Observable.create(subscriber -> amazonClient.subscribeAsync(subscribeRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<Void> unsubscribe(String string) {
    return Observable.create(subscriber -> amazonClient.unsubscribeAsync(string, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }

  public Observable<Void> unsubscribe(UnsubscribeRequest unsubscribeRequest) {
    return Observable.create(subscriber -> amazonClient.unsubscribeAsync(unsubscribeRequest, AmazonWebServiceRequestAsyncHandler.voidHandlerFor(subscriber)));
  }
}

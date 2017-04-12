package tddmonkey.reactordynamo.awssdk;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import com.amazonaws.services.dynamodbv2.model.DescribeLimitsRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveResult;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceRequest;
import com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.TagResourceRequest;
import com.amazonaws.services.dynamodbv2.model.TagResourceResult;
import com.amazonaws.services.dynamodbv2.model.UntagResourceRequest;
import com.amazonaws.services.dynamodbv2.model.UntagResourceResult;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateTableResult;
import com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveResult;
import com.amazonaws.services.dynamodbv2.model.WriteRequest;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import reactor.core.publisher.Mono;
import tddmonkey.reactoraws.common.AmazonWebServiceRequestAsyncHandler;

public class AmazonSdkReactorDynamoDb {
  private final AmazonDynamoDBAsync amazonClient;

  public AmazonSdkReactorDynamoDb(AmazonDynamoDBAsync amazonClient) {
    this.amazonClient = amazonClient;
  }

  public Mono<BatchGetItemResult> batchGetItem(Map<String, KeysAndAttributes> requestItems) {
    return Mono.create(subscriber -> amazonClient.batchGetItemAsync(requestItems, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<BatchGetItemResult> batchGetItem(Map<String, KeysAndAttributes> requestItems, String returnConsumedCapacity) {
    return Mono.create(subscriber -> amazonClient.batchGetItemAsync(requestItems, returnConsumedCapacity, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<BatchGetItemResult> batchGetItem(BatchGetItemRequest batchGetItemRequest) {
    return Mono.create(subscriber -> amazonClient.batchGetItemAsync(batchGetItemRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<BatchWriteItemResult> batchWriteItem(Map<String, List<WriteRequest>> requestItems) {
    return Mono.create(subscriber -> amazonClient.batchWriteItemAsync(requestItems, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<BatchWriteItemResult> batchWriteItem(BatchWriteItemRequest batchWriteItemRequest) {
    return Mono.create(subscriber -> amazonClient.batchWriteItemAsync(batchWriteItemRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<CreateTableResult> createTable(List<AttributeDefinition> attributeDefinitions, String tableName, List<KeySchemaElement> keySchema, ProvisionedThroughput provisionedThroughput) {
    return Mono.create(subscriber -> amazonClient.createTableAsync(attributeDefinitions, tableName, keySchema, provisionedThroughput, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<CreateTableResult> createTable(CreateTableRequest createTableRequest) {
    return Mono.create(subscriber -> amazonClient.createTableAsync(createTableRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteItemResult> deleteItem(String tableName, Map<String, AttributeValue> key) {
    return Mono.create(subscriber -> amazonClient.deleteItemAsync(tableName, key, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteItemResult> deleteItem(String tableName, Map<String, AttributeValue> key, String returnValues) {
    return Mono.create(subscriber -> amazonClient.deleteItemAsync(tableName, key, returnValues, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteItemResult> deleteItem(DeleteItemRequest deleteItemRequest) {
    return Mono.create(subscriber -> amazonClient.deleteItemAsync(deleteItemRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteTableResult> deleteTable(String tableName) {
    return Mono.create(subscriber -> amazonClient.deleteTableAsync(tableName, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DeleteTableResult> deleteTable(DeleteTableRequest deleteTableRequest) {
    return Mono.create(subscriber -> amazonClient.deleteTableAsync(deleteTableRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DescribeLimitsResult> describeLimits(DescribeLimitsRequest describeLimitsRequest) {
    return Mono.create(subscriber -> amazonClient.describeLimitsAsync(describeLimitsRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DescribeTableResult> describeTable(String tableName) {
    return Mono.create(subscriber -> amazonClient.describeTableAsync(tableName, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DescribeTableResult> describeTable(DescribeTableRequest describeTableRequest) {
    return Mono.create(subscriber -> amazonClient.describeTableAsync(describeTableRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<DescribeTimeToLiveResult> describeTimeToLive(DescribeTimeToLiveRequest describeTimeToLiveRequest) {
    return Mono.create(subscriber -> amazonClient.describeTimeToLiveAsync(describeTimeToLiveRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetItemResult> getItem(String tableName, Map<String, AttributeValue> key) {
    return Mono.create(subscriber -> amazonClient.getItemAsync(tableName, key, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetItemResult> getItem(String tableName, Map<String, AttributeValue> key, Boolean consistentRead) {
    return Mono.create(subscriber -> amazonClient.getItemAsync(tableName, key, consistentRead, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<GetItemResult> getItem(GetItemRequest getItemRequest) {
    return Mono.create(subscriber -> amazonClient.getItemAsync(getItemRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListTablesResult> listTables(String exclusiveStartTableName, Integer limit) {
    return Mono.create(subscriber -> amazonClient.listTablesAsync(exclusiveStartTableName, limit, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListTablesResult> listTables(String exclusiveStartTableName) {
    return Mono.create(subscriber -> amazonClient.listTablesAsync(exclusiveStartTableName, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListTablesResult> listTables(Integer limit) {
    return Mono.create(subscriber -> amazonClient.listTablesAsync(limit, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListTablesResult> listTables(ListTablesRequest listTablesRequest) {
    return Mono.create(subscriber -> amazonClient.listTablesAsync(listTablesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ListTagsOfResourceResult> listTagsOfResource(ListTagsOfResourceRequest listTagsOfResourceRequest) {
    return Mono.create(subscriber -> amazonClient.listTagsOfResourceAsync(listTagsOfResourceRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<PutItemResult> putItem(String tableName, Map<String, AttributeValue> item) {
    return Mono.create(subscriber -> amazonClient.putItemAsync(tableName, item, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<PutItemResult> putItem(String tableName, Map<String, AttributeValue> item, String returnValues) {
    return Mono.create(subscriber -> amazonClient.putItemAsync(tableName, item, returnValues, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<PutItemResult> putItem(PutItemRequest putItemRequest) {
    return Mono.create(subscriber -> amazonClient.putItemAsync(putItemRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<QueryResult> query(QueryRequest queryRequest) {
    return Mono.create(subscriber -> amazonClient.queryAsync(queryRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ScanResult> scan(String tableName, Map<String, Condition> scanFilter) {
    return Mono.create(subscriber -> amazonClient.scanAsync(tableName, scanFilter, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ScanResult> scan(String tableName, List<String> attributesToGet, Map<String, Condition> scanFilter) {
    return Mono.create(subscriber -> amazonClient.scanAsync(tableName, attributesToGet, scanFilter, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ScanResult> scan(ScanRequest scanRequest) {
    return Mono.create(subscriber -> amazonClient.scanAsync(scanRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<ScanResult> scan(String tableName, List<String> attributesToGet) {
    return Mono.create(subscriber -> amazonClient.scanAsync(tableName, attributesToGet, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<TagResourceResult> tagResource(TagResourceRequest tagResourceRequest) {
    return Mono.create(subscriber -> amazonClient.tagResourceAsync(tagResourceRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<UntagResourceResult> untagResource(UntagResourceRequest untagResourceRequest) {
    return Mono.create(subscriber -> amazonClient.untagResourceAsync(untagResourceRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<UpdateItemResult> updateItem(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates) {
    return Mono.create(subscriber -> amazonClient.updateItemAsync(tableName, key, attributeUpdates, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<UpdateItemResult> updateItem(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates, String returnValues) {
    return Mono.create(subscriber -> amazonClient.updateItemAsync(tableName, key, attributeUpdates, returnValues, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<UpdateItemResult> updateItem(UpdateItemRequest updateItemRequest) {
    return Mono.create(subscriber -> amazonClient.updateItemAsync(updateItemRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<UpdateTableResult> updateTable(String tableName, ProvisionedThroughput provisionedThroughput) {
    return Mono.create(subscriber -> amazonClient.updateTableAsync(tableName, provisionedThroughput, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<UpdateTableResult> updateTable(UpdateTableRequest updateTableRequest) {
    return Mono.create(subscriber -> amazonClient.updateTableAsync(updateTableRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Mono<UpdateTimeToLiveResult> updateTimeToLive(UpdateTimeToLiveRequest updateTimeToLiveRequest) {
    return Mono.create(subscriber -> amazonClient.updateTimeToLiveAsync(updateTimeToLiveRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }
}

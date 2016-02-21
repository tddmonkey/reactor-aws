package tddmonkey.rxdynamo.awssdk;

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
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateTableResult;
import com.amazonaws.services.dynamodbv2.model.WriteRequest;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import rx.Observable;
import tddmonkey.rxaws.common.AmazonWebServiceRequestAsyncHandler;

public class AmazonSdkRxDynamoDb {
  private final AmazonDynamoDBAsync amazonClient;

  public AmazonSdkRxDynamoDb(AmazonDynamoDBAsync amazonClient) {
    this.amazonClient = amazonClient;
  }

  public Observable<BatchGetItemResult> batchGetItem(Map<String, KeysAndAttributes> requestItems) {
    return Observable.create(subscriber -> amazonClient.batchGetItemAsync(requestItems, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<BatchGetItemResult> batchGetItem(Map<String, KeysAndAttributes> requestItems, String returnConsumedCapacity) {
    return Observable.create(subscriber -> amazonClient.batchGetItemAsync(requestItems, returnConsumedCapacity, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<BatchGetItemResult> batchGetItem(BatchGetItemRequest batchGetItemRequest) {
    return Observable.create(subscriber -> amazonClient.batchGetItemAsync(batchGetItemRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<BatchWriteItemResult> batchWriteItem(Map<String, List<WriteRequest>> requestItems) {
    return Observable.create(subscriber -> amazonClient.batchWriteItemAsync(requestItems, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<BatchWriteItemResult> batchWriteItem(BatchWriteItemRequest batchWriteItemRequest) {
    return Observable.create(subscriber -> amazonClient.batchWriteItemAsync(batchWriteItemRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<CreateTableResult> createTable(List<AttributeDefinition> attributeDefinitions, String tableName, List<KeySchemaElement> keySchema, ProvisionedThroughput provisionedThroughput) {
    return Observable.create(subscriber -> amazonClient.createTableAsync(attributeDefinitions, tableName, keySchema, provisionedThroughput, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<CreateTableResult> createTable(CreateTableRequest createTableRequest) {
    return Observable.create(subscriber -> amazonClient.createTableAsync(createTableRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<DeleteItemResult> deleteItem(String tableName, Map<String, AttributeValue> key) {
    return Observable.create(subscriber -> amazonClient.deleteItemAsync(tableName, key, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<DeleteItemResult> deleteItem(String tableName, Map<String, AttributeValue> key, String returnValues) {
    return Observable.create(subscriber -> amazonClient.deleteItemAsync(tableName, key, returnValues, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<DeleteItemResult> deleteItem(DeleteItemRequest deleteItemRequest) {
    return Observable.create(subscriber -> amazonClient.deleteItemAsync(deleteItemRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<DeleteTableResult> deleteTable(String tableName) {
    return Observable.create(subscriber -> amazonClient.deleteTableAsync(tableName, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<DeleteTableResult> deleteTable(DeleteTableRequest deleteTableRequest) {
    return Observable.create(subscriber -> amazonClient.deleteTableAsync(deleteTableRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<DescribeTableResult> describeTable(String tableName) {
    return Observable.create(subscriber -> amazonClient.describeTableAsync(tableName, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<DescribeTableResult> describeTable(DescribeTableRequest describeTableRequest) {
    return Observable.create(subscriber -> amazonClient.describeTableAsync(describeTableRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetItemResult> getItem(String tableName, Map<String, AttributeValue> key) {
    return Observable.create(subscriber -> amazonClient.getItemAsync(tableName, key, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetItemResult> getItem(String tableName, Map<String, AttributeValue> key, Boolean consistentRead) {
    return Observable.create(subscriber -> amazonClient.getItemAsync(tableName, key, consistentRead, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<GetItemResult> getItem(GetItemRequest getItemRequest) {
    return Observable.create(subscriber -> amazonClient.getItemAsync(getItemRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListTablesResult> listTables(String exclusiveStartTableName, Integer limit) {
    return Observable.create(subscriber -> amazonClient.listTablesAsync(exclusiveStartTableName, limit, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListTablesResult> listTables(String exclusiveStartTableName) {
    return Observable.create(subscriber -> amazonClient.listTablesAsync(exclusiveStartTableName, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListTablesResult> listTables(Integer limit) {
    return Observable.create(subscriber -> amazonClient.listTablesAsync(limit, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ListTablesResult> listTables(ListTablesRequest listTablesRequest) {
    return Observable.create(subscriber -> amazonClient.listTablesAsync(listTablesRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<PutItemResult> putItem(String tableName, Map<String, AttributeValue> item) {
    return Observable.create(subscriber -> amazonClient.putItemAsync(tableName, item, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<PutItemResult> putItem(String tableName, Map<String, AttributeValue> item, String returnValues) {
    return Observable.create(subscriber -> amazonClient.putItemAsync(tableName, item, returnValues, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<PutItemResult> putItem(PutItemRequest putItemRequest) {
    return Observable.create(subscriber -> amazonClient.putItemAsync(putItemRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<QueryResult> query(QueryRequest queryRequest) {
    return Observable.create(subscriber -> amazonClient.queryAsync(queryRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ScanResult> scan(String tableName, Map<String, Condition> scanFilter) {
    return Observable.create(subscriber -> amazonClient.scanAsync(tableName, scanFilter, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ScanResult> scan(String tableName, List<String> attributesToGet, Map<String, Condition> scanFilter) {
    return Observable.create(subscriber -> amazonClient.scanAsync(tableName, attributesToGet, scanFilter, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ScanResult> scan(ScanRequest scanRequest) {
    return Observable.create(subscriber -> amazonClient.scanAsync(scanRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<ScanResult> scan(String tableName, List<String> attributesToGet) {
    return Observable.create(subscriber -> amazonClient.scanAsync(tableName, attributesToGet, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<UpdateItemResult> updateItem(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates) {
    return Observable.create(subscriber -> amazonClient.updateItemAsync(tableName, key, attributeUpdates, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<UpdateItemResult> updateItem(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates, String returnValues) {
    return Observable.create(subscriber -> amazonClient.updateItemAsync(tableName, key, attributeUpdates, returnValues, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<UpdateItemResult> updateItem(UpdateItemRequest updateItemRequest) {
    return Observable.create(subscriber -> amazonClient.updateItemAsync(updateItemRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<UpdateTableResult> updateTable(String tableName, ProvisionedThroughput provisionedThroughput) {
    return Observable.create(subscriber -> amazonClient.updateTableAsync(tableName, provisionedThroughput, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }

  public Observable<UpdateTableResult> updateTable(UpdateTableRequest updateTableRequest) {
    return Observable.create(subscriber -> amazonClient.updateTableAsync(updateTableRequest, AmazonWebServiceRequestAsyncHandler.valueEmittingHandlerFor(subscriber)));
  }
}

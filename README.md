# reactor-aws

This project provides Spring Reactor abstractions over some of the AWS Java SDK

# Supported SDKs

SQS

SNS

DynamoDb

# Usage

All SDKs follow the same naming conventions, parameters and return types that the current clients do so that they can almost be used as a drop in replacement in your existing code.  For example, if you have code that performs a synchronous `listQueues` request for SQS like this:

```
ListQueuesResult listQueuesResult = amazonClient.listQueues(new ListQueuesRequest());
listQueuesResult.getQueueUrls().forEach(System.out::println);
```

This can be turned into an Rx call like this:

```
AmazonSdkReactorSqs reactorSqs = new AmazonSdkReactorSqs(amazonClient);
reactorSqs.listQueues(new ListQueuesRequest())
	.flatMapIterable(listQueuesResult -> listQueuesResult.getQueueUrls())
	.subscribe(System.out::println);
```

To receive messages, a synchronous call of this:

```
ReceiveMessageRequest request = new ReceiveMessageRequest()
	.withQueueUrl(queueUrl)
	.withMaxNumberOfMessages(1);
ReceiveMessageResult receiveMessageResult = amazonClient.receiveMessage(request);
receiveMessageResult.getMessages()
	.stream()
	.map(message -> message.getBody())
	.forEach(System.out::println);
```

Would become this:

```
AmazonSdkReactorSqs reactorSqs = new AmazonSdkReactorSqs(amazonClient);
ReceiveMessageRequest request = new ReceiveMessageRequest()
	.withQueueUrl(queueUrl)
	.withMaxNumberOfMessages(1);
reactorSqs.receiveMessage(request)
	.flatMapIterable(receiveMessageResult -> receiveMessageResult.getMessages())
	.map(message -> message.getBody())
	.subscribe(System.out::println);
```

The Reactor client must be instantiated with an Async version of the AWS SDK being used as the Reactor code performs an asynchronous call on your behalf.  Under the hood this is just a call to the relevant aws async method with a relevant Reactor handler.  For example, using the aws async interface for listing queues, the code would be like this:

```
amazonClient.listQueuesAsync(new ListQueuesRequest(), new AsyncHandler<ListQueuesRequest, ListQueuesResult>() {
	@Override
	public void onError(Exception exception) {
		// handle errors here
	}

	@Override
	public void onSuccess(ListQueuesRequest request, ListQueuesResult listQueuesResult) {
		// handle success here
	}
});
```

whereas with this library the call is a standard Reactor chain:

```
reactorSqs.listQueues(new ListQueuesRequest())
	.doOnError(t -> handleErrorsHere())
	.subscribe(listQueuesResult -> handleSuccessHere());
```

Building
========

The project is built using the Gradle wrapper and requires Java 1.8

Where are the tests?!
=====================

The code here is all fully generated and has no tests.  If you want to know more about the code generation see [The Generator Project](https://github.com/tddmonkey/rx-aws-generator)

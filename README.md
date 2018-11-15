# Workshop on Consumer-Driven Contracts

This repository points to some material that can be used in a hands-on workshop
to get a feel for Consumer-Driven Contracts with the frameworks [Pact](https://docs.pact.io/)
and / or [Spring Cloud Contract](https://cloud.spring.io/spring-cloud-contract/).

## Preparation

If you're new to Consumer-Driven Contracts, read [this article](https://reflectoring.io/7-reasons-for-consumer-driven-contracts/)
as an introduction to CDC.

The setup takes some time since dependencies have to be loaded from the internet.
So it makes sense to follow these steps in advance:

* make sure you have Java 8 installed
* for the Angular example, make sure you have the latest NodeJS installed
* clone this repository

## 1. REST Contracts

### Task #1: Define a REST contract

In a group of 2-3, dream up a use case and define a contract
between a REST consumer and a REST provider.

The contract should consist of 2-3 interactions (request / response pairs).

Per interaction, define

* the path of the request
* the HTTP method of the request
* potential request headers
* potential query parameters in the request
* the JSON structure of the request body
* the JSON structure of the response body
* the HTTP status code of the response
* potential response headers.

Write down the definition in a text file or on paper for later reference.

### REST Contracts with Java

#### Task #2: Implement a REST Consumer with Spring, Feign & Pact

1. Start with the code in the folder [consumer/pact-feign-consumer](consumer/pact-feign-consumer)
1. Go through the steps explained in [this tutorial](https://reflectoring.io/consumer-driven-contract-feign-pact/)
   to set up a consumer test that creates a pact file
   * use one interaction of the API you defined in Task #1 instead of the API described in the tutorial
   * choose different consumer and provider names to make your implementation unique
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/pact/pact-feign-consumer)
1. Run `./gradlew build` to run the tests and check that a pact file has been created in the folder `target/pacts`

#### Task #3: Implement a REST Provider with Spring & Pact

1. Start with the code in the folder [provider/pact-spring-provider](provider/pact-spring-provider)
1. Go through the steps explained in [this tutorial](https://reflectoring.io/consumer-driven-contract-provider-pact-spring/)
   to set up a Spring REST Controller that satisfies the contract from Task #1
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/pact/pact-spring-provider)
1. Run `./gradlew build` to run the provider test and check that it works

## Task #4: Implement a REST Consumer & Provider with Spring Cloud Contract 

1. Start with the code in the folders [consumer/scc-consumer](consumer/scc-consumer) and 
   [provider/scc-provider](provider/scc-provider)
1. Go through the steps explained in [this tutorial](https://reflectoring.io/consumer-driven-contract-consumer-spring-cloud-contract/)
   and [this tutorial](https://reflectoring.io/consumer-driven-contract-provider-spring-cloud-contract/)
   to set up a REST Consumer & Provider with Spring Cloud Contract
    * use one interaction of the API you defined in Task #1 instead of the API described in the tutorials
1. If you need orientation, have a look at the complete example: [consumer](https://github.com/thombergs/code-examples/tree/master/spring-cloud/spring-cloud-contract-consumer) and
   [producer](https://github.com/thombergs/code-examples/tree/master/spring-cloud/spring-cloud-contract-provider)
1. Run `./gradlew build` in the consumer and producer codebase to check that the consumer and producer tests work as 
   expected

#### Task #5: Use a Pact Broker

1. Insert the pact broker credentials you have been provided into the `pact` section of the `build.gradle` file of
   the consumer you created in Task #2
1. Run `./gradlew build` in the consumer code base to create the pact file
1. Run `./gradlew pactPublish` in the consumer code base to publish the pact to the broker
1. Visit the Pact Broker in your browser and check that the pact has been published
1. Replace the `@PactFolder` annotation in the provider test from Task #3 with the `@PactBroker` annotation to
   load the pact from the broker instead of from the file system

### REST Contracts with Node

#### Task #6 Implement a REST Consumer with Node / React & Pact
1. Start with an empty workspace
1. Go through the steps explained in [this tutorial](https://reflectoring.io/pact-react-consumer/)
   to set up a consumer test that creates a pact file
   * use one interaction of the API you defined in Task #1 instead of the API described in the tutorial
   * choose different consumer and provider names to make your implementation unique
   * to publish the contract on a pact broker, use the pact broker credentials you have been provided
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/pact/pact-react-consumer)
1. Run `npm run test:pact` to run the tests and check that a pact file has been created in the folder `./pacts`

#### Task #7: Implement a REST Consumer with Angular & Pact

1. Download and install the latest NodeJS distribution at [https://nodejs.org/en/download/](https://nodejs.org/en/download/)
1. Verify that npm and Node are installed properly by calling `node -v` and `npm -v`
1. Start with the code in the folder [consumer/pact-angular-consumer](consumer/pact-angular-consumer)
1. Run `npm install` in the folder and check that a `node_modules` folder has been created
1. Run `npm run test` to verify that the Angular tests run on your machine (you need to have Google Chrome installed)
1. Go through the steps explained in [this tutorial](https://reflectoring.io/consumer-driven-contracts-with-angular-and-pact/) 
   to set up a consumer test that creates a pact file
   * use one interaction of the API you defined in Task #1 instead of the API described in the tutorial
   * choose different consumer and provider names to make your implementation unique
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/pact/pact-angular)
1. Run `npm run test` again to run the tests and check that a pact file has been created in the `pacts` folder

#### Task #8: Implement a REST Provider with Node & Pact

1. Start with an empty workspace
1. Go through the steps explained in [this tutorial](https://reflectoring.io/pact-node-provider/)
   to set up a provider test against the contract you have created in task #5 or #6
   * to load the contract from the pact broker, use the pact broker credentials you have been provided
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/pact/pact-node-provider)
1. Run `npm run test:pact` to run the provider tests and check make the test pass

## Messaging Contracts

### Task #9: Define a Messaging Contract

In a group of 2-3, dream up a use case and define a contract
between a message consumer and a message producer.

* The contract should consist of one or two message types.
* Per message, define the JSON structure of the message body. 
* Write down the definition in a text file or on paper for later reference.

### Task #10: Implement a Spring Messaging Consumer & Provider with Pact 

1. Start with the code in the folders [consumer/pact-message-consumer](consumer/pact-message-consumer) and
   [provider/pact-message-producer](provider/pact-message-producer)
1. Go through the steps explained in [this tutorial](https://reflectoring.io/cdc-pact-messages/)
   to set up a Spring Messaging Consumer and Producer that satisfy the contract from Task #8
1. If you need orientation, have a look at the complete example: [consumer](https://github.com/thombergs/code-examples/tree/master/pact/pact-message-consumer) and
      [producer](https://github.com/thombergs/code-examples/tree/master/pact/pact-message-producer)
1. Run `./gradlew build` in the consumer and producer codebase to check that the consumer and producer tests work as 
      expected
      
### Task #11: Implement a Node Messaging Consumer & Provider with Pact 

1. Start with an empty workspace
1. Go through the steps explained in [this tutorial](https://reflectoring.io/pact-node-messaging/)
   to set up a Node Messaging Consumer and Producer that satisfy the contract from Task #8
1. If you need orientation, have a look at the complete example: [consumer](https://github.com/thombergs/code-examples/tree/master/pact/pact-node-messages) 
1. Run `npm run test:pact:consumer` and `npm run test:pact:provider` to check that the consumer and producer tests work as 
   expected

## GraphQL Contracts

### Task 12: Define a GraphQL Contract

In a group of 2-3, dream up a use case and define a GraphQL Schema

* The contract should consist of one or two interactions
* Write down the definition in a text file or on paper for later reference.

### Task #13: Implement a Node-based GraphQL Consumer with Pact

1. Start with an empty workspace
1. Go through the steps explained in [this tutorial](https://reflectoring.io/pact-node-graphql-consumer/)
   to set up a Node GraphQL Consumer 
   * use one interaction of the API you defined in Task #12
   * choose different consumer and provider names than the ones used in the tutorial to make your implementation unique
   * to publish the contract on a pact broker, use the pact broker credentials you have been provided
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/pact/pact-react-consumer)
1. Run `npm run test:pact:graphql` to check that the consumer test works as expected

### Task #14 Implement a Node-based GraphQL Provider with Pact

1. Start with an empty workspace
1. Go through the steps explained in [this tutorial](https://reflectoring.io/pact-node-graphql-provider/)
   to set up a Node GraphQL Provider
   * to load the contract from the pact broker, use the pact broker credentials you have been provided
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/pact/pact-node-provider)
1. Run `npm run test:pact:graphql` to check that the provider test works as expected


# Workshop on Consumer-Driven Contracts

This repository points to some material that can be used in a hands-on workshop
to get a feel for Consumer-Driven Contracts with the frameworks [Pact](https://docs.pact.io/)
and / or [Spring Cloud Contract](https://cloud.spring.io/spring-cloud-contract/).

## Preparation

If you're new to Consumer-Driven Contracts, read [this article](https://reflectoring.io/7-reasons-for-consumer-driven-contracts/)
as an introduction to CDC.

The setup takes some time since dependencies have to be loaded from the internet.
So it makes sense to follow these steps in advance:

* make sure you have Java >= 8 installed
* for the Angular example, make sure you have the latest NodeJS installed
* clone this repository
* run `npm install` in the folder `consumer/pact-angular-consumer` to load all JS dependencies
* run `./gradlew build` int the folder `consumer/pact-feign-consumer` to load the 
  needed Gradle version and most of the needed dependencies

## Task #1: Define a REST contract

In a group of 2-3, dream up a use case and define a contract
between a REST consumer and a REST provider.

The contract should consist of about a handful of interactions (request / response pairs).

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

## Task #2: Implement a REST Consumer with Spring, Feign & Pact

1. Start with the code in the folder [consumer/pact-feign-consumer](consumer/pact-feign-consumer)
1. Go through the steps explained in [this tutorial](https://reflectoring.io/consumer-driven-contract-feign-pact/)
   to set up a consumer test that creates a pact file
   * use one interaction of the API you defined in Task #1 instead of the API described in the tutorial
   * choose different consumer and provider names to make your implementation unique
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/pact/pact-feign-consumer)
1. Run `./gradlew build` to run the tests and check that a pact file has been created in the folder `target/pacts`

**Results:**
* a pact file created from a Gradle build 

## Task #3: Implement a REST Provider with Spring & Pact

1. Start with the code in the folder [provider/pact-spring-provider](provider/pact-spring-provider)
1. Go through the steps explained in [this tutorial](https://reflectoring.io/consumer-driven-contract-provider-pact-spring/)
   to set up a Spring REST Controller that satisfies the contract from Task #2
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/pact/pact-spring-provider)
1. Run `./gradlew build` to run the provider test and check that it works

**Results:**
* a REST controller that is verified to work against the contract defined in Task #2

## Task #4: Use a Pact Broker

1. Insert the pact broker credentials you have been provided into the `pact` section of the `build.gradle` file of
   the consumer you created in Task #2
1. Run `./gradlew build` in the consumer code base to create the pact file
1. Run `./gradlew pactPublish` in the consumer code base to publish the pact to the broker
1. Visit the Pact Broker in your browser and check that the pact has been published
1. Replace the `@PactFolder` annotation in the provider test from Task #3 with the `@PactBroker` annotation to
   load the pact from the broker instead of from the file system

**Results:**
* the consumer published the pact on the broker and the provider loaded it from the broker

## Task #5: Implement a REST Consumer with Angular & Pact

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

**Results:**
* a pact file created from an Angular build 

## Task #6: Define a Messaging Contract

In a group of 2-3, dream up a use case and define a contract
between a message consumer and a message producer.

The contract should consist of one or two message types.

Per message, define the JSON structure of the message body. 

Write down the definition in a text file or on paper for later reference.

## Task #7: Implement a Spring Messaging Consumer & Provider with Pact 

1. Start with the code in the folders [consumer/pact-message-consumer](consumer/pact-message-consumer) and
   [provider/pact-message-producer](provider/pact-message-producer)
1. Go through the steps explained in [this tutorial](https://reflectoring.io/cdc-pact-messages/)
   to set up a Spring Messaging Consumer and Producer that satisfy the contract from Task #6
1. If you need orientation, have a look at the complete example: [consumer](https://github.com/thombergs/code-examples/tree/master/pact/pact-message-consumer) and
      [producer](https://github.com/thombergs/code-examples/tree/master/pact/pact-message-producer)
1. Run `./gradlew build` in the consumer and producer codebase to check that the consumer and producer tests work as 
      expected

**Results:**
* a messaging consumer and producer that are verified with pact to speak the same language

## Task #8: Implement a REST Consumer & Provider with Spring Cloud Contract 

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

**Results:**
* a REST consumer and provider with Spring Cloud Contract tests to verify that they speak the same language

## Example Workshop Agenda

* Introduction
  * Who is Who? (Interviews in Pairs and each partner introduces the other)
  * Talk: Intro to Consumer-Driven Contracts
  * Demo: CDC Workflow with Angular (Node), Pact and Spring Boot
  * Task #1 Define a REST contract
* REST Contracts with Pact
  * Task #2 Implement a REST Consumer with Spring, Feign & Pact
  * Task #3: Implement a REST Provider with Spring & Pact
  * Talk: How do we manage Provider States with Pact?
  * Talk: Introduction to the Pact Broker
  * Task #4: Use a Pact Broker
  * Hands-On: Implementing a REST Consumer with Angular and Pact
  * Task #5: Implement a REST Consumer with Angular & Pact
* Messaging Contracts with Pact
  * Task #6: Define a Messaging Contract
  * Talk: How can we Test async Messaging with CDC?
  * Task #7: Implement a Spring Messaging Consumer & Provider with Pact 
* Continuous Integration Workflow with Pact 
  * Talk: Continuous Integration with Pact
* REST Contracts with Spring Cloud Contract 
  * Talk: CDC Workflow with Spring Cloud Contract
  * Task #8: Implement a REST Consumer & Provider with Spring Cloud Contract 
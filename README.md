# Workshop on Consumer-Driven Contracts

This repository points to some material that can be used in a hands-on workshop
to get a feel for Consumer-Driven Contracts with the frameworks [Pact](https://docs.pact.io/)
and / or [Spring Cloud Contract](https://cloud.spring.io/spring-cloud-contract/).

If you need to get an idea about the concept of Consumer-Driven Contracts, read
[this article](https://reflectoring.io/7-reasons-for-consumer-driven-contracts/) 
before moving on to the tasks below.

## The Tasks in this Workshop

Select a valid consumer / provider combination from the table below and follow
the instructions to set up a consumer, a provider and a contract between them. 

| | Spring MVC Provider with Pact | Spring MVC Provider with Spring Cloud Contract|
| ------------- |-------------| ----- |
| **Angular Consumer with Pact** | :heavy_check_mark: | :heavy_check_mark: |
| **Java Feign Consumer with Pact** | :heavy_check_mark: | :x: |
| **Java Feign Consumer with Spring Cloud Contract** | :x: | :heavy_check_mark: |

**Complete the following tasks**

1. implement the selected consumer (which implies creating a contract)
1. implement the selected provider (which implies creating a test against the contract)
1. change the contract and repeat steps 1 and 2 to update the consumer and provider to the contract 

You can find more detailed steps for each of the consumers and providers below.

## Consumer Implementations

### Angular Consumer with Pact

1. Download and install the latest NodeJS distribution at [https://nodejs.org/en/download/](https://nodejs.org/en/download/)
1. Verify that npm and Node are installed properly by calling `node -v` and `npm -v`
1. Start with the code in the folder [consumer/pact-angular-userclient](consumer/pact-angular-userclient)
1. Run `npm install` in the folder and check that a `node_modules` folder has been created
1. Run `npm run test` to verify that the Angular tests run on your machine (you need to have Google Chrome installed)
1. Go through the steps explained in [this article](https://reflectoring.io/consumer-driven-contracts-with-angular-and-pact/) 
   to set up a consumer test that creates a pact file
   * create a different API from the one in the article (instead of creating users, do something else)
   * choose different consumer and provider names to make your implementation unique
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/pact/pact-angular)
1. Run `npm run test` again to run the tests and check that a pact file has been created in the `pacts` folder

**Results:**
* a pact file created from an Angular build 
* if working with a Pact Broker: the pact file has been published on the Pact Broker

### Java Spring Consumer with Pact

1. Start with the code in the folder [consumer/pact-feign-userclient](consumer/pact-feign-userclient)
1. Go through the steps explained in [this article](https://reflectoring.io/consumer-driven-contract-feign-pact/)
   to set up a consumer test that creates a pact file
   * create a different API from the one in the article (instead of creating users, do something else)
   * choose different consumer and provider names to make your implementation unique
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/pact/pact-feign-consumer)
1. Run `./gradlew build` to run the tests and check that a pact file has been created in the folder `target/pacts`

**Results:**
* a pact file created from a Gradle build 
* if working with a Pact Broker: the pact file has been published on the Pact Broker

### Java Spring Consumer with Spring Cloud Contract

1. Start with the code in the folder [consumer/scc-feign-userclient](consumer/scc-feign-userclient)
1. Go through the steps explained in [this article](https://reflectoring.io/consumer-driven-contract-consumer-spring-cloud-contract/)
   to set up a contract and a consumer test against that contract
   * in the contract, specify a different API from the one in the article (instead of creating users, do something else)
   * the "provider code base" mentioned in the article is the folder [provider/scc-spring-userservuce](provider/scc-spring-userservice)
   * skip the step "verify the consumer code online" if you do not have access to a Maven repository where you can publish
     the provider mock
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/spring-cloud/spring-cloud-contract-consumer)

**Results:**
* a Groovy contract file in the provider code base
* a working consumer test verifying that the client works as specified in the contract

## Provider Implementations

### Java Spring Provider with Pact

1. Start with the code in the folder [provider/pact-spring-userservice](provider/pact-spring-userservice)
1. Go through the steps explained in [this article](https://reflectoring.io/consumer-driven-contract-provider-pact-spring/)
   to set up a Spring REST Controller that satisfies the contract you specified in your consumer
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/pact/pact-spring-provider)
1. Run `./gradlew build` to run the provider test and check that it works

**Results:**
* a REST controller that is verified to work against the consumer-driven contract
* if working with a Pact Broker: the pact file for the provider test has been loaded from the Pact Broker

### Java Spring Provider with Spring Cloud Contract

1. Start with the code in the folder [provider/scc-spring-userservuce](provider/scc-spring-userservice)
1. Go through the steps explained in [this article](https://reflectoring.io/consumer-driven-contract-provider-spring-cloud-contract/)
   to set up a Spring REST Controller that satisfies the contract you specified in your consumer
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/spring-cloud/spring-cloud-contract-provider)
1. Run `./gradlew generateContractTests` to generate the provider tests
1. Run `./gradlew build` to run the tests 

**Results:**
* contract tests verifying that our controller works have been automatically generated
* the contract test passes
# Workshop on Consumer-Driven Contracts

This repository points to some material that can be used in a hands-on workshop
to get a feel for Consumer-Driven Contracts with the frameworks [Pact](https://docs.pact.io/)
and / or [Spring Cloud Contract](https://cloud.spring.io/spring-cloud-contract/).

The concept of Consumer-Driven Contracts is best learned by implementing one or more
API consumer and provider with your own hands and test them against a contract.

**Select a consumer / provider combination** from the table below and follow
the instructions to set up a consumer-driven contract between them.

| | Java Provider with Pact | Java Provider with Spring Cloud Contract|
| ------------- |-------------| ----- |
| **Angular Consumer with Pact** | :heavy_check_mark: | :heavy_check_mark: |
| **Java Consumer with Pact** | :heavy_check_mark: | :x: |
| **Java Consumer with Spring Cloud Contract** | :x: | :heavy_check_mark: |


After successfully setting up a contract test between one consumer and one provider
you may create additional consumers and providers and set up additional contracts.

## Consumer Implementations

### Angular Consumer with Pact

1. Download and install the latest NodeJS distribution at [https://nodejs.org/en/download/](https://nodejs.org/en/download/)
1. Verify that npm and Node are installed properly by calling `node -v` and `npm -v`
1. Start with the code in the folder [consumer/pact-angular](consumer/pact-angular)
1. Run `npm install` in the folder and check that a `node_modules` folder has been created
1. Run `npm run test` to verify that the Angular tests run on your machine (you need to have Google Chrome installed)
1. Go through the steps explained in [this article](https://reflectoring.io/consumer-driven-contracts-with-angular-and-pact/) 
   to set up a consumer test that creates a pact file
1. If you need orientation, have a look at the [complete example](https://github.com/thombergs/code-examples/tree/master/pact/pact-angular)
1. Run `npm run test` again to run the tests and check that a pact file has been created in the `pacts` folder

**Results:**
* a pact file created from an Angular build 
* if working with a Pact Broker: the pact file has been published on the Pact Broker

### Java Spring Consumer with Pact

1. Clone the starting repository at TODO
1.

### Java Spring Consumer with Spring Cloud Contract

1. Clone the starting repository at TODO
1.

## Provider Implementations

### Java Spring Provider with Pact

1. Clone the starting repository at TODO
1.

### Java Spring Provider with Spring Cloud Contract

1. Clone the starting repository at TODO
1.

 
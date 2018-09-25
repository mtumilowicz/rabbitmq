[![Build Status](https://travis-ci.com/mtumilowicz/rabbitmq.svg?branch=master)](https://travis-ci.com/mtumilowicz/rabbitmq)
# rabbitmq
The main goal of this project is to explore basic features of Spring AMQP.

_Reference_: https://blogs.vmware.com/vfabric/2013/02/choosing-your-messaging-protocol-amqp-mqtt-or-stomp.html  
_Reference_: https://www.rabbitmq.com/tutorials/amqp-concepts.html  
_Reference_: https://www.rabbitmq.com/install-windows.html  
_Reference_: https://cmatskas.com/getting-started-with-rabbitmq-on-windows/

# preface
**RabbitMQ** is an open source message broker software that supports:
* Advanced Message Queuing Protocol (AMQP),
* Streaming Text Oriented Messaging Protocol (STOMP), 
* Message Queuing Telemetry Transport (MQTT).

## AMQP
The AMQP protocol is a binary protocol with modern features:
* multi-channel, 
* negotiated,
* asynchronous, 
* secure, 
* portable, 
* neutral, 
* and efficient.  
AMQP is usefully split into two layers:
* Functional Layer
    * Transactions 
    * Exchanges 
    * Message queues
* Transport Layer
    * Framing Content Data representation
    * Error handling
    * Heart-beating
    * Channels

## STOMP
STOMP (Simple/Streaming Text Oriented Messaging Protocol) is the only one of these three protocols to be text-based, 
making it more analogous to HTTP in terms of how it looks under the covers. Like AMQP, STOMP provides a message 
(or frame) header with properties, and a frame body.

STOMP does not, however, deal in queues and topics—it uses a SEND semantic with a "destination" string. 
The broker must map onto something that it understands internally such as a topic, queue, or exchange. 
Consumers then SUBSCRIBE to those destinations.

## MQTT
The design principles and aims of MQTT are much more simple and focused than those of AMQP — 
it provides publish-and-subscribe messaging (no queues, in spite of the name) and was specifically 
designed for resource-constrained devices and low bandwidth, high latency networks.

It offers three qualities of service: 
* fire-and-forget / unreliable,
* "at least once" to ensure it is sent a minimum of one time (but might be sent more than one time),
* "exactly once".

MQTT’s strengths are:
* simplicity (just five API methods), 
* compact binary packet payload (no message properties, compressed headers, much less verbose than 
something text-based like HTTP),
* good fit for simple push messaging scenarios such as temperature updates, stock price tickers, oil pressure feeds 
or mobile notifications.

# RabbitMQ AMQP
## overview
![](images/amqp-overview.png)

## exchange
Exchanges are AMQP entities where messages are sent. Exchanges take a message and route it into zero or more queues. 
The routing algorithm used depends on the exchange type and rules called bindings.

Besides the exchange type, exchanges are declared with a number of attributes, the most important of which are:
* Name
* Durability (exchanges survive broker restart)
* Auto-delete (exchange is deleted when last queue is unbound from it)

### direct
A direct exchange delivers messages to queues based on the message routing key (`String`):
1. A queue binds to the exchange with a routing key K
1. When a new message with routing key R arrives at the direct exchange, 
the exchange routes it to the queue if K = R

![](images/exchange-direct.png)

### topic
Topic exchanges route messages to one or many queues based on matching between a message routing key and the pattern 
that was used to bind a queue to an exchange.

Use cases: 
* News updates that involve categorization or tagging (for example, only for a particular sport or team).
* Distributing data relevant to specific geographic location, for example, points of sale.
![](images/exchange-topic.jpg)

### fanout
A fanout exchange routes messages to all of the queues that are bound to it and the routing key is ignored. 
If N queues are bound to a fanout exchange, when a new message is published to that exchange a copy of the 
message is delivered to all N queues.

Use cases: 
* Sport news sites can use fanout exchanges for distributing score updates to mobile clients in near real-time.
* Group chats can distribute messages between participants using a fanout exchange.

![](images/exchange-fanout.png)

### header
A headers exchange is designed for routing on multiple attributes that are more easily expressed as message 
headers than a routing key. Headers exchanges ignore the routing key attribute. Instead, the attributes used 
for routing are taken from the headers attribute. A message is considered matching if the value of the header 
equals the value specified upon binding.

It is possible to bind a queue to a headers exchange using more than one header for matching. This is what the 
"x-match" binding argument is for. When the "x-match" argument is set to "any", just one matching header value 
is sufficient. Alternatively, setting "x-match" to "all" mandates that all the values must match.

Headers exchanges can be looked upon as "direct exchanges on steroids". Because they route based on header values, 
they can be used as direct exchanges where the routing key does not have to be a string; it could be an integer 
or a hash (dictionary) for example.

![](images/exchange-header.png)

## queue
They store messages that are consumed by applications.

Properties:
* Name
* Durable (the queue will survive a broker restart)
* Exclusive (used by only one connection and the queue will be deleted when that connection closes)
* Auto-delete (queue that has had at least one consumer is deleted when last consumer unsubscribes)
* Arguments (optional; used by plugins and broker-specific features such as message TTL, queue length limit, etc)

## bindings
Bindings are rules that exchanges use (among other things) to route messages to queues. To instruct an exchange 
E to route messages to a queue Q, Q has to be bound to E. Bindings may have an optional routing key attribute 
used by some exchange types.

To draw an analogy:
* Queue is like your destination in New York city
* Exchange is like JFK airport
* Bindings are routes from JFK to your destination. There can be zero or many ways to reach it

## delivery
* If AMQP message cannot be routed to any queue (for example, because there are no bindings for the exchange it was 
published to) it is either dropped or returned to the publisher, depending on message attributes the publisher has set.
* Dead Letter Exchanges - Messages from a queue can be 'dead-lettered'; that is, republished 
to another exchange when any of the following events occur:
    * The message is rejected (basic.reject or basic.nack) with requeue=false,
    * The TTL for the message expires,
    * The queue length limit is exceeded.


# rabbitmq
## setting up on windows
1. Install a supported version of Erlang for Windows.
1. Run the RabbitMQ installer, `rabbitmq-server-3.7.7.exe`. 
It installs RabbitMQ as a Windows service and starts it using the default configuration.

## management plugin
RabbitMQ comes with a handy and web-based management plugin which is part of the installation files, to use it:
1. Open an elevated command line (Run as Administrator)
1. Navigate to the `sbin` directory of the RabbitMQ Server installation directory. For example:
    ```
    cd Program Files\RabbitMQ Server\rabbitmq_server-3.7.7\sbin
    ```
1. Run the following command to enable the plugin
    ```
    rabbitmq-plugins.bat enable rabbitmq_management
    ```
1. Re-install the RabbitMQ service using the commands below:
    ```
   rabbitmq-service.bat stop  
   rabbitmq-service.bat install  
   rabbitmq-service.bat start  
    ```
1. http://localhost:15672
    ```
    username: guest
    password: guest
    ```
_Remark_: You could run rabbitmq using Docker - https://docs.docker.com/samples/library/rabbitmq/

## basics
Useful commands running on `sbin` directory:
* `rabbitmq-service.bat start`
* `rabbitmq-service.bat stop`
* `rabbitmq-service.bat install`
* `rabbitmq-service.bat disable`
* `rabbitmq-service.bat enable`

# project description
`microservice2` operates on the table `CUSTOMER` that is defined on the database of `microservice1` (and modified by 
`microservice1`) - so when `microservice1` modifies (adds / deletes) its `CUSTOMER` we send event via `rabbitmq` 
and `microservice2` updates its copy of `CUSTOMER` table.

Shortly:
* `microservice1` - publisher
* `microservice2` - consumer

## exchanges
Exchange is defined by publisher and consumer as well to provide full decoupling at deploy time.  
_Remark_: Exchange is added by publisher lazily (at first message).

```
@Bean
@CustomersExchange
Exchange customersExchange() {
    return ExchangeBuilder.topicExchange(ExchangeNames.CUSTOMERS)
            .durable(true)
            .build();
}
```

## queues
Defined only at consumer side - producer should have no info about queues.
```
@Bean
@CustomersCreateQueue
Queue customersCreateQueue() {
    return new Queue(QueueNames.CUSTOMERS_CREATE);
}
```

## bindings
Defined only at customer side - needs predefined queues:
```
@Bean
Binding customersCreateQueueBinding(@CustomersCreateQueue Queue queue,
                                    @CustomersExchange Exchange exchange) {
    return BindingBuilder.bind(queue)
            .to(exchange)
            .with("customers.create")
            .noargs();
}
```

## publisher
```
void publish(@NonNull CustomerSaveMessage message) {
    rabbitTemplate.convertAndSend(
            exchange.getName(), 
            "customers.create",
            message);
}
```
plus configuration (`RabbitConfig`):
* `messageConverter`
* `RabbitTemplate`

## consumer
```
@RabbitListener(queues = QueueNames.CUSTOMERS_CREATE)
public void onSave(@NonNull CustomerSaveMessage message) {
    CustomerSaveMessageValidator.validate(message);
    customerMessageHandler.processSave(message);
}
```
plus configuration (`ListenerConfig`):
* `implements RabbitListenerConfigurer`
* `@EnableRabbit`
* `messageConverter`

# tests
**Coverage**: `94%`
package io.reflectoring;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Takes a {@link UserCreatedMessage}, converts it to a {@link String} and sends it to be published.
 */
class MessageProducer {

	private ObjectMapper objectMapper;

	private MessagePublisher messagePublisher;

	MessageProducer(ObjectMapper objectMapper, MessagePublisher messagePublisher) {
		this.objectMapper = objectMapper;
		this.messagePublisher = messagePublisher;
	}


//	void produceMessage(MyMessage message) throws IOException {
//		// TODO: map Java object to JSON string and pass it to the MessagePublisher
//	}

}

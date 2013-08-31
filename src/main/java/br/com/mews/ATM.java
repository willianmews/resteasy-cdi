/**
 *
 */
package br.com.mews;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.slf4j.Logger;

import br.com.mews.interceptor.Security;

/**
 * @author wmews
 */
public class ATM {

	private final Event<Handling> handlingEvent;
	private final Logger logger;

	@Inject
	public ATM(Event<Handling> handlingEvent, Logger logger) {
		super();
		this.handlingEvent = handlingEvent;
		this.logger = logger;
	}

	@Security
	public void deposit(int value) {
		logger.info("deposit = " + value);
		handlingEvent.fire(new Handling(value));
	}

	@Security
	public void take(int value) {
		logger.info("take = " + value);
		handlingEvent.fire(new Handling(-1 * value));
	}
}

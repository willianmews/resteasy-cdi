/**
 *
 */
package br.com.mews;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * @author wmews
 */
@ApplicationScoped
public class BankAccount {

	@Inject
	private Logger logger;
	private int balance = 1000;

	private void receivedMoviment(@Observes Handling handling) {
		balance += handling.getValue();
		logger.info("balance = " + balance);
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}

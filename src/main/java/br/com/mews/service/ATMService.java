package br.com.mews.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.slf4j.Logger;

import br.com.mews.ATM;
import br.com.mews.BankAccount;

@Path("/atm")
public class ATMService {

	@Inject
	private ATM atm;
	@Inject
	private BankAccount bankAccount;
	@Inject
	private Logger logger;

	@GET
	@Path("deposit/{value}")
	public String deposit(@PathParam("value") int value) {
		atm.deposit(value);
		return String.valueOf(bankAccount.getBalance());
	}

	@GET
	@Path("take/{value}")
	public String take(@PathParam("value") int value) {
		atm.take(value);
		return String.valueOf(bankAccount.getBalance());
	}

	@GET
	@Path("balance")
	public String balance() {
		return String.valueOf(bankAccount.getBalance());
	}
}

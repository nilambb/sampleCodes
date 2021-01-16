package banking;

/**
 *
 * Private Variables:<br>
 * {@link #accountNumber}: Long<br>
 * {@link #bank}: Bank<br>
 */
public class Transaction implements TransactionInterface {
	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank
	 *            The bank where the account is housed.
	 * @param accountNumber
	 *            The customer's account number.
	 * @param attemptedPin
	 *            The PIN entered by the customer.
	 * @throws Exception
	 *             Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		this.accountNumber = accountNumber;
		this.bank = bank;
		boolean valid = bank.authenticateUser(accountNumber, attemptedPin);
		if(!valid) {
			throw new Exception("Invalid account number or pin is inserted...");
		}
	}

	public double getBalance() {
		return bank.getBalance(accountNumber);
	}

	public void credit(double amount) {
		bank.credit(accountNumber, amount);
	}

	public boolean debit(double amount) {
        return bank.debit(accountNumber, amount);
	}
}

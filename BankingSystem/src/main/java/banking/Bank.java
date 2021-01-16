package banking;

import java.util.Collections;
import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		accounts = new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		Long accountNumber = generateAccountNumber();
		accounts.put(accountNumber, new CommercialAccount(company, accountNumber, pin, startingDeposit));
        return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		Long accountNumber = generateAccountNumber();
		accounts.put(accountNumber, new ConsumerAccount(person, accountNumber, pin, startingDeposit));
        return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		Account account = accounts.get(accountNumber);
        if( account != null && account.validatePin(pin)) {
        	return true;
        }
		return false;
	}

	public double getBalance(Long accountNumber) {
		Account account = accounts.get(accountNumber);
        if( account != null) {
        	return account.getBalance();
        }
        return -1;
	}

	public void credit(Long accountNumber, double amount) {
		Account account = accounts.get(accountNumber);
        if( account != null) {
        	account.creditAccount(amount);
        }
    }

	public boolean debit(Long accountNumber, double amount) {
		Account account = accounts.get(accountNumber);
        if( account != null) {
        	return account.debitAccount(amount);
        }
        return false;
	}
	
	private Long generateAccountNumber() {
		if (this.accounts.isEmpty()) {
			return 1L;
		} else {
			Long max = Collections.max(accounts.keySet());
			return ++max;
		}
	}
}

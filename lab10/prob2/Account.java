package lab10.prob2;

import java.util.Objects;

public class Account {
	private int acctId;
	private double balance;
	
	public Account(int id, double startBalance) {
		if(startBalance <= 0) throw new IllegalArgumentException("Start balance must be > 0!");
		acctId = id;
		balance = startBalance;
	}
	public int getAcctId() {
		return acctId;
	}
	public double getBalance() {
		return balance;
	}
	@Override
	public int hashCode(){
		return Objects.hash(this.acctId, this.balance);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		Account other = (Account) obj;
		return this.acctId == other.acctId && this.balance == other.balance;
	}
}

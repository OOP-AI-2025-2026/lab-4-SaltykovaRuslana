package ua.opnu.java.inheritance.account;

import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public class MinMaxAccount extends BankingAccount {
    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        this.minBalance = this.getBalance();
        this.maxBalance = this.getBalance();
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
        this.maxBalance = Math.max(this.minBalance, this.getBalance());
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        this.minBalance = Math.min(this.minBalance, this.getBalance());
    }

    public int getMin() {
        return this.minBalance;
    }

    public int getMax() {
        return this.maxBalance;
    }
}

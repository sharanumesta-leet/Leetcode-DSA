class Bank {
    private int totalAccounts;
    private long[] balance;

    public Bank(long[] balance) {
        this.totalAccounts = balance.length;
        this.balance = new long[this.totalAccounts];
        for (int i = 0; i < this.totalAccounts; i++)
            this.balance[i] = balance[i];
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 <= 0 || account1 > totalAccounts || account2 <= 0 || account2 > totalAccounts)
            return false;
        if (balance[account1 - 1] < money)
            return false;
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account <= 0 || account > totalAccounts)
            return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account <= 0 || account > totalAccounts)
            return false;
        if (balance[account - 1] < money)
            return false;
        balance[account - 1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
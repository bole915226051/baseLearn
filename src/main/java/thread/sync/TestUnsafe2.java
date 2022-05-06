package thread.sync;

/**
 * 练习线程不安全,模拟取钱操作
 * <p>
 * 多个人同时操作一个账户,会造成线程不安全
 */
public class TestUnsafe2 {
    public static void main(String[] args) {
        // 班费账户中有1000块钱
        Account account = new Account("班费", 1000);


        //  模拟多个用户取钱
        new Thread(new Bank(account, 1000), "体育委员").start();
        new Thread(new Bank(account, 500), "班长").start();
    }

}

class Account {

    public String name;

    public int money;

    Account(String name, int money) {
        this.name = name;
        this.money = money;
    }
}


class Bank implements Runnable {

    private Account account;

    // 取走的钱
    private int tackMoney;

    //手里的钱
    private int currentMoney;

    Bank(Account account, int tackMoney) {
        this.account = account;
        this.tackMoney = tackMoney;
    }


    @Override
    public void run() {
        synchronized (account) {
            if (this.account.money < tackMoney) {
                System.out.println(Thread.currentThread().getName() + "取钱,账户已经没钱了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.account.money = this.account.money - tackMoney;
            currentMoney = currentMoney + tackMoney;

            System.out.println(Thread.currentThread().getName() + "取走了" + tackMoney + ",手上还有" + this.currentMoney + ",余额还剩下" + this.account.money);
        }
    }
}

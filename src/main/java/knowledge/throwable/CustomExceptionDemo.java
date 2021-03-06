package knowledge.throwable;

/**
 * CustomException
 * 自定义异常
 * 1.所有异常都必须是 Throwable 的子类
 * 2.写一个检查性异常类，需要继承 Exception 类
 * 3.写一个运行时异常类，需要继承 RuntimeException 类
 * https://zhuanlan.zhihu.com/p/66228306
 *
 * @author ljh
 * created on 2020/9/4 14:10
 */
public class CustomExceptionDemo {

    public static void main(String[] args) {
        CheckingAccount ca = new CheckingAccount(101);
        System.out.println("Depositing $500...");
        ca.deposit(500.00);

        try {
            System.out.println("Withdrawing $100...");
            ca.withdraw(100.00);
            System.out.println("Withdrawing $600...");
            ca.withdraw(600.00);
        } catch (CustomException e) {
            System.out.println("Sorry, but you are short $" + e.getAmount());
            e.printStackTrace();
        }
    }

    /**
     * 自定义异常类
     */
    private static class CustomException extends RuntimeException {

        private double amount;

        CustomException() {
        }

        CustomException(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }
    }

    /**
     * 模拟银行账户
     */
    private static class CheckingAccount {

        /**
         * 余额
         */
        private double balance;
        /**
         * 卡号
         */
        private int number;

        CheckingAccount(int number) {
            this.number = number;
        }

        /**
         * 存钱
         */
        public void deposit(double amount) {
            balance += amount;
        }

        /**
         * 取钱
         */
        public void withdraw(double amount) throws CustomException {
            if (amount <= balance) {
                balance -= amount;
            } else {
                double needs = amount - balance;
                throw new CustomException(needs);
            }
        }

        public double getBalance() {
            return balance;
        }

        public int getNumber() {
            return number;
        }

    }
}



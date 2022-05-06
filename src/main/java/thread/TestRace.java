package thread;

import org.apache.commons.lang.StringUtils;

/**
 * 通过多线程,模拟龟兔赛跑
 */
public class TestRace implements Runnable {
    private String champion;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //  模拟兔子睡觉
            if (Thread.currentThread().getName().equals("兔子")) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //  判断是否已经结束
            if (isEnd(i)) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "选手,已经跑了" + i + "。");
        }
    }

    private boolean isEnd(int i) {
        if (StringUtils.isNotBlank(champion)) {
            return true;
        }
        if (i == 100) {
            this.champion = Thread.currentThread().getName();
            System.out.println("比赛已经结束,冠军是:" + this.champion);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        TestRace race = new TestRace();
        new Thread(race, "兔子").start();
        Thread.sleep(2);
        new Thread(race, "乌龟").start();
    }
}

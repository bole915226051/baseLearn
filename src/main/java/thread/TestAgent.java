package thread;

/**
 * 结婚模拟静态代理模式
 * 静态代理模式总结：
 * 1.真实对象和代理对象都要实现同一个接口
 * 2.代理对象要代理真实角色
 * <p>
 * 好处:
 * 1.代理对象可以做很多真实对象做不了的事情
 * 2.真实对象只需要专注做好自己的事情
 */
public class TestAgent {
    public static void main(String[] args) {
        new Wedding(new Person()).marry("司仪");
    }
}

interface Marry {
    void marry(String name);
}

class Person implements Marry {

    @Override
    public void marry(String name) {
        System.out.println("结婚本人：" + name);
    }
}

class Wedding implements Marry {

    // 结婚本人
    private Marry marry;

    Wedding(Marry marry) {
        this.marry = marry;
    }

    @Override
    public void marry(String name) {
        System.out.println("模拟布置现场:" + name);
        this.marry.marry("小汪");
        System.out.println("模拟收拾现场:" + name);
    }
}

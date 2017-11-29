package 代理模式;

/**
 * Created by 666 on 2017/11/29.
 */
public class 静态代理 {
    public static void main(String[] args){
        RealSubject realSubject = new RealSubject();
        MyProxy myProxy = new MyProxy(realSubject);
        myProxy.request();
    }

    interface Subject {
        void request();
    }

    /**
     * 委托类
     */
    static class RealSubject implements Subject{
        @Override
        public void request() {
            System.out.println("real--request");
        }
    }

    /**
     *  代理类
     */

    static class MyProxy implements Subject{
        private Subject subject;

        public MyProxy(Subject subject) {
            this.subject = subject;
        }

        @Override
        public void request() {
            System.out.println("PreProcess");
            subject.request();
            System.out.println("PostProcess");
        }
    }

}

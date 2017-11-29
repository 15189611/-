package 代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 666 on 2017/11/29.
 */
public class 动态代理 {

    public static void main(String[] args){
        RealSubject realSubject = new RealSubject();
        MyHandler myHandler = new MyHandler(realSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), myHandler);
        subject.request();
    }

    interface Subject{
        void request();
    }

    /**
     * 委托类
     */
    static class RealSubject implements Subject{
        @Override
        public void request() {
            System.out.println("real----quest");
        }
    }

   static  class MyHandler implements InvocationHandler{
        private Subject subject;

        public MyHandler(Subject subject) {
            this.subject = subject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("====before====");//定义预处理的工作，当然你也可以根据 method 的不同进行不同的预处理工作
            Object result = method.invoke(subject, args);
            System.out.println("====after====");
            return result;
        }

    }

}

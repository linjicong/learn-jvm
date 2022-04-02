package com.learn.jvm;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author linjicong
 * @date 2022-04-02 14:40
 */
public class MarkWord {
    static A a;
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        a = new A();
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        sync();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
    private static void sync(){
        synchronized (a){
            System.out.println("synchronized");
        }
    }
}

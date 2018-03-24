package com.xym.springboot;

import com.xym.springboot.task.AsyncTask;
import com.xym.springboot.task.AsyncTaskWithResult;
import com.xym.springboot.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

    @Autowired
    private Task task;
    @Autowired
    private AsyncTask asyncTask;
    @Autowired
    private AsyncTaskWithResult asyncTaskWithResult;

    @Test
    public void task1() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }


    /**
     * 原因是目前doTaskOne、doTaskTwo、doTaskThree三个函数的时候已经是异步执行了。主程序在异步调用之后，主程序并不会理会这三个函数是否执行完成了，由于没有其他需要执行的内容，所以程序就自动结束了，导致了不完整或是没有输出任务相关内容的情况。
     *
     * @throws Exception
     */
    @Test
    public void task2() throws Exception {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
    }

    /**
     * 在测试用例一开始记录开始时间
     * 在调用三个异步函数的时候，返回Future<String>类型的结果对象
     * 在调用完三个异步函数之后，开启一个循环，根据返回的Future<String>对象来判断三个异步函数是否都结束了。若都结束，就结束循环；若没有都结束，就等1秒后再判断。
     * 跳出循环之后，根据结束时间 - 开始时间，     *
     *
     * @throws Exception
     */
    @Test
    public void task3() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncTaskWithResult.doTaskOne();
        Future<String> task2 = asyncTaskWithResult.doTaskTwo();
        Future<String> task3 = asyncTaskWithResult.doTaskThree();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
            System.out.println("~~~~~~~~~~~~~~~1秒后重试");
        }
        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
}

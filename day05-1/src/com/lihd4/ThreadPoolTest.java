package com.lihd4;

import java.util.concurrent.*;

/**
 * 实现多线程方式四 ：线程池 ExecutorsService
 * 1 创建线程池 ExecutorsService service = Executors.newXxxThreadPool();
 * 2 设置参数 ThreadPoolExecutor executor = (...)service,此时就可以设置参数
 * 3 运行  |----- 1 service.submit(Callable/Runnable)
 *        |----- 2 service.execute(Runnable)
 * 4 关闭线程池 service.shutdown()
 *
 * ThreadPoolExecutor中有5个set方法，可以设置状态
 * 1 setThreadFactory
 * 2 setCorePoolSize
 * @author ：葬花吟留别1851053336@qq .com
 * @description：TODO
 * @date ：2022/3/8 19:31
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {//为了代码易读性，抛出异常
        //1
        ExecutorService service = Executors.newFixedThreadPool(10);
        //2
        ThreadPoolExecutor executor = (ThreadPoolExecutor) service;
        executor.setCorePoolSize(5);
        //3

        executor.execute(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + "----------------");
            }
        });

        MyCall myCall = new MyCall();
        FutureTask<String> futureTask = new FutureTask<>(myCall);
        executor.submit(futureTask);
        String s = futureTask.get();
        System.out.println(s);//可以获取返回值
        //4
        executor.shutdown();
    }
}



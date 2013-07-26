package com.gzb.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 2011 2011-5-27
 * by diyong
 * 
 */

public class ThreadPoolManager {

	private static ThreadPoolManager singletonObject = null; 
    private ExecutorService es = null;
    
    private ThreadPoolManager() {
//       es = Executors.newFixedThreadPool(Const.FetchThreadPoolSize);
       es = new ThreadPoolExecutor(10,4000,
               600L, TimeUnit.SECONDS,
               new SynchronousQueue<Runnable>());
       
//    	es = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
//                60L, TimeUnit.SECONDS,
//                new SynchronousQueue<Runnable>());
//    	
//    	es = new ThreadPoolExecutor(Const.FetchThreadPoolSize, Const.FetchThreadPoolSize,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());
    }
    
    public static synchronized ThreadPoolManager getInstance(){
        if (singletonObject == null) {
            singletonObject = new ThreadPoolManager();
        }
        return singletonObject;
    }
    
    public ExecutorService getExecutorService() {
        return es;
    }
	
}

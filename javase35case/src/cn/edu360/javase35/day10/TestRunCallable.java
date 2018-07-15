package cn.edu360.javase35.day10;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import com.sun.corba.se.impl.orbutil.closure.Future;
import com.sun.org.apache.xpath.internal.functions.FuncRound;

public class TestRunCallable {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		TestCallable callable = new TestCallable();
		FutureTask<Integer> ft=new FutureTask<>(callable);
		Thread t = new Thread(ft);
		t.start();
		
		Integer integer = ft.get();
		System.out.println(integer);
	}

}

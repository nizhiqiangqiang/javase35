package cn.edu360.javase35.day10;

import java.util.Random;
import java.util.concurrent.Callable;

public class TestCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum=0;
		Random random = new Random();
		for(int i=0;i<100;i++){
			int nextInt = random.nextInt(101);
			sum+=nextInt;
		}
		return sum;
	}

}

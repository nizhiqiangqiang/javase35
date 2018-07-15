package cn.edu360.javase35.day09.Utiles;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyDbUtile {
	static ComboPooledDataSource pool = new ComboPooledDataSource();

    
    public static QueryRunner getRunner(){
        QueryRunner runner = new QueryRunner(pool);
        return runner;
    }
}

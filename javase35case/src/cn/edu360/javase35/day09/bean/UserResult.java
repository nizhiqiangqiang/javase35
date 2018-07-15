package cn.edu360.javase35.day09.bean;

public class UserResult {
	boolean result;
    String desc;

    @Override
    public String toString() {
        return "UserResult{" +
                "result=" + result +
                ", desc='" + desc + '\'' +
                '}';
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}

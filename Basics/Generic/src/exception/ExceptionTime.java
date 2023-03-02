package exception;

public class ExceptionTime {
    private int testTimes;

    public ExceptionTime(int testTimes)
    {
        this.testTimes=testTimes;
    }

    public void newObject()
    {
        long l=System.nanoTime();
        for (int i = 0; i < testTimes; i++) {
            new Object();
        }
        System.out.println("建立对象: "+(System.nanoTime()-1));
    }

    public void newException(){
        long l=System.nanoTime();
        for (int i = 0; i < testTimes; i++) {
            new Exception();
        }

        System.out.println("建立异常对象："+(System.nanoTime()-1));
    }

    public void catchException(){
        long l=System.nanoTime();
        for (int i = 0; i < testTimes; i++) {
            try {
                throw new Exception();
            } catch (Exception e) {
                //
            }
        }
        System.out.println("建立、抛出并接住异常对象："+(System.nanoTime()-1));
    }

    public static void main(String[] args) {
        ExceptionTime test=new ExceptionTime(1000);
        test.newObject();
        test.newException();
        test.catchException();
    }
}

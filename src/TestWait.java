/**
 * Created by harry_zhou on 2016-11-08.
 */
public class TestWait implements  Runnable{
    private  int num;
    private Object lock;

    public TestWait(int num,Object lock){
        super();
        this.num=num;
        this.lock=lock;
    }

    public  void run(){
        try{
            while(true){
                synchronized (lock){
                    lock.notifyAll();
                    lock.wait();
                    System.out.println("mum:"+num);
                }
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws InterruptedException {
       final Object lock = new Object();
        Thread thread1 = new Thread(new TestWait(1,lock));
        Thread thread2 = new Thread(new TestWait(2,lock));
        thread1.start();
        thread2.start();
    }
}

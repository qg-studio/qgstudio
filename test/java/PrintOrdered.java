/**
 * @author linxu
 * @date 2019
 * tips:
 * 1、交替打印，根据构造器构造的N，构造一个交替任务执行器。
 * 2、假如N=1，则打印12，假如N=2.则打印1212。
 * 3、效率第一，可有多种解法，适当加分。
 */
static class PrintOrdered {
    private int n;

    public PrintOrdered(int n) {
        this.n = n;
    }

    public void one() throws InterruptedException {
        //这部分内容可以修改
        for (int i = 0; i < n; i++) {
            System.out.print("1");
        }
    }

    public void two() throws InterruptedException {
        //这部分内容可以修改
        for (int i = 0; i < n; i++) {
            System.out.print("2");
        }
    }
}
    //main方法内容不允许修改
    public static void main(String[] args) throws InterruptedException{

        PrintOrdered printOrdered=new PrintOrdered(100);
        Runnable r1 = () -> {
            try {
                printOrdered.one();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                printOrdered.two();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t=new Thread(r1);
        Thread t1=new Thread(r2);
        //keep sync
        Thread.sleep(100);
        //start
        t.start();
        t1.start();
    }

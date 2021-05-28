package rx;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class MyObserverTest {

    @Test
    public void test1() {
        String[] items = {"1", "2", "3"};
        Integer count = Observable.from(items).count().toBlocking().single();
        System.out.println(count);
    }

    @Test
    public void test2() throws InterruptedException {
        String[] items = {"1", "2", "3"};

        Observable<String> observable = Observable.from(items);
        observable.delay(1, TimeUnit.SECONDS).filter(s -> s.equals("1")).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("complete");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
        Thread.currentThread().join();

        observable.count();
    }

}

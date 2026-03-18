package org.webflux.publisher;

import org.webflux.subscriber.SubscriberImpl;

public class Demo_1 {
    public static void main(String[] args) {
        demo1();
    }

    public static void demo1(){
        var publisher=new PublisherImpl();
        var subscriber=new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
    }

}

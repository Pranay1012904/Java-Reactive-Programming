package org.webflux.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {
    private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);
    private final Subscriber<? super String> subscriber;
    private boolean isCancelled;
    private final Faker faker;
    private static final int MAX_ITEM = 10;
    private int count;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long request) {
        if (isCancelled) return;
        log.info("Subscriber has requested {} items", request);
        for (int i = 0; i < request && count < MAX_ITEM; i++) {
            this.subscriber.onNext(faker.internet().emailAddress());
            count++;
        }
        if (count == MAX_ITEM) {
            log.info("No more data to produce");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }
    }

    @Override
    public void cancel() {
        log.info("Subscriber has canceled!");
        this.isCancelled = true;
    }
}

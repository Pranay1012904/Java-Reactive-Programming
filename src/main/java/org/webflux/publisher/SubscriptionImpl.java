package org.webflux.publisher;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {
    private static final Logger log= LoggerFactory.getLogger(SubscriptionImpl.class);

    @Override
    public void request(long l) {

    }

    @Override
    public void cancel() {

    }
}

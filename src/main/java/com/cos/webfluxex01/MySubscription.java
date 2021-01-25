package com.cos.webfluxex01;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

// 구독 정보
public class MySubscription implements Subscription {

	private Subscriber s;
	private Iterator<Integer> it;

	public MySubscription(Subscriber s, Iterable<Integer> its) {
		this.s = s;
		this.it = its.iterator();
	}

	public void request(long n) {
		System.out.println("3. 신문 " + n + "개 받을께");
		// 구독자한테 신문을 전달
		while (n-- > 0) {
			if (it.hasNext()) {
				s.onNext(it.next());
			} else {
				s.onComplete();
				break;
			}
		}

	}

	public void cancel() {
		System.out.println("구독 취소");
	}

}

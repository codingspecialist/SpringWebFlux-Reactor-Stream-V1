package com.cos.webfluxex01;

import java.util.Arrays;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

// 출판사 = 신문사
public class MyPublisher implements Publisher<Integer>{

	// 배열 10개자리 1,2,3,4,5,6,7,8,9,10
	Iterable<Integer> its = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	
	// 구독!!
	public void subscribe(Subscriber<? super Integer> s) {
		System.out.println("1. 구독 시작");
		s.onSubscribe(new MySubscription(s, its));
	}
	
}

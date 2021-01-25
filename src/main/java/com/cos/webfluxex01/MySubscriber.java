package com.cos.webfluxex01;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

// 구독자 = 일반시민
public class MySubscriber implements Subscriber<Integer>{

	private Subscription s;
	private Integer size = 2;
	
	public void onSubscribe(Subscription s) {
		this.s = s;
		System.out.println("2. 구독 응답 완료"); // 구독 완료
		s.request(size); // 신문 줘!! BackPressure => 난 신문 1개밖에 처리못해!!
	}

	public void onNext(Integer t) { // 신문 전달 메서드
		System.out.println("신문 "+t);
		size --;
		if(size ==0) {
			size = 2;
			s.request(size);	
		}
		
	}

	public void onError(Throwable t) {
		System.out.println("신문 주다가 사고 났어!!");
	}

	public void onComplete() {
		System.out.println("다줬어 이제 줄 신문 없어!!");
	}
	
}

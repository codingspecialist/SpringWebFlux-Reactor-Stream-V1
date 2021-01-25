package com.cos.webfluxex01;

public class App {
	public static void main(String[] args) {
		MyPublisher pub = new MyPublisher();
		MySubscriber sub = new MySubscriber();
		
		// 구독하기 (구독자정보)
		pub.subscribe(sub);
	}
}

package com.kh.sts24;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Test01 {

//	@Test
	public void test1() {
		char a=65;
		log.info("암호화 전: {}", a);
//		암호화방법(알고리즘): +5
		a+=5;
		log.info("암호화 후: {}", a);
		a-=5;
		log.info("복호화 후: {}",a);
		
		String text = "hello";
		
		log.info("암호화 전: {}",text);
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<text.length(); i++) {
			char c = text.charAt(i);
			c +=5;
			buffer.append(c);			
		}
		
		text = buffer.toString();
		log.info("암호화 후: {}",text);
		
		buffer = new StringBuffer();
		for(int i=0; i<text.length(); i++) {
			char c = text.charAt(i);
			c -=5;
			buffer.append(c);			
		}
		
		text = buffer.toString();
		log.info("복호화 후: {}",text);
	}
	@Test
	public void test2() {
		int a = 7;
		log.info("암호화 전 = {}", a);
		a^=10;
		log.info("암호화 후 = {}", a);
		a^=10;
		log.info("복호화 후 = {}", a);
		
		String text = "hello";
		
		log.info("암호화 전: {}",text);
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<text.length(); i++) {
			char c = text.charAt(i);
			c ^=5;
			buffer.append(c);			
		}
		
		text = buffer.toString();
		log.info("암호화 후: {}",text);
		
		buffer = new StringBuffer();
		for(int i=0; i<text.length(); i++) {
			char c = text.charAt(i);
			c ^=5;
			buffer.append(c);			
		}
		
		text = buffer.toString();
		log.info("복호화 후: {}",text);
	}
	
	
}

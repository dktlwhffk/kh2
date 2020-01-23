package com.kh.sts18;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test01 {
	/**
	 * 로깅(Logging)
	 *  -기록을 남기는 행위
	 *  -sysout과 같은 행위
	 *  -log4j, logback 등이 대표적
	 *  -로그 확인을 위한 각종 도구들(시간, 날짜, 형식,...)지원
	 *  
	 *  로깅 수준(logging level)
	 *  -이 메시지의 심각도를 6단계로 구분해놓음(라이브러리마다 상이함)
	 *  -Fatal : 심각
	 *  -Error : 오류
	 *  -Warn : 경고
	 *  -Info : 정보
	 *  -Debug : 개발용
	 *  -Trace : 일상 기록
	 *  
	 *  로거 설정
	 *  
	 */
	
	//도구 생성
//	Logger logger = LoggerFactory.getLogger(Test01.class);
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void test() {
		logger.info("로그 테스트");
		logger.debug("디버그 테스트");
		logger.warn("warn 테스트");
		logger.error("error 테스트");
	}
}

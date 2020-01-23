package com.kh.sts23.service;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ScheduleServiceImpl implements ScheduleService{

	@Override
//	@Scheduled(fixedRate = 1000)
	public void work() {
		log.info("work 메소드 실행");
		log.info("시각 = {}", LocalDateTime.now());
	}

	@Override
//	@Scheduled (cron = "* * * * * *")
	public void work2() {
		log.info("work2 : 매 초마다 실행");
	}

	@Override 
//	@Scheduled (cron ="*/5 * * * * *")
	public void work3() {
		log.info("work3 : 매 5초마다 실행");
	}

	@Override
//	@Scheduled (cron = "5-10 * * * * *")
	public void work4() {
		log.info("work4 : 매 5초~10초 사이에만 실행");	
	}
	
	@Override
//	@Scheduled(cron = "0 0 * * * *")
	public void work5() {
		log.info("work5: 1시간 마다 실행");
	}

	@Override
//	@Scheduled(cron = "* * * * * 2") 화요일
//	@Scheduled(cron = "* * * * * tue") 화요일
	@Scheduled(cron = "0 0 0 ? 1/1 TUE#4")
	public void work6() {
		log.info("work6 실행");
	}
}

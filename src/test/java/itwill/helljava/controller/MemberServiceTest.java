package itwill.helljava.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import itwill.helljava.Enum.PayTypeEnum;
import itwill.helljava.dto.Member;
import itwill.helljava.exception.MemberIdSearchNotFoundException;
import itwill.helljava.exception.MemberNotFoundException;
import itwill.helljava.exception.MemberPwSearchNotFoundException;
import itwill.helljava.service.MemberService;
import itwill.helljava.service.PayService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MemberServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(PtOnceServiceTest.class);

	@Autowired
	private MemberService memberService;

	@Autowired
	private PayService payService;
	/*
	 * @Test public void testSelectMemeberList() { Map<String, Object> map = new
	 * HashMap();
	 * 
	 * map.put("startRow", 1); map.put("endRow", 5); map.put("member_id", "ㄴㄴㄴ");
	 * 
	 * List<Member> memberList = memberService.getMemberList(map);
	 * 
	 * for(Member member : memberList) { logger.info(member.toString()); } }
	 */

	/*
	 * @Test public void testgetSearchMember() throws
	 * MemberIdSearchNotFoundException, MemberPwSearchNotFoundException {
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * 
	 * map.put("memberName", "트레이너1"); map.put("memberPhone", "010-1234-1234");
	 * //map.put("memberId", "trainer1");
	 * 
	 * Member member = memberService.getSearchMember(map);
	 * 
	 * logger.info(member.toString()); }
	 */

	@Test
	public void autoPayTrainer() throws ParseException {

		List<Member> autoMemberList = memberService.getAutoPayMemberList();

		// 파싱할 패턴
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		for (Member autoMember : autoMemberList) {

			// 트레이너 결제 시작일
			String payStartDate = autoMember.getPayStart().substring(0, 10);

			// 최근 결제일 localDate 타입으로 파싱
			LocalDate lastPayDate = LocalDate.parse(payStartDate, formatter);

			// 최근 결제일로부터 30일 더함
			LocalDate payDate = lastPayDate.plusDays(30);

			// 오늘 날짜
			LocalDate now = LocalDate.now();

			// 결제일이 되었을 경우
			if (now.isEqual(payDate)) {

				Map<String, Object> payMap = new HashMap<String, Object>();

				payMap.put("pay_start", String.valueOf(payDate));
				payMap.put("pay_no", autoMember.getPayNo());

				// 결제 일자 최신화
				payService.modifyPay(payMap);

				Map<String, Object> cashMap = new HashMap<String, Object>();
				
				cashMap.put("cash", 15000);
				cashMap.put("cashType", PayTypeEnum.트레이너신청.getValue());
				cashMap.put("memberNo", autoMember.getMemberNo());
				
				// 15,000원 캐시 차감
				memberService.modifyMemberCash(cashMap);
			}
		}
	}
}

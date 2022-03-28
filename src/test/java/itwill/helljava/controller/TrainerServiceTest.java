package itwill.helljava.controller;

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

import itwill.helljava.dto.Member;
import itwill.helljava.dto.Trainer;
import itwill.helljava.service.TrainerService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TrainerServiceTest {

	private static final Logger logger=LoggerFactory.getLogger(PtOnceServiceTest.class);
	
	@Autowired
	private TrainerService trainerService;
	
	@Test
	public void testSelectTrainerList() {
		
		Map<String, Object> map = new HashMap();
		
		map.put("startRow", 1);
		map.put("endRow", 5);
		map.put("member_id", "트레이너예정1");
		map.put("member_status", 2);
		
		List<Trainer> trainerList = trainerService.getTrainerList(map);
		
		for(Trainer member : trainerList) {
			logger.info(member.toString());
		}
	}
}

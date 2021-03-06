package itwill.helljava.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import itwill.helljava.Enum.PtServiceSortationEnum;
import itwill.helljava.Enum.PtServiceStatusEnum;
import itwill.helljava.dto.Member;
import itwill.helljava.dto.PtService;
import itwill.helljava.service.PtServiceService;
import itwill.helljava.service.TrainerService;
import itwill.helljava.util.Auth;
import itwill.helljava.util.Pager;
import itwill.helljava.util.Auth.Role;
import itwill.helljava.util.AuthUser;

@Controller
@RequestMapping("/ptqna")
public class PtQnAController {

	@Autowired
	private PtServiceService ptServiceService;
	
	@Autowired
	private TrainerService trainerService;

/*===================================회원 & 예비트레이너========================================  */
	
	// PT 문의 전체 리스트 요청 처리 메소드 
	@Auth(role=Role.USER_PRETRAINER)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String searchAllList(Model model, @RequestParam(defaultValue = "1") int pageNum,
			@AuthUser Member member) {
		
		// 회원번호 세션으로 받음
		int memberNo = member.getMemberNo();

		// 전체 리스트 게시글 개수 정보 요청을 위한 메소드의 매개변수
		Map<String, Object> countMap = new HashMap<String, Object>();

		countMap.put("pt_service_sortation", PtServiceSortationEnum.피티문의.getValue());
		countMap.put("member_no", memberNo);
		countMap.put("pt_service_status", 234); // 임의의값
		
		int totalBoard = ptServiceService.getPtServiceCount(countMap);
		int pageSize = 3;
		int blockSize = 5;
		int number = totalBoard - (pageNum - 1) * pageSize;

		Pager pager = new Pager(pageNum, totalBoard, pageSize, blockSize);
		
		Map<String, Object> pagerMap = new HashMap<String, Object>();
		pagerMap.put("startRow", pager.getStartRow());
		pagerMap.put("endRow", pager.getEndRow());
		pagerMap.put("pt_service_sortation", PtServiceSortationEnum.피티문의.getValue());
		pagerMap.put("pt_service_status", 345); // 임의의값
		pagerMap.put("member_no", memberNo);

		model.addAttribute("pager", pager);
		model.addAttribute("ptQnaList", ptServiceService.getPtServiceList(pagerMap));
		model.addAttribute("number", number);
		
		return "/user/ptQnA/ptQnA_list";
	}

	// 확인, 미확인 여부 리스트 페이지 요청 처리 메소드
	@Auth(role=Role.USER_PRETRAINER)
	@RequestMapping(value = "/list/status", method = RequestMethod.GET)
	public String searchList(Model model, @RequestParam(defaultValue = "1") int pageNum,
			@RequestParam String confirmStatus, @AuthUser Member member) {
		
		// 회원번호 세션으로 받음
		int memberNo = member.getMemberNo();

		// 게시글 갯수 정보 호출을 위한 메소드의 매개변수 
		Map<String, Object> countMap = new HashMap<String, Object>();

		countMap.put("pt_service_sortation", PtServiceSortationEnum.피티문의.getValue());
		countMap.put("member_no", memberNo);
		countMap.put("pt_service_status", Integer.parseInt(confirmStatus)); // 전체일 경우 9니까 넘겨봤자임

		int totalBoard = ptServiceService.getPtServiceCount(countMap);
		int pageSize = 3;
		int blockSize = 5;
		int number = totalBoard - (pageNum - 1) * pageSize;

		Pager pager = new Pager(pageNum, totalBoard, pageSize, blockSize);

		// 리스트 요청을 위한 메소드의 매개변수
		Map<String, Object> pagerMap = new HashMap<String, Object>();
		pagerMap.put("startRow", pager.getStartRow());
		pagerMap.put("endRow", pager.getEndRow());
		pagerMap.put("pt_service_sortation", PtServiceSortationEnum.피티문의.getValue());
		pagerMap.put("pt_service_status", Integer.parseInt(confirmStatus));
		pagerMap.put("member_no", memberNo);

		model.addAttribute("pager", pager);
		model.addAttribute("ptQnaList", ptServiceService.getPtServiceList(pagerMap));
		model.addAttribute("status",confirmStatus);
		model.addAttribute("number", number);

		return "/user/ptQnA/ptQnA_list";
	}

	// PT 문의 수정 요청 처리 메소드
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute PtService ptService) {

		ptServiceService.modifyPtService(ptService);
		return "redirect:/ptqna/list";
	}
	
	
	/*===================================  트레이너  ======================================  */	

	//  PT 문의 리스트 최초 화면 요청 처리 메소드 
	@Auth(role=Role.TRAINER)
	@RequestMapping(value = "/trainer/list", method = RequestMethod.GET)
	public String searchAllList2(Model model, @RequestParam(defaultValue = "1") int pageNum,
			@AuthUser Member member) {
		
		// 트레이너 번호 세션으로 받음
		int trainerNo = trainerService.getTrainer(member.getMemberNo()).getTrainerNo();
		
		// 트레이너 수 정보를 요청하기 위한 메소드의 매개변수
		Map<String, Object> countMap = new HashMap<String, Object>();

		countMap.put("pt_service_sortation", PtServiceSortationEnum.피티문의.getValue());
		countMap.put("trainer_no", trainerNo);
		countMap.put("pt_service_status", 234); // 임의의값
		
		int totalBoard = ptServiceService.getPtServiceTrainerCount(countMap);
		int pageSize = 3;
		int blockSize = 5;
		int number = totalBoard - (pageNum - 1) * pageSize;

		Pager pager = new Pager(pageNum, totalBoard, pageSize, blockSize);
		
		Map<String, Object> pagerMap = new HashMap<String, Object>();
		pagerMap.put("startRow", pager.getStartRow());
		pagerMap.put("endRow", pager.getEndRow());
		pagerMap.put("pt_service_sortation", PtServiceSortationEnum.피티문의.getValue());
		pagerMap.put("pt_service_status", 345); // 임의의값
		pagerMap.put("trainer_no", trainerNo);

		model.addAttribute("pager", pager);
		model.addAttribute("ptQnaList", ptServiceService.getPtServiceTrainerList(pagerMap));
		model.addAttribute("number", number);
		
		return "/user/trainer/trainer_ptQnA_list";
	}

	// 확인, 미확인 여부 리스트 페이지 요청 처리 메소드
	@Auth(role=Role.TRAINER)
	@RequestMapping(value = "/trainer/list/status", method = RequestMethod.GET)
	public String searchList2(Model model, @RequestParam(defaultValue = "1") int pageNum,
			@RequestParam String confirmStatus, @AuthUser Member member) {
		
		// 트레이너 번호 세션으로 받음
		int trainerNo = trainerService.getTrainer(member.getMemberNo()).getTrainerNo();

		// 상태별 트레이너 수 정보 요청 메소드를 위한 매개변수 
		Map<String, Object> countMap = new HashMap<String, Object>();

		countMap.put("pt_service_sortation", PtServiceSortationEnum.피티문의.getValue());
		countMap.put("trainer_no", trainerNo);
		countMap.put("pt_service_status", Integer.parseInt(confirmStatus)); // 임의의값
		
		int totalBoard = ptServiceService.getPtServiceTrainerCount(countMap);
		int pageSize = 3;
		int blockSize = 5;
		int number = totalBoard - (pageNum - 1) * pageSize;

		Pager pager = new Pager(pageNum, totalBoard, pageSize, blockSize);

		Map<String, Object> pagerMap = new HashMap<String, Object>();
		pagerMap.put("startRow", pager.getStartRow());
		pagerMap.put("endRow", pager.getEndRow());
		pagerMap.put("pt_service_sortation", PtServiceSortationEnum.피티문의.getValue());
		pagerMap.put("pt_service_status", Integer.parseInt(confirmStatus));
		pagerMap.put("trainer_no", trainerNo);

		model.addAttribute("pager", pager);
		model.addAttribute("ptQnaList", ptServiceService.getPtServiceTrainerList(pagerMap));
		model.addAttribute("status",Integer.parseInt(confirmStatus));
		model.addAttribute("number", number);

		return "/user/trainer/trainer_ptQnA_list";
	}

	// PT 완료 후 status 수정하는 메소드
	@Auth(role=Role.TRAINER)
	@RequestMapping(value = "/trainer/modify/{ptServiceNo}/{status}", method = RequestMethod.GET)
	public String modifyStatus(@PathVariable(value = "ptServiceNo") int ptServiceNo,
			@PathVariable(value = "status") int status) {
		
		PtService ptService = ptServiceService.getPtService(ptServiceNo);
		
		ptService.setPtServiceStatus(status);
		ptServiceService.modifyPtService(ptService);

		return "redirect:/ptqna/trainer/list";
		}
}

package itwill.helljava.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import itwill.helljava.dao.PtServiceDAO;
import itwill.helljava.dto.PtService;

@Service
public class PtServiceServiceImpl implements PtServiceService {
	@Autowired
	private PtServiceDAO ptServiceDAO;
	
	@Transactional
	@Override
	public void addPtService(PtService ptService) {
		ptServiceDAO.insertPtService(ptService);
	}
	
	@Transactional
	@Override
	public void modifyPtService(PtService ptService) {
		ptServiceDAO.updatePtService(ptService);
	}
	
	@Transactional
	@Override
	public void modifyPtServiceGood(int pt_service_no) {
		ptServiceDAO.updatePtServiceGood(pt_service_no);
	}

	@Override
	public int getPtServiceCount(Map<String, Object> map) {
		return ptServiceDAO.selectPtServiceCount(map);
	}

	@Override
	public int getPtServiceTrainerCount(Map<String, Object> map) {
		return ptServiceDAO.selectPtServiceTrainerCount(map);
	}

	@Override
	public PtService getPtService(int pt_service_no) {
		return ptServiceDAO.selectPtService(pt_service_no);
	}

	@Override
	public PtService getPtServiceReview(Map<String, Object> map) {
		return ptServiceDAO.selectPtServiceReview(map);
	}
	
	@Override
	public List<PtService> getPtServiceList(Map<String, Object> map) {
		return ptServiceDAO.selectPtServiceList(map);
	}

	@Override
	public List<PtService> getPtServiceTrainerList(Map<String, Object> map) {
		return ptServiceDAO.selectPtServiceTrainerList(map);
	}

	@Override
	public List<PtService> getReviewGoodList() {
		return ptServiceDAO.selectReviewGoodList();
	}

}

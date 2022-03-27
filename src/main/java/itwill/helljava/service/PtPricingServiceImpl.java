package itwill.helljava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import itwill.helljava.dao.PtPricingDAO;
import itwill.helljava.dto.PtPricing;

@Service
public class PtPricingServiceImpl implements PtPricingService {
	
	@Autowired
	private PtPricingDAO ptPricingDAO;
	
	@Transactional
	@Override
	public void addPtPricing(PtPricing ptPricing) {
		ptPricingDAO.insertPtPricing(ptPricing);
	}
	
	@Transactional
	@Override
	public void modifyPtPricing(PtPricing ptPricing) {
		ptPricingDAO.updatePtPricing(ptPricing);
	}

	@Override
	public List<PtPricing> getPtPricingList(int trainer_no) {
		return ptPricingDAO.selectPtPricingList(trainer_no);
	}

}

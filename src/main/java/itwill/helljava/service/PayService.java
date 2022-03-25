package itwill.helljava.service;

import java.util.List;
import java.util.Map;

import itwill.helljava.dto.Pay;

public interface PayService {

	void addPay(Pay pay);
	void modifyPay(Pay pay);
	//void removePay(int pay_no); // 결제 데이터를 삭제할 일은 없을듯..
	int getPayCount();
	Pay getPay(int pay_no);
	List<Pay> getPayList(Map<String, Object> map);
	
	
}

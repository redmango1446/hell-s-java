package itwill.helljava.dto;

public class Pay {

	int payNo;
	int memberNo;
	String payStart;
	int payPrice;
	int payType;

	
	public int getPayNo() {
		return payNo;
	}

	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getPayStart() {
		return payStart;
	}

	public void setPayStart(String payStart) {
		this.payStart = payStart;
	}

	public int getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

}

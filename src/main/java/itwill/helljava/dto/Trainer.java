package itwill.helljava.dto;

public class Trainer {
	private int trainerNo;
	private int memberNo;
	private String trainerProfileImg;
	private String trainerAddress;
	private String trainerCentername;
	private String trainerZip;

	private String memberId;
	private String memberName;
	private String memberPhone;
	private String memberEmail;
	private String memberStatus;


	private String postingSelfIntroduction;
	private String postingProgramIntroduction;

	
	public Trainer() {
		// TODO Auto-generated constructor stub
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	
	public String getPostingSelfIntroduction() {
		return postingSelfIntroduction;
	}

	public void setPostingSelfIntroduction(String postingSelfIntroduction) {
		this.postingSelfIntroduction = postingSelfIntroduction;
	}

	public String getPostingProgramIntroduction() {
		return postingProgramIntroduction;
	}

	public void setPostingProgramIntroduction(String postingProgramIntroduction) {
		this.postingProgramIntroduction = postingProgramIntroduction;
	}

	public String getTrainerCentername() {
		return trainerCentername;
	}

	public void setTrainerCentername(String trainerCentername) {
		this.trainerCentername = trainerCentername;
	}


	public int getTrainerNo() {
		return trainerNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public void setTrainerNo(int trainerNo) {
		this.trainerNo = trainerNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getTrainerProfileImg() {
		return trainerProfileImg;
	}

	public void setTrainerProfileImg(String trainerProfileImg) {
		this.trainerProfileImg = trainerProfileImg;
	}

	public String getTrainerAddress() {
		return trainerAddress;
	}

	public void setTrainerAddress(String trainerAddress) {
		this.trainerAddress = trainerAddress;
	}

	public String getTrainerZip() {
		return trainerZip;
	}

	public void setTrainerZip(String trainerZip) {
		this.trainerZip = trainerZip;
	}

	@Override
	public String toString() {
		return "Trainer [trainerNo=" + trainerNo + ", memberNo=" + memberNo + ", trainerProfileImg=" + trainerProfileImg
				+ ", trainerAddress=" + trainerAddress + ", trainerCentername=" + trainerCentername + ", trainerZip="
				+ trainerZip + ", memberId=" + memberId + ", memberName=" + memberName + ", memberPhone=" + memberPhone
				+ ", memberEmail=" + memberEmail + ", memberStatus=" + memberStatus + ", postingSelfIntroduction="
				+ postingSelfIntroduction + ", postingProgramIntroduction=" + postingProgramIntroduction + "]";
	}

	

}

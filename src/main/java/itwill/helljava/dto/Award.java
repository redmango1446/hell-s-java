package itwill.helljava.dto;

public class Award {

	private int awardNo;
	private int trainerNo;
	private String awardContent;
	private String awardImage;

	public int getAwardNo() {
		return awardNo;
	}

	public void setAwardNo(int awardNo) {
		this.awardNo = awardNo;
	}

	public int getTrainerNo() {
		return trainerNo;
	}

	public void setTrainerNo(int trainerNo) {
		this.trainerNo = trainerNo;
	}

	public String getAwardContent() {
		return awardContent;
	}

	public void setAwardContent(String awardContent) {
		this.awardContent = awardContent;
	}

	public String getAwardImage() {
		return awardImage;
	}

	public void setAwardImage(String awardImage) {
		this.awardImage = awardImage;
	}
}

package itwill.helljava.service;

import java.util.List;

import itwill.helljava.dto.Posting;

public interface PostingService {

	void addPosting(Posting posting);

	void modifyPosting(Posting posting);

	Posting getPosting(int trainer_no);
}

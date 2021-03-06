package itwill.helljava.service;

import java.util.List;
import java.util.Map;

import itwill.helljava.dto.NoticeService;

public interface NoticeServiceService {

	void addNoticeService(NoticeService noticeService);

	void modifyNoticeService(NoticeService noticeService);

	void modifyReplyNoticeService(NoticeService noticeService);

	// 공지사항, FAQ 조회수 올리는 메서드
	void modifyNoticeServiceHits(int noticeServiceNo);

	void removeNoticeService(int noticeServiceNo);

	// 1:1 공지사항&FAQ 게시글 카운트 (검색 있음 제목, 내용, 이름(1:1문의 관리자) 검색)
	int getNoticeServiceCount(Map<String, Object> map);

	// FAQ 게시글 갯수
	int getNoticeServiceFaqCount(int noticeServiceCategory);

	// 검색과 카테고리 FAQ 게시글 개수
	int getNoticeServiceFaqSearchCount(Map<String, Object> map);

	int getNoticeServicePersonalCount(Map<String, Object> map);

	// 합친 DB이기 때문에 구분하려면 혹시 몰라서 글 구분 매개변수도 추가함. (공지사항&FAQ)
	NoticeService getNoticeService(int notice_service_no);

	// 마찬가지로 글 구분 매개변수도 추가함
	List<NoticeService> getNoticeServiceList(Map<String, Object> map);

	// FAQ 리스트 뽑기
	List<NoticeService> getNoticeServiceFaqList(Map<String, Object> map);
	
	// 검색, 카테고리 포함 FAQ 리스트 뽑기
	List<NoticeService> getNoticeServiceFaqSearchList(Map<String, Object> map);

	List<NoticeService> getNoticeServicePersonalList(Map<String, Object> map);
}

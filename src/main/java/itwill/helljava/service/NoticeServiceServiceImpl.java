package itwill.helljava.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import itwill.helljava.dao.NoticeServiceDAO;
import itwill.helljava.dto.NoticeService;

@Service
public class NoticeServiceServiceImpl implements NoticeServiceService {

	@Autowired
	private NoticeServiceDAO noticeServiceDAO;

	@Override
	@Transactional
	public void addNoticeService(NoticeService noticeService) {
		noticeServiceDAO.insertNoticeService(noticeService);
	}

	@Override
	@Transactional
	public void modifyNoticeService(NoticeService noticeService) {
		noticeServiceDAO.updateNoticeService(noticeService);
	}

	@Override
	@Transactional
	public void modifyReplyNoticeService(NoticeService noticeService) {
		noticeServiceDAO.updateReplyNoticeService(noticeService);
	}

	@Override
	public void modifyNoticeServiceHits(int noticeServiceNo) {
		noticeServiceDAO.updateNoticeServiceHits(noticeServiceNo);
	}

	@Override
	public void removeNoticeService(int noticeServiceNo) {
		noticeServiceDAO.deleteNoticeService(noticeServiceNo);
	}

	@Override
	public int getNoticeServiceCount(Map<String, Object> map) {
		return noticeServiceDAO.selectNoticeServiceCount(map);
	}

	@Override
	public int getNoticeServiceFaqCount(int noticeServiceCategory) {
		return noticeServiceDAO.selectNoticeServiceFaqCount(noticeServiceCategory);
	}

	@Override
	public int getNoticeServiceFaqSearchCount(Map<String, Object> map) {
		return noticeServiceDAO.selectNoticeServiceFaqSearchCount(map);
	}

	@Override
	public int getNoticeServicePersonalCount(Map<String, Object> map) {
		return noticeServiceDAO.selectNoticeServicePersonalCount(map);
	}

	@Override
	public NoticeService getNoticeService(int notice_service_no) {
		return noticeServiceDAO.selectNoticeService(notice_service_no);
	}

	@Override
	public List<NoticeService> getNoticeServiceList(Map<String, Object> map) {
		return noticeServiceDAO.selectNoticeServiceList(map);
	}

	@Override
	public List<NoticeService> getNoticeServiceFaqList(Map<String, Object> map) {
		return noticeServiceDAO.selectNoticeServiceFaqList(map);
	}
	
	@Override
	public List<NoticeService> getNoticeServiceFaqSearchList(Map<String, Object> map) {
		return noticeServiceDAO.selectNoticeServiceFaqSearchList(map);
	}

	@Override
	public List<NoticeService> getNoticeServicePersonalList(Map<String, Object> map) {
		return noticeServiceDAO.selectNoticeServicePersonalList(map);
	}

}

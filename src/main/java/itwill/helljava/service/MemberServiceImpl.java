package itwill.helljava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import itwill.helljava.dao.MemberDAO;
import itwill.helljava.dto.Member;

public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public void addMember(Member member) {
		memberDAO.insertMember(member);
	}

	@Override
	public void modifyMember(Member member) {
		memberDAO.updateMember(member);
	}

	@Override
	public Member getMember(int member_no) {
		return memberDAO.selectMember(member_no);
	}

	@Override
	public List<Member> getMemberList() {
		return memberDAO.selectMemberList();
	}
}
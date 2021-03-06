package itwill.helljava.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import itwill.helljava.dto.Pay;
import itwill.helljava.mapper.PayMapper;

@Repository
public class PayDAOImpl implements PayDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertPay(Pay pay) {
		return sqlSession.getMapper(PayMapper.class).insertPay(pay);
	}

	@Override
	public int updatePay(Map<String, Object> map) {
		return sqlSession.getMapper(PayMapper.class).updatePay(map);
	}

	@Override
	public int selectPayCount(int member_no) {
		return sqlSession.getMapper(PayMapper.class).selectPayCount(member_no);
	}

	@Override
	public Pay selectPay(Map<String, Object> map) {
		return sqlSession.getMapper(PayMapper.class).selectPay(map);
	}

	@Override
	public List<Pay> selectPayList(Map<String, Object> map, int member_no) {
		return sqlSession.getMapper(PayMapper.class).selectPayList(map, member_no);
	}

}

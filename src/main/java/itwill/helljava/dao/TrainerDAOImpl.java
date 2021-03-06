package itwill.helljava.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import itwill.helljava.dto.Member;
import itwill.helljava.dto.Trainer;
import itwill.helljava.mapper.TrainerMapper;

@Repository
public class TrainerDAOImpl implements TrainerDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertTrainer(Trainer trainer) {
		return sqlSession.getMapper(TrainerMapper.class).insertTrainer(trainer);
	}

	@Override
	public int updateTrainer(Trainer trainer) {
		return sqlSession.getMapper(TrainerMapper.class).updateTrainer(trainer);
	}

	@Override
	public int selectTrainerListCount(Map<String, Object> map) {
		return sqlSession.getMapper(TrainerMapper.class).selectTrainerListCount(map);
	}

	@Override
	public int selectMainPageTrainerListCount(Map<String, Object> map) {
		return sqlSession.getMapper(TrainerMapper.class).selectMainPageTrainerListCount(map);
	}

	@Override
	public Trainer selectTrainer(int memberNo) {
		return sqlSession.getMapper(TrainerMapper.class).selectTrainer(memberNo);
	}

	@Override
	public Trainer selectTrainerTrainerNo(int trainerNo) {
		return sqlSession.getMapper(TrainerMapper.class).selectTrainerTrainerNo(trainerNo);
	}

	@Override
	public List<Trainer> selectTrainerList(Map<String, Object> map) {
		return sqlSession.getMapper(TrainerMapper.class).selectTrainerList(map);
	}

	@Override
	public List<Trainer> selectMainPageTrainerList(Map<String, Object> map) {
		return sqlSession.getMapper(TrainerMapper.class).selectMainPageTrainerList(map);
	}

	@Override
	public List<Trainer> selectMonthTrainer() {
		return sqlSession.getMapper(TrainerMapper.class).selectMonthTrainer();
	}
}

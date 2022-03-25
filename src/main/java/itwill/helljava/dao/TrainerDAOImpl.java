package itwill.helljava.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public int deleteTrainer(Trainer trainer) {
		return sqlSession.getMapper(TrainerMapper.class).deleteTrainer(trainer);
	}

	@Override
	public int selectTrainerCount() {
		return sqlSession.getMapper(TrainerMapper.class).selectTrainerCount();
	}

	@Override
	public Trainer selectTrainer(int trainer_no) {
		return sqlSession.getMapper(TrainerMapper.class).selectTrainer(trainer_no);
	}

	@Override
	public List<Trainer> selectTrainerList() {
		return sqlSession.getMapper(TrainerMapper.class).selectTrainerList();
	}
	
	
}

package record_backend.rms.serviceImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import record_backend.rms.service.RmsService;
import record_backend.rms.vo.RmsVO;

@Service
public class RmsServiceImpl implements RmsService {

    private static final String NAMESPACE = "rms.";

    private final SqlSessionTemplate sqlSession;

    public RmsServiceImpl(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<RmsVO> selectRmsList() {
        return sqlSession.selectList(NAMESPACE + "selectRmsList");
    }

    @Override
    public RmsVO selectRms(Long id) {
        RmsVO result = sqlSession.selectOne(NAMESPACE + "selectRms", id);

        if (result == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다."
            );
        }

        return result;
    }

    @Override
    @Transactional
    public RmsVO insertRms(RmsVO vo) {
        sqlSession.insert(NAMESPACE + "insertRms", vo);
        return selectRms(vo.getId());
    }

    @Override
    @Transactional
    public RmsVO updateRms(Long id, RmsVO vo) {
        selectRms(id);

        vo.setId(id);
        sqlSession.update(NAMESPACE + "updateRms", vo);

        return selectRms(id);
    }

    @Override
    @Transactional
    public void deleteRms(Long id) {
        selectRms(id);
        sqlSession.delete(NAMESPACE + "deleteRms", id);
    }
}
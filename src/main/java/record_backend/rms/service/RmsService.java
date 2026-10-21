package record_backend.rms.service;

import java.util.List;
import record_backend.rms.vo.RmsVO;

public interface RmsService {

    List<RmsVO> selectRmsList();
    RmsVO selectRms(Long id);
    RmsVO insertRms(RmsVO vo);
    RmsVO updateRms(Long id, RmsVO vo);
    void deleteRms(Long id);
}
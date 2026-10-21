
package record_backend.rms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import record_backend.rms.service.RmsService;
import record_backend.rms.vo.RmsVO;

@RestController
@RequestMapping("/api/rms")
public class RmsController {

    private final RmsService rmsService;

    public RmsController(RmsService rmsService) {
        this.rmsService = rmsService;
    }

    // 전체 조회
    @GetMapping
    public List<RmsVO> selectRmsList() {
        return rmsService.selectRmsList();
    }

    // 상세 조회
    @GetMapping("/{id}")
    public RmsVO selectRms(@PathVariable Long id) {
        return rmsService.selectRms(id);
    }

    // 등록
    @PostMapping
    public ResponseEntity<Map<String, Object>> insertRms(
            @Valid @RequestBody RmsVO vo) {

        rmsService.insertRms(vo);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "등록이 완료되었습니다.");
        response.put("id", vo.getId());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateRms(
            @PathVariable Long id,
            @Valid @RequestBody RmsVO vo) {

        vo.setId(id);
        rmsService.updateRms(id, vo);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "수정이 완료되었습니다.");
        response.put("id", id);

        return ResponseEntity.ok(response);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteRms(
            @PathVariable Long id) {

        rmsService.deleteRms(id);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "삭제가 완료되었습니다.");
        response.put("id", id);

        return ResponseEntity.ok(response);
    }
}
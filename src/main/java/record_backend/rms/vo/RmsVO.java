package record_backend.rms.vo;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RmsVO {

    private Long id;

    @NotBlank
    @Size(max = 50)
    private String topic;

    @NotBlank
    @Size(max = 200)
    private String title;

    @Size(max = 500)
    private String subtitle;

    @NotBlank
    private String content;

    // 로그 기본 정보
    private String logType;
    private String systemName;
    private String dbType;
    private String sqlId;
    private String sourceClass;

    // SQL 분석
    private String originalSql;
    private String optimizedSql;
    private String relatedTables;

    // 성능 측정
    private Long executionMs;
    private Long optimizedMs;

    // 분석 및 해결 방법
    private String analysis;
    private String solution;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
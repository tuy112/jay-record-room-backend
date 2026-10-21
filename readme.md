## Jay-record-room 백엔드 개발

---

### 구성
- 가계부
- 운동기록방
- 일기장
- 정보처리기사
- 코딩지식
- 기록관리시스템 (RMS)

## 백엔드 파일구조
```declarative
record-backend/
│
├── build.gradle
├── settings.gradle
│
└── src/
    └── main/
        ├── java/com/jstory/record/
        │   │
        │   ├── RecordApplication.java
        │   │
        │   ├── account/                    # 가계부 API
        │   │   ├── controller/
        │   │   │   └── AccountController.java
        │   │   ├── service/
        │   │   │   └── AccountService.java
        │   │   ├── serviceImpl/
        │   │   │   └── AccountServiceImpl.java
        │   │   └── vo/
        │   │       └── AccountVO.java
        │   │
        │   ├── exercise/                   # 운동기록방 API
        │   │   ├── controller/
        │   │   │   └── ExerciseController.java
        │   │   ├── service/
        │   │   │   └── ExerciseService.java
        │   │   ├── serviceImpl/
        │   │   │   └── ExerciseServiceImpl.java
        │   │   └── vo/
        │   │       └── ExerciseVO.java
        │   │
        │   ├── diary/                      # 일기장 API
        │   │   ├── controller/
        │   │   │   └── DiaryController.java
        │   │   ├── service/
        │   │   │   └── DiaryService.java
        │   │   ├── serviceImpl/
        │   │   │   └── DiaryServiceImpl.java
        │   │   └── vo/
        │   │       └── DiaryVO.java
        │   │
        │   ├── eip/                        # 정보처리기사 공부방 API
        │   │   ├── controller/
        │   │   │   └── EipController.java
        │   │   ├── service/
        │   │   │   └── EipService.java
        │   │   ├── serviceImpl/
        │   │   │   └── EipServiceImpl.java
        │   │   └── vo/
        │   │       └── EipVO.java
        │   │
        │   ├── coding/                     # 코딩지식 API
        │   │   ├── controller/
        │   │   │   └── CodingController.java
        │   │   ├── service/
        │   │   │   └── CodingService.java
        │   │   ├── serviceImpl/
        │   │   │   └── CodingServiceImpl.java
        │   │   └── vo/
        │   │       └── CodingVO.java
        │   │
        │   └── rms/                        # RMS API
        │       ├── controller/
        │       │   └── RmsController.java
        │       ├── service/
        │       │   └── RmsService.java
        │       ├── serviceImpl/
        │       │   └── RmsServiceImpl.java
        │       └── vo/
        │           └── RmsVO.java
        │
        └── resources/
            ├── application.yml
            └── application-prod.yml
```

---

### JAR 빌드
.\gradlew.bat clean bootJar

### 빌드된 JAR 실행
java -jar .\build\libs\record-backend-0.0.1-SNAPSHOT.jar
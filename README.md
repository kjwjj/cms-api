### 프로젝트 클론
- git clone https://github.com/kjwjj/cms-api
- cd cms-api

### 실행 방법
- spring boot -> ./gradlew bootRun
- IDE -> Application클래스 실행

### 구현 내용
- 게시물 CRUD
- 페이징 처리
- 조회수 증가
- 권한 처리

### 인증
- Spring Security 기반 로그인 인증
- Role 기반 접근 제어(ADMIN/USER)
- test1 / 1234, bob / 1234

### 로그인 방식
- Spring Secruity의 HTTP Basci Authentication방식을 사용하여 로그인 기능 구현
- 사용자 정보 Member테이블에 저장
- 인증은 UserDetailsService를 통해 처리
- 비밀번호는 BCryptPasswordEncdoer를 사용하여 암호화 (1234->$2a$10$QEG5HOzsuZUTssEtTfHg5.PTlIlnewE/u9Wuj.esTyseFg7hNdPHS)

### Chat GPT도움
- Gpt를 참고하여 일부 코드 구조 및 설명을 보완

### REST API Docs
- Rest API 테스트 및 문서는 Postman Collection을 통해 확인 가능
- Rest API 문서 링크 : https://documenter.getpostman.com/view/40403538/2sBXcLgHQP




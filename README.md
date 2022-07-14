# 계산기 프로젝트

### (선택) API 명세서
- **Swagger** / RestDocs 같은 툴사용 or 직접 작성
- Swagger 적용 (OK)
- API 별로 Swagger 관련 내용 작성 필요

## [기능]
### 히스토리
- 계산식과 결과를 저장 (OK)
- 로그인기능 추가할 경우 로그인한 유저의 히스토리만 
### DB
- 히스토리 저장 : H2 in-memory 사용 (OK)
- mysql 로 변경(OK)

### (선택) https
- 블로그 키생성/적용 관련 내용 참조함 (OK)
### (선택) 로그인
- 쿠키 : 가장 간단하게 먼저.. 로그인 체크 중복인것은 인터셉터로 해야함
- 세션
- JWT
### (선택) 배포
#### nginx (OK)
- 리버스 프록시 역할, 80포트 요청을 8080으로 보내준다. 로그밸런싱, 무중단 서비스등..
- app 도커 빌드 : docker build -t ktchae/calc:0.0.2 .
- nginx 도커 빌드 : docker build -t ktchae/nginx:0.0.1 .
- app 도커 이미지로 2개의 서버를 띄우고, 8888/8889 포트를 8080으로 받음
- 로컬에서 nginx 를 띄워서 80포트 -> 8888/8889 각 app 컨테이너로 로그밸런싱 동작함
- nginx 도커 이미지로 서버 띄우고는 8888/8889로 연결이 안됨..


## [동작]
### (기본) 사칙연산 적용
- 기본 연산자 4개 선택, 피연산자는 2개만? (OK)
- 사칙연산에 대한 예외처리, 정확성(BigDecimal) 확인 필요

#### (선택) 로그인 시 공학용 계산기 적용
- ~~추가 연산은? : log 같은건가?~~
- 로그인시 다른 화면 나옴 (OK)
- 로그인 사용자의 히스토리만 보이게

### 히스토리 CRUD
- C : 계산할때마다 history 생성 (OK)
- R : 히스토리 조회 (OK)
- _**U : 무엇을 업데이트? 불러온 다음에 변경??**_
- D : 히스토리 삭제 (OK)  
      웹 front 에서는 JS로 삭제 (OK)
#### (선택) 페이징
- 히스토리 조회 API에 페이징 구현 (OK) 
- 웹 front 에는 안구현.
#### (선택) 원하는 시점으로 백업 가능한 기능
- _**무슨말인지 이해안됨, 과거 계산내용?**_

### 추가선택
- Exception 처리 (RestControllerAdvice 추가 해봄)
- 로깅처리 : 로그서비스로 level, 로그파일, 로그 출력 패턴 적용(OK)
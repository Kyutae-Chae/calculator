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

### (선택) https
- 키생성 방법
```
keytool -genkey -alias keystore -keyalg  RSA -keystore keystore.pkcs12 -sto
retype pkcs12
keytool -export -alias keystore -keystore keystore.pkcs12 -rfc -file certfi
le.cer

```
### (선택) 로그인
- 안해봤는데 해봐야할거 같음
### (선택) 배포
#### nginx

## [동작]
### (기본) 사칙연산 적용
- 기본 연산자 4개 선택, 피연산자는 2개만? (OK)
- 사칙연산에 대한 예외처리, 정확성(BigDecimal) 확인 필요

#### (선택) 로그인 시 공학용 계산기 적용
- ~~추가 연산은? : log 같은건가?~~
- 로그인시 다른 화면 나오고, 추가기능 약간

### 히스토리 CRUD
- C : 계산할때마다 history 생성 (OK)
- R : 히스토리 조회 (OK)
- _**U : 무엇을 업데이트? 불러온 다음에 변경??**_
- D : 히스토리 삭제
#### (선택) 페이징
- 히스토리 조회에 페이징 구현 / 해봤던거니 해보자
#### (선택) 원하는 시점으로 백업 가능한 기능
- _**무슨말인지 이해안됨, 과거 계산내용?**_

### 추가선택
- Exception 처리
- 로깅처리
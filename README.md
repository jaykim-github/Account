# Account(계좌 관리) 프로젝트
- 제로베이스 강의를 바탕으로 생성된 프로젝트 입니다.

<br>

:page_with_curl: 프로젝트 소개
- 사용자와 계좌의 정보를 저장하고 있으며, 외부 시스템에서 거래를 요청할 경우 거래 정보를 받아서 계좌에서 잔액을 거래금액만큼 줄이거나(결제), 거래금액만큼 늘리는(결제 취소) 거래 관리 기능을 제공하
- 구현의 편의를 위해 사용자 생성 등의 관리는 API로 제공하지 않고 프로젝트 시작 시 자동으로 데이터가 입력되도록 하며, 계좌 추가/해지/확인, 거래 생성/거래 취소/거래 확인의 6가지 API를 제공

<br> 

:books: 프로젝트 스택
- Spring boot와 Java를 활용
- 단위테스트를 작성하여 작성한 코드를 검증
- DB는 H2 DB(memory DB 모드)를 활용
- DB를 접근하는 방법은 Spring data jpa를 활용
- 동시성 제어를 위한 Embedded redis를 활용
- API Request body와 Response body는 json 타입으로 표현
- 각각의 API들은 각자의 요청과 응답 객체 구조를 가짐

<br>

:black_circle: 프로젝트 기능

<br>

:one: 계좌 관련 API
<br>
1. 계좌 생성 
- 파라미터 : 사용자 아이디, 초기 잔액
- 결과 : 성공 시 사용자 아이디, 생성된 계좌번호(랜덤 10자리숫자), 등록 일시(LocalDateTime)

<br>

2. 계좌 해지
- 파라미터 : 사용자 아이디, 계좌 번호
- 결과 : 성공 시 사용자 아이디, 계좌번호, 해지 일시

<br>

3. 계좌 확인
- 파라미터 : 사용자 아이디
- 결과 : 계좌번호, 잔액 정보를 Json List 형식으로 응답

<br>

----------------------------

<br>

:two: 거래 관련 API

<br>

1. 잔액 사용    
- 파라미터 : 사용자 아이디, 계좌 번호, 거래 금액
- 결과 : 계좌번호, Transaction_result, Transaction_id, 거래금액, 거래 일시

<br>

2. 잔액 사용 취소
- 파라미터 : Transaction_id, 계좌번호, 거래금액
- 결과 : 계좌번호, Transaction_result, Transaction_id, 취소 거래금액, 취소 거래 일시

<br>

3. 거래 확인
- 파라미터 : Transaction_id
- 결과 : 계좌번호, 거래종류(잔액 사용, 잔액 사용 취소), Transaction_result, Transaction_id, 거래금액, 거래일시

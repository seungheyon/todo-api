Todo-list api
========

#### 할 일 목록을 작성하는 api 입니다. 

기능 요구사항
-------------

### 필수 요구사항
* 할 일(task) 을 저장하는 api 를 작성합니다.
* 할 일을 조회하는 api 를 작성합니다.
* 할 일 목록을 조회하는 api 를 작성합니다.
* 할 일을 수정하는 api 를 작성합니다.
* 할 일을 삭제하는 api 를 작성합니다.

### 추가 요구사항
* Step 1.
  1. 할 일 완료여부를 나타내는 필드를 추가합니다.
  2. 댓글 기능을 추가합니다. 댓글 작성, 수정, 삭제 api 를 작성하고 할 일 조회 시 댓글목록이 같이 조회되도록 변경합니다.
* Step 2.
  1. 할 일 목록 조회 api에 작성일을 기준으로 오름차순, 내림차순 정렬 기능을 추가합니다.
  2. 할 일 목록 조회 api에 작성자를 기준으로 필터링 기능을 추가합니다.
  3. 할 일 작성, 수정 api에 validation 을 추가합니다.
  4. ResponseEntity 를 사용하여 적절한 응답을 반환합니다.
* Step 3.
  1. 할 일 목록 조회 api에 연관된 댓글 내용을 추가합니다.
  2. 할 일 목록 조회 api에 pagination 기능을 추가합니다.
  3. 회원가입, 로그인 기능을 추가합니다.
 




프로젝트 개요
-------------

* ERD

  ![image](https://github.com/seungheyon/todo-api/assets/71931476/b16e6f10-e19d-4b6a-9903-450f22f3781f)


  
-> 구현 기능까지 반영된 ERD 입니다.

* Api 명세(Notion 링크)

  https://www.notion.so/09546f63d69f455c8c598fdd9bb8da79?v=4fd946163e5b40a79dc2ff9ae12ed97a&pvs=4
  
-> 아직 고민이 필요한 부분은 공란으로 두었습니다.


### 구현한 기능
* 할 일(task) 작성 api
* 할 일 조회 api
* 할 일 목록 조회 api
* 할 일 수정 api
* 할 일 삭제 api
* 할 일 완료 api
* 댓글 작성 api
* 댓글 수정 api
* 댓글 삭제 api
* 할 일 목록 조회 api 에 작성자 이름으로 필터링 기능 추가
* 할 일 작성, 수정 api 에 글자 수 검증 기능 추가
  

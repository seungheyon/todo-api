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
  



### 구현한 기능
* 할 일(task) 작성 api

![image](https://github.com/seungheyon/todo-api/assets/71931476/dfc30bad-3fdb-4cb0-b7f3-74bffe9ede88)
![image](https://github.com/seungheyon/todo-api/assets/71931476/b044129d-af84-41f7-b9b6-f4ff344d2dca)

* 할 일 조회 api

![image](https://github.com/seungheyon/todo-api/assets/71931476/42551779-e025-4c41-8fd7-6fc6da45614c)
![image](https://github.com/seungheyon/todo-api/assets/71931476/c44fdce1-be10-482b-b32b-5dac22c11b0e)

* 할 일 목록 조회 api

![image](https://github.com/seungheyon/todo-api/assets/71931476/5bd11066-e47f-4166-a1f4-fdd3a90b0cb8)
![image](https://github.com/seungheyon/todo-api/assets/71931476/bcf0c5b1-710f-40cf-b31b-c954cc504115)

* 할 일 수정 api

![image](https://github.com/seungheyon/todo-api/assets/71931476/a6fefce3-92b3-41e2-859c-e19cd88334aa)
![image](https://github.com/seungheyon/todo-api/assets/71931476/a661efc4-7ee2-4104-b8dc-54ecde3881c8)

* 할 일 삭제 api

![image](https://github.com/seungheyon/todo-api/assets/71931476/509bfcae-c748-4254-9395-641a47e20320)
![image](https://github.com/seungheyon/todo-api/assets/71931476/a7287ccf-aeca-43ce-880a-b17b2de0c579)

* 할 일 완료 api

![image](https://github.com/seungheyon/todo-api/assets/71931476/825838a7-8568-46ae-91ce-beb81e7d5fe6)
![image](https://github.com/seungheyon/todo-api/assets/71931476/65adec86-e783-4c4d-ba17-ef826111ccd8)

* 댓글 작성 api
* 댓글 수정 api
* 댓글 삭제 api
* 할 일 조회 시 연관된 댓글 조회
* 할 일 목록 조회 api 에 작성자 이름으로 필터링 기능 추가
* 할 일 작성, 수정 api 에 글자 수 검증 기능 추가
  

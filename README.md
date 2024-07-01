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

  ###### 할 일(Task) 엔티티와 댓글(Comment) 엔티티는 양방향 연관관계를 맺고 있습니다.

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

  ###### 모든 수정 기능은 Dirty checking 사용하여 구현하였습니다.

* 할 일 삭제 api

![image](https://github.com/seungheyon/todo-api/assets/71931476/509bfcae-c748-4254-9395-641a47e20320)
![image](https://github.com/seungheyon/todo-api/assets/71931476/a7287ccf-aeca-43ce-880a-b17b2de0c579)

* 할 일 완료 api

![image](https://github.com/seungheyon/todo-api/assets/71931476/825838a7-8568-46ae-91ce-beb81e7d5fe6)
![image](https://github.com/seungheyon/todo-api/assets/71931476/65adec86-e783-4c4d-ba17-ef826111ccd8)

* 댓글 작성 api

![image](https://github.com/seungheyon/todo-api/assets/71931476/46a67d82-58b6-409d-b689-c64eac0f4b54)
![image](https://github.com/seungheyon/todo-api/assets/71931476/aea633a9-0988-40ba-bc2c-b8b422b55aac)

* 댓글 수정 api

![image](https://github.com/seungheyon/todo-api/assets/71931476/7d5885b3-7535-4f89-9d34-002642ac7f46)
![image](https://github.com/seungheyon/todo-api/assets/71931476/b82e7976-76b3-4922-9987-5a7b66a457ad)

* 댓글 삭제 api

![image](https://github.com/seungheyon/todo-api/assets/71931476/31daa161-68c0-420e-8853-9970aa1aeefd)
![image](https://github.com/seungheyon/todo-api/assets/71931476/cf401086-abb1-489b-bfc0-7bd2af7f1a56)

* 할 일 조회 시 연관된 댓글 조회

![image](https://github.com/seungheyon/todo-api/assets/71931476/42551779-e025-4c41-8fd7-6fc6da45614c)
![image](https://github.com/seungheyon/todo-api/assets/71931476/c44fdce1-be10-482b-b32b-5dac22c11b0e)

* 할 일 목록 조회 api 에 작성자 이름으로 필터링 기능 추가

![image](https://github.com/seungheyon/todo-api/assets/71931476/5bd11066-e47f-4166-a1f4-fdd3a90b0cb8)
![image](https://github.com/seungheyon/todo-api/assets/71931476/bcf0c5b1-710f-40cf-b31b-c954cc504115)

  ###### 할 일 목록 조회 api 안에 작성자 이름을 파라미터로 받고 Service 레이어의 메서드 내에서 분기하여 필터링 수행하였습니다.
  ###### 이후 동적 쿼리를 사용하는 방법으로 개선시킬 계획입니다.

* 할 일 작성, 수정 api 에 글자 수 검증 기능 추가

![image](https://github.com/seungheyon/todo-api/assets/71931476/624325ed-8cb8-44ca-b787-a50ea09ff935)
![image](https://github.com/seungheyon/todo-api/assets/71931476/24226d5f-16a5-4f7f-a2fb-852626e79e47)

  ###### 도메인 엔티티 내에서 검증 로직을 가지고, 엔티티의 프로퍼티를 변경하는 행위와 그에 대한 검증도 엔티티에 종속되도록 설계했습니다.




7.01 수정사항
-------------

### QeuryDsl 사용하여 동적 조건으로 검색하는 기능 구현
*  QueryDslConfig 클래스에서 JPAQueryFactory 빈 등록
  ![image](https://github.com/seungheyon/todo-api/assets/71931476/3e429356-ce59-44a5-a8da-cc5676d67983)

* TaskQueyrDslRepository 를 작성하여, TaskRepository 가 이를 확장하도록 구현
  ![image](https://github.com/seungheyon/todo-api/assets/71931476/075b533d-ca00-488b-abb7-6d7c7cc0e24e)
  ![image](https://github.com/seungheyon/todo-api/assets/71931476/a537489c-4cef-4954-a85f-dc46a0577559)

  
* 구현클래스에서 BooleanExpression 을 활용하여 동적 조건을 처리하도록 구현
  ![image](https://github.com/seungheyon/todo-api/assets/71931476/f075877f-7aaf-4163-b482-c842d09c08cb)

  
### Service 레이어에 테스트 코드 작성(진행 중)
* DataSource로 H2 를 연결하여 테스트 환경 구성
  ![image](https://github.com/seungheyon/todo-api/assets/71931476/e775eb09-6444-4308-a006-3f71b7f9a3aa)

* TaskService 클래스의 메서드 테스트 작성(진행 중)
  ![image](https://github.com/seungheyon/todo-api/assets/71931476/0c781f8f-8ca0-4e6b-82b9-b38697b5c47f)



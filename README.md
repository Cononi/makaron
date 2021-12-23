# Makaron Project
`디저트 판매 쇼핑몰 사이트인 마카롱 프로젝트 입니다. 현재 개발중인 프로젝트로 미비한 점이 많습니다.`

## 목차
* [Developer](#Developer)
* [ServiceList](#ServiceImplement)
* [Project](#Project)
* [Special Part](#SpecialPart)
* [Issue](#Issue)


# Developer


### Hardwear
* Main Server (Tomcat9)  
`OS : Ubuntu 18.0.4 LTS SERVER`  
`CPU : 1 Single Core 1.2Ghz`  
`RAM : 1G`  
`HDD/SSD : 40G`

* File Server  
`(NFS서버 -> Main Server에 NFS 서버 연결 및 마운트 처리) `  
`(Apache2 Server)`  
`OS : Ubuntu 18.0.4 LTS SERVER`  
`CPU : 1 Single Core 1.2Ghz`  
`RAM : 1G`  
`HDD/SSD : 40G`

* DB Server (Oracle Sql Server)  
`OS : Ubuntu 18.0.4 LTS SERVER`  
`CPU : 1 Single Core 1.2Ghz`  
`RAM : 1G`  
`HDD/SSD : 40G`

### ETC.
* Gabia 호스팅에 도메인 연결 처리
*  Apache2

  
###Lang
**Server** : <img src="https://img.shields.io/badge/Tomaat-F8DC75?style=flat-square&logo=Apache Tomcat&logoColor=black"/></a>
<img src="https://img.shields.io/badge/Ubuntu-E95420?style=flat-square&logo=Ubuntu&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Oracle-F80000?style=flat-square&logo=Oracle&logoColor=white"/></a>

**Back-End** : <img src="https://img.shields.io/badge/Python-007396?style=flat-square&logo=Python&logoColor=white"/></a> 
<img src="https://img.shields.io/badge/Java-3766AB?style=flat-square&logo=Java&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white"/></a>

**Front-End** :  <img src="https://img.shields.io/badge/Html5-3766AB?style=flat-square&logo=Html5&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Css-1572B6?style=flat-square&logo=Css3&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Javascript-F7DF1E?style=flat-square&logo=Javascript&logoColor=white"/></a>

**Database** : <img src="https://img.shields.io/badge/Oracle-F80000?style=flat-square&logo=Oracle&logoColor=white"/></a>

### Terms
|리스트|1W|2W|3W|
|------|:---:|:---:|:---:|
|분석|O|||
|개발환경 구성|O|O|||
|화면 구현||O|O|O|
|화면 테스트|||O|
|최종 배포|||O|



# ServiceImplement
### Implement

|구현 페이지|20%|40%|60%|80%|100%| 구현 내용|
|------|:---:|:---:|:---:|:---:|:---:|---|
|메인 페이지|||O|||최신 상품 리스트, 최신 인기 상품, 랜덤 상품 8개, 최근 조회수 리뷰, 배너|
|로그인, 회원가입||||O||로그인 세션처리, 암호 sha256처리, 회원가입 SMS API, 주소 API|
|상품 페이지|||O|||상품 정보, 상품 전체목록, 상품 카테고리별 검색, 전체 검색|
|마이 페이지||||O||구매 내역, 상품 리뷰, 1:1 질문, 배송지 관리|
|결제 페이지|O|||||페이지만 존재|

### Implement Check
* 메인 페이지 - 최근 상품의 다양화, 상품 랜덤화, 카테고리 선호도에 따른 추천 리스트 구현 부족으로 차후 개발
* 로그인 / 회원가입 - 회원가입 JS 코드 다이어트 및 최적화 필요, 자동로그인과 아이디찾기 비밀번호 찾기 구현 부족으로 차후 개발
* 상품 페이지 - 페이징 처리, 리뷰 관련 데이터 정돈이 필요
* 마이 페이지 - 주문내역 연도별 조회, 회원 탈퇴미비
* 결제 페이지 - 전체적으로 미비로 차후에 개발

### Python Database 수집항목
* Python 데이터 수집 - https://gist.github.com/Cononi/8bf6be5a7350e152855d2816cbfec897
* 수집 항목 : 리뷰, 상품 정보 전체, 카테고리 리스트 전체
* 카테고리 리스트 수집 항목 - 약 23개
* 상품 이미지 수집 항목 - 약 170개
* 상품 콘텐츠 이미지 수지 항목 - 약 540개
* 리뷰 데이터 수집 항목 - 약 3000개
* 상품 전체 조회 - 약 170개
* 소요 소간 : 6분

## 테이블 설계 명세서
[보드 테이블](https://drive.google.com/file/d/1Ttwujz9T2YsPH_A9qTgNq21-FN9joIpw/view?usp=sharing)  
[상품 테이블](https://drive.google.com/file/d/1eoq_utU3E1MTfr6SbuhHTVCHRyG8sNhj/view?usp=sharing)  
[회원테이블](https://drive.google.com/file/d/1Z6QBQN2hneiQPk_STYld14C7oswV-jz1/view?usp=sharing)  

## ERD
### - Board -
![board](https://user-images.githubusercontent.com/47350461/147200535-508fc6cf-3f30-45d9-8ea5-efffca0572fd.png)

### - Customer -
![customer](https://user-images.githubusercontent.com/47350461/147200543-23e69354-9f7a-4a70-bbe6-69f05077f77a.png)

### - Product -
![product](https://user-images.githubusercontent.com/47350461/147200546-c4a9e3bf-56ca-4c88-a550-c9c57e705380.png)
	

# Project 

* Jhw(Main) - Login, Register, MainPage, product, Server Setting, Domain Setting, All Service  
* Ch(sub) - Mainpage, product
* Hsy(sub) - Mypage, Mypage order, Mypage List
* Psj(sub) - Notice, product, serches

> Homepage : http://www.makaron.shop:7180/  
> 사항 : 현재 가입시 인증번호 금액적 부분으로 막아둠

# SpecialPart

### Apache HTTP Virtualhost
* 도메인 연결을 위해 FileSever에 Apache 서버 구현
* 연결된 가상 호스트는 2개 입니다.  
  img.makaron.shop은 FileServer 활용  
  www.makaron.shop은 MainServer 와 연결되는 가상 호스트 역활 입니다.
 ![서버흐름도](https://user-images.githubusercontent.com/47350461/147200468-2cad78b3-d056-46b3-a663-9b80fe5386b3.png)

### Python 데이터 수집
* 데이터 베이스의 상품, 주문정보, 회원 리뷰, 이미지의 더미 데이터를 파이썬을 이용해  총네가지의 쿼리 문서를 만들고 수집했습니다.  
상품 정보에서 가져올 데이터는 카테고리, Thumnail 이미지, 가격, 배송비, 콘텐츠 정보, 리뷰, 리뷰작성자 입니다.

* 데이터 수집시 링크 주소에 정규표현식을 활용하여 원하는 데이터를 가져올 수 있도록 처리 하였습니다.
*  수집할때 잘못된 데이터가 있는지 파악하고 수정 했습니다. 수집 목적도 있지만 잘못된 링크가 형성된 데이터도 찾을 수 있었기에 크롤링을 통해  
JSP에서 Servlet을 통해 최종 VIEW가 되었을때 활용만 잘 쓴다면 최종적으로 잘못된 부분 점검도 가능할거 같았습니다.

* 최종 DB 쿼리문으로 바꿔서 문서화 시킬때 PK와 FK의 관계도 신경써야 했기에 연관성을 엮어서 수집하도록 했으며 한번에 데이터를 뽑아냇습니다.

### 로그인 처리
 * 로그인 처리를 할때 세션을 생성하고 속도에 중점을 두어 싱글톤을 활용하여 차후 재로그인이나 다른 PC에서 동시접속등 관리에 용이하게 했습니다.  
 싱글톤으로 구현된 로그인 세션 처리는 상당히 빨랏으며 초기 셋팅후 안정적으로 돌아갔습니다.
 * 인터셉터를 이용해서 로그인 상태를 계속 체크하도록 유도했습니다.
 
### 회원 가입 처리
* 회원 가입에 JavaScript로 유효성 체크를 사전에 미리 하여 과도한 가입시도와 트래픽 과부하를 어느정도 줄일수 있었습니다.
* 아이디 중복검사를 실시간으로 직관적으로 보여주도록 Js로 비동기 처리하였습니다.
*  비밀번호 암호화를 처리하기위해 Hash + Salt를 이용해 SHA256 처리후 DB에 복호화 단서와 SHA256으로 변환시켜 각각 저장 했습니다.
* 다음 주소 API를 활용하여 국내 읍면동 주소를 받아와서 기입하도록 하였습니다.
* 네이버 클라우드 SNES를 활용하여 휴대폰 메세지를 통해 1인 1계정으로 제한을 두고 인증 절차 방식으로 구현 했습니다.  
  - 가입 조건은 1인 1계정으로 휴대폰 인증으로 고객정보에서 체크 합니다.
  - 휴대폰 인증 횟수는 금액적인 부분으로 1일 5회 처리, 인증 가능 시간은 3분으로 처리 하였습니다.
  - 휴대폰 인증번호는 DB에 SHA256 암호화 처리해서 저장하도록 했습니다. 저장된 휴대폰번호와 인증번호는 일일 제한 횟수처리에 이용됩니다.

### 인터셉터 처리
* 특정 페이지는 로그인이 필수하도록 처리하기 위해 인터셉터 처리 하였습니다.
* 로그인하기전에 사전에 있던 페이지 위치를 저장하고 로그인하면 다시 돌아가도록 인터셉터 처리했습니다.
* 로그인 여부 확인을위해 인터셉터에서 관리 합니다.
* 모든 페이지에 헤더를 동일시 하기 위해 인터셉터로 관리 합니다.

### Properties, config
* DB 정보, API 인증키와 같은 데이터를 따로 관리하여 차후 유지보수에 용이성을 생각했습니다.
* 차후에 service,mapper,controller등이 많아지고 확장성과 관리를 고려해 xml을 따로 만들어서 관리 하도록 했습니다.

# Issue

* Css 각 타겟서비스마다 조금씩 다른 부분이 있음.
* JWT 방식을 적극 활용하는 방향성 진행이 필요함
* 전체적으로 하나로 처리할 수 있는 부분이 많은데 간결하게 다이어트가 필요함
* Service보다 Controller에 치중된 부분과 코드중복 제거가 필요
* 아직 개발중인 프로젝트로 미비한 점이 많음.

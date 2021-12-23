# Makaron Project
`디저트 사이트가 중점인 마카롱 프로젝트 입니다.`

## 목차
* [Developer](#Developer)
* [ServiceList](#ServiceImplement)
* [Project](#Project)
* [Issue](#Issue)

#Developer

### Hardwear
`OS : Ubuntu 18.0.4 LTS SERVER`  
`CPU : 1 Single Core 1.2Ghz`  
`RAM : 1G`  
`HDD/SSD : 40G`
  
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
|리스트|1W|2W|3W|4W|5W|
|------|:---:|:---:|:---:|:---:|:---:|
|분석|O|||||
|개발환경 구성|O|O||||
|화면 구현||O|O|O||
|화면 테스트||||O|O|
|최종 배포|||||O|




# Service Implement
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

### Database 수집항목
* Python 데이터 수집 - https://gist.github.com/Cononi/8bf6be5a7350e152855d2816cbfec897
* 수집 항목 : 리뷰, 상품 정보 전체, 카테고리 리스트 전체
* 카테고리 리스트 수집 항목 - 약 23개
* 상품 이미지 수집 항목 - 약 170개
* 상품 콘텐츠 이미지 수지 항목 - 약 540개
* 리뷰 데이터 수집 항목 - 약 3000개
* 상품 전체 조회 - 약 170개
* 소요 소간 : 6분

### Database 항목
* Link - https://drive.google.com/file/d/1blaR_jmVaZnzmk1hjCBfza1ikfYr--wO/view?usp=sharing
* 테이블 설계 명세서
* ERD

# Project 

* Jhw(Main) - Login, Register, MainPage, product, Server Setting, Domain Setting, All Service  
* Ch(sub) - Mainpage, product
* Hsy(sub) - Mypage, Mypage order, Mypage List
* Psj(sub) - Notice, product, serches

> Homepage : http://www.makaron.shop:7180/  
> 사항 : 현재 가입시 인증번호 금액적 부분으로 막아둠


# Issue

* Css 각 타겟서비스마다 조금씩 다른 부분이 있음.
* JWT 방식을 적극 활용하는 방향성 진행이 필요함
* 전체적으로 하나로 처리할 수 있는 부분이 많은데 간결하게 다이어트가 필요함
* Service보다 Controller에 치중된 부분과 코드중복 제거가 필요


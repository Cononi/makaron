# Makaron Project
`디저트 사이트가 중점인 마카롱 프로젝트 입니다.`

## 목차
* [Developer](#Developer)
* [ServiceList](#ServiceImplement)
* [Project](#Project)
* [Special Part](#SpecialPart)
* [Issue](#Issue)

#Developer

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
[보드 테이블.pdf](https://github.com/Cononi/makaron/files/7767240/default.pdf)  
[상품 테이블.pdf](https://github.com/Cononi/makaron/files/7767241/default.pdf)  
[회원테이블.pdf](https://github.com/Cononi/makaron/files/7767242/default.pdf)  

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




# Issue

* Css 각 타겟서비스마다 조금씩 다른 부분이 있음.
* JWT 방식을 적극 활용하는 방향성 진행이 필요함
* 전체적으로 하나로 처리할 수 있는 부분이 많은데 간결하게 다이어트가 필요함
* Service보다 Controller에 치중된 부분과 코드중복 제거가 필요

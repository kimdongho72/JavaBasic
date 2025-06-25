
# 🃏 Sports Card Shop Console App

스포츠 카드 수집가 및 거래자를 위한 **자바 기반 콘솔 애플리케이션**입니다. 이 프로젝트는 사용자 등록부터 카드 구매, 주문, 관리자 통제 기능까지 전체 거래 흐름을 텍스트 기반으로 시뮬레이션하며, 객체지향 설계와 계층 분리를 통해 유지보수성과 확장성을 고려했습니다.

---

## 🧠 프로젝트 주제 선정 이유 및 차별점

### 🎯 프로젝트 목적

* **실제 존재하는 수집 시장**을 기반으로 한 구조 설계 훈련
* **VO/DAO/Service 계층 분리**를 통한 고전적인 아키텍처 구현 능력 강화
* 사용자 흐름, 관리자 통제, 조건 검색 등 **현실적인 시나리오 반영**

### 📈 스포츠 카드 시장 분석

* 글로벌 카드 거래 시장은 2022년 기준 약 1억 3,230만 달러
* 2031년까지 약 4억 달러 규모 성장 전망
* 투자, 수집, 커뮤니티 등 다양한 활용 분야 존재

### 🧍 사용자 페르소나 기반 기능 설계

* **김OO (20대 수집가)**: 빠른 키워드 검색, 간편 결제, 새 카드 정보에 민감
* **이OO (40대 투자자)**: 등급 정보 중시, 카드 상세 스펙 중요, 장기 투자 관점

### 💡 기존 플랫폼 대비 차별점

* UI/UX는 콘솔 기준으로도 명확한 흐름과 메뉴 분기 구현
* 초보자를 위한 간단 필터링부터 전문가용 고급 검색까지 확장 가능 구조
* 관리자 권한 기반으로 주문 상태 변경, 회원 강제 탈퇴 등 제어 가능

---

## 📦 주요 기능 상세 분석

### 👤 회원 시스템 (Member)

* **회원가입/로그인/탈퇴/수정**: 기본 CRUD 수행
* `join(MemberVO)`: 중복 ID 체크 및 등록
* `login(id, pw)`: 비밀번호 일치 여부 확인
* `updateInfo(MemberVO)`: 닉네임/비밀번호 수정 처리
* `isAdmin(id)`: 관리자 여부 확인 후 메뉴 분기

### 🃏 카드 기능 (Card)

* **CRUD + 고급 필터링 기능** 제공
* `getAllCards()`: 전체 목록 출력
* `searchCards(CardSearchCondition)`: 브랜드, 연도, 가격 등 조건 다중 검색
* `registerCard(), updateCard(), deleteCard()`: 관리자 전용 카드 관리 기능
* `getCardById(id)`: 주문 및 장바구니 기능을 위한 상세 조회

### 🛒 장바구니 기능 (Cart)

* **사용자별로 분리된 장바구니 저장 구조**
* `addToCart(userId, cardId, qty)`: 재고 여부 확인 후 추가
* `viewCart(userId)`: 현재 담긴 카드와 수량 확인
* `removeItem(userId, cardId)`: 특정 항목 제거
* `clearCart(userId)`: 전체 항목 삭제
* `checkoutAll() / checkoutSelected(List<Integer>)`: 전체 또는 일부 결제 기능 제공

### 📦 주문 기능 (Order)

* **장바구니 기반 주문 흐름 처리**
* `placeOrder(userId, Map<cardId, qty>)`: 주문 객체 생성 후 저장
* `getOrderHistory(userId)`: 사용자별 내역 조회
* `getAllOrders()`: 관리자용 전체 주문 확인
* `updateOrderStatus(orderId, status)`: 상태값 변경 처리 ('예약 중', '거래 완료')

### 🛠 관리자 기능 (Admin)

* 전체 정보 조회 및 수동 제어 기능 포함
* 카드 재고 수정, 삭제 / 회원 강제 탈퇴 / 인기 카드 조회 등 포함
* `forceRemoveMember(id)`, `updateCardStock(id, stock)`, `getCardCountByGame()` 등 사용

---

## ⚙️ 개발 환경 및 기술 스택

* **Language**: Java 17+
* **IDE**: IntelliJ / Eclipse
* **구현 패턴**: MVC 유사 구조 (VO / DAO / Service 분리)
* **데이터 구조**: `HashMap` 기반 메모리 저장
* **빌드 도구**: 없음 (CLI 실행)

```bash
javac app/MainApplication.java
java app.MainApplication
```

---

## 📌 클래스 다이어그램 (전체 구조 시각화)

### 📦 카드 구조
![카드 클래스 다이어그램](https://github.com/user-attachments/assets/defb8860-734d-4aee-8ecb-011665839011)



### 📦 주문 구조

![주문 클래스 다이어그램](https://github.com/user-attachments/assets/e6860c07-a07c-4ec1-b7b1-3ffb97db5333)


### 📦 회원 구조

![멤버 클래스 다이어그램](https://github.com/user-attachments/assets/c914db1b-3be8-4c8a-b6dc-35843c95fcae)


### 📦 장바구니 구조

![장바구니 클래스 다이어그램](https://github.com/user-attachments/assets/80f07c63-c098-4a6b-84e7-9b68d3d89e33)


### 📦 관리자 서버 구조

![관리자 서버 클래스 다이어그램](https://github.com/user-attachments/assets/218ac13e-2dda-467c-b02d-9830c4904033)


---

## 🎥 프로젝트 시연 영상

사용자 메뉴 시연
https://youtu.be/2g4OhmLJRCY

관리자 메뉴 시연

https://youtu.be/Me0mchQwEaE
## 🌱 기대 효과 및 향후 개발 계획

### ✅ 기대 효과

* 객체 설계 및 클래스 다이어그램 활용 능력 강화
* 콘솔 기반 구조에서도 실제 거래 흐름 구현 경험 확보
* 관리자 제어/예외 처리 등 로직적 사고력 향상



## 📁 패키지 구조 요약

```
src/
├── card/             # 카드 정보 VO, DAO, Service
├── cart/             # 장바구니 관련 구조
├── order/            # 주문 처리 DAO, VO, Service
├── user/             # 회원 정보 및 인증 로직
├── admin/            # 관리자 서비스 및 인터페이스
├── app/              # 실행 진입점(MainApplication)
```

---

📊 발표용 PPT 자료

본 프로젝트의 전체 흐름과 시각 자료를 포함한 발표용 PPT 파일은 아래 링크에서 확인하실 수 있습니다.

🔗 스포츠 카드 쇼핑몰 발표용 PPT 다운로드


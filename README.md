# 서비스 설명

🔔 서비스명 : 스읍-팡!(롤모델의 습관을 루팡한다!)

🔔 서비스 한줄소개 : 롤모델의 습관을 훔쳐 변화를 위한 습관을 형성할 수 있는 습관 기록 서비스!

🔔 서비스 가치제안 : 
(1) 변화를 목표하고 있나요? 성공한 사람들이 실천했던 습관을 확인해봐요!
(2) 그 습관을 훔쳐서 나의 습관으로 한번 만들어봐요!
(3) 나의 성과를 증명할 수 있는 뱃지도 획득해봐요!

🔔 서비스 문제정의 :
 📌 문제정의 : 
(1) 고객이 겪고 있는 문제 or 내가 겪고 있는 문제(What)
		자신이 생각한 롤모델처럼 "변화"하고 싶으나 그렇지 않은 상황이다.
(2) 고객이 문제를 겪고 있는 이유(Why)
		이를 위한 실천 방법을 모른다 or 이를 위한 실천을 꾸준히 하기 어렵다.
(3) 그래서 그들이 문제를 해결하기 위해 택하는 솔루션(제품, 서비스, 행동 등)(How)
		롤모델 관련 자서전 구매 / 해당 인물의 습관 검색하고 따라하기 / 자신의 투두리스트에 해당 인물 습관 직접 기입하고 실천하기
(4) 이보다 더 좋은 나만의 해결책 아이디어가 있다면?
		"롤모델의 습관 투두리스트"
		롤모델의 습관을 찾아 알려드릴게요. 습관을 훔쳐 실천하여 나의 습관으로 만들어보세요!

🔔 서비스 고객정의 :
* 타겟: 롤모델처럼 생활 습관을 변화시키고자 하는 의지가 있는 2030
📌페르소나
- 고객 생각/사고/관심사: 손흥민과 같은 꾸준함으로 건강한 몸을 얻고 싶은 26살 손민기씨
- 고객의 인적사항(하는 일/능력/이름/성별,나이/직업):
26세 손민기 / 서비스 기획자 / 꾸준함을 가지고 있으나 바빠서 헬스장을 다니기는 어려움 
- 고객의 성격/성향
[서비스 관련]
일정한 생활 습관을 형성하고 있음 / 롤모델에 대한 열망을 가지고 있음 / 자신의 생활 습관을 보다 개선하고자 하는 욕구가 있음
[그 외 성향]
매일 밤 옷을 세탁하고 널어서 잠 / 무언가를 알아가고 습득하는 것에 보람참을 느낌 / 늘 변화를 꿈꾸는 사람
- 고객의 니즈(painpoint) 및 목표
니즈) 롤모델과 같이 변화하고자 하는 니즈
목표) 실천을 통해서 건강함을 유지하는 사람이 되고 싶다

# 단체사진/파트사진

<image width="500" src ="https://user-images.githubusercontent.com/77060011/202864365-4fb15664-52da-41f2-9cc0-b3335bd4a694.jpg">
<image width="500" src ="https://user-images.githubusercontent.com/77060011/202864467-9ef75429-9e45-4876-8c6a-3bd0f3383f61.jpeg">


# 역할 분담

1. Splash animation - 준원
2. Home - 다은
3. Search - 강희
4. Profile - 준원 + 태희

# 코드컨벤션

1. User + 응답 받는건 : Response / 요청하는 건: Request
2. 변수명 view_where_detail ex)et_home_login
Button - btn
EditText - et
TextView - tv
imageview - iv
    
    SerachView - sv
    ProgressBar - progress_bar
    RadioButton - radio_btn
    ToggleButton - toggle_btn
    Spinner - spn
    Menu - menu
    RecyclerView - rv
    ConstraintLayout - cl
    
    CheckBox - cb
    
3. model은 서버 통신에만 사용하는 data class
4. 서버 통신 외에 다른 data class 는 entity에 작성


# 구현하기 어려웠던 문제
1. tab layout과 viewpager를 연결하는 문제
본래, tab layout과 viewpager를 연결해 tab layout을 통해서도 화면을 이동할 수 있고, viewpager의 swipe를 통해서도 화면을 이동할 수 있는 layout을 구성하려했으나 초반에 fragment 내에서 구현을 하지 않고 tab layout을 구현하지 않아 원하는 뷰를 구현할 수 없는 문제가 발생함

# 해결방안
1.<br>
    - view pager로 화면을 swipe 하는 것을 막음<br>
    - tab layout 대신 텍스트 하나 하나에 clicklistener를 적용해 화면이 tablayout이 적용돼 넘어가는거 처럼 구현함

# 시연영상


https://user-images.githubusercontent.com/77060011/202875980-87a11dbe-fa99-42fa-84be-2b3dfb210e78.mp4


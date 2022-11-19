package com.junewon.soptkathon.presentation.search

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.junewon.soptkathon.R
import com.junewon.soptkathon.data.model.request.UserRequest
import com.junewon.soptkathon.data.model.response.Habit
import com.junewon.soptkathon.data.model.response.Star
import com.junewon.soptkathon.data.service.SpangService
import com.junewon.soptkathon.data.service.User
import com.junewon.soptkathon.databinding.ActivitySearchBinding
import com.junewon.soptkathon.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.net.URL
import javax.inject.Inject

@AndroidEntryPoint
class SearchActivity : BindingActivity<ActivitySearchBinding>(R.layout.activity_search) {
    lateinit var keyWordAdapter: SearchKeywordAdapter
    lateinit var starAdapter: SearchStarAdapter
    @Inject
    lateinit var service: SpangService
    private val keyWordData = arrayListOf<KeyWordData>(
        KeyWordData(keyWord = "운동"),
        KeyWordData(keyWord = "다이어트"),
        KeyWordData(keyWord = "공부 습관"),
        KeyWordData(keyWord = "시간 관리"),
        KeyWordData(keyWord = "워렌 버핏"),
        KeyWordData(keyWord = "대박 투자"),
        KeyWordData(keyWord = "티끌모아"),
        KeyWordData(keyWord = "9조 화이팅"),
        KeyWordData(keyWord = "스읍-팡!")
    )

    // Todo 가짜 데이터 넣기
    private val stars = listOf<Star>(
        Star(
            habits = listOf(
                Habit(title = "운동 일지 쓰기"),Habit(title = "대체 운동 찾기"),Habit(title = "운동 감사 일기 쓰기")
            ),
            starId = "1",
            title = "다카하시 사카에의 운동 습관"
        ),
        Star(
            habits = listOf(
                Habit(title = "매일 10분 걷기"),Habit(title = "과일, 채소 섭취하기"),Habit(title = "하루 최소 6시간 수면하기")
            ),
            starId = "2",
            title = "워렌 버핏의 돈 모으는 습관"
        ),
        Star(
            habits = listOf(
                Habit(title = "하루 우선 과제를 선정하기"),Habit(title = "아침에 한가지 일과 꼭 설정하고 지키기"),Habit(title = "요일별로 업무 주제 정하기")
            ),
            starId = "3",
            title = "케빈 크루즈의 갓생 사는 습관"
        ),
        Star(
            habits = listOf(
                Habit(title = "아침 4000원 이하로 먹기"),Habit(title = "취미 생활 1번 이상 하기"),Habit(title = "거울을 보고 나에게 중요한 질문하기")
            ),
            starId = "4",
            title = "워렌 버핏의 돈 모으는 습관"
        ),
        Star(
            habits = listOf(
                Habit(title = "외국 영화 자막 없이 20분 시청하기"),Habit(title = "영자 신문 하나 번역기 없이 읽기"),Habit(title = "영어 단어 하루에 20개 외우기")
            ),
            starId = "5",
            title = "안현모의 언어 습득 습관"
        ),
        Star(
            habits = listOf(
                Habit(title = "두부나 오트밀 섭취하기"),Habit(title = "비건 식단에 대해 공부하고 한 끼 계획 짜기"),Habit(title = "한 끼 이상 비건 식단 섭취하기")
            ),
            starId = "6",
            title = "파멜라 퍼거슨의 건강한 습관"
        ),
        Star(
            habits = listOf(
                Habit(title = "나의 한계를 재단하지 않기"),Habit(title = "포기하고 싶을 때 한번 더 보기"),Habit(title = "포기하고 싶을 때 한번 더 보기")
            ),
            starId = "7",
            title = "서동주의 만능 인재가 되는 습관"
        ),
        Star(
            habits = listOf(
                Habit(title = "일주일에 책 한 권 이상 읽기"),Habit(title = "일주일에 책 한 권 이상 읽기"),Habit(title = "한 곳에 너무 집중하지 않기")
            ),
            starId = "8",
            title = "오프라 윈프리의 성공하는 습관"
        )
    )

    private val starsImg = listOf<String>(
        "https://prod-df-public.s3.amazonaws.com/uploads/doctordf/img_url2/46011/20181228_2.jpg",
        "https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F028%2F2020%2F08%2F18%2F0002509127_001_20200818133407489.jpg&type=sc960_832",
        "https://scs-phinf.pstatic.net/MjAyMTA3MTNfMjE3/MDAxNjI2MTI4MDkwMzEx.MzrLPetBZ5s_JOESJR4EVmBsHldDv0ATnyZ6oNABZ3Ig.Yi0bb0Iu0ghX878aV43N0nGQoF4P1u1597fnYiAu36Mg.JPEG/%EC%BC%80%EB%B9%88_%ED%81%AC%EB%A3%A8%EC%A6%88.jpg?type=w800",
        "https://blog.kakaocdn.net/dn/dk00CX/btqQ3hptzRj/eQqZx5sB03KhnN73iHmRdK/img.jpg",
        "https://mblogthumb-phinf.pstatic.net/MjAyMDAxMDVfMjA1/MDAxNTc4MjE1NTg4Njc1.jqPdUoP4JahI9HL0McWpzsO6qIDNQrKhYMP4V_ulDmkg.gfULKDVmwpFCd9jDsmrBZB664m9tSakzeAHrIKF7hiQg.JPEG.risingkeyword/IMG_6683.jpg?type=w800",
        "https://vkind.com/wp-content/uploads/2020/11/73420348_2742020892495354_950769613166084096_n.jpg",
        "http://res.heraldm.com/phpwas/restmb_jhidxmake.php?idx=5&simg=202209090727047497863_20220909072738_01.jpg",
        "https://blog.kakaocdn.net/dn/egohP6/btrl1JK0i56/qkxbhyWxZkBJkij0HZuCZK/img.jpg"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKeyWorkAdapter()
        initStarAdapter()
        fetchStars()
        initSearchClickListener()

        binding.rvSearchCeleb.setOnClickListener {
            service.postObserver(UserRequest("1"))
        }


    }

    private fun initSearchClickListener() {
        binding.svSearchContent.setOnSearchClickListener {
            fetchStars()
        }
    }

    private fun initKeyWorkAdapter() {
        keyWordAdapter = SearchKeywordAdapter(this)
        binding.rvSearchPopularKeyword.adapter = keyWordAdapter
        binding.rvSearchPopularKeyword.layoutManager =
            LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        keyWordAdapter.setKeywordList(keyWordData)
    }

    private fun initStarAdapter() {
        starAdapter = SearchStarAdapter(this)
        binding.rvSearchCeleb.adapter = starAdapter
        starAdapter.setStars(false,starsImg,stars)
    }

    private fun fetchStars() {
        lifecycleScope.launch {
            runCatching {
                service.getSearch(binding.svSearchContent.query.toString())
            }.onSuccess {
                starAdapter.setStars(true, starsImg,it.data.stars)
            }.onFailure { }
        }
    }
}

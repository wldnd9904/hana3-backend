package com.study.ex12_h2db;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MemberRepositoryTest extends Ex12H2DbApplicationTests {
    //생성자 주입 안됨
    @Autowired
    MemberRepository memberRepository;

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - 클래스 초기화시 한 번 수행");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - @Test 호출 시 한번만 실행");
        save();
    }

    @Test
    @DisplayName("save 테스트") // 콘솔에 출력되는 메소드 이름
    public void save() {
        memberRepository.save(new MemberEntity(Long.valueOf(1),
                "hong", "1234", "홍길동", "ROLE_USER", LocalDate.parse("2023-01-01")
        ));
        memberRepository.save(new MemberEntity(Long.valueOf(2),
                "tom", "1234", "톰아저씨", "ROLE_USER", LocalDate.parse("2023-02-01")
        ));
        memberRepository.save(new MemberEntity(Long.valueOf(3),
                "admin", "1234", "관리자", "ROLE_ADMIN", LocalDate.parse("2023-03-01")
        ));
//        memberRepository.saveAll(Arrays.asList(
//                new MemberEntity((long) 1, "hong", "1234", "홍길동", "ROLE_USER", LocalDate.parse("2023-09-01")),
//                new MemberEntity((long) 2, "kong", "1234", "콩길동", "ROLE_USER", LocalDate.parse("2023-09-02")),
//                new MemberEntity((long) 3, "gong", "1234", "공길동", "ROLE_USER", LocalDate.parse("2023-09-03")),
//                new MemberEntity((long) 4, "bong", "1234", "봉길동", "ROLE_USER", LocalDate.parse("2023-09-04")),
//                new MemberEntity((long) 5, "pong", "1234", "퐁길동", "ROLE_ADMIN", LocalDate.parse("2023-09-05"))
//        ));

//        List<MemberEntity> list = memberRepository.findAll();
//        for(MemberEntity member: list)
//            System.out.println(member.getUserName());

//        assertEquals(5,list.size());
    }

    @Test
    @DisplayName("findById 테스트")
    void findById() {
        Optional<MemberEntity> member = memberRepository.findById(1L);
        member.ifPresentOrElse(unwrappedMemberEntity -> {
            System.out.println(unwrappedMemberEntity.getUserName());
            assertEquals("홍길동", unwrappedMemberEntity.getUserName());
        }, () -> {
            fail("없는데");
        });
    }

    @Test
    @DisplayName("count 테스트")
    void count() {
        Long count = memberRepository.count();
        System.out.println(count);
    }

    @Test
    @DisplayName("쿼리메소드 테스트")
    void query() {
        //SELECT * FROM MEMBER WHERE USER_ID = "pong"
        List<MemberEntity> list = memberRepository.findByUserId("pong");
        assertEquals(1, list.size());
        assertEquals("퐁길동", list.get(0).getUserName());

        //SELECT * FROM MEMBER WHERE USER_ID = "hong" AND USER_NAME = "홍길동" ORDER BY ID DESC LIMIT 3;
        List<MemberEntity> list2 = memberRepository.findFirst3ByUserIdAndUserNameOrderByIdDesc("hong", "홍길동");
        for (MemberEntity member : list2)
            System.out.println(member.getUserName());

        Boolean isExist = memberRepository.existsByJoinDateLessThanEqual(LocalDate.now());
        System.out.println(isExist);

        long count = memberRepository.countByUserNameIgnoreCaseLike("%길동");
        System.out.println(count);
    }

    @Test
    @DisplayName("JPQL 테스트")
    void jpql() {
        List<MemberEntity> list = memberRepository.findByUserId_JPQL_Query("kong");
        assertEquals(list.size(), 1);
    }

    @Test
    @DisplayName("찾아서 바꾸기 테스트")
    void update() {
        Optional<MemberEntity> member = memberRepository.findById(1L);
        member.ifPresentOrElse((memberFound)->{
            memberFound.update("admin","admin","어드민","ADMIN");
            memberRepository.save(memberFound);
            List<MemberEntity> list = memberRepository.findAll();
            for(MemberEntity entry: list)
                System.out.println(entry.getUserName());
        },()->{
            fail("1번아이디 멤버 없음");
        });
    }

    @Test
    @DisplayName("Native Query 테스트")
    void nativeQuery(){
        List<MemberEntity> list = memberRepository.findByUserId_NATIVE_Query("gong");
        assertEquals(list.size(), 1);
         memberRepository.updateById_NATIVE_Query("mmmm",1L);
        list = memberRepository.findByUserId_NATIVE_Query("mmmm");
        assertEquals(list.get(0).getUserId(),"mmmm");

    }


    //member 테이블 안에 암호가 "1234"인 회원이 있는지 테스트 하시오.
    //23년도 3월에 가입한 회원의 수가 1인지 테스트하시오.
    //"lee"라는 아이디로 회원가입하고자 할때, 아이디 중복인지 테스트하시오.
    //"tom"이라는 아이디의 회원정보를 수정하고, 잘 수정되었는지 테스트하시오.
    //톰아저씨 -> 마이클, 암호 -> 3456
    //쿼리 메소드 또는 Native SQL, JPQL 방법 중 하나를 사용하시오.

    @Test
    @DisplayName("1.member 테이블 안에 암호가 \"1234\"인 회원이 있는지 테스트 하시오.")
    void quiz1() {
        List<MemberEntity> list = memberRepository.findByUserPw("1234");
        assertTrue(!list.isEmpty());
    }

    @Test
    @DisplayName("2.2023년도 3월에 가입한 회원의 수가 1인지 테스트하시오.")
    void quiz2() {
        List<MemberEntity> list = memberRepository.findByYearAndMonth_JPQL(2023,3);
        assertEquals(list.size() ,1L);
    }

    @Test
    @DisplayName("3.\"lee\"라는 아이디로 회원가입하고자 할때, 아이디 중복인지 테스트하시오.")
    void quiz3() {
        List<MemberEntity> list = memberRepository.findByUserId("lee");
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("4.\"tom\"이라는 아이디의 회원정보를 수정하고, 잘 수정되었는지 테스트하시오.")
    void quiz4() {
        //톰아저씨 -> 마이클, 암호 -> 3456
        memberRepository.updateUserNameUserPwByUserId_nativeQuery("tom","마이클","3456");
        List<MemberEntity> list = memberRepository.findByUserId("tom");
        assertFalse(list.isEmpty());
        assertEquals(list.get(0).getUserName(), "마이클");
        assertEquals(list.get(0).getUserPw(), "3456");
    }

}

package com.study.ex22_tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//          (디스패처 서블릿)
// 클라 ---> Front Controller -> Controller1,2,3 ->
//       ---> Service(로직) -> Repository(DAO) -> Entity
//       ---> DBMS

// 클라 <-- View Resolver(html render) <-- Front Controller

@Service
public class MemberService {


    public int loginAction(Member member) {
        System.out.println("gd");
        //DAO(레포지토리)클래스를 이용한 DB검색
        if (member.getLoginId().equals("hong") && member.getLoginPw().equals("1234")) {
            return 1;
        } else {
            return 0;
        }
    }
}

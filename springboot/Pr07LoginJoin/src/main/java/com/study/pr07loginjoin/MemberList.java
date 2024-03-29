package com.study.pr07loginjoin;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Data
public class MemberList {

    private ArrayList<Member> memberList = new ArrayList<>();

    public boolean isDuplicate(String name) {
        for (Member member : memberList) {
            if (name.equals(member.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean login(String name, String pw) {
        for (Member member : memberList) {
            if (name.equals(member.getUsername()) && pw.equals(member.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public boolean join(Member member) {
        if (isDuplicate(member.getUsername())) return false;
        memberList.add(member);
        return true;
    }

    public void printAll() {
        System.out.println("현재 아이디 목록:");
        for (Member member : memberList)
            System.out.println(member);
    }
}

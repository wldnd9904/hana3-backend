package com.study.pr10memberadminapi.model;

import com.study.pr10memberadminapi.request.MemberUpdateRequest;
import com.study.pr10memberadminapi.response.MemberUpdateResponse;
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

    public Member findMemberById(int index) {
        return memberList.get(index);
    }

    public boolean removeMemberById(int index) {
        return memberList.remove(index) != null;
    }

    public boolean updateMember(MemberUpdateRequest request) {
        return memberList.set(request.index(), request.toMember()) != null;
    }
}

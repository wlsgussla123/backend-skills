package jpabook.jpashop;

import org.assertj.core.api.Assertions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() throws Exception{
        Member member = new Member();
        member.setUsername("memberA");
        Long savedId = memberRepository.save(member);

        Member member1 = memberRepository.find(savedId);
        Assertions.assertThat(member1).isSameAs(member);
    }
}
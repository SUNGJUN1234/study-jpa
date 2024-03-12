package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest // 스프링 부트 테스트를 위한 어노테이션
//@Rollback(false) // 롤백을 수행하지 않도록 설정할 경우 주석 해제
class MemberRepositoryTest {

    @Autowired // 테스트할 대상 빈을 주입받기 위한 어노테이션
    MemberRepository memberRepository;

    @Test
    @Transactional // 각 테스트 메서드를 트랜잭션으로 처리하기 위한 어노테이션
    public void testMember() {
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(member); // 회원 저장
        Member findMember = memberRepository.find(saveId); // 저장된 회원 검색

        //then
        // 회원의 ID와 이름이 같은지 확인하는 단언문
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
    }
}

package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository respository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        respository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        respository.save(member);

        Member result = respository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);


    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Spring1");
        respository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        respository.save(member2);

        Member result = respository.findByName("Spring1").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Spring1");
        respository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        respository.save(member2);

        List<Member> result = respository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}

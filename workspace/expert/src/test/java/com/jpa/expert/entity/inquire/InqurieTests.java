package com.jpa.expert.entity.inquire;

import com.jpa.expert.repository.inquire.AnswerDAO;
import com.jpa.expert.repository.inquire.QuestionDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class InqurieTests {
    @Autowired
    private QuestionDAO questionDAO;
    @Autowired
    private AnswerDAO answerDAO;

    @Test
    public void saveTest(){
//        Question(1) -> Answer(N) -> 연관관계 주인은 아니나, 목적에 맞는 로직
//        Question question = new Question();
//        question.setQuestionTitle("전철역");
//        question.setQuestionContent("전철역 어디가 좋나요?");
//        questionDAO.save(question);
//
//        Answer answer1 = new Answer();
//        Answer answer2 = new Answer();

//        Answer(N) -> Question(1) -> 연관관계 주인이지만, 목적 맞지 않는 로

//        연관관계의 주인이 아닌 question.answers는 조회 목적으로만 사용한다.
//        질문에 답변을 추가하고 싶다면, answer.setQuestion()를 사용하여 직접 질문을 지정해야 한다.
//        만약 매번 setQuestion()을 사용하기 불편하다면, 편의 메소드를 제작한다.

//        3. Question(1) -> Answer(N) 편의 메소드 사용, 목적도 맞고 연관관계도 성립

    }

    @Test
    public void findByIdTest(){
        final Optional<Question> foundQuestion = questionDAO.findById(33L);
    }
}

package com.dk.project_board0.repository;

import com.dk.project_board0.config.JpaConfig;
import com.dk.project_board0.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

//import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private ArticleRepository articleRepository;
    private ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(

            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository) {

        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {

        List<Article> articles = articleRepository.findAll();

        assertThat(articles).isNotNull().hasSize(123);

    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine() {

        Long previousCount = articleRepository.count();

        Article article = Article.of("new article", "new article", "#spring");

        Article savedArticle = articleRepository.save(article);

        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);

    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine() {

        Article article = articleRepository.findById(1L).orElseThrow();

        String updateHashtag = "#spring_boot";

        article.setHashtag(updateHashtag);

//        Article savedArticle = articleRepository.save(article);
        Article savedArticle = articleRepository.saveAndFlush(article);

        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updateHashtag);

    }

    @DisplayName("delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine() {

        Article article = articleRepository.findById(1l).orElseThrow();

        Long previousArticleCount = articleRepository.count();

        Long previoiiusArticleCommentCount = articleCommentRepository.count();

        int deletedCommentsSize = article.getArticleComments().size();

        articleRepository.delete(article);

        assertThat(articleRepository.count()).isEqualTo(previousArticleCount - 1);

        assertThat(articleCommentRepository.count()).isEqualTo(previoiiusArticleCommentCount - deletedCommentsSize);

    }

}



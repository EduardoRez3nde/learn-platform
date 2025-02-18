package com.rezende.learn.seeder;

import com.rezende.learn.entities.*;
import com.rezende.learn.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SeederConfig implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private WatchTimeRepository watchTimeRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verifica se já existem dados nas tabelas
        if (categoryRepository.count() == 0 && courseRepository.count() == 0) {
            // Inserir categorias
            Category devCategory = new Category();
            devCategory.setName("Desenvolvimento");
            devCategory.setPosition(1);
            categoryRepository.save(devCategory);

            Category designCategory = new Category();
            designCategory.setName("Design");
            designCategory.setPosition(2);
            categoryRepository.save(designCategory);

            Category marketingCategory = new Category();
            marketingCategory.setName("Marketing");
            marketingCategory.setPosition(3);
            categoryRepository.save(marketingCategory);

            Category webDevCategory = new Category();
            webDevCategory.setName("Desenvolvimento Web");
            webDevCategory.setPosition(1);
            categoryRepository.save(webDevCategory);

            Category graphicDesignCategory = new Category();
            graphicDesignCategory.setName("Design Gráfico");
            graphicDesignCategory.setPosition(2);
            categoryRepository.save(graphicDesignCategory);

            Category digitalMarketingCategory = new Category();
            digitalMarketingCategory.setName("Marketing Digital");
            digitalMarketingCategory.setPosition(3);
            categoryRepository.save(digitalMarketingCategory);

            Category projectManagementCategory = new Category();
            projectManagementCategory.setName("Gestão de Projetos");
            projectManagementCategory.setPosition(4);
            categoryRepository.save(projectManagementCategory);

            // Inserir cursos
            Course jsCourse = new Course();
            jsCourse.setName("JavaScript Moderno");
            jsCourse.setSynopsis("Domine as técnicas mais recentes de JavaScript.");
            jsCourse.setThumbnailUrl("url_js");
            jsCourse.setFeatured(true);
            jsCourse.setCategory(devCategory);
            courseRepository.save(jsCourse);

            Course designCourse = new Course();
            designCourse.setName("Design para Web");
            designCourse.setSynopsis("Crie interfaces web incríveis.");
            designCourse.setThumbnailUrl("url_design");
            designCourse.setFeatured(false);
            designCourse.setCategory(designCategory);
            courseRepository.save(designCourse);

            Course seoCourse = new Course();
            seoCourse.setName("SEO para Iniciantes");
            seoCourse.setSynopsis("Aprenda a otimizar seu site para os mecanismos de busca.");
            seoCourse.setThumbnailUrl("url_seo");
            seoCourse.setFeatured(true);
            seoCourse.setCategory(marketingCategory);
            courseRepository.save(seoCourse);

            Course agileCourse = new Course();
            agileCourse.setName("Gerenciamento Ágil de Projetos");
            agileCourse.setSynopsis("Domine os princípios do Agile e Scrum.");
            agileCourse.setThumbnailUrl("url_agile");
            agileCourse.setFeatured(false);
            agileCourse.setCategory(projectManagementCategory);
            courseRepository.save(agileCourse);

            Course reactCourse = new Course();
            reactCourse.setName("React do Zero ao Avançado");
            reactCourse.setSynopsis("Construa aplicações web robustas com React.");
            reactCourse.setThumbnailUrl("url_react");
            reactCourse.setFeatured(true);
            reactCourse.setCategory(webDevCategory);
            courseRepository.save(reactCourse);

            // Inserir episódios
            Episode jsEpisode1 = new Episode();
            jsEpisode1.setName("Introdução ao JavaScript");
            jsEpisode1.setSynopsis("Conceitos básicos de JS.");
            jsEpisode1.setOrder(1);
            jsEpisode1.setVideoUrl("url_video1");
            jsEpisode1.setSecondsLong(1200L);
            jsEpisode1.setCourse(jsCourse);
            episodeRepository.save(jsEpisode1);

            Episode jsEpisode2 = new Episode();
            jsEpisode2.setName("Variáveis e Tipos");
            jsEpisode2.setSynopsis("Trabalhando com dados em JS.");
            jsEpisode2.setOrder(2);
            jsEpisode2.setVideoUrl("url_vildeo2");
            jsEpisode2.setSecondsLong(1500L);
            jsEpisode2.setCourse(jsCourse);
            episodeRepository.save(jsEpisode2);

            Episode designEpisode1 = new Episode();
            designEpisode1.setName("HTML e CSS para Designers");
            designEpisode1.setSynopsis("Estruturando e estilizando páginas web.");
            designEpisode1.setOrder(1);
            designEpisode1.setVideoUrl("url_video3");
            designEpisode1.setSecondsLong(1800L);
            designEpisode1.setCourse(designCourse);
            episodeRepository.save(designEpisode1);

            Episode seoEpisode1 = new Episode();
            seoEpisode1.setName("O que é SEO?");
            seoEpisode1.setSynopsis("Entendendo a otimização para buscadores.");
            seoEpisode1.setOrder(1);
            seoEpisode1.setVideoUrl("url_video4");
            seoEpisode1.setSecondsLong(900L);
            seoEpisode1.setCourse(seoCourse);
            episodeRepository.save(seoEpisode1);

            Episode agileEpisode1 = new Episode();
            agileEpisode1.setName("Fundamentos do Scrum");
            agileEpisode1.setSynopsis("Princípios e práticas do Scrum.");
            agileEpisode1.setOrder(1);
            agileEpisode1.setVideoUrl("url_video5");
            agileEpisode1.setSecondsLong(2100L);
            agileEpisode1.setCourse(agileCourse);
            episodeRepository.save(agileEpisode1);

            Episode reactEpisode1 = new Episode();
            reactEpisode1.setName("Introdução ao React");
            reactEpisode1.setSynopsis("Primeiros passos com React.");
            reactEpisode1.setOrder(1);
            reactEpisode1.setVideoUrl("url_video6");
            reactEpisode1.setSecondsLong(1500L);
            reactEpisode1.setCourse(reactCourse);
            episodeRepository.save(reactEpisode1);

            // Inserir usuários
            User user1 = new User();
            user1.setFirstName("Ana");
            user1.setLastName("Pereira");
            user1.setPhone("11977777777");
            user1.setBirthDate(LocalDate.of(1995, 3, 10));
            user1.setEmail("ana.pereira@email.com");
            userRepository.save(user1);

            User user2 = new User();
            user2.setFirstName("Carlos");
            user2.setLastName("Rodrigues");
            user2.setPhone("11966666666");
            user2.setBirthDate(LocalDate.of(1988, 11, 25));
            user2.setEmail("carlos.rodrigues@email.com");
            userRepository.save(user2);

            User user3 = new User();
            user3.setFirstName("Mariana");
            user3.setLastName("Almeida");
            user3.setPhone("11955555555");
            user3.setBirthDate(LocalDate.of(2000, 7, 2));
            user3.setEmail("mariana.almeida@email.com");
            userRepository.save(user3);

            // Inserir favoritos
            Favorite favorite1 = new Favorite();
            favorite1.setCourse(jsCourse);
            favorite1.setUser(user1);
            favoriteRepository.save(favorite1);

            Favorite favorite2 = new Favorite();
            favorite2.setCourse(designCourse);
            favorite2.setUser(user1);
            favoriteRepository.save(favorite2);

            Favorite favorite3 = new Favorite();
            favorite3.setCourse(reactCourse);
            favorite3.setUser(user2);
            favoriteRepository.save(favorite3);

            // Inserir likes
            Like like1 = new Like();
            like1.setCourse(jsCourse);
            like1.setUser(user1);
            likeRepository.save(like1);

            Like like2 = new Like();
            like2.setCourse(jsCourse);
            like2.setUser(user2);
            likeRepository.save(like2);

            Like like3 = new Like();
            like3.setCourse(seoCourse);
            like3.setUser(user3);
            likeRepository.save(like3);

            Like like4 = new Like();
            like4.setCourse(designCourse);
            like4.setUser(user2);
            likeRepository.save(like4);

            // Inserir watch times
            WatchTime watchTime1 = new WatchTime();
            watchTime1.setEpisode(jsEpisode1);
            watchTime1.setUser(user1);
            watchTime1.setSeconds(600L);
            watchTimeRepository.save(watchTime1);

            WatchTime watchTime2 = new WatchTime();
            watchTime2.setEpisode(jsEpisode2);
            watchTime2.setUser(user1);
            watchTime2.setSeconds(600L);
            watchTimeRepository.save(watchTime2);

            WatchTime watchTime3 = new WatchTime();
            watchTime3.setEpisode(jsEpisode2);
            watchTime3.setUser(user2);
            watchTime3.setSeconds(900L);
            watchTimeRepository.save(watchTime3);

            WatchTime watchTime4 = new WatchTime();
            watchTime4.setEpisode(seoEpisode1);
            watchTime4.setUser(user3);
            watchTime4.setSeconds(450L);
            watchTimeRepository.save(watchTime4);

            System.out.println("Dados iniciais inseridos com sucesso!");
        } else {
            System.out.println("Dados iniciais já existem.");
        }
    }
}
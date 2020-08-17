package info.vziks.api.controller;

import info.vziks.api.beans.*;
import info.vziks.api.model.Issue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class AppContextController
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@RestController
public class AppContextController {

    @RequestMapping("/appcontext")
    public List<Music> getContext() {

        List<Music> musics = new ArrayList<>();

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        try (ClassPathXmlApplicationContext contextTry =
                     new ClassPathXmlApplicationContext("myAppContext.xml")

        ) {
            musics.add(contextTry.getBean("rockMusic", RockMusic.class));
            musics.add(contextTry.getBean("classicMusic", ClassicMusic.class));


            String[] allBeanNames = contextTry.getBeanDefinitionNames();

            for (String bean :
                    allBeanNames) {
                System.out.println(bean);
            }

            musics.add(context.getBean(PopMusic.class));
            musics.add((Music) context.getBean("popMusicConfig"));
            musics.add(context.getBean("popMusicConfig", PopMusic.class));

            for (Music music : musics) {
                MusicPlayer musicPlayer = new MusicPlayer(music);
                System.out.println(musicPlayer.playSong());
            }


            MyBean myBean = contextTry.getBean("myBean", MyBean.class);
            MyBean myBean1 = contextTry.getBean("myBean", MyBean.class);


            System.out.println(myBean);
            System.out.println(myBean);


        }


        return musics;
    }


    @RequestMapping("/appcontext/score")
    public Map<Integer, MyBean> getBeansScope() {

        Map<Integer, MyBean> myBeans = new HashMap<>();

        try (ClassPathXmlApplicationContext contextTry =
                     new ClassPathXmlApplicationContext("myAppContext.xml")

        ) {
            MyBean myBean = contextTry.getBean("myBean", MyBean.class);
            MyBean myBean1 = contextTry.getBean("myBean", MyBean.class);

            myBeans.put(myBean.hashCode(), myBean);
            myBeans.put(myBean1.hashCode(), myBean1);
        }

        return myBeans;
    }

}

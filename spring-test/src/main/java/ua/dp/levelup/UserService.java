package ua.dp.levelup;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by java on 16.06.2017.
 */
public class UserService implements InitializingBean, DisposableBean {



    public void destroy() throws Exception {
        System.out.println("bye bye chepushilo");
        doMagic();
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("hello chepushilo");
        doMagic();
    }


    @Profiling
    public void doMagic(){
        System.out.println("UserService does magic");
    }

}

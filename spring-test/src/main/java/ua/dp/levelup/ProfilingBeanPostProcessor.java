package ua.dp.levelup;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by java on 16.06.2017.
 */
public class ProfilingBeanPostProcessor implements BeanPostProcessor {


    private static Map<String, Class> beans = new HashMap<>();

    public Object postProcessBeforeInitialization(Object o, String beanName) throws BeansException {
        Class<?> beanClass = o.getClass();
        for (Method m : beanClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Profiling.class)) {
                beans.put(beanName, beanClass);
                return o;
            }
        }

        return o;
    }

    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        if (beans.containsKey(beanName)) {
            Class beanClass = beans.get(beanName);
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.isAnnotationPresent(Profiling.class)) {
                        System.out.println("Start profiling");
                        long start = System.nanoTime();

                        Object result = method.invoke(bean, args);

                        System.out.println("End profiling with time" + (System.nanoTime()-start));
                        return result;
                    }

                    return method.invoke(bean, args);
                }
            });
        }

        return bean;
    }
}

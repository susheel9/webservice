package web.service.webservice.model;

/**
 * thread local class used to store user information
 */
public class UserTreadLocal {

    static private ThreadLocal threadLocal = new ThreadLocal<User>();

    public static ThreadLocal<User> getThreadLocal() {
        return threadLocal;
    }
}

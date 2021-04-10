package edu.ait.listnames.token;

/**
 * @author XiaoGuiYou
 */
public class TokenThreadLocal {
    private static ThreadLocal<TokenDto> threadLocal = new ThreadLocal<>();

    /**
     * 保存用户
     *
     * @param t
     */
    public static void put(TokenDto t) {
        threadLocal.set(t);
    }

    /**
     * 获取用户
     *
     * @return
     */
    public static TokenDto get() {
        return threadLocal.get();
    }

    /**
     * 清空
     */
    public static void remove() {
        threadLocal.remove();
    }

    /**
     * 获取用户
     *
     * @return
     */
    public static Long getUserId() {
        return threadLocal.get() != null ? Long.valueOf(threadLocal.get().getUserId()) : null;
    }
}

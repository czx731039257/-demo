import redis.clients.jedis.Jedis;

public class Demo {

    private static Jedis jedis=null;

    public static void main(String[] args) {

        Demo.initJedis();
        String value=null;
        /*session1*/
        Demo.addSession("sessionid1","name","czx");
        value = Demo.getSession("sessionid1", "name");
        System.out.println(value);

        /*session2*/
        Demo.addSession("sessionid2","name","jsh");
        value = Demo.getSession("sessionid2", "name");
        System.out.println(value);

    }

    /**
     * 初始化 jedis
     * @return
     */
    public static Jedis initJedis(){
        if(jedis==null) {
            jedis=new Jedis("127.0.0.1",6379);
        }
        return jedis;
    }


    /**
     * 给某个session域 添加key-value对
     * @param sessionid
     * @param field
     * @param value
     */
    public static void addSession(String sessionid ,String field , String value){
        jedis.hset(sessionid,field,value);
    }

    /**
     * 从某个session域 获取key对应的value
     * @param sessionid
     * @param field
     * @return
     */
    public static String getSession(String sessionid ,String field){
        return jedis.hget(sessionid,field);
    }

}
package cn.homjie.hazelcast.tutorial;

import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * @author jiehong.jh
 * @date 2018/10/11
 */
public class MapBackupMain {

    /*
        <!-- 0表示不备份，1表示备份到其他一个成员 -->
        <!-- 同步备份 -->
        <backup-count>0</backup-count>
        <!-- 异步备份 -->
        <async-backup-count>1</async-backup-count>
     */

    public static void main(String[] args) {
        // 先启动 map1()，后启动 map3()，再关闭 map1()，启动 map2()
        //map1();
        map2();
        //map3();
    }

    private static void map1() {
        HazelcastInstance hz1 = Hazelcast.newHazelcastInstance();
        System.out.println("map1 start");
        Map<String, String> hz1Map = hz1.getMap("capitals");
        hz1Map.put("1", "Tokyo");
        hz1Map.put("2", "Paris");
        hz1Map.put("3", "Washington");
        hz1Map.put("4", "Ankara");
        hz1Map.put("5", "Brussels");
        hz1Map.put("6", "Amsterdam");
        hz1Map.put("7", "New Delhi");
        hz1Map.put("8", "London");
        hz1Map.put("9", "Berlin");
        hz1Map.put("10", "Oslo");
        hz1Map.put("11", "Moscow");
        hz1Map.put("12", "ShangHai");
    }

    private static void map2() {
        HazelcastInstance hz2 = Hazelcast.newHazelcastInstance();
        System.out.println("map2 start");
        IMap<Object, Object> hz2Map = hz2.getMap("capitals");
        hz2Map.forEach((k, v) -> System.out.println("k: " + k + ", v: " + v));
    }

    private static void map3() {
        Hazelcast.newHazelcastInstance();
        System.out.println("map3 start");
    }
}

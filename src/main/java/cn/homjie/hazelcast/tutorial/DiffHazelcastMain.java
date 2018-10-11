package cn.homjie.hazelcast.tutorial;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;

/**
 * @author jiehong.jh
 * @date 2018/10/11
 */
public class DiffHazelcastMain {

    public static void main(String[] args) {
        Config config = new Config();
        // 与 FirstHazelcastMain 不在同一个集群
        config.getGroupConfig().setName("Other");
        Hazelcast.newHazelcastInstance(config);
        Hazelcast.newHazelcastInstance(config);
    }
}

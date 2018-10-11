package cn.homjie.hazelcast.tutorial;

import com.hazelcast.core.Hazelcast;

/**
 * @author jiehong.jh
 * @date 2018/10/11
 */
public class FirstHazelcastMain {

    public static void main(String[] args) {
        // 启动多次可以看到集群建立
        Hazelcast.newHazelcastInstance();
    }
}

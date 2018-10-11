package cn.homjie.hazelcast.tutorial;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

/**
 * @author jiehong.jh
 * @date 2018/10/11
 */
public class TopicPublishMain {

    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        // 所以 Topic 下的订阅者都能收到消息
        ITopic<String> topic = hazelcastInstance.getTopic("default");
        topic.addMessageListener(new Listener());
        topic.publish("Hello World");
    }

    public static class Listener implements MessageListener<String> {
        @Override
        public void onMessage(Message<String> message) {
            System.out.println("Message received = " + message.getMessageObject());
        }
    }
}

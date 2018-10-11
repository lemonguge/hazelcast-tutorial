package cn.homjie.hazelcast.tutorial;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ISet;
import com.hazelcast.core.ItemEvent;
import com.hazelcast.core.ItemListener;

/**
 * @author jiehong.jh
 * @date 2018/10/11
 */
public class ItemListenerMain {

    public static void main(String[] args) {
        // 多次启动，可以看到每个成功都能收到 Listener
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

        ISet<Long> set = hazelcastInstance.getSet("default");
        set.addItemListener(new LongItemListener(), true);
        set.add(System.currentTimeMillis());
    }

    public static class LongItemListener implements ItemListener<Long> {

        @Override
        public void itemAdded(ItemEvent<Long> event) {
            System.out.println("Item added:  " + event);
        }

        @Override
        public void itemRemoved(ItemEvent<Long> event) {
            System.out.println("Item removed: " + event);
        }
    }
}

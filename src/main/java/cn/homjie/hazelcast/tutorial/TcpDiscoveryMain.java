package cn.homjie.hazelcast.tutorial;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.TcpIpConfig;
import com.hazelcast.core.Hazelcast;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jiehong.jh
 * @date 2018/10/11
 */
@Slf4j
public class TcpDiscoveryMain {
    /*
        <multicast enabled="false"></multicast>
        <tcp-ip enabled="true">
            <member>machine1</member>
            <member>machine2</member>
            <member>machine3:5799</member>
            <member>192.168.1.0-7</member>
            <member>192.168.1.21</member>
        </tcp-ip>
     */

    public static void main(String[] args) throws UnknownHostException {
        String address = InetAddress.getLocalHost().getHostAddress();
        log.info("localhost: {}", address);
        Config config = new Config();
        config.getGroupConfig().setName("TcpDiscovery");
        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
        joinConfig.getMulticastConfig().setEnabled(false);
        // 不需要列出所有的集群成员，当一个新成员加入，配置的集群成员中至少要有一个激活
        TcpIpConfig tcpIpConfig = joinConfig.getTcpIpConfig();
        tcpIpConfig.setEnabled(true);
        tcpIpConfig.addMember("192.168.1.10:5701");
        // 当前 IP 不是 192.168.1.10，所以不会加入同一集群
        Hazelcast.newHazelcastInstance(config);
        Hazelcast.newHazelcastInstance(config);
    }
}

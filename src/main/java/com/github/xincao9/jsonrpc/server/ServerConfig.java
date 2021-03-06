package com.github.xincao9.jsonrpc.server;

import com.github.xincao9.jsonrpc.constant.ServerConfigConsts;
import com.github.xincao9.jsonrpc.util.PropertiesUtils;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author xincao9@gmail.com
 */
public class ServerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerConfig.class);

    public static Integer port;
    public static Integer ioThreadBoss;
    public static Integer ioThreadWorker;

    public static Boolean init(String filename) {
        try {
            Properties pros = PropertiesUtils.read(filename, ServerConfigConsts.DEFAULT_CONFIG_FILENAME);
            port = Integer.valueOf(String.valueOf(pros.getProperty(ServerConfigConsts.PORT, ServerConfigConsts.DEFAULT_PORT)));
            ioThreadBoss = Integer.valueOf(String.valueOf(pros.getProperty(ServerConfigConsts.IO_THREAD_BOSS, ServerConfigConsts.DEFAULT_IO_THREAD_BOSS)));
            ioThreadWorker = Integer.valueOf(String.valueOf(pros.getProperty(ServerConfigConsts.IO_THREAD_WORKER, ServerConfigConsts.DEFAULT_IO_THREAD_WORKER)));
            if (port <= 0 || port > 65535) {
                port = Integer.valueOf(ServerConfigConsts.DEFAULT_PORT);
            }
            if (ioThreadBoss <= 0 || ioThreadBoss > 4) {
                ioThreadBoss = Integer.valueOf(ServerConfigConsts.DEFAULT_IO_THREAD_BOSS);
            }
            if (ioThreadWorker <= 0) {
                ioThreadWorker = Integer.valueOf(ServerConfigConsts.DEFAULT_IO_THREAD_WORKER);
            }
            return true;
        } catch (IOException ioe) {
            LOGGER.error(ioe.getMessage());
        }
        return false;

    }
}

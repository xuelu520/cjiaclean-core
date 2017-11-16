package redis.clients.jedis;

import redis.clients.jedis.exceptions.InvalidURIException;
import redis.clients.util.JedisURIHelper;
import redis.clients.util.ShardInfo;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import java.net.URI;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class JedisShardInfo extends ShardInfo<Jedis> {
    private int connectionTimeout;
    private int soTimeout;
    private String host;
    private int port;
    private String password;
    private String name;
    private int db;
    private boolean ssl;
    private SSLSocketFactory sslSocketFactory;
    private SSLParameters sslParameters;
    private HostnameVerifier hostnameVerifier;

    public JedisShardInfo(String host, String password) {
        super(1);
        this.password = password;
        this.name = null;
        this.db = 0;
        URI uri = URI.create(host);
        if(JedisURIHelper.isValid(uri)) {
            this.host = uri.getHost();
            this.port = uri.getPort();
            if(this.password == null){
                this.password = JedisURIHelper.getPassword(uri);
            }
            this.db = JedisURIHelper.getDBIndex(uri) > 15 ? 0 : JedisURIHelper.getDBIndex(uri);
            this.ssl = uri.getScheme().equals("rediss");
        } else {
            this.host = host;
            this.port = 6379;
        }

    }

    public JedisShardInfo(String host, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier, String password) {
        super(1);
        this.password = password;
        this.name = null;
        this.db = 0;
        URI uri = URI.create(host);
        if(JedisURIHelper.isValid(uri)) {
            this.host = uri.getHost();
            this.port = uri.getPort();
            if(this.password == null){
                this.password = JedisURIHelper.getPassword(uri);
            }
            this.db = JedisURIHelper.getDBIndex(uri) > 15 ? 0 : JedisURIHelper.getDBIndex(uri);
            this.ssl = uri.getScheme().equals("rediss");
            this.sslSocketFactory = sslSocketFactory;
            this.sslParameters = sslParameters;
            this.hostnameVerifier = hostnameVerifier;
        } else {
            this.host = host;
            this.port = 6379;
        }

    }

    public JedisShardInfo(String host, String name, String password) {
        this(host, 6379, name, password);
    }

    public JedisShardInfo(String host, int port, String password) {
        this(host, port, 2000, password);
    }

    public JedisShardInfo(String host, int port, boolean ssl, String password) {
        this(host, port, 2000, 2000, 1, ssl, password);
    }

    public JedisShardInfo(String host, int port, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier, String password) {
        this(host, port, 2000, 2000, 1, ssl, sslSocketFactory, sslParameters, hostnameVerifier, password);
    }

    public JedisShardInfo(String host, int port, String name, String password) {
        this(host, port, 2000, name, password);
    }

    public JedisShardInfo(String host, int port, String name, boolean ssl, String password) {
        this(host, port, 2000, name, ssl, password);
    }

    public JedisShardInfo(String host, int port, String name, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier, String password) {
        this(host, port, 2000, name, ssl, sslSocketFactory, sslParameters, hostnameVerifier, password);
    }

    public JedisShardInfo(String host, int port, int timeout, String password) {
        this(host, port, timeout, timeout, 1, password);
    }

    public JedisShardInfo(String host, int port, int timeout, boolean ssl, String password) {
        this(host, port, timeout, timeout, 1, ssl, password);
    }

    public JedisShardInfo(String host, int port, int timeout, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier, String password) {
        this(host, port, timeout, timeout, 1, ssl, sslSocketFactory, sslParameters, hostnameVerifier, password);
    }

    public JedisShardInfo(String host, int port, int timeout, String name, String password) {
        this(host, port, timeout, timeout, 1, password);
        this.name = name;
    }

    public JedisShardInfo(String host, int port, int timeout, String name, boolean ssl, String password) {
        this(host, port, timeout, timeout, 1, password);
        this.name = name;
        this.ssl = ssl;
    }

    public JedisShardInfo(String host, int port, int timeout, String name, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier, String password) {
        this(host, port, timeout, timeout, 1, password);
        this.name = name;
        this.ssl = ssl;
        this.sslSocketFactory = sslSocketFactory;
        this.sslParameters = sslParameters;
        this.hostnameVerifier = hostnameVerifier;
    }

    public JedisShardInfo(String host, int port, int connectionTimeout, int soTimeout, int weight, String password) {
        super(weight);
        this.password = password;
        this.name = null;
        this.db = 0;
        this.host = host;
        this.port = port;
        this.connectionTimeout = connectionTimeout;
        this.soTimeout = soTimeout;
    }

    public JedisShardInfo(String host, int port, int connectionTimeout, int soTimeout, int weight, boolean ssl, String password) {
        super(weight);
        this.password = password;
        this.name = null;
        this.db = 0;
        this.host = host;
        this.port = port;
        this.connectionTimeout = connectionTimeout;
        this.soTimeout = soTimeout;
        this.ssl = ssl;
    }

    public JedisShardInfo(String host, int port, int connectionTimeout, int soTimeout, int weight, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier, String password) {
        super(weight);
        this.password = password;
        this.name = null;
        this.db = 0;
        this.host = host;
        this.port = port;
        this.connectionTimeout = connectionTimeout;
        this.soTimeout = soTimeout;
        this.ssl = ssl;
        this.sslSocketFactory = sslSocketFactory;
        this.sslParameters = sslParameters;
        this.hostnameVerifier = hostnameVerifier;
    }

    public JedisShardInfo(String host, String name, int port, int timeout, int weight, String password) {
        super(weight);
        this.password = password;
        this.name = null;
        this.db = 0;
        this.host = host;
        this.name = name;
        this.port = port;
        this.connectionTimeout = timeout;
        this.soTimeout = timeout;
    }

    public JedisShardInfo(String host, String name, int port, int timeout, int weight, boolean ssl, String password) {
        super(weight);
        this.password = password;
        this.name = null;
        this.db = 0;
        this.host = host;
        this.name = name;
        this.port = port;
        this.connectionTimeout = timeout;
        this.soTimeout = timeout;
        this.ssl = ssl;
    }

    public JedisShardInfo(String host, String name, int port, int timeout, int weight, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier, String password) {
        super(weight);
        this.password = password;
        this.name = null;
        this.db = 0;
        this.host = host;
        this.name = name;
        this.port = port;
        this.connectionTimeout = timeout;
        this.soTimeout = timeout;
        this.ssl = ssl;
        this.sslSocketFactory = sslSocketFactory;
        this.sslParameters = sslParameters;
        this.hostnameVerifier = hostnameVerifier;
    }

    public JedisShardInfo(URI uri, String password) {
        super(1);
        this.password = password;
        this.name = null;
        this.db = 0;
        if(!JedisURIHelper.isValid(uri)) {
            throw new InvalidURIException(String.format("Cannot open Redis connection due invalid URI. %s", new Object[]{uri.toString()}));
        } else {
            this.host = uri.getHost();
            this.port = uri.getPort();
            if(this.password == null){
                this.password = JedisURIHelper.getPassword(uri);
            }
            this.db = JedisURIHelper.getDBIndex(uri) > 15 ? 0 : JedisURIHelper.getDBIndex(uri);
            this.ssl = uri.getScheme().equals("rediss");
        }
    }

    public JedisShardInfo(URI uri, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier, String password) {
        super(1);
        this.password = password;
        this.name = null;
        this.db = 0;
        if(!JedisURIHelper.isValid(uri)) {
            throw new InvalidURIException(String.format("Cannot open Redis connection due invalid URI. %s", new Object[]{uri.toString()}));
        } else {
            this.host = uri.getHost();
            this.port = uri.getPort();
            if(this.password == null){
                this.password = JedisURIHelper.getPassword(uri);
            }
            this.db = JedisURIHelper.getDBIndex(uri) > 15 ? 0 : JedisURIHelper.getDBIndex(uri);
            this.ssl = uri.getScheme().equals("rediss");
            this.sslSocketFactory = sslSocketFactory;
            this.sslParameters = sslParameters;
            this.hostnameVerifier = hostnameVerifier;
        }
    }

    public String toString() {
        return this.host + ":" + this.port + "*" + this.getWeight();
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String auth) {
        this.password = auth;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getSoTimeout() {
        return this.soTimeout;
    }

    public void setSoTimeout(int soTimeout) {
        this.soTimeout = soTimeout;
    }

    public String getName() {
        return this.name;
    }

    public int getDb() {
        return this.db;
    }

    public boolean getSsl() {
        return this.ssl;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public SSLParameters getSslParameters() {
        return this.sslParameters;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public Jedis createResource() {
        return new Jedis(this);
    }
}


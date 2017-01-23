package com.medal.weixin.sdk.util;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 证书信任管理器（用于https请求）
 *
 * 这个证书管理器的作用就是让它信任我们指定的证书，上面的代码意味着信任所有证书，不管是否权威机构颁发
 * Created by xhuji on 2016/9/3.
 */
public class MyX509TrustManager implements X509TrustManager {

    /**
     * 检查客户端证书
     * @param x509Certificates
     * @param s
     * @throws CertificateException
     */
    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    /**
     * 检查服务器端证书
     * @param x509Certificates
     * @param s
     * @throws CertificateException
     */
    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    /**
     * 返回受信任的X509证书数组
     * @return
     */
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}

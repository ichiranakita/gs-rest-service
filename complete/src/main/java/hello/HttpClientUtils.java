package hello;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.File;

/**
 * private PersonService personService = Feign.builder().client(new ApacheHttpClient(HttpClientUtils.getTLSHttpClient()))
 *             .encoder(new JacksonEncoder())
 *             .decoder(new JacksonDecoder()).target(PersonService.class, baseUrl);
 *
 *
 */
public class HttpClientUtils {
    static String trustStorePath = HttpClientUtils.class.getResource("/rabbittruststore.jks").getPath();

    public static HttpClient getTLSHttpClient() {
        SSLContext sslcontext = null;
        try {
            sslcontext = SSLContexts.custom().loadTrustMaterial(new File(trustStorePath), "rabbit".toCharArray(), new TrustSelfSignedStrategy()).build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext, new String[] {"TLSv1"}, null, NoopHostnameVerifier.INSTANCE
        );

        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        return httpclient;
    }

}

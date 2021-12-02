package org.es.client.pool.factory;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/11/5 15:51
 * @Description:
 **/
public class EsClientFactory implements PooledObjectFactory<RestClient> {

    private final RestClientBuilder restClientBuilder;

    public EsClientFactory(RestClientBuilder restClientBuilder){
        this.restClientBuilder = restClientBuilder;
        RestClient build = restClientBuilder.build();
        ClientBuilder.
    }

    @Override
    public void activateObject(PooledObject<RestClient> p) throws Exception {

    }

    @Override
    public void destroyObject(PooledObject<RestClient> p) throws Exception {

    }

    @Override
    public PooledObject<RestClient> makeObject() throws Exception {
        return null;
    }

    @Override
    public void passivateObject(PooledObject<RestClient> p) throws Exception {

    }

    @Override
    public boolean validateObject(PooledObject<RestClient> p) {
        return false;
    }
}

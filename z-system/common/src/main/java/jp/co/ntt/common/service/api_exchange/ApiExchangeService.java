package jp.co.ntt.common.service.api_exchange;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

@Service
public interface ApiExchangeService<S, T> {
    /**
     *
     * @param url
     * @param body
     * @return
     */
    RequestEntity<S> postRequest(String url, S body) throws URISyntaxException;

    /**
     *
     * @param url
     * @param parameters
     * @param clazz
     * @return
     * @throws URISyntaxException
     */
    ResponseEntity<S> getRequest(String url, String[] parameters, Class<S> clazz) throws URISyntaxException;

    /**
     *
     * @param url
     * @param body
     * @return
     */
    RequestEntity<S> putRequest(String url, S body) throws URISyntaxException;

    /**
     *
     * @return
     */
    ResponseEntity<T> response(RequestEntity<S> request, Class<T> typeClass);
}

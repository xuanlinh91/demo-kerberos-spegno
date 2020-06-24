package jp.co.ntt.common.service.api_exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class ApiExchangeServiceImpl<S, T> implements ApiExchangeService<S, T> {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public RequestEntity<S> postRequest(String url, S body) throws URISyntaxException {
        return RequestEntity
                .post(new URI(url))
                .accept(MediaType.APPLICATION_JSON)
                .body(body);
    }

    @Override
    public ResponseEntity<S> getRequest(String url, String[] parameters, Class<S> clazz) throws URISyntaxException {
        String param = String.join("/", parameters);
        return restTemplate.getForEntity(new URI(url) + param, clazz);
    }

    @Override
    public RequestEntity<S> putRequest(String url, S body) throws URISyntaxException {
        return RequestEntity
                .put(new URI(url))
                .accept(MediaType.APPLICATION_JSON)
                .body(body);
    }

    @Override
    public ResponseEntity<T> response(RequestEntity<S> request, Class<T> clazz) {
        return restTemplate.exchange(request, clazz);
    }
}

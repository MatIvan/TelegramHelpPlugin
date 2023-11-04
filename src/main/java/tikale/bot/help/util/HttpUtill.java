package tikale.bot.help.util;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import tikale.bot.help.entity.dto.BotGetDto;
import tikale.bot.help.entity.dto.MessageResponseDto;

@Service
public class HttpUtill {

    private static final Logger LOG = LoggerFactory.getLogger(HttpUtill.class);

    private static final String GET = "/get";
    private static final String SEND = "/send";

    private String host;
    private String token;

    private final RestTemplate restTemplate;

    @Autowired
    public HttpUtill(RestTemplateBuilder restTemplateBuilder, @Value("${bot.host}") String host, @Value("${my.token}") String token,
            @Value("${http.timeout:1}") int timeout) {
        this.host = host;
        this.token = token;
        this.restTemplate = restTemplateBuilder
                .requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
                .rootUri(this.host)
                .setConnectTimeout(Duration.ofSeconds(timeout))
                .setReadTimeout(Duration.ofSeconds(timeout))
                .errorHandler(new DefaultResponseErrorHandler())
                .build();

    }

    public List<BotGetDto> get() {
        LOG.trace("get message");
        HttpEntity<String> entity = new HttpEntity<String>(getHeader());

        ResponseEntity<List<BotGetDto>> response = this.restTemplate.exchange(
                GET,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<BotGetDto>>() {

                });

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }

        return null;
    }

    public void sendText(MessageResponseDto message) {
        HttpEntity<MessageResponseDto> entity = new HttpEntity<MessageResponseDto>(message, getHeader());

        this.restTemplate.exchange(
                SEND,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<List<BotGetDto>>() {

                });
    }

    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set(StringUtil.AUTHORIZATION, StringUtil.TOKEN + StringUtil.SPACE + token);

        return headers;
    }
}

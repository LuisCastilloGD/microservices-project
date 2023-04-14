package com.grid.product.config;


import com.grid.product.exceptions.ProductNotFoundedException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomFeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(final String s, final Response response) {

        switch (response.status()) {
            case 404 -> {
                log.error("Not product Founded");
                return new ProductNotFoundedException();
            }
            default -> {
                log.error("Error in request went through feign client");
                return new RuntimeException("Common Feign Exception");
            }
        }
    }




}

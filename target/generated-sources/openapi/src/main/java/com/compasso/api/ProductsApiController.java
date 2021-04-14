package com.compasso.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-04-13T17:10:20.487025-03:00[America/Sao_Paulo]")

@Controller
@RequestMapping("${openapi.productMSCOMPASSOUOL.base-path:/v1}")
public class ProductsApiController implements ProductsApi {

    private final ProductsApiDelegate delegate;

    public ProductsApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) ProductsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ProductsApiDelegate() {});
    }

    @Override
    public ProductsApiDelegate getDelegate() {
        return delegate;
    }

}

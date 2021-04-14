package com.compasso.api;

import java.math.BigDecimal;
import com.compasso.model.Error;
import com.compasso.model.Product;
import com.compasso.model.ProductData;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ProductsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-04-13T17:10:20.487025-03:00[America/Sao_Paulo]")

public interface ProductsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /products : Create new product
     *
     * @param productData  (optional)
     * @return Created (status code 201)
     *         or Bad Request (status code 400)
     * @see ProductsApi#createProduct
     */
    default ResponseEntity<Product> createProduct(ProductData productData) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"price\" : 1.54, \"name\" : \"name\", \"description\" : \"description\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /products/{id} : Delete product by id
     *
     * @param id The id of the product that needs to be deleted.  (required)
     * @return Ok (status code 200)
     *         or Not Found (status code 404)
     * @see ProductsApi#deleteProductById
     */
    default ResponseEntity<Void> deleteProductById(Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /products/{id} : Get product by id
     *
     * @param id The id of the product that needs to be fetched.  (required)
     * @return Ok (status code 200)
     *         or Not Found (status code 404)
     * @see ProductsApi#getProductById
     */
    default ResponseEntity<Product> getProductById(Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"price\" : 1.54, \"name\" : \"name\", \"description\" : \"description\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /products : List all products
     *
     * @return Ok (status code 200)
     *         or No Content (status code 204)
     * @see ProductsApi#listProducts
     */
    default ResponseEntity<List<Product>> listProducts() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"price\" : 1.54, \"name\" : \"name\", \"description\" : \"description\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /products/search : List all products with filters
     *
     * @param q Name or description (optional)
     * @param minPrice Minimum price (optional)
     * @param maxPrice Maximum price (optional)
     * @return Ok (status code 200)
     *         or No Content (status code 204)
     * @see ProductsApi#listProductsFilter
     */
    default ResponseEntity<List<Product>> listProductsFilter(String q,
        BigDecimal minPrice,
        BigDecimal maxPrice) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"price\" : 1.54, \"name\" : \"name\", \"description\" : \"description\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /products/{id} : Update product by id
     *
     * @param id The id of the product that needs to be updated.  (required)
     * @param productData  (optional)
     * @return Ok (status code 200)
     *         or Not Found (status code 404)
     * @see ProductsApi#updateProductById
     */
    default ResponseEntity<Product> updateProductById(Integer id,
        ProductData productData) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"price\" : 1.54, \"name\" : \"name\", \"description\" : \"description\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return 400 HttpStatus when request param is string"
    request {
        method GET()
        url("/basicDataOfClient") {
            queryParameters {
                parameter("size", anyNonEmptyString())
            }
        }
    }
    response {
        status BAD_REQUEST()
    }
}
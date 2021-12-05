import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return 400 HttpStatus when request param is null"
    request {
        method GET()
        url("/basicDataOfClient") {
            queryParameters {
                parameter("size", null)
            }
        }
    }
    response {
        status BAD_REQUEST()
    }
}
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return 400 HttpStatus when request param is empty"
    request {
        method GET()
        url("/basicDataOfClient") {
            queryParameters {
            }
        }
    }
    response {
        status BAD_REQUEST()
    }
}
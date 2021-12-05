import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return 400 HttpStatus when request params are empty"
    request {
        method GET()
        url("/optionalDataOfClient") {
            queryParameters {
            }
        }
    }
    response {
        status BAD_REQUEST()
    }
}


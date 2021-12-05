import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return 400 HttpStatus when request SIZE, PARAMS are null"
    request {
        method GET()
        url("/optionalDataOfClient") {
            queryParameters {
                parameter("size", null)
                parameter("params", null)
            }
        }
    }
    response {
        status BAD_REQUEST()
    }
}
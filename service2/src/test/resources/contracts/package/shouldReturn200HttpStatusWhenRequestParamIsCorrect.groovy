import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return status 200 when request param is between 1 and 500"
    request {
        method GET()
        url("/basicDataOfClient") {
            queryParameters {
                parameter("size", 100)
            }
        }
    }
    response {
        body(anyNonEmptyString())
        status OK()
    }
}

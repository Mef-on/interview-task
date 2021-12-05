import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return status 400 when PARAMS has incorrect keys"
    request {
        method GET()
        url("/optionalDataOfClient") {
            queryParameters {
                parameter("size", 3)
                parameter("params", "secondName, id_")
            }
        }
    }
    response {
        status(BAD_REQUEST())
    }
}


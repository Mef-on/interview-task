import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return status 200 when request param is between 1 and 500 and all elements of PARAMS are correct"
    request {
        method GET()
        url("/optionalDataOfClient") {
            queryParameters {
                parameter("size", 3)
                parameter("params", "_id, _type, key, name, fullName, iata_airport_code, " +
                        "type, country, latitude, longitude, location_id, inEurope, countryCode, coreCountry, distance")
            }
        }
    }
    response {
        body(anyNonEmptyString())
        status OK()
    }
}


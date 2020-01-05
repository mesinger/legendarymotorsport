package mesi.gta.legendarymotorsport.controller

import mesi.gta.legendarymotorsport.dao.Vehicle
import mesi.gta.legendarymotorsport.service.VehicleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("vehicle")
class VehicleController {

    @Autowired
    private lateinit var service : VehicleService

    @RequestMapping(
            method = [RequestMethod.POST],
            consumes = ["application/json"],
            produces = ["application/json"]
    )
    fun create(@RequestBody vehicle : Vehicle) : Vehicle {
        return service.add(vehicle)
    }
}
package mesi.gta.legendarymotorsport.service

import mesi.gta.legendarymotorsport.dao.Vehicle
import mesi.gta.legendarymotorsport.dao.VehicleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class VehicleService {

    @Autowired
    private lateinit var repo : VehicleRepository

    fun add(vehicle : Vehicle) : Vehicle {
        return repo.save(vehicle)
    }
}
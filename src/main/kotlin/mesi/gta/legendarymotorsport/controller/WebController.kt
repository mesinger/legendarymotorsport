package mesi.gta.legendarymotorsport.controller

import mesi.gta.legendarymotorsport.dao.VehicleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class WebController {

    @Autowired
    private lateinit var vehicleRepo: VehicleRepository

    @GetMapping(path = ["index", ""], produces = ["text/html"])
    fun index(model : Model) : String {
        model.addAttribute("vehicles", vehicleRepo.findAll())
        return "index"
    }
}
package mesi.gta.legendarymotorsport.exception

import com.fasterxml.jackson.core.JsonParseException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class JacksonExceptionController {

    @ExceptionHandler(JsonParseException::class)
    fun onParseException() : ResponseEntity<String> {
        return ResponseEntity.badRequest().body("Invalid request")
    }
}
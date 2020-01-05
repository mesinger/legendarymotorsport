package mesi.gta.legendarymotorsport.dao

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "vehicles")
data class Vehicle (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonProperty(required = false)
        val id : Long,

        @Column(length = 50, nullable = false)
        val manufacturer : String,

        @Column(length = 50, nullable = false)
        val name : String,

        @Column(nullable = false)
        val price : Float,

        @Column(length = 150, nullable = false)
        val image : String,

        @Column(length = 100, nullable = false)
        val headline : String,

        @Column(nullable = false)
        @JsonProperty(required = false)
        val isOnDiscount : Boolean = false,

        @Column(nullable = false)
        @JsonProperty(required = false)
        val discountedPrice : Float = 0.0f
)
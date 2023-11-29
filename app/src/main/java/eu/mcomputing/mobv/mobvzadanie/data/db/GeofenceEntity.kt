package eu.mcomputing.mobv.mobvzadanie.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

// Credit to my professor (Maros Cavorsky) for letting us inspire from his code
@Entity(tableName = "geofence")
class GeofenceEntity(
    val lat: Double,
    val lon: Double,
    val radius: Double,
    @PrimaryKey val time: Long = System.currentTimeMillis(),
    var uploaded: Boolean = false
)
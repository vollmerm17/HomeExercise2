package at.fh.swengb.vollmer.homeexercise2

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Notes(@PrimaryKey var title:String, var content:String)
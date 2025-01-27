package com.example.homework.data.network

class Plane(
    val engine: PlaneEngine,
    val podyomnik: Int,
) {

}

class PlaneEngine(
    // dohera polei
    val dvs: DvsPlane
){

}

class DvsPlane(
    val cameraSgoraniya: CameraSgoraniya,
){

}

class CameraSgoraniya
package com.example.homework.di

import com.example.homework.data.network.CameraSgoraniya
import com.example.homework.data.network.DvsPlane
import com.example.homework.data.network.Plane
import com.example.homework.data.network.PlaneEngine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providePlane(
        engine: PlaneEngine,
        podyomnik: Int,
    ): Plane {
        return Plane(engine, podyomnik)
    }

    @Provides
    fun providePlaneEngine(dvsPlane: DvsPlane): PlaneEngine {
        return PlaneEngine(dvsPlane)
    }

    @Provides
    fun provideDvsPlane(cameraSgoraniya: CameraSgoraniya): DvsPlane {
        return DvsPlane(cameraSgoraniya)
    }

    @Provides
    fun provideCameraSgoraniya(): CameraSgoraniya {
        return CameraSgoraniya()
    }

    @Provides
    fun providePodyomnik(): Int {
        return 2
    }

}
package com.fghilmany.movielist.core.di

import com.fghilmany.movielist.BuildConfig
import com.fghilmany.movielist.core.data.MovieRepository
import com.fghilmany.movielist.core.data.ImplMovieRepository
import com.fghilmany.movielist.core.data.source.remote.RemoteDataSource
import com.fghilmany.movielist.core.data.source.remote.network.MovieService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        val interceptor = HttpLoggingInterceptor()
        interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor).build()

    }

    single {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        retrofit.create(MovieService::class.java)
    }

}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    factory<MovieRepository> { ImplMovieRepository(get()) }
}
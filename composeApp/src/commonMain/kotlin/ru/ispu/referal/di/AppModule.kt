package ru.ispu.referal.di

import org.koin.dsl.module
import ru.ispu.referal.data.DataSource
import ru.ispu.referal.data.repository.RepositoryImpl
import ru.ispu.referal.domain.reporitory.Repository

val appModule = module {
    single { DataSource() }
    factory<Repository> { RepositoryImpl(get()) }
}
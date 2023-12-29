package com.example.user

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UserModule {
    @Provides
    fun provideUserLocalRepository(
        userDao: UserDao
    ): IUserLocalRepository {
        return UserLocalRepository(userDao)
    }

    @Provides
    fun provideUserDao(@ApplicationContext context: Context): UserDao {
        return UserDatabase.getDatabase(context).userDao()
    }

    @Provides
    fun provideUserDb(@ApplicationContext context: Context): UserDatabase {
        return UserDatabase.getDatabase(context)
    }
}
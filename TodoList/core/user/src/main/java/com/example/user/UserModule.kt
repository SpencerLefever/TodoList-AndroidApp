package com.example.user

import android.content.Context
import androidx.room.Room
import com.example.common_libs.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

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
    fun provideUserDao(userDatabase: UserDatabase): UserDao {
        return userDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideUserDb(@ApplicationContext context: Context): UserDatabase {
        return UserDatabase.getDatabase(context)
    }
}
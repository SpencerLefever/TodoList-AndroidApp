package com.example.user

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.common_libs.Constants
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import java.security.SecureRandom

@Database(entities = [User::class], version = 1)
@TypeConverters(TaskConverter::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        fun getDatabase(context: Context): UserDatabase {
            val dbFile =
                context.applicationContext.getDatabasePath(Constants.DB_NAME)

            val random = SecureRandom.getInstanceStrong()
            val salt = ByteArray(16)
            random.nextBytes(salt)
            val dbKey = salt.toString()
            val key = SQLiteDatabase.getBytes(dbKey.toCharArray())
            val factory = SupportFactory(key)

            return Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                Constants.DB_NAME
            )
                .openHelperFactory(factory)
                .build()
        }
    }
}
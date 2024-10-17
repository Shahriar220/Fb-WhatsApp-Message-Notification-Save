package com.example.notificationcatcher

/**
 * @author Shahriar
 * @since 17/10/24 1:06 AM
 */
//@Module
//@InstallIn(SingletonComponent::class)
//object DatabaseModule {
//
//    @Provides
//    @Singleton
//    fun provideAppDatabase(@ApplicationContext context: Context): AppDataBase {
//        return Room.databaseBuilder(
//            context.applicationContext,
//            AppDataBase::class.java,
//            "message_database"
//        ).build()
//    }
//
//    @Provides
//    fun provideMessageDao(database: AppDataBase): MessageDao {
//        return database.messageDao()
//    }
//}
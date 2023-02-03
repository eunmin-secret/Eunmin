package dev.project.eunmin.core.common.di

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import com.google.firebase.ktx.initialize
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.project.eunmin.core.common.R
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object CommonModules {
    private const val EUNMIN_FIREBASE = "eunmin-firebase"

    @EunminFirebaseApp
    @Provides
    fun provideEunminFirebaseApp(
        @ApplicationContext context: Context
    ): FirebaseApp {
        val options = FirebaseOptions.Builder()
            .setProjectId(context.getString(R.string.eunmin_firebase_project_id))
            .setApplicationId(context.getString(R.string.eunmin_firebase_application_id))
            .setApiKey(context.getString(R.string.eunmin_firebase_api_key))
            .build()

        Firebase.initialize(context, options, EUNMIN_FIREBASE)
        return Firebase.app(EUNMIN_FIREBASE)
    }

    @Provides
    fun provideEunminFirebaseAuth(
        @EunminFirebaseApp app: FirebaseApp
    ): FirebaseAuth = Firebase.auth(app)
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class EunminFirebaseApp
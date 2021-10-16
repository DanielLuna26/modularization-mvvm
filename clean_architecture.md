# CLEAN ARCHITECTURE 2 WAYS

Lo que se ve en la siguiente imagen es la dependencia de las capas en clean architecture en Android lo suguiente es la resposabilidad de cada una y lo que debe contener.

![alt text](./clean_architecture.png "Clean architecture")

**Repository:** 
* Puente entre las capas de dominio y data.
* Conectar con los data source y retornar data mapeada.
* Siempre guarda data mapeada.

**Use case:**
* Responsable de conectarse con el repositorio y regresar la data necesaria. Deberia regresar Flow, emitiendo los cambios que esta sufriendo ese proceso.
* Aqui se tiene la logica de negocio.
* Es parte de domain.

**ViewModel:**
* Organiza la data y maneja los estados de la vista.
* Este solo debe conectarse con los casos de uso.
* No conoce nada acerca de la vista.

**View:**
* Actualiza la vista.
* Y observa los cambios del view model.

En una aplicación sencilla o en algún modulo la organización de las capas seria la siguiente:

* data
    - repositories
        * AuthRepository.kt
    - remote
        * responses
            * UserResponse.kt
        * services
            * AuthService.kt
    - local
        * entities
            * User.kt
        * migrations
            * Migration1_2.kt
        * daos
            * UserDao.kt
        * Converters.kt
        * Database.kt
* domain
    - interactors
        * GetSessionUseCase.kt
    - model
        * User.kt
    - repositories
        * AuthRepository.kt
* view
    - home
        * HomeFragment.kt
        * HomeViewModel.kt

En mi percepción como desarrollador de Android creo que es mejor tener el fragmento y el view model en el mismo nivel de carpeta.

# Inversión de dependencias con hilt

AppModule.kt
```kotlin
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    fun provideAuthService(retrofit: Retrofit) =
        retrofit.create(AuthService::class.java)
}
```
AuthModule.kt
```kotlin
@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {
    fun provideAuthRepository(authRepository: AuthRepositoryImpl) : AuthRepository
}
```


AuthRepository.kt
```kotlin
class AuthRepositoryImpl @Inject constructor(
    private val api: AuthService
) : AuthRepository
```

ViewModelsModule.kt
```kotlin
@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {
    fun provideGetSessionUseCase(getSessionUseCase: GetSessionUseCaseImpl) : GetSessionUseCase
}
```

HomeViewModel.kt
```kotlin
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSessionUseCase: GetSessionUseCase
) : ViewModel()
```

HomeFragment.kt
```kotlin
class HomeFragment : Fragment(R.layout.home_fragment) {
    private val viewModel: HomeViewModel by viewModels()
}
```
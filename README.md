# CLEAN ARCHITECTURE

La siguiente imagen muestra la dependendencia entre las capas de clean architecture, las capas o 
modulos que se manejan son: presentación (presentation), dominio (domain) y datos (data). En este 
caso en especial se usa un nuevo modulo que es "*common*", este contiene dependencias de las capas 
mencionadas y funcionalidades que son comunes en el proyecto.

![alt text](./clean_architecture.png "Clean architecture")

**Data**
* Proveer datos de manera remota o local.

**Repository:** 
* Puente entre las capas de dominio y data.
* Responsable de conectar con las fuentes de datos puede ser remota o local.
* Responsable de manejar el mapeo de data.
* Responsable de manejar los hilos.

**Use case (Interactors):**
* Responsable de conectar con el repositorio y regresar la data necesaria
* Regresar un flujo esto se refiere a la logica de negocio.
* Es parte de la capa de negocio.

**ViewModel:**
* Organiza la data y maneja los estados de la vista.
* Este solo debe conectarse con los casos de uso.
* No conoce nada acerca de la vista.
* También es resposanble de manejar hilos, pero este solo deberia manejar el viewModelScope.launch {} 
  que maneja por defecto el hilo principal.

**View:**
* Actualiza la vista.
* Responsable de manejar flow.
* Observar los cambios del view model.

En una aplicación sencilla o en algún modulo la organización de las capas seria la siguiente:

* data/
    - repositories/ (Este contiene la implementación del repositorio)
    - remote/
        * responses/
        * services/
    - local/
        * entities/
        * migrations/
        * daos/
        * Converters.kt
        * Database.kt
* domain/
    - interactors
    - model
    - repositories (Este pertenece a logica de negocio, que solo es la interface)
* view/
    - home/
        * HomeFragment.kt
        * HomeViewModel.kt

En mi percepción como desarrollador de Android creo que es mejor tener el fragmento y el view model en el mismo nivel de carpeta.

Lo siguiente, sería saber que pasa con **app**, este solo sería responsable de la inyección de dependencias y tener como dependencias todas las demas capas en caso de que estas sean divididas por modulo.

## Puntos importantes

DiffUtil: Esta utilidad sirve para mejorar el performance y animaciones de un RecyclerView.

Delegates: Estos sirven para obtener un valor, nos permiten hacer oneliners de algo en especifico.

SafeApiRequest: Clase para hacer peticiones seguras, estas nos permiten identificar si hay un error 
o fue satisfactoria la llamada.

Resource: Es una clase sellada que nos servirá para realizar un ViewStrategy esto se refiere en 
actualizar la vista segun el estado en el que se encuentre.

Navigation Extensions: clase para no recargar las vistas al dar clic a un elemento del bottom nav, 
esta nos ayuda a manejar el back stack.

Flow: el manejar flow nos ayuda a hacer una cominicación secuencial con nuestro view model.

Componentes Hilt: Estos nos ayudan para los ciclos de vida de nuestros objetos.

## Malas practicas

No se debe tener un base fragment o base activity. Una de las ventajas que nos da Kotlin es crear extensiones. Si queremos una funcionalidad en especifico de la actividad crearemos una extensión.
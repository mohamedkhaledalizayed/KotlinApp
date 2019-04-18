package com.smile.kotlinapp

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.smile.kotlinapp.databinding.ActivityMainBinding
import com.smile.kotlinapp.service.activity.UsersActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.name.text = "Mohamed Khalid"

//        binding.secondActivity.setOnClickListener {
//            var intent = Intent(this,SecondActivity::class.java)
//            intent.putExtra("name","mohamed khalid")
//            startActivity(intent)
//        }
//
//        binding.extension.setOnClickListener {
//            showToast("Mohamed Khalid")
//        }
//
//        binding.recycler.setOnClickListener {
//            var intent = Intent(this,RecyclerActivity::class.java)
//            startActivity(intent)
//        }
//
//        binding.pass.setOnClickListener {
//            var movie = Movie("movie", "title","poster")
//            var intent = Intent(this,SecondActivity::class.java)
//            intent.putExtra("movie",movie)
//            startActivity(intent)
//        }
//
//        binding.service.setOnClickListener {
//            var intent = Intent(this,UsersActivity::class.java)
//            startActivity(intent)
//        }
        //Rangs
        for(i in 1..5){
            println(i)
        }
    }

     fun checkAny(obj: Any){
        var res = when(obj){
            is Int -> "Int"
            is String -> "String"
            is Long -> "Long"
            is Double -> "Double"
            else -> "Unknown"
        }
        println(res)
    }

    fun list(){
        var items = listOf("Mohamed","khaled","ali","zayed","ahmed")

        items.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach{println(it)}
    }

    fun sum(a: Int, b: Int) = a + b

}

/*
* Extension Functions
* Default Parameters
* Ranges // DownTo // Step // RangeTo // Until
* If as Expression
* When as Expression
* Any
* Filter // Sort By // For Each
* Function as Expression
* Interoperability // Java with Kotlin // @file:JVMName("")
* Contains // === Operator
* Array -> Fixed length
* List // MutableListOf Not Fixed Length
* Fixed length -> arrayOf, listOf
* Set MutableSetOf Like list except it unique, value not changed, can not access by position
* 4 Functions Type (Named, Lambda, Extension, Infix)
* A data class must have a non empty primary constructor that has at least one property as an argument and should be var or val
* if we create two object from the same data class and compare between them they will be equal, and data class have copy keyword
* that can copy the object and change in the data by name or let it
* Infix Function is Extension Function in natural, Only one Parameter, All Infix Function is Extension
* Primary constructor we can use var, but not allow in secondary constructor, secondary constructor have a body unlike primary have init
* Classes in kotlin public and final in nature so you can not inherit from it without keyword open
* Override you should make fun or variable open to be able override it
* Abstract -> abstract functions should be exist in abstract class, abstract in open in nature so we can override functions
* and variables without open keyword, we can not create object from abstract class, abstract functions don't have body and
* should overriding unlike the normal functions have body and may override it or not as we like
* Interface ->all empty functions in interface are abstract in nature and open, we can't take object from it
* Singleton -> we can create singleton using the object keyword and the all methods and variables become static or react as
* a static, we can inherit in singleton, it doesn't have constructor and contain init block, and we can access it using
* the name of the object.method or variable, we can't create object from it
* Functions with unlimited parameters //vararg
* immutable collection implementations are always more memory-efficient
*
*
*
*
*
*
*
*
*
*
*
* modifiers
* tailrec
* lambda
* object
* operator ===
* enum
* singleton
* fragment,fragment dialog,navigation view
* val x: Int  get() = x + 1
* Enum ?
* Tuples / Pair<>
* Object // support inhertans // can not contain constructor // contain init block
* operator
* apply // with
* https://proandroiddev.com/kotlin-clean-architecture-1ad42fcd97fa
* https://proandroiddev.com/the-difference-between-kotlins-functions-let-apply-with-run-and-else-ca51a4c696b8
* https://www.google.com/search?q=kotlin+also+apply&oq=kotlin+also&aqs=chrome.2.69i57j0l5.11528j0j4&sourceid=chrome&ie=UTF-8
* https://github.com/android10/Android-CleanArchitecture
* https://www.google.com/search?q=android+clean+architecture+example&oq=clean+architecture&aqs=chrome.5.69i57j0l5.16406j0j7&sourceid=chrome&ie=UTF-8
* https://kotlinlang.org/docs/reference/delegation.html
* https://medium.com/@napperley/kotlin-tutorial-10-classes-736614de1d3f
* https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/
* https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html
* https://kotlinlang.org/docs/reference/collections.html
* https://www.google.com/search?q=kotlin+collections+tutorial&oq=kotlin+collections+tutorial&aqs=chrome..69i57j0l5.19240j0j7&sourceid=chrome&ie=UTF-8
* https://android.jlelse.eu/a-beginners-guide-to-setting-up-opencv-android-library-on-android-studio-19794e220f3c
* Clean Arc
* https://proandroiddev.com/kotlin-clean-architecture-1ad42fcd97fa
* https://proandroiddev.com/a-guided-tour-inside-a-clean-architecture-code-base-48bb5cc9fc97
* https://medium.com/@dmilicic/a-detailed-guide-on-developing-android-apps-using-the-clean-architecture-pattern-d38d71e94029
* https://github.com/android10/Android-CleanArchitecture
* https://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
* https://medium.com/search?q=Clean%20Architecture
* https://mindorks.com/android/store
* https://www.androidhive.info/android-databinding-in-recyclerview-profile-screen/
* https://blog.mindorks.com/understanding-higher-order-functions-and-lambdas-in-kotlin
* https://blog.mindorks.com/play-with-flexbox-layout-for-android
* https://medium.com/search?q=null%20saffty%20in%20kotlin
* https://blog.mindorks.com/applying-proguard-in-an-android-application
* https://blog.mindorks.com/what-is-android-jetpack-and-why-should-we-use-it
* https://www.andreasjakl.com/recyclerview-kotlin-style-click-listener-android/
* https://developer.android.com/topic/libraries/architecture/viewmodel#java
* https://stackoverflow.com/questions/53653157/manually-clearing-an-android-viewmodel
* https://android.jlelse.eu/dive-deep-into-androids-viewmodel-android-architecture-components-e0a7ded26f70
* https://codesbolt.com/free-download-taxi-booking-complete-solution-web-and-android-app/?fbclid=IwAR2tu2vD3XURNCTJArPOPFrlVH1955JxT6AkDA4n2ooCQkDii4j2OCkRFC8
*
*
*
*
*
*
*
* What is data binding
* how it is work
* benefits
* setup
* basic data binding example
* DataBinding in RecyclerView
* DataBinding with Fragment
* DataBinding in <include> layouts
* BindingAdapter
* Binding Click Listeners / Event Handling
* Updating UI using Observables
* Updating UI using ObservableFields
* Binding Java Functions (Imports)
* demo contain all explain
* Resources
*
* */
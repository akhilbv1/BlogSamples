package com.sample.blog

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class KotlinCollectionTools : AppCompatActivity() {
    val usersList:MutableList<User> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prepareData()
        kotlinFuntion()
    }

    private fun prepareData(){
        usersList.add(User("Chan",2))
        usersList.add(User("Asw",3))
        usersList.add(User("asd",1))
        usersList.add(User("asdf",5))
        usersList.add(User("asfdf",8))
        usersList.add(User("asdff",3))
        usersList.add(User("asdzxcx",9))

    }

   private fun kotlinFuntion() {
        val numbers = listOf(5, 5, 2,4,5,6)
        Log.i("Operations", "any:-" + numbers.any { it == 2 })
        Log.i("Operations", "all:-" + numbers.all { it > 0})
        Log.i("Operations", "count:-" + numbers.count { it >= 0})
        for(i in numbers)
        {
            Log.i("lists", "for_loop:- $i")
        }
        Log.i("list", "" +numbers.forEach{
            if(it>0)
            {
                Log.i("lists", "for_each:- $it")
            }
        })

        numbers.forEach {it*2}
       for(i in numbers.drop(2))
       {
           Log.i("filter", "drop:- $i")
       }


       for(i in numbers.dropWhile { it>3 })
       {
           Log.i("filter", "dropWhile:- $i")
       }




   }
}
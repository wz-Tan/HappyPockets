package com.example.happypockets

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

val supabaseUrl=BuildConfig.SupabaseURL
val supabaseKey=BuildConfig.SupabaseKey
val Supabase= createSupabaseClient(supabaseUrl, supabaseKey){
    install(Auth)
    install(Postgrest)
    install(Storage)
}
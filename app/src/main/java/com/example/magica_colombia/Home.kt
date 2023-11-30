package com.example.magica_colombia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class Home: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener { private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


    }
    fun enivarhistorias(){
        val intent: Intent = Intent( this,Historias::class.java)
        startActivity(intent)
    }

    private val viewListener = View.OnClickListener{
        when(it.id){
            R.id.depart->enivarhistorias()
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                return true
            }

            R.id.perfil -> {
                val intent = Intent(this, Perfil::class.java)
                startActivity(intent)
                return true  // <-- Mueve esta línea aquí para que solo retorne si el intent se ha iniciado correctamente
            }

            R.id.depart -> {
                val intent = Intent(this, DepaAmazonas::class.java)
                startActivity(intent)
                return true  // <-- Mueve esta línea aquí para que solo retorne si el intent se ha iniciado correctamente
            }
            R.id.Subir -> {
                val intent = Intent(this, SubirHistoria::class.java)
                startActivity(intent)
                return true  // <-- Mueve esta línea aquí para que solo retorne si el intent se ha iniciado correctamente
            }
            R.id.message -> {
                val intent = Intent(this, ReportarError::class.java)
                startActivity(intent)
                return true  // <-- Mueve esta línea aquí para que solo retorne si el intent se ha iniciado correctamente
            }
            R.id.historial -> {
                val intent = Intent(this, DetalleHistoriaActivity::class.java)
                startActivity(intent)
                return true  // <-- Mueve esta línea aquí para que solo retorne si el intent se ha iniciado correctamente
            }
            R.id.salir -> {
                FirebaseAuth.getInstance().signOut()

                // Regresar a MainActivity
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()  // Esto finaliza la actividad actual y evita que el usuario vuelva atrás
                return true
            }
            // Otras opciones del menú si las tienes
            else -> return super.onOptionsItemSelected(item)
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}



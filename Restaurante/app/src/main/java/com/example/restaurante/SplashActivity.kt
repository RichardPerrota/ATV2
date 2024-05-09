package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
//esse código configura a interface do usuário da atividade Splash para exibir o conteúdo definido no arquivo
//de layout activity_splash.xml.
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//esse código aguarda 2 segundos e, em seguida, inicia a atividade PedidoActivity,
//transferindo os dados da intenção atual para a nova atividade.
        Handler(Looper.getMainLooper()).postDelayed({
            val i = intent
            val j = Intent(this,PedidoActivity::class.java)
            j.putExtras(i)
            startActivity(j)
        },2000)

    }
}

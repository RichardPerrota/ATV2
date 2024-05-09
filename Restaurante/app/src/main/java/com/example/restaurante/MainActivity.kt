package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//inicializa a variável binding com o binding do layout activity_main.xml, permitindo que você acesse as visualizações e 
//interaja com elas programaticamente. 
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
//Esse código executa as etapas iniciais necessárias para configurar a atividade,
//como a inicialização do layout e a associação com a visualização correspondente
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//ele exibe uma saudação personalizada na tela e configura o botão para encerrar todas as atividades do aplicativo.
//Caso contrário, nada acontece.
        val username = intent.extras?.getString("username")

        if(!username.isNullOrEmpty()){
            binding.textOla.setText("Olá $username")
        }

        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }
//Esse código define um listener de clique para um botão. Quando o botão é clicado, ele cria uma intenção para iniciar 
//a SplashActivity, passando a quantidade de pizza inserida no campo de edição como um extra
        binding.buttonPedir.setOnClickListener {
            val i = Intent(this, SplashActivity::class.java)
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)
            finish()
        }

//esse código controla a quantidade de pizza selecionada com base na caixa de seleção.
        binding.checkPizza.setOnClickListener {
            if(binding.checkPizza.isChecked()){
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            }else{
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }
//Esse código controla a quantidade de salada selecionada com base na caixa de seleção.
        binding.checkSalada.setOnClickListener {
            if(binding.checkSalada.isChecked()){
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }
//Esse código controla a quantidade de hamburguer selecionada com base na caixa de seleção.
        binding.checkHamburger.setOnClickListener {
            if(binding.checkHamburger.isChecked()){
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}

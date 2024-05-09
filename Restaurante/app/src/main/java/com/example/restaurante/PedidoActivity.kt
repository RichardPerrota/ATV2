package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding
//esse código configura a interface do usuário da atividade Pedido com base no layout definido em ActivityPedidoBinding.
//Ele infla o layout, vincula os elementos da UI à variável binding e define o conteúdo da atividade para o layout inflado.
class PedidoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPedidoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//esse código está recuperando valores  de pizzas, saladas e hambúrgueres de uma intenção anterior 
//e armazenando esses valores como variáveis na atividade atual.
        val i = intent
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()
//esse código calcula os preços totais com base nas quantidades de pizza, salada e hambúrguer selecionadas e exibe
//essas informações em uma visualização na interface do usuário.
        val texto = "Resumo do Pedido\n" +
                "Pizza: $quantidadePizza Preço: ${quantidadePizza*8}\n" +
                "Salada: $quantidadeSalada Preço: ${quantidadeSalada*10}\n" +
                "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer*12}\n"

        binding.textResumo.text = texto

    }
}

package br.com.zup.recursoshumanos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.recursoshumanos.CAMPO_OBRIGATORIO
import br.com.zup.recursoshumanos.CHAVE_FUNCIONARIO
import br.com.zup.recursoshumanos.R
import br.com.zup.recursoshumanos.databinding.FragmentCadastroBinding
import br.com.zup.recursoshumanos.model.Funcionario

class CadastroFragment : Fragment() {
    private lateinit var binding: FragmentCadastroBinding
    private lateinit var nome: String
    private lateinit var horas: String
    private lateinit var valor: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBotaoCalcular.setOnClickListener {
            enviarDadosRecuperados()
        }
    }

    private fun enviarDadosRecuperados(){
        recuperarDadosDigitados()
        if(!verificarCampos()){
            val funcionario = Funcionario(nome, horas.toDouble(), valor.toDouble())
            irParaSalarioFragment(funcionario)
            limparCampos()
        }
    }

    private fun irParaSalarioFragment(funcionario: Funcionario){
        val bundle = bundleOf(CHAVE_FUNCIONARIO to funcionario)
        NavHostFragment.findNavController(this).navigate(R.id.action_cadastroFragment_to_salarioFragment, bundle)
    }

    private fun recuperarDadosDigitados() {
        this.nome = binding.etNomeSobrenome.text.toString()
        this.horas = binding.etHoras.text.toString()
        this.valor = binding.etValor.text.toString()
    }

    private fun verificarCampos(): Boolean{
        when{
            this.nome.isEmpty() -> {
                binding.etNomeSobrenome.error = CAMPO_OBRIGATORIO
                return true
            }
            this.horas.isEmpty() -> {
                binding.etHoras.error = CAMPO_OBRIGATORIO
                return true
            }
            this.valor.isEmpty() -> {
                binding.etValor.error = CAMPO_OBRIGATORIO
                return true
            }
        }
        return false
    }

    private fun limparCampos(){
        binding.etNomeSobrenome.text.clear()
        binding.etHoras.text.clear()
        binding.etValor.text.clear()
    }
}
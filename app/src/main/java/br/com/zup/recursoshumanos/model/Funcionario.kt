package br.com.zup.recursoshumanos.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

class Funcionario(private var nomeSobrenome: String,
                  private var horasTrabalhadas: Double,
                  private var valorPorHora: Double):
    Parcelable {

    private fun calcularSalario(): Double {

        return horasTrabalhadas * valorPorHora
    }

    fun getNome() = nomeSobrenome
    fun getHoras() = horasTrabalhadas
    fun getValor() = valorPorHora
    fun getSalario() = calcularSalario()
}